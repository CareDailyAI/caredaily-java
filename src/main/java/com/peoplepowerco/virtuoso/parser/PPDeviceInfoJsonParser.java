/**
 * @FileName : PPDeviceInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;


import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.util.PPDeviceBundleUtil;
import com.peoplepowerco.virtuoso.util.PPDeviceNewBundleUtil;
import java.util.List;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Device information
 * @date : 2013. 10. 30.
 */
public class PPDeviceInfoJsonParser implements PPBaseJsonParser, IPPDeviceParameters {

    List<PPDeviceInfoModel> mDeviceList;

    @SuppressWarnings("unchecked")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        mDeviceList = (List<PPDeviceInfoModel>) obj[0];
        if (mDeviceList != null) {
            mDeviceList.clear();
        }
        List<PPDeviceInfoModel> newDevices = null;
        if (obj.length > 1) {
            newDevices = (List<PPDeviceInfoModel>) obj[1];
        }

        if (jso.containsKey("devices")) {
            JSONArray devicesArray = jso.getJSONArray("devices");
            String jsonString = devicesArray.toString();
            try {
                List<PPDeviceInfoModel> devices = JSON.parseArray(jsonString, PPDeviceInfoModel.class);
                mDeviceList.addAll(devices);
                if (null != newDevices) {
                    checkNewDevices(newDevices, PPAppCenter.m_SharedPresence.getKeyStringValue(PPCommonInfo.REFERENCE_KEY_DEVICE_LIST));
                }

                PPAppCenter.m_SharedPresence.setKeyStringValue(PPCommonInfo.REFERENCE_KEY_DEVICE_LIST, jsonString);
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError ex) {
                Runtime.getRuntime().gc();
            }
        }
        if (PPAppCenter.BUNDLE_VERSION == 1) {
            PPDeviceBundleUtil.checkDeviceBundleStoryInfo(mDeviceList);
        } else {
            PPDeviceNewBundleUtil.checkDeviceBundleStoryInfo(mDeviceList);
        }
        return true;
    }

    private void checkNewDevices(List<PPDeviceInfoModel> newDevices, String oldDeviceListJson) {
        if (!TextUtils.isEmpty(oldDeviceListJson)) {
            List<PPDeviceInfoModel> oldDeviceList = JSON.parseArray(oldDeviceListJson, PPDeviceInfoModel.class);
            if (null != oldDeviceList && oldDeviceList.size() < mDeviceList.size()) {
                for (PPDeviceInfoModel device : mDeviceList) {
                    boolean findDevice = false;
                    for (PPDeviceInfoModel oldDevice : oldDeviceList) {
                        if (oldDevice.id.equals(device.id)) {
                            findDevice = true;
                            break;
                        }
                    }
                    if (!findDevice) {
                        newDevices.add(device);
                    }
                }
            }
        } else {
            newDevices.addAll(mDeviceList);
        }
    }
}
