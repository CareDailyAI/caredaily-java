package com.peoplepowerco.virtuoso.managers;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPQuestionsModel;
import com.peoplepowerco.virtuoso.models.PPQuestionsModel.PPQuestionCollectionReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionsManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPQuestionsManager.class.getSimpleName();
    private static PPQuestionsManager instance = null;

    private ArrayList<PPQuestionsModel> questionsModels;
    private LinkedHashMap<PPQuestionCollectionReference, List<PPQuestionsModel>> questionsMaps;

    private PPQuestionsManager() {
        init();
    }

    private void init() {
        init(this);
        questionsModels = new ArrayList<>();
        questionsMaps = new LinkedHashMap<>();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPQuestionsManager getInstance() {
        synchronized (PPQuestionsManager.class) {
            if (instance == null) {
                instance = new PPQuestionsManager();
            }
        }
        return instance;
    }

    public ArrayList<PPQuestionsModel> getQuestionsModels() {
        return questionsModels;
    }

    public LinkedHashMap<PPQuestionCollectionReference, List<PPQuestionsModel>> getFilteredQuestionsModels() {
        return questionsMaps;
    }

    public void clearFilteredQuestionsModels() {
        questionsMaps.clear();
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    public void getFrontPageQuestions(String tag) {
        getQuestions(tag, false, true, true, true,
            false, false, true, false,
            null, null, true, true, null,
            null);
    }

    public void requestPutQuestions(String tag, String json) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("data", json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(IPPVirtuosoTypes.REQ_PUT_ANSWER_QUESTION, jsonObj);
    }

    public void serverRequestGetSurvey(String tag) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("TAG", tag);
        jsonObj.put("brand", PPAppCenter.BRAND_NAME);
        m_CloudCommander.GetDataThreadPool(IPPVirtuosoTypes.REQ_GET_SURVEY_QUESTIONS, jsonObj);
    }

    public void serverRequestPutSurvey(String tag, String json) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("data", json);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(IPPVirtuosoTypes.REQ_PUT_ANSWER_SURVEY_QUESTIONS, jsonObj);
    }

    public void getMonitoringServiceQuestionsForInstanceId(String tag, String instanceId) {
        getQuestions(tag, false, true, true, true,
            true, true, false, false,
            null, null, true, true, null,
            instanceId);

    }

    public void getMonitoringServiceQuestions(String tag, int[] values) {
        getQuestions(tag, values, false, false,
            null, null, false, false, null,
            null);

    }

    public void getSimpleServiceQuestions(String tag) {
        JSONObject jsonObj = new JSONObject();
        int[] values = new int[]{1, 2, 3, 4};
        StringBuilder builder = new StringBuilder();
        try {
            for (int i = 0; i != values.length; ++i) {
                builder.append("answerStatus=");
                builder.append(values[i]);
                if (i != values.length - 1) {
                    builder.append("&");
                }
            }
            String answerStatus = builder.toString();
            if (!TextUtils.isEmpty(answerStatus)) {
                jsonObj.put("answerStatus", answerStatus);
            }
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_SIMPLE_QUESTIONS, jsonObj);
    }

    public void getMonitoringServiceQuestions(String tag, List<PPQuestionsModel> questions, int keyType, String key) {
        JSONObject jsonObj = new JSONObject();
        int[] values = new int[]{1, 2, 3, 4};
        StringBuilder builder = new StringBuilder();
        try {
            for (int i = 0; i != values.length; ++i) {
                builder.append("answerStatus=");
                builder.append(values[i]);
                if (i != values.length - 1) {
                    builder.append("&");
                }
            }
            String answerStatus = builder.toString();
            if (!TextUtils.isEmpty(answerStatus)) {
                jsonObj.put("answerStatus", answerStatus);
            }
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_QUESTION_BY_KEY, jsonObj, new Object[]{questions, keyType, key});
    }

    private void getQuestions(String tag, int[] values,
        boolean getOnlyFrontPageQuestions, boolean getOnlyEditableQuestions, String organizationId,
        String collectionName, boolean privateQuestions, boolean publicQuestions,
        String onlyQuestionId, String onlyComposerAppId) {
        JSONObject jsonObj = new JSONObject();

        StringBuilder builder = new StringBuilder();
        try {
            for (int i = 0; i != values.length; ++i) {
                builder.append("answerStatus=");
                builder.append(values[i]);
                if (i != values.length - 1) {
                    builder.append("&");
                }
            }
            String answerStatus = builder.toString();
            if (!TextUtils.isEmpty(answerStatus)) {
                jsonObj.put("answerStatus", answerStatus);
            }
            if (getOnlyFrontPageQuestions) {
                jsonObj.put("front", "true");
            }
            if (getOnlyEditableQuestions) {
                jsonObj.put("editable", "true");
            }
            if (!TextUtils.isEmpty(organizationId)) {
                jsonObj.put("organizationId", organizationId);
            }
            if (!TextUtils.isEmpty(collectionName)) {
                jsonObj.put("collectionName", collectionName);
            }
            if (privateQuestions && !publicQuestions) {
                jsonObj.put("generalPublic", "false");
            } else if (!privateQuestions && publicQuestions) {
                jsonObj.put("generalPublic", "true");
            }
            if (!TextUtils.isEmpty(onlyQuestionId)) {
                jsonObj.put("questionId", onlyQuestionId);
            }
            if (!TextUtils.isEmpty(onlyComposerAppId)) {
                jsonObj.put("appInstanceId", onlyComposerAppId);
            }
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_QUESTIONS, jsonObj,
            getOnlyFrontPageQuestions, getOnlyEditableQuestions, questionsMaps);
    }

    private void getQuestions(String tag, boolean getDelayedQuestions, boolean getQueuedQuestions, boolean getAvailableQuestions,
        boolean getSkippedQuestions, boolean getAnsweredQuestions, boolean getWontAnswerQuestions,
        boolean getOnlyFrontPageQuestions, boolean getOnlyEditableQuestions, String organizationId,
        String collectionName, boolean privateQuestions, boolean publicQuestions,
        String onlyQuestionId, String onlyComposerAppId) {
        JSONObject jsonObj = new JSONObject();

        StringBuilder builder = new StringBuilder();
        try {
            if (getDelayedQuestions) {
                builder.append("answerStatus=0");
            }
            if (getQueuedQuestions) {

                builder.append("&");
                builder.append("answerStatus=1");
            }
            if (getAvailableQuestions) {
                builder.append("&");
                builder.append("answerStatus=2");
            }
            if (getSkippedQuestions) {
                builder.append("&");
                builder.append("answerStatus=3");
            }
            if (getAnsweredQuestions) {
                builder.append("&");
                builder.append("answerStatus=4");
            }

            if (getWontAnswerQuestions) {
                builder.append("&");
                builder.append("answerStatus=5");
            }
            String answerStatus = builder.toString();
            if (!TextUtils.isEmpty(answerStatus)) {
                jsonObj.put("answerStatus", answerStatus);
            }
            if (getOnlyFrontPageQuestions) {
                jsonObj.put("front", "true");
            }
            if (getOnlyEditableQuestions) {
                jsonObj.put("editable", "true");
            }
            if (!TextUtils.isEmpty(organizationId)) {
                jsonObj.put("organizationId", organizationId);
            }
            if (!TextUtils.isEmpty(collectionName)) {
                jsonObj.put("collectionName", collectionName);
            }
            if (privateQuestions && !publicQuestions) {
                jsonObj.put("generalPublic", "false");
            } else if (!privateQuestions && publicQuestions) {
                jsonObj.put("generalPublic", "true");
            }
            if (!TextUtils.isEmpty(onlyQuestionId)) {
                jsonObj.put("questionId", onlyQuestionId);
            }
            if (!TextUtils.isEmpty(onlyComposerAppId)) {
                jsonObj.put("appInstanceId", onlyComposerAppId);
            }
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_QUESTIONS, jsonObj,
            getOnlyFrontPageQuestions, getOnlyEditableQuestions, questionsModels);
    }
}
