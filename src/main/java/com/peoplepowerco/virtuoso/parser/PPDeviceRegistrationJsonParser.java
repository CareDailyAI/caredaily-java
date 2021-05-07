/**
 * @FileName  : PPDeviceRegistrationJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceRegistrationInfoModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

public class PPDeviceRegistrationJsonParser implements PPBaseJsonParser {

	private static final String TAG = "PPDeviceRegistrationJsonParser";

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		try {
			PPDeviceRegistrationInfoModel deviceRegistrationInfoModel = (PPDeviceRegistrationInfoModel) obj[0];
			deviceRegistrationInfoModel.bExist = (jso.containsKey("exist")) ? jso.getBoolean("exist") : false;
			deviceRegistrationInfoModel.sAuthToken = (jso.containsKey("authToken")) ? jso.getString("authToken") : null;
			deviceRegistrationInfoModel.sHost = (jso.containsKey("host")) ? jso.getString("host") : null;
			deviceRegistrationInfoModel.sPort = (jso.containsKey("port")) ? jso.getString("port") : null;
			deviceRegistrationInfoModel.sUri = (jso.containsKey("uri")) ? jso.getString("uri") : null;
			deviceRegistrationInfoModel.sUseSSL = (jso.containsKey("useSSL")) ? jso.getString("useSSL") : null;
			if (deviceRegistrationInfoModel.sAuthToken != null) {
				// TODO only registering device from Login And Registering and
				// not from DeviceList activity so saved at activity level
				// PPAppCenter.m_SharedPresence.setEspToken(deviceRegistrationInfoModel.sAuthToken);
				PPVirtuosoLogTrace.d(TAG, "AuthToken is :: " + deviceRegistrationInfoModel.sAuthToken);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
