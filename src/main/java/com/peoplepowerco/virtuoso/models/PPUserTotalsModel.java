/**
 * @FileName : PPUserTotalsModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;

public class PPUserTotalsModel {
    private int iDevicesTotal = 0;
    private int iFilesTotal = 0;
    private int iRulesTotal = 0;
    private int iFriendsTotal = 0;


    public int getDevicesTotal() {
        return iDevicesTotal;
    }

    public void setDevicesTotal(int iDevicesTotal) {
        this.iDevicesTotal = iDevicesTotal;
    }

    public int getFilesTotal() {
        return iFilesTotal;
    }

    public void setFilesTotal(int iFilesTotal) {
        this.iFilesTotal = iFilesTotal;
    }

    public int getRulesTotal() {
        return iRulesTotal;
    }

    public void setRulesTotal(int iRulesTotal) {
        this.iRulesTotal = iRulesTotal;
    }

    public int getFriendsTotal() {
        return iFriendsTotal;
    }

    public void setFriendsTotal(int iFriendsTotal) {
        this.iFriendsTotal = iFriendsTotal;
    }
}
