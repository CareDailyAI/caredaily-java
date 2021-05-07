/**
 * @FileName : PPEnsembleTask.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.network;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.models.PPBeaconModel;
import com.peoplepowerco.virtuoso.parser.PPAccountUserParser;
import com.peoplepowerco.virtuoso.parser.PPAddDeviceJsonParser;
import com.peoplepowerco.virtuoso.parser.PPAggregatedFileListJsonParser;
import com.peoplepowerco.virtuoso.parser.PPAppInformationParser;
import com.peoplepowerco.virtuoso.parser.PPAppInstanceParser;
import com.peoplepowerco.virtuoso.parser.PPAppPresenceIdsParser;
import com.peoplepowerco.virtuoso.parser.PPApplicationFileParser;
import com.peoplepowerco.virtuoso.parser.PPBaseJsonParser;
import com.peoplepowerco.virtuoso.parser.PPBillingInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPBotSummaryParser;
import com.peoplepowerco.virtuoso.parser.PPCallCenterAlertJsonParser;
import com.peoplepowerco.virtuoso.parser.PPCallCenterJsonParser;
import com.peoplepowerco.virtuoso.parser.PPCommunityPostJsonParser;
import com.peoplepowerco.virtuoso.parser.PPConnectionSettingsJsonParser;
import com.peoplepowerco.virtuoso.parser.PPCountryInfoParser;
import com.peoplepowerco.virtuoso.parser.PPCurrentEnergyUsageJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceActivationInformationJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceFAQParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceFileInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceGoalParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceInfoSeparatorParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceInstallationJsonPaser;
import com.peoplepowerco.virtuoso.parser.PPDeviceMeasurementJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceParameterJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDevicePropertyJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceRegistrationJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceSimpleListJsonParser;
import com.peoplepowerco.virtuoso.parser.PPDeviceUploadJsonParser;
import com.peoplepowerco.virtuoso.parser.PPFirmwareJobsJsonParser;
import com.peoplepowerco.virtuoso.parser.PPFriendInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPFriendProspectJsonParser;
import com.peoplepowerco.virtuoso.parser.PPGatewayRegistrationJsonParser;
import com.peoplepowerco.virtuoso.parser.PPGetDeviceModelByTypeParser;
import com.peoplepowerco.virtuoso.parser.PPGetDeviceModelParser;
import com.peoplepowerco.virtuoso.parser.PPGetLocationSpaceParser;
import com.peoplepowerco.virtuoso.parser.PPGetPostFileUrlParser;
import com.peoplepowerco.virtuoso.parser.PPGetServerJsonParser;
import com.peoplepowerco.virtuoso.parser.PPGetStoryModelParser;
import com.peoplepowerco.virtuoso.parser.PPLocationDashboardParser;
import com.peoplepowerco.virtuoso.parser.PPLocationParser;
import com.peoplepowerco.virtuoso.parser.PPLocationServicePlanParser;
import com.peoplepowerco.virtuoso.parser.PPLocationSpaceUpdateParser;
import com.peoplepowerco.virtuoso.parser.PPLocationStateParser;
import com.peoplepowerco.virtuoso.parser.PPLocationUserFilteredParser;
import com.peoplepowerco.virtuoso.parser.PPLocationUserParser;
import com.peoplepowerco.virtuoso.parser.PPLocationUserSupportTaskParser;
import com.peoplepowerco.virtuoso.parser.PPLoginJsonParser;
import com.peoplepowerco.virtuoso.parser.PPLoginbyKeyJsonParser;
import com.peoplepowerco.virtuoso.parser.PPMarketProductJsonParser;
import com.peoplepowerco.virtuoso.parser.PPNarrativeQuestionsParser;
import com.peoplepowerco.virtuoso.parser.PPNarrativesParser;
import com.peoplepowerco.virtuoso.parser.PPNotificationJsonParser;
import com.peoplepowerco.virtuoso.parser.PPNotificationSubscriptionsParser;
import com.peoplepowerco.virtuoso.parser.PPOperationTokenJsonParser;
import com.peoplepowerco.virtuoso.parser.PPOrganizationPropertiesParser;
import com.peoplepowerco.virtuoso.parser.PPParameterDisplayInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPPostUploadFileParser;
import com.peoplepowerco.virtuoso.parser.PPQuestionParser;
import com.peoplepowerco.virtuoso.parser.PPQuestionsParser;
import com.peoplepowerco.virtuoso.parser.PPQuestionsSimpleParser;
import com.peoplepowerco.virtuoso.parser.PPRegisterJsonParser;
import com.peoplepowerco.virtuoso.parser.PPRuleGetConditionJsonParser;
import com.peoplepowerco.virtuoso.parser.PPRuleGetListJsonParser;
import com.peoplepowerco.virtuoso.parser.PPSMSSubscriberJsonParser;
import com.peoplepowerco.virtuoso.parser.PPSceneChangeInfoParser;
import com.peoplepowerco.virtuoso.parser.PPServicePlanJsonParser;
import com.peoplepowerco.virtuoso.parser.PPStreamingInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPSurveyQuestionsParser;
import com.peoplepowerco.virtuoso.parser.PPTermsOfServiceJsonParser;
import com.peoplepowerco.virtuoso.parser.PPThirdpartyApplicationsJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUIScreenJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserCodeParser;
import com.peoplepowerco.virtuoso.parser.PPUserInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserInformationJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserLocationEventJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserPropertyJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserRefreshInfoJsonParser;
import com.peoplepowerco.virtuoso.parser.PPUserTotalsJsonParser;
import com.peoplepowerco.virtuoso.sqlite.JSON.JSONColumn;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Set;
import java.util.Vector;

/**
 * Ensemble call wrappred inside an Android AsyncTask.
 */
public class PPEnsembleTask extends AsyncTask<Void, Object, Message> implements IPPVirtuosoTypes {

    private static final String TAG = PPEnsembleTask.class.getSimpleName();
    public int m_nReqID;
    public JSONObject m_jsonObjArgs;
    public Object[] m_objList;
    public byte[] m_fileData = null;
    public PPHttpTransfer m_httpTransfer;
    public boolean m_bExit;
    public int m_nLastError;
    public byte[] m_videoData = null;
    public Handler m_handler = null;
    public Vector<PPEnsembleTask> m_vector = null;
    private PPSharedPreferences m_Prefs = PPVirtuoso.getInstance().getPrefs();
    private char m_cPrefix = '?';

    private static String getServerUrl() {
        PPSharedPreferences prefs = PPVirtuoso.getInstance().getPrefs();
        if (prefs.getServerCommunicationURL() == null) {
            PPVirtuosoLogTrace.d(TAG, "getServerUrl: Somebody called me and I am null!");
        }
        return prefs.getServerCommunicationURL();
    }

    /**
     * This method provides a quick way to add parameters to a URL reducing code repetition.
     *
     * @param sburl Exisitng StringBuilder object containing the current URL.
     * @param param Parameter name to add.
     */
    private void appendParameter(StringBuilder sburl, String param) throws JSONException {
        if (m_jsonObjArgs.containsKey(param) && m_jsonObjArgs.get(param) != null) {
            //prefix
            sburl.append(m_cPrefix);
            m_cPrefix = '&';

            //name
            sburl.append(param);
            sburl.append("=");

            //value
            String value = m_jsonObjArgs.getString(param);
            value = Uri.encode(value);

            sburl.append(value);
        }
    }

    private void appendParameters(String prefix, StringBuilder sburl) throws JSONException {
        if (!m_jsonObjArgs.isEmpty()) {
            Set<String> keys = m_jsonObjArgs.keySet();
            for (String key : keys) {
                sburl.append(prefix);
                sburl.append(key);
                sburl.append("=");
                String value = m_jsonObjArgs.getString(key);
                value = Uri.encode(value);
                sburl.append(value);
                if (prefix.equals("?")) {
                    prefix = "&";
                }
            }
        }
    }

    @Override
    protected Message doInBackground(Void... params) {
        Message msg = m_handler.obtainMessage();

        msg.what = m_nReqID;
        msg.arg1 = RES_FAILURE;
        msg.arg2 = PPHttpTransfer.ERROR_OK;
        msg.obj = null;
        String sJsonData = null;
        boolean bVisitDatabase = false;
        boolean bUpdateDatabase = false;

        try {
            PPBaseJsonParser jsonBaseObj = null;
            StringBuilder sbURL = new StringBuilder();
            StringBuilder sbData = new StringBuilder();

            if (m_httpTransfer != null) {
                m_httpTransfer.clear();
            }

            if (m_jsonObjArgs.containsKey("TAG")) {
                Bundle bunTag = new Bundle();
                bunTag.putString("TAG", m_jsonObjArgs.getString("TAG"));
                msg.setData(bunTag);
                m_jsonObjArgs.remove("TAG");
            }

            switch (m_nReqID) {
                /* CLOUD MANAGER */
                case REQ_GET_CHECK_AVAILABILITY:
                    sbURL.append(getServerUrl());
                    sbURL.append("/espapi/watch");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_CHECK_AVAILABILITY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_CLOUD_SETTINGS:
                    jsonBaseObj = new PPConnectionSettingsJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/settings");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "version");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_CLOUD_SETTINGS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_SERVER_URL:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/settingsServer");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "version");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "ssl");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SERVER_URL");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_SERVER:
                    jsonBaseObj = new PPGetServerJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/settingsServer/");
                    sbURL.append((m_jsonObjArgs.containsKey("type")) ? m_jsonObjArgs.getString("type") : null);
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "connected");
                    appendParameter(sbURL, "version");
                    appendParameter(sbURL, "brand");
                    appendParameter(sbURL, "appName");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SERVER");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                /* USER MANAGER */
                case REQ_GET_LOGIN_USERNAME:
                    jsonBaseObj = new PPLoginJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/login");
                    appendParameter(sbURL, "username");
                    appendParameter(sbURL, "expiry");
                    appendParameter(sbURL, "appName");
                    //sbURL.append("&expiry=-1");
                    if (m_jsonObjArgs.containsKey("password")) {
                        m_httpTransfer.setHeaderPassWordValue(URLEncoder.encode(m_jsonObjArgs.getString("password"), "utf-8"));
                    } else if (m_jsonObjArgs.containsKey("passcode")) {
                        m_httpTransfer.setHeaderPassCordValue(URLEncoder.encode(m_jsonObjArgs.getString("passcode"), "utf-8"));
                    }
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_LOGIN_USERNAME");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_LOGIN_KEY:
                    jsonBaseObj = new PPLoginbyKeyJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/loginByKey");
                    // keyType=1
                    appendParameter(sbURL, "keyType");
                    appendParameter(sbURL, "expiry");
                    appendParameter(sbURL, "clientId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_LOGIN_KEY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                case REQ_GET_LOGOUT:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/logout");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_LOGOUT");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                case REQ_POST_NEW_USER_AND_LOCATION:
                    jsonBaseObj = new PPRegisterJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    sbData.append("{\"user\":");
                    String password = null;
                    String location = null;
                    if (m_jsonObjArgs != null) {
                        if (m_jsonObjArgs.containsKey("password")) {
                            password = (String) m_jsonObjArgs.remove("password");
                        }
                        if (m_jsonObjArgs.containsKey("location")) {
                            location = (String) m_jsonObjArgs.remove("location");
                        }
                        sbData.append(m_jsonObjArgs.toString());
                    } else {
                        sbData.append("{}");
                    }
                    if (!TextUtils.isEmpty(location)) {
                        sbData.append(String.format(",\"location\":%s", location));
                        sbData.append("}");
                    }
                    sbData.append("}");
                    m_httpTransfer.setHeaderOperationToken((m_objList[1].toString()));
                    if (null != password) {
                        m_httpTransfer.setHeaderPassWordValue(URLEncoder.encode(password, "utf-8"));
                    }
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_NEW_USER_AND_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbData: " + sbData.toString());
                    break;

                case REQ_GET_OPERATION_TOKEN:
                    jsonBaseObj = new PPOperationTokenJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/token");
                    sbURL.append("?type=");
                    sbURL.append((m_jsonObjArgs.containsKey("tokenType")) ? m_jsonObjArgs.getString("tokenType") : null);
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_OPERATION_TOKEN");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/user?userId=userId&organizationId=organizationId
//                public static final short REQ_GET_USER_INFO                             = 121;
                case REQ_TWITTER_USER_INFO:
