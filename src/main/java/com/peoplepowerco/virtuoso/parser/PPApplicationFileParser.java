package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceFileDetailsModel;
import com.peoplepowerco.virtuoso.models.PPDeviceFileInfoModel;

public class PPApplicationFileParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPDeviceFileInfoModel fileModel = (PPDeviceFileInfoModel) obj[0];
        fileModel.fileList.clear();

        fileModel.sTempKey = jso.getString("tempKey");
        fileModel.sTempKeyExpire = jso.getString("tempKeyExpire");
        JSONArray array = jso.getJSONArray("files");
        if (null != array && !array.isEmpty()) {
            for (int i = 0; i != array.size(); ++i) {
                JSONObject fileObj = array.getJSONObject(i);
                PPDeviceFileDetailsModel detailModel = new PPDeviceFileDetailsModel();
                detailModel.sId = fileObj.getString("id");
                detailModel.sType = fileObj.getString("type");
                detailModel.sName = fileObj.getString("name");
                detailModel.size = fileObj.getLongValue("size");
                detailModel.deviceId = fileObj.getString("deviceId");
                detailModel.locationId = fileObj.getString("locationId");
                detailModel.userId = fileObj.getString("userId");
                detailModel.isPublicAccess = fileObj.getString("publicAccess").equals("1");
                fileModel.fileList.add(detailModel);
            }
        }
        return true;
    }
}
