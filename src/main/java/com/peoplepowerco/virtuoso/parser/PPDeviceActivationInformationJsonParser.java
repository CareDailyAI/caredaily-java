/**
 * @FileName  :
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceActivateModel;

/**
 * @brief : Device Activation information parser.
 * @date  : Sep 21, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceActivationInformationJsonParser implements PPBaseJsonParser {

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		try {
            PPDeviceActivateModel DeviceActivationModel = (PPDeviceActivateModel) obj[0];

            DeviceActivationModel.setActivationKey((jso.containsKey("deviceActivationKey")) ? jso.getString("deviceActivationKey") : null);
            DeviceActivationModel.setActivationURL((jso.containsKey("deviceActivationUrl")) ? jso.getString("deviceActivationUrl") : null);
            DeviceActivationModel.setMessage((jso.containsKey("message")) ? jso.getString("message") : null);
            DeviceActivationModel.setHost((jso.containsKey("host")) ? jso.getString("host") : null);
            DeviceActivationModel.setPort((jso.containsKey("port")) ? jso.getString("port") : null);
            DeviceActivationModel.setURL((jso.containsKey("uri")) ? jso.getString("uri") : null);
            DeviceActivationModel.setSSL((jso.containsKey("ssl")) ? jso.getString("ssl") : null);

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
