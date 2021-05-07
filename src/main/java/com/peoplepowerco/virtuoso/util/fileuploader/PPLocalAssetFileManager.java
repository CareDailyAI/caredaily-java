package com.peoplepowerco.virtuoso.util.fileuploader;

/**
 * Created by edwardliu on 2018/4/27.
 */

public class PPLocalAssetFileManager {

    private PPForegroundFileUploader m_FgFileUploader;

    public static final int PPApplicationFileFileTypeUserImage = 1;
    public static final int PPApplicationFileFileTypeLocationImage = 2;
    public static final int PPApplicationFileFileTypeDeviceImage = 3;
    public static final int PPApplicationFileFileTypeBitmapMask = 4;
    public static final int PPApplicationFileFileTypeAny = 5;

    public PPLocalAssetFileManager(IPPFileUploadResultListener listener) {
        m_FgFileUploader = new PPForegroundFileUploader(listener);
    }

    public boolean startUploadAvatarFile(String filePath, String fileId, int type) {
        return m_FgFileUploader.requestUploadAvatarAssetFile(filePath, fileId, type);
    }

    public boolean requestUploadPostFile(String filePath, String postId, int type, String contentType, String ext) {
        return m_FgFileUploader.requestUploadPostFile(filePath, postId, type, contentType, ext);
    }

    public boolean startUploadFile(String filePath, String fileId, String fileName, String locationId, String deviceId, int type) {
        return m_FgFileUploader.requestUploadDeviceFile(filePath, fileId, fileName, locationId, deviceId, type);
    }
}