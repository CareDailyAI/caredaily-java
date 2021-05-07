package com.peoplepowerco.virtuoso.bean;

public class DeviceOptionItem {
    public int type;
    public String name;
    public String value;

    public DeviceOptionItem(int type) {
        this.type = type;
    }

    public DeviceOptionItem(String name, String value, int type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public static final int TYPE_ROW_DIVIDER = 0;
    public static final int TYPE_ACTION_NAME = 1;
    public static final int TYPE_ACTION_BEHAVIOR = 2;
    public static final int TYPE_ACTION_ROOM = 3;
    public static final int TYPE_ACTION_IMAGE = 4;
    public static final int TYPE_ROW_ITEM = 5;
    public static final int TYPE_ACTION_PARAMETERS = 6;
    public static final int TYPE_ACTION_DEGREES = 7;
    public static final int TYPE_ACTION_RATE = 8;
    public static final int TYPE_ROW_DEVICE_ID = 9;
}
