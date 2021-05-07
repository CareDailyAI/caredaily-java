package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPUserPropertyModel;
import com.peoplepowerco.virtuoso.util.PPUtil;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laghee on 5/22/16.
 */
public class PPSystemUserPropertyManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPSystemUserPropertyManager.class.getSimpleName();
    private static PPSystemUserPropertyManager instance = null;

    public final static String PROPERTY_USER_CURRENCY_CODE = "ppc.api.user-currencyCode";
    public final static String PROPERTY_USER_CURRENCY_COUNTRY = "ppc.api.user-currencyCountry";
    public final static String PROPERTY_USER_CURRENCY_SYMBOL = "ppc.api.user-currencySymbol";
    public final static String PROPERTY_USER_TEMPERATURE_SYMBOL = "ppc.api.user-temperature";

    public final static String PROPERTY_USER_NUMERIC_CODE = "ppc.api.numericCode";
    public final static String PROPERTY_USER_DURESS_CODE = "ppc.api.duressCode";
    public final static String PROPERTY_USER_TIME = "ppc.api.user-time";

    private List<PPUserPropertyModel> m_userPropertyList = null;

    /**
     * Hidden class constructor.
     */
    private PPSystemUserPropertyManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPSystemUserPropertyManager getInstance() {
        synchronized (PPSystemUserPropertyManager.class) {
            if (instance == null) {
                instance = new PPSystemUserPropertyManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_userPropertyList = new ArrayList<>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_userPropertyList.clear();
            instance.m_userPropertyList = null;
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
     * Get the list of userProperty...
     */
    public List<PPUserPropertyModel> getUserPropertyList() {
        return m_userPropertyList;
    }

    /**
     * Get the Value by name...
     */
    public String getUserPropertyValueByName(String name) {
        for (PPUserPropertyModel currentModel : m_userPropertyList) {
            if (currentModel.sName != null && currentModel.sName.contains(name)) {
                return currentModel.sValue;
            }
        }
        return null;
    }

    public void updateUserPropertyValueByName(String keyName, String value) {
        for (PPUserPropertyModel currentModel : m_userPropertyList) {
            if (currentModel.sName != null && currentModel.sName.contains(keyName)) {
                currentModel.sValue = value;
                break;
            }
        }
    }

    public String getUserPropertyValue(String propertyName) {
        for (PPUserPropertyModel userProperty : m_userPropertyList) {
            if (userProperty.sName.contains("ppc.api")) {
                if (userProperty.sName.equals("ppc.api." + propertyName)) {
                    return userProperty.sValue;
                }
            } else {
                if (userProperty.sName.equals(propertyName)) {
                    return userProperty.sValue;
                }
            }
        }
        return null;
    }

    /**
     * Get a list of values for names like...
     */
    public List<String> getUserPropertyValuesForNameLike(String name) {
        List<String> lstNames = new ArrayList<>(10);

        for (PPUserPropertyModel currentModel : m_userPropertyList) {
            if (currentModel.sName != null && currentModel.sName.contains(name)) {
                lstNames.add(currentModel.sValue);
            }
        }

        return lstNames;
    }

    /**
     * Refine a list of guest codes.
     */
    public List<String> getActiveGuestCodes() {
        List<String> lstCodes = new ArrayList<>(10);

        for (PPUserPropertyModel currentModel : m_userPropertyList) {
            if (currentModel.sName != null && currentModel.sName.contains("guestCode")) {
                String[] arrayValues = currentModel.sValue.split(",");

                //TODO validate that code is not expired
                lstCodes.add(arrayValues[0]);
            }
        }

        return lstCodes;
    }

    /**
     * https://app.presencepro.com/cloud/json/systemProperty/propertyName Get the system prop from server.
     */
    public void serverRequestGetSystemProperty(String tag, String systemPropertyName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("propertyName", systemPropertyName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SYSTEM_OR_USER_PROPERTY, jsonObj);
        PPVirtuosoLogTrace.d(TAG, "REQ_GET_SYSTEM_OR_USER_PROPERTY " + systemPropertyName);
    }

    /**
     * https://app.presencepro.com/cloud/json/systemProperty/propertyName Get the system prop from server.
     */
    public void serverRequestGetProperty(String tag, String systemPropertyName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("propertyName", systemPropertyName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SYSTEM_PROPERTY, jsonObj);
        PPVirtuosoLogTrace.d(TAG, "REQ_GET_SYSTEM_OR_USER_PROPERTY " + systemPropertyName);
    }

    /**
     * https://developer.presencepro.com/cloud/json/userProperties?propertyName=propertyName&userId=userId Get the user prop from server.
     */
    public void serverRequestUserProperty(String tag, String userPropertyName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_PROPERTIES, jsonObj, m_userPropertyList);
        PPVirtuosoLogTrace.d(TAG, "REQ_GET_USER_PROPERTIES " + userPropertyName);
    }

    /**
     * https://developer.presencepro.com/cloud/json/userProperties?propertyName=propertyName&userId=userId Get the user prop from server.
     */
    public void serverRequestUserProperties(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_PROPERTIES, jsonObj, m_userPropertyList);
        PPVirtuosoLogTrace.d(TAG, "REQ_GET_USER_PROPERTIES ");
    }

    /**
     * https://developer.peoplepowerco.com/docs/?q=cloud/systemProperty Put the system prop from server.
     */
    public void serverRequestPutUserProperty(String tag, String userPropertyName, String userPropertyValue) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("propertyName", userPropertyName);
            if (!PPUtil.isEmpty(userPropertyValue)) {
                jsonObj.put("value", userPropertyValue.replace("\n", ""));
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_USER_PROPERTY, jsonObj);
        PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_USER_PROPERTY " + userPropertyName + ", " + userPropertyValue);
    }

//    /**
//     * Update user property information
//     */
//    public void requestPutUserPropertyCode(String tag, String sCode, String sPropertyName)
//    {
//        JSONObject jsonObj = new JSONObject();
//        try {
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
//            jsonObj.put("property_name", sPropertyName);
//            jsonObj.put("property_value", sCode.replace("\n", ""));
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
////        m_CloudCommander.PutDataThreadPool(REQ_PUT_CURRENCY_CODE, jsonObj);
//    }

//    /* SYSTEM AND USER PROPERTIES */
//    // https://app.presencepro.com/cloud/json/systemProperty/propertyName
//    public static final short REQ_GET_SYSTEM_OR_USER_PROPERTY               = 200;
//
//    // https://app.presencepro.com/cloud/json/userProperties?propertyName=propertyName&userId=userId
//    public static final short REQ_GET_USER_PROPERTIES                       = 201;
//
//    // https://app.presencepro.com/cloud/json/userProperties?userId=userId
//    public static final short REQ_POST_UPDATE_USER_PROPERTIES               = 202;
//
//    // https://app.presencepro.com/cloud/json/userProperty/propertyName?propertyValue=propertyValue
//    public static final short REQ_PUT_UPDATE_USER_PROPERTY                  = 203;
}
