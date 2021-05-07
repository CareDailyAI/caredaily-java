package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.HashSet;
import java.util.Set;

public class PPBotSummaryParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        Set<String> dataStreams = (Set<String>) obj[0];
        Set<String> microServices = (Set<String>) obj[1];

        Set<String> tempStreams = new HashSet<>();
        JSONArray array = jso.getJSONArray("dataStreams");
        if (null != array) {
            for (int i = 0; i != array.size(); ++i) {
                tempStreams.add(array.getString(i));
            }
        }

        Set<String> tempServices = new HashSet<>();
        array = jso.getJSONArray("microServices");
        if (null != array) {
            for (int i = 0; i != array.size(); ++i) {
                tempServices.add(array.getString(i));
            }
        }

        dataStreams.clear();
        dataStreams.addAll(tempStreams);

        microServices.clear();
        microServices.addAll(tempStreams);
        return true;
    }
}
