/**
 * @FileName  : PPDeviceRegisteJsonrParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceRegisterModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * @brief : Device register parser
 * @date  : Aug 7, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceRegisteJsonrParser implements PPBaseJsonParser {

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		try 
        {
			PPDeviceRegisterModel DeviceModel = (PPDeviceRegisterModel)obj[0];
           
			DeviceModel.sDeviceId  = (jso.containsKey("deviceId")) ? jso.getString("deviceId") : null;
			DeviceModel.bExist = (jso.containsKey("exist")) ? jso.getBoolean("exist") : false;
            
            PPVirtuosoLogTrace.d("PPLoginJsonParser", "DeviceId =" + DeviceModel.sDeviceId );
            PPVirtuosoLogTrace.d("PPLoginJsonParser", "Exist =" + DeviceModel.bExist);
                        
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
