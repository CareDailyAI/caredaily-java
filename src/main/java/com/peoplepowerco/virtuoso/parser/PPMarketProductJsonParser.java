/**
 * @FileName  : PPMarketProductJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPMarketProductModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * @brief : Market product json parser
 * @date  : 2013. 9. 10.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPMarketProductJsonParser implements PPBaseJsonParser {

	public ArrayList<PPMarketProductModel> m_productList;

	@SuppressWarnings("unchecked")
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		JSONArray 		jaArray = null;
		JSONObject 		json 	= null;

		PPMarketProductModel prdModel = null;

		try 
		{
			m_productList = (ArrayList<PPMarketProductModel>)obj[0]; 	
			
			jaArray = (jso.containsKey("products")) ? jso.getJSONArray("products") : null;

			if(jaArray != null && jaArray.size() > 0){
				@SuppressWarnings("null")
				int arrayCount = jaArray.size();
				for(int i=0; i<arrayCount; i++){
					json = jaArray.getJSONObject(i);
					prdModel = new PPMarketProductModel();
					prdModel.sProductId  = (json.containsKey("id")) ? json.getString("id") : null;
					prdModel.sThumbnailLink  = (json.containsKey("thumbnail")) ? json.getString("thumbnail") : null;
					prdModel.sName  = (json.containsKey("name")) ? json.getString("name") : null;
					prdModel.sDescription  = (json.containsKey("description")) ? json.getString("description") : null;
					prdModel.sProductLink  = (json.containsKey("productLink")) ? json.getString("productLink") : null;
					prdModel.sCellImage = (json.containsKey("cellImage")) ? json.getString("cellImage") : null;

					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "id =" + prdModel.sProductId);
					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "thumbnail =" + prdModel.sThumbnailLink);
					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "name =" + prdModel.sName);
					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "description =" + prdModel.sDescription);
					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "productLink =" + prdModel.sProductLink);
					PPVirtuosoLogTrace.d("PPMarketProductJsonParser", "cellImage =" + prdModel.sCellImage);

					m_productList.add(prdModel);
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
