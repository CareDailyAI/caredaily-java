package com.peoplepowerco.virtuoso.managers;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;

/**
 * Created by laghee on 5/22/16.
 */
public class PPOAuthManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPOAuthManager.class.getSimpleName();
    private static PPOAuthManager instance = null;

    /**
     * Hidden class constructor.
     */
    private PPOAuthManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     * @return
     */
    public static PPOAuthManager getInstance() {
        synchronized(PPOAuthManager.class) {
            if (instance == null) {
                instance = new PPOAuthManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if(instance != null) {
            instance.releaseBase();
            instance = null;
        }
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

//    /* OAuth 2.0 Client */
//    // https://app.presencepro.com/cloud/json/authorize
//    public static final short REQ_GET_SUPPORTED_THIRD_PARTY_APPS            = 280;
//
//    // https://app.presencepro.com/auth/authorize/appId?API_KEY=API_KEY
//    public static final short REQ_GET_ACCESS_THIRD_PARTY_APP                = 281;
//
//    // https://app.presencepro.com/cloud/json/authorize/applicationId?userId=userId
//    public static final short REQ_DELETE_REMOVE_THIRD_PARTY_APP_SUPPORT     = 282;
//
//
//    /* OAuth 2.0 Host */
//    // https://app.presencepro.com/oauth/authorize?client_id=client_id&state=state&response_type=response_type
//    public static final short REQ_GET_AUTHORIZE_THIRD_PARTY_APP             = 283;
//
//    // https://app.presencepro.com/auth/approve/approved?client_id=client_id&state=state&response_type=response_type&API_KEY=API_KEY
//    public static final short REQ_GET_APPROVE_OR_DENY_APP_AUTHORIZATION     = 284;
//
//    // https://app.presencepro.com/oauth/token?code=code&refresh_token=refresh_token&client_id=client_id
//    public static final short REQ_POST_GET_ACCESS_TOKEN                     = 285;
//
//    // https://app.presencepro.com/cloud/authClient?client_id=client_id&userId=userId
//    public static final short REQ_DELETE_REVOKE_OAUTH_CLIENTS               = 286;
}
