package com.peoplepowerco.virtuoso.util.fileuploader;

/**
 * Created by edwardliu on 2018/4/27.
 */

public interface IPPFileUploadResultListener {

    public void onFileUploadFailed();

    public void onFileUploadSuccessed(int fileRefId, int fileType);
}