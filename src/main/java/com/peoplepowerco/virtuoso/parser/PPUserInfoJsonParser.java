/**
 * @FileName : PPUserInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPUserModel;

/**
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : User information json parser
 * @date : 2014. 5. 4.
 */
public class PPUserInfoJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        JSONObject json = null;
        PPUserModel userModel = (PPUserModel) obj[0];
        json = jso.getJSONObject("user");
        userModel.sId = (json.containsKey("id")) ? json.getString("id") : null;
        return true;
    }
}
