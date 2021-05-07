package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.PPUserPropertyModel;
import java.util.ArrayList;

/**
 * @FileName :
 * @Project : ${project_name}
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserPropertyJsonParser implements PPBaseJsonParser {

    public ArrayList<PPUserPropertyModel> m_UserPropertyModelArrayList;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        JSONArray jaArrayProperty = null;
        JSONObject json = null;
        try {
            m_UserPropertyModelArrayList = (ArrayList<PPUserPropertyModel>) obj[0];
            m_UserPropertyModelArrayList.clear();
            jaArrayProperty = (jso.containsKey("properties")) ? jso.getJSONArray("properties") : null;

            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                int nArrayName = jaArrayProperty.size();
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    String name = json.getString("name");
                    String value = json.getString("value");
                    //A.1.a
                    if (null != name && name.equals(PPCommonInfo.EVENT_TRACK_USER_DATA_EXCEPTION)
                        && null != value && value.contains("true")) {
                        PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED, true);
                    }
                }
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    String name = json.getString("name");
                    String value = json.getString("value");

                    PPUserPropertyModel userPropertyMode = new PPUserPropertyModel();
                    userPropertyMode.sName = name;
                    userPropertyMode.sValue = value;
                    //A.2
                    if (null != name && name.equals(PPCommonInfo.EVENT_TRACK_BETA_DATA_EXCEPTION)
                        && null != value && value.contains("true")) {
                        PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED, false);
                        PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_BETA_DATA_EXCEPTION, true);
                    }
                    m_UserPropertyModelArrayList.add(userPropertyMode);
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
