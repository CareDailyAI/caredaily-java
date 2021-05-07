package com.peoplepowerco.virtuoso.models.userinformations;

import android.text.TextUtils;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author : James Cho
 * @brief :
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationModel extends RealmObject {

    @PrimaryKey
    public long id;
    public String userId;
    public String sName;
    public int locationAccess;
    public int userCategory;
    public int fileUploadPolicy;
    public String smsPhone;
    public int nType;
    public String sZip;
    public String sLatitude;
    public String slongitude;
    public double dLatitude;
    public double dLongitude;
    public String salesTaxRate;
    public String sEvent;
    public int nStoriesNumber;
    public int nRoomsNumber;
    public int nBathRoomNumber;
    public int nOccupantsNumber;
    public int nUsagePeriod;
    public int nHeatingType;
    public int nCoolingType;
    public int nWaterHeaterType;
    public int nThermostatType;
    public int nCodeType;
    public String sStartDate;
    public String sAccessEndDate;
    public long lAccessEndDateMs;

    public String sAddress1;
    public String sAddress2;
    public String sAddCity;
    public String sAddState;
    public int iTemporary;
    public String sOrganizationId;

    public PPUserInformationLocationTimezoneModel userInformationLocationTimezoneModel;
    public PPUserInformationLocationStateModel userInformationLocationStateModel;
    public PPUserInformationLocationCountryModel userInformationLocationCountryModel;
    public PPUserInformationLocationOrgModel userInformationLocationOrgModel;
    public RealmList<PPUserInformationServiceModel> userInformationLocationServiceArrayList = new RealmList<>();

    public int getLocationAccess() {
        return locationAccess;
    }

    public void setLocationAccess(int locationAccess) {
        this.locationAccess = locationAccess;
    }

    public int getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(int userCategory) {
        this.userCategory = userCategory;
    }

    public String getAddress1() {
        return sAddress1;
    }

    public void setAddress1(String address1) {
        sAddress1 = address1;
    }

    public String getAddress2() {
        return sAddress2;
    }

    public void setAddress2(String address2) {
        sAddress2 = address2;
    }

    public void setCity(String addCity) {
        sAddCity = addCity;
    }

    public String getCity() {
        return sAddCity;
    }

    public void setState(String state) {
        sAddState = state;
    }

    public String getState() {
        return sAddState;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemporary() {
        return iTemporary;
    }

    public void setTemporary(int temporary) {
        iTemporary = temporary;
    }

    public String getName() {
        return sName;
    }

    public void setName(String name) {
        sName = name;
    }

    public int getType() {
        return nType;
    }

    public void setType(int type) {
        nType = type;
    }

    public String getZip() {
        return sZip;
    }

    public void setZip(String zip) {
        sZip = zip;
    }

    public int getFileUploadPolicy() {
        return fileUploadPolicy;
    }

    public void setFileUploadPolicy(int fileUploadPolicy) {
        this.fileUploadPolicy = fileUploadPolicy;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }


    public String getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(String salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public String getLatitude() {
        return sLatitude;
    }

    public void setLatitude(String latitude) {
        sLatitude = latitude;
    }

    public String getLongitude() {
        return slongitude;
    }

    public void setLongitude(String longitude) {
        slongitude = longitude;
    }

    public String getEvent() {
        return sEvent;
    }

    public void setEvent(String event) {
        sEvent = event;
    }

    public int getStoriesNumber() {
        return nStoriesNumber;
    }

    public void seStroiesNumber(int storyNumber) {
        nStoriesNumber = storyNumber;
    }

    public int getRoomsNumber() {
        return nRoomsNumber;
    }

    public void setRoomsNumber(int roomsNumber) {
        nRoomsNumber = roomsNumber;
    }

    public int getIdBathRoomNumber() {
        return nBathRoomNumber;
    }

    public void setBathRoomNumber(int bathRoomNumber) {
        nBathRoomNumber = bathRoomNumber;
    }

    public int getOccupantsNumber() {
        return nOccupantsNumber;
    }

    public void setOccupantsNumber(int occupantsNumber) {
        nOccupantsNumber = occupantsNumber;
    }

    public int getUsagePeriod() {
        return nUsagePeriod;
    }

    public void setUsagePeriod(int usagePeriod) {
        nUsagePeriod = usagePeriod;
    }

    public int getHeatingType() {
        return nHeatingType;
    }

    public void setHeatingType(int heatingType) {
        nHeatingType = heatingType;
    }

    public int getCoolingType() {
        return nCoolingType;
    }

    public void setCoolingType(int coolingType) {
        nCoolingType = coolingType;
    }

    public int getWaterHeaterType() {
        return nWaterHeaterType;
    }

    public void setWaterHeaterType(int waterHeaterType) {
        nWaterHeaterType = waterHeaterType;
    }

    public int getThermostatType() {
        return nThermostatType;
    }

    public int getCodeType() {
        return nCodeType;
    }

    public void setCodeType(int nCodeType) {
        this.nCodeType = nCodeType;
    }

    public String getAccessEndDate() {
        return sAccessEndDate;
    }

    public void setAccessEndDate(String accessEndDate) {
        sAccessEndDate = accessEndDate;
    }

    public String getStartDate() {
        return sStartDate;
    }

    public void setStartDate(String startDate) {
        sStartDate = startDate;
    }

    public long getAccessEndDateMs() {
        return lAccessEndDateMs;
    }

    public void setAccessEndDateMs(long accessEndDateMs) {
        lAccessEndDateMs = accessEndDateMs;
    }

    public void setThermostatType(int thermostatType) {
        nThermostatType = thermostatType;
    }

    public String getOrganizationId() {
        return sOrganizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.sOrganizationId = organizationId;
    }

    public PPUserInformationLocationTimezoneModel getUserInformationLocationTimezoneModel() {
        return userInformationLocationTimezoneModel;
    }

    public void setUserInformationLocationTimezoneModel(PPUserInformationLocationTimezoneModel timezoneModel) {
        userInformationLocationTimezoneModel = timezoneModel;
    }

    public PPUserInformationLocationStateModel getUserInformationLocationStateModel() {
        return userInformationLocationStateModel;
    }

    public void setUserInformationLocationStateModel(PPUserInformationLocationStateModel stateModel) {
        userInformationLocationStateModel = stateModel;
    }

    public PPUserInformationLocationCountryModel getUserInformationLocationCountryModel() {
        return userInformationLocationCountryModel;
    }

    public void setUserInformationLocationCountryModel(PPUserInformationLocationCountryModel countryModel) {
        userInformationLocationCountryModel = countryModel;
    }

    public String getReadableLocation() {
        boolean needSplit = false;
        StringBuilder builder = new StringBuilder();
        if (!TextUtils.isEmpty(sAddress2)) {
            builder.append(sAddress2);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(sAddress1)) {
            if (needSplit) {
                builder.append(" ");
            }
            builder.append(sAddress1);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(sAddCity)) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(sAddCity);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(sAddState)) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(sAddState);
            needSplit = true;
        }
        if (!TextUtils.isEmpty(sZip)) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(sZip);
            needSplit = true;
        }
        if (null != userInformationLocationCountryModel
            && !TextUtils.isEmpty(userInformationLocationCountryModel.getName())) {
            if (needSplit) {
                builder.append(", ");
            }
            builder.append(userInformationLocationCountryModel.getName());
        }
        return builder.toString();
    }
}
