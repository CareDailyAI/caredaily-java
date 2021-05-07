/**
 * @FileName  : PPCurrentEnergyUsageJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPCurrentEnergyUsageModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * @brief : Current EnergyUsage json parser
 * @date  : Jul 22, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPCurrentEnergyUsageJsonParser implements PPBaseJsonParser {
	public ArrayList<PPCurrentEnergyUsageModel> m_CurrentEnergyUsageList;
	
	public PPCurrentEnergyUsageJsonParser()
	{
	}

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		JSONObject 		json 	= null;
		PPCurrentEnergyUsageModel CurrentEnergyUsageModel = null;
		
		
		try 
		{
			m_CurrentEnergyUsageList = (ArrayList<PPCurrentEnergyUsageModel>)obj[0]; 
//			json = jso.getJSONObject("power");
//			CurrentEnergyUsageModel.sAmountPerHour  = (json.containsKey("amountPerHour")) ? json.getString("amountPerHour") : null;
//			CurrentEnergyUsageModel.sWatts  = (json.containsKey("watts")) ? json.getString("watts") : null;
//			CurrentEnergyUsageModel.sCurrentRate  = (json.containsKey("currentRate")) ? json.getString("currentRate") : null;
//			CurrentEnergyUsageModel.sLastUpdateDate  = (json.containsKey("lastUpdateDate")) ? json.getString("lastUpdateDate") : null;
			json = jso.getJSONObject("energy");
			CurrentEnergyUsageModel = new PPCurrentEnergyUsageModel();
//			CurrentEnergyUsageModel.sAmount  = (json.containsKey("amount")) ? json.getString("amount") : null;
//			CurrentEnergyUsageModel.sKwh  = (json.containsKey("kwh")) ? json.getString("kwh") : null;
			CurrentEnergyUsageModel.sAmountYTD  = (json.containsKey("amountYTD")) ? json.getString("amountYTD") : null;
//			CurrentEnergyUsageModel.sKwhYTD  = (json.containsKey("kwhYTD")) ? json.getString("kwhYTD") : null;
//			CurrentEnergyUsageModel.sAmountDTD  = (json.containsKey("amountDTD")) ? json.getString("amountDTD") : null;
//			CurrentEnergyUsageModel.sKwhDTD  = (json.containsKey("kwhDTD")) ? json.getString("kwhDTD") : null;

//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sAmountPerHour ==" + CurrentEnergyUsageModel.sAmountPerHour);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sWatts ==" + CurrentEnergyUsageModel.sWatts);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sCurrentRate ==" + CurrentEnergyUsageModel.sCurrentRate);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sLastUpdateDate ==" + CurrentEnergyUsageModel.sLastUpdateDate);
			
			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sAmount ==" + CurrentEnergyUsageModel.sAmount);
			m_CurrentEnergyUsageList.add(CurrentEnergyUsageModel);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sKwh ==" + CurrentEnergyUsageModel.sKwh);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sAmountYTD ==" + CurrentEnergyUsageModel.sAmountYTD);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sKwhYTD ==" + CurrentEnergyUsageModel.sKwhYTD);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sAmountDTD ==" + CurrentEnergyUsageModel.sAmountDTD);
//			PPVirtuosoLogTrace.d("PPCurrentEnergyUsageJsonParser", "sKwhDTD ==" + CurrentEnergyUsageModel.sKwhDTD);

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
