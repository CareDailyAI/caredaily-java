package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

public class PPServicePlanPriceModel {
	private String sAppleStoreId = null;
	private String sPaypalPlanId = null;
	private int nType = 0;
	private boolean isFree= false;
	private int nduration = 0;
	private ArrayList<PPServicePlanAmountModel> amountModelArrayList = null;

	public void setAppleStoreId(String Id){
		sAppleStoreId = Id;
	}

	public String getAppleStoreId(){
		return sAppleStoreId;
	}

	public void setPaypalId(String Id){
		sPaypalPlanId = Id;
	}

	public String getPaypalId(){
		return sPaypalPlanId;
	}

	public void setType(int type){
		nType = type;
	}
	public int getType(){
		return nType;
	}

	public boolean getIsFree(){
		return isFree;
	}

	public void setIsFree(boolean free){
		isFree = free;
	}

	public int getDuration(){
		return nduration;
	}

	public void setDuration(int duration){
		nduration = duration;
	}

	public void setAmountModelArrayList(ArrayList<PPServicePlanAmountModel> alAmountModel){
		amountModelArrayList = alAmountModel;
	}

	public ArrayList<PPServicePlanAmountModel> getamountModelArrayList(){
		return amountModelArrayList;
	}

}
