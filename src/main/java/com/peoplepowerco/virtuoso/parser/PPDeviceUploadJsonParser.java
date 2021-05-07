/**
 * @FileName : PPDeviceUploadJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceUploadFileModel;


/**
 * @brief : Upload device file json parser
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceUploadJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
            PPDeviceUploadFileModel deviceUploadFileModel = (PPDeviceUploadFileModel) obj[0];

            deviceUploadFileModel.sStatus = (jso.containsKey("status")) ? jso.getString("status") : null;
            deviceUploadFileModel.resultCode = (jso.containsKey("resultCode")) ? jso.getInteger("resultCode") : 0;
            deviceUploadFileModel.fileRef = (jso.containsKey("fileRef")) ? jso.getInteger("fileRef") : 0;
            if (0 == deviceUploadFileModel.fileRef) {
                deviceUploadFileModel.fileRef = (jso.containsKey("fileId")) ? jso.getInteger("fileId") : 0;
            }
            deviceUploadFileModel.fileAction = (jso.containsKey("filesAction")) ? jso.getInteger("filesAction") : 0;
            deviceUploadFileModel.thumbnail = (jso.containsKey("thumbnail")) ? jso.getBoolean("thumbnail") : false;
            deviceUploadFileModel.totalFilesSpace = (jso.containsKey("totalFilesSpace")) ? jso.getInteger("totalFilesSpace") : 0;
            deviceUploadFileModel.usedFilesSpace = (jso.containsKey("usedFilesSpace")) ? jso.getInteger("usedFilesSpace") : 0;
            deviceUploadFileModel.fragments = (jso.containsKey("fragments")) ? jso.getInteger("fragments") : 0;
            deviceUploadFileModel.twitterShare = (jso.containsKey("twitterShare")) ? jso.getBoolean("twitterShare") : false;

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }

}
