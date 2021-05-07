package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPUserInformationLocationOrgModel extends RealmObject {

    @PrimaryKey
    public long locationId;
    public String id;
    public String sName;
    public String sContactName1;
    public String sContactEmail1;
    public String sContactPhone1;
}
