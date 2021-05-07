package com.peoplepowerco.virtuoso.models;

import android.net.wifi.ScanResult;

/**
 * Created by edwardliu on 2018/7/6.
 */

public class PPWifiModel {

    public boolean isSelected;
    public ScanResult scanResult;
    public String ssid;
    public String securityType;
    public int wifiSignalValues;
    public boolean bOther;

    public PPWifiModel(boolean other) {
        this.bOther = other;
    }

    public PPWifiModel(ScanResult scanResult, boolean isSelected) {
        this.scanResult = scanResult;
        this.isSelected = isSelected;
    }

    public PPWifiModel(String ssid, int wifiSignalValues, String securityType, boolean isSelected) {
        this.ssid = ssid;
        this.wifiSignalValues = wifiSignalValues;
        this.securityType = securityType;
        this.isSelected = isSelected;
    }
}
