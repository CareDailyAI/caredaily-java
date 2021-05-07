/**
 * @FileName : PPDeviceParameterInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;


import com.peoplepowerco.virtuoso.util.PPUtil;

/**
 * @brief : Device parameter information Model
 * @date  : Jun 2, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceParameterInfoModel {
    private static final String TAG = "PPDeviceParameterInfoModel";
    private String sName = PPUtil.NULL_STRING;
    private String sValue = PPUtil.NULL_STRING;
    private String sPower = PPUtil.NULL_STRING;
    private String sIndex = PPUtil.NULL_STRING;
    private String sLastUpdatedTime = PPUtil.NULL_STRING;
    private long lastUpdatedTimeMS;
    public String getName() {
        return sName;
    }

    public void setName(String name) {
        sName = name;
    }

    public String getValue() {
        return sValue;
    }

    public void setValue(String value) {
        sValue = value;
    }

    public String getIndex() {
        return sIndex;
    }

    public void setIndex(String index) {
        sIndex = index;
    }

    public String getLastUpdatedTime() {
        return sLastUpdatedTime;
    }

    public void setLastUpdatedTime(String lastUpdatedTime) {
        sLastUpdatedTime = lastUpdatedTime;
    }

    public long getLastUpdatedTimeMS() {
        return lastUpdatedTimeMS;
    }

    public void setLastUpdatedTimeMS(long lastUpdatedTimeMS) {
        this.lastUpdatedTimeMS = lastUpdatedTimeMS;
    }
}

