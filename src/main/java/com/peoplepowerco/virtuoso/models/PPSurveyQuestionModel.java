package com.peoplepowerco.virtuoso.models;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;
import java.util.ArrayList;
import java.util.List;

public class PPSurveyQuestionModel extends RealmObject {

    @PrimaryKey
    public long id;
    public String title;
    public String question;
    public int sliderMin;
    public int sliderMax;
    public long answerTime;

    public static PPSurveyQuestionModel findItemById(Realm realm, long id) {
        return realm.where(PPSurveyQuestionModel.class).equalTo("id", id).findFirst();
    }

    public static List<PPSurveyQuestionModel> getSurveyQuestions(Realm realm) {
        List<PPSurveyQuestionModel> questions = new ArrayList<>();
        RealmResults<PPSurveyQuestionModel> results = realm.where(PPSurveyQuestionModel.class).findAll();
        if (!results.isEmpty()) {
            long currentTime = System.currentTimeMillis();
            for (PPSurveyQuestionModel question : results) {
                long delta = (currentTime - question.answerTime) / 1000;
                if (delta > 1209600l) {
                    questions.add(question);
                }
            }
        }
        return questions;
    }
}
