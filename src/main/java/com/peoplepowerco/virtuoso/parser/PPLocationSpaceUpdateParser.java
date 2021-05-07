package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;

/**
 * Created by edwardliu on 2018/9/20.
 */

public class PPLocationSpaceUpdateParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPLocationSpaceModel updateSpace = (PPLocationSpaceModel) obj[0];
        if (jso.containsKey("spaceId")) {
            updateSpace.setId(jso.getIntValue("spaceId"));
        } else {
            return false;
        }
        return true;
    }
}
