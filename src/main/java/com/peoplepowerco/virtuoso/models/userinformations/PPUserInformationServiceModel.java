package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;

/**
 * @author : James Cho
 * @brief : User service model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationServiceModel extends RealmObject {

    public long locationId;
    public String sName;
    public int nAmount;
    public String sStartDate;
    public long lStartDateMs;
    public String sEndDate;
    public long lEndDateMs;

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        sName = name;
    }

    public int getAmount() {
        return nAmount;
    }

    public void setAmount(int amount) {
        nAmount = amount;
    }

    public String getStartDate() {
        return sStartDate;
    }

    public void setStartDate(String startDate) {
        sStartDate = startDate;
    }

    public long getStartDateMs() {
        return lStartDateMs;
    }

    public void setStartDateMs(long startDateMs) {
        lStartDateMs = startDateMs;
    }

    public String getEndDate() {
        return sEndDate;
    }

    public void setEndDate(String endDate) {
        sEndDate = endDate;
    }

    public long getEndDateMs() {
        return lEndDateMs;
    }

    public void setEndDateMs(long endDateMs) {
        this.lEndDateMs = endDateMs;
    }
}
