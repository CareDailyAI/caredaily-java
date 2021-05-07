/**
 * @FileName : PPDeviceFileInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceFileDetailsModel;
import com.peoplepowerco.virtuoso.models.PPDeviceFileInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.util.PPUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Bhargav Panchal
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Device File(s) json parser
 * @date : 2013. 05. 09.
 */
public class PPDeviceFileInfoJsonParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArray = null;
        JSONObject json = null;
        PPDeviceFileInfoModel deviceFileInfoModel = null;
        PPDeviceFileDetailsModel deviceFileDetailsModel = null;
        try {
            deviceFileInfoModel = (PPDeviceFileInfoModel) obj[0];
            deviceFileInfoModel.iCollectionTotalSize = (jso.containsKey("collectionTotalSize")) ? jso.getInteger("collectionTotalSize") : 0;
            deviceFileInfoModel.sTotalFilesSpace = (jso.containsKey("totalFilesSpace")) ? jso.getString("totalFilesSpace") : null;
            deviceFileInfoModel.sUsedFilesSpace = (jso.containsKey("usedFilesSpace")) ? jso.getString("usedFilesSpace") : null;
            deviceFileInfoModel.sTempKey = (jso.containsKey("tempKey")) ? jso.getString("tempKey") : null;
            deviceFileInfoModel.sTempKeyExpire = (jso.containsKey("tempKeyExpire")) ? jso.getString("tempKeyExpire") : null;
            jaArray = (jso.containsKey("files")) ? jso.getJSONArray("files") : null;
            if (jaArray != null && jaArray.size() > 0) {
                int arrayCount = jaArray.size();
                List<PPDeviceFileDetailsModel> deviceFileDetailsModels = null;
                if (deviceFileInfoModel.fileList != null && deviceFileInfoModel.fileList.size() > 0)
                    deviceFileDetailsModels = deviceFileInfoModel.fileList;
                else
                    deviceFileDetailsModels = new ArrayList<PPDeviceFileDetailsModel>();
                for (int i = 0; i < arrayCount; i++) {
                    deviceFileDetailsModel = new PPDeviceFileDetailsModel();
                    json = jaArray.getJSONObject(i);
                    deviceFileDetailsModel.sId = (json.containsKey("id")) ? json.getString("id") : null;
                    deviceFileDetailsModel.sType = (json.containsKey("type")) ? json.getString("type") : null;
                    deviceFileDetailsModel.sName = (json.containsKey("name")) ? json.getString("name") : null;
                    deviceFileDetailsModel.isThumbnail = (json.containsKey("thumbnail")) ? json.getBoolean("thumbnail") : false;
                    deviceFileDetailsModel.isViewed = (json.containsKey("viewed")) ? json.getBoolean("viewed") : false;
                    deviceFileDetailsModel.isFavourite = (json.containsKey("favourite")) ? json.getBoolean("favourite") : false;
                    deviceFileDetailsModel.isPublicAccess = (json.containsKey("publicAccess")) ? json.getBoolean("publicAccess") : false;
                    deviceFileDetailsModel.sCreationDate = (json.containsKey("creationDate")) ? json.getString("creationDate") : null;
                    deviceFileDetailsModel.creationTime = (json.containsKey("creationTime")) ? json.getLong("creationTime") : 0;
                    deviceFileDetailsModel.size = (json.containsKey("size")) ? json.getLongValue("size") : 0;
                    deviceFileDetailsModel.duration = (json.containsKey("duration")) ? json.getString("duration") : null;
                    deviceFileDetailsModel.shared = (json.containsKey("shared")) ? json.getInteger("shared") : 0;
                    deviceFileDetailsModel.isIncomplete = (json.containsKey("incomplete")) ? json.getBoolean("incomplete") : false;
                    deviceFileDetailsModel.rotate = (json.containsKey("rotate")) ? json.getInteger("rotate") : 0;
                    JSONObject joDeviceInfo = (json.containsKey("device")) ? json.getJSONObject("device") : null;
                    if (joDeviceInfo != null) {
                        List<PPDeviceInfoModel> deviceInfoModelsList = new ArrayList<PPDeviceInfoModel>();
                        PPDeviceInfoModel deviceInfoModel = new PPDeviceInfoModel();
                        deviceInfoModel.id = (joDeviceInfo.containsKey("id")) ? joDeviceInfo.getString("id") : PPUtil.NULL_STRING;
                        deviceInfoModel.type = (joDeviceInfo.containsKey("type")) ? joDeviceInfo.getInteger("type") : 0;
                        deviceInfoModel.desc = (joDeviceInfo.containsKey("desc")) ? joDeviceInfo.getString("desc") : null;
                        deviceInfoModelsList.add(deviceInfoModel);
                        deviceFileDetailsModel.deviceInfoList = deviceInfoModelsList;
                    }
                    JSONObject joUserInfo = (json.containsKey("user")) ? json.getJSONObject("user") : null;
                    if (joUserInfo != null) {
                        List<PPUserInfoModel> userInfoModelsList = new ArrayList<PPUserInfoModel>();
                        PPUserInfoModel userInfoModel = new PPUserInfoModel();
                        userInfoModel.sUserInfoId = (joUserInfo.containsKey("id")) ? joUserInfo.getString("id") : null;
                        userInfoModel.sUserFirstName = (joUserInfo.containsKey("firstName")) ? joUserInfo.getString("firstName") : null;
                        userInfoModel.sUserLastName = (joUserInfo.containsKey("lastName")) ? joUserInfo.getString("lastName") : null;
                        JSONObject jsonemail = (joUserInfo.containsKey("email")) ? joUserInfo.getJSONObject("email") : null;
                        if (jsonemail != null) {
                            userInfoModel.sUserEmail = (joUserInfo.containsKey("email")) ? joUserInfo.getString("email") : null;
                        }
                        userInfoModelsList.add(userInfoModel);
                        deviceFileDetailsModel.userInfoList = userInfoModelsList;
                    }
                    deviceFileDetailsModels.add(deviceFileDetailsModel);
                }
                Collections.reverse(deviceFileDetailsModels);
                deviceFileInfoModel.fileList = deviceFileDetailsModels;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
