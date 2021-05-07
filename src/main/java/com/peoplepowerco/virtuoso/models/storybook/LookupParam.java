package com.peoplepowerco.virtuoso.models.storybook;

import java.util.List;

public class LookupParam {
    private Integer deviceType;
    private List<Param> params = null;

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

}