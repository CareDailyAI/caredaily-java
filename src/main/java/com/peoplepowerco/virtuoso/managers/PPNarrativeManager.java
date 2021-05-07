package com.peoplepowerco.virtuoso.managers;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.bean.FAEvent;
import com.peoplepowerco.virtuoso.bean.SectionObject;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by edwardliu on 2018/11/23.
 */

public class PPNarrativeManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPNarrativeManager.class.getSimpleName();
    private static PPNarrativeManager instance = null;

    private List<FAEvent> mNarrativeEvents;

    private PPNarrativeManager() {
        init();
    }

    private void init() {
        init(this);
        mNarrativeEvents = new ArrayList<>();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPNarrativeManager getInstance() {
        synchronized (PPNarrativeManager.class) {
            if (instance == null) {
                instance = new PPNarrativeManager();
            }
        }
        return instance;
    }

    public List<FAEvent> getNarrativeEvents() {
        return mNarrativeEvents;
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    public void getNarratives(String tag, int priority, Date startDate, Date endDate, String pageMarker, SectionObject nextPageMarker) {
        getNarratives(tag, PPAppCenter.m_SharedPresence.getLocationId(),
            PPCommonInfo.PPInvalidValue, priority, null, startDate,
            endDate, 20, pageMarker, nextPageMarker);
    }

    public void getNarratives(String tag, String locationId, int narrativeId, int priority,
        String searchBy, Date startDate, Date endDate, int rowCount,
        String pageMarker, SectionObject nextPageMarker) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        if (narrativeId != PPCommonInfo.PPInvalidValue) {
            jsonObj.put("narrativeId", narrativeId);
        }
        if (priority != PPCommonInfo.PPInvalidValue) {
            jsonObj.put("priority", priority);
        }
        jsonObj.put("toPriority", 3);
        if (!TextUtils.isEmpty(searchBy)) {
            jsonObj.put("searchBy", searchBy);
        }
        if (null != startDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
            String startResult = dateFormat.format(startDate);
            jsonObj.put("startTime", startResult);
        }
        if (null != endDate) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
            String endResult = dateFormat.format(endDate);
            jsonObj.put("endTime", endResult);
        }
        if (rowCount != PPCommonInfo.PPInvalidValue) {
            jsonObj.put("rowCount", rowCount);
        }
        if (!TextUtils.isEmpty(pageMarker)) {
            jsonObj.put("pageMarker", pageMarker);
        }
        jsonObj.put("TAG", tag);
        jsonObj.put("sortOrder", "desc");
        m_CloudCommander.GetDataThreadPool(REQ_GET_NARRATIVES, jsonObj, new Object[]{nextPageMarker, mNarrativeEvents});
    }

    public void getQuestions(String tag, Date startDate, Date endDate) {
        ArrayList<Integer> status = new ArrayList<>();
        status.add(PPCommonInfo.PPQuestionAnswerStatusReady);
        status.add(PPCommonInfo.PPQuestionAnswerStatusDelayed);
        status.add(PPCommonInfo.PPQuestionAnswerStatusSkipped);
        status.add(PPCommonInfo.PPQuestionAnswerStatusAnswered);
        status.add(PPCommonInfo.PPQuestionAnswerStatusNoAnswer);
        status.add(PPCommonInfo.PPQuestionAnswerStatusAvailable);
        getQuestions(tag, status, PPCommonInfo.PPQuestionEditableNone, null,
            null, PPCommonInfo.PPQuestionCollectionGeneralPublicNone, null,
            null, null, PPCommonInfo.PPQuestionsLimitNone, PPCommonInfo.PPQuestionsPublicNone,
            startDate, endDate);
    }

    public void getQuestions(String tag, ArrayList<Integer> status, int editable, String organizationId,
        String collectionName, int generalPublic, String questionId, String appInstanceId,
        String lang, int limit, int questionPublic, Date startDate, Date endDate) {
        JSONObject jsonObj = new JSONObject();

        StringBuilder builder = new StringBuilder();
        try {
            if (null != status && !status.isEmpty()) {
                for (int iStatus : status) {
                    builder.append(String.format("answerStatus=%d&", iStatus));
                }
            }
            if (editable != PPCommonInfo.PPQuestionEditableNone) {
                builder.append(String.format("editable=%d&", editable));
            }
            if (!TextUtils.isEmpty(organizationId)) {
                builder.append(String.format("organizationId=%s&", organizationId));
            }
            if (!TextUtils.isEmpty(collectionName)) {
                builder.append(String.format("collectionName=%s&", collectionName));
            }
            if (generalPublic != PPCommonInfo.PPQuestionCollectionGeneralPublicNone) {
                builder.append(String.format("generalPublic=%d&", generalPublic));
            }
            if (!TextUtils.isEmpty(questionId)) {
                builder.append(String.format("questionId=%s&", questionId));
            }
            if (!TextUtils.isEmpty(appInstanceId)) {
                builder.append(String.format("appInstanceId=%s&", appInstanceId));
            }
            if (!TextUtils.isEmpty(lang)) {
                builder.append(String.format("lang=%s&", lang));
            }
            if (limit != PPCommonInfo.PPQuestionsLimitNone) {
                builder.append(String.format("limit=%d&", limit));
            }
            if (questionPublic != PPCommonInfo.PPQuestionsPublicNone) {
                builder.append(String.format("public=%d&", questionPublic));
            }

            if (null != startDate) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                String startResult = dateFormat.format(startDate);
                builder.append(String.format("startDate=%s&", startResult));
            }
            if (null != endDate) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
                String endResult = dateFormat.format(endDate);
                builder.append(String.format("endDate=%s&", endResult));
            }

            String answerStatus = builder.toString();
            if (!TextUtils.isEmpty(answerStatus)) {
                jsonObj.put("answerStatus", answerStatus);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_NARRATIVE_QUESTIONS, jsonObj);
    }
}
