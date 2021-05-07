package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPNotificationSubscriptions;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;

import java.util.ArrayList;

/**
 * Created by laghee on 5/22/16.
 */
public class PPCommunicationsManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPCommunicationsManager.class.getSimpleName();
    private static PPCommunicationsManager instance = null;

    private PPUserInfoModel m_UserInfoModel = null;
    private ArrayList<PPNotificationSubscriptions> m_NotificationSubscriptionsList = null;

    /**
     * Hidden class constructor.
     */
    private PPCommunicationsManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPCommunicationsManager getInstance() {
        synchronized (PPCommunicationsManager.class) {
            if (instance == null) {
                instance = new PPCommunicationsManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_NotificationSubscriptionsList = new ArrayList<PPNotificationSubscriptions>();
        m_UserInfoModel = new PPUserInfoModel();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_NotificationSubscriptionsList.clear();
            instance.m_NotificationSubscriptionsList = null;
            instance.m_UserInfoModel = null;
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

//    /* USER COMMUNICATIONS */
//    // https://app.presencepro.com/cloud/json/notificationSubscriptions
//    public static final short REQ_GET_NOTIFICATION_SUBSCRIPTIONS            = 176;
//
//    // https://app.presencepro.com/cloud/json/notificationSubscriptions/type?email=email&emailPeriod=emailPeriod&push=push&pushPeriod=pushPeriod&sms=sms&smsPeriod=smsPeriod
//    public static final short REQ_PUT_NOTIFICATION_SUBSCRIPTIONS            = 177;
//
//    // https://app.presencepro.com/cloud/json/notificationToken/appName/notificationToken_or_registrationId?badge=badge
//    public static final short REQ_PUT_APP_NOTIFICATION_REGISTRATION         = 178;

    /**
     * Put the GCM notification token
     */
    public void serverRequestNotificationToken(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            //We need to use "androidPresence" as a app name
            jsonObj.put("appName", "androidPresence");
            jsonObj.put("registrationId", PPVirtuoso.getInstance().getPrefs().getNotificationToken());
            jsonObj.put("badge", PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE));
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_APP_NOTIFICATION_REGISTRATION, jsonObj);
    }
//    // https://app.presencepro.com/cloud/json/notificationToken/notificationToken_or_registrationId
//    public static final short REQ_DELETE_APP_NOTIFICATION_REGISTRATION      = 179;

    /**
     * Delete GCM
     */
    public void serverRequestDeleteNotificationToken(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("registrationId", PPVirtuoso.getInstance().getPrefs().getNotificationToken());
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_APP_NOTIFICATION_REGISTRATION, jsonObj);
    }

    /**
     * https://developer.peoplepowerco.com/docs/?q=cloud/user Retrieve user and device locations information from server.
     */
    public void serverRequestGetNotificationSubscriptions(String tag) {
        JSONObject jsonObj = new JSONObject();
        if (m_NotificationSubscriptionsList != null) {
            m_NotificationSubscriptionsList.clear();
        }
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_NOTIFICATION_SUBSCRIPTIONS, jsonObj, new Object[]{m_NotificationSubscriptionsList});
    }

    /**
     * https://developer.peoplepowerco.com/docs/?q=cloud/notificationSubscriptions Allows a user to see his subscriptions to system notifications like device alerts or rules notifications.
     */
    public void serverRequestSetNotificationSubscriptions(String tag, JSONObject m_NotificationJson) {
        JSONObject jsonObj = m_NotificationJson;
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_NOTIFICATION_SUBSCRIPTIONS, jsonObj, m_UserInfoModel);
    }

    public ArrayList<PPNotificationSubscriptions> getNotificationsSubscriptionsList() {
        return m_NotificationSubscriptionsList;
    }

    public void serverRequestSendCrowdFeedback(String tag, JSONObject jsonData) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("data", jsonData);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_CROWD_FEEDBACK, jsonObj);
    }

//    // https://app.presencepro.com/cloud/json/notifications?userId=userId&organizationId=organizationId
//    public static final short REQ_POST_SEND_NOTIFICATION                    = 180;
//
//    // https://app.presencepro.com/cloud/json/feedback
//    public static final short REQ_POST_CROWD_FEEDBACK                       = 181;
//
//    // https://app.presencepro.com/cloud/json/feedback/appName/type?startPos=startPos&length=length&productId=productId&productCategory=productCategory
//    public static final short REQ_GET_CROWD_FEEDBACK_SEARCHING              = 182;
//
//    // https://app.presencepro.com/cloud/json/feedback/feedbackId
//    public static final short REQ_GET_CROWD_FEEDBACK                        = 183;
//
//    // https://app.presencepro.com/cloud/json/feedback/feedbackId
//    public static final short REQ_PUT_UPDATE_FEEDBACK                       = 184;
//
//    // https://app.presencepro.com/cloud/json/feedback/feedbackId/rank
//    public static final short REQ_PUT_VOTE_FOR_FEEDBACK                     = 185;
//
//    // https://app.presencepro.com/cloud/json/support
//    public static final short REQ_POST_REQUEST_SUPPORT                      = 186;
//
//    // https://app.presencepro.com/cloud/json/messages
//    public static final short REQ_POST_SEND_MESSAGE                         = 187;
//
//    // https://app.presencepro.com/cloud/json/messages?status=status&messageId=messageId&userId=userId&type=type
//    public static final short REQ_GET_RECEIVE_MESSAGES                      = 188;
//
//    // https://app.presencepro.com/cloud/json/messages/messageId?read=read
//    public static final short REQ_PUT_UPDATE_MESSAGE_ATTRIBUTES             = 189;
//
//    // https://app.presencepro.com/cloud/json/messages/messageId
//    public static final short REQ_DELETE_MESSAGE                            = 190;
//
//    // https://app.presencepro.com/cloud/json/messages/messageId
//    public static final short REQ_POST_REPLY_TO_MESSAGE                     = 191;
//
//    // https://app.presencepro.com/cloud/json/questions?questionId=questionId&organizationId=organizationId&appId=appId&editable=editable
//    public static final short REQ_GET_QUESTIONS                             = 192;
//
//    // https://app.presencepro.com/cloud/json/questions
//    public static final short REQ_PUT_ANSWER_QUESTION                       = 193;
//
//    // https://app.presencepro.com/cloud/json/questions?questionId=questionId
//    public static final short REQ_POST_UPDATE_RESPONSE                      = 194;
}
