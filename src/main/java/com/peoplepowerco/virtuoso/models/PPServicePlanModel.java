package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

public class PPServicePlanModel {
	private int id = 0;
	private String sName = null;
	private String sDesc = null;
	private boolean isAvailable = false;
	private ArrayList<PPServicePlanPriceModel> priceList =  null;
	private ArrayList<PPServicePlanSubscriptionModel> subscriptionList = null;
	private boolean isSubscribed = false;

	public void setServicePlanId(int Id){
		id = Id;
	}

	public int getServicePlanId(){
		return id;
	}

	public void setServiceName(String name){
		sName = name;
	}

	public String getServiceName(){
		return sName;
	}

	public void setDesc(String desc){
		sDesc = desc;
	}

	public String getDesc(){
		return sDesc;
	}

	public void setAvailable(boolean bAvailable){
		isAvailable = bAvailable;
	}

	public boolean getAvailable(){
		return isAvailable;
	}

	public void setPriceList( ArrayList<PPServicePlanPriceModel> alPriceList){
		priceList = alPriceList;
	}

	public ArrayList<PPServicePlanPriceModel> getPriceList(){
		return priceList;
	}

	public void setSubscriptionList(ArrayList<PPServicePlanSubscriptionModel> alSubscription){
		subscriptionList = alSubscription;
	}

	public ArrayList<PPServicePlanSubscriptionModel> getSubscriptionList(){
		return subscriptionList;
	}

	public void setSubscription(boolean bSubscribed){
		isSubscribed = bSubscribed;
	}

	public boolean getSubscription(){
		return isSubscribed;
	}

}
