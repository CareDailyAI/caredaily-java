package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class PPAppPresenceIdsParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<String> uuids = (List<String>) obj[0];
        uuids.clear();
        if (jso.containsKey("ibeaconUuids")) {
            JSONArray array = jso.getJSONArray("ibeaconUuids");
            for (int i = 0; i != array.size(); ++i) {
                uuids.add(array.getString(i).replaceAll("-", "").toUpperCase());
            }
        }
        return true;
    }
}
