/**
 * @FileName : PPHttpTransfer.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.network;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * Class to handle HTTP calls.
 */
public class PPHttpDeviceIOTransfer implements IPPVirtuosoTypes {
    private static final String TAG = PPHttpDeviceIOTransfer.class.getSimpleName();

    public static final char TRANS_GET = 1;
    public static final char TRANS_POST = 2;
    public static final char TRANS_PUT = 3;
    public static final char TRANS_DELETE = 4;

    public static final short ERROR_OK = -1;
    public static final short ERROR_FAILED = -2;
    public static final short ERROR_CANCEL = -3;
    public static final short ERROR_STOP = -4;
    public static final short ERROR_CONNECTION = -5;
    public static final short ERROR_RESPONSE = -6;
    public static final short ERROR_IOEXCEPTION = -7;
    public static final short ERROR_TIMEOUT = -8;
    public static final short ERROR_ALREADY_CONNECTION = -12;
    public static final short ERROR_EMAIL_ADDRESS = 8;
    public static final short ERROR_PASSWORD_USERNAME = 12;
    public static final short ERROR_LOCKED_USER = 16;
    public static final short ERROR_DUPLICATE_USERNAME = 20;

    public static final short ERROR_API_NOT_FOUND = 29;

    private String m_strCharset = "UTF-8";
    private char m_chTransType = TRANS_GET;
    private String m_strContentType = "multipart/form-data";
    private String m_strPPCAuthorizationVaule = null;
    private String m_strHeaderPassWordVaule = null;
    private String m_strHeaderApiKeyVaule = null;
    private String m_strHeaderOperationToken = null;
    private ArrayList<String> m_arValue = null;

    public short m_nLastError = ERROR_OK;
    private boolean m_bConnection = false;
    private byte[] m_videoData = null;

    private String m_sUserAgent = null;
    private String m_sDeviceUniqueId = null;
    private String m_sDeviceModel = null;

    /**
     * Constructor
     */
    public PPHttpDeviceIOTransfer() {
//        m_sUserAgent = PPVirtuoso.getInstance(null).getUserAgent(); //PPCommonInfo.getUserAgentInformation(m_context);
//        m_sDeviceUniqueId = PPVirtuoso.getInstance(null).getDeviceUniqueId(); //PPCommonInfo.getDeviceUniqueId(m_context);
//        m_sDeviceModel = PPVirtuoso.getInstance(null).getDeviceModel(); //PPCommonInfo.getPhoneModel();
    }

    /**
     * Set trans mode POST/GET
     *
     * @param chType
     */
    public void setTransMode(char chType) {
        m_chTransType = chType;
    }

    /**
     * Set content type
     *
     * @param strType
     */
    public void setContentType(String strType) {
        m_strContentType = strType;
    }

    /**
     * Set Header password value
     *
     * @param strValue
     */
    public void setHeaderPassWordValue(String strValue) {
        m_strHeaderPassWordVaule = strValue;
    }

    /**
     * Set Header Apikey value
     *
     * @param strValue
     */
    public void setHeaderApiKeyValue(String strValue) {
        m_strHeaderApiKeyVaule = strValue;
        //PPVirtuosoLogTrace.d(TAG, "HeaderApiKeyValue ===================== " + m_strHeaderApiKeyVaule);
    }

    public void setHeaderOperationToken(String strValue) {
        m_strHeaderOperationToken = strValue;
        //PPVirtuosoLogTrace.d(TAG, "Operation token header Value ===================== " + m_strHeaderOperationToken);
    }

    /**
     * Set Header Value
     *
     * @param strValue
     */
    public void setHeaderPPCAuthorizationValue(String strValue) {
        m_strPPCAuthorizationVaule = strValue;
    }

    /**
     * Add string information
     *
     * @param strValue
     */
    public void addValue(String strValue) {
        if (m_arValue == null) {
            m_arValue = new ArrayList<String>();
        }
        m_arValue.add(strValue);
    }

