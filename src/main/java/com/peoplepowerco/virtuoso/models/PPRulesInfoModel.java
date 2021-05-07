/**
 * @FileName  : PPRulesInfoModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/*
 * It is used for grouping purpose.
 */
public class PPRulesInfoModel{
	private String sActionName	= null; 	//Tigger,State and Action
	private int intActionId		= 0;		//ID of Tigger,State and Action to make rule.
	private int intCustomActionId	= 0;	//ID which is set to PPCommonInfo.
	private int sDisplayType	= 0;
	private String sDeviceId	= null;
	private String sDeviceName	= null;
	private String sDisplayName	= null;
	private String sSetText 	= null;
	
	public PPRulesInfoModel(){}

	public String getActionName() {
		return sActionName;
	}
	public void setActionName(String sActionName) {
		this.sActionName = sActionName;
	}	
	public int getActionId() {
		return intActionId;
	}
	public void setActionId(int intActionId) {
		this.intActionId = intActionId;
	}	
	public int getCustomActionId() {
		return intCustomActionId;
	}
	public void setCustomActionId(int intCustomActionId) {
		this.intCustomActionId = intCustomActionId;
	}
	public int getDisplayType() {
		return sDisplayType;
	}
	public void setDisplayType(int sDisplayType) {
		this.sDisplayType = sDisplayType;
	}
	public String getDeviceId() {
		return sDeviceId;
	}
	public void setDeviceId(String sDeviceId) {
		this.sDeviceId = sDeviceId;
	}
	public String getDeviceName() {
		return sDeviceName;
	}
	public void setDeviceName(String sDeviceName) {
		this.sDeviceName = sDeviceName;
	}
	public String getDisplayName() {
		return sDisplayName;
	}
	public void setDisplayName(String sDisplayName) {
		this.sDisplayName = sDisplayName;
	}
	public String getText() {
		return sSetText;
	}
	public void setText(String sSetText) {
		this.sSetText = sSetText;
	}
}
