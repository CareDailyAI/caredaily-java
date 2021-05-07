package com.peoplepowerco.virtuoso.bean;

import com.peoplepowerco.virtuoso.models.PPQuestionsModel.PPQuestionCollectionReference;

public class SettingItem {

    public int itemType;
    public String primaryText;
    public String secondayText;
    public PPQuestionCollectionReference collectionReference;
    public boolean isPincode;

    public SettingItem() {
    }

    public SettingItem(int type) {
        itemType = type;
    }

    public SettingItem(int type, String text) {
        itemType = type;
        primaryText = text;
    }

    public static final int ITEM_TYPE_SECTION = 0;
    public static final int ITEM_TYPE_QUESTION = 1;
    public static final int ITEM_TYPE_SITE_OWNER = 2;
    public static final int ITEM_TYPE_CALL_TREE = 3;
    public static final int ITEM_TYPE_PINCODE = 4;
    public static final int ITEM_TYPE_DURESSCODE = 5;
    public static final int ITEM_TYPE_VERBALCODE = 6;
    public static final int ITEM_TYPE_PERMITID = 7;
    public static final int ITEM_TYPE_AUTH = 8;
    public static final int ITEM_TYPE_EMS = 9;
}
