package com.peoplepowerco.virtuoso.models.storybook;

import java.util.List;

/**
 * Created by edwardliu on 2018/6/21.
 */

public class PPGetDeviceModel {
    private List<PPGetDeviceCategory> categories = null;

    public List<PPGetDeviceCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<PPGetDeviceCategory> categories) {
        this.categories = categories;
    }
}
