package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPPostLocationModel extends RealmObject {

    @PrimaryKey
    public String id;
    public String name;
    public String latitude;
    public String longitude;
    public PPPostTimezoneModel timezone;
}
