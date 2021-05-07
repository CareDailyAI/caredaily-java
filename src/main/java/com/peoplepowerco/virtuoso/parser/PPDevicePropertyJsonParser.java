/**
 * @FileName  : PPDevicePropertyJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDevicePropertyModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

public class PPDevicePropertyJsonParser implements PPBaseJsonParser {

	private static String TAG = "PPDevicePropertyJsonParser";
	
	public ArrayList<PPDevicePropertyModel> m_DevicePropertyList = null;
	
	
	JSONArray jaArrayParam = null;
	JSONObject json = null;
	PPDevicePropertyModel m_devicePropertyModel = null;

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		try {
			m_DevicePropertyList = (ArrayList<PPDevicePropertyModel>) obj[0];
			jaArrayParam = jso.getJSONArray("properties");
			if(jaArrayParam != null && jaArrayParam.size() > 0){
				int arrayPropertyCount = jaArrayParam.size();
				for (int i = 0; i < arrayPropertyCount; i++) {
					json = jaArrayParam.getJSONObject(i);
					m_devicePropertyModel = new PPDevicePropertyModel();
					m_devicePropertyModel.setStrName(json.getString("name"));
					m_devicePropertyModel.setStrContent(json.getString("value"));
					m_devicePropertyModel.setStrIndex(json.getString("index"));
					
					PPVirtuosoLogTrace.d(TAG, "Name =" + m_devicePropertyModel.getStrName());
					PPVirtuosoLogTrace.d(TAG, "Value =" + m_devicePropertyModel.getStrContent());
					PPVirtuosoLogTrace.d(TAG, "LastUpdatedTime =" + m_devicePropertyModel.getStrIndex());
					m_DevicePropertyList.add(m_devicePropertyModel);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
