package com.peoplepowerco.virtuoso.models;

import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 24/04/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPAggregatedListFileModel {

    private long totalFileSpace = 0L;
    private long usedFileSpace = 0L;
    private int fileCount = 0;
    private String startDate = null;
    private long startDateMs = 0L;
    private String endDate = null;
    private long endDateMs = 0L;
    private List<PPAggregatedFileSummaryModel> summaryModelList = null;

    public long getTotalFileSpace() {
        return totalFileSpace;
    }

    public void setTotalFileSpace(long totalFileSpace) {
        this.totalFileSpace = totalFileSpace;
    }

    public long getUsedFileSpace() {
        return usedFileSpace;
    }

    public void setUsedFileSpace(long usedFileSpace) {
        this.usedFileSpace = usedFileSpace;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getEndDateMs() {
        return endDateMs;
    }

    public void setEndDateMs(long endDateMs) {
        this.endDateMs = endDateMs;
    }

    public List<PPAggregatedFileSummaryModel> getSummaryModelList() {
        return summaryModelList;
    }

    public void setSummaryModelList(List<PPAggregatedFileSummaryModel> summaryModelList) {
        this.summaryModelList = summaryModelList;
    }
}
