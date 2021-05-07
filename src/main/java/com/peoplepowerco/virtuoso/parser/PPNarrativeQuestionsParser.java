package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.narratives.PPQuestionCollectionReference;
import com.peoplepowerco.virtuoso.models.narratives.PPQuestionResponseOption;
import com.peoplepowerco.virtuoso.models.narratives.PPQuestionsModel;

import java.util.ArrayList;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPNarrativeQuestionsParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArrayProperty = null;
        JSONObject json = null;
        try {
            ArrayList<PPQuestionsModel> events = new ArrayList<>();
            jaArrayProperty = (jso.containsKey("questions")) ? jso.getJSONArray("questions") : null;
            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                for (int i = 0; i < jaArrayProperty.size(); i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    boolean front = json.getBooleanValue("front");
                    boolean editable = json.getBooleanValue("editable");
                    int responseType = json.getIntValue("responseType");
                    String sectionTitle = json.getString("sectionTitle");
                    long questionId = json.getLongValue("id");
                    PPQuestionsModel questionModel = new PPQuestionsModel();
                    questionModel.id = questionId;
                    questionModel.creationDate = json.getString("creationDate");
                    questionModel.key = json.getString("key");
                    questionModel.urgent = json.getBooleanValue("urgent");
                    questionModel.front = front;
                    questionModel.editable = editable;
                    questionModel.aggregatePublicly = json.getBooleanValue("aggregatePublicly");
                    questionModel.question = json.getString("question");
                    questionModel.placeholder = json.getString("placeholder");
                    if (json.containsKey("collections")) {
                        questionModel.collections = new ArrayList<>();
                        JSONArray collections = json.getJSONArray("collections");
                        for (int j = 0; j < collections.size(); ++j) {
                            PPQuestionCollectionReference collectionReference = new PPQuestionCollectionReference();
                            JSONObject collection = collections.getJSONObject(j);
                            collectionReference.id = collection.getIntValue("id");
                            collectionReference.order = collection.getIntValue("order");
                            questionModel.collections.add(collectionReference);
                        }
                    }
                    questionModel.responseType = responseType;
                    questionModel.displayType = json.getIntValue("displayType");
                    questionModel.defaultAnswer = json.getString("defaultAnswer");
                    questionModel.answerFormat = json.getString("answerFormat");
                    questionModel.sliderMin = json.getIntValue("sliderMin");
                    questionModel.sliderMax = json.getIntValue("sliderMax");
                    questionModel.sliderInc = json.getIntValue("sliderInc");
                    questionModel.sectionTitle = sectionTitle;
                    questionModel.sectionId = json.getIntValue("sectionId");
                    questionModel.questionWeight = json.getIntValue("questionWeight");

                    if (json.containsKey("responseOptions")) {
                        questionModel.options = new ArrayList<>();
                        JSONArray optionsArray = json.getJSONArray("responseOptions");
                        for (int j = 0; j < optionsArray.size(); ++j) {
                            PPQuestionResponseOption responseOption = new PPQuestionResponseOption();
                            JSONObject optionObj = optionsArray.getJSONObject(j);
                            responseOption.id = optionObj.getIntValue("id");
                            responseOption.text = optionObj.getString("text");
                            questionModel.options.add(responseOption);
                        }
                    }
                    questionModel.deviceId = json.getString("deviceId");
                    questionModel.icon = json.getString("icon");
                    questionModel.answerStatus = json.getIntValue("answerStatus");
                    questionModel.answer = json.getString("answer");
                    questionModel.answerModified = json.getBooleanValue("answerModified");
                    questionModel.answerPoints = json.getIntValue("answerPoints");
                    questionModel.answerDate = json.getString("answerDate");
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
