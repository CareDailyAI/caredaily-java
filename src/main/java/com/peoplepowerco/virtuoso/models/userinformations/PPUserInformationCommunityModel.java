package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.Realm;
import io.realm.RealmObject;

public class PPUserInformationCommunityModel extends RealmObject {

    public String locationId;
    public String communityId;
    public String communityName;

    public static PPUserInformationCommunityModel firstCommunity(Realm realm) {
        if (null == realm || realm.isClosed()) {
            return null;
        }
        return realm.where(PPUserInformationCommunityModel.class).findFirst();
    }

    public static String getLocationCommunityName(Realm realm, String locationId) {
        if (null == realm || realm.isClosed()) {
            return null;
        }
        PPUserInformationCommunityModel locationCommunity = realm.where(PPUserInformationCommunityModel.class)
            .equalTo("locationId", locationId).findFirst();
        if (null != locationCommunity) {
            return locationCommunity.communityName;
        }
        return null;
    }
}
