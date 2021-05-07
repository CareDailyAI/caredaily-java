package com.peoplepowerco.virtuoso.models.rules;

/**
 * @author : James Cho
 * @brief :
 * @date : 03/05/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPRuleTypeForSelectedDeviceModel {

    private int id = 0;
    private String deviceId = null;
    //TRIGGER or STATE or ACTION
    private int ruleState = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getRuleType() {
        return ruleState;
    }

    public void setRuleType(int ruleState) {
        this.ruleState = ruleState;
    }

}
