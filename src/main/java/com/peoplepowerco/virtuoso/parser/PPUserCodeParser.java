package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserCodeModel;
import java.util.ArrayList;
import java.util.List;

public class PPUserCodeParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPUserCodeModel> userCodeList = (ArrayList<PPUserCodeModel>) obj[0];
        try {
            if (!userCodeList.isEmpty()) {
                userCodeList.clear();
            }
            if (jso.containsKey("codes")) {
                JSONArray codesArray = jso.getJSONArray("codes");
                for (int i = 0; i != codesArray.size(); ++i) {
                    PPUserCodeModel userCode = new PPUserCodeModel();
                    JSONObject codeOBJ = codesArray.getJSONObject(i);
                    userCode.setType(codeOBJ.containsKey("type") ? codeOBJ.getInteger("type") : 0);
                    userCode.setName(codeOBJ.containsKey("name") ? codeOBJ.getString("name") : null);
                    userCodeList.add(userCode);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
