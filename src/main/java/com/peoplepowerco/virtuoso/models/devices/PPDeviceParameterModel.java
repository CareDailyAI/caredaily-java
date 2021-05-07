package com.peoplepowerco.virtuoso.models.devices;

/**
 * Created by justintan on 6/15/16.
 */
public class PPDeviceParameterModel {

    private String name;
    private String value;
    private String lastUpdateTime;
    private long lastUpdateTimeMs;
    private String index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getLastUpdateTimeMs() {
        return lastUpdateTimeMs;
    }

    public void setLastUpdateTimeMs(long lastUpdateTimeMs) {
        this.lastUpdateTimeMs = lastUpdateTimeMs;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
