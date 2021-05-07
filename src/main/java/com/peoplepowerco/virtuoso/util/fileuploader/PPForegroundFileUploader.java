package com.peoplepowerco.virtuoso.util.fileuploader;

import static com.peoplepowerco.virtuoso.IPPVirtuosoTypes.REQ_DELETE_APP_FILE;
import static com.peoplepowerco.virtuoso.IPPVirtuosoTypes.REQ_POST_APP_UPLOAD_FILE_CONTENT;
import static com.peoplepowerco.virtuoso.IPPVirtuosoTypes.REQ_POST_UPLOAD_POST_FILE;
import static com.peoplepowerco.virtuoso.IPPVirtuosoTypes.REQ_PUT_UPLOAD_FILE_DONE;
import static com.peoplepowerco.virtuoso.IPPVirtuosoTypes.RES_SUCCESS;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.bean.FAPostUploadFile;
import com.peoplepowerco.virtuoso.models.PPDeviceUploadFileModel;
import com.peoplepowerco.virtuoso.network.PPCloudCallCommander;
import com.peoplepowerco.virtuoso.util.BitmapUtils;
import com.peoplepowerco.virtuoso.util.PPWeakHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PPForegroundFileUploader {

    private static final String TAG = PPForegroundFileUploader.class.getSimpleName();

    private PPDeviceUploadFileModel m_DeviceUploadFile;
    private FAPostUploadFile mPostUploadFile;
    private JSONObject mUploadAvatarJson;
    private String mAvatarFilePath;

    private final ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    private final Handler m_FileUploadHandler = new FileUploadHandler(this);
    private PPCloudCallCommander m_parserMainForUploadFile = new PPCloudCallCommander(m_FileUploadHandler);

    private IPPFileUploadResultListener m_ResultListener;

    public PPForegroundFileUploader(IPPFileUploadResultListener listener) {
        m_ResultListener = listener;
        mUploadAvatarJson = new JSONObject();
        mPostUploadFile = new FAPostUploadFile();
        m_DeviceUploadFile = new PPDeviceUploadFileModel();
    }

    public boolean requestUploadAvatarAssetFile(final String filePath, final String fileId, final int type) {
        mThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                mUploadAvatarJson.clear();
                mAvatarFilePath = filePath;
                mUploadAvatarJson.put("contentType", "image/jpeg");
                mUploadAvatarJson.put("fileId", fileId);
                mUploadAvatarJson.put("type", type);
                mUploadAvatarJson.put("name", "AVATAR");
                mUploadAvatarJson.put("publicAccess", "true");

                if (!TextUtils.isEmpty(fileId)) {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("TAG", TAG);
                    jsonObj.put("fileId", fileId);
                    jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
                    m_parserMainForUploadFile.DeleteDataThreadPool(REQ_DELETE_APP_FILE, jsonObj);
                } else {
                    byte[] datas = BitmapUtils.getImageBytes(filePath, 16, 8, 4);
                    m_parserMainForUploadFile.PostDataThreadPool(REQ_POST_APP_UPLOAD_FILE_CONTENT, mUploadAvatarJson
                        , new Object[]{m_DeviceUploadFile, datas});
                }
            }
        });
        return true;
    }

    public boolean requestUploadDeviceFile(final String filePath, final String fileId, final String fileName,
        final String locationId, final String deviceId, final int type) {
        mThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                byte[] datas = BitmapUtils.getImageBytes(filePath, 8, 4, 2);
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("contentType", "image/jpeg");
                jsonObj.put("fileId", fileId);
                jsonObj.put("locationId", locationId);
                if (null != deviceId) {
                    jsonObj.put("deviceId", deviceId);
                }
                jsonObj.put("type", type);
                jsonObj.put("name", fileName);
                jsonObj.put("publicAccess", "false");
                jsonObj.put("TAG", TAG);
                m_parserMainForUploadFile.PostDataThreadPool(REQ_POST_APP_UPLOAD_FILE_CONTENT, jsonObj, new Object[]{m_DeviceUploadFile, datas});
            }
        });
        return true;
    }

    public boolean requestUploadPostFile(final String filePath, final String postId, final int type,
        final String contentType, final String ext) {
        mThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                mPostUploadFile.filePath = filePath;
                mPostUploadFile.postId = postId;

                JSONObject jsonObj = new JSONObject();
                jsonObj.put("postId", postId);
                jsonObj.put("type", type);
                jsonObj.put("contentType", contentType);
                jsonObj.put("ext", ext);
                jsonObj.put("TAG", TAG);
                m_parserMainForUploadFile.PostDataThreadPool(REQ_POST_UPLOAD_POST_FILE, jsonObj, mPostUploadFile);
            }
        });
        return true;
    }

    public boolean requestMarkPostFileDone(final String postId, final String fileId, final boolean complete) {
        mThreadPool.submit(new Runnable() {
            @Override
            public void run() {
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("postId", postId);
                jsonObj.put("fileId", fileId);
                jsonObj.put("complete", complete);
                jsonObj.put("TAG", TAG);
                m_parserMainForUploadFile.PutDataThreadPool(REQ_PUT_UPLOAD_FILE_DONE, jsonObj);
            }
        });
        return true;
    }

    private void uploadFileToAmazonS3() {
        final File file = new File(mPostUploadFile.filePath);
        if (file.exists()) {
            mThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        upload(file);
                        Thread.sleep(1500);
                        requestMarkPostFileDone(mPostUploadFile.postId, mPostUploadFile.fileId, true);
                    } catch (IOException e) {
                        e.printStackTrace();
                        m_ResultListener.onFileUploadFailed();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void upload(File uploadFile) throws IOException {
        String fileName = uploadFile.getName();
        Set<String> keys = mPostUploadFile.uploadHeaders.keySet();
        URL url = new URL(mPostUploadFile.contentUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", fileName.endsWith(".jpg") ? "image/jpeg" : "video/mp4");
        connection.setRequestMethod("PUT");
        for (String key : keys) {
            connection.setRequestProperty(key, mPostUploadFile.uploadHeaders.get(key));
        }

        OutputStream output = connection.getOutputStream();
        FileInputStream input = null;
        if (fileName.endsWith(".jpg")) {
            byte[] datas = BitmapUtils.getImageBytes(uploadFile.getAbsolutePath(), 4, 2, 1, 1024);
            output.write(datas);
        } else {
            input = new FileInputStream(uploadFile);
            byte[] buffer = new byte[8192];
            int bytesRead = -1;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
        }

        output.flush();
        output.close();
        if (null != input) {
            input.close();
        }
        connection.connect();
        int resultCode = connection.getResponseCode();
        Log.d("Edward", "ResultCode: " + resultCode);
    }

    private class FileUploadHandler extends PPWeakHandler<PPForegroundFileUploader> {

        public FileUploadHandler(PPForegroundFileUploader owner) {
            super(owner);
        }

        @Override
        public void handleMessage(Message msg) {
            PPForegroundFileUploader wkRef = getTheOwner();
            if (msg.what == REQ_POST_APP_UPLOAD_FILE_CONTENT) {
                if (msg.arg1 == RES_SUCCESS) {
                    wkRef.m_ResultListener.onFileUploadSuccessed(wkRef.m_DeviceUploadFile.fileRef, -1);
                } else {
                    wkRef.m_ResultListener.onFileUploadFailed();
                }
            } else if (msg.what == REQ_DELETE_APP_FILE) {
                wkRef.mUploadAvatarJson.remove("fileId");
                byte[] datas = BitmapUtils.getImageBytes(wkRef.mAvatarFilePath, 16, 8, 4);
                wkRef.m_parserMainForUploadFile.PostDataThreadPool(REQ_POST_APP_UPLOAD_FILE_CONTENT, wkRef.mUploadAvatarJson
                    , new Object[]{wkRef.m_DeviceUploadFile, datas});
            } else if (msg.what == REQ_POST_UPLOAD_POST_FILE) {
                if (msg.arg1 == RES_SUCCESS) {
                    uploadFileToAmazonS3();
                } else {
                    wkRef.m_ResultListener.onFileUploadFailed();
                }
            } else if (msg.what == REQ_PUT_UPLOAD_FILE_DONE) {
                if (msg.arg1 == RES_SUCCESS) {
                    wkRef.m_ResultListener.onFileUploadSuccessed(-1, -1);
                } else {
                    wkRef.m_ResultListener.onFileUploadFailed();
                }
            }
        }
    }
}