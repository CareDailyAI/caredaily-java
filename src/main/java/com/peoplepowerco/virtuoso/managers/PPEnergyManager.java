package com.peoplepowerco.virtuoso.managers;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;

/**
 * Created by laghee on 5/22/16.
 */
public class PPEnergyManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPEnergyManager.class.getSimpleName();
    private static PPEnergyManager instance = null;

    /**
     * Hidden class constructor.
     */
    private PPEnergyManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     * @return
     */
    public static PPEnergyManager getInstance() {
        synchronized(PPEnergyManager.class) {
            if (instance == null) {
                instance = new PPEnergyManager();
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

//    /* ENERGY MANAGEMENT */
//    // https://app.presencepro.com/cloud/json/locations/locationId/energyUsage/aggregation/startDate?endDate=endDate&external=external
//    public static final short REQ_GET_LOCATION_ENERGY_USAGE                 = 250;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/billData
//    public static final short REQ_POST_UPLOAD_LOCATION_UTILITY_BILLS        = 251;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/bills/billId
//    public static final short REQ_DELETE_UTILITY_BILL                       = 252;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/currentEnergyUsage?index=index&locationId=locationId&userId=userId
//    public static final short REQ_GET_DEVICE_ENERGY_USAGE                   = 253;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/energyUsage/aggregation/startDate?endDate=endDate&reduceNoise=reduceNoise&locationId=locationId&userId=userId
//    public static final short REQ_GET_AGGREGATED_DEVICE_ENERGY_USAGE        = 254;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/billing/filter
//    public static final short REQ_GET_BILLING_INFORMATION                   = 255;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/billing
//    public static final short REQ_PUT_UPDATE_BILLING_INFORMATION            = 256;
}
