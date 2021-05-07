package com.peoplepowerco.virtuoso.bean;

public class FASubscriptionItem {

    public String content;
    public int type;
    public boolean defaultLogo;

    public FASubscriptionItem(String content, int type, boolean bDefaultLogo) {
        this.content = content;
        this.type = type;
        this.defaultLogo = bDefaultLogo;
    }

    public static final int TYPE_DIVIDER = 0;
    public static final int TYPE_LOGO = 1;
    public static final int TYPE_TEXT = 2;
    public static final int TYPE_PHONE = 3;
    public static final int TYPE_TEXT_CONTACT = 4;
    public static final int TYPE_MAIL = 5;
    public static final int TYPE_LINK = 6;
}
