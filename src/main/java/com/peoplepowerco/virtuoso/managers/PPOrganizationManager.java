package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPOrganizationObjectModel;
import java.util.HashMap;

/**
 * Created by edwardliu on 2020/10/16.
 */

public class PPOrganizationManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPOrganizationManager.class.getSimpleName();
    private static PPOrganizationManager instance = null;

    private PPOrganizationManager() {
        init();
    }

    private void init() {
        init(this);
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPOrganizationManager getInstance() {
        synchronized (PPOrganizationManager.class) {
            if (instance == null) {
                instance = new PPOrganizationManager();
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

    public void getOrganizationProperties(String tag, String organizationId, HashMap<String, PPOrganizationObjectModel> datas) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("organizationId", organizationId);
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_ORGANIZATION_PROPERTIES, jsonObj, datas);
    }

    public void getOrganizationObjectContent(String tag, String organizationId, String objectName) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("organizationId", organizationId);
        jsonObj.put("objectName", objectName);
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_ORGANIZATION_OBJECT_CONTENT, jsonObj);
    }

    public void addLocationToOrganization(String tag, String organizationId) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("organizationId", organizationId);
        jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        jsonObj.put("TAG", tag);
        m_CloudCommander.PutDataThreadPool(REQ_PUT_ADD_LOCATION, jsonObj);
    }

    public void moveLocationToOrganization(String tag, String domainName) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("domainName", domainName);
        jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        jsonObj.put("TAG", tag);
        m_CloudCommander.PutDataThreadPool(REQ_PUT_MOVE_LOCATION, jsonObj);
    }
}
