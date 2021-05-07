package com.peoplepowerco.virtuoso;

import android.content.Context;
import android.graphics.Typeface;

import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.interfaces.IPPRestartListener;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * Created by edwardliu on 2018/8/15.
 */

public class PPAppCenter {

    public static Context m_Context;
    public static PPSharedPreferences m_SharedPresence;

    public static boolean m_restartRequested;

    public static PPFontIconLabel m_IconFontLabel;
    public static Typeface m_IconsTypeFace;
    public static Typeface m_IotIconsTypeFace;
    public static Typeface m_HelpOverLayTypeFace;

    public static IPPRestartListener m_RestartListener;
    public static String APP_NAME;
    public static String BRAND_NAME;
    public static int BUNDLE_VERSION = 1;
    public static int SPRINT_VERSION = 0;

    public static void inject(Context context, PPSharedPreferences sharedPresence) {
        m_Context = context;
        m_SharedPresence = sharedPresence;
        m_IconFontLabel = new PPFontIconLabel(m_Context);
        m_IconsTypeFace = Typeface.createFromAsset(m_Context.getAssets(), "PPCIcons.ttf");
        m_IotIconsTypeFace = Typeface.createFromAsset(m_Context.getAssets(), "PPCIOTIconsLight.ttf");
        m_HelpOverLayTypeFace = Typeface.createFromAsset(m_Context.getAssets(), "rabiohead.ttf");
    }

    public static void unject() {
        m_RestartListener = null;
        m_SharedPresence = null;
        m_Context = null;
    }

    public static void setRestartListener(IPPRestartListener listener) {
        m_RestartListener = listener;
    }

    public static void restartApp(String className) {
        m_RestartListener.restartApp(className);
    }

    public static String getServerUrl() {
        if (m_SharedPresence.getServerCommunicationURL() == null) {
            PPVirtuosoLogTrace.d("PPApp", "getServerUrl: Somebody called me and I am null!");
        }
        return m_SharedPresence.getServerCommunicationURL();
    }

    public static void setServerUrl(String url, Object obj) {
        String callingClass = obj.getClass().getName();
        if (url != null) {
            m_SharedPresence.setServerCommunicationURL(url);
        } else {
            PPVirtuosoLogTrace.d("PPApp", "WARNING!!! Setting Server URL: (" + callingClass + ") tried to set  me to  null!");
        }
    }
}