//                case REQ_GET_USER_INFO:
                case REQ_GET_ALL_USER_INFORMATION_NO_SWITCH:
                case REQ_GET_ALL_USER_INFORMATION:
                    jsonBaseObj = new PPUserInformationJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "organizationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_ALL_USER_INFORMATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_USER_LOCATION_EVENT:
                    jsonBaseObj = new PPUserLocationEventJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "organizationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    break;
                case REQ_GET_USER_LOCATION_REFRESH:
                case REQ_GET_USER_INFO_REFRESH:
                    jsonBaseObj = new PPUserRefreshInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "organizationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_OTHER_USER_INFORMATION:
                    jsonBaseObj = new PPUserInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");

                    m_httpTransfer.setHeaderApiKeyValue((String) m_jsonObjArgs.remove("apiKey"));

                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_ALL_USER_INFORMATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/user?userId=userId
//                public static final short REQ_PUT_UPDATE_USER_INFO                      = 122;
                case REQ_PUT_UPDATE_USER_INFO:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    sbData.append("{\"user\":");

                    if (m_jsonObjArgs != null && m_jsonObjArgs.containsKey("data")) {
                        sbData.append(m_jsonObjArgs.getJSONObject("data").toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        m_httpTransfer.setHeaderPassWordValue((m_jsonObjArgs.containsKey("password")) ? URLEncoder.encode(m_jsonObjArgs.getString("password"), "utf-8") : null);
                        m_httpTransfer.addValue(sbData.toString());
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_USER_INFO");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;
                case REQ_PUT_UPDATE_OTHER_USER_INFO:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    sbData.append("{\"user\":");

                    if (m_jsonObjArgs != null && m_jsonObjArgs.containsKey("data")) {
                        sbData.append(m_jsonObjArgs.getJSONObject("data").toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue((String) m_jsonObjArgs.remove("token"));
                        m_httpTransfer.addValue(sbData.toString());
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_USER_INFO");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/user?userId=userId
//                public static final short REQ_DELETE_USER                               = 123;
                case REQ_DELETE_USER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/user");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "merge");
                    appendParameter(sbURL, "mergeUserId");

                    if (m_httpTransfer != null) {
                        if (m_jsonObjArgs.containsKey("mergeUserApiKey")) {
                            String mergeUserApiKey = (String) m_jsonObjArgs.remove("mergeUserApiKey");
                            m_httpTransfer.setHeaderApiKeyValue(String.format("%s,%s", m_Prefs.getUserKey(), mergeUserApiKey));
                        } else {
                            m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        }
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_USER");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/devices/<proxyId>/user
//                public static final short REQ_GET_USER_BY_DEVICE                        = 124;

//                // https://app.presencepro.com/cloud/json/location?userId=userId
//                public static final short REQ_POST_ADD_USER_LOCATION                    = 125;
                case REQ_POST_ADD_USER_LOCATION:
                    jsonBaseObj = new PPLocationParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location?userId=");
                    sbURL.append(m_Prefs.getUserId());
                    appendParameter(sbURL, "appName");
                    sbData.append("{\"location\":");

                    if (m_jsonObjArgs != null) {
                        sbData.append(m_jsonObjArgs.toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        m_httpTransfer.addValue(sbData.toString());
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_ADD_USER_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/location/<locationId>
//                public static final short REQ_PUT_UPDATE_LOCATION                       = 126;
                case REQ_PUT_UPDATE_LOCATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    String locationId = m_Prefs.getLocationId();
                    if (null != m_jsonObjArgs && m_jsonObjArgs.containsKey("locationId")) {
                        locationId = String.valueOf(m_jsonObjArgs.remove("locationId"));
                    }
                    sbURL.append(locationId);
                    sbData.append("{\"location\":");

                    if (m_jsonObjArgs != null) {
                        sbData.append(m_jsonObjArgs.toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        m_httpTransfer.addValue(sbData.toString());
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;
                case REQ_DELETE_LOCATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    String deleteLocationId = m_Prefs.getLocationId();
                    if (null != m_jsonObjArgs && m_jsonObjArgs.containsKey("locationId")) {
                        deleteLocationId = String.valueOf(m_jsonObjArgs.remove("locationId"));
                    }
                    sbURL.append(deleteLocationId);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/location/<locationId>/event/<eventName>
//                public static final short REQ_POST_CHANGE_SCENE_AT_LOCATION             = 127;
                case REQ_POST_CHANGE_SCENE_AT_LOCATION:
                    jsonBaseObj = new PPSceneChangeInfoParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.getString("locationId"));
                    sbURL.append("/event/");
                    sbURL.append(m_jsonObjArgs.getString("eventName"));
                    sbData.append("{\"comment\":\"\"}");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_CHANGE_SCENE_AT_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/location/<locationId>/events
//                public static final short REQ_GET_LOCATION_SCENE_HISTORY                = 128;

//                // https://app.presencepro.com/cloud/json/emailVerificationMessage?forward=forward&type=type
//                public static final short REQ_GET_SEND_VERIFICATION_MESSAGE             = 129;

//                // https://app.presencepro.com/cloud/json/emailVerificationMessage?type=type&code=code
//                public static final short REQ_PUT_PROVIDE_VERIFICATION_CODE             = 130;

//                // https://app.presencepro.com/cloud/json/newPassword?username=username&forward=forward
//                public static final short REQ_GET_RECOVER_PASSWORD                      = 131;
                case REQ_GET_RECOVER_PASSWORD:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/newPassword");
                    appendParameter(sbURL, "username");
//                    appendParameter(sbURL, "forward");
                    appendParameter(sbURL, "brand");
                    appendParameter(sbURL, "appName");
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_GET_RECOVER_PASSWORD");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/newPassword?forward=forward
//                public static final short REQ_PUT_NEW_PASSWORD                          = 132;
//
//                // https://app.presencepro.com/cloud/json/badges?type=type
//                public static final short REQ_PUT_RESET_BADGES                          = 133;
//
//                // https://app.presencepro.com/cloud/json/termsOfServices/<signatureId>
//                public static final short REQ_PUT_SIGN_TOS                              = 134;

                case REQ_PUT_NEW_PASSWORD:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/newPassword");
                    appendParameters("?", sbURL);
                    if (m_objList[0] != null) {
                        sbData.append(m_objList[0].toString());
                    } else {
                        sbData.append("{}");
                    }
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        m_httpTransfer.addValue(sbData.toString());
                    }
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_NEW_PASSWORD");
                    break;

                case REQ_PUT_RESET_BADGES:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/badges");
                    appendParameter(sbURL, "type");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_PUT_RESET_BADGES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_PUT_SIGN_TOS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/termsOfServices/");
                    sbURL.append((m_jsonObjArgs.containsKey("signatureId")) ? m_jsonObjArgs.getString("signatureId") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_SIGN_TOS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/termsOfServices
//                public static final short REQ_GET_SIGNATURES                            = 135;
                case REQ_GET_SIGNATURES:
                    jsonBaseObj = new PPTermsOfServiceJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/termsOfServices");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SIGNATURES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/countries?organizationId=organizationId&countryCode=countryCode
//                public static final short REQ_GET_COUNTRIES_STATES_TIME_ZONES           = 139;
                case REQ_GET_COUNTRIES_STATES_TIME_ZONES:
                    jsonBaseObj = new PPCountryInfoParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/countries");
                    appendParameter(sbURL, "organizationId");
                    appendParameter(sbURL, "countryCode");
                    bVisitDatabase = m_jsonObjArgs.getBooleanValue("visitDatabase");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_COUNTRIES_STATES_TIME_ZONES");
                    break;

                /* DEVICE MANAGER */
//                // https://app.presencepro.com/cloud/json/devices?locationId=locationId&deviceId=deviceId&deviceType=deviceType&authToken=authToken&startDate=startDate&desc=desc
//                public static final short REQ_POST_REGISTER_DEVICE                      = 150;
                case REQ_POST_REGISTER_DEVICE:
                    jsonBaseObj = new PPDeviceRegistrationJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "deviceType");
                    appendParameter(sbURL, "authToken");
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "desc");
                    if (m_jsonObjArgs.containsKey("properties")) {
                        sbData.append(m_jsonObjArgs.getString("properties"));
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_REGISTER_DEVICE");
                    break;
                case REQ_POST_REGISTER_GATEWAY:
                    jsonBaseObj = new PPGatewayRegistrationJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "deviceType");
                    appendParameter(sbURL, "authToken");
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "desc");
                    if (m_jsonObjArgs.containsKey("properties")) {
                        sbData.append(m_jsonObjArgs.getString("properties"));
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_REGISTER_GATEWAY");
                    break;
                case REQ_GET_DEVICE_LIST:
                    jsonBaseObj = new PPDeviceInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "checkPersistent");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_SIMPLE_DEVICE_LIST:
                    jsonBaseObj = new PPDeviceSimpleListJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "checkPersistent");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                //TODO: MERGE WITH "REQ_GET_DEVICE_LIST"
                case REQ_GET_DEVICE_SEPARATE_INFO:
                    jsonBaseObj = new PPDeviceInfoSeparatorParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "checkPersistent");
//                    sbURL.append("&sortCollection=devices&sortBy=typeCategory&sortOrder=asc");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_SEPARATE_INFO: " + m_Prefs.getUserKey());
                    break;
                case REQ_PUT_UPDATE_DEVICE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    if (m_jsonObjArgs.containsKey("locationId")) {
                        sbURL.append(m_jsonObjArgs.remove("locationId"));
                    }
                    sbURL.append("/devices/");
                    if (m_jsonObjArgs.containsKey("deviceId")) {
                        sbURL.append(m_jsonObjArgs.remove("deviceId"));
                    }
                    sbData.append("{\"device\":");
                    if (m_objList[0] != null) {
                        sbData.append(m_objList[0].toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_DEVICE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

//                case REQ_PUT_DEVICE_ATTRIBUTE:
//                    sbURL.append(getServerUrl());
//                    sbURL.append("/cloud");
//                    sbURL.append("/json");
//                    sbURL.append("/devices/");
//                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
//                    if (m_objList[0] != null)
//                    {
//                        sbData.append(m_objList[0].toString());
//                    }
//                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
//                    m_httpTransfer.addValue(sbData.toString());
//                    break;
//
//                // https://app.presencepro.com/cloud/json/devices/deviceId?clear=clear
//                public static final short REQ_DELETE_DEVICE                             = 155;
                case REQ_DELETE_DEVICE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    if (m_jsonObjArgs.containsKey("locationId")) {
                        sbURL.append(m_jsonObjArgs.remove("locationId"));
                    }
                    sbURL.append("/devices/");
                    if (m_jsonObjArgs.containsKey("deviceId")) {
                        sbURL.append(m_jsonObjArgs.remove("deviceId"));
                    }
                    appendParameter(sbURL, "clear");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_DEVICE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_DEVICE_FAQ:
                    jsonBaseObj = new PPDeviceFAQParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/locales/");
                    sbURL.append((m_jsonObjArgs.containsKey("locale")) ? m_jsonObjArgs.getString("locale") : "en");
                    sbURL.append("/helpers/");
                    sbURL.append((m_jsonObjArgs.containsKey("device")) ? m_jsonObjArgs.getString("device") : "10014-mk2");
                    sbURL.append("-faq.json");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_FAQ");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/locations/<locationId>/devices/<deviceId>
//                public static final short REQ_PUT_UPDATE_DEVICE_AT_LOCATION             = 156;
//
//                // https://app.presencepro.com/cloud/json/locations/locationId/devices/deviceId?clear=clear
//                public static final short REQ_DELETE_DEVICE_AT_LOCATION                 = 157;
//
//                // https://app.presencepro.com/cloud/json/deviceActivation/deviceType?sendEmail=sendEmail
//                public static final short REQ_GET_DEVICE_ACTIVATION_INFO                = 158;
//
//                // https://app.presencepro.com/cloud/json/locations/locationId/deviceActivation/deviceType?sendEmail=sendEmail
//                public static final short REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION    = 159;
                case REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION:
                    jsonBaseObj = new PPDeviceActivationInformationJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append((m_jsonObjArgs.containsKey("locationId")) ? m_jsonObjArgs.getString("locationId") : null);
                    sbURL.append("/deviceActivation/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceType")) ? m_jsonObjArgs.getString("deviceType") : null);
                    appendParameter(sbURL, "sendEmail");
//                    sbURL.append("?sendEmail=true");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&value=value&index=index
//                public static final short REQ_PUT_SINGLE_DEVICE_PROPERTY                = 160;
                case REQ_PUT_SINGLE_DEVICE_PROPERTY:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/properties");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "name");
                    appendParameter(sbURL, "value");
                    appendParameter(sbURL, "index");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_SINGLE_DEVICE_PROPERTY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/devices/deviceId/properties
//                public static final short REQ_PUT_MULTIPLE_DEVICE_PROPERTIES            = 161;
                case REQ_PUT_MULTIPLE_DEVICE_PROPERTIES:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/properties");
                    appendParameter(sbURL, "locationId");
                    sbData.append("{\"property\":");
                    if (m_objList != null) {
                        sbData.append(Arrays.asList(m_objList).toString());
                    }
                    sbData.append("}");
                    if (sbData.toString() != null && m_httpTransfer != null) {
                        if (m_httpTransfer != null && sbData.toString() != null) {
                            m_httpTransfer.addValue(sbData.toString());
                            m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        }
                    }
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_MULTIPLE_DEVICE_PROPERTIES");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
//                public static final short REQ_GET_DEVICE_PROPERTY                       = 162;
                case REQ_GET_DEVICE_PROPERTY:
                    jsonBaseObj = new PPDevicePropertyJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/properties");
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_PROPERTY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
//                public static final short REQ_DELETE_DEVICE_PROPERTY                    = 163;
                case REQ_DELETE_DEVICE_PROPERTY:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/properties");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "name");
                    appendParameter(sbURL, "index");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_DEVICE_PROPERTY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                /* DEVICE MEASUREMENTS */
//                // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId&userId=userId&paramName=paramName
//                public static final short REQ_GET_CURRENT_MEASUREMENTS                  = 170;
                case REQ_GET_CURRENT_MEASUREMENTS:
                    jsonBaseObj = new PPDeviceParameterJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/parameters");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "paramName");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_CURRENT_MEASUREMENTS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                case REQ_GET_SINGLE_DEVICE_PARAMETER:
//                    jsonBaseObj = new PPDeviceParameterJsonParser();
//                    sbURL.append(getServerUrl());
//                    sbURL.append("/cloud");
//                    sbURL.append("/json");
//                    sbURL.append("/devices/");
//                    sbURL.append((m_jsonObjArgs.containsKey("DeviceId")) ? m_jsonObjArgs.getString("DeviceId") : null);
//                    sbURL.append("/parameters");
//                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
//                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SINGLE_DEVICE_PARAMETER");
//                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
//                    break;
//
//                // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId
//                public static final short REQ_PUT_SEND_COMMAND                          = 171;
                case REQ_PUT_SEND_COMMAND:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/parameters");
                    appendParameter(sbURL, "locationId");
                    if (m_jsonObjArgs.containsKey("paramsObj")) {
                        sbData.append(m_jsonObjArgs.getJSONObject("paramsObj").toString());
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_SEND_COMMAND");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                case REQ_PUT_SEND_COMMAND_TYPE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/parameters");
                    appendParameter(sbURL, "locationId");
                    String dataValue = (String) m_jsonObjArgs.remove("data");
                    m_httpTransfer.addValue(dataValue);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_SEND_COMMAND_TYPE");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + dataValue);
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/parameters?locationId=locationId&userId=userId&deviceId=deviceId&paramName=paramName
//                public static final short REQ_GET_MEASUREMENTS_WITH_SEARCH              = 172;
                case REQ_GET_MEASUREMENTS_WITH_SEARCH:
                    jsonBaseObj = new PPDeviceParameterJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/parameters");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "paramName");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_MEASUREMENTS_WITH_SEARCH");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_MEASUREMENT_HISTORY:
                    jsonBaseObj = new PPDeviceMeasurementJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/parametersByDate/");
                    sbURL.append((m_jsonObjArgs.containsKey("startDate")) ? m_jsonObjArgs.getString("startDate") : null);
                    appendParameter(sbURL, "endDate");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    sbURL.append("&paramName=");
                    sbURL.append((m_jsonObjArgs.containsKey("paramName")) ? m_jsonObjArgs.getString("paramName") : null);
                    appendParameter(sbURL, "interval");
                    appendParameter(sbURL, "aggregation");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_MEASUREMENT_HISTORY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_FIRMWARE_JOBS:
                    jsonBaseObj = new PPFirmwareJobsJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/fwupdate");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_FIRMWARE_JOBS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_PUT_FIRMWARE_UPDATE_STATUS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/fwupdate");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "status");
                    appendParameter(sbURL, "startDate");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_FIRMWARE_UPDATE_STATUS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//
