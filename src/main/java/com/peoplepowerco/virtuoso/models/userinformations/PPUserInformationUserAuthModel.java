package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User auth model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserAuthModel {
    private int nAppId = 0;
    private String sAppName = null;
    private String sUserName = null;
    private boolean bActive = false;
    private String sExpiry = null;
    private boolean bAutoRefresh = false;

    public int getAppId(){
        return nAppId;
    }

    public void setAppId(int appId){
        nAppId = appId;
    }

    public String getAppName(){
        return sAppName;
    }

    public void setAppName(String appName){
        sUserName = appName;
    }

    public String getUserName(){
        return sUserName;
    }

    public void setUserName(String userName){
        sUserName = userName;
    }

    public boolean getActive(){
        return bActive;
    }

    public void setActive(boolean active){
        bActive = active;
    }

    public String getExpiry(){
        return sExpiry;
    }

    public void setExpiry(String expiry){
        sExpiry = expiry;
    }

    public boolean getAutoRefresh(){
        return bAutoRefresh;
    }

    public void setAutoRefresh(boolean autoRefresh){
        bAutoRefresh = autoRefresh;
    }
}
