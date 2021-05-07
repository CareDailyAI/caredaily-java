package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPQuestionSliderModel;
import com.peoplepowerco.virtuoso.models.PPQuestionsModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
            parseForFamily(jso, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }

    private void parseForFamily(JSONObject jso, Object[] obj) {
        List<PPQuestionsModel> questions = (List<PPQuestionsModel>) obj[0];
        int keyType = (int) obj[1];
        String questionKey = (String) obj[2];
        JSONArray jaArrayProperty = (jso.containsKey("questions")) ? jso.getJSONArray("questions") : null;
        if (jaArrayProperty == null || jaArrayProperty.size() == 0) {
            return;
        }

        for (int i = 0; i < jaArrayProperty.size(); i++) {
            JSONObject json = jaArrayProperty.getJSONObject(i);
            String key;
            if (keyType == PPQuestionsModel.KEY_TYPE_QUESTION_ID) {
                key = json.getString("key");
            } else if (keyType == PPQuestionsModel.KEY_TYPE_COLLECTION_NAME && json.containsKey("collection")) {
                JSONObject collectionJso = json.getJSONObject("collection");
                key = collectionJso.getString("name");
            } else {
                key = json.getString("sectionId");
            }

            if (null != key && key.equals(questionKey)) {
                boolean front = json.getBooleanValue("front");
                boolean editable = json.getBooleanValue("editable");
                int responseType = json.getIntValue("responseType");
                String sectionTitle = json.getString("sectionTitle");
                PPQuestionsModel questionModel = new PPQuestionsModel();
                PPQuestionSliderModel questionSliderModel = new PPQuestionSliderModel();
                JSONObject sliderJsonObj = json.getJSONObject("slider");
                questionModel.id = json.getIntValue("id");
                questionModel.creationDate = json.getString("creationDate");
                questionModel.key = json.getString("key");
                questionModel.urgent = json.getBooleanValue("urgent");
                questionModel.front = front;
                questionModel.editable = editable;
                questionModel.aggregatePublicly = json.getBooleanValue("aggregatePublicly");
                questionModel.question = json.getString("question");
                questionModel.placeholder = json.getString("placeholder");
                questionModel.responseType = responseType;
                questionModel.displayType = json.getIntValue("displayType");
                questionModel.appInstanceId = json.getLongValue("appInstanceId");
                questionModel.defaultAnswer = json.getString("defaultAnswer");
                questionModel.answerFormat = json.getString("answerFormat");
                questionModel.sliderMin = json.getIntValue("sliderMin");
                questionModel.sliderMax = json.getIntValue("sliderMax");
                questionModel.sliderInc = json.getIntValue("sliderInc");
                questionModel.sectionTitle = sectionTitle;
                questionModel.sectionId = json.getIntValue("sectionId");
                questionModel.questionWeight = json.getIntValue("questionWeight");
                if(sliderJsonObj!=null) {
                    questionSliderModel.setSliderMin(sliderJsonObj.containsKey("min") ? sliderJsonObj.getInteger("min") : 0);
                    questionSliderModel.setSliderMax(sliderJsonObj.containsKey("max") ? sliderJsonObj.getInteger("max") : 0);
                    questionSliderModel.setSliderInc(sliderJsonObj.containsKey("inc") ? sliderJsonObj.getInteger("inc") : 0);
                    questionSliderModel.setUnitDesc(sliderJsonObj.containsKey("unitDesc") ? sliderJsonObj.getString("unitDesc") : null);
                    questionSliderModel.setUnitDesc(sliderJsonObj.containsKey("minDesc") ? sliderJsonObj.getString("minDesc") : null);
                    questionSliderModel.setUnitDesc(sliderJsonObj.containsKey("maxDesc") ? sliderJsonObj.getString("maxDesc") : null);
                    questionModel.questionSliderModel = questionSliderModel;
                    questionModel.questionSliderModel = questionSliderModel;
                }
                if (json.containsKey("responseOptions")) {
                    questionModel.options = new ArrayList<>();
                    JSONArray optionsArray = json.getJSONArray("responseOptions");
                    for (int j = 0; j < optionsArray.size(); ++j) {
                        PPQuestionsModel.PPQuestionResponseOption responseOption = new PPQuestionsModel.PPQuestionResponseOption();
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
                questions.add(questionModel);
            }
        }
    }
}
