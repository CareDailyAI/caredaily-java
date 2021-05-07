/**
 * @FileName  : PPNotificationSubscriptionsParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPNotificationSubscriptions;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

public class PPNotificationSubscriptionsParser implements PPBaseJsonParser {
	private static final String TAG = "PPNotificationSubscriptionsParser";
	private ArrayList<PPNotificationSubscriptions> m_NotificationSubscriptionsList;
	@SuppressWarnings("unchecked")
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		JSONArray 		jaArray = null;
		JSONObject 		json 	= null;
		PPNotificationSubscriptions m_NotificationSubscriptions = null;
		try{
			m_NotificationSubscriptionsList = (ArrayList<PPNotificationSubscriptions>)obj[0]; 	
			jaArray = (jso.containsKey("subscriptions")) ? jso.getJSONArray("subscriptions") : null;
			if(jaArray != null && jaArray.size() > 0){
				int jsonArrayCount = jaArray.size();
				for(int i = 0;i<jsonArrayCount;i++){
					m_NotificationSubscriptions = new PPNotificationSubscriptions();
					json = jaArray.getJSONObject(i);
					m_NotificationSubscriptions.type  	= (json.containsKey("type")) ? json.getInteger("type") : 0;
					m_NotificationSubscriptions.isEmail = (json.containsKey("email")) ? json.getBoolean("email") : false;
					m_NotificationSubscriptions.isPush  = (json.containsKey("push")) ? json.getBoolean("push") : false;
					m_NotificationSubscriptions.isSms  	= (json.containsKey("sms")) ? json.getBoolean("sms") : false;
					m_NotificationSubscriptions.sName  	= (json.containsKey("name")) ? json.getString("name") : null;
					m_NotificationSubscriptions.emailPeriod = (json.containsKey("emailPeriod")) ? json.getInteger("emailPeriod") : 0;
					m_NotificationSubscriptions.pushPeriod  = (json.containsKey("pushPeriod")) ? json.getInteger("pushPeriod") : 0;
					m_NotificationSubscriptions.smsPeriod  	= (json.containsKey("smsPeriod")) ? json.getInteger("smsPeriod") : 0;
					m_NotificationSubscriptionsList.add(m_NotificationSubscriptions);

					PPVirtuosoLogTrace.d(TAG, "Type:"+m_NotificationSubscriptions.type);
					PPVirtuosoLogTrace.d(TAG, "Email:"+m_NotificationSubscriptions.isEmail);
					PPVirtuosoLogTrace.d(TAG, "Push:"+m_NotificationSubscriptions.isPush);
					PPVirtuosoLogTrace.d(TAG, "Sms:"+m_NotificationSubscriptions.isSms);
					PPVirtuosoLogTrace.d(TAG, "Name:"+m_NotificationSubscriptions.sName);
					PPVirtuosoLogTrace.d(TAG, "EmailPeriod:"+m_NotificationSubscriptions.emailPeriod);
					PPVirtuosoLogTrace.d(TAG, "PushPeriod:"+m_NotificationSubscriptions.pushPeriod);
					PPVirtuosoLogTrace.d(TAG, "SmsPeriod:"+m_NotificationSubscriptions.smsPeriod);
				}
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}catch (OutOfMemoryError ex) {
			Runtime.getRuntime().gc();
		}
		return false;
	}

}
