/**
 * @FileName : PPCloudManager.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPConnectionSettingsModel;
import com.peoplepowerco.virtuoso.models.PPGetServerModel;
import com.peoplepowerco.virtuoso.models.PPServerInformationModel;
import com.peoplepowerco.virtuoso.util.PPUtil;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.util.ArrayList;
import java.util.List;

/**
 * Manager to handle clouds:
 * 1. Availability
 * 2. Types
 */
public class PPCloudManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPCloudManager.class.getSimpleName();
    private static PPCloudManager instance = null;

    private List<PPConnectionSettingsModel> m_HostList = null;
    private PPGetServerModel m_ServerModel = null;

    private String m_sHost = null;
    private String m_sHostDeviceIo = null;
    private String m_sPortDeviceIo = null;
    private String m_sHostWebApp = null;
    private String m_sPortWebApp = null;
    private boolean m_bSSLDeviceIo = false;
    private boolean m_bSSLWebApp = false;
    private String m_sHostStreaming = null;
    private String m_sPortStreaming = null;
    private boolean m_bSSLStreaming = false;

    /**
     * Hidden class constructor.
     */
    private PPCloudManager() {
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
    public static PPCloudManager getInstance() {
        synchronized (PPCloudManager.class) {
            if (instance == null) {
                instance = new PPCloudManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_HostList = new ArrayList<>();
        m_ServerModel = new PPGetServerModel();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_HostList.clear();
            instance.m_HostList = null;
            instance.m_ServerModel = null;
            instance = null;
        }
    }

    public List<PPConnectionSettingsModel> getConnectionList() {
        return m_HostList;
    }

    public PPGetServerModel getServerModel() {
        return m_ServerModel;
    }

    /**
     * Check server availability...
     * https:/<cloud>/espapi/watch
     */
    public void serverRequestGetCheckAvailability(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_CHECK_AVAILABILITY, jsonObj);
    }

    /**
     * Get selected cloud settings...
     * https://<cloud>/cloud/json/settings?deviceId=deviceId&version=version
     *
     * @param deviceid
     * @param version
     */
    public void serverRequestGetCloudSettings(String tag, String deviceid, String version) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("deviceId", deviceid);
            if (null != version) {
                jsonObj.put("version", version);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (m_HostList != null && m_HostList.size() > 0) {
            m_HostList.clear();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_CLOUD_SETTINGS, jsonObj, m_HostList);
    }

    public void serverRequestGetCloudSettings(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_CLOUD_SETTINGS, jsonObj, m_HostList);
    }

    /**
     * Get a specific server URL based on type...
     * https://<cloud>/cloud/json/settingsServer?type=type&deviceId=deviceId&ssl=ssl&version=version
     *
     * @param deviceid
     * @param version
     * @param ssl
     * @param type
     */
    public void serverRequestGetServerURL(String tag, String deviceid, String version, String ssl, String type) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("deviceId", deviceid);
            jsonObj.put("version", version);
            jsonObj.put("ssl", ssl);
            jsonObj.put("type", type);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_SERVER_URL, jsonObj);
    }

    /**
     * Get a specific server based on type...
     * GEThttps://app.presencepro.com/cloud/json/settingsServer/type?deviceId=&connected=&version=&brand=&appName=
     *
     * @param type
     * @param deviceid
     * @param connected
     * @param version
     * @param brand
     * @param appName
     */
    public void serverRequestGetServer(String tag, String type, String deviceid, String connected, String version, String brand, String appName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("type", type);
            jsonObj.put("deviceId", deviceid);
            jsonObj.put("connected", connected);
            jsonObj.put("version", version);
            jsonObj.put("brand", brand);
            jsonObj.put("appName", appName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_SERVER, jsonObj, m_ServerModel);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        switch (reqid) {
            case REQ_GET_CLOUD_SETTINGS:
                PPVirtuosoLogTrace.d(TAG, "GET SERVER URL ================ " + PPAppCenter.getServerUrl());
                //First server item is selected server item.(If there a better way to get selected server item, it should be changed.)
                boolean bSetWebapp = false;
                for (PPServerInformationModel currServerInfo : m_HostList.get(0).serverInfoList) {
                    if (currServerInfo.getType().equals("deviceio")) {
                        if (currServerInfo.getSsl().equalsIgnoreCase("true")) {
                            setDeviceIoSSL(true);
                            setHostDeviceIo("https://" + currServerInfo.getHost());
                        } else {
                            setDeviceIoSSL(false);
                            setHostDeviceIo("http://" + currServerInfo.getHost());
                        }
                        setPortDeviceIo(currServerInfo.getPort());
                        PPAppCenter.m_SharedPresence.setDeviceCommunicationHost(m_sHostDeviceIo);
                        PPAppCenter.m_SharedPresence.setDeviceCommunicationPort(m_sPortDeviceIo);
                        PPAppCenter.m_SharedPresence.setDeviceCommunicationSSL(currServerInfo.getSsl());

                        PPVirtuosoLogTrace.d(TAG, "device io,  sHostName = " + m_sHostDeviceIo);
                        PPVirtuosoLogTrace.d(TAG, "device io,  sPortNum = " + m_sPortDeviceIo);
                        PPVirtuosoLogTrace.d(TAG, "device io,  sSSL = " + m_bSSLDeviceIo);
                    }

                    if (currServerInfo.getType().equals("streaming")) {
                        if (currServerInfo.getSsl().equalsIgnoreCase("true")) {
                            setStreamingSSL(true);
                            setHostStreaming("https://" + currServerInfo.getHost());
                        } else {
                            setStreamingSSL(false);
                            setHostStreaming("http://" + currServerInfo.getHost());
                        }
                        setPortStreaming(currServerInfo.getPort());
                        PPVirtuosoLogTrace.d(TAG, "Streaming,  HostStreaming = " + m_sHostStreaming);
                        PPVirtuosoLogTrace.d(TAG, "Streaming,  PortStreaming  = " + m_sPortStreaming);
                        PPVirtuosoLogTrace.d(TAG, "Streaming,  SSLStreaming  = " + m_bSSLStreaming);
                    }

                    if (currServerInfo.getType().equals("webapp") && !bSetWebapp) {
                        if (!PPUtil.isEmpty(currServerInfo.getBrand())) {
                            if (currServerInfo.getBrand().equals(PPAppCenter.BRAND_NAME)) {
                                if (currServerInfo.getSsl().equalsIgnoreCase("true")) {
                                    setWebAppSSL(true);
                                    setHostWebApp("https://" + currServerInfo.getHost());
                                } else {
                                    setWebAppSSL(false);
                                    setHostWebApp("http://" + currServerInfo.getHost());
                                }
                                setPortWebApp(currServerInfo.getPort());
                                PPAppCenter.m_SharedPresence.setWebAppCommunicationHost(m_sHostWebApp);
                                PPAppCenter.m_SharedPresence.setWebAppCommunicationPort(m_sPortWebApp);
                                PPAppCenter.m_SharedPresence.setWebAppCommunicationSSL(currServerInfo.getSsl());

                                PPVirtuosoLogTrace.d(TAG, "webapp,  sHostName = " + m_sHostWebApp);
                                PPVirtuosoLogTrace.d(TAG, "webapp,  sPortNum = " + m_sPortWebApp);
                                PPVirtuosoLogTrace.d(TAG, "webapp,  sSSL = " + m_bSSLWebApp);
                                bSetWebapp = true;
                            }
                        }
                    }
                }
                break;
            default:
                break;
        }
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    /**
     * Get the Ensemble host address...
     * NOTE: This is set elsewhere and should not be set here!
     *
     * @return
     */
    public String getHost() {
        if (m_sHost == null) {
            m_sHost = PPAppCenter.m_SharedPresence.getServerCommunicationURL();
        }
        return m_sHost;
    }

//    public void setHost(String host) {
//        m_sHost = host;
//    }

    public boolean isDeviceIoSSL() {
        return m_bSSLDeviceIo;
    }

    public void setDeviceIoSSL(boolean ssl) {
        m_bSSLDeviceIo = ssl;
    }

    public boolean isWebAppSSL() {
        return m_bSSLWebApp;
    }

    public void setWebAppSSL(boolean ssl) {
        m_bSSLWebApp = ssl;
    }

    public boolean isStreamingSSL() {
        return m_bSSLStreaming;
    }

    public void setStreamingSSL(boolean ssl) {
        m_bSSLStreaming = ssl;
    }

    public String getHostDeviceIo() {
        if (m_sHostDeviceIo == null) {
            m_sHostDeviceIo = PPAppCenter.m_SharedPresence.getDeviceCommunicationHost();
        }
        return m_sHostDeviceIo;
    }

    public void setHostDeviceIo(String hostdeviceio) {
        m_sHostDeviceIo = hostdeviceio;
        PPAppCenter.m_SharedPresence.setDeviceCommunicationHost(m_sHostDeviceIo);
    }

    public String getHostWebApp() {
        if (m_sHostWebApp == null) {
            m_sHostWebApp = PPAppCenter.m_SharedPresence.getWebAppsCommunicationHost();
        }
        return m_sHostWebApp;
    }

    public void setHostWebApp(String hostWebApp) {
        m_sHostWebApp = hostWebApp;
        PPAppCenter.m_SharedPresence.setWebAppCommunicationHost(m_sHostWebApp);
    }

    public String getPortDeviceIo() {
        if (m_sPortDeviceIo == null) {
            m_sPortDeviceIo = PPAppCenter.m_SharedPresence.getDeviceCommunicationPort();
        }
        return m_sPortDeviceIo;
    }

    public void setPortDeviceIo(String portdeviceio) {
        m_sPortDeviceIo = portdeviceio;
        PPAppCenter.m_SharedPresence.setDeviceCommunicationPort(m_sPortDeviceIo);
    }

    public String getPortWebApp() {
        if (m_sPortWebApp == null) {
            m_sPortWebApp = PPAppCenter.m_SharedPresence.getWebAppCommunicationPort();
        }
        return m_sPortWebApp;
    }

    public void setPortWebApp(String portwebapp) {
        m_sPortWebApp = portwebapp;
        PPAppCenter.m_SharedPresence.setWebAppCommunicationPort(m_sPortWebApp);
    }

    public String getHostStreaming() {
        return m_sHostStreaming;
    }

    public void setHostStreaming(String hoststreaming) {
        m_sHostStreaming = hoststreaming;
    }

    public String getPortStreaming() {
        return m_sPortStreaming;
    }

    public void setPortStreaming(String portstreaming) {
        m_sPortStreaming = portstreaming;
    }

//    /**
//     *  Handler for management of server communication.
//     */
//    private static class CloudServerCommunicationHandler extends PPWeakHandler<PPCloudManager> {
//
//        public CloudServerCommunicationHandler(PPCloudManager owner) {
//            super(owner);
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            PPCloudManager owner = getTheOwner();
//            switch(msg.what) {
//                case REQ_GET_CHECK_AVAILABILITY:
//                case REQ_GET_CLOUD_SETTINGS:
//                case REQ_GET_SERVER_URL:
//                case REQ_GET_LOGIN_USERNAME:
//                case REQ_GET_LOGIN_KEY:
//                case REQ_GET_LOGOUT:
//                    for(Handler listener : owner.m_Handlers) {
//                        listener.obtainMessage(msg.what, msg.arg1, msg.arg2, msg.obj).sendToTarget();
//                    }
//                    break;
//                default:
//                    PPVirtuosoLogTrace.e(TAG, "Unknown message in CLOUD server communications handler.");
//                    break;
//            }
//        }
//    }
}
