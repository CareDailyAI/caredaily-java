package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief :
 * @date : 24/04/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPAggregatedFileSummaryModel {
    private String date = null;
    private long dateMs = 0L;
    private int total = 0;
    private int deleted = 0;
    private long size = 0L;
    private int duration = 0;
    private int viewed = 0;
    private int favourite = 0;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getDateMs() {
        return dateMs;
    }

    public void setDateMs(long dateMs) {
        this.dateMs = dateMs;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }
}
