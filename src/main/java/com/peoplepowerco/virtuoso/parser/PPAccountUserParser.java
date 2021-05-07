package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;

import java.util.List;

public class PPAccountUserParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPLocationUserModel> userModels = (List<PPLocationUserModel>) obj[0];
        userModels.clear();

        if (jso.containsKey("users")) {
            JSONArray array = jso.getJSONArray("users");
            List<PPLocationUserModel> results = JSON.parseArray(array.toString(), PPLocationUserModel.class);
            userModels.addAll(results);
        }
        return true;
    }
}
