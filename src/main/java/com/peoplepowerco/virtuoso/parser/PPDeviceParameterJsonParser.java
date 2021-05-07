/**
 * @FileName : PPDeviceParameterJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.managers.PPDeviceManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterModel;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Device parameter json parser
 * @date : Jun 2, 2014
 */
public class PPDeviceParameterJsonParser implements PPBaseJsonParser {

    private static String TAG = "PPDeviceParameterJsonParser";
    public ArrayList<PPDeviceParameterModel> m_DeviceParameterList;

    @SuppressWarnings("unchecked")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        JSONArray jaArrayParam = null;
        JSONArray jaArray = null;
        JSONObject json = null;
        PPDeviceParameterModel m_deviceParameterModel = null;
        ArrayList<PPDeviceParameterInfoModel> m_deviceParameterInfoModel = null;
        PPDeviceParameterInfoModel m_deviceParameterInfoModelfactor = null;
        PPDeviceInfoModel device = null;

        PPSharedPreferences m_Prefs = PPVirtuoso.getInstance().getPrefs();

        try {
            m_DeviceParameterList = (ArrayList<PPDeviceParameterModel>) obj[0];
            boolean bIndex = false;
            if (obj.length > 1) {
                bIndex = obj[1] == null ? false : (boolean) obj[1];
            }
            //clear the previous results...
            m_DeviceParameterList.clear();
            jaArray = (jso.containsKey("devices")) ? jso.getJSONArray("devices") : null;
            if (jaArray != null && jaArray.size() > 0) {
                int arrayCount = jaArray.size();
                for (int i = 0; i < arrayCount; i++) {
                    json = jaArray.getJSONObject(i);
                    m_deviceParameterModel = new PPDeviceParameterModel();
                    m_deviceParameterModel.setDeviceId((json.containsKey("id")) ? json.getString("id") : null);
                    m_deviceParameterModel.setLastReceivedDate((json.containsKey("lastDataReceivedDate")) ? json.getString("lastDataReceivedDate") : null);
                    m_deviceParameterModel.setMeasureDate((json.containsKey("lastMeasureDate")) ? json.getString("lastMeasureDate") : null);

//					PPVirtuosoLogTrace.d(TAG, "DeviceId =" + m_deviceParameterModel.getDeviceId());
//					PPVirtuosoLogTrace.d(TAG, "LastReceivedDate =" + m_deviceParameterModel.getLastReceivedDate());
//					PPVirtuosoLogTrace.d(TAG, "MeasureDate =" + m_deviceParameterModel.getMeasureDate());

                    //LLM NOW FIND THE DEVICE
                    //When camera restart from background, device is null,so cannot get parameter value.
                    if (!PPDeviceManager.getInstance().getDeviceInfoArrayList().isEmpty()) {
                        device = PPDeviceManager.getInstance().getDeviceInfoByID(m_deviceParameterModel.getDeviceId());
                        if (device == null) {
                            continue;
                        }
                        if (device.getDeviceParameters() != null) {
                            device.getDeviceParameters().clear();
                        }
                    }

                    jaArrayParam = json.getJSONArray("parameters");
                    if (jaArrayParam != null && jaArrayParam.size() > 0) {
                        int arrayParamCount = jaArrayParam.size();
                        LinkedHashMap<String, PPDeviceParameterInfoModel> params = new LinkedHashMap<>();
                        m_deviceParameterInfoModel = new ArrayList<>();
                        for (int j = 0; j < arrayParamCount; j++) {
                            json = jaArrayParam.getJSONObject(j);
                            m_deviceParameterInfoModelfactor = new PPDeviceParameterInfoModel();
                            if (bIndex) {
                                boolean indexParam = json.containsKey("index") ? true : false;
                                if (indexParam) {
                                    String name = json.containsKey("name") ? json.getString("name") : null;
                                    String index = " " + json.getString("index");
                                    m_deviceParameterInfoModelfactor.setName(name + index);
                                } else {
                                    m_deviceParameterInfoModelfactor.setName((json.containsKey("name")) ? json.getString("name") : null);
                                }
                            } else {
                                m_deviceParameterInfoModelfactor.setName((json.containsKey("name")) ? json.getString("name") : null);
                            }
                            m_deviceParameterInfoModelfactor.setIndex((json.containsKey("index")) ? json.getString("index") : null);
                            m_deviceParameterInfoModelfactor.setValue((json.containsKey("value")) ? json.getString("value") : null);
                            m_deviceParameterInfoModelfactor.setLastUpdatedTime((json.containsKey("lastUpdateTime")) ? json.getString("lastUpdateTime") : null);
                            m_deviceParameterInfoModelfactor.setLastUpdatedTimeMS((json.containsKey("lastUpdateTimeMs")) ? json.getLong("lastUpdateTimeMs") : 0);
                            if (m_deviceParameterInfoModelfactor.getName().equals("outletStatus")) {
                                m_Prefs.setDeviceStatusUpdatedTime("outletStatus", m_deviceParameterInfoModelfactor.getLastUpdatedTime());
                            }
                            if (m_deviceParameterInfoModelfactor.getName().equals("motionStatus")) {
                                m_Prefs.setDeviceStatusUpdatedTime("motionStatus", m_deviceParameterInfoModelfactor.getLastUpdatedTime());
                                PPVirtuosoLogTrace.d(TAG, "Motion status LastUpdatedTime ========================================" + m_deviceParameterInfoModelfactor.getLastUpdatedTime());
                            }


                            if (params.containsKey(m_deviceParameterInfoModelfactor.getName())) {
                                PPDeviceParameterInfoModel storedInfoModel = params.get(m_deviceParameterInfoModelfactor.getName());
                                if (storedInfoModel.getLastUpdatedTime().compareTo(m_deviceParameterInfoModelfactor.getLastUpdatedTime()) < 0) {
                                    params.put(m_deviceParameterInfoModelfactor.getName(), m_deviceParameterInfoModelfactor);
                                }
                            } else {
                                params.put(m_deviceParameterInfoModelfactor.getName(), m_deviceParameterInfoModelfactor);
                            }

//							PPVirtuosoLogTrace.d(TAG, "Name =" + m_deviceParameterInfoModelfactor.getName());
//							PPVirtuosoLogTrace.d(TAG, "Value =" + m_deviceParameterInfoModelfactor.getValue());
//							PPVirtuosoLogTrace.d(TAG, "LastUpdatedTime =" + m_deviceParameterInfoModelfactor.getLastUpdatedTime());
                            if (device != null) {
                                device.addDeviceParameter(m_deviceParameterInfoModelfactor);
                            }
                        }
                        for (String key : params.keySet()) {
                            m_deviceParameterInfoModel.add(params.get(key));
                        }
                        //These are needed for device parameter manager
                        m_deviceParameterModel.setDeviceParametersInfoModel(m_deviceParameterInfoModel);
                        m_DeviceParameterList.add(m_deviceParameterModel);
                    }
                }

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
