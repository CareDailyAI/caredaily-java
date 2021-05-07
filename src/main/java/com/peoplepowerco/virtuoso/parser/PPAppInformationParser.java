package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppAccessesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppDeviceTypesModel;

import java.util.ArrayList;


public class PPAppInformationParser implements PPBaseJsonParser {

    public static final String TAG = "PPAppInformationParser";
    public ArrayList<PPAppAccessesModel> m_accessArrayList;
    public ArrayList<PPAppDeviceTypesModel> m_deviceTypesArrayList;

    @Override
    public boolean setData(JSONObject jsonObject, Object[] obj) {
        try {
            JSONObject jso = jsonObject.getJSONObject("app");
            if (null == jso) {
                return false;
            }
            m_accessArrayList = (ArrayList<PPAppAccessesModel>) obj[0];
            if (m_accessArrayList != null) {
                m_accessArrayList.clear();
            }
            m_deviceTypesArrayList = (ArrayList<PPAppDeviceTypesModel>) obj[1];
            if (m_deviceTypesArrayList != null) {
                m_deviceTypesArrayList.clear();
            }

            if (jso.containsKey("deviceTypes")) {
                JSONArray typesArray = jso.getJSONArray("deviceTypes");
                if (null != typesArray) {
                    for (int i = 0; i != typesArray.size(); ++i) {
                        JSONObject json = typesArray.getJSONObject(i);
                        PPAppDeviceTypesModel typeModel = new PPAppDeviceTypesModel();
                        typeModel.id = json.getInteger("id");
                        typeModel.trigger = json.getBoolean("trigger");
                        typeModel.read = json.getBoolean("read");
                        typeModel.control = json.getBoolean("control");
                        typeModel.minOccurrence = json.getInteger("minOccurrence");
                        JSONObject reasonObj = json.getJSONObject("reason");
                        if (null != reasonObj && reasonObj.containsKey("en")) {
                            typeModel.reason = reasonObj.getString("en");
                        }
                        typeModel.requiredParamValues = json.containsKey("requiredParamValues") ? json.getString("requiredParamValues") : "";
                        typeModel.triggerParamName = json.containsKey("triggerParamName") ? json.getString("triggerParamName") : "";
                        typeModel.triggerParamValues = json.containsKey("triggerParamValues") ? json.getString("triggerParamValues") : "";
                        m_deviceTypesArrayList.add(typeModel);
                    }
                }
            }

            if (jso.containsKey("access")) {
                JSONArray accessArray = jso.getJSONArray("access");
                if (null != accessArray) {
                    for (int i = 0; i != accessArray.size(); ++i) {
                        JSONObject json = accessArray.getJSONObject(i);
                        PPAppAccessesModel accessModel = new PPAppAccessesModel();
                        accessModel.category = json.getInteger("category");
                        accessModel.trigger = json.getBoolean("trigger");
                        accessModel.read = json.getBoolean("read");
                        accessModel.control = json.getBoolean("control");
                        JSONObject reasonObj = json.getJSONObject("reason");
                        if (null != reasonObj && reasonObj.containsKey("en")) {
                            accessModel.reason = reasonObj.getString("en");
                        }
                        accessModel.excluded = json.getBoolean("excluded");
                        m_accessArrayList.add(accessModel);
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
