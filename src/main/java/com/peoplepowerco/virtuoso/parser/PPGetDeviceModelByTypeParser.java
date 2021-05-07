package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.storybook.Model;

/**
 * Created by edwardliu on 2018/6/21.
 */

public class PPGetDeviceModelByTypeParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        Model deviceModel = (Model) obj[0];
        int requiredDeviceType = (int) obj[1];
        JSONArray array = jso.getJSONArray("categories");
        if (null == array) {
            return false;
        }
        for (int i = 0; i != array.size(); ++i) {
            JSONObject cateJson = array.getJSONObject(i);
            if (cateJson.containsKey("models")) {
                JSONArray modelsArray = cateJson.getJSONArray("models");
                for (int j = 0; j != modelsArray.size(); ++j) {
                    JSONObject modelJson = modelsArray.getJSONObject(j);
                    if (modelJson.containsKey("lookupParams") && modelJson.getIntValue("pairingType") == 8) {
                        JSONArray paramArray = modelJson.getJSONArray("lookupParams");
                        for (int k = 0; k != paramArray.size(); ++k) {
                            JSONObject paramJson = paramArray.getJSONObject(k);
                            int deviceType = paramJson.getIntValue("deviceType");
                            if (deviceType == requiredDeviceType) {
                                deviceModel.setId(modelJson.getString("id"));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
