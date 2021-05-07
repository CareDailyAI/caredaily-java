/**
 * @FileName : PPDeviceFileInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;


import com.peoplepowerco.virtuoso.util.PPUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Bhargav Panchal
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Device Files model for video tab.
 * @date : 2014. 05. 09.
 */
public class PPDeviceFileInfoModel {
    public String sTotalFilesSpace = PPUtil.NULL_STRING;
    public String sUsedFilesSpace = PPUtil.NULL_STRING;
    public String sTempKey = PPUtil.NULL_STRING;
    public String sTempKeyExpire = PPUtil.NULL_STRING;
    public int iCollectionTotalSize = 0;
    public List<PPDeviceFileDetailsModel> fileList = new ArrayList<>();
}
