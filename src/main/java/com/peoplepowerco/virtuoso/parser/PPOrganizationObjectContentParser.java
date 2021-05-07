package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;

public class PPOrganizationObjectContentParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        if (jso.containsKey("organizationObjects")) {
        }
        return true;
    }
}
