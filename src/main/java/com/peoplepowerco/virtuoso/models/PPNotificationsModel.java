package com.peoplepowerco.virtuoso.models;

import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 14/06/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPNotificationsModel {
    private String sendData = null;
    private long sendDataMs = 0L;
    private int deliveryType = 0;
    private int notificationType = 0;
    private String brand = null;
    private String templateName = null;
    private String language = null;
    private String sound = null;
    private int badge = 0;
    private int sentCound = 0;
    private int sourceType = 0;
    private String sourceId = null;
    private String messageText = null;
    private List<PPNotificationsModel> notificationsList = null;

    public String getSendDate() {
        return sendData;
    }

    public void setSendDate(String sendData) {
        this.sendData = sendData;
    }

    public long getSendDateMs() {
        return sendDataMs;
    }

    public void setSendDateMs(long sendDataMs) {
        this.sendDataMs = sendDataMs;
    }

    public int getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(int deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public int getBadge() {
        return badge;
    }

    public void setBadge(int badge) {
        this.badge = badge;
    }

    public int getSentCound() {
        return sentCound;
    }

    public void setSentCound(int sentCound) {
        this.sentCound = sentCound;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public List<PPNotificationsModel> getNotificationsList() {
        return notificationsList;
    }

    public void setNotificationsList(List<PPNotificationsModel> notificationsList) {
        this.notificationsList = notificationsList;
    }
}