/**
 * @FileName : PPUserTotalsJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPUserTotalsModel;

public class PPUserTotalsJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONObject 		json 	= null;

        try
        {
            PPUserTotalsModel userTotalModel = (PPUserTotalsModel)obj[0];

            userTotalModel.setDevicesTotal((jso.containsKey("devicesTotal")) ? jso.getInteger("devicesTotal") : 0);
            userTotalModel.setFilesTotal((jso.containsKey("filesTotal")) ? jso.getInteger("filesTotal") : 0);
            userTotalModel.setRulesTotal((jso.containsKey("rulesTotal")) ? jso.getInteger("rulesTotal") : 0);
            userTotalModel.setFriendsTotal((jso.containsKey("friendsTotal")) ? jso.getInteger("friendsTotal") : 0);

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        catch (OutOfMemoryError ex)
        {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
