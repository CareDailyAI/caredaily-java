package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPBeaconModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppAccessesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppDeviceTypesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppInstanceModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by edwardliu on 2017/7/11.
 */

public class PPAppInstanceManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static PPAppInstanceManager instance = null;

    private Set<String> m_dataStreams;
    private Set<String> m_microServices;
    private ArrayList<PPAppInstanceModel> m_appInstanceArrayList;
    private ArrayList<PPAppAccessesModel> m_accessArrayList;
    private ArrayList<PPAppDeviceTypesModel> m_deviceTypesArrayList;

    public static final int PPComposerAppInstanceDataStreamBitmaskUndefined = 0;
    public static final int PPComposerAppInstanceDataStreamBitmaskInvdividual = 1 << 0;
    public static final int PPComposerAppInstanceDataStreamBitmaskOrganizational = 1 << 1;

    /**
     * Hidden class constructor.
     */
    private PPAppInstanceManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPAppInstanceManager getInstance() {
        synchronized (PPAppInstanceManager.class) {
            if (instance == null) {
                instance = new PPAppInstanceManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_dataStreams = new HashSet<>();
        m_microServices = new HashSet<>();
        m_appInstanceArrayList = new ArrayList<>();
        m_accessArrayList = new ArrayList<>();
        m_deviceTypesArrayList = new ArrayList<>();
    }

    public List<PPAppInstanceModel> getAppInstanceArrayList() {
        return m_appInstanceArrayList;
    }

    public List<PPAppAccessesModel> getAppAccessArrayList() {
        return m_accessArrayList;
    }

    public List<PPAppDeviceTypesModel> getAppDeviceTypeArrayList() {
        return m_deviceTypesArrayList;
    }

    public PPAppInstanceModel findAppInstanceByBundle(String bundle) {
        if (null == m_appInstanceArrayList || m_appInstanceArrayList.isEmpty()) {
            return null;
        }
        for (PPAppInstanceModel instanceModel : m_appInstanceArrayList) {
            if (null != instanceModel.bundle && instanceModel.bundle.equals(bundle)) {
                return instanceModel;
            }
        }
        return null;
    }

    public PPAppDeviceTypesModel findDeviceTypeById(int deviceType) {
        if (null != m_deviceTypesArrayList) {
            for (PPAppDeviceTypesModel model : m_deviceTypesArrayList) {
                if (model.id == deviceType) {
                    return model;
                }
            }
        }
        return null;
    }

    public boolean containDataStream(String dataStream) {
        return m_dataStreams.contains(dataStream);
    }

    /**
     * Get app information from server
     */
    public void serverRequestGetAppInformation(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_APP_INFORMATION, jsonObj, new Object[]{m_accessArrayList, m_deviceTypesArrayList});
    }

    /**
     * Get app instance from server
     */
    public void serverRequestGetAppInstance(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_APP_INSTANCE, jsonObj, new Object[]{m_appInstanceArrayList});
    }

    public void serverRequestGetPresenceIds(String tag, List<String> uuids) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_PRESENCE_IDS, jsonObj, uuids);
    }

    public void serverRequestPostAuthAccess(String tag, String uuid, String major, String minor, int rssi) {
        String data = String.format("{\"paramsMap\": {\"ibeaconUuid\":\"%s\", \"ibeaconMajor\":\"%s\", \"ibeaconMinor\":\"%s\"}}"
            , uuid, major, minor);
        PPBeaconModel model = new PPBeaconModel(uuid, major, minor, rssi);
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_AUTH_ACCESS, jsonObj, model);
    }

    public void serverRequestConfigureAppInstance(String tag, int instanceId, int status, String appAccessStr) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            if (status != PPCommonInfo.PPComposerAppInstanceStatusUndefined) {
                jsonObj.put("status", status);
            }
            if (0 != instanceId) {
                jsonObj.put("appInstanceId", instanceId);
            }
            if (null != appAccessStr) {
                jsonObj.put("app", appAccessStr);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_CONFIGURE_APP_INSTANCE, jsonObj);
    }

    public void serverRequestPurchaseAppInstance(String tag, String bundleId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("bundle", bundleId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_PURCHASE_APP_INSTANCE, jsonObj);
    }

    public void serverRequestGetBotSummary(String tag, String locationId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", locationId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_BOT_SUMMARY, jsonObj, new Object[]{m_dataStreams, m_microServices});
    }

    public void serverRequestPostDataStreamWithBitmask(String tag, int dataStreamBitmask, String address, String data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("address", address);
            jsonObj.put("data", data);
            if (dataStreamBitmask != PPComposerAppInstanceDataStreamBitmaskUndefined) {
                jsonObj.put("organizational", String.valueOf(dataStreamBitmask));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_DATA_STREAM_WITH_MASK, jsonObj);
    }

    public void serverRequestPostDataStreamWithBitmask(String tag, int scope, String address, String locationId,
        String organizationId, String data) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("TAG", tag);
        jsonObj.put("address", address);
        if (scope != PPComposerAppInstanceDataStreamBitmaskUndefined) {
            jsonObj.put("scope", String.valueOf(scope));
        }
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        if (null != organizationId) {
            jsonObj.put("organizationId", organizationId);
        }
        jsonObj.put("data", data);
        m_CloudCommander.PostDataThreadPool(REQ_POST_DATA_STREAM_WITH_MASK, jsonObj);
    }

    public void serverRequestPostDataStreamWithBitmask(String tag, boolean isEnter, int scope, String address, String locationId,
        String organizationId, String data) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("TAG", tag);
        jsonObj.put("address", address);
        if (scope != PPComposerAppInstanceDataStreamBitmaskUndefined) {
            jsonObj.put("scope", String.valueOf(scope));
        }
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        if (null != organizationId) {
            jsonObj.put("organizationId", organizationId);
        }
        jsonObj.put("data", data);
        m_CloudCommander.PostDataThreadPool(isEnter ? REQ_POST_DATA_STREAM_WITH_MASK : REQ_POST_DATA_STREAM_WITH_MASK_FALSE, jsonObj);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }
}
