package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPCallCenterAlertsDeviceModel;
import com.peoplepowerco.virtuoso.models.PPCallCenterContactsModel;
import com.peoplepowerco.virtuoso.models.PPCallCenterModel;

import java.util.ArrayList;

/**
 * @author : James Cho
 * @brief :
 * @date : 2016. 6. 14.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPCallCenterManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPCallCenterManager.class.getSimpleName();
    private static PPCallCenterManager instance = null;

    private PPCallCenterModel m_callCenterModel = null;
    private static ArrayList<PPCallCenterModel> m_callCenterUpdateList = null;
    private static ArrayList<PPCallCenterAlertsDeviceModel> m_callCenterAlertDeviceList = null;
    //Call Center Registration Status
    public final int CallCenterRegistrationStatusUnavailable = 0;
    public final int CallCenterRegistrationStatusAvailable = 1;
    public final int CallCenterRegistrationStatusRegistrationPending = 2;
    public final int CallCenterRegistrationStatusRegistered = 3;
    public final int CallCenterRegistrationStatusCancellationPending = 4;
    public final int CallCenterRegistrationStatusCancelled = 5;
    //Call Center Alert Status
    public final int CallCenterAlertStatusDefault = 0;
    public final int CallCenterAlertStatusRaised = 1;
    public final int CallCenterAlertStatusCancelled = 2;
    public final int CallCenterAlertStatusReported = 3;


    private PPCallCenterManager() {
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
    public static PPCallCenterManager getInstance() {
        synchronized (PPCallCenterManager.class) {
            if (instance == null) {
                instance = new PPCallCenterManager();
            }
        }
        return instance;
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    private void init() {
        init(this);
        m_callCenterModel = new PPCallCenterModel();
        m_callCenterUpdateList = new ArrayList<>();
        m_callCenterAlertDeviceList = new ArrayList<>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_callCenterModel = null;
            instance.m_callCenterUpdateList.clear();
            instance.m_callCenterUpdateList = null;
            instance.m_callCenterAlertDeviceList.clear();
            instance.m_callCenterAlertDeviceList = null;
            instance = null;
        }
    }

    /**
     * Request CALL CENTER
     */
    public void serverRequestGetCallCenter(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_CALL_CENTER, jsonObj, new Object[]{m_callCenterModel});
    }

    /**
     * UPDATE CALL CENTER
     */
    public void serverRequestUpdateCallCenter(String tag, JSONObject jsonObjCallCenter) {
        try {
            jsonObjCallCenter.put("TAG", tag);
            jsonObjCallCenter.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_CALL_CENTER, jsonObjCallCenter);
    }

    public void serverRequestDeleteCallCenter(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_CALL_CENTER, jsonObj);
    }

    /**
     * GET CALL CENTER ALERT DEVICE
     */
    public void serverRequestGetCallCenterAlertDevice(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_CALL_CENTER_ALERTS, jsonObj, m_callCenterAlertDeviceList);
    }

    /**
     * Gets the current list of call center.
     */
    public PPCallCenterModel getCallCenterModel() {
        return m_callCenterModel;
    }

    public int getCallTreeCount() {
        int count = 0;
        ArrayList<PPCallCenterContactsModel> contacts = m_callCenterModel.getCallCenterContactsModelArrayList();
        if (null != contacts && !contacts.isEmpty()) {
            count += contacts.size();
        }
        return count;
    }

    /**
     * Gets the current list of call center alert device
     */
    public ArrayList<PPCallCenterAlertsDeviceModel> getCallCenterAlertDeviceList() {
        return m_callCenterAlertDeviceList;
    }

    /**
     * Gets the current list of call center alert device
     */
    public ArrayList<PPCallCenterModel> getCallCenterUpdateList() {
        return m_callCenterUpdateList;
    }
}
