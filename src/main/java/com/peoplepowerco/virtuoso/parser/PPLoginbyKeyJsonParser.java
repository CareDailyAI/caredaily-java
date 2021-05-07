/**
 * @FileName  : PPLoginbyKeyJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.models.PPLoginByKeyModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;


/**
 * @brief : Login by key json parser
 * @date  : 2013. 11. 4.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPLoginbyKeyJsonParser implements PPBaseJsonParser {

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		try 
        {
			PPLoginByKeyModel LoginKeyModel = (PPLoginByKeyModel)obj[0];
           
			LoginKeyModel.sTempKey  = (jso.containsKey("key")) ? jso.getString("key") : null;
			LoginKeyModel.sExpire  = (jso.containsKey("keyExpire")) ? jso.getString("keyExpire") : null;

            PPVirtuoso.getInstance().getPrefs().setTempKey(LoginKeyModel.sTempKey);
            
            PPVirtuosoLogTrace.d("PPLoginbyKeyJsonParser", "UserKey =" + LoginKeyModel.sTempKey);
            PPVirtuosoLogTrace.d("PPLoginbyKeyJsonParser", "UserKeyExpire =" + LoginKeyModel.sExpire);
                        
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
