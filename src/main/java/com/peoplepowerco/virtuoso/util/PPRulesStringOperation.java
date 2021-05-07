/**
 * @FileName  : PPRulesStringOperation.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;

import android.text.TextUtils;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.R;

public class PPRulesStringOperation {

//	public static String getTextNoun(int displayType){
//		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
//			return "the time is ";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_EVENT){
//			return "I ";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
//			return "the time is between ";
//		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
//			return "my ";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
//			return "I ";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_SET_DEVICE_PROP){
//			return "make my ";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
//			return "my ";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
//			return "notify me by email";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
//			return "notify me by phone";
//		}
//		return null;
//	}
//
//	public static String getTextNoun(int displayType,PPRuleParametersValuesModel m_ValueModel){
//		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
//			return "the time is";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_EVENT){
//			return "I";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
//			return "the time is between";
//		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
//			return (m_ValueModel.getName() == null) ?"my (unnamed device)":"my '"+m_ValueModel.getName()+"'";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_SET_DEVICE_PROP){
//			return "make my '"+m_ValueModel.getName()+"'";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
//			return "I";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
//			return (m_ValueModel.getName() == null) ?"my (unnamed device)":"my '"+m_ValueModel.getName()+"'";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
//			return "notify me by email";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
//			return "notify me by phone";
//		}
//		return null;
//	}

	public static String getTextNoun(int displayType, String m_sDeviceName){
		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
			//return "the time is";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_is);
		} else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_HOME_AWAY) {
			//return "I";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_i);
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
			//return "the time is between";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_between);
		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
			//return (m_sDeviceName == null) ?"my (unnamed device)":"my '"+m_sDeviceName+"'";
			return (m_sDeviceName == null) ? PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device):PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my) + " " + "'"+m_sDeviceName+"'";
		} else if (displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_HOME_AWAY) {
			//return "make my '"+m_sDeviceName+"'";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_make_my)+ " " +"'"+m_sDeviceName+"'";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
			//return (m_sDeviceName == null) ?"my (unnamed device)":"my '"+m_sDeviceName+"'";
			return (m_sDeviceName == null) ? PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device):PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my) + " " + "'"+m_sDeviceName+"'";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
			//return "I";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_i);
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
			//return "notify me by email";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_email);
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
			//return "notify me by phone";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_phone);
		}else{
			return null;
		}
	}

//	public static String getNounForComponent(int displayType,PPRuleParametersValuesModel m_ValueModel){
//		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
//			return "The time is ...";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_EVENT){
//			return "I come home or go away ...";
//		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
//			return (m_ValueModel.getName() == null) ?"My (unnamed device)":"My '"+m_ValueModel.getName()+"'";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
//			return "The time is between ...";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
//			return "I am somewhere ...";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
//			return (m_ValueModel.getName() == null) ?"My (unnamed device)":"My '"+m_ValueModel.getName()+"'";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
//			return "notify me by phone";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
//			return "notify me by email";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_SET_DEVICE_PROP){
//			return "make my '"+m_ValueModel.getName()+"'";
//		}
//		return null;
//	}

	public static String getNounForComponent(int displayType,String m_sDeviceName){
		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
			//return "The time is ...";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_is_con);
		} else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_HOME_AWAY) {
			//return "I come home or go away ...";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_home_or_away);
		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
			//return (TextUtils.isEmpty(m_sDeviceName)) ?"My (unnamed device)":"My '"+m_sDeviceName+"'";
			return (TextUtils.isEmpty(m_sDeviceName)) ?PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device_con):PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_con) + " " + "'"+m_sDeviceName+"'";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
			//return "The time is between ...";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_between_con);
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
			//return "I am somewhere ...";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_somewhere);
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
			//return (TextUtils.isEmpty(m_sDeviceName)) ?"My (unnamed device)":"My '"+m_sDeviceName+"'";
			return (TextUtils.isEmpty(m_sDeviceName)) ?PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device_con):PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_con) + " " + "'"+m_sDeviceName+"'";
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
			//return "notify me by phone";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_phone);
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
			//return "notify me by email";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_email);
		} else if (displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_HOME_AWAY) {
			if(m_sDeviceName !=null && m_sDeviceName.contains(PPAppCenter.m_Context.getResources().getString(R.string.mode_home))){
				return PPAppCenter.m_Context.getResources().getString(R.string.rule_change_modes_action) + " ...";
			}else{
				//return "make my '"+m_sDeviceName+"'";
				return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_make_my)+ " " +"'"+m_sDeviceName+"'";
			}
		}
		return null;
	}

//	public static String getNounTextComponent(int displayType,PPRuleParametersValuesModel m_ValueModel){
//		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
//			return "the time is ____";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_EVENT){
//			return "I ____";
//		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
//			return (m_ValueModel.getName() == null) ?"my (unnamed device)"+" ____":"my '"+m_ValueModel.getName()+"' ____";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
//			return "the time is between ____";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
//			//return "____";
//			return "I ____";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
//			return (m_ValueModel.getName() == null) ?"my (unnamed device)"+" ____" : "my '"+m_ValueModel.getName()+"' ____";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
//			return "notify me by Phone";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
//			return "notify me by email";
//		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_SET_DEVICE_PROP){
//			return "make my '"+m_ValueModel.getName()+"'"+" ____";
//		}
//		return null;
//	}

	public static String getNounTextComponent(int displayType,String m_sDeviceName){
		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
			//return "the time is ____";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_is) + " " +"____";
		} else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_HOME_AWAY) {
			//return "I ____";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_i) +" " +"____";
		}else if((displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) || (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA)){
			//return (TextUtils.isEmpty(m_sDeviceName)) ?"my (unnamed device) ____":"my '"+m_sDeviceName+"' ____";
			return (TextUtils.isEmpty(m_sDeviceName)) ?PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device) +" "+"____":PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my) +" " + "'"+m_sDeviceName+"'" + " " + "____";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
			//return "the time is between ____";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_time_between) + " "+"____";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_i) + " "+"____";
		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
			//return (TextUtils.isEmpty(m_sDeviceName)) ?"my (unnamed device) ____" : "my '"+m_sDeviceName+"' ____";
			return (TextUtils.isEmpty(m_sDeviceName)) ?PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my_unnamed_device) +" "+"____":PPAppCenter.m_Context.getResources().getString(R.string.rule_str_my) +" " + "'"+m_sDeviceName+"'" + " " + "____";
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION){
			//return "notify me by phone";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_phone);
		}else if(displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL){
			//return "notify me by email";
			return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_notify_by_email);
		} else if (displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD || displayType == PPCommonInfo.INT_RULE_ACTION_HOME_AWAY) {
			if(m_sDeviceName !=null && m_sDeviceName.contains(PPAppCenter.m_Context.getResources().getString(R.string.mode_home))){
				return PPAppCenter.m_Context.getResources().getString(R.string.rule_change_modes_action) + " ...";
			}else {
				//return "make my '" + m_sDeviceName + "'" + " ____";
				return PPAppCenter.m_Context.getResources().getString(R.string.rule_str_make_my)+ " " + "'"+m_sDeviceName+"'" + " ____";
			}
		}
		return null;
	}

//	public static int getIdFromNoun(String m_ContainString){
//		if(m_ContainString.contains("This")){
//			return PPCommonInfo.INT_RULE_TRIGGER;
//		}else if(m_ContainString.contains("That")){
//			return PPCommonInfo.INT_RULE_ACTION;
//		}else if(m_ContainString.contains("the time is")){
//			return PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE;
//		}else if(m_ContainString.contains("I ")){
//			return PPCommonInfo.INT_RULE_TRIGGER_EVENT;
//		}else if(m_ContainString.contains("tell my")){
//			return PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD;
//		}else if(m_ContainString.contains("my")){
//			return PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM;
//		}
//		return 0;
//	}
//
//	public static int setIconFromNoun(String m_Desc,String m_sDeviceId){
//		if(m_Desc == null)
//			return 0;
//		if(m_Desc.contains("The time is ...")){
//			return R.drawable.device_clock;
//		}else if(m_Desc.contains("The time is between")){
//			return R.drawable.device_clock;
//		}else if(m_Desc.contains("I")){
//			return R.drawable.device_home;
//		}else if(m_Desc.contains("Tell My")){
//			if(m_sDeviceId != null && m_sDeviceId.contains("MON"))
//				return R.drawable.thumbnail_2012;
//			else
//				return R.drawable.device_presence_remote;
//		}else if(m_Desc.contains("My")){
//			if(m_sDeviceId != null && m_sDeviceId.contains("MON"))
//				return R.drawable.thumbnail_2012;
//			else
//				return R.drawable.device_presence_remote;
//		}else if(m_Desc.contains("phone")){
//			return R.drawable.icon_alert_iphone;
//		}else if(m_Desc.contains("email")){
//			return R.drawable.icon_pro_email;
//		}else{
//			return 0;
//		}
//	}

	public static String setDescWithBlankSpace(String m_sDesc,String m_sFindName){
		return m_sDesc.replace("$"+m_sFindName, "____");
	}

//	public static String generatNotificationText(int displayType){
//		if(displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE){
//			return "The time is";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_EVENT){
//			return "You";
//		}else if(displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA || displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION){
//			return "Your";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY){
//			return "you";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_GENERAL){
//			return "the time was between";
//		}else if(displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM){
//			return "your";
//		}
//		return null;
//	}
}
