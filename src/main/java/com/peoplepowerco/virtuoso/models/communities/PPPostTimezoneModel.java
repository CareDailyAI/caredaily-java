package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPPostTimezoneModel extends RealmObject {
    @PrimaryKey
    public String id;
    public String name;
    public int offset;
    public boolean dst;
}
