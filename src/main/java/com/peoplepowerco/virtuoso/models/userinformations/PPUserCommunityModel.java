package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.Realm;
import io.realm.RealmObject;

public class PPUserCommunityModel extends RealmObject {

    public long communityId;
    public String communityName;

    public static boolean isModerator(Realm realm, long communityId) {
        if (null == realm || realm.isClosed()) {
            return false;
        }
        return null != realm.where(PPUserCommunityModel.class).equalTo("communityId", communityId).findFirst();
    }
}
