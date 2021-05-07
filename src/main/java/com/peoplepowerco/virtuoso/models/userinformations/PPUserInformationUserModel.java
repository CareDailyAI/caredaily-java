package com.peoplepowerco.virtuoso.models.userinformations;

import java.util.List;

/**
 * @author : James Cho
 * @brief : User model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserModel {

    public int nId = 0;
    public String sUserName = null;
    public String sFirstName = null;
    public String sLastName = null;
    public String sCommunityName = null;

    public boolean bAnonymous = false;
    public int nFileUploadPolicy = 0;
    public String sPhone = null;
    public int nPhoneType;
    public int nSmsType;
    public String sLanguage = null;

    public String sUserEmail = null;
    public boolean bEmailVerified = false;
    public int nEmailStatus = 0;
    public List<Integer> arrayListPermission;

    public int getId() {
        return nId;
    }

    public void setId(int id) {
        nId = id;
    }

    public String getUserName() {
        return sUserName;
    }

    public void setUserName(String userName) {
        sUserName = userName;
    }

    public String getFirstName() {
        return sFirstName;
    }

    public void setFirstName(String firstName) {
        sFirstName = firstName;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String lastName) {
        sLastName = lastName;
    }

    public String getCommunityName() {
        return sCommunityName;
    }

    public void setCommunityName(String sCommunityName) {
        this.sCommunityName = sCommunityName;
    }

    public boolean getAnonymous() {
        return bAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        bAnonymous = anonymous;
    }

    public int getFileUploadPolicy() {
        return nFileUploadPolicy;
    }

    public void setFileUploadPolicy(int fileUploadPolicy) {
        nFileUploadPolicy = fileUploadPolicy;
    }

    public String getPhone() {
        return sPhone;
    }

    public void setPhone(String phone) {
        sPhone = phone;
    }

    public int getPhoneType() {
        return nPhoneType;
    }

    public void setPhoneType(int phoneType) {
        nPhoneType = phoneType;
    }

    public int getSmsType() {
        return nSmsType;
    }

    public void setSmsType(int smsStatus) {
        nSmsType = smsStatus;
    }

    public String getLanguage() {
        return sLanguage;
    }

    public void setLanguage(String language) {
        sLanguage = language;
    }

    public void setArrayListPermission(List<Integer> arrayListPermission) {
        this.arrayListPermission = arrayListPermission;
    }

    public List<Integer> getArrayListPermission() {
        return arrayListPermission;
    }
}
