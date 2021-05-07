package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.models.PPQuestionSliderModel;
import com.peoplepowerco.virtuoso.models.PPQuestionsModel;
import com.peoplepowerco.virtuoso.models.PPQuestionsModel.PPQuestionCollectionReference;
import com.peoplepowerco.virtuoso.util.PPUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionsParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
//            if (PPAppCenter.SPRINT_VERSION > 20) {
//                final JSONArray jaArrayProperty = jso.getJSONArray("questions");
//                if (null != jaArrayProperty) {
//                    Realm.getDefaultInstance().executeTransaction(new Transaction() {
//                        @Override
//                        public void execute(Realm realm) {
//                            parseForFamilyNew(realm, jaArrayProperty);
//                        }
//                    });
//                }
//            } else {
//            }
            parseForFamily(jso, obj);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }

//    private void parseForFamilyNew(Realm realm, JSONArray array) {
//        for (int i = 0; i < array.size(); i++) {
//            JSONObject json = array.getJSONObject(i);
//            if (!json.containsKey("sectionId")) {
//                continue;
//            }
//
//            long questionId = json.getLongValue("id");
//            PPQuestionsModel questionModel = realm.where(PPQuestionsModel.class).equalTo("id", questionId).findFirst();
//            if (null == questionModel) {
//                questionModel = realm.createObject(PPQuestionsModel.class, questionId);
//            }
//            questionModel.creationDate = json.getString("creationDate");
//            questionModel.key = json.getString("key");
//            questionModel.urgent = json.getBooleanValue("urgent");
//            questionModel.front = json.getBooleanValue("front");
//            questionModel.editable = json.getBooleanValue("editable");
//            questionModel.aggregatePublicly = json.getBooleanValue("aggregatePublicly");
//            questionModel.question = json.getString("question");
//            questionModel.placeholder = json.getString("placeholder");
//            questionModel.responseType = json.getIntValue("responseType");
//            questionModel.displayType = json.getIntValue("displayType");
//            questionModel.appInstanceId = json.getLongValue("appInstanceId");
//            questionModel.defaultAnswer = json.getString("defaultAnswer");
//            questionModel.answerFormat = json.getString("answerFormat");
//            questionModel.sliderMin = json.getIntValue("sliderMin");
//            questionModel.sliderMax = json.getIntValue("sliderMax");
//            questionModel.sliderInc = json.getIntValue("sliderInc");
//            questionModel.sectionTitle = json.getString("sectionTitle");
//            questionModel.sectionId = json.getIntValue("sectionId");
//            questionModel.questionWeight = json.getIntValue("questionWeight");
//
//            if (json.containsKey("responseOptions")) {
//                questionModel.options.deleteAllFromRealm();
//                JSONArray optionsArray = json.getJSONArray("responseOptions");
//                for (int j = 0; j < optionsArray.size(); ++j) {
//                    JSONObject optionObj = optionsArray.getJSONObject(j);
////                    PPQuestionResponseOption responseOption = realm.createObject(PPQuestionResponseOption.class);
////                    responseOption.id = optionObj.getIntValue("id");
////                    responseOption.text = optionObj.getString("text");
////                    questionModel.options.add(responseOption);
//                }
//            }
//            questionModel.deviceId = json.getString("deviceId");
//            questionModel.icon = json.getString("icon");
//            questionModel.answerStatus = json.getIntValue("answerStatus");
//            questionModel.answer = json.getString("answer");
//            questionModel.answerModified = json.getBooleanValue("answerModified");
//            questionModel.answerPoints = json.getIntValue("answerPoints");
//            questionModel.answerDate = json.getString("answerDate");
//            PPQuestionCollectionReference collection = new PPQuestionCollectionReference();
//            if (json.containsKey("collection")) {
//                JSONObject collectionJson = json.getJSONObject("collection");
//                collection.id = collectionJson.getIntValue("id");
//                collection.description = collectionJson.getString("description");
//                collection.name = collectionJson.getString("name");
//                collection.icon = collectionJson.getString("icon");
//                collection.weight = collectionJson.getIntValue("weight");
//            } else {
//                collection.name = "Other Settings";
//                collection.icon = PPFontIconLabel.ICON_FA_COGS;
//                collection.weight = 10010;
//            }
//        }
//    }

    private void parseForFamily(JSONObject jso, Object[] obj) {
        JSONArray jaArrayProperty = null;
        JSONObject json = null;
        boolean getOnlyFrontPageQuestions = (boolean) obj[0];
        boolean getOnlyEditableQuestions = (boolean) obj[1];
        LinkedHashMap<PPQuestionCollectionReference, List<PPQuestionsModel>> results
            = (LinkedHashMap<PPQuestionCollectionReference, List<PPQuestionsModel>>) obj[2];
        results.clear();
        HashMap<PPQuestionCollectionReference, List<PPQuestionsModel>> responseSections = new HashMap<>();
        jaArrayProperty = (jso.containsKey("questions")) ? jso.getJSONArray("questions") : null;
        if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
            for (int i = 0; i < jaArrayProperty.size(); i++) {
                json = jaArrayProperty.getJSONObject(i);
                if (!json.containsKey("sectionId")) {
                    continue;
                }
                boolean front = json.getBooleanValue("front");
                boolean editable = json.getBooleanValue("editable");
                int responseType = json.getIntValue("responseType");
                int sectionId = json.getIntValue("sectionId");
                String sectionTitle = json.getString("sectionTitle");
                if (getOnlyFrontPageQuestions && !front) {
                    continue;
                }
                if (getOnlyEditableQuestions && !editable) {
                    continue;
                }

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
                PPQuestionCollectionReference collection = new PPQuestionCollectionReference();
                if (json.containsKey("collection")) {
                    JSONObject collectionJson = json.getJSONObject("collection");
                    collection.id = collectionJson.getIntValue("id");
                    collection.description = collectionJson.getString("description");
                    collection.name = collectionJson.getString("name");
                    collection.icon = collectionJson.getString("icon");
                    collection.weight = collectionJson.getIntValue("weight");
                } else {
                    collection.name = "Other Settings";
                    collection.icon = PPFontIconLabel.ICON_FA_COGS;
                    collection.weight = 10010;
                }
                List<PPQuestionsModel> models = null;
                if (!responseSections.containsKey(collection)) {
                    models = new ArrayList<>();
                    responseSections.put(collection, models);
                } else {
                    models = responseSections.get(collection);
                }

                boolean bAdded = false;
                //Fix duplicated key in submodels.
                if (!models.isEmpty()) {
                    for (PPQuestionsModel subModel : models) {
                        if (!PPUtil.isEmpty(subModel.key) && subModel.key.equals(questionModel.key)) {
                            bAdded = true;
                            break;
                        }
                    }
                }
                if (!bAdded) {
                    models.add(questionModel);
                }
            }

            List<PPQuestionCollectionReference> keys = new ArrayList<>();
            keys.addAll(responseSections.keySet());
            Collections.sort(keys, new SectionComparator());
            for (PPQuestionCollectionReference key : keys) {
                List<PPQuestionsModel> models = responseSections.get(key);
                Collections.sort(models, new QuestionComparator());
                results.put(key, models);
            }
        }
    }

    private class QuestionComparator implements Comparator<PPQuestionsModel> {

        @Override
        public int compare(PPQuestionsModel o1, PPQuestionsModel o2) {
            if (o1.questionWeight > o2.questionWeight) {
                return 1;
            } else if (o1.questionWeight < o2.questionWeight) {
                return -1;
            }
            return 0;
        }
    }

    private class SectionComparator implements Comparator<PPQuestionCollectionReference> {

        @Override
        public int compare(PPQuestionCollectionReference o1, PPQuestionCollectionReference o2) {
            if (o1.weight > o2.weight) {
                return 1;
            } else if (o1.weight < o2.weight) {
                return -1;
            }
            return 0;
        }
    }
}
