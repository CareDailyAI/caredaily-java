package com.peoplepowerco.virtuoso.models.storybook;

import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoDeviceListBindings;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoParameters;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoTests;
import java.util.List;

public class DisplayInfo {
    private List<PPLocationSpaceModel> locationSpaces = null;
    private boolean controllable;
    private boolean customRuleFlag;
    private boolean customRules;
    private boolean displayDetails;
    private boolean displayDetailsFlag;
    private DeviceBundle deviceBundle;
    private String appStoreUrl;
    private String iconName;
    private String iconType;
    private List<DisplayInfoTests> displayInfoTests;
    private List<DisplayInfoParameters> displayInfoParameters;
    private List<DisplayInfoDeviceListBindings> displayInfoDeviceListBindings;

    public DeviceBundle getDeviceBundle() {
        return deviceBundle;
    }

    public void setDeviceBundle(DeviceBundle deviceBundle) {
        this.deviceBundle = deviceBundle;
    }

    public List<PPLocationSpaceModel> getLocationSpaces() {
        return locationSpaces;
    }

    public void setLocationSpaces(List<PPLocationSpaceModel> locationSpaces) {
        this.locationSpaces = locationSpaces;
    }

    public boolean isControllable() {
        return controllable;
    }

    public void setControllable(boolean controllable) {
        this.controllable = controllable;
    }

    public boolean isCustomRuleFlag() {
        return customRuleFlag;
    }

    public void setCustomRuleFlag(boolean customRuleFlag) {
        this.customRuleFlag = customRuleFlag;
    }

    public boolean isCustomRules() {
        return customRules;
    }

    public void setCustomRules(boolean customRules) {
        this.customRules = customRules;
    }

    public boolean isDisplayDetails() {
        return displayDetails;
    }

    public void setDisplayDetails(boolean displayDetails) {
        this.displayDetails = displayDetails;
    }

    public boolean isDisplayDetailsFlag() {
        return displayDetailsFlag;
    }

    public void setDisplayDetailsFlag(boolean displayDetailsFlag) {
        this.displayDetailsFlag = displayDetailsFlag;
    }

    public String getAppStoreUrl() {
        return appStoreUrl;
    }

    public void setAppStoreUrl(String appStoreUrl) {
        this.appStoreUrl = appStoreUrl;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public List<DisplayInfoTests> getDisplayInfoTests() {
        return displayInfoTests;
    }

    public void setDisplayInfoTests(List<DisplayInfoTests> displayInfoTests) {
        this.displayInfoTests = displayInfoTests;
    }

    public List<DisplayInfoParameters> getDisplayInfoParameters() {
        return displayInfoParameters;
    }

    public void setDisplayInfoParameters(List<DisplayInfoParameters> displayInfoParameters) {
        this.displayInfoParameters = displayInfoParameters;
    }

    public List<DisplayInfoDeviceListBindings> getDisplayInfoDeviceListBindings() {
        return displayInfoDeviceListBindings;
    }

    public void setDisplayInfoDeviceListBindings(List<DisplayInfoDeviceListBindings> displayInfoDeviceListBindings) {
        this.displayInfoDeviceListBindings = displayInfoDeviceListBindings;
    }
}