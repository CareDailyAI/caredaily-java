package com.peoplepowerco.virtuoso.models.communities;

import android.text.TextUtils;
import io.realm.RealmObject;

public class PPPostAddressModel extends RealmObject {

    public String addrStreet1;
    public String addrStreet2;
    public String addrCity;
    public String stateId;
    public String countryId;
    public String zip;

    public String getReadableLocation() {
        boolean needSplit = false;
        StringBuilder builder = new StringBuilder();
        if (!TextUtils.isEmpty(addrStreet1)) {
            builder.append(addrStreet1);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(addrStreet2)) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(addrStreet2);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(addrCity)) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(addrCity);
        }
        return builder.toString();
    }
}
