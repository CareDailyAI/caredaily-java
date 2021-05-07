package com.peoplepowerco.virtuoso.bean;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class CRSwitchDevice extends RealmObject {

    @PrimaryKey
    public String deviceId;
    public String paramName;
    public long updateTimeMs;
    public boolean isChecked;

    public static CRSwitchDevice findItemById(Realm realm, String deviceId) {
        return realm.where(CRSwitchDevice.class)
            .equalTo("deviceId", deviceId)
            .findFirst();
    }

    public static CRSwitchDevice findItem(Realm realm, String deviceId, String paramName) {
        return realm.where(CRSwitchDevice.class)
            .beginGroup()
            .equalTo("deviceId", deviceId)
            .and()
            .equalTo("paramName", paramName)
            .endGroup()
            .findFirst();
    }
}
