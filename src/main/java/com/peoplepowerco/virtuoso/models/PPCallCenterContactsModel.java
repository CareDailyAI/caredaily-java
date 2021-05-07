package com.peoplepowerco.virtuoso.models;


import android.text.TextUtils;

import com.peoplepowerco.virtuoso.PPCommonInfo;

import java.io.Serializable;

public class PPCallCenterContactsModel implements Serializable {

    private static final long serialVersionUID = 5658243830337929541L;

    private int iUserId = PPCommonInfo.PPInvalidValue;
    private String sFristName = null;
    private String sLastName = null;
    private String sPhone = null;
    private String sAvatarId = null;

    public PPCallCenterContactsModel() {
    }

    public String getFirstName() {
        return sFristName;
    }

    public void setFirstName(String firstName) {
        sFristName = firstName;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String LastName) {
        sLastName = LastName;
    }

    public String getPhone() {
        return sPhone;
    }

    public void setPhone(String phoneNumber) {
        sPhone = phoneNumber;
    }

    public String getFullName() {
        if (!TextUtils.isEmpty(sFristName) && !TextUtils.isEmpty(sLastName)) {
            return String.format("%s %s", sFristName, sLastName);
        }
        if (!TextUtils.isEmpty(sFristName)) {
            return sFristName;
        }
        if (!TextUtils.isEmpty(sLastName)) {
            return sLastName;
        }
        return null;
    }

    public int getUserId() {
        return iUserId;
    }

    public void setUserId(int iUserId) {
        this.iUserId = iUserId;
    }

    public String getAvatarId() {
        return sAvatarId;
    }

    public void setAvatarId(String sAvatarId) {
        this.sAvatarId = sAvatarId;
    }
}
