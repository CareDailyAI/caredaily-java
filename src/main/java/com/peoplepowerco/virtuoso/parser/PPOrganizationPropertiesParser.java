package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPOrganizationObjectModel;
import java.util.HashMap;

public class PPOrganizationPropertiesParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        HashMap<String, PPOrganizationObjectModel> datas = (HashMap<String, PPOrganizationObjectModel>) obj[0];
        if (jso.containsKey("organizationObjects")) {
            JSONArray array = jso.getJSONArray("organizationObjects");
            for (int i = 0; i != array.size(); ++i) {
                JSONObject orgObj = array.getJSONObject(i);
                PPOrganizationObjectModel objectModel = new PPOrganizationObjectModel();
                objectModel.privateContent = orgObj.getBooleanValue("privateContent");
                objectModel.name = orgObj.getString("name");
                objectModel.value = orgObj.getString("value");
                objectModel.parent = orgObj.getBooleanValue("parent");
                datas.put(objectModel.name, objectModel);
            }
        }
        return true;
    }
}
