package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPGetServerModel;

/**
 * @author : James Cho
 * @brief :
 * @date : 2017. 9. 13.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPGetServerJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {

        JSONObject getServerJsonObj = null;
        PPGetServerModel getServerModel = null;
        try {
            getServerModel = (PPGetServerModel) obj[0];
            getServerJsonObj = jso.getJSONObject("server");
            getServerModel.setType(getServerJsonObj.getString("type"));
            getServerModel.setHost(getServerJsonObj.getString("host"));
            getServerModel.setPort(getServerJsonObj.getString("port"));
            getServerModel.setSsl(getServerJsonObj.getBooleanValue("ssl"));
            getServerModel.setAltPort(getServerJsonObj.getString("altPort"));
            getServerModel.setAltSsl(getServerJsonObj.getString("altSsl"));
            getServerModel.setPath(getServerJsonObj.getString("path"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
