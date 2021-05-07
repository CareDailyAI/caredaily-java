package com.peoplepowerco.virtuoso.models;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import java.util.ArrayList;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionsModel {

    public int id = PPCommonInfo.PPInvalidValue;
    public String creationDate;
    public String key;
    public boolean urgent;
    public boolean front;
    public boolean editable;
    public boolean aggregatePublicly;
    public String question;
    public String placeholder;
    public long appInstanceId;
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
    public boolean isDescription = false;
    public PPQuestionSliderModel questionSliderModel;

    public static final int KEY_TYPE_QUESTION_ID = 1;
    public static final int KEY_TYPE_COLLECTION_NAME = 2;
    public static final int KEY_TYPE_SECTION_ID = 3;

    public ArrayList<PPQuestionResponseOption> options;

    public static class PPQuestionResponseOption {

        public int id;
        public String text;
    }

    public static class PPQuestionCollectionReference {

        public String description;
        public String name;
        public int weight;
        public int id;
        public String icon;

        @Override
        public boolean equals(@Nullable Object obj) {
            if (obj instanceof PPQuestionCollectionReference) {
                PPQuestionCollectionReference other = (PPQuestionCollectionReference) obj;
                if (TextUtils.isEmpty(this.name)) {
                    return false;
                } else if (TextUtils.isEmpty(other.name)) {
                    return false;
                } else {
                    return this.name.equals(other.name);
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (name != null ? name.hashCode() : 1) * 31;
        }
    }
}
