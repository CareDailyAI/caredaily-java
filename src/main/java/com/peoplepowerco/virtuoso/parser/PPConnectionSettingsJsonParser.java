/**
 * @FileName  : PPConnectionSettingsJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPConnectionSettingsModel;
import com.peoplepowerco.virtuoso.models.PPServerInformationModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * @author James Cho
 * Connection setting Json parser
 */
public class PPConnectionSettingsJsonParser implements PPBaseJsonParser {
	public  ArrayList<PPConnectionSettingsModel> m_ConnectionSettingsModelList;

	public boolean setStringData(String sJSON, Object[] obj) {
		JSONObject jso = null;
		try {
			jso = JSONObject.parseObject(sJSON);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return setData(jso,obj);
	}

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		JSONArray 		jaArrayClouds = null;
		JSONArray 		jaArrayServer = null;
		JSONObject 		json 	= null;
		ArrayList<PPServerInformationModel> m_PPServerInfoModelList = null;
		// TODO Auto-generated method stub
		try{
			m_ConnectionSettingsModelList = (ArrayList<PPConnectionSettingsModel>) obj[0];			
			jaArrayClouds = (jso.containsKey("clouds")) ? jso.getJSONArray("clouds") : null;
			if(jaArrayClouds != null && jaArrayClouds.size() > 0){
				int nArrayName = jaArrayClouds.size();
				for(int i=0; i<nArrayName; i++){
					json = jaArrayClouds.getJSONObject(i);
					PPConnectionSettingsModel connectionSettingModel = new PPConnectionSettingsModel();
					connectionSettingModel.sName = (json.containsKey("name")) ? json.getString("name") : null;
					connectionSettingModel.sVersion = (json.containsKey("version")) ? json.getString("version") : null;
					PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "name = " + connectionSettingModel.sName);
					jaArrayServer = (json.containsKey("servers")) ? json.getJSONArray("servers") : null;
					if(jaArrayServer != null && jaArrayServer.size() > 0){
                        int nArraySever = jaArrayServer.size();
                        m_PPServerInfoModelList = new ArrayList<PPServerInformationModel>(nArraySever);
						for(int j = 0; j < nArraySever; j ++){
							json = jaArrayServer.getJSONObject(j);
							PPServerInformationModel severInformationModel = new PPServerInformationModel();
							severInformationModel.setType((json.containsKey("type")) ? json.getString("type") : null);
							severInformationModel.setHost((json.containsKey("host")) ? json.getString("host") : null);
							severInformationModel.setPort((json.containsKey("port")) ? json.getString("port") : null);
							severInformationModel.setAltPort((json.containsKey("altPort")) ? json.getString("altPort") : null);
							severInformationModel.setSsl((json.containsKey("ssl")) ? json.getString("ssl") : null);
							severInformationModel.setAltSsl((json.containsKey("altSsl")) ? json.getString("altSsl") : null);
                            severInformationModel.setBrand((json.containsKey("brand")) ? json.getString("brand") : null);
                            m_PPServerInfoModelList.add(severInformationModel);
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.sType = " + severInformationModel.getType());
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.sHost = " + severInformationModel.getHost());
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.sPort = " + severInformationModel.getPort());
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.sAltPort = " + severInformationModel.getAltPort());
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.bSsl = " + severInformationModel.getSsl());
							PPVirtuosoLogTrace.d("PPConnectionSettingsJsonParser", "severInformationModel.bAltSsl = " + severInformationModel.getAltSsl());
						}
						connectionSettingModel.setServerInformation(m_PPServerInfoModelList);
					}
                    m_ConnectionSettingsModelList.add(connectionSettingModel);
				}
			}
			return true;

		}catch (Exception e) {
			e.printStackTrace();
		} catch (OutOfMemoryError ex) {
			Runtime.getRuntime().gc();
		}
		return false;
	}

}
