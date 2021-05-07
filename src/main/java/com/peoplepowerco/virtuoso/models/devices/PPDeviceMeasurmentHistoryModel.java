package com.peoplepowerco.virtuoso.models.devices;

import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 2017. 12. 13.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPDeviceMeasurmentHistoryModel {
    private String sDeviceId;
    private String sTimeStamp;
    private long lTimeMs;
    private List<PPDeviceParameterModel> deviceParameterModelList;
    private String sDateSection;
    private boolean bSecton;

    public String getsDeviceId() {
        return sDeviceId;
    }

    public String getsTimeStamp() {
        return sTimeStamp;
    }

    public long getlTimeMs() {
        return lTimeMs;
    }

    public void setsDeviceId(String sDeviceId) {
        this.sDeviceId = sDeviceId;
    }

    public void setsTimeStamp(String sTimeStamp) {
        this.sTimeStamp = sTimeStamp;
    }

    public void setlTimeMs(long lTimeMs) {
        this.lTimeMs = lTimeMs;
    }

    public List<PPDeviceParameterModel> getDeviceParameterModelList() {
        return deviceParameterModelList;
    }

    public void setDeviceParameterModelList(List<PPDeviceParameterModel> deviceParameterModelList) {
        this.deviceParameterModelList = deviceParameterModelList;
    }

    public String getsDateSection() {
        return sDateSection;
    }

    public void setsDateSection(String sDateSection) {
        this.sDateSection = sDateSection;
    }

    public boolean isbSecton() {
        return bSecton;
    }

    public void setbSecton(boolean bSecton) {
        this.bSecton = bSecton;
    }
}
