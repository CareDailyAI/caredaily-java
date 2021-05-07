package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author : James Cho
 * @brief : User location state model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationStateModel extends RealmObject {

    @PrimaryKey
    public long locationId;
    public String id;
    public String sName;
    public String sTimezone;
    public String sAbbr;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        sName = name;
    }

    public String getTimezone() {
        return sTimezone;
    }

    public void setTimezone(String timezone) {
        sTimezone = timezone;
    }

    public String getAbbr() {
        return sAbbr;
    }

    public void setAbbr(String abbr) {
        sAbbr = abbr;
    }
}
