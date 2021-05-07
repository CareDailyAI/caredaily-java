package com.peoplepowerco.virtuoso.models.narratives;

import java.util.List;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionsModel {
    public long id;
    public String creationDate;
    public String key;
    public boolean urgent;
    public boolean front;
    public boolean editable;
    public boolean aggregatePublicly;
    public String question;
    public String placeholder;
    public int responseType;
    public int displayType;
    public String defaultAnswer;
    public String answerFormat;
    public int sliderMin;
    public int sliderMax;
    public int sliderInc;
    public String sectionTitle;
    public int sectionId;
    public int questionWeight;
    public String deviceId;
    public String icon;
    public int answerStatus;
    public String answer;
    public boolean answerModified;
    public int answerPoints;
    public String answerDate;
    public boolean isSection = false;

    public List<PPQuestionCollectionReference> collections;
    public List<PPQuestionResponseOption> options;


}
