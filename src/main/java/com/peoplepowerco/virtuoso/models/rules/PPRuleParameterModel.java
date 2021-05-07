package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleParameterModel implements Serializable {
    private String name;
    private int category;
    private String value;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
