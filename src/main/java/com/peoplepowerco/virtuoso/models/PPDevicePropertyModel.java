/**
 * @FileName  : PPDevicePropertyModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;


/**
 * @brief : Device property info model
 * @author vaibhav
 *
 */

public class PPDevicePropertyModel{

//	private static final String TAG = "PPDeviceParameterInfoModel";
	public String strName = null;
	public String strContent = null;
	public String strIndex = null;

	public PPDevicePropertyModel() {
	}

	public PPDevicePropertyModel(String index, String name, String content) {
        strIndex = index;
        strName = name;
        strContent = content;
	}

	public String getStrName() {
		return strName;
	}



	public void setStrName(String strName) {
		this.strName = strName;
	}



	public String getStrContent() {
		return strContent;
	}



	public void setStrContent(String strContent) {
		this.strContent = strContent;
	}



	public String getStrIndex() {
		return strIndex;
	}



	public void setStrIndex(String strIndex) {
		this.strIndex = strIndex;
	}

	
}
