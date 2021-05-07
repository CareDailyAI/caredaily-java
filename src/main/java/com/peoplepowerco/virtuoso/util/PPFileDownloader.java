package com.peoplepowerco.virtuoso.util;

import android.content.Context;
import android.text.TextUtils;
import com.peoplepowerco.virtuoso.network.PPHttpTransfer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PPFileDownloader {

    private int mErrorTimes = 0;
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static final int MAX_ERROR_TIMES = 5;
    private static final int DIVIDER_DELTA = 6;
    private static PPFileDownloader sInstance;

    public static interface OnDownloadListener {

        public void onDownloadFinished(String filePath);
    }

    public static interface OnMultiDownloadListener {

        public void onDownloadSuccess();
    }

    private PPFileDownloader() {
    }

    public static PPFileDownloader getInstance() {
        if (null == sInstance) {
            sInstance = new PPFileDownloader();
        }
        return sInstance;
    }

    private int finishedCount = 0;
    private int divideCount = 0;
    private OnMultiDownloadListener listener;

    public void setMultiDownloadListener(OnMultiDownloadListener listener) {
        this.listener = listener;
    }

    public void startDownloadVideos(final Context context, final List<String> videos) {
        if (null == videos || videos.isEmpty()) {
            listener.onDownloadSuccess();
            return;
        }

        int startIndex = 0;
        int videoSize = videos.size();
        divideCount = (videoSize / DIVIDER_DELTA) + 1;
        for (int i = 0; i != divideCount; ++i) {
            cachedThreadPool.execute(new SubQueue(context, videos, startIndex));
            startIndex += DIVIDER_DELTA;
        }
    }

    private class SubQueue implements Runnable {

        private Context context;
        private LinkedList<String> queue;

        public SubQueue(Context context, List<String> videos, int startIndex) {
            this.context = context;
            this.queue = new LinkedList<>();
            int endIndex = startIndex + DIVIDER_DELTA;
            if (endIndex > videos.size()) {
                endIndex = videos.size();
            }
            queue.addAll(videos.subList(startIndex, endIndex));
        }

        @Override
        public void run() {
            while (!queue.isEmpty()) {
                String videoUrl = queue.getFirst();
                final String fileName = videoUrl.substring(videoUrl.lastIndexOf('/') + 1);
                final File file = new File(context.getExternalFilesDir(null), fileName);
                if (file.exists()) {
                    queue.removeFirst();
                } else if (!downloadFile(videoUrl, file)) {
                    ++mErrorTimes;
                    if (mErrorTimes > MAX_ERROR_TIMES) {
                        break;
                    }
                    queue.addLast(queue.removeFirst());
                }
            }
            ++finishedCount;
            if (finishedCount == divideCount) {
                listener.onDownloadSuccess();
            }
        }
    }

    public void startDownload(final Context context, final String url, final OnDownloadListener listener) {
        if (TextUtils.isEmpty(url)) {
            listener.onDownloadFinished(null);
            return;
        }
        String fileName = url.substring(url.lastIndexOf('/') + 1);
        File file = new File(context.getExternalFilesDir(null), fileName);
        listener.onDownloadFinished(file.exists() ? file.getAbsolutePath() : null);
    }

    private boolean downloadFile(String downloadUrl, File outputFile) {
        try {
            URL url = new URL(downloadUrl);
            HttpURLConnection con = null;
            if (url.getProtocol().toLowerCase().equals("https")) {
                con = PPHttpTransfer.getHttpURLConnection(url);
            } else {
                con = (HttpURLConnection) url.openConnection();
            }
            con.setReadTimeout(5000);
            con.setConnectTimeout(5000);
            con.setRequestProperty("Charset", "UTF-8");
            con.setRequestMethod("GET");
            if (con.getResponseCode() == 200) {
                InputStream is = con.getInputStream();
                FileOutputStream fileOutputStream = null;
                if (is != null) {
                    fileOutputStream = new FileOutputStream(outputFile);
                    byte[] buf = new byte[1024];
                    int ch;
                    while ((ch = is.read(buf)) != -1) {
                        fileOutputStream.write(buf, 0, ch);
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            } else {
                int responseCode = con.getResponseCode();
                if (responseCode > 300 && responseCode < 400) {
                    String redirectHeader = con.getHeaderField("Location");
                    return downloadFile(redirectHeader, outputFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
