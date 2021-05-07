package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPSMSSubscriberModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by edwardliu on 2017/7/14.
 */

public class PPSMSSubscriberJsonParser implements PPBaseJsonParser {

    private ArrayList<PPSMSSubscriberModel> m_smsSubscriberArrayList;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArrayProperty = null;
        JSONObject json = null;
        try {
            m_smsSubscriberArrayList = (ArrayList<PPSMSSubscriberModel>) obj[0];
            m_smsSubscriberArrayList.clear();
            jaArrayProperty = (jso.containsKey("subscribers")) ? jso.getJSONArray("subscribers") : null;

            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                int nArrayName = jaArrayProperty.size();
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    Object phoneObj = json;
                    PPSMSSubscriberModel contactModel = new PPSMSSubscriberModel();
                    contactModel.firstName = (json.containsKey("firstName")) ? json.getString("firstName") : null;
                    contactModel.lastName = (json.containsKey("lastName")) ? json.getString("lastName") : null;
                    if (phoneObj instanceof Integer) {
                        int iPhone = (json.containsKey("phone")) ? json.getInteger("phone") : 0;
                        contactModel.phone = Integer.toString(iPhone);
                    } else {
                        contactModel.phone = (json.containsKey("phone")) ? json.getString("phone") : null;
                    }
                    contactModel.initials = (json.containsKey("initials")) ? json.getString("initials") : null;
                    JSONArray array = json.getJSONArray("categories");
                    if (null != array) {
                        contactModel.categories = new ArrayList<>();
                        for (int j = 0; j != array.size(); ++j) {
                            int category = array.getIntValue(j);
                            contactModel.categories.add(category);
                        }
                    }
                    contactModel.status = Integer.valueOf(json.getString("status"));
                    m_smsSubscriberArrayList.add(contactModel);
                }
            }
            if (m_smsSubscriberArrayList.size() > 1) {
                Collections.sort(m_smsSubscriberArrayList, new Comparator<PPSMSSubscriberModel>() {
                    @Override
                    public int compare(PPSMSSubscriberModel o1, PPSMSSubscriberModel o2) {
                        return o1.phone.compareTo(o2.phone);
                    }
                });
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
