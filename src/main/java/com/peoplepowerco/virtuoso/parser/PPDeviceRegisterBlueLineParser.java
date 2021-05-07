/**
 * @FileName  : PPDeviceRegisterBlueLineParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceRegisterBlueLineModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

public class PPDeviceRegisterBlueLineParser implements PPBaseJsonParser {

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		try 
        {
			PPDeviceRegisterBlueLineModel DeviceRegisterBlueLineModel = (PPDeviceRegisterBlueLineModel)obj[0];
           
			DeviceRegisterBlueLineModel.sDeviceId  = (jso.containsKey("deviceId")) ? jso.getString("deviceId") : null;
			DeviceRegisterBlueLineModel.sExist  = (jso.containsKey("exist")) ? jso.getString("exist") : null;
			DeviceRegisterBlueLineModel.sAuthToken  = (jso.containsKey("authToken")) ? jso.getString("authToken") : null;
			DeviceRegisterBlueLineModel.sHost  = (jso.containsKey("host")) ? jso.getString("host") : null;
			DeviceRegisterBlueLineModel.sPort  = (jso.containsKey("port")) ? jso.getString("port") : null;
			DeviceRegisterBlueLineModel.sUri  = (jso.containsKey("uri")) ? jso.getString("uri") : null;
			DeviceRegisterBlueLineModel.sSSL  = (jso.containsKey("useSSL")) ? jso.getString("useSSL") : null;
            
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "DeviceId =" + DeviceRegisterBlueLineModel.sDeviceId);
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "Exist =" + DeviceRegisterBlueLineModel.sExist );
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "AuthToken =" + DeviceRegisterBlueLineModel.sAuthToken);
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "Host =" + DeviceRegisterBlueLineModel.sHost );
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "Port =" + DeviceRegisterBlueLineModel.sPort);
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "Uri =" + DeviceRegisterBlueLineModel.sUri );
            PPVirtuosoLogTrace.d("PPDeviceRegisterBlueLineParser", "SSL =" + DeviceRegisterBlueLineModel.sSSL);
            
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
