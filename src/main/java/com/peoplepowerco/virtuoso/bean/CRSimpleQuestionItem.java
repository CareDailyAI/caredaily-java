package com.peoplepowerco.virtuoso.bean;

import com.peoplepowerco.virtuoso.PPCommonInfo;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmObject;

public class CRSimpleQuestionItem extends RealmObject {

    public long id;
    public int answerStatus;
    public String defaultAnswer;
    public String answer;
    public String key;
    public int editable;

    public static CRSimpleQuestionItem findItemByKey(Realm realm, String key) {
        return realm.where(CRSimpleQuestionItem.class)
            .equalTo("key", key).findFirst();
    }

    public static void updateQuestionItem(Realm realm, final String key, final boolean enabled) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                CRSimpleQuestionItem questionItem = findItemByKey(realm, key);
                if (null != questionItem) {
                    questionItem.answerStatus = PPCommonInfo.PPQuestionAnswerStatusAnswered;
                    questionItem.answer = enabled ? "true" : "false";
                }
            }
        });
    }
}
