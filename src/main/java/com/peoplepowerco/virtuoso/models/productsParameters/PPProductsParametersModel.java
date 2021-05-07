package com.peoplepowerco.virtuoso.models.productsParameters;

/**
 * @author : James Cho
 * @date : 2019-11-19
 */

public class PPProductsParametersModel {
    private String systemMultiplier;
    private String systemUnit;
    private int scale;
    private boolean profiled;
    private boolean adjustment;
    private boolean configured;
    private boolean numeric;
    private boolean editable;
    private int historical;
    private String description;
    private String name;
    private PPParameterDisplayModel displayModel;

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public int getHistorical() {
        return historical;
    }

    public void setHistorical(int historical) {
        this.historical = historical;
    }

    public String getSystemMultiplier() {
        return systemMultiplier;
    }

    public void setSystemMultiplier(String systemMultiplier) {
        this.systemMultiplier = systemMultiplier;
    }

    public String getSystemUnit() {
        return systemUnit;
    }

    public void setSystemUnit(String systemUnit) {
        this.systemUnit = systemUnit;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public boolean isProfiled() {
        return profiled;
    }

    public void setProfiled(boolean profiled) {
        this.profiled = profiled;
    }

    public boolean isAdjustment() {
        return adjustment;
    }

    public void setAdjustment(boolean adjustment) {
        this.adjustment = adjustment;
    }

    public boolean isConfigured() {
        return configured;
    }

    public void setConfigured(boolean configured) {
        this.configured = configured;
    }

    public boolean isNumeric() {
        return numeric;
    }

    public void setNumeric(boolean numeric) {
        this.numeric = numeric;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PPParameterDisplayModel getDisplayModel() {
        return displayModel;
    }

    public void setDisplayModel(PPParameterDisplayModel displayModel) {
        this.displayModel = displayModel;
    }
}
