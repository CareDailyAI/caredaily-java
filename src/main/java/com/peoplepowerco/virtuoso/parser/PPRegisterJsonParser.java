/**
 * @FileName : PPRegisterJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.models.PPUserModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;


/**
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Register json parser
 * @date : 2013. 8. 15.
 */
public class PPRegisterJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        try {
            PPUserModel userModel = (PPUserModel) obj[0];

            userModel.sResult = (jso.containsKey("resultCode")) ? jso.getString("resultCode") : null;
            userModel.sKey = (jso.containsKey("key")) ? jso.getString("key") : null;
            userModel.sKeyExpire = (jso.containsKey("keyExpire")) ? jso.getString("keyExpire") : null;
            userModel.sId = (jso.containsKey("userId")) ? jso.getString("userId") : null;

            if (userModel.bNeedUpdatePreference) {
                PPAppCenter.m_SharedPresence.setUserKey(userModel.sKey);
                PPAppCenter.m_SharedPresence.setKeyExpire(userModel.sKeyExpire);
                PPVirtuosoLogTrace.d("PPRegisterJsonParser", "UserKey =" + PPAppCenter.m_SharedPresence.getUserKey());
                PPVirtuosoLogTrace.d("PPRegisterJsonParser", "UserKeyExpire =" + PPAppCenter.m_SharedPresence.getKeyExpire());
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
