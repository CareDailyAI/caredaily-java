package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author : James Cho
 * @brief : User location time zone model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationTimezoneModel extends RealmObject {

    @PrimaryKey
    public long locationId;
    public String id;
    public int nOffset;
    public boolean bDst;
    public String sName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOffset() {
        return nOffset;
    }

    public void setOffset(int offset) {
        nOffset = offset;
    }

    public boolean getDst() {
        return bDst;
    }

    public void setDst(boolean dst) {
        bDst = dst;
    }

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        sName = name;
    }
}
