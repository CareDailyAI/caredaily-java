package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPServicePlanModel;
import com.peoplepowerco.virtuoso.models.PPServicePlanSubscriptionModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * Created by laghee on 5/22/16.
 */
public class PPServicesManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPServicesManager.class.getSimpleName();
    private static PPServicesManager instance = null;
    private static ArrayList<PPServicePlanModel> m_servicePlanList = null;

    public static final String PRO_VIDEO = "Pro Video";
    public static final String CLOUD_STORAGE = "Cloud Storage";
    public static final String PRO_ENERGY = "Pro Energy";
    public static final String PRO_CAPE = "Pro Cape";
    public static final String TEST_PLAN = "Test Plan";
    public static final String PRO_SECURITY = "Pro Security";
    public static final String FREE_USER = "Free User";
    public static final String PRO_MONITORYING = "fpl-pro-monitoring";

    public static final int INT_FREE_USER = 0;
    public static final int INT_PRO_VIDEO = 1;
    public static final int INT_PRO_SECURITY = 2;

    /**
     * Hidden class constructor.
     */
    private PPServicesManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     *
     * @return
     */
    public static PPServicesManager getInstance() {
        synchronized (PPServicesManager.class) {
            if (instance == null) {
                instance = new PPServicesManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_servicePlanList = new ArrayList<>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance = null;
        }
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    /**
     * Request service plan
     */
    public void requestGetServicePlan(String tag) {
        JSONObject jsonObj = new JSONObject();
        if (m_servicePlanList != null) {
            m_servicePlanList.clear();
        }
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SOFTWARE_SUBSCRIPTIONS, jsonObj, m_servicePlanList);
    }

//    /**
//     * Login By key
//     */
//    public void requestLoginByKey()
//    {
//        JSONObject jsonObj = new JSONObject();
//        try{
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
//            PPVirtuosoLogTrace.d("PPServicePlanManager", "UserKey = " + PPAppCenter.m_SharedPresence.getUserKey());
//        } catch (JSONException e){
//            e.printStackTrace();
//        }
//        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_KEY, jsonObj, m_LoginByKeyModel);
//    }

    /**
     * Cancel service plan
     */
    public void requestCancelServicePlan(String tag, String servicePlanId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("servicePlanId", servicePlanId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            PPVirtuosoLogTrace.d("PPServicePlanManager", "UserKey = " + PPAppCenter.m_SharedPresence.getUserKey());
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_CANCEL_SUBSCRIPTION, jsonObj);
    }

    public boolean isProSecurityUser() {
        for (PPServicePlanModel currentPlanModel : m_servicePlanList) {
            if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(PRO_SECURITY)) {
                if (currentPlanModel.getSubscription()) {
                    PPVirtuosoLogTrace.d(TAG, "Pro security user");
                    return true;
                }
            }
        }

        //could not find a subscription
        return false;
    }

    /**
     * Check for pro user or not
     */
    public int checkforSubscribe_() {
        for (PPServicePlanModel currentPlanModel : m_servicePlanList) {
            if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(PRO_VIDEO)) {
                if (currentPlanModel.getSubscription()) {
                    PPVirtuosoLogTrace.d(TAG, "Pro video user");
                    return INT_PRO_VIDEO;
                }
            } else if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(PRO_SECURITY)) {
                if (currentPlanModel.getSubscription()) {
                    PPVirtuosoLogTrace.d(TAG, "Pro security user");
                    return INT_PRO_SECURITY;
                }
            }
        }
        PPVirtuosoLogTrace.d(TAG, "Free user");
        return INT_FREE_USER;
    }

    public boolean isSubscribeProMonitoring() {
        for (PPServicePlanModel currentPlanModel : m_servicePlanList) {
            if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(PRO_MONITORYING)
                    && currentPlanModel.getSubscription()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check for pro user or not (service plan subscribe pro video, pro security ...)
     */
    public boolean checkforSubscribe(String Type) {
        for (PPServicePlanModel currentPlanModel : getServicePlanList()) {
            if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(Type)) {
                if (currentPlanModel.getSubscription()) {
                    return true;
                }

            }
        }
        return false;
    }

    /**
     * Check for user plan id
     */
    public int getUserPlanId(String sType) {
        for (PPServicePlanModel currentPlanModel : getServicePlanList()) {
            if (currentPlanModel.getServiceName() != null && currentPlanModel.getServiceName().equals(sType)) {
                if (currentPlanModel.getSubscriptionList() != null && currentPlanModel.getSubscriptionList().size() > 0) {
                    for (PPServicePlanSubscriptionModel currentSubscriptioModel : currentPlanModel.getSubscriptionList()) {
                        if (currentSubscriptioModel.getUserPlanId() > 0) {
                            PPVirtuosoLogTrace.d(TAG, "GET UserPlan ID = " + currentSubscriptioModel.getUserPlanId());
                            return currentSubscriptioModel.getUserPlanId();
                        }
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Gets the current list of service plan.
     * If the list is empty, a call to get service plan will be made.
     *
     * @return
     */
    public ArrayList<PPServicePlanModel> getServicePlanList() {
        return m_servicePlanList;
    }

//    /* PAID SERVICES */
//    // https://app.presencepro.com/cloud/json/servicePlans?appName=appName&userId=userId&hiddenPrices=hiddenPrices
//    public static final short REQ_GET_SOFTWARE_SUBSCRIPTIONS                = 238;
//
//    // https://app.presencepro.com/cloud/json/receipt/apple?appName=appName
//    public static final short REQ_POST_SUBMIT_APPLE_PURCHASE_RECEIPT        = 239;
//
//    // https://app.presencepro.com/auth/paypalpurchase/planPriceId?API_KEY=API_KEY&sandbox=sandbox
//    public static final short REQ_GET_REDIRECT_USER_TO_PAYPAL_SITE          = 240;
//
//    // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId?userName=userName&endDate=endDate
//    public static final short REQ_POST_ASSIGN_SERVICES_TO_USER              = 241;
//
//    // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId
//    public static final short REQ_DELETE_CANCEL_SUBSCRIPTION                = 242;
//
//    // https://app.presencepro.com/cloud/json/userServicePlansBatch/servicePlanId?endDate=endDate
//    public static final short REQ_POST_ASSIGN_SERVICES_TO_USERS             = 243;
//
//    // https://app.presencepro.com/cloud/json/market?appName=appName
//    public static final short REQ_GET_STORE_PRODUCTS                        = 244;
}
