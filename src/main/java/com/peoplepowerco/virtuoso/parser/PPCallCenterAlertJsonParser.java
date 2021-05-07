package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPCallCenterAlertsDeviceModel;
import com.peoplepowerco.virtuoso.models.PPCallCenterAlertsModel;

import java.util.ArrayList;

public class PPCallCenterAlertJsonParser implements PPBaseJsonParser {
    private ArrayList<PPCallCenterAlertsModel> m_callCenterAlertsModelList;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArray = null;
        JSONArray 		callCenterAlertsDevicesJsonArray = null;
        JSONObject 		json 	= null;
        PPCallCenterAlertsModel m_callCenterAlertsModel;
        try{

            m_callCenterAlertsModelList = (ArrayList<PPCallCenterAlertsModel>)obj[0];
            jaArray = (jso.containsKey("callCenterAlerts")) ? jso.getJSONArray("callCenterAlerts") : null;
            if(jaArray != null && jaArray.size() > 0){
                int arrayCount = jaArray.size();
                for(int i=0; i<arrayCount; i++){
                    json = jaArray.getJSONObject(i);
                    m_callCenterAlertsModel = new PPCallCenterAlertsModel();
                    m_callCenterAlertsModel.setAlertDate((json.containsKey("alertDate")) ? json.getString("alertDate") : null);
                    m_callCenterAlertsModel.setAlertDateMs((json.containsKey("alertDateMs")) ? json.getString("alertDateMs") : null);
                    m_callCenterAlertsModel.setAlertStatus((json.containsKey("alertStatus")) ? json.getInteger("alertStatus") : 0);
                    m_callCenterAlertsModel.setSignalType((json.containsKey("signalType")) ? json.getString("signalType") : null);
                    m_callCenterAlertsModel.setSignalMessage((json.containsKey("signalMessage")) ? json.getString("signalMessage") : null);

                    if(json.containsKey("device")) {
                        JSONObject jsonObjDevice = json.getJSONObject("amount");
                        ArrayList<PPCallCenterAlertsDeviceModel> callCenterAlertsDeviceModelArrayList = new ArrayList<PPCallCenterAlertsDeviceModel>();
                        PPCallCenterAlertsDeviceModel callCenterAlertsDeviceModel = new PPCallCenterAlertsDeviceModel();
                        callCenterAlertsDeviceModel.setId((jsonObjDevice.containsKey("id")) ? jsonObjDevice.getString("id") : null);
                        callCenterAlertsDeviceModel.setType((jsonObjDevice.containsKey("type")) ? jsonObjDevice.getInteger("type") : 0);
                        callCenterAlertsDeviceModel.setGoalId((jsonObjDevice.containsKey("goalId")) ? jsonObjDevice.getInteger("goalId") : 0);
                        callCenterAlertsDeviceModel.setCategoryType((jsonObjDevice.containsKey("typeCategory")) ? jsonObjDevice.getInteger("typeCategory") : 0);
                        callCenterAlertsDeviceModel.setDesc((jsonObjDevice.containsKey("desc")) ? jsonObjDevice.getString("desc") : null);
                        callCenterAlertsDeviceModelArrayList.add(callCenterAlertsDeviceModel);
                        m_callCenterAlertsModel.setCallCenterAlertsDeviceModelsArrayList(callCenterAlertsDeviceModelArrayList);
                    }
                    m_callCenterAlertsModelList.add(m_callCenterAlertsModel);
                }
            }
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
