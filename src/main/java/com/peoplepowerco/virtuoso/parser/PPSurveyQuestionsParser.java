package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel;
import io.realm.Realm;
import java.util.ArrayList;

public class PPSurveyQuestionsParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        if (jso.containsKey("questions")) {
            final JSONArray questionsArray = jso.getJSONArray("questions");
            if (questionsArray.isEmpty()) {
                return false;
            }

            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            ArrayList<Long> questions = new ArrayList<>();
            for (int i = 0; i != questionsArray.size(); ++i) {
                JSONObject questionObj = questionsArray.getJSONObject(i);
                String title = questionObj.getString("title");
                if (TextUtils.isEmpty(title)) {
                    continue;
                }

                long questionId = questionObj.getLongValue("id");
                questions.add(questionId);
                PPSurveyQuestionModel questionModel = realm.where(PPSurveyQuestionModel.class)
                    .equalTo("id", questionId).findFirst();
                if (null == questionModel) {
                    questionModel = realm.createObject(PPSurveyQuestionModel.class, questionId);
                    questionModel.answerTime = 0;
                }
                questionModel.title = questionObj.getString("title");
                questionModel.question = questionObj.getString("question");
                questionModel.sliderMin = questionObj.getIntValue("sliderMin");
                questionModel.sliderMax = questionObj.getIntValue("sliderMax");
            }
            Long[] questionIds = new Long[questions.size()];
            questions.toArray(questionIds);
            realm.where(PPSurveyQuestionModel.class)
                .beginGroup()
                .not().in("id", questionIds)
                .endGroup()
                .findAll().deleteAllFromRealm();
            realm.commitTransaction();
            realm.close();
            return true;
        }
        return false;
    }
}
