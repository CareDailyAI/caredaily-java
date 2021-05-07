/**
 * @FileName : PPVirtuoso.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso;

import android.content.Context;

import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Application class, control the shared preference initialize and set the log trace, image loader
 * @date : 2013. 8. 16.
 */
public class PPVirtuoso {

    private static final String TAG = PPVirtuoso.class.getSimpleName();
    private static PPVirtuoso instance = null;
    //	make this variable false while releasing the app
    public static boolean m_IsDebug = true;

    private Context m_context;
    private PPSharedPreferences m_Prefs;
    //vital info for some server calls...
    private static String m_sUserAgent = null;
    private static String m_sDeviceUniqueId = null;
    private static String m_sDeviceModel = null;

    /**
     * Hidden class constructor.
     */
    private PPVirtuoso(Context appcontext) {
        m_context = appcontext;
        init();
    }

    /**
     * Applications must call this before using the library. Initialize the one and only instance of this class. The first calling thread will create an initial instance. This method will only be
     * synchronized on the first call, thus it will not affect speed of our app.
     *
     * @return returns a created instance...
     */
    public static PPVirtuoso initFirstInstance(Context appcontext) {
        synchronized (PPVirtuoso.class) {
            if ((appcontext != null) && (instance == null)) {
                instance = new PPVirtuoso(appcontext);
            }
        }
        return instance;
    }

    /**
     * Get the one and only instance of this class.
     *
     * @return Returns an instance if it exists and null otherwise
     */
    public static PPVirtuoso getInstance() {
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        //If set false Presence app log not appear.
        PPVirtuosoLogTrace.setDebug(m_IsDebug);
        String preferenceName = "com.peoplepowerco.virtuoso:presence";
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)) {
            preferenceName = "com.peoplepowerco.virtuoso:family";
        }
        m_Prefs = new PPSharedPreferences(m_context, preferenceName);
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance = null;
        }
    }

    /**
     * Returns the context of the application which is using Virtuoso.
     */
    public Context getContext() {
        return m_context;
    }

    /**
     * Returns the shared preferences being used by Virtuoso
     */
    public PPSharedPreferences getPrefs() {
        return m_Prefs;
    }

    public String getUserAgent() {
        return m_sUserAgent;
    }

    public void setUserAgent(String useragent) {
        m_sUserAgent = useragent;
    }

    public String getDeviceUniqueId() {
        return m_sDeviceUniqueId;
    }

    public void setDeviceUniqueId(String uniqueid) {
        m_sDeviceUniqueId = uniqueid;
    }

    public String getDeviceModel() {
        return m_sDeviceModel;
    }

    public void setDeviceModel(String model) {
        m_sDeviceModel = model;
    }
}
