package com.peoplepowerco.virtuoso.models.deviceBundle;

import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmList;
import io.realm.RealmObject;

public class BundleModel extends RealmObject {

    public int count;
    public String icon;
    public int ownedCount;
    public boolean compressed;
    public RealmList<Integer> indexes = new RealmList<>();
    public RealmList<String> modelIds = new RealmList<>();
    public int mediaType;
    public String mediaUrl;

    public void setOwnedCount(Realm realm, final int ownedCount) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                BundleModel.this.ownedCount = ownedCount;
            }
        });
    }
}
