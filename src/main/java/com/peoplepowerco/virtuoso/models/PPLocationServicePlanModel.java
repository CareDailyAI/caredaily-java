package com.peoplepowerco.virtuoso.models;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPLocationServicePlanModel extends RealmObject {

    @PrimaryKey
    public long userPlanId;
    public long locationId;
    public int type;
    public int paymentType;
    public int status;
    public long startDateMs;
    public long endDateMs;
    public boolean free;
    public boolean isPaid;
    public String gatewayId;
    public String subscriptionId;
    public String services;

    public static PPLocationServicePlanModel getRenewServicePlan(Realm realm, String locationId) {
        PPLocationServicePlanModel renewServicePlan = null;
        PPLocationServicePlanModel locationPlan = realm.where(PPLocationServicePlanModel.class)
            .equalTo("locationId", Long.valueOf(locationId))
            .and()
            .equalTo("isPaid", true)
            .findFirst();
        if (null == locationPlan) {
            renewServicePlan = realm.where(PPLocationServicePlanModel.class)
                .beginGroup()
                .equalTo("locationId", Long.valueOf(locationId))
                .and()
                .equalTo("isPaid", false)
                .and()
                .equalTo("status", 0)
                .and()
                .contains("services", "family")
                .endGroup()
                .findFirst();
        }
        return renewServicePlan;
    }
}