    public void setInputByteArrayFileData(byte[] videoData) {
        this.m_videoData = videoData;
    }

    /**
     * Clear parameter information
     */
    public void clear() {
        if (m_arValue != null) {
            m_arValue.clear();
        }
        if (m_videoData != null) {
            m_videoData = null;
        }
    }

    /**
     * Send data str URL and receive string data
     *
     * @param strURL
     * @param nType
     * @return
     */
    public String PostData(String strURL, int nType) {
        if (m_bConnection == true) {
            m_nLastError = ERROR_ALREADY_CONNECTION;
            return null;
        } else if (strURL == null) {
            m_nLastError = ERROR_FAILED;
            return null;
        }
        m_nLastError = ERROR_OK;
        String strResult = sendData(strURL, nType);

        return strResult;
    }

    /**
     * Send data URL (Support GET, POST, PUT, DELETE)
     *
     * @param strURL
     * @param nType
     * @return
     */
    private String sendData(String strURL, int nType) {

        final int CONNECTION_TIMEOUT = 60000;
        final int READ_TIMEOUT = 60000;
        String response = null;

        m_sUserAgent = PPVirtuoso.getInstance().getUserAgent(); //PPCommonInfo.getUserAgentInformation(m_context);
        m_sDeviceUniqueId = PPVirtuoso.getInstance().getDeviceUniqueId(); //PPCommonInfo.getDeviceUniqueId(m_context);
        m_sDeviceModel = PPVirtuoso.getInstance().getDeviceModel(); //PPCommonInfo.getPhoneModel();

        try {

            //Added use agent information for all API
            StringBuffer responseStringBuilder = new StringBuffer();

            URL url = new URL(strURL);
            HttpURLConnection connection = null;

            //Check for https
            if (url.getProtocol().toLowerCase().equals("https")) {
                connection = PPHttpTransfer.getHttpURLConnection(url);
                PPVirtuosoLogTrace.d(TAG, "Https Connection");
            } else {
                connection = (HttpURLConnection) url.openConnection();
                PPVirtuosoLogTrace.d(TAG, "Http Connection");
            }

            HttpURLConnection httpURLConnection = connection;
            httpURLConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            httpURLConnection.setReadTimeout(READ_TIMEOUT);
            //Request mode
            if (m_chTransType == TRANS_GET) {
                httpURLConnection.setRequestMethod("GET");
                //httpURLConnection.setRequestProperty("Content-Type", "application/json");
                if (nType == REQ_GET_LOGIN_USERNAME) {
                    httpURLConnection.setRequestProperty("PASSWORD", m_strHeaderPassWordVaule);
                } else if (m_strPPCAuthorizationVaule != null) {
                    httpURLConnection.setRequestProperty("PPCAuthorization", "esp token=" + m_strPPCAuthorizationVaule);
                } else {
                    if (m_strHeaderApiKeyVaule != null) {
                        httpURLConnection.setRequestProperty("API_KEY", m_strHeaderApiKeyVaule);
                    }
                }
            } else if (m_chTransType == TRANS_POST) {
                httpURLConnection.setRequestMethod("POST");
                if (nType == REQ_POST_NEW_USER_AND_LOCATION) {
                    httpURLConnection.setRequestProperty("Charset", m_strCharset);
                    httpURLConnection.setRequestProperty("Content-Type", m_strContentType);
                    httpURLConnection.setRequestProperty("PASSWORD", m_strHeaderPassWordVaule);
                    httpURLConnection.setRequestProperty("PPCAuthorization", "op token=" + m_strHeaderOperationToken);
                }
            } else if (m_chTransType == TRANS_PUT) {
                httpURLConnection.setRequestMethod("PUT");
                if (nType == REQ_PUT_UPDATE_USER_INFO) {
                    httpURLConnection.setRequestProperty("PASSWORD", m_strHeaderPassWordVaule);
                }
            } else if (m_chTransType == TRANS_DELETE) {
                httpURLConnection.setRequestMethod("DELETE");
            }

            if (m_sUserAgent != null) {
                httpURLConnection.setRequestProperty("User-Agent", m_sUserAgent);
            }

            if (m_sDeviceUniqueId != null && m_sDeviceModel != null) {
                httpURLConnection.setRequestProperty("IOE_CALLER_ID", m_sDeviceUniqueId);
                httpURLConnection.setRequestProperty("IOE_CALLER_DESC", m_sDeviceModel);
            }

            if (m_strPPCAuthorizationVaule != null) {
                httpURLConnection.setRequestProperty("PPCAuthorization", "esp token=" + m_strPPCAuthorizationVaule);
            }

            if (nType == REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL || nType == REQ_POST_UPLOAD_NEW_FILE ||
                    nType == REQ_POST_DEVICE_FILE_VIDEO || nType == REQ_POST_DEVICE_FILE_THUMBNAIL) {
                httpURLConnection.setRequestProperty("Content-Type", "video/mp4");
                httpURLConnection.setRequestProperty("PPCAuthorization", "esp token=" + m_strPPCAuthorizationVaule);
            } else {
                httpURLConnection.setRequestProperty("Content-Type", m_strContentType);
            }

            httpURLConnection.setRequestProperty("Charset", m_strCharset);
            if (m_strHeaderApiKeyVaule != null) {
                httpURLConnection.setRequestProperty("API_KEY", m_strHeaderApiKeyVaule);
            }

            if (m_chTransType == TRANS_GET || m_chTransType == TRANS_DELETE) {
                httpURLConnection.setDoInput(true);
            } else {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                if (m_arValue != null) {
                    for (String strValue : m_arValue) {
                        if (m_chTransType == TRANS_POST || m_chTransType == TRANS_PUT) {
                            outputStream.write(strValue.getBytes("UTF-8"));
                            outputStream.flush();
                        }
                    }
                }
                //Video data write and flush
                if (nType == REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL || nType == REQ_POST_UPLOAD_NEW_FILE ||
                        nType == REQ_POST_DEVICE_FILE_VIDEO || nType == REQ_POST_DEVICE_FILE_THUMBNAIL) {
                    outputStream.write(m_videoData);
                    outputStream.flush();
                }

                outputStream.close();
                httpURLConnection.connect();
            }

            //StringBuilder responseStringBuilder = new StringBuilder();
            if (httpURLConnection != null) {
                if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    while (true) {
                        String Line = bufferedReader.readLine();
                        if (Line == null)
                            break;
                        responseStringBuilder.append(Line).append("\n");
                    }
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                } else {
                    m_nLastError = ERROR_CONNECTION;
                    PPVirtuosoLogTrace.e(TAG, "Http Request Response: connection fail");
                }
            }
            response = responseStringBuilder.toString();
            //PPVirtuosoLogTrace.i(TAG, "Http Request Response: " + response);

        } catch (IllegalArgumentException e) {
            m_nLastError = ERROR_FAILED;
            PPVirtuosoLogTrace.e("HttpTransfer", "MalformedURLException error: " + e.getMessage(), e);
        } catch (SocketTimeoutException e) {
            m_nLastError = ERROR_TIMEOUT;
            PPVirtuosoLogTrace.e("HttpTransfer", "TIME OUT Exception error: " + e.getMessage(), e);
        } catch (Exception e) {
            m_nLastError = ERROR_FAILED;
            PPVirtuosoLogTrace.e("HttpTransfer", "Exception error: " + e.getMessage(), e);
        }

        return response;
    }

    //trust ssl
    // always verify the host - dont check for certificate
    public final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            // TODO Auto-generated method stub
            return true;
        }
    };


    /**
     * Check error result
     *
     * @return
     */
    public short getLastError() {
        return m_nLastError;
    }
}
