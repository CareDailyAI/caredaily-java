/**
 * @FileName  : PPServicePlanSubscriptionModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

public class PPServicePlanSubscriptionModel {
	private String sStartDate = null;
	private String sEndDate = null;
	private String sStartDateMs = null;
	private int nEndDateMs = 0;
	private boolean isfree = false;
	private int nUserPlanId = 0;
	private int nType = 0 ;
	private int nPaymentType = 0;
	private ArrayList<PPServicePlanAmountModel> amountModelArrayList = null;

	public void setStartDate(String startDate){
		sStartDate = startDate;
	}

	public String getStartDate(){
		return sStartDate;
	}

	public void setEndDates(String endDate){
		sEndDate = endDate;
	}

	public String getEndDate(){
		return sEndDate;
	}

	public String getStartDateMs(){
		return sStartDateMs;
	}

	public void setStartDateMs(String date){
		sStartDateMs = date;
	}

	public int gedEndDateMs(){
		return nEndDateMs;
	}

	public void setEndDateMs(int date){
		nEndDateMs = nEndDateMs;
	}

	public boolean getIsfree(){
		return isfree;
	}

	public void setIsfree(boolean free){
		isfree = free;
	}

	public int getUserPlanId(){
		return nUserPlanId;
	}

	public void setUserPlanId(int id){
		nUserPlanId = id;
	}

	public int getType(){
		return nType;
	}

	public void setType(int type){
		nType = type;
	}

	public int getPaymentType(){
		return nPaymentType;
	}

	public void setPaymentType(int type){
		nPaymentType = type;
	}

	public void setAmountModelArrayList(ArrayList<PPServicePlanAmountModel> alAmountModel){
		amountModelArrayList = alAmountModel;
	}

	public ArrayList<PPServicePlanAmountModel> getamountModelArrayList(){
		return amountModelArrayList;
	}
}
