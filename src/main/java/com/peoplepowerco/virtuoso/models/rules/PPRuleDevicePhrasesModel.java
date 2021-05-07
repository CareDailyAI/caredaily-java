package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Justin on 4/22/16.
 */
public class PPRuleDevicePhrasesModel implements Serializable {

    private String deviceId;
    private String deviceName;
    private String deviceIcon;
    private Integer sequence;
    private int deviceType;
    private int display;
    private int deviceCategoryType;
    private int deviceSelectedType;
//    private boolean selected;
    private List<PPRulePhraseModel> triggers;
    private List<PPRulePhraseModel> states;
    private List<PPRulePhraseModel> actions;
    private boolean isMode;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceIcon() {
        return deviceIcon;
    }

    public void setDeviceIcon(String deviceIcon) {
        this.deviceIcon = deviceIcon;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public List<PPRulePhraseModel> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<PPRulePhraseModel> triggers) {
        this.triggers = triggers;
    }

    public List<PPRulePhraseModel> getStates() {
        return states;
    }

    public void setStates(List<PPRulePhraseModel> states) {
        this.states = states;
    }

    public List<PPRulePhraseModel> getActions() {
        return actions;
    }

    public void setActions(List<PPRulePhraseModel> actions) {
        this.actions = actions;
    }

    public int getDeviceCategoryType() {
        return deviceCategoryType;
    }

    public void setDeviceCategoryType(int deviceCategoryType) {
        this.deviceCategoryType = deviceCategoryType;
    }

    public boolean isMode() {
        return isMode;
    }

    public void setMode(boolean mode) {
        isMode = mode;
    }

    public int getDeviceSelectedType() {
        return deviceSelectedType;
    }

    public void setDeviceSelectedType(int deviceSelectedType) {
        this.deviceSelectedType = deviceSelectedType;
    }
}