//                // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByDate/startDate?endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&interval=interval&aggregation=aggregation&reduceNoise=reduceNoise
//                public static final short REQ_GET_MEASUREMENT_HISTORY                   = 173;
//
//                // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByCount/rowCount?startDate=startDate&endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&reduceNoise=reduceNoise
//                public static final short REQ_GET_LAST_N_MEASUREMENTS                   = 174;
//
//                // https://app.presencepro.com/cloud/json/units
//                public static final short REQ_GET_UNITS_OF_MEASURE                      = 175;
//
//
//    /* USER COMMUNICATIONS */
//                // https://app.presencepro.com/cloud/json/notificationSubscriptions
//                public static final short REQ_GET_NOTIFICATION_SUBSCRIPTIONS            = 176;
                case REQ_GET_NOTIFICATION_SUBSCRIPTIONS:
                    jsonBaseObj = new PPNotificationSubscriptionsParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/notificationSubscriptions");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_NOTIFICATION_SUBSCRIPTIONS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/notificationSubscriptions/type?email=email&emailPeriod=emailPeriod&push=push&pushPeriod=pushPeriod&sms=sms&smsPeriod=smsPeriod
//                public static final short REQ_PUT_NOTIFICATION_SUBSCRIPTIONS            = 177;
                case REQ_PUT_NOTIFICATION_SUBSCRIPTIONS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/notificationSubscriptions");
                    sbURL.append("/" + m_jsonObjArgs.getString("Type"));
//                    sbURL.append("?"+m_jsonObjArgs.getString("Enable"));
//                    sbURL.append("&"+m_jsonObjArgs.getString("Time"));
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "email");
                    appendParameter(sbURL, "emailPeriod");
                    appendParameter(sbURL, "push");
                    appendParameter(sbURL, "pushPeriod");
                    appendParameter(sbURL, "sms");
                    appendParameter(sbURL, "smsPeriod");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_NOTIFICATION_SUBSCRIPTIONS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/notificationToken/appName/notificationToken_or_registrationId?badge=badge
