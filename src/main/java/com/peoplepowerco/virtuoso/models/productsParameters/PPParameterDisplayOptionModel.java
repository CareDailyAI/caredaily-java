package com.peoplepowerco.virtuoso.models.productsParameters;

/**
 * @author : James Cho
 * @date : 2019-11-19
 */
public class PPParameterDisplayOptionModel {

    private PPParameterDisplayMLNameModel mlNameModel;
    private int id;
    private String value;
    private String icon;
    private String icon_font;

    public PPParameterDisplayMLNameModel getMlNameModel() {
        return mlNameModel;
    }

    public void setMlNameModel(PPParameterDisplayMLNameModel mlNameModel) {
        this.mlNameModel = mlNameModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconfont() {
        return icon_font;
    }

    public void setIconfont(String icon_font) {
        this.icon_font = icon_font;
    }
}
