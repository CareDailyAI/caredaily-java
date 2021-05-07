package com.peoplepowerco.virtuoso.handlers;

import android.os.Bundle;
import android.os.Message;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import com.peoplepowerco.virtuoso.util.PPWeakHandler;

/**
 * Generic server result handler.
 */
public class PPServerResultHandler extends PPWeakHandler<IPPServerResultListener> implements IPPVirtuosoTypes {

    private static final String TAG = PPServerResultHandler.class.getSimpleName();

    public PPServerResultHandler(IPPServerResultListener owner) {
        super(owner);
    }

    @Override
    public void handleMessage(Message msg) {
        String sTag = null;
        IPPServerResultListener owner = getTheOwner();
        try {
            if ((owner != null) && (!PPAppCenter.m_restartRequested)) {
                if (msg.peekData() != null) {
                    Bundle tagBun = msg.getData();
                    sTag = tagBun.getString("TAG");
                    PPVirtuosoLogTrace.d(TAG, "TAG DATA:" + sTag);
                }
                switch (msg.arg1) {
                    case RES_SUCCESS:
                        owner.onResultSuccess(msg.what, msg.arg1, msg.arg2, msg.obj, sTag);
                        PPVirtuosoLogTrace.d(TAG, "RES_SUCCESS!");
                        break;
                    default:
                        //a bad key is signified on arg2
                        //Why device not found error make app restarted? Le't remove RES_DEVICE_NOT_FOUND
                        if (msg.arg2 == RES_WRONG_APIKEY) {
                            final boolean isTokenValid = msg.arg2 == RES_DEVICE_NOT_FOUND;
                            PPVirtuosoLogTrace.d(TAG, "BAD KEY RESTART: " + msg.toString());
                            post(new Runnable() {
                                @Override
                                public void run() {
                                    handleBadKey(isTokenValid);
                                }
                            });
                        } else {
                            //Let's not use for now,until we get further notice for this event.
//                            EventTrackingHelper.getInstance().logSystemEvent(PPCommonInfo.AMP_EVENT_SYSTEM_CONNECTION_TROUBLE);
                            owner.onResultFailure(msg.what, msg.arg1, msg.arg2, msg.obj, sTag);
                            PPVirtuosoLogTrace.e(TAG, "FAIL ON SERVER CALL!");
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method handles bad key cases. Right now the only way to get a bad key is expiration or logout. Either way requires the user to
     * log back in so we will handle it here for all calls.
     */
    private synchronized void handleBadKey(boolean isTokenValid) {
        if (!PPAppCenter.m_restartRequested) {
            PPAppCenter.m_restartRequested = true;
            PPSharedPreferences prefs = PPVirtuoso.getInstance().getPrefs();
            prefs.setLongin(isTokenValid);
            prefs.setFirstName(null);
            prefs.clearCache();
            PPAppCenter.restartApp("badkey");
        }
    }
}
