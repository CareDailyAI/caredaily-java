/**
 * @FileName  : PPUIScreenJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPUIScreenItemModel;
import com.peoplepowerco.virtuoso.models.PPUIScreenModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @brief : UI screen json parser
 * @date  : Aug 14, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPUIScreenJsonParser implements PPBaseJsonParser {
	public List<PPUIScreenItemModel> m_UIScreenItemList = null;
    public List<PPUIScreenModel> m_UIScreenPassList = null;
	private PPUIScreenItemModel m_UIScreenItemModel = null;
	private int  nSection = 0;

	@SuppressWarnings({ "unused", "unchecked" })
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		JSONArray 		jsonArrayScreen = null;
		JSONArray 		jsonArraySection = null;
		JSONObject 		jsonArrayOrganization = null;
		JSONArray 		jsonArrayItems = null;
		JSONObject 		json 	= null;
		PPUIScreenModel UIScreenModel = null;
		try 
		{
            m_UIScreenPassList = (List<PPUIScreenModel>)obj[0];
            m_UIScreenItemList = new ArrayList<PPUIScreenItemModel>();

            if(m_UIScreenPassList != null) {
                m_UIScreenPassList.clear();
            }

			jsonArrayScreen = (jso.containsKey("screens")) ? jso.getJSONArray("screens") : null;
			if(jsonArrayScreen != null && jsonArrayScreen.size() > 0){
				int arrayScreenCount = jsonArrayScreen.size();
				for(int i=0; i<arrayScreenCount; i++){
					json = jsonArrayScreen.getJSONObject(i);
					jsonArraySection = (json.containsKey("sections")) ? json.getJSONArray("sections") : null;
					if(jsonArraySection != null && jsonArraySection.size() > 0){
						int arraySectionCount = jsonArraySection.size();
						for(int j=0; j<arraySectionCount; j++){
							nSection = j;
							json = jsonArraySection.getJSONObject(j);
							UIScreenModel = new PPUIScreenModel();
							UIScreenModel.sSectionId  = (json.containsKey("id")) ? json.getString("id") : null;
							UIScreenModel.sSectionName  = (json.containsKey("name")) ? json.getString("name") : null;
							UIScreenModel.nSectionOrder  = (json.containsKey("order")) ? json.getInteger("order") : 0;

							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.sSectionId = " + UIScreenModel.sSectionId);
							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.sSectionName  = " + UIScreenModel.sSectionName);
							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.nSectionOrder  = " + UIScreenModel.nSectionOrder);

							jsonArrayOrganization = json.getJSONObject("organization");

							UIScreenModel.sOrganizationId  = (jsonArrayOrganization.containsKey("id")) ? jsonArrayOrganization.getString("id") : null;
							UIScreenModel.sOrganizationName  = (jsonArrayOrganization.containsKey("name")) ? jsonArrayOrganization.getString("name") : null;
							UIScreenModel.sOrganizationDomain  = (jsonArrayOrganization.containsKey("domainName")) ? jsonArrayOrganization.getString("domainName") : null;

							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.sOrganizationId = " + UIScreenModel.sOrganizationId);
							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.sOrganizationName  = " + UIScreenModel.sOrganizationName);
							PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenModel.sOrganizationDomain  = " + UIScreenModel.sOrganizationDomain);

							jsonArrayItems = (json.containsKey("items")) ? json.getJSONArray("items") : null;
							if(jsonArrayItems != null && jsonArrayItems.size() > 0){
								int arrayItmeCount = jsonArrayItems.size();
								//m_UIScreenItemList = new ArrayList<PPUIScreenItemModel>();	
								for(int l=0; l<arrayItmeCount; 	l++){
									json = jsonArrayItems.getJSONObject(l);
									m_UIScreenItemModel = new PPUIScreenItemModel();
									
									m_UIScreenItemModel.setItemId((json.containsKey("id")) ? json.getString("id") : null);
									m_UIScreenItemModel.setItemName((json.containsKey("name")) ? json.getString("name") : null);
									m_UIScreenItemModel.setItemOrder((json.containsKey("order")) ? json.getInteger("order") : 0);
									m_UIScreenItemModel.setItemProduct((json.containsKey("product")) ? json.getString("product") : null);
									m_UIScreenItemModel.setItemDetails((json.containsKey("details")) ? json.getString("details") : null);
									m_UIScreenItemModel.setItemIcons((json.containsKey("icon")) ? json.getString("icon") : null);
									m_UIScreenItemModel.setItemIndex(nSection);

									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemId = " + m_UIScreenItemModel.getItemId());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemName  = " + m_UIScreenItemModel.getItemName());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemOrder  = " + m_UIScreenItemModel.getItemOrder());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemProduct = " + m_UIScreenItemModel.getItemProduct());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemDetails  = " + m_UIScreenItemModel.getItemDetails());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "UIScreenItemModel.getItemIcons  = " + m_UIScreenItemModel.getItemIcons());
									PPVirtuosoLogTrace.d("PPUIScreenJsonParser", "Index = " + m_UIScreenItemModel.getItemIndex());
									
									m_UIScreenItemList.add(m_UIScreenItemModel);	
								}						
								UIScreenModel.setUIScreenItemModel(m_UIScreenItemList);
							}
                            if(m_UIScreenPassList != null) {
                                m_UIScreenPassList.add(UIScreenModel);
                            }
						}
					}
				}
			}
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