//                public static final short REQ_PUT_APP_NOTIFICATION_REGISTRATION         = 178;
                case REQ_PUT_APP_NOTIFICATION_REGISTRATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/notificationToken/");
                    sbURL.append(m_jsonObjArgs.getString("appName"));
                    sbURL.append("/");
                    sbURL.append((m_jsonObjArgs.containsKey("registrationId")) ? m_jsonObjArgs.getString("registrationId") : null);
                    appendParameter(sbURL, "badge");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_APP_NOTIFICATION_REGISTRATION");
                    PPVirtuosoLogTrace.d(TAG, "USERKEY = " + m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/notificationToken/notificationToken_or_registrationId
//                public static final short REQ_DELETE_APP_NOTIFICATION_REGISTRATION      = 179;
                case REQ_DELETE_APP_NOTIFICATION_REGISTRATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/notificationToken/");
                    sbURL.append((m_jsonObjArgs.containsKey("registrationId")) ? m_jsonObjArgs.getString("registrationId") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_APP_NOTIFICATION_REGISTRATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_NOTIFICATIONS:
                    jsonBaseObj = new PPNotificationJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/notifications");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "endDate");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_CROWD_FEEDBACK:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/feedback");
                    sbData.append("{\"feedback\":");
                    if (m_jsonObjArgs != null) {
                        sbData.append(m_jsonObjArgs.getJSONObject("data").toString());
                    } else {
                        sbData.append("{}");
                    }
                    sbData.append("}");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());

                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_CROWD_FEEDBACK");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;
                case REQ_GET_QUESTIONS:
                    jsonBaseObj = new PPQuestionsParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/questions?");
                    if (m_jsonObjArgs.containsKey("answerStatus")) {
                        String answerStatus = (String) m_jsonObjArgs.remove("answerStatus");
                        sbURL.append(answerStatus);
                    }
                    appendParameters("&", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_SIMPLE_QUESTIONS:
                    jsonBaseObj = new PPQuestionsSimpleParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/questions?");
                    if (m_jsonObjArgs.containsKey("answerStatus")) {
                        String answerStatus = (String) m_jsonObjArgs.remove("answerStatus");
                        sbURL.append(answerStatus);
                    }
                    appendParameters("&", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_QUESTION_BY_KEY:
                    jsonBaseObj = new PPQuestionParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/questions?");
                    if (m_jsonObjArgs.containsKey("answerStatus")) {
                        String answerStatus = (String) m_jsonObjArgs.remove("answerStatus");
                        sbURL.append(answerStatus);
                    }
                    appendParameters("&", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_PUT_ANSWER_QUESTION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/questions");
                    appendParameter(sbURL, "locationId");
                    if (m_jsonObjArgs.containsKey("data")) {
                        sbData.append(m_jsonObjArgs.getJSONObject("data").toString());
                        m_httpTransfer.addValue(sbData.toString());
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_SMS_SUBSCRIBERS:
                    jsonBaseObj = new PPSMSSubscriberJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/smsSubscribers");
                    if (m_jsonObjArgs != null && m_jsonObjArgs.containsKey("categoryData")) {
                        sbURL.append(m_jsonObjArgs.getString("categoryData"));
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_SMS_SUBSCRIBER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/smsSubscribers");
                    if (m_jsonObjArgs != null) {
                        sbData.append(m_jsonObjArgs.getJSONObject("data").toString());
                    } else {
                        sbData.append("{}");
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    break;
                case REQ_DELETE_SMS_SUBSCRIBER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/smsSubscribers");
                    appendParameter(sbURL, "phone");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;

                case REQ_GET_SYSTEM_OR_USER_PROPERTY:
                case REQ_GET_SYSTEM_PROPERTY:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/systemProperty/");
                    sbURL.append((m_jsonObjArgs.containsKey("propertyName")) ? m_jsonObjArgs.getString("propertyName") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_GET_SYSTEM_OR_USER_PROPERTY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/userProperties?propertyName=propertyName&userId=userId
//                public static final short REQ_GET_USER_PROPERTIES                       = 201;
                case REQ_GET_USER_PROPERTIES:
                    jsonBaseObj = new PPUserPropertyJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userProperties");
                    appendParameter(sbURL, "propertyName");
                    appendParameter(sbURL, "userId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_GET_USER_PROPERTIES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/userProperties?userId=userId
//                public static final short REQ_POST_UPDATE_USER_PROPERTIES               = 202;

//                // https://app.presencepro.com/cloud/json/userProperty/propertyName?value=value
//                public static final short REQ_PUT_UPDATE_USER_PROPERTY                  = 203;
                case REQ_PUT_UPDATE_USER_PROPERTY:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userProperty/");
                    sbURL.append((m_jsonObjArgs.containsKey("propertyName")) ? m_jsonObjArgs.getString("propertyName") : null);
//                    sbURL.append("?value=");
//                    sbURL.append((m_jsonObjArgs.containsKey("property_value")) ? m_jsonObjArgs.getString("property_value") : null);
                    appendParameter(sbURL, "value");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_PUT_UPDATE_USER_PROPERTY");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                /* FILE MANAGER */
                //https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&thumbnail=thumbnail&incomplete=incomplete&index=index
//              //https://app.presencepro.com/cloud/json/files?proxyId=proxyId&deviceId=deviceId&ext=ext&expectedSize=expectedSize&duration=duration&rotate=rotate&fileId=fileId&thumbnail=thumbnail&incomplete=incomplete&type=type
//              public static final short REQ_POST_UPLOAD_NEW_FILE                      = 210;
                case REQ_POST_UPLOAD_NEW_FILE:
                    jsonBaseObj = new PPDeviceUploadJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    appendParameter(sbURL, "proxyId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "ext");
                    appendParameter(sbURL, "expectedSize");
                    appendParameter(sbURL, "duration");
                    appendParameter(sbURL, "rotate");
                    appendParameter(sbURL, "fileId");
                    appendParameter(sbURL, "thumbnail");
                    appendParameter(sbURL, "incomplete");
                    appendParameter(sbURL, "type");
                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs.getString("EspToken") : null);
                    if (m_objList[1] != null) {
                        m_videoData = (byte[]) m_objList[1];
                    }
                    m_httpTransfer.setContentType("video/mp4");
                    m_httpTransfer.setInputByteArrayFileData(m_videoData);
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_UPLOAD_NEW_FILE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
//                public static final short REQ_GET_FILES                                 = 211;
                case REQ_GET_FILES:
                    //TODO: Remove these extra types (REQ_GET_OLD_FILES)
                case REQ_GET_OLD_FILES:
                    jsonBaseObj = new PPDeviceFileInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "owners");
                    appendParameter(sbURL, "ownerId");
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "endDate");
                    appendParameter(sbURL, "searchTag");
                    //sorting
                    appendParameter(sbURL, "sortCollection");
                    appendParameter(sbURL, "sortBy");
                    appendParameter(sbURL, "rowCount");
                    appendParameter(sbURL, "sortOrder");
                    appendParameter(sbURL, "firstRow");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_FILES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/files
//                public static final short REQ_DELETE_ALL_FILES                          = 212;
                case REQ_DELETE_ALL_FILES:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_ALL_FILES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_LAST_N_FILES:
                    jsonBaseObj = new PPDeviceFileInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/filesByCount/");
                    if (m_jsonObjArgs.containsKey("count")) {
                        sbURL.append(m_jsonObjArgs.getString("count"));
                    }
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "endDate");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "deviceDescription");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_LAST_N_FILES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&thumbnail=thumbnail&incomplete=incomplete&index=index
//                public static final short REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL           = 213;
                case REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL:
                    //TODO prepare new object for parser here
                    jsonBaseObj = new PPDeviceUploadJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    if (m_jsonObjArgs.containsKey("fileId") && !m_jsonObjArgs.getString("fileId").equals("0")) {
                        sbURL.append("/");
                        sbURL.append(m_jsonObjArgs.getString("fileId"));
                    }
                    appendParameter(sbURL, "proxyId");
                    appendParameter(sbURL, "thumbnail");
                    appendParameter(sbURL, "incomplete");
                    appendParameter(sbURL, "index");
                    //??????
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "duration");
                    appendParameter(sbURL, "rotate");
                    appendParameter(sbURL, "ext");
                    appendParameter(sbURL, "fileId");

                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs.getString("EspToken") : null);
                    if (m_objList[1] != null) {
                        m_videoData = (byte[]) m_objList[1];
                    }
                    m_httpTransfer.setContentType("video/mp4");
                    m_httpTransfer.setInputByteArrayFileData(m_videoData);
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_POST_DEVICE_FILE_THUMBNAIL:
                    jsonBaseObj = new PPDeviceUploadJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    sbURL.append("?proxyId=");
                    sbURL.append((m_jsonObjArgs.containsKey("proxyId")) ? m_jsonObjArgs.getString("proxyId") : null);
                    sbURL.append("&deviceId=");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("&duration=");
                    sbURL.append((m_jsonObjArgs.containsKey("duration")) ? m_jsonObjArgs.getString("duration") : null);
                    sbURL.append("&rotate=0");
                    sbURL.append("&ext=");
                    sbURL.append((m_jsonObjArgs.containsKey("ext")) ? m_jsonObjArgs.getString("ext") : null);
                    sbURL.append("&incomplete=");
                    sbURL.append((m_jsonObjArgs.containsKey("incomplete")) ? m_jsonObjArgs.getString("incomplete") : null);

                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs
                        .getString("EspToken") : null);

                    if (m_objList[1] != null) {
                        m_videoData = (byte[]) m_objList[1];
                    }
                    m_httpTransfer.setContentType("video/mp4");
                    m_httpTransfer.setInputByteArrayFileData(m_videoData);
                    PPVirtuosoLogTrace.d("JsonParserMain", "REQ_POST_DEVICE_FILE_THUMBNAIL");
                    break;
                case REQ_POST_DEVICE_FILE_VIDEO:
                    //TODO prepare new object for parser here
                    jsonBaseObj = new PPDeviceUploadJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    if (m_jsonObjArgs.containsKey("fileId") && !m_jsonObjArgs.getString("fileId").equals("0")) {
                        sbURL.append("/");
                        sbURL.append(m_jsonObjArgs.getString("fileId"));
                    }
                    sbURL.append("?proxyId=");
                    sbURL.append((m_jsonObjArgs.containsKey("proxyId")) ? m_jsonObjArgs.getString("proxyId") : null);
                    if (m_jsonObjArgs.containsKey("deviceId")) {
                        sbURL.append("&deviceId=");
                        sbURL.append(m_jsonObjArgs.getString("deviceId"));
                    }
                    if (m_jsonObjArgs.containsKey("duration")) {
                        sbURL.append("&duration=");
                        sbURL.append(m_jsonObjArgs.getString("duration"));
                    }
                    if (m_jsonObjArgs.containsKey("rotate")) {
                        sbURL.append("&rotate=0");
                    }
                    if (m_jsonObjArgs.containsKey("ext")) {
                        sbURL.append("&ext=");
                        sbURL.append(m_jsonObjArgs.getString("ext"));
                    }
                    if (m_jsonObjArgs.containsKey("index")) {
                        sbURL.append("&index=");
                        sbURL.append(m_jsonObjArgs.getString("index"));
                    }
                    if (m_jsonObjArgs.containsKey("newFileId") && !m_jsonObjArgs.getString("newFileId").equals("0")) {
                        sbURL.append("&fileId=");
                        sbURL.append((m_jsonObjArgs.containsKey("newFileId")) ? m_jsonObjArgs.getString("newFileId") : null);
                    }

                    sbURL.append("&thumbnail=");
                    sbURL.append((m_jsonObjArgs.containsKey("thumbnail")) ? m_jsonObjArgs.getString("thumbnail") : null);
                    sbURL.append("&incomplete=");
                    sbURL.append((m_jsonObjArgs.containsKey("incomplete")) ? m_jsonObjArgs.getString("incomplete") : null);

                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs
                        .getString("EspToken") : null);

                    if (m_objList[1] != null) {
                        m_videoData = (byte[]) m_objList[1];
                    }
                    m_httpTransfer.setContentType("video/mp4");
                    m_httpTransfer.setInputByteArrayFileData(m_videoData);
                    PPVirtuosoLogTrace.d("JsonParserMain", "REQ_POST_DEVICE_FILE_VIDEO");
                    break;
//                // https://app.presencepro.com/cloud/json/files/fileId?thumbnail=thumbnail&API_KEY=API_KEY
//                public static final short REQ_GET_FILE                                  = 214;

//                // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&incomplete=incomplete&recover=recover&userId=userId
//                public static final short REQ_PUT_UPDATE_FILE_ATTRIBUTES                = 215;
                case REQ_PUT_UPDATE_FILE_ATTRIBUTES:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    sbURL.append("/" + m_jsonObjArgs.getString("fileId"));
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "proxyId");
                    appendParameter(sbURL, "incomplete");
                    appendParameter(sbURL, "recover");
                    appendParameter(sbURL, "userId");
                    if (m_objList[0] != null) {
                        sbData.append("{\"file\":");
                        sbData.append(m_objList[0].toString());
                        sbData.append("}");
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_FILE_ATTRIBUTES");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                //                // https://app.presencepro.com/cloud/json/files/fileId
//                public static final short REQ_DELETE_FILE                               = 216;
                case REQ_DELETE_FILE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/files");
                    if (m_jsonObjArgs.containsKey("fileId")) {
                        sbURL.append("/" + m_jsonObjArgs.getString("fileId"));
                    }
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_FILE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                case REQ_GET_AGGREGATED_FILE_LIST:
                    jsonBaseObj = new PPAggregatedFileListJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/filesSummary/");
                    if (m_jsonObjArgs.containsKey("aggregation")) {
                        sbURL.append(m_jsonObjArgs.getString("aggregation"));
                    }
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "details");
                    appendParameter(sbURL, "timeZone");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "owners");
                    appendParameter(sbURL, "ownerId");
                    appendParameter(sbURL, "startDate");
                    appendParameter(sbURL, "endDate");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
//                // https://app.presencepro.com/cloud/json/filesSummary/aggregation?timeZone=timeZone&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate
//                public static final short REQ_GET_AGGREGATED_FILE_LIST                  = 217;

//                // https://app.presencepro.com/cloud/json/filesInfo/fileId
//                public static final short REQ_GET_FILE_INFORMATION                      = 218;

//                // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
//                public static final short REQ_PUT_APPLY_FILE_TAG                        = 219;

//                // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
//                public static final short REQ_DELETE_FILE_TAG                           = 220;

//                // https://app.presencepro.com/cloud/json/files/fileId/report/reportType
//                public static final short REQ_PUT_REPORT_ABUSE                          = 221;

//                // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
//                public static final short REQ_POST_APP_UPLOAD_FILE_CONTENT              = 222;
                case REQ_POST_APP_UPLOAD_FILE_CONTENT:
                    jsonBaseObj = new PPDeviceUploadJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/appfiles");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "fileId");
                    appendParameter(sbURL, "name");
                    appendParameter(sbURL, "publicAccess");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");

                    String contentType = (String) m_jsonObjArgs.remove("contentType");
                    if (m_objList[1] != null) {
                        m_fileData = (byte[]) m_objList[1];
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.setContentType(contentType);
                    m_httpTransfer.setInputByteArrayFileData(m_fileData);

                    break;
//                // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
//                public static final short REQ_GET_APP_FILES                             = 223;
                case REQ_GET_APP_FILES:
                    jsonBaseObj = new PPApplicationFileParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/appfiles");
                    appendParameter(sbURL, "type");
                    appendParameter(sbURL, "fileId");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    break;
                case REQ_DELETE_APP_FILE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/appfiles/");
                    sbURL.append(String.format("%s", m_jsonObjArgs.remove("fileId")));
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    break;
//                // https://app.presencepro.com/cloud/json/appfiles/fileId?API_KEY=API_KEY&userId=userId&locationId=locationId
//                public static final short REQ_GET_APP_DOWNLOAD_FILE                     = 224;

//                // https://app.presencepro.com/cloud/json/appfiles/fileId?userId=userId&locationId=locationId
//                public static final short REQ_DELETE_APP_FILE                           = 225;

                /* RULES ENGINE */
//                // https://app.presencepro.com/cloud/json/ruleConditions?version=version
//                public static final short REQ_GET_RULE_PHRASES                          = 230;
                case REQ_GET_RULE_PHRASES:
                    jsonBaseObj = new PPRuleGetConditionJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/ruleConditions");
//                    sbURL.append("/ruleConditions?version=1");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "version");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_RULE_PHRASES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/rules
//                public static final short REQ_POST_CREATE_RULE                          = 231;
                case REQ_POST_CREATE_RULE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    sbData = (StringBuilder) m_objList[0];
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_CREATE_RULE");
                    PPVirtuosoLogTrace.d(TAG, "Data:-" + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/rules?deviceId=deviceId&details=details
//                public static final short REQ_GET_RULES                                 = 234;
                case REQ_GET_RULES:
                    jsonBaseObj = new PPRuleGetListJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "details");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
// https://app.presencepro.com/cloud/json/rules/ruleId?details=details
//                public static final short REQ_GET_RULE                                  = 235;
                case REQ_GET_RULE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("ruleId")) ? m_jsonObjArgs.getInteger("ruleId") : 0));
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "details");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/rules/ruleId
//                public static final short REQ_PUT_UPDATE_RULE                           = 232;
                case REQ_PUT_UPDATE_RULE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("ruleId")) ? m_jsonObjArgs.getString("ruleId") : null));
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    sbData = (StringBuilder) m_objList[0];
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_RULE");
                    PPVirtuosoLogTrace.d(TAG, "Data:-" + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/rules/ruleId
//                public static final short REQ_DELETE_RULE                               = 236;
                case REQ_DELETE_RULE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("ruleId")) ? m_jsonObjArgs.getInteger("ruleId") : 0));
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/rules/ruleId/attrs
//                public static final short REQ_PUT_UPDATE_RULE_ATTRIBUTE                 = 233;
                case REQ_PUT_UPDATE_RULE_ATTRIBUTE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/rules");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("ruleId")) ? m_jsonObjArgs.getString("ruleId") : null));
                    sbURL.append("/attrs");
                    appendParameter(sbURL, "locationId");
                    sbData.append("{\"rule\":{");
                    sbData.append("\"status\":" + m_jsonObjArgs.getString("status"));
                    if ((m_jsonObjArgs.containsKey("timezone"))) {
                        sbData.append(",\"timeZone\":\"" + m_jsonObjArgs.getString("timezone") + "\"");
                    }
                    sbData.append("}}");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/rulesCreateDefault?deviceId=deviceId&userId=userId
