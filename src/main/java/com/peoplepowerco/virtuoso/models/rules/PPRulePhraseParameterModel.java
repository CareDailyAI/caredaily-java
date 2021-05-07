package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRulePhraseParameterModel implements Serializable {
    private String name;
    private int category;
    private boolean optional;
    private String desc;
    private String value;
    private String minValue;
    private String maxValue;
    private int valueType;
    private String deviceId;

    private List<PPRulePhraseValuesModel> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<PPRulePhraseValuesModel> getValues() {
        return values;
    }

    public void setValues(List<PPRulePhraseValuesModel> values) {
        this.values = values;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
