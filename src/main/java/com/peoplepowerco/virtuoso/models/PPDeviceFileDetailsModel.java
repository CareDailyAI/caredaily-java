/**
 * @FileName : PPDeviceFileDetailsModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.List;

/**
 * @brief : Device Files model for video tab which is represent PPDeviceFileInfoModel.
 * @date  : 2014. 05. 09.
 * @author : Bhargav Panchal
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceFileDetailsModel {
    public String sId;
    public String sType;
    public String sName;
    public long size;
    public String deviceId;
    public String locationId;
    public String userId;

    public boolean isThumbnail;
    public boolean isViewed;
    public boolean isFavourite;
    public boolean isLocalFavourite;
    public boolean isPublicAccess;
    public String sCreationDate;
    public long creationTime;
    public String duration;
    public int shared;
    public int rotate;
    public boolean isIncomplete;
    public boolean isSelected = false;
    public List<PPUserInfoModel> userInfoList;
    public List<PPDeviceInfoModel> deviceInfoList;
}
