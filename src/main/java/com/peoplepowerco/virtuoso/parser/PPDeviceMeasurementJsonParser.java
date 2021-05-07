package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceMeasurmentHistoryModel;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceParameterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 2017. 12. 13.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPDeviceMeasurementJsonParser implements PPBaseJsonParser {

    private List<PPDeviceMeasurmentHistoryModel> m_measurmentHistoryModelList;


    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaReading = null;
        JSONArray jaParams = null;
        JSONObject json = null;
        JSONObject jsonParam = null;
        try {
            m_measurmentHistoryModelList = (ArrayList<PPDeviceMeasurmentHistoryModel>) obj[0];
            if (m_measurmentHistoryModelList != null && m_measurmentHistoryModelList.size() > 0) {
                m_measurmentHistoryModelList.clear();
            }
            jaReading = (jso.containsKey("readings")) ? jso.getJSONArray("readings") : null;
            if (jaReading != null && jaReading.size() > 0) {
                int iArReadingCount = jaReading.size();
                for (int i = 0; i < iArReadingCount; i++) {
                    json = jaReading.getJSONObject(i);
                    PPDeviceMeasurmentHistoryModel historyModel = new PPDeviceMeasurmentHistoryModel();
                    historyModel.setsDeviceId((json.containsKey("deviceId")) ? json.getString("deviceId") : null);
                    historyModel.setsTimeStamp((json.containsKey("timeStamp")) ? json.getString("timeStamp") : null);
                    historyModel.setlTimeMs((json.containsKey("timeStampMs")) ? json.getLong("timeStampMs") : 0L);

                    jaParams = (json.containsKey("params")) ? json.getJSONArray("params") : null;
                    if (jaParams != null) {
                        int iParamCount = jaParams.size();
                        List<PPDeviceParameterModel> paramList = new ArrayList<PPDeviceParameterModel>();
                        for (int j = 0; j < iParamCount; j++) {
                            if (jaParams != null && jaParams.size() > 0) {
                                jsonParam = jaParams.getJSONObject(j);
                                PPDeviceParameterModel parameterModel = new PPDeviceParameterModel();
                                parameterModel.setName((jsonParam.containsKey("name")) ? jsonParam.getString("name") : null);
                                parameterModel.setValue((jsonParam.containsKey("value")) ? jsonParam.getString("value") : null);
                                paramList.add(parameterModel);
                                historyModel.setDeviceParameterModelList(paramList);
                            }

                        }
                        m_measurmentHistoryModelList.add(historyModel);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
