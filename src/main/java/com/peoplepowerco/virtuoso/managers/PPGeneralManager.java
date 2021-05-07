package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPCountryInfoModel;
import com.peoplepowerco.virtuoso.models.PPMarketProductModel;
import com.peoplepowerco.virtuoso.models.PPThirdpartyApplicationsModel;

import java.util.ArrayList;

/**
 * Created by laghee on 5/22/16.
 */
public class PPGeneralManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPGeneralManager.class.getSimpleName();
    private static PPGeneralManager instance = null;
    private ArrayList<PPThirdpartyApplicationsModel> m_ThirdPartyApplicationsArrayList = null;
    private ArrayList<PPCountryInfoModel> m_CountryInfoList = null;
    private ArrayList<PPMarketProductModel> m_productArrayList;

    /**
     * Hidden class constructor.
     */
    private PPGeneralManager() {
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
    public static PPGeneralManager getInstance() {
        synchronized (PPGeneralManager.class) {
            if (instance == null) {
                instance = new PPGeneralManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_ThirdPartyApplicationsArrayList = new ArrayList<PPThirdpartyApplicationsModel>();
        m_CountryInfoList = new ArrayList<PPCountryInfoModel>();
        m_productArrayList = new ArrayList<PPMarketProductModel>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_ThirdPartyApplicationsArrayList.clear();
            instance.m_ThirdPartyApplicationsArrayList = null;
            instance.m_CountryInfoList.clear();
            instance.m_CountryInfoList = null;
            instance.m_productArrayList.clear();
            instance.m_productArrayList = null;
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
     * Request third party application information from server
     */
    public void requestGetThirdPartyApplication(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_THIRD_PARTY_APPS, jsonObj, new Object[]{m_ThirdPartyApplicationsArrayList});
    }

    public ArrayList<PPThirdpartyApplicationsModel> getThirdPartyApplicationsAList() {
        return m_ThirdPartyApplicationsArrayList;
    }

    /**
     * Get country information
     */
    public void requestGetCountryInformation(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CountryInfoList.clear();
        m_CloudCommander.GetDataThreadPool(REQ_GET_COUNTRIES_STATES_TIME_ZONES, jsonObj, new Object[]{m_CountryInfoList});
    }

    public ArrayList<PPCountryInfoModel> getCountryInfoList() {
        return m_CountryInfoList;
    }

    /**
     * Request market information
     */
    public void requestServerForMarketInfo(String tag, String strAppName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("appName", strAppName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (m_productArrayList != null) {
            m_productArrayList.clear();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_STORE_PRODUCTS, jsonObj, new Object[]{m_productArrayList});
        //User can dismiss loading wheel dialog only back key
    }

    public ArrayList<PPMarketProductModel> getMarketInfo() {
        return m_productArrayList;
    }


//    /* DYNAMIC USER INTERFACES */
//    // https://app.presencepro.com/cloud/json/uiscreens/appName?version=version
//    public static final short REQ_GET_UI_SCREENS                            = 245;

//    /* REPORTS */
//    // https://app.presencepro.com/espapi/report/json/totalDeviceAlerts?alertType=alertType
//    public static final short REQ_GET_TOTAL_DEVICE_ALERTS                   = 300;
}
