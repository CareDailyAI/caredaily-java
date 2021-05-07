package com.peoplepowerco.virtuoso.models;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

public class PPCardServiceModel extends RealmObject {

    @PrimaryKey
    public String id;
    public String icon;
    public String title;
    public String comment;
    public String description;
    public String statusText;
    public int status;
    public float percent;
    public boolean active;
    public String questionId;
    public String collectionId;
    public String sectionId;
    public long updatedMs;
    public int weight;
    public int displayType;

    public static final int TYPE_SECTION = 0;
    public static final int TYPE_ALL = 1;
    public static final int TYPE_NORMAL = 2;

    public static PPCardServiceModel findItemById(Realm realm, String id) {
        return realm.where(PPCardServiceModel.class).equalTo("id", id).findFirst();
    }

    public static RealmResults<PPCardServiceModel> findAll(Realm realm) {
        return realm.where(PPCardServiceModel.class).notEqualTo("status", -1).sort("weight").findAll();
    }
}
