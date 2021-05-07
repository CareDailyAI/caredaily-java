package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPLocationModel;

public class PPLocationParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPLocationModel locationModel = (PPLocationModel) obj[0];
        if (jso.containsKey("locationId")) {
            locationModel.sLocationId = jso.getString("locationId");
        }
        return true;
    }
}
