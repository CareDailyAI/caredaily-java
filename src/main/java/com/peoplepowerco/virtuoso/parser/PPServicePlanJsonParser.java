package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPServicePlanAmountModel;
import com.peoplepowerco.virtuoso.models.PPServicePlanModel;
import com.peoplepowerco.virtuoso.models.PPServicePlanPriceModel;
import com.peoplepowerco.virtuoso.models.PPServicePlanSubscriptionModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

public class PPServicePlanJsonParser implements PPBaseJsonParser {
	private ArrayList<PPServicePlanModel> m_ServicePlanModelList;
	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		JSONArray 		jaArray = null;
		JSONArray 		priceJsonArray = null;
		JSONArray 		subscriptionJsonArray = null;
		JSONObject 		json 	= null;
		PPServicePlanModel m_ServicePlanModel;
		try{
			m_ServicePlanModelList = (ArrayList<PPServicePlanModel>)obj[0];
			jaArray = (jso.containsKey("servicePlans")) ? jso.getJSONArray("servicePlans") : null;
			if(jaArray != null && jaArray.size() > 0){
				int arrayCount = jaArray.size();
				for(int i=0; i<arrayCount; i++){
					json = jaArray.getJSONObject(i);
					m_ServicePlanModel = new PPServicePlanModel();
					m_ServicePlanModel.setServicePlanId((json.containsKey("id")) ? json.getInteger("id") : 0);
					m_ServicePlanModel.setServiceName((json.containsKey("name")) ? json.getString("name") : null);
					m_ServicePlanModel.setDesc((json.containsKey("desc")) ? json.getString("desc") : null);
					m_ServicePlanModel.setAvailable((json.containsKey("available")) ? json.getBoolean("available") : false);

					priceJsonArray = (json.containsKey("prices")) ? json.getJSONArray("prices") : null;
					if(priceJsonArray != null && priceJsonArray.size() > 0){
						int priceCount = priceJsonArray.size();
						ArrayList<PPServicePlanPriceModel> m_ServicePlanPriceModelList = new ArrayList<PPServicePlanPriceModel>();
						for(int j=0; j<priceCount; j++){
							PPServicePlanPriceModel m_ServicePlanPriceModel = new PPServicePlanPriceModel();
							JSONObject priceJsonObject = priceJsonArray.getJSONObject(j);
							m_ServicePlanPriceModel.setAppleStoreId((priceJsonObject.containsKey("appleStoreId")) ? priceJsonObject.getString("appleStoreId") : null);
							m_ServicePlanPriceModel.setPaypalId((priceJsonObject.containsKey("paypalPlanId")) ? priceJsonObject.getString("paypalPlanId") : null);
							m_ServicePlanPriceModel.setType((priceJsonObject.containsKey("type")) ? priceJsonObject.getInteger("type") : 0);
							m_ServicePlanPriceModel.setIsFree((priceJsonObject.containsKey("free")) ? priceJsonObject.getBoolean("free") : false);
							//m_ServicePlanPriceModel.setDuration((priceJsonObject.containsKey("duration")) ? priceJsonObject.getInteger("duration") : null);
							PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "apple store id = " + m_ServicePlanPriceModel.getAppleStoreId());
							PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "Paypal id = " + m_ServicePlanPriceModel.getPaypalId());
							if(priceJsonObject.containsKey("amount")){
								JSONObject jsonObjAmount = priceJsonObject.getJSONObject("amount");
								ArrayList<PPServicePlanAmountModel> servicePlanAmountModelArrayList = new ArrayList<PPServicePlanAmountModel>();
								PPServicePlanAmountModel servicePlanAmountModel = new PPServicePlanAmountModel();
								if(jsonObjAmount!=null) {
									servicePlanAmountModel.setCurrencyCode((jsonObjAmount.containsKey("currencyCode")) ? jsonObjAmount.getString("currencyCode") : null);
									servicePlanAmountModel.setCurrencySymbol((jsonObjAmount.containsKey("currencySymbol")) ? jsonObjAmount.getString("currencySymbol") : null);
									servicePlanAmountModel.setValue((jsonObjAmount.containsKey("value")) ? jsonObjAmount.getString("value") : null);
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "currencyCode = " + servicePlanAmountModel.getCurrencyCode());
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "currencySymbol = " + servicePlanAmountModel.getCurrencySymbol());
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "value = " + servicePlanAmountModel.getValue());
								}
								servicePlanAmountModelArrayList.add(servicePlanAmountModel);
								m_ServicePlanPriceModel.setAmountModelArrayList(servicePlanAmountModelArrayList);
							}
							m_ServicePlanPriceModelList.add(m_ServicePlanPriceModel);
						}
						m_ServicePlanModel.setPriceList(m_ServicePlanPriceModelList);
					}
					subscriptionJsonArray = (json.containsKey("subscriptions")) ? json.getJSONArray("subscriptions") : null;
					if(subscriptionJsonArray != null && subscriptionJsonArray.size() > 0){
						int subscriptionCount = subscriptionJsonArray.size();
						ArrayList<PPServicePlanSubscriptionModel> m_ServicePlanSubscriptionModelList = new ArrayList<PPServicePlanSubscriptionModel>();
						for(int j=0; j<subscriptionCount; j++){
							PPServicePlanSubscriptionModel m_ServicePlanSubscriptionModel = new PPServicePlanSubscriptionModel();
							JSONObject subscriptionJsonObject = subscriptionJsonArray.getJSONObject(j);
							m_ServicePlanSubscriptionModel.setStartDate((subscriptionJsonObject.containsKey("startDate")) ? subscriptionJsonObject.getString("startDate") : null);
							m_ServicePlanSubscriptionModel.setEndDates((subscriptionJsonObject.containsKey("endDate")) ? subscriptionJsonObject.getString("endDate") : null);
							m_ServicePlanSubscriptionModel.setStartDateMs((subscriptionJsonObject.containsKey("startDateMs")) ? subscriptionJsonObject.getString("startDateMs") : null);
							m_ServicePlanSubscriptionModel.setEndDateMs((subscriptionJsonObject.containsKey("endDateMs")) ? subscriptionJsonObject.getInteger("endDateMs") : 0);
							m_ServicePlanSubscriptionModel.setIsfree((subscriptionJsonObject.containsKey("free")) ? subscriptionJsonObject.getBoolean("free") : false);
							m_ServicePlanSubscriptionModel.setUserPlanId((subscriptionJsonObject.containsKey("userPlanId")) ? subscriptionJsonObject.getInteger("userPlanId") : 0);
							m_ServicePlanSubscriptionModel.setType((subscriptionJsonObject.containsKey("type")) ? subscriptionJsonObject.getInteger("type") : 0);
							if(subscriptionJsonObject.containsKey("paymentType")) {
								m_ServicePlanSubscriptionModel.setPaymentType((subscriptionJsonObject.containsKey("paymentType")) ? subscriptionJsonObject.getInteger("paymentType") : 0);
							}
							PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "setStartDateMs = " + m_ServicePlanSubscriptionModel.getStartDateMs());

							if(subscriptionJsonObject.containsKey("amount")){
								JSONObject jsonObjSubScripAmount = subscriptionJsonObject.getJSONObject("amount");
								ArrayList<PPServicePlanAmountModel> servicePlanAmountModelArrayList = new ArrayList<PPServicePlanAmountModel>();
								PPServicePlanAmountModel servicePlanAmountModel = new PPServicePlanAmountModel();
								if(jsonObjSubScripAmount!=null) {
									servicePlanAmountModel.setCurrencyCode((jsonObjSubScripAmount.containsKey("currencyCode")) ? jsonObjSubScripAmount.getString("currencyCode") : null);
									servicePlanAmountModel.setCurrencySymbol((jsonObjSubScripAmount.containsKey("currencySymbol")) ? jsonObjSubScripAmount.getString("currencySymbol") : null);
									servicePlanAmountModel.setValue((jsonObjSubScripAmount.containsKey("value")) ? jsonObjSubScripAmount.getString("value") : null);
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "subscrip currencyCode = " + servicePlanAmountModel.getCurrencyCode());
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "subscrip currencySymbol = " + servicePlanAmountModel.getCurrencySymbol());
									PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "subscrip value = " + servicePlanAmountModel.getValue());
								}

								servicePlanAmountModelArrayList.add(servicePlanAmountModel);
								m_ServicePlanSubscriptionModel.setAmountModelArrayList(servicePlanAmountModelArrayList);
							}
							m_ServicePlanSubscriptionModelList.add(m_ServicePlanSubscriptionModel);
						}
						m_ServicePlanModel.setSubscriptionList(m_ServicePlanSubscriptionModelList);
					}
					m_ServicePlanModel.setSubscription((json.containsKey("subscribed")) ? json.getBoolean("subscribed") : false);
					PPVirtuosoLogTrace.d("PPServicePlanJsonParser", "subscription = " + m_ServicePlanModel.getSubscription());
					m_ServicePlanModelList.add(m_ServicePlanModel);
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
