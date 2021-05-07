/**
 * @FileName : PPCountryInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

/**
 * @brief : country information model(need to be extended)
 * @date  : Jul 9, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPCountryInfoModel {
    private int nId = 0;
    private String sCountryName = null;
    private String sCountryCode = null;
    private String sCurrencyCode = null;
    private String sCurrencySymbol = null;
    private String sZipFormat = null;
    private String sStateName = null;
    private String sZipName = null;
    private boolean bPreferred = true;

    public String getFormatCountryInfo() {
        return sFormatCountryInfo;
    }

    public void setFormatCountryInfo(String sFormatCountryInfo) {
        this.sFormatCountryInfo = sFormatCountryInfo;
    }

    private String sFormatCountryInfo = null;
    private ArrayList<PPCountryInfoTimezonesModel> countryInfoTimezonesModelArrayList = null;
    private ArrayList<PPCountryInfoStatesModel> countryInfoStatesModelArrayList = null;

    public int getId() {
        return nId;
    }

    public void setId(int id) {
        nId = id;
    }

    public String getCountryName() {
        return sCountryName;
    }

    public void setCountryName(String countryName) {
        sCountryName = countryName;
    }

    public String getCountryCode() {
        return sCountryCode;
    }

    public void setCountryCode(String countryCode) {
        sCountryCode = countryCode;
    }

    public String getCurrencyCode() {
        return sCurrencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        sCurrencyCode = currencyCode;
    }

    public String getCurrencySymbol() {
        return sCurrencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        sCurrencySymbol = currencySymbol;
    }

    public String getZipFormat() {
        return sZipFormat;
    }

    public void setZipFormat(String zipFormat) {
        sZipFormat = zipFormat;
    }

    public String getStateName() {
        return sStateName;
    }

    public void setStateName(String stateName) {
        sStateName = stateName;
    }

    public String getZipName() {
        return sZipName;
    }

    public void setZipName(String zipName) {
        sZipName = zipName;
    }

    public boolean getPreffered() {
        return bPreferred;
    }

    public void setPreferred(boolean preferred) {
        bPreferred = preferred;
    }

    public ArrayList<PPCountryInfoTimezonesModel> getCountryInfoTimezonesModelArrayList() {
        return countryInfoTimezonesModelArrayList;
    }

    public void setCountryInfoTimezonesModelArrayList(ArrayList<PPCountryInfoTimezonesModel> timezonesModelArrayList) {
        countryInfoTimezonesModelArrayList = timezonesModelArrayList;
    }

    public ArrayList<PPCountryInfoStatesModel> getCountryInfoStatesModelArrayList() {
        return countryInfoStatesModelArrayList;
    }

    public void setCountryInfoStatesModelArrayList(ArrayList<PPCountryInfoStatesModel> statesModelArrayList) {
        countryInfoStatesModelArrayList = statesModelArrayList;
    }
}
