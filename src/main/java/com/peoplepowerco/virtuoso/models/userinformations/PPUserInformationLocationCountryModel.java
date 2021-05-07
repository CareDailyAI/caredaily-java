package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author : James Cho
 * @brief : User country model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationCountryModel extends RealmObject {

    @PrimaryKey
    public long locationId;
    public String id;
    public String sName = null;
    public String sCountryCode = null;
    public String sCurrencyCode = null;
    public String sCurrencySymbol = null;
    public String sZipFormat = null;
    public String sStateName = null;
    public String sZipName = null;

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

    public String getCountryCode() {
        return sCountryCode;
    }

    public void setCountryCode(String countryCode) {
        sCountryCode = countryCode;
    }

    public String getsCurrencyCode() {
        return sCurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        sCurrencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return sCurrencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        sCurrencySymbol = currencySymbol;
    }

    public String getsZipFormat() {
        return sZipFormat;
    }

    public void setZipFormat(String zipFormat) {
        sZipFormat = zipFormat;
    }

    public String getStateName() {
        return sStateName;
    }

    public void setsStateName(String stateName) {
        sStateName = stateName;
    }

    public String getZipName() {
        return sZipName;
    }

    public void setZipName(String zipName) {
        sZipName = zipName;
    }

}
