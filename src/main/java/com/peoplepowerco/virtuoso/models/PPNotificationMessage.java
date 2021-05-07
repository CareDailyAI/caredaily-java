/**
 * @FileName : PPNotificationMessage.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;


import com.peoplepowerco.virtuoso.util.PPUtil;

public class PPNotificationMessage implements Comparable<PPNotificationMessage> {
    private String date;
    private String time;
    private String message;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(PPNotificationMessage o) {
        long timeMill = PPUtil.getFormatDatetime(getTime());
        long otherTimeMill = PPUtil.getFormatDatetime(o.getTime());
        if (timeMill > otherTimeMill) {
            return 1;
        } else if (timeMill < otherTimeMill) {
            return -1;
        }
        return 0;
    }
}




