/**
 * @FileName : PPSharedDeviceModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;


import com.peoplepowerco.virtuoso.util.PPUtil;

/**
 * Model used for ownDevices and friendDevices.
 */
public class PPSharedDeviceModel {
    private String sDeviceID = PPUtil.NULL_STRING;
    private int iType = 0;
    private String sTypeCategory = PPUtil.NULL_STRING;
    private String sDescription = PPUtil.NULL_STRING;
    private String sEvents = PPUtil.NULL_STRING;
    private String sCurrentEvent = PPUtil.NULL_STRING;
    private boolean bShared = false;
    private boolean bMute = false;
    private boolean bConnected = false;

    /**
     * Determines whether the friend is currently being shared to.
     *
     * @return True if the current event is in the events list.
     * False otherwise.
     */
    public boolean isCurrentlySharedTo() {
        return sEvents.contains(sCurrentEvent);
    }

    public String getDeviceID() {
        return sDeviceID;
    }

    public void setDeviceID(String deviceID) {
        sDeviceID = deviceID;
    }

    public int getType() {
        return iType;
    }

    public void setType(int type) {
        iType = type;
    }

    public String getTypeCategory() {
        return sTypeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        sTypeCategory = typeCategory;
    }

    public String getDescription() {
        return sDescription;
    }

    public void setDescription(String description) {
        sDescription = description;
    }

    public String getEvents() {
        return sEvents;
    }

    public void setEvents(String events) {
        sEvents = events;
    }

    public String getCurrentEvent() {
        return sCurrentEvent;
    }

    public void setCurrentEvent(String currentEvent) {
        sCurrentEvent = currentEvent;
    }

    public boolean isShared() {
        return bShared;
    }

    public void setShared(boolean shared) {
        bShared = shared;
    }

    public boolean isMute() {
        return bMute;
    }

    public void setMute(boolean mute) {
        bMute = mute;
    }

    public boolean isConnected() {
        return bConnected;
    }

    public void setConnected(boolean connected) {
        bConnected = connected;
    }
}