//                public static final short REQ_POST_CREATE_RULE_FOR_DEVICE               = 237;


                /* PAID SERVICES */
//                // https://app.presencepro.com/cloud/json/servicePlans?appName=appName&userId=userId&hiddenPrices=hiddenPrices
//                public static final short REQ_GET_SOFTWARE_SUBSCRIPTIONS                = 238;
                case REQ_GET_SOFTWARE_SUBSCRIPTIONS:
                    jsonBaseObj = new PPServicePlanJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/servicePlans");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "appName");
                    appendParameter(sbURL, "userId");
                    appendParameter(sbURL, "hiddenPrices");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SERVICE_PLAN");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//                // https://app.presencepro.com/cloud/json/receipt/apple?appName=appName
//                public static final short REQ_POST_SUBMIT_APPLE_PURCHASE_RECEIPT        = 239;

//                // https://app.presencepro.com/auth/paypalpurchase/planPriceId?API_KEY=API_KEY&sandbox=sandbox
//                public static final short REQ_GET_REDIRECT_USER_TO_PAYPAL_SITE          = 240;

//                // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId?userName=userName&endDate=endDate
//                public static final short REQ_POST_ASSIGN_SERVICES_TO_USER              = 241;

//                // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId
//                public static final short REQ_DELETE_CANCEL_SUBSCRIPTION                = 242;
                case REQ_DELETE_CANCEL_SUBSCRIPTION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userServicePlans/");
                    sbURL.append((m_jsonObjArgs.containsKey("servicePlanId")) ? m_jsonObjArgs.getString("servicePlanId") : null);
                    appendParameter(sbURL, "locationId");
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_CANCEL_SUBSCRIPTION");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/userServicePlansBatch/servicePlanId?endDate=endDate
//                public static final short REQ_POST_ASSIGN_SERVICES_TO_USERS             = 243;

//                // https://app.presencepro.com/cloud/json/market?appName=appName
//                public static final short REQ_GET_STORE_PRODUCTS                        = 244;
                case REQ_GET_STORE_PRODUCTS:
                    jsonBaseObj = new PPMarketProductJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/market");
//                    sbURL.append("/market?appName=Presence");
                    appendParameter(sbURL, "appName");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_GET_STORE_PRODUCTS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
                //                // https://app.presencepro.com/cloud/json/callCenter
//                public static final short REQ_GET_CALL_CENTER                           = 136;
                case REQ_GET_CALL_CENTER:
                    jsonBaseObj = new PPCallCenterJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/callCenter");
                    appendParameter(sbURL, "locationId");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_CALL_CENTER");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;

//                // https://app.presencepro.com/cloud/json/callCenter
//                public static final short REQ_PUT_UPDATE_CALL_CENTER                    = 137;
                case REQ_PUT_UPDATE_CALL_CENTER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/callCenter");
                    String locationIdStr = m_jsonObjArgs.containsKey("locationId") ? (String) m_jsonObjArgs.remove("locationId") : null;
                    if (null != locationIdStr) {
                        sbURL.append(String.format("?locationId=%s", locationIdStr));
                    }
                    sbData.append("{\"callCenter\":");
                    //We dont need this right now. Let's use this when we need it.(confirmed it from cloud channel)
//                    if (VirtuosoCommonSettings.setDNDInAvantguard) {
//                        sbData.append("{\"callCenter\": \"notDispatch\": true,");
//                    } else {
//                        sbData.append("{\"callCenter\":");
//                    }
                    if (m_jsonObjArgs != null) {
                        sbData.append(m_jsonObjArgs.toString());
                    }
                    sbData.append("}");
                    if (m_httpTransfer != null) {
                        m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                        m_httpTransfer.addValue(sbData.toString());
                    }

                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_CALL_CENTER");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;
                case REQ_DELETE_CALL_CENTER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/callCenter");
                    appendParameter(sbURL, "locationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_CALL_CENTER");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/callCenterAlerts
//                public static final short REQ_GET_CALL_CENTER_ALERTS                    = 138;
                case REQ_GET_CALL_CENTER_ALERTS:
                    jsonBaseObj = new PPCallCenterAlertJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/callCenterAlerts");
                    appendParameter(sbURL, "locationId");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_CALL_CENTER_ALERTS");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                /* DYNAMIC USER INTERFACES */
//                // https://app.presencepro.com/cloud/json/uiscreens/appName?version=version
//                public static final short REQ_GET_UI_SCREENS                            = 245;
                case REQ_GET_UI_SCREENS:
                    jsonBaseObj = new PPUIScreenJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/uiscreens/");
                    sbURL.append((m_jsonObjArgs.containsKey("appName")) ? m_jsonObjArgs.getString("appName") : null);
                    appendParameter(sbURL, "version");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_UI_SCREENS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/userTotals?devices=devices&files=files&rules=rules&friends=friends&userId=userId
//                public static final short REQ_GET_USER_TOTALS                           = 246;
                case REQ_GET_USER_TOTALS:
                    jsonBaseObj = new PPUserTotalsJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locationTotals");
//                    sbURL.append("devices=true&files=true&rules=true&friends=true");
                    appendParameter(sbURL, "devices");
                    appendParameter(sbURL, "files");
                    appendParameter(sbURL, "rules");
                    appendParameter(sbURL, "friends");
                    appendParameter(sbURL, "userId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                case REQ_GET_USER_TOTALS_OLD:
                    jsonBaseObj = new PPUserTotalsJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userTotals");
//                    sbURL.append("devices=true&files=true&rules=true&friends=true");
                    appendParameter(sbURL, "devices");
                    appendParameter(sbURL, "files");
                    appendParameter(sbURL, "rules");
                    appendParameter(sbURL, "friends");
                    appendParameter(sbURL, "userId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                /* ENERGY MANAGEMENT */
//                // https://app.presencepro.com/cloud/json/locations/locationId/energyUsage/aggregation/startDate?endDate=endDate&external=external
//                public static final short REQ_GET_LOCATION_ENERGY_USAGE                 = 250;

//                // https://app.presencepro.com/cloud/json/locations/locationId/billData
//                public static final short REQ_POST_UPLOAD_LOCATION_UTILITY_BILLS        = 251;

//                // https://app.presencepro.com/cloud/json/locations/locationId/bills/billId
//                public static final short REQ_DELETE_UTILITY_BILL                       = 252;

//                // https://app.presencepro.com/cloud/json/devices/deviceId/currentEnergyUsage?index=index&locationId=locationId&userId=userId
//                public static final short REQ_GET_DEVICE_ENERGY_USAGE                   = 253;
                case REQ_GET_DEVICE_ENERGY_USAGE:
                    jsonBaseObj = new PPCurrentEnergyUsageJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbURL.append("/currentEnergyUsage");
                    appendParameter(sbURL, "index");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "userId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_ENERGY_USAGE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/devices/deviceId/energyUsage/aggregation/startDate?endDate=endDate&reduceNoise=reduceNoise&locationId=locationId&userId=userId
//                public static final short REQ_GET_AGGREGATED_DEVICE_ENERGY_USAGE        = 254;

//                // https://app.presencepro.com/cloud/json/locations/locationId/billing/filter
//                public static final short REQ_GET_BILLING_INFORMATION                   = 255;
                case REQ_GET_BILLING_INFORMATION:
                    jsonBaseObj = new PPBillingInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("locationId")) ? m_jsonObjArgs.getString("locationId") : null));
                    sbURL.append("/billing");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("filter")) ? m_jsonObjArgs.getString("filter") : null));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_GET_BILLING_INFORMATION");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/locations/locationId/billing
//                public static final short REQ_PUT_UPDATE_BILLING_INFORMATION            = 256;
                case REQ_PUT_UPDATE_BILLING_INFORMATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations");
                    sbURL.append("/" + ((m_jsonObjArgs.containsKey("locationId")) ? m_jsonObjArgs.getString("locationId") : null));
                    sbURL.append("/billing");
                    sbData.append("{\"billingInfo\":{\"billingRate\":");
                    if (m_objList[0] != null) {
                        JSONObject valueObj = JSON.parseObject(m_objList[0].toString());
                        String value = valueObj.getString("value");
                        sbData.append("{\"value\":\"" + value + "\"}");
                    }
                    sbData.append("}}");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d("PPMainJsonParser", "REQ_PUT_UPDATE_BILLING_INFORMATION");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                /* CREATING PRODUCTS */
