/**
 * @FileName  : PPBillingInfoJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPBillingInfoModel;


/**
 * @brief : Billing info json parser
 * @date  : 2013. 12. 30.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPBillingInfoJsonParser implements PPBaseJsonParser {

    private final static String TAG = "PPBillingInfoJsonParser";

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		JSONObject 		json 	= null;
		try {
			PPBillingInfoModel BillingInfoModel = (PPBillingInfoModel)obj[0];
			json = jso.getJSONObject("billingRate");
            BillingInfoModel.setBillingRateId((json.containsKey("id")) ? json.getInteger("id") : 0);
            BillingInfoModel.setBillingRateType((json.containsKey("type")) ? json.getInteger("type") : 0);
            BillingInfoModel.setBillingRateTypical((json.containsKey("typical")) ? json.getBoolean("typical") : false);
			BillingInfoModel.setBillingRateValue((json.containsKey("value")) ? json.getString("value") : null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

		return false;
	}

}
