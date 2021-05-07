package com.peoplepowerco.virtuoso.models;

public class PPBeaconModel {
    public String uuid;
    public String major;
    public String minor;
    public int rssi;
    public String locationId;

    public PPBeaconModel(String uuid, String major, String minor, int rssi) {
        this.uuid = uuid;
        this.major = major;
        this.minor = minor;
        this.rssi = rssi;
    }
}
