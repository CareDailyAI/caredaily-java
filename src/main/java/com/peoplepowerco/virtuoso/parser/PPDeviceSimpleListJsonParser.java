/**
 * @FileName : PPDeviceInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.util.PPDeviceBundleUtil;
import com.peoplepowerco.virtuoso.util.PPDeviceNewBundleUtil;
import java.util.ArrayList;
import java.util.List;

public class PPDeviceSimpleListJsonParser implements PPBaseJsonParser {

    @SuppressWarnings("unchecked")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
            List<PPDeviceInfoModel> devices = new ArrayList<>();
            if (jso.containsKey("devices")) {
                JSONArray devicesArray = jso.getJSONArray("devices");
                String jsonString = devicesArray.toString();
                devices.addAll(JSON.parseArray(jsonString, PPDeviceInfoModel.class));
                PPAppCenter.m_SharedPresence.setKeyStringValue(PPCommonInfo.REFERENCE_KEY_DEVICE_LIST, jsonString);
            }
            if (PPAppCenter.BUNDLE_VERSION == 1) {
                PPDeviceBundleUtil.checkDeviceBundleStoryInfo(devices);
            } else {
                PPDeviceNewBundleUtil.checkDeviceBundleStoryInfo(devices);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return true;
    }
}
