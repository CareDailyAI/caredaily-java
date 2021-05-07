package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem;
import io.realm.Realm;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPQuestionsSimpleParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
            final JSONArray jaArrayProperty = (jso.containsKey("questions")) ? jso.getJSONArray("questions") : null;
            if (null != jaArrayProperty) {
//                Realm.getDefaultInstance().executeTransaction(new Transaction() {
//                    @Override
//                    public void execute(Realm realm) {
//
//                    }
//                });
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                parseForFamily(realm, jaArrayProperty);
                realm.commitTransaction();
                realm.close();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }

    private void parseForFamily(Realm realm, JSONArray jaArrayProperty) {
        if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
            for (int i = 0; i < jaArrayProperty.size(); i++) {
                JSONObject json = jaArrayProperty.getJSONObject(i);
                int responseType = json.getIntValue("responseType");
                int displayType = json.getIntValue("displayType");
                //10 means PPQuestionResponseTypeYesNoDisplayTypeOnOff = 10
                if (!json.containsKey("sectionId") || responseType != 1 || displayType != 0) {
                    continue;
                }
                long questionId = json.getLongValue("id");
                CRSimpleQuestionItem questionItem = realm.where(CRSimpleQuestionItem.class)
                    .equalTo("id", questionId).findFirst();
                if (null == questionItem) {
                    questionItem = realm.createObject(CRSimpleQuestionItem.class);
                    questionItem.id = questionId;
                }
                questionItem.key = json.getString("key");
                questionItem.defaultAnswer = json.getString("defaultAnswer");
                questionItem.editable = json.getBooleanValue("editable") ? 1 : 0;
                questionItem.answer = json.getString("answer");
                questionItem.answerStatus = json.getIntValue("answerStatus");
            }
        }
    }
}
