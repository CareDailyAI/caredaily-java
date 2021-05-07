package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPSMSSubscriberModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwardliu on 2017/7/11.
 */

public class PPSMSSubscriberManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static PPSMSSubscriberManager instance = null;

    private ArrayList<PPSMSSubscriberModel> m_smsArrayList;

    /**
     * Hidden class constructor.
     */
    private PPSMSSubscriberManager() {
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
    public static PPSMSSubscriberManager getInstance() {
        synchronized (PPSMSSubscriberManager.class) {
            if (instance == null) {
                instance = new PPSMSSubscriberManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_smsArrayList = new ArrayList<>();
    }

    public List<PPSMSSubscriberModel> getSMSSubscribers() {
        return m_smsArrayList;
    }

    public void serverRequestGetSMSSubscribers(String tag, ArrayList<Integer> categories) {
        JSONObject jsonObj = new JSONObject();
        try {
            if (null != categories) {
                StringBuilder builder = new StringBuilder();
                builder.append("?");
                for (Integer category : categories) {
                    builder.append(String.format("category=%d&", category));
                }
                jsonObj.put("categoryData", builder.toString());
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SMS_SUBSCRIBERS, jsonObj, m_smsArrayList);
    }

    public void serverRequestPostSMSSubscriber(String tag, JSONObject subscriberJson) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("data", subscriberJson);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_SMS_SUBSCRIBER, jsonObj);
    }

    public void serverRequestDeleteSMSSubscriber(String tag, String phone) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("phone", phone);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_SMS_SUBSCRIBER, jsonObj);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }
}
