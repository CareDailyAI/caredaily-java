package com.peoplepowerco.virtuoso.models;


public class PPQuestionSliderModel {

    private int sliderMin;
    private int sliderMax;
    private int sliderInc;
    private String unitDesc;
    private String minDesc;
    private String maxDesc;

    public int getSliderMin() {
        return sliderMin;
    }

    public void setSliderMin(int sliderMin) {
        this.sliderMin = sliderMin;
    }

    public int getSliderMax() {
        return sliderMax;
    }

    public void setSliderMax(int sliderMax) {
        this.sliderMax = sliderMax;
    }

    public int getSliderInc() {
        return sliderInc;
    }

    public void setSliderInc(int sliderInc) {
        this.sliderInc = sliderInc;
    }

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getMinDesc() {
        return minDesc;
    }

    public void setMinDesc(String minDesc) {
        this.minDesc = minDesc;
    }

    public String getMaxDesc() {
        return maxDesc;
    }

    public void setMaxDesc(String maxDesc) {
        this.maxDesc = maxDesc;
    }
}
