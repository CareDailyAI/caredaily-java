/**
 * @FileName  : PPRuleGetConditionJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.rules.PPRuleGetPhrasesModel;

public class PPRuleGetConditionJsonParser implements PPBaseJsonParser {

	@SuppressWarnings("unchecked")
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		PPRuleGetPhrasesModel getPhrasesModel = (PPRuleGetPhrasesModel) obj[0];

		try{

            PPRuleGetPhrasesModel response = JSON.parseObject(jso.toString(), PPRuleGetPhrasesModel.class);
			if(response == null) {
				return false;
			}
            getPhrasesModel.setTriggers(response.getTriggers());
            getPhrasesModel.setStates(response.getStates());
            getPhrasesModel.setActions(response.getActions());

			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		catch (OutOfMemoryError ex)
		{
			Runtime.getRuntime().gc();
		}
		return false;
	}
}
