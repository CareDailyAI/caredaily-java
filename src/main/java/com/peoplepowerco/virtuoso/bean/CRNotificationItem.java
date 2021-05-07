package com.peoplepowerco.virtuoso.bean;

import com.peoplepowerco.virtuoso.PPCommonInfo;

public class CRNotificationItem {

    public String title;
    public String message;
    public String locationId;
    public String deviceId;
    public String postId;
    public String communityId;
    public String sound;
    public int type = PPCommonInfo.PPInvalidValue;
    public int badge = PPCommonInfo.PPInvalidValue;
}
