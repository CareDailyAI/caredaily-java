/**
 * @FileName : PPLoginJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.models.PPUserModel;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Login json parser
 * @date : 2014. 8. 20.
 */
public class PPLoginJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        try {
            PPUserModel userModel = (PPUserModel) obj[0];
            PPSharedPreferences m_Prefs = PPVirtuoso.getInstance().getPrefs();

            userModel.sResult = (jso.containsKey("resultCode")) ? jso.getString("resultCode") : null;
            userModel.sKey = (jso.containsKey("key")) ? jso.getString("key") : null;
            userModel.sKeyExpire = (jso.containsKey("keyExpire")) ? jso.getString("keyExpire") : null;
            userModel.sId = (jso.containsKey("userId")) ? jso.getString("userId") : null;
            if (userModel.bNeedUpdatePreference) {
                m_Prefs.setUserKey(userModel.sKey);
                m_Prefs.setKeyExpire(userModel.sKeyExpire);
            }

            PPVirtuosoLogTrace.d("PPLoginJsonParser", "UserKey =" + m_Prefs.getUserKey());
            PPVirtuosoLogTrace.d("PPLoginJsonParser", "UserKeyExpire =" + m_Prefs.getKeyExpire());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }

}
