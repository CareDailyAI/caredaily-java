/**
 * @FileName  : PPDeviceParameterModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

/**
 * @brief : Device parameter Model
 * @date  : Jun 1, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceParameterModel {
	private static final String TAG = "PPDeviceParameterModel";
	public String strDeviceId = null;
	public String strLastReceivedDate = null;
	public String strMeasureDate = null;
	public ArrayList<PPDeviceParameterInfoModel> aDeviceParameterInfoModel;


	public String getDeviceId()
	{
		return strDeviceId;
	}

	public void setDeviceId(String sDeviceId)
	{
		this.strDeviceId = sDeviceId;
	}

	public String getLastReceivedDate() {
		return strLastReceivedDate;
	}

	public void setLastReceivedDate(String sLastReceivedDate) {
		this.strLastReceivedDate = sLastReceivedDate;
	}

	public String getMeasureDate() {
		return strMeasureDate;
	}

	public void setMeasureDate(String strMeasureDate) {
		this.strMeasureDate = strMeasureDate;
	}

	public ArrayList<PPDeviceParameterInfoModel> getDeviceParametersInfoModel() {
		return aDeviceParameterInfoModel;
	}

	public void setDeviceParametersInfoModel(
			ArrayList<PPDeviceParameterInfoModel> arrayDeviceParametersInfoModels) {
		this.aDeviceParameterInfoModel = arrayDeviceParametersInfoModels;
	}

}
