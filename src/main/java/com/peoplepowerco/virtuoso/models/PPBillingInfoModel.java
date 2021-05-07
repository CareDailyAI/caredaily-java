/**
 * @FileName  : PPBillingInfoModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief : Billing model for device billing information
 * @date  : 2013. 12. 30.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPBillingInfoModel {
	private int nBillingDay = 0;
	private String sUtilityName = null;
	private int nBillingRateId = 0;
	private int nBillingRateType = 0;
	private boolean bBillingRateTypical = false;
	private String sBillingRateValue = null;

	public int getBillingDay(){
		return nBillingDay;
	}

	public void setBillingDay(int billingDay){
		nBillingDay = billingDay;
	}

	public String getUtilityName(){
		return sUtilityName;
	}

	public int getBillingRateId(){
		return nBillingRateId;
	}

	public void setBillingRateId(int id){
		nBillingRateId = id;
	}

	public int getBillingRateType(){
		return nBillingRateType;
	}

	public void setBillingRateType(int type){
		nBillingRateType = type;
	}

	public boolean getBillingRateTypical(){
		return bBillingRateTypical;
	}

	public void setBillingRateTypical(boolean bTypical){
		bBillingRateTypical = bTypical;
	}

	public String getBillingRateValue(){
		return sBillingRateValue;
	}

	public void setBillingRateValue(String sValue){
		sBillingRateValue = sValue;
	}
}
