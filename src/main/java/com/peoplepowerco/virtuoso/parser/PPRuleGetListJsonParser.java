/**
 * @FileName : PPRuleGetListJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.rules.PPRuleGetListModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleModel;

import java.util.List;

public class PPRuleGetListJsonParser implements PPBaseJsonParser {

    @SuppressWarnings("unchecked")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPRuleGetListModel getListModel = (PPRuleGetListModel) obj[0];

        try {

            PPRuleGetListModel response = JSON.parseObject(jso.toString(), PPRuleGetListModel.class);
            if (response == null) {
                return false;
            }

            List<PPRuleModel> list = response.getRules();
            getListModel.setRules(list);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