//                // https://app.presencepro.com/cloud/json/deviceTypes?deviceType=deviceType&attrName=attrName&attrValue=attrValue&own=own&simple=simple&organizationId=organizationId
//                public static final short REQ_GET_SUPPORTED_PRODUCTS                    = 260;
                case REQ_GET_SUPPORTED_PRODUCTS:
                    jsonBaseObj = new PPAddDeviceJsonParser(PPVirtuoso.getInstance().getContext());
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/deviceTypes");
                    appendParameter(sbURL, "deviceType");
                    appendParameter(sbURL, "attrName");
                    appendParameter(sbURL, "attrValue");
                    appendParameter(sbURL, "own");
                    appendParameter(sbURL, "simple");
                    appendParameter(sbURL, "organizationId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SUPPORTED_PRODUCTS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/deviceTypeAttrs
//                public static final short REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES          = 261;
                case REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/deviceTypeAttrs");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

                case REQ_GET_PRODUCT_PARAMETERS:
                    jsonBaseObj = new PPParameterDisplayInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/deviceParameters");
                    appendParameter(sbURL, "paramName");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_PRODUCT_PARAMETERS");
                    break;

//                // https://app.presencepro.com/cloud/json/deviceType
//                public static final short REQ_POST_CREATE_PRODUCT                       = 262;

//                // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId
//                public static final short REQ_POST_UPDATE_PRODUCT                       = 263;

//                // https://app.presencepro.com/cloud/json/deviceParameters?paramName=paramName
//                public static final short REQ_GET_PRODUCT_PARAMETERS                    = 264;

//                // https://app.presencepro.com/cloud/json/deviceParameters
//                public static final short REQ_POST_CREATE_OR_UPDATE_PRODUCT_PARAMETERS  = 265;

//                // https://app.presencepro.com/cloud/json/deviceParameters/parameterName
//                public static final short REQ_DELETE_PRODUCT_PARAMETER                  = 266;

//                // https://app.presencepro.com/cloud/json/ruleTemplates
//                public static final short REQ_GET_PRODUCT_RULE_PHRASE                   = 267;

//                // https://app.presencepro.com/cloud/json/ruleTemplates
//                public static final short REQ_POST_CREATE_PRODUCT_RULE_PHRASE           = 268;

//                // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//                public static final short REQ_GET_PRODUCT_RULE_PHRASE_BY_ID             = 269;

//                // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//                public static final short REQ_PUT_UPDATE_PRODUCT_RULE_PHRASE            = 270;

//                // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
//                public static final short REQ_DELETE_PRODUCT_RULE_PHRASE                = 271;

//                // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules?details=details
//                public static final short REQ_GET_PRODUCT_DEFAULT_RULES                 = 272;

//                // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId?hidden=hidden
//                public static final short REQ_POST_PRODUCT_DEFAULT_RULE                 = 273;

//                // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId
//                public static final short REQ_DELETE_PRODUCT_DEFAULT_RULE               = 274;

//                // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/goals
//                public static final short REQ_GET_DEVICE_GOALS_BY_TYPE                  = 275;
                case REQ_GET_DEVICE_GOALS_BY_TYPE:
                    jsonBaseObj = new PPDeviceGoalParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/deviceType/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceTypeId")) ? m_jsonObjArgs.getString("deviceTypeId") : null);
                    sbURL.append("/goals");
                    sbURL.append("?appName=");
                    sbURL.append((m_jsonObjArgs.containsKey("appName")) ? m_jsonObjArgs.getString("appName") : null);
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_GOALS_BY_TYPE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;

//                // https://app.presencepro.com/cloud/json/goals/goalId/installation
//                public static final short REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS      = 276;
                case REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS:
                    jsonBaseObj = new PPDeviceInstallationJsonPaser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/goals/");
                    sbURL.append((m_jsonObjArgs.containsKey("goalId")) ? m_jsonObjArgs.getString("goalId") : null);
                    sbURL.append("/installation");
                    sbURL.append("?appName=");
                    sbURL.append((m_jsonObjArgs.containsKey("appName")) ? m_jsonObjArgs.getString("appName") : null);
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;

//                // https://app.presencepro.com/cloud/json/hardwareOrders?userId=userId
//                public static final short REQ_GET_HARDWARE_ORDERS                       = 277;

//                // https://app.presencepro.com/cloud/json/hardwareOrders/orderId/status/status?userId=userId&changeDate=changeDate
//                public static final short REQ_PUT_SET_HARDWARE_ORDERS                   = 278;

                /* OAuth 2.0 Client */
//                // https://app.presencepro.com/cloud/json/authorize
//                public static final short REQ_GET_SUPPORTED_THIRD_PARTY_APPS            = 280;
                case REQ_GET_SUPPORTED_THIRD_PARTY_APPS:
                    jsonBaseObj = new PPThirdpartyApplicationsJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/authorize");
                    appendParameter(sbURL, "locationId");
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_SUPPORTED_THIRD_PARTY_APPS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
//
//                // https://app.presencepro.com/auth/authorize/appId?API_KEY=API_KEY
//                public static final short REQ_GET_ACCESS_THIRD_PARTY_APP                = 281;
//
//                // https://app.presencepro.com/cloud/json/authorize/applicationId?userId=userId
//                public static final short REQ_DELETE_REMOVE_THIRD_PARTY_APP_SUPPORT     = 282;


                /* OAuth 2.0 Host */
//                // https://app.presencepro.com/oauth/authorize?client_id=client_id&state=state&response_type=response_type
//                public static final short REQ_GET_AUTHORIZE_THIRD_PARTY_APP             = 283;
//
//                // https://app.presencepro.com/auth/approve/approved?client_id=client_id&state=state&response_type=response_type&API_KEY=API_KEY
//                public static final short REQ_GET_APPROVE_OR_DENY_APP_AUTHORIZATION     = 284;
//
//                // https://app.presencepro.com/oauth/token?code=code&refresh_token=refresh_token&client_id=client_id
//                public static final short REQ_POST_GET_ACCESS_TOKEN                     = 285;
//
//                // https://app.presencepro.com/cloud/authClient?client_id=client_id&userId=userId
//                public static final short REQ_DELETE_REVOKE_OAUTH_CLIENTS               = 286;


                /* FRIENDS */
//                // https://app.presencepro.com/cloud/json/friends
//                public static final short REQ_POST_ADD_FRIENDS                          = 290;
                case REQ_POST_ADD_FRIENDS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/friends");
                    sbData.append((m_jsonObjArgs.containsKey("friendsObj")) ? m_jsonObjArgs.getJSONObject("friendsObj").toString() : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_ADD_FRIENDS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/friends?friendshipId=friendshipId&deviceId=deviceId&checkConnected=checkConnected
//                public static final short REQ_GET_FRIENDS                               = 291;
                case REQ_GET_FRIENDS:
                    jsonBaseObj = new PPFriendInfoJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/friends");
                    appendParameter(sbURL, "friendshipId");
                    appendParameter(sbURL, "deviceId");
                    appendParameter(sbURL, "checkConnected");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_FRIENDS");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/friends/friendshipId
//                public static final short REQ_PUT_UPDATE_FRIENDSHIP                     = 292;
                case REQ_BLOCK_FRIEND:
                case REQ_PUT_UPDATE_FRIENDSHIP:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/friends/");
                    sbURL.append((m_jsonObjArgs.containsKey("friendshipId")) ? m_jsonObjArgs.getString("friendshipId") : null);
                    sbData.append((m_jsonObjArgs.containsKey("friendObj")) ? m_jsonObjArgs.getJSONObject("friendObj").toString() : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    PPVirtuosoLogTrace.d(TAG, "REQ_PUT_UPDATE_FRIENDSHIP");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    PPVirtuosoLogTrace.d(TAG, "sbData: " + sbData.toString());
                    break;

//                // https://app.presencepro.com/cloud/json/friends/friendshipId
//                public static final short REQ_DELETE_FRIENDSHIP                         = 293;
                case REQ_DELETE_FRIENDSHIP:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/friends/");
                    sbURL.append((m_jsonObjArgs.containsKey("friendshipId")) ? m_jsonObjArgs.getString("friendshipId") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_FRIENDSHIP");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//                // https://app.presencepro.com/cloud/json/friends/friendshipId/devices/deviceId
//                public static final short REQ_DELETE_SHARED_DEVICE                      = 294;
                case REQ_DELETE_SHARED_DEVICE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/friends/");
                    sbURL.append((m_jsonObjArgs.containsKey("friendshipId")) ? m_jsonObjArgs.getString("friendshipId") : null);
                    sbURL.append("/devices/");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_DELETE_SHARED_DEVICE");
                    PPVirtuosoLogTrace.d(TAG, "sbURL: " + sbURL.toString());
                    break;
//
//    /* REPORTS */
//                // https://app.presencepro.com/espapi/report/json/totalDeviceAlerts?alertType=alertType
//                public static final short REQ_GET_TOTAL_DEVICE_ALERTS                   = 300;
                //HIDDEN API
                case REQ_GET_USER_BY_EMAIL:
                    jsonBaseObj = new PPFriendProspectJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/users?email=");
                    sbURL.append((m_jsonObjArgs.containsKey("email")) ? URLEncoder.encode(m_jsonObjArgs.getString("email"), "utf-8") : null);

                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_USER_BY_EMAIL");
                    break;
                case REQ_POST_USER_BY_PHONEORMAIL:
                    jsonBaseObj = new PPAccountUserParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/users?");
                    sbData.append(m_jsonObjArgs.remove("data"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());

                    PPVirtuosoLogTrace.d(TAG, "REQ_POST_USER_BY_PHONEORMAIL");
                    break;
                case REQ_GET_USER_BY_PHONEORMAIL:
                    jsonBaseObj = new PPAccountUserParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/users?");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());

                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_USER_BY_PHONEORMAIL");
                    break;
                /** THESE ARE DEVICE IO CALLS **/
                case REQ_SET_DEVICE_DEFAULT_PARAMETERS:
                case REQ_SET_DEVICE_DEFAULT_PARAMETER:
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/deviceio");
                    sbURL.append("/mljson");
                    sbData.append("{");
                    sbData.append("\"seq\":\"");
                    sbData.append(m_Prefs.getNextSequenceValue());
                    sbData.append("\",");
                    sbData.append("\"version\":\"2\",");
                    sbData.append("\"proxyId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"measures\":[");
                    sbData.append("{\"deviceId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"params\":");
                    if (m_objList != null) {
                        sbData.append(Arrays.asList(m_objList).toString());
                    }
                    sbData.append("}]");
                    if ((m_jsonObjArgs.containsKey("commandId"))) {
                        sbData.append(",\"responses\":[");
                        sbData.append("{\"commandId\":");
                        sbData.append((m_jsonObjArgs.containsKey("commandId")) ? m_jsonObjArgs.getString("commandId") : null);
                        sbData.append(",\"result\":");
                        sbData.append((m_jsonObjArgs.containsKey("result")) ? m_jsonObjArgs.getString("result") : null);
                        sbData.append("}]");
                    }
                    sbData.append("}");
                    if (sbData.toString() != null && m_httpTransfer != null) {
                        m_httpTransfer.addValue(sbData.toString());
                        m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs.getString("EspToken") : null);
                    }
                    PPVirtuosoLogTrace.d(TAG, "REQ_SET_DEVICE_DEFAULT_PARAMETER");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

                case REQ_SET_DEVICE_COMMAND_RESPONSE:
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/deviceio");
                    sbURL.append("/mljson");
                    sbData.append("{");
                    sbData.append("\"seq\":\"");
                    sbData.append(m_Prefs.getNextSequenceValue());
                    sbData.append("\",");
                    sbData.append("\"version\":\"2\",");
                    sbData.append("\"proxyId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    if ((m_jsonObjArgs.containsKey("commandId"))) {
                        sbData.append(",\"responses\":[");
                        sbData.append("{\"commandId\":");
                        sbData.append((m_jsonObjArgs.containsKey("commandId")) ? m_jsonObjArgs.getString("commandId") : null);
                        sbData.append(",\"result\":");
                        sbData.append((m_jsonObjArgs.containsKey("result")) ? m_jsonObjArgs.getString("result") : null);
                        sbData.append("}]");
                    }
                    sbData.append("}");
                    if (sbData.toString() != null && m_httpTransfer != null) {
                        m_httpTransfer.addValue(sbData.toString());
                        m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs.getString("EspToken") : null);
                    }
                    PPVirtuosoLogTrace.d(TAG, "REQ_SET_DEVICE_COMMAND_RESPONSE");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;

                case REQ_SET_DEVICE_MOTION_ACTIVITY:
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/deviceio");
                    sbURL.append("/mljson");
                    sbData.append("{");
                    sbData.append("\"seq\":\"");
                    sbData.append(m_Prefs.getNextSequenceValue());
                    sbData.append("\",");
                    sbData.append("\"version\":\"2\",");
                    sbData.append("\"proxyId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"measures\":[");
                    sbData.append("{\"deviceId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"params\":");
                    if (m_objList != null) {
                        sbData.append(Arrays.asList(m_objList).toString());
                    }
                    sbData.append("}]");
                    sbData.append("}");
                    m_httpTransfer.addValue(sbData.toString());
                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs
                        .getString("EspToken") : null);
                    PPVirtuosoLogTrace.d(TAG, "REQ_SET_DEVICE_MOTION_ACTIVITY");
                    PPVirtuosoLogTrace.d(TAG, "Send: " + sbData.toString());
                    break;
                case REQ_GET_STREAMING_SESSION_CAMERA:
                    jsonBaseObj = new PPStreamingInfoJsonParser();
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/streaming");
                    sbURL.append("/session");
                    sbURL.append("?deviceId=");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs
                        .getString("EspToken") : null);
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_STREAMING_SESSION");
                    break;

                case REQ_GET_STREAMING_SESSION_VIEWER:
                    jsonBaseObj = new PPStreamingInfoJsonParser();
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/streaming");
                    sbURL.append("/session");
                    sbURL.append("?deviceId=");
                    sbURL.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    PPVirtuosoLogTrace.d(TAG, "REQ_GET_STREAMING_SESSION");
                    break;

                case REQ_SET_MOTION_ALERT_USER:
                    sbURL.append((m_jsonObjArgs.containsKey("HostName")) ? m_jsonObjArgs.getString("HostName") : null);
                    sbURL.append(":");
                    sbURL.append((m_jsonObjArgs.containsKey("Port")) ? m_jsonObjArgs.getString("Port") : null);
                    sbURL.append("/deviceio");
                    sbURL.append("/mljson");
                    sbData.append("{");
                    sbData.append("\"seq\":\"");
                    sbData.append(m_Prefs.getNextSequenceValue());
                    sbData.append("\",");
                    sbData.append("\"version\":\"2\",");
                    sbData.append("\"proxyId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("DeviceId")) ? m_jsonObjArgs.getString("DeviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"alerts\":[");
                    sbData.append("{\"deviceId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("DeviceId")) ? m_jsonObjArgs.getString("DeviceId") : null);
                    sbData.append("\"");
                    sbData.append(",\"alertType\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("Type")) ? m_jsonObjArgs.getString("Type") : null);
                    sbData.append("\"");
                    sbData.append(",\"params\":");
                    sbData.append(m_objList[0].toString());
                    //if (m_objList != null) {
                    //	sbData.append(Arrays.asList(m_objList).toString());
                    //}
                    sbData.append("}]");
                    sbData.append("}");
                    m_httpTransfer.addValue(sbData.toString());
                    m_httpTransfer.setHeaderPPCAuthorizationValue((m_jsonObjArgs.containsKey("EspToken")) ? m_jsonObjArgs
                        .getString("EspToken") : null);
                    PPVirtuosoLogTrace.d("JsonParserMain", "REQ_SET_MOTION_ALERT_USER");
                    PPVirtuosoLogTrace.d("JsonParserMain", "Send: " + sbData.toString());
                    break;
                case REQ_GET_APP_INFORMATION:
                    jsonBaseObj = new PPAppInformationParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore/appInfo?");
                    sbURL.append(String.format("bundle=%s&", PPCommonInfo.APP_INFO_BUNDLE));
                    sbURL.append("lang=en");

                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_APP_INSTANCE:
                    jsonBaseObj = new PPAppInstanceParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore/appInstance?");

                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PURCHASE_APP_INSTANCE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore/appInstance");
                    appendParameter(sbURL, "bundle");

                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_DATA_STREAM_WITH_MASK:
                case REQ_POST_DATA_STREAM_WITH_MASK_FALSE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore/stream");
                    appendParameter(sbURL, "address");
                    appendParameter(sbURL, "locationId");
                    appendParameter(sbURL, "scope");
                    if (m_jsonObjArgs.containsKey("organizational")) {
                        appendParameter(sbURL, "organizational");
                    }
                    if (m_jsonObjArgs.containsKey("data")) {
                        sbData.append(m_jsonObjArgs.get("data"));
                        m_httpTransfer.addValue(sbData.toString());
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_CONFIGURE_APP_INSTANCE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore/appInstance?");
                    if (m_jsonObjArgs.containsKey("appInstanceId")) {
                        sbURL.append(String.format("appInstanceId=%d", m_jsonObjArgs.getInteger("appInstanceId")));
                    }
                    if (m_jsonObjArgs.containsKey("status")) {
                        sbURL.append(String.format("&status=%d", m_jsonObjArgs.getInteger("status")));
                    }
                    if (m_jsonObjArgs.containsKey("app")) {
                        String app = m_jsonObjArgs.getString("app");
                        m_httpTransfer.addValue(app);
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_DEVICE_MODEL_BY_DEVICETYPE:
                    bUpdateDatabase = true;
                    jsonBaseObj = new PPGetDeviceModelByTypeParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud/json/devicemodels");
                    bVisitDatabase = m_jsonObjArgs.getBooleanValue("visitDatabase");
                    appendParameter(sbURL, "brand");
                    break;
                case REQ_GET_DEVICE_MODELS:
                    bUpdateDatabase = true;
                    jsonBaseObj = new PPGetDeviceModelParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud/json/devicemodels");
                    bVisitDatabase = m_jsonObjArgs.getBooleanValue("visitDatabase");
                    appendParameter(sbURL, "brand");
                    appendParameter(sbURL, "searchBy");
                    if (m_jsonObjArgs.containsKey("hidden")) {
                        sbURL.append(String.format("&hidden=%d", m_jsonObjArgs.getInteger("hidden")));
                    }
                    if (m_jsonObjArgs.containsKey("lang")) {
                        sbURL.append(String.format("&lang=%s", m_jsonObjArgs.getString("lang")));
                    }
                    break;
                case REQ_GET_STORIES:
                    bUpdateDatabase = true;
                    jsonBaseObj = new PPGetStoryModelParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud/json/stories");
                    bVisitDatabase = m_jsonObjArgs.getBooleanValue("visitDatabase");
                    appendParameter(sbURL, "storyId");
                    appendParameter(sbURL, "modelId");
                    appendParameter(sbURL, "brand");
                    appendParameter(sbURL, "searchBy");
                    if (m_jsonObjArgs.containsKey("storyType")) {
                        sbURL.append(String.format("&storyType=%d", m_jsonObjArgs.getInteger("storyType")));
                    }
                    if (m_jsonObjArgs.containsKey("hidden")) {
                        sbURL.append(String.format("&hidden=%s", m_jsonObjArgs.getString("hidden")));
                    }
                    if (m_jsonObjArgs.containsKey("lang")) {
                        sbURL.append(String.format("&lang=%s", m_jsonObjArgs.getString("lang")));
                    }
                    break;
                case REQ_GET_LOCATION_SPACES:
                    jsonBaseObj = new PPGetLocationSpaceParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.getInteger("locationId"));
                    sbURL.append("/spaces");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_LINK_DEVICE_SPACE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.getInteger("locationId"));
                    sbURL.append("/devices/");
                    sbURL.append(m_jsonObjArgs.getString("deviceId"));
                    sbURL.append("/spaces/");
                    sbURL.append(m_jsonObjArgs.getInteger("spaceId"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_UNLINK_DEVICE_SPACE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.getInteger("locationId"));
                    sbURL.append("/devices/");
                    sbURL.append(m_jsonObjArgs.getString("deviceId"));
                    sbURL.append("/spaces/");
                    sbURL.append(m_jsonObjArgs.getInteger("spaceId"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_DELETE_LOCATION_SPACE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.getInteger("locationId"));
                    sbURL.append("/spaces?");
                    sbURL.append("spaceId=");
                    sbURL.append(m_jsonObjArgs.getInteger("spaceId"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_UPDATE_LOCATION_SPACE:
                    jsonBaseObj = new PPLocationSpaceUpdateParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.getInteger("locationId"));
                    sbURL.append("/spaces?");
                    if (m_jsonObjArgs.containsKey("spaceId")) {
                        sbURL.append("spaceId=");
                        sbURL.append(m_jsonObjArgs.getInteger("spaceId"));
                    }
                    m_httpTransfer.addValue(m_jsonObjArgs.getString("data"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_NARRATIVES:
                    jsonBaseObj = new PPNarrativesParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/narratives");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_NARRATIVE_QUESTIONS:
                    jsonBaseObj = new PPNarrativeQuestionsParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/questions?");
                    if (m_jsonObjArgs.containsKey("answerStatus")) {
                        String answerStatus = (String) m_jsonObjArgs.remove("answerStatus");
                        sbURL.append(answerStatus);
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_USERS:
                    jsonBaseObj = new PPLocationUserParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/users");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_USERS_WITH_FILTERS:
                    jsonBaseObj = new PPLocationUserFilteredParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/users");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_TASK_USERS:
                    jsonBaseObj = new PPLocationUserSupportTaskParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/users");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_LOCATION_USERS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/users");
                    String data = (String) m_jsonObjArgs.remove("data");
                    m_httpTransfer.addValue(data);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_DELETE_LOCATION_USER:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/users");
                    appendParameter(sbURL, "userId");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_STATE:
                case REQ_GET_LOCATION_OTHER_STATE:
                    jsonBaseObj = new PPLocationStateParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/state?");
                    if (m_jsonObjArgs.containsKey("names")) {
                        sbURL.append(m_jsonObjArgs.remove("names"));
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_TIME_STATE:
                    jsonBaseObj = new PPLocationStateParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/timeStates");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_LOCATION_DASHBOARD:
                    jsonBaseObj = new PPLocationDashboardParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/state?");
                    if (m_jsonObjArgs.containsKey("names")) {
                        sbURL.append(m_jsonObjArgs.remove("names"));
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_LOCATION_STATE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/locations/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/state");
                    appendParameter(sbURL, "name");
                    m_httpTransfer.addValue((String) m_jsonObjArgs.remove("data"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_SEND_PASSCODE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/passcode");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_DATA_REQUEST:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/dataRequests");
                    appendParameter(sbURL, "locationId");

                    String dataRequestValue = (String) m_jsonObjArgs.remove("data");
                    m_httpTransfer.addValue(dataRequestValue);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_PRESENCE_IDS:
                    jsonBaseObj = new PPAppPresenceIdsParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/presence");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());

                    break;
                case REQ_POST_AUTH_ACCESS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/presence");

                    String beaconValue = (String) m_jsonObjArgs.remove("data");
                    m_httpTransfer.addValue(beaconValue);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_COMMUNITY_POSTS:
                    jsonBaseObj = new PPCommunityPostJsonParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_CREATE_COMMUNITY_POST:
                case REQ_UPDATE_COMMUNITY_POST:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts");
                    m_httpTransfer.addValue((String) m_jsonObjArgs.remove("data"));
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_DELETE_COMMUNITY_POST:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_CREATE_COMMUNITY_COMMENT:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPostComments");
                    String commentData = (String) m_jsonObjArgs.remove("data");
                    appendParameters("?", sbURL);
                    m_httpTransfer.addValue(commentData);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_DELETE_COMMUNITY_COMMENT:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPostComments");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_CREATE_COMMUNITY_REACTION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPostReaction");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_BOT_SUMMARY:
                    jsonBaseObj = new PPBotSummaryParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/appstore");
                    sbURL.append("/summary");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_POST_UPLOAD_POST_FILE:
                    jsonBaseObj = new PPPostUploadFileParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts/");
                    sbURL.append(m_jsonObjArgs.remove("postId"));
                    sbURL.append("/files");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_UPLOAD_FILE_DONE:
                case REQ_DELETE_POST_FILE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts/");
                    sbURL.append(m_jsonObjArgs.remove("postId"));
                    sbURL.append("/files");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_POST_FILE_URL:
                    jsonBaseObj = new PPGetPostFileUrlParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/communityPosts/");
                    sbURL.append(m_jsonObjArgs.remove("postId"));
                    sbURL.append("/files");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_USER_CODE:
                case REQ_PUT_USER_CODE_DEVICE_ID:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userCodes");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    if (m_objList[0] != null) {
                        sbData.append(m_objList[0].toString());
                    } else {
                        sbData.append("{}");
                    }
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    break;
                case REQ_DELETE_USER_CODE:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userCodes");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_GET_USER_CODE:
                    jsonBaseObj = new PPUserCodeParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userCodes");
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
//              https://app.presencepro.com/cloud/json/surveys?brand=
                case REQ_GET_SURVEY_QUESTIONS:
                    jsonBaseObj = new PPSurveyQuestionsParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/surveys");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_ANSWER_SURVEY_QUESTIONS:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/surveys");
                    sbData.append(m_jsonObjArgs.remove("data"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    m_httpTransfer.addValue(sbData.toString());
                    break;
                case REQ_GET_ORGANIZATION_PROPERTIES:
                    jsonBaseObj = new PPOrganizationPropertiesParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/admin");
                    sbURL.append("/json");
                    sbURL.append("/organizations/");
                    sbURL.append(m_jsonObjArgs.remove("organizationId"));
                    sbURL.append("/objects");
                    break;
                case REQ_GET_ORGANIZATION_OBJECT_CONTENT:
                    sbURL.append(getServerUrl());
                    sbURL.append("/admin");
                    sbURL.append("/json");
                    sbURL.append("/organizations/");
                    sbURL.append(m_jsonObjArgs.remove("organizationId"));
                    sbURL.append("/objects/");
                    sbURL.append(m_jsonObjArgs.remove("objectName"));
                    break;
                case REQ_GET_LOCATION_SERVICE_PLANS:
                    jsonBaseObj = new PPLocationServicePlanParser();
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/userServicePlans");
                    appendParameters("?", sbURL);
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_ADD_LOCATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/admin");
                    sbURL.append("/json");
                    sbURL.append("/organizations/");
                    sbURL.append(m_jsonObjArgs.remove("organizationId"));
                    sbURL.append("/locationStatus/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                case REQ_PUT_MOVE_LOCATION:
                    sbURL.append(getServerUrl());
                    sbURL.append("/cloud");
                    sbURL.append("/json");
                    sbURL.append("/location/");
                    sbURL.append(m_jsonObjArgs.remove("locationId"));
                    sbURL.append("/organization/");
                    sbURL.append(m_jsonObjArgs.remove("domainName"));
                    m_httpTransfer.setHeaderApiKeyValue(m_Prefs.getUserKey());
                    break;
                default:
                    throw new Exception("Found not dspID");
            }

            String url = sbURL.toString();
            PPVirtuosoLogTrace.d(TAG, "URL: " + url);
            if (m_httpTransfer != null) {
                String strResult = null;
                if (bVisitDatabase) {
                    strResult = history(PPVirtuoso.getInstance().getContext(), url);
                }
                if (TextUtils.isEmpty(strResult)) {
                    strResult = m_httpTransfer.PostData(url, m_nReqID);
                }

                if (!TextUtils.isEmpty(strResult)) {
                    JSONObject jsonData = null;
                    String strResultCode = null;

                    try {
                        PPVirtuosoLogTrace.d(TAG, "Result:%s", strResult);
                        //If it's not json format,check the currency unit(system property result is not json format)
                        if (checkProperties(msg, strResult)) {
                            return msg;
                        }

                        if (PPCommonInfo.isJSONValid(strResult)) {
                            jsonData = JSONObject.parseObject(strResult);
                        } else {
                            PPVirtuosoLogTrace.d(TAG, "Server result is not Json format");
                        }
                        if (jsonData != null) {
                            if (jsonData.containsKey("resultCode")) {
                                strResultCode = jsonData.getString("resultCode");
                                if (strResultCode.equals("0")) {
                                    if (jsonBaseObj != null) {
                                        if (bUpdateDatabase) {
                                            updateJSONToDatabase(PPVirtuoso.getInstance().getContext(), strResult, url);
                                        }
                                        publishProgress(jsonBaseObj, jsonData, msg);
                                    } else {
                                        if (m_nReqID == REQ_PURCHASE_APP_INSTANCE) {
                                            int appInstanceId = jsonData.getIntValue("appInstanceId");
                                            msg.obj = appInstanceId;
                                        } else if (m_nReqID == REQ_POST_AUTH_ACCESS) {
                                            String locationId = jsonData.getString("locationId");
                                            PPBeaconModel beaconModel = (PPBeaconModel) m_objList[0];
                                            beaconModel.locationId = locationId;
                                            msg.obj = beaconModel;
                                        } else if (m_nReqID == REQ_CREATE_COMMUNITY_POST) {
                                            String postId = jsonData.getString("postId");
                                            msg.obj = postId;
                                        }
                                        msg.arg1 = RES_SUCCESS; //
                                        return msg;
                                    }
                                } else {
                                    PPVirtuosoLogTrace.e(TAG, "Error : ReqID: %d", m_nReqID);
                                    PPVirtuosoLogTrace.e(TAG, "ResultCode: %s", jsonData.getString("resultCode"));
                                    String errorMessage = jsonData.getString("resultCodeMessage");
                                    if (TextUtils.isEmpty(errorMessage)) {
                                        errorMessage = jsonData.getString("resultCodeDesc");
                                    }
                                    msg.obj = errorMessage;
                                    msg.arg2 = Integer.parseInt(strResultCode);
                                }
                            } else if (jsonData.containsKey("status")) {
                                // TODO different codes we are getting from
                                // server as a repsonse
                                // "ACK", "CONT", "ERR", "ERR_FORMAT",
                                // "UNKNOWN", "UNAUTHORIZED", "ERR", "ERR"
                                if (jsonData.getString("status").equalsIgnoreCase("ACK") || jsonData.getString("status").equalsIgnoreCase("CONT")) {
                                    msg.arg1 = RES_SUCCESS;
                                    msg.obj = strResult;
                                } else {
                                    msg.arg1 = RES_FAILURE;
                                    msg.obj = jsonData;
                                }
                            } else if (jsonData.containsKey("data")) {
                                JSONArray dataArray = jsonData.getJSONArray("data");
                                if (null != dataArray && !dataArray.isEmpty()) {
                                    if (jsonBaseObj != null) {
                                        publishProgress(jsonBaseObj, jsonData, msg);
                                    } else {
                                        msg.arg1 = RES_SUCCESS; //
                                    }
                                } else {
                                    msg.arg1 = RES_FAILURE;
                                }
                                return msg;
                            } else {
                                PPVirtuosoLogTrace.e(TAG, "Error : ReqID: %d", m_nReqID);
                                PPVirtuosoLogTrace.e(TAG, "ResultCode: %s", jsonData.getString("resultCode"));
                                msg.obj = jsonData.getString("resultCodeMessage");
                                msg.arg2 = Integer.parseInt(strResultCode);
                            }
                        } else if (m_nReqID == REQ_GET_ORGANIZATION_OBJECT_CONTENT) {
                            msg.arg1 = RES_SUCCESS;
                            return msg;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if (m_jsonObjArgs.containsKey("propertyName") && m_jsonObjArgs.get("propertyName")
                        .equals(PPCommonInfo.OOBE_PROPERTY_NAME_STANDARD)) {
                        msg.arg1 = RES_SUCCESS;
                        msg.obj = "0";
                        return msg;
                    } else {
                        msg.arg2 = m_httpTransfer.getLastError();
                        msg.obj = null;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

            if (isCancelled() || m_httpTransfer == null) {
                msg.arg2 = PPHttpTransfer.ERROR_CANCEL;
                msg.obj = null;
            } else {
                msg.arg2 = (m_httpTransfer.getLastError() != PPHttpTransfer.ERROR_OK) ? m_httpTransfer.getLastError() : PPHttpTransfer.ERROR_FAILED;
                msg.obj = null;
            }
        }
        m_nLastError = msg.arg2;
        return msg;

    }

    @Override
    protected void onProgressUpdate(Object... obj) {
        if (!m_bExit) {
            if (((PPBaseJsonParser) obj[0]).setData((JSONObject) obj[1], m_objList)) {
                Message msg = (Message) obj[2];
                msg.arg1 = RES_SUCCESS;
            } else {
                Message msg = (Message) obj[2];
            }
            obj[0] = null;
        }
    }

    @Override
    protected void onPostExecute(Message msg) {
        if (!m_bExit && m_handler != null) {
            m_handler.sendMessage(msg);
        }
        m_httpTransfer = null;
        if (m_vector != null) {
            m_vector.remove(this);
        }
    }

    private void updateJSONToDatabase(Context context, String jsonContent, String url) {
        ContentResolver contentResolver = context.getContentResolver();
        ContentValues values = new ContentValues();
        String columns[] = new String[]{JSONColumn._ID, JSONColumn.URL, JSONColumn.JSON, JSONColumn.CREATED_TIME};
        Cursor cur = contentResolver.query(JSONColumn.CONTENT_URI, columns, "url = ?",
            new String[]{url}, null);

        if (cur != null && cur.getCount() > 0) {
            values.put(JSONColumn.JSON, jsonContent);
            values.put(JSONColumn.CREATED_TIME, String.valueOf(System.currentTimeMillis()));
            contentResolver.update(JSONColumn.CONTENT_URI, values, "url = ?", new String[]{url});
        } else {
            values.put(JSONColumn.URL, url);
            values.put(JSONColumn.JSON, jsonContent);
            values.put(JSONColumn.CREATED_TIME, String.valueOf(System.currentTimeMillis()));
            contentResolver.insert(JSONColumn.CONTENT_URI, values);
        }
        if (cur != null) {
            cur.close();
        }
    }

    private String history(Context context, String url) {
        String columns[] = new String[]{JSONColumn._ID, JSONColumn.URL, JSONColumn.JSON, JSONColumn.CREATED_TIME};
        String selection;
        String[] selectionArgs;
        selection = JSONColumn.URL + " = ? ";
        selectionArgs = new String[]{url};
        Cursor cur = context.getContentResolver().query(JSONColumn.CONTENT_URI,
            columns, selection, selectionArgs, null);

        if (cur != null && cur.getCount() > 0) {
            cur.moveToFirst();
            String jsonString = cur.getString(cur.getColumnIndex(JSONColumn.JSON));
            String createTime = cur.getString(cur.getColumnIndex(JSONColumn.CREATED_TIME));
            long createTimeLong = Long.parseLong(createTime);
            long delta = (System.currentTimeMillis() - createTimeLong) / 1000;
            //We store the history for 2 hours;
            if (delta > 7200) {
                jsonString = null;
            }
            cur.close();
            return jsonString;
        }

        if (cur != null) {
            cur.close();
        }
        return null;
    }

    private boolean checkProperties(Message msg, String strResult) {
        if (PPCommonInfo.checkCurrencyCode(strResult)) {
            PPCommonInfo.setCurrencyCode(strResult.replace("\n", ""));
            msg.arg1 = RES_SUCCESS;
            msg.obj = strResult.replace("\n", "");
            return true;
        } else if (PPCommonInfo.checkCurrencyCountry(strResult)) {
            msg.arg1 = RES_SUCCESS;
            msg.obj = strResult.replace("\n", "");
            return true;
        } else if (m_nReqID == REQ_GET_SYSTEM_OR_USER_PROPERTY && m_jsonObjArgs.containsKey("propertyName")) {
            if (m_jsonObjArgs.get("propertyName").equals(PPCommonInfo.ANDROID_TERMS_OF_SERVICE)) {
                msg.arg1 = RES_SUCCESS;
                strResult = strResult.replace("\n", "");
                m_Prefs.setTermsOfServiceSignature(PPCommonInfo.ANDROID_TERMS_OF_SERVICE, strResult);
            } else if (m_jsonObjArgs.get("propertyName").equals(PPCommonInfo.EVENT_TRACK_CLOUD_DATA_EXCEPTION)) {
                msg.arg1 = RES_SUCCESS;
                PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED, !TextUtils.isEmpty(strResult) && strResult.contains("true"));
            } else if (m_jsonObjArgs.get("propertyName").equals(PPCommonInfo.POST_FILE_CONTENT_LIMIT)) {
                msg.arg1 = RES_SUCCESS;
                if (!TextUtils.isEmpty(strResult)) {
                    String contentLimit = strResult.replace("\n", "");
                    PPAppCenter.m_SharedPresence.setKeyLongValue(PPCommonInfo.POST_FILE_CONTENT_LIMIT_KEY, Long.parseLong(contentLimit));
                }
            } else if (m_jsonObjArgs.get("propertyName").equals(PPCommonInfo.BRAND_LOCATION_ACCESS)) {
                msg.arg1 = RES_SUCCESS;
                if (!TextUtils.isEmpty(strResult)) {
                    String contentLimit = strResult.replace("\n", "");
                    PPAppCenter.m_SharedPresence.setKeyStringValue(PPCommonInfo.BRAND_LOCATION_ACCESS, contentLimit);
                } else {
                    PPAppCenter.m_SharedPresence.setKeyStringValue(PPCommonInfo.BRAND_LOCATION_ACCESS, null);
                }
            }
            return true;
        }
        return false;
    }
}
