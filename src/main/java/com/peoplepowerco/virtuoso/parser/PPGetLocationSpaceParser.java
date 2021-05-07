package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by edwardliu on 2018/6/21.
 */

public class PPGetLocationSpaceParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPLocationSpaceModel> spaceModels = (List<PPLocationSpaceModel>) obj[0];
        spaceModels.clear();
        JSONArray jaArraySpaces = (jso.containsKey("spaces")) ? jso.getJSONArray("spaces") : null;
        if (jaArraySpaces != null && !jaArraySpaces.isEmpty()) {
            Set<String> names = new HashSet<>();
            for (int i = 0; i < jaArraySpaces.size(); i++) {
                JSONObject spaceJson = jaArraySpaces.getJSONObject(i);
                String name = spaceJson.getString("name");
                if (names.contains(name) || name.toLowerCase().equals("test") || name.toLowerCase().equals("couch")) {
                    continue;
                }
                names.add(name);
                PPLocationSpaceModel spaceModel = new PPLocationSpaceModel();
                spaceModel.setId(spaceJson.getIntValue("id"));
                spaceModel.setType(spaceJson.getIntValue("type"));
                spaceModel.setName(spaceJson.getString("name"));
                spaceModels.add(spaceModel);
            }
        }
        return true;
    }
}
