/**
 * @FileName : PPUserInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import android.text.TextUtils;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : User information model
 * @date : 2013. 9. 1.
 */
public class PPUserInfoModel extends RealmObject {

    @PrimaryKey
    public String sUserInfoId;
    public String sUserInfoName;
    public String sUserInfoLoId;
    public String sUserInfoLoName;
    public String sUserFirstName;
    public String sUserLastName;
    public String sCommunityName;
    public String sUserInfoLoEvent;
    public String sUserInfoStartDay;
    public String sUserEmail = null;
    public boolean sUserVerified;
    public int nMailStatus;
    public int nSmsStatus;
    public int nPhoneType;
    public String sUserStatus;
    public String sFileUploadPolicy;
    public String sPhoneNumber;
    public String stimezoneId;
    public String stimezoneName;
    public String sLanguage;
    public int iLocationCount = 0;
    public boolean bAnonymous;
    public double dLongitude = 0.0000000;
    public double dLatitude = 0.0000000;

    public String getFullName() {
        if (!TextUtils.isEmpty(sUserFirstName) && !TextUtils.isEmpty(sUserLastName)) {
            return String.format("%s %s", sUserFirstName, sUserLastName);
        }
        if (!TextUtils.isEmpty(sUserInfoName)) {
            return sUserInfoName;
        }
        if (!TextUtils.isEmpty(sUserFirstName)) {
            return sUserFirstName;
        }
        if (!TextUtils.isEmpty(sUserLastName)) {
            return sUserLastName;
        }
        if (!TextUtils.isEmpty(sUserEmail)) {
            return sUserEmail;
        }
        return null;
    }
}
