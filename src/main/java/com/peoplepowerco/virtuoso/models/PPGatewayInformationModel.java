package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief :
 * @date : 2015. 12. 23.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPGatewayInformationModel {

    private String sDeviceId = null;
    private boolean bConnected = false;
    private String sDescription = null;
    private int nDeviceType;

    public void setDeviceId(String deviceId) {
        sDeviceId = deviceId;
    }

    public String getDeviceId() {
        return sDeviceId;
    }

    public void setIsConnected(boolean connected) {
        bConnected = connected;
    }

    public boolean getIsConnected() {
        return bConnected;
    }

    public void setDescription(String description) {
        sDescription = description;
    }

    public String getDescription() {
        return sDescription;
    }

    public void setDeviceType(int deviceType) {
        nDeviceType = deviceType;
    }

    public int getDeviceType() {
        return nDeviceType;
    }
}
