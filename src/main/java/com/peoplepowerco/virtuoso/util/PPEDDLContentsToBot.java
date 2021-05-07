package com.peoplepowerco.virtuoso.util;


import android.os.Build;
import android.os.Build.VERSION;
import com.peoplepowerco.virtuoso.Constants;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.managers.PPAppInstanceManager;

public class PPEDDLContentsToBot {

    private static final String TAG = PPEDDLContentsToBot.class.getSimpleName();

    public static void sendEDDLContentsToBot(String eventProperties) {

        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"feed\":{");
        builder.append(String.format("\"user_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getUserId()));
        builder.append(String.format("\"event_properties\":%s, ", eventProperties));
        builder.append(String.format("\"platform\":\"%s\", ", "android"));
        builder.append(String.format("\"device_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getKeyStringValue(Constants.EXTRA_FAMILY_APP_UUID)));
        builder.append(String.format("\"device_type\":\"%s\", ", Build.MANUFACTURER + " " + Build.MODEL));
        builder.append(String.format("\"version\":\"%s\", ", PPAppCenter.m_SharedPresence.getKeyStringValue("VERSION_NAME")));
        builder.append(String.format("\"library\":\"%s\", ", "Peoplepower-Analytics/1.0.0"));
        builder.append(String.format("\"os\":\"%s\" ", VERSION.RELEASE));
        builder.append("}}");
        PPVirtuosoLogTrace.d(TAG, "EDDL CONTENTS TO BOT = " + builder.toString());
        PPAppInstanceManager.getInstance().serverRequestPostDataStreamWithBitmask(TAG,
            PPAppInstanceManager.PPComposerAppInstanceDataStreamBitmaskInvdividual,
            PPCommonInfo.LOCATION_STATE_USER_ACTIVITY, PPAppCenter.m_SharedPresence.getLocationId(),
            null, builder.toString());

    }


    public static void sendEDDLContentsToBot(String event, String eventProperties) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"feed\":{");
        builder.append(String.format("\"user_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getUserId()));
        builder.append(String.format("\"event\":\"%s\", ", event));
        builder.append(String.format("\"event_properties\":%s, ", eventProperties));
        builder.append(String.format("\"platform\":\"%s\", ", "android"));
        builder.append(String.format("\"device_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getKeyStringValue(Constants.EXTRA_FAMILY_APP_UUID)));
        builder.append(String.format("\"device_type\":\"%s\", ", Build.MANUFACTURER + " " + Build.MODEL));
        builder.append(String.format("\"version\":\"%s\", ", PPAppCenter.m_SharedPresence.getKeyStringValue("VERSION_NAME")));
        builder.append(String.format("\"library\":\"%s\", ", "Peoplepower-Analytics/1.0.0"));
        builder.append(String.format("\"os\":\"%s\" ", VERSION.RELEASE));
        builder.append("}}");
        PPVirtuosoLogTrace.d(TAG, "EDDL CONTENTS TO BOT = " + builder.toString());
        PPAppInstanceManager.getInstance().serverRequestPostDataStreamWithBitmask(TAG,
            PPAppInstanceManager.PPComposerAppInstanceDataStreamBitmaskInvdividual,
            PPCommonInfo.LOCATION_STATE_USER_ACTIVITY, PPAppCenter.m_SharedPresence.getLocationId(),
            null, builder.toString());

    }

    public static void sendEDDLUserContentsToBot(String event, String userProperties) {
        userProperties = replace(userProperties);
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"feed\":{");
        builder.append(String.format("\"user_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getUserId()));
        builder.append(String.format("\"event\":\"%s\", ", event));
        builder.append(userProperties);
        builder.append("}}");
        PPVirtuosoLogTrace.d(TAG, "EDDL CONTENTS TO BOT = " + builder.toString());
        PPAppInstanceManager.getInstance().serverRequestPostDataStreamWithBitmask(TAG,
            PPAppInstanceManager.PPComposerAppInstanceDataStreamBitmaskInvdividual,
            PPCommonInfo.LOCATION_STATE_USER_ACTIVITY, PPAppCenter.m_SharedPresence.getLocationId(),
            null, builder.toString());

    }

    public static void sendEDDLContentsToBot(String event, String eventProperties, String userProperties) {
        if(userProperties==null){
            return;
        }
        userProperties = replace(userProperties);
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("\"feed\":{");
        builder.append(String.format("\"user_id\":\"%s\", ", PPAppCenter.m_SharedPresence.getUserId()));
        builder.append(String.format("\"event\":\"%s\", ", event));
        builder.append(String.format("\"event_properties\":%s, ", eventProperties));
        builder.append(userProperties);
        builder.append("}}");
        PPVirtuosoLogTrace.d(TAG, "EDDL CONTENTS TO BOT = " + builder.toString());
        PPAppInstanceManager.getInstance().serverRequestPostDataStreamWithBitmask(TAG,
            PPAppInstanceManager.PPComposerAppInstanceDataStreamBitmaskInvdividual,
            PPCommonInfo.LOCATION_STATE_USER_ACTIVITY, PPAppCenter.m_SharedPresence.getLocationId(),
            null, builder.toString());

    }

    private static String replace(String properties) {
        String c = null;
        try {
            c = properties.replaceAll("\\{", "");
            c = c.replaceAll("\\}", "");
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }
}