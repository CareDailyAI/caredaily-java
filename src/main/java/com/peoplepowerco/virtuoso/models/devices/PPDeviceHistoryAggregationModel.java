package com.peoplepowerco.virtuoso.models.devices;


public class PPDeviceHistoryAggregationModel {
    String aggregationType = null;
    String aggregationDetail = null;
    boolean isSelected = false;

    public String getAggregationType() {
        return aggregationType;
    }

    public void setAggregationType(String aggregationType) {
        this.aggregationType = aggregationType;
    }

    public String getAggregationDetail() {
        return aggregationDetail;
    }

    public void setAggregationDetail(String aggreataionDetail) {
        this.aggregationDetail = aggreataionDetail;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
