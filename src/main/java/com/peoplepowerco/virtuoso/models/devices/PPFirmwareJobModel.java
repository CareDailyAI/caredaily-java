package com.peoplepowerco.virtuoso.models.devices;

/**
 * Created by laghee on 5/26/17.
 */

public class PPFirmwareJobModel {
    private int id;
    private String index;
    private String firmware;
    private String currentFirmware;
    private int status;
    private String notificationDate;
    private long notificationDateMs;
    private String startDate;
    private long startDateMs;
//    private PPDeviceModel device;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getCurrentFirmware() {
        return currentFirmware;
    }

    public void setCurrentFirmware(String currentFirmware) {
        this.currentFirmware = currentFirmware;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public long getNotificationDateMs() {
        return notificationDateMs;
    }

    public void setNotificationDateMs(long notificationDateMs) {
        this.notificationDateMs = notificationDateMs;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public long getStartDateMs() {
        return startDateMs;
    }

    public void setStartDateMs(long startDateMs) {
        this.startDateMs = startDateMs;
    }

//    public PPDeviceModel getDevice() {
//        return device;
//    }

//    public void setDevice(PPDeviceModel device) {
//        this.device = device;
//    }
}
