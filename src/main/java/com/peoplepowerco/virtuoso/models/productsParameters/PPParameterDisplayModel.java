package com.peoplepowerco.virtuoso.models.productsParameters;

import java.util.List;

/**
 * @author : James Cho
 * @date : 2019-11-19
 */
public class PPParameterDisplayModel {
    private int defaultOption;
    private int valueType;
    private String iconFont;
    private int displayType;
    private int maxValue;
    private int minValue;
    private String step;
    private PPParameterDisplayMLNameModel mlNameModel;
    private String icon;
    private List<PPParameterDisplayOptionModel> optionList;
    private boolean hidden;
    private boolean ranged;

    public int getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(int defaultOption) {
        this.defaultOption = defaultOption;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valueType) {
        this.valueType = valueType;
    }

    public String getIconFont() {
        return iconFont;
    }

    public void setIconFont(String iconFont) {
        this.iconFont = iconFont;
    }

    public int getDisplayType() {
        return displayType;
    }

    public void setDisplayType(int displayType) {
        this.displayType = displayType;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public PPParameterDisplayMLNameModel getMlNameModel() {
        return mlNameModel;
    }

    public void setMlNameModel(PPParameterDisplayMLNameModel mlNameModel) {
        this.mlNameModel = mlNameModel;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<PPParameterDisplayOptionModel> getOptioList() {
        return optionList;
    }

    public void setOptionList(List<PPParameterDisplayOptionModel> optionList) {
        this.optionList = optionList;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isRanged() {
        return ranged;
    }

    public void setRanged(boolean ranged) {
        this.ranged = ranged;
    }
}
