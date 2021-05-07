package com.peoplepowerco.virtuoso.bean;

public class DeviceOptionParameterItem {

    public String displayName;
    public String parameter;
    public String value;
    public String icon;
    public String fontType;
    public boolean isRanged;

    public DeviceOptionParameterItem(String paramName, String name, String value, String icon, String fontType) {
        this.parameter = paramName;
        this.displayName = name;
        this.value = value;
        this.icon = icon;
        this.fontType = fontType;
        this.isRanged = isRanged;
    }

    public DeviceOptionParameterItem(String paramName, String name, String value, String icon, String fontType, boolean isRanged) {
        this.parameter = paramName;
        this.displayName = name;
        this.value = value;
        this.icon = icon;
        this.fontType = fontType;
        this.isRanged = isRanged;
    }
}
