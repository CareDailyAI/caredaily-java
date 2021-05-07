package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.managers.PPUserManager;

public class PPUserLocationEventJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        try {
            //Locations
            String locationId = PPAppCenter.m_SharedPresence.getLocationId();
            if (null != locationId) {
                JSONArray jsonArrayLocation = jso.getJSONArray("locations");
                if (null != jsonArrayLocation && !jsonArrayLocation.isEmpty()) {
                    for (int i = 0; i < jsonArrayLocation.size(); i++) {
                        JSONObject jsonObjLocation = jsonArrayLocation.getJSONObject(i);
                        String id = jsonObjLocation.getString("id");
                        if (locationId.equals(id)) {
                            PPUserManager.getInstance().setCurrentLocation(jsonObjLocation.getString("event"));
                            break;
                        }

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
