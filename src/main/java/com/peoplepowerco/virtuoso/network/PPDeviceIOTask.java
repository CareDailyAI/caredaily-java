package com.peoplepowerco.virtuoso.network;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.parser.PPBaseJsonParser;
import com.peoplepowerco.virtuoso.parser.PPStreamingInfoJsonParser;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by laghee on 12/4/17.
 */

public class PPDeviceIOTask extends AsyncTask<Void, Object, Message> implements IPPVirtuosoTypes {
    private static final String TAG = PPDeviceIOTask.class.getSimpleName();
    public int m_nReqID;
    public JSONObject m_jsonObjArgs;
    public Object[] m_objList;
    public PPHttpDeviceIOTransfer m_httpTransfer;
    public boolean m_bExit;
    public int m_nLastError;
    public Handler m_handler = null;
    public Vector<PPDeviceIOTask> m_vector = null;
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

    @Override
    protected Message doInBackground(Void... params) {
        Message msg = m_handler.obtainMessage();

        msg.what = m_nReqID;
        msg.arg1 = RES_FAILURE;
        msg.arg2 = PPHttpTransfer.ERROR_OK;
        msg.obj = null;
        String sJsonData = null;

        int iSequence = m_Prefs.getNextSequenceValue();

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
                    sbData.append(iSequence);
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
                    sbData.append(iSequence);
                    sbData.append("\",");
                    sbData.append("\"version\":\"2\",");
                    sbData.append("\"proxyId\":\"");
                    sbData.append((m_jsonObjArgs.containsKey("deviceId")) ? m_jsonObjArgs.getString("deviceId") : null);
                    sbData.append("\"");
                    if((m_jsonObjArgs.containsKey("commandId"))){
                        sbData.append(",\"responses\":[");
                        sbData.append("{\"commandId\":");
                        sbData.append((m_jsonObjArgs.containsKey("commandId")) ? m_jsonObjArgs.getString("commandId") : null);
                        sbData.append(",\"result\":");
                        sbData.append((m_jsonObjArgs.containsKey("result")) ? m_jsonObjArgs.getString("result") : null);
                        sbData.append("}]");
                    }
                    sbData.append("}");
                    if(sbData.toString() !=null && m_httpTransfer !=null){
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
                    sbData.append(iSequence);
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
                    //TODO: Do we need this header API key to get streaming info?
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
                    sbData.append(iSequence);
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

                default:
                    throw new Exception("Found not dspID");
            }

            PPVirtuosoLogTrace.d(TAG, "URL: " + sbURL.toString());
            if (m_httpTransfer != null) {
                String strResult = m_httpTransfer.PostData(sbURL.toString(), m_nReqID);

                if (strResult != null) {
                    JSONObject jsonData = null;
                    String strResultCode = null;

                    try {
                        PPVirtuosoLogTrace.d(TAG, "Result:%s", strResult);

                        if (PPCommonInfo.isJSONValid(strResult)) {
                            jsonData = JSONObject.parseObject(strResult);
                        } else {
                            PPVirtuosoLogTrace.d(TAG, "Server result is not Json format");
                        }

                        if (jsonData != null) {
                            if (jsonData.containsKey("resultCode")) {
                                strResultCode = jsonData.getString("resultCode");
                                if (strResultCode.equals("0") == true) {
                                    if (jsonBaseObj != null) {
                                        publishProgress(jsonBaseObj, jsonData, msg);
                                    } else {
                                        msg.arg1 = RES_SUCCESS; //
                                    }
                                } else {
                                    PPVirtuosoLogTrace.e(TAG, "Error : ReqID: %d", m_nReqID);
                                    PPVirtuosoLogTrace.e(TAG, "ResultCode: %s", jsonData.getString("resultCode"));
                                    if(strResultCode.equals("22")){
                                        msg.obj = jsonData.getString("resultCodeMessage");
                                    }else {
                                        msg.obj = jsonData.getString("resultCodeDesc");
                                    }
                                    msg.arg2 = Integer.parseInt(strResultCode);
//                                    if (m_nReqID == REQ_GET_LOGIN_USERNAME) {
//                                        msg.obj = jsonData;
//                                    }
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
                            } else {
                                PPVirtuosoLogTrace.e(TAG, "Error : ReqID: %d", m_nReqID);
                                PPVirtuosoLogTrace.e(TAG, "ResultCode: %s", jsonData.getString("resultCode"));
                                msg.obj = jsonData.getString("resultCodeDesc");
                                msg.arg2 = Integer.parseInt(strResultCode);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    msg.arg2 = m_httpTransfer.getLastError();
                    msg.obj = null;
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
        if (m_bExit == false) {
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
}
