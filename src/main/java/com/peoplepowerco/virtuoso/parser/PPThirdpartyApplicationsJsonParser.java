/**
 * @FileName  : PPThirdpartyApplicationsJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPThirdpartyApplicationsModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * @author James Cho 
 * Third party application Json parser
 */
public class PPThirdpartyApplicationsJsonParser  implements PPBaseJsonParser {
	public  ArrayList<PPThirdpartyApplicationsModel> m_ThridpartyApplicationsModelList;
	private static final String TAG = "PPThirdpartyApplicationsJsonParser";
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		JSONArray 		jaArrayApplications = null;
		JSONObject 		json 	= null;
		try{
			m_ThridpartyApplicationsModelList = (ArrayList<PPThirdpartyApplicationsModel>) obj[0];			
			jaArrayApplications = (jso.containsKey("applications")) ? jso.getJSONArray("applications") : null;
			
			if(jaArrayApplications != null && jaArrayApplications.size() > 0){
				int nArrayName = jaArrayApplications.size();
				for(int i=0; i<nArrayName; i++){
					json = jaArrayApplications.getJSONObject(i);
					PPThirdpartyApplicationsModel ThirdpartyModel = new PPThirdpartyApplicationsModel();
					ThirdpartyModel.sId = (json.containsKey("id")) ? json.getString("id") : null;
					ThirdpartyModel.sName = (json.containsKey("name")) ? json.getString("name") : null;
					ThirdpartyModel.bGreenButton = (json.containsKey("greenButton")) ? json.getBoolean("greenButton") : false;
					ThirdpartyModel.sIcon = (json.containsKey("icon")) ? json.getString("icon") : null;
//					if(ThirdpartyModel.sGreenButton !=null && ThirdpartyModel.sGreenButton.equals("true")){
						m_ThridpartyApplicationsModelList.add(ThirdpartyModel);
//					}

					PPVirtuosoLogTrace.d(TAG, "ThirdpartyModel.sId = " + ThirdpartyModel.sId);
					PPVirtuosoLogTrace.d(TAG, "ThirdpartyModel.sName = " + ThirdpartyModel.sName);
					PPVirtuosoLogTrace.d(TAG, "ThirdpartyModel.sGreenButton = " + ThirdpartyModel.bGreenButton);
					PPVirtuosoLogTrace.d(TAG, "ThirdpartyModel.sIcon = " + ThirdpartyModel.sIcon);
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
