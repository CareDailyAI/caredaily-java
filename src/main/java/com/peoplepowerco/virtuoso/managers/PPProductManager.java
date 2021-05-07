package com.peoplepowerco.virtuoso.managers;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;

/**
 * Created by laghee on 5/22/16.
 */
public class PPProductManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPProductManager.class.getSimpleName();
    private static PPProductManager instance = null;

    /**
     * Hidden class constructor.
     */
    private PPProductManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     * @return
     */
    public static PPProductManager getInstance() {
        synchronized(PPProductManager.class) {
            if (instance == null) {
                instance = new PPProductManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if(instance != null) {
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

//    /* CREATING PRODUCTS */
//    // https://app.presencepro.com/cloud/json/deviceTypes?deviceType=deviceType&attrName=attrName&attrValue=attrValue&own=own&simple=simple&organizationId=organizationId
//    public static final short REQ_GET_SUPPORTED_PRODUCTS                    = 260;
//
//    // https://app.presencepro.com/cloud/json/deviceTypeAttrs
//    public static final short REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES          = 261;
//
//    // https://app.presencepro.com/cloud/json/deviceType
//    public static final short REQ_POST_CREATE_PRODUCT                       = 262;
//
//    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId
//    public static final short REQ_POST_UPDATE_PRODUCT                       = 263;
//
//    // https://app.presencepro.com/cloud/json/deviceParameters?paramName=paramName
//    public static final short REQ_GET_PRODUCT_PARAMETERS                    = 264;
//
//    // https://app.presencepro.com/cloud/json/deviceParameters
//    public static final short REQ_POST_CREATE_OR_UPDATE_PRODUCT_PARAMETERS  = 265;
//
//    // https://app.presencepro.com/cloud/json/deviceParameters/parameterName
//    public static final short REQ_DELETE_PRODUCT_PARAMETER                  = 266;
//
//    // https://app.presencepro.com/cloud/json/ruleTemplates
//    public static final short REQ_GET_PRODUCT_RULE_PHRASE                   = 267;
//
//    // https://app.presencepro.com/cloud/json/ruleTemplates
//    public static final short REQ_POST_CREATE_PRODUCT_RULE_PHRASE           = 268;
//
//    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//    public static final short REQ_GET_PRODUCT_RULE_PHRASE_BY_ID             = 269;
//
//    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//    public static final short REQ_PUT_UPDATE_PRODUCT_RULE_PHRASE            = 270;
//
//    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//    public static final short REQ_DELETE_PRODUCT_RULE_PHRASE                = 271;
//
//    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules?details=details
//    public static final short REQ_GET_PRODUCT_DEFAULT_RULES                 = 272;
//
//    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId?hidden=hidden
//    public static final short REQ_POST_PRODUCT_DEFAULT_RULE                 = 273;
//
//    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId
//    public static final short REQ_DELETE_PRODUCT_DEFAULT_RULE               = 274;
//
//    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/goals
//    public static final short REQ_GET_DEVICE_GOALS_BY_TYPE                  = 275;
//
//    // https://app.presencepro.com/cloud/json/goals/goalId/installation
//    public static final short REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS      = 276;
//
//    // https://app.presencepro.com/cloud/json/hardwareOrders?userId=userId
//    public static final short REQ_GET_HARDWARE_ORDERS                       = 277;
//
//    // https://app.presencepro.com/cloud/json/hardwareOrders/orderId/status/status?userId=userId&changeDate=changeDate
//    public static final short REQ_PUT_SET_HARDWARE_ORDERS                   = 278;
}
