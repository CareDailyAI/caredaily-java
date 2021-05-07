package com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub;

/**
 * @author : James Cho
 * @date : 2019-12-12
 */
public class DisplayInfoOption {

    private int id;
    private String value;
    private DisplayInfoOptionName mlName;

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

    public DisplayInfoOptionName getMlName() {
        return mlName;
    }

    public void setMlName(DisplayInfoOptionName mlName) {
        this.mlName = mlName;
    }
}
