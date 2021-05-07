package com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub;

import java.util.List;

/**
 * @author : James Cho
 * @date : 2019-12-12
 */
public class DisplayInfoParameters {

    private String name;
    private List<DisplayInfoOption> displayOptionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DisplayInfoOption> getDisplayOptionList() {
        return displayOptionList;
    }

    public void setDisplayOptionList(List<DisplayInfoOption> displayOptionList) {
        this.displayOptionList = displayOptionList;
    }
}
