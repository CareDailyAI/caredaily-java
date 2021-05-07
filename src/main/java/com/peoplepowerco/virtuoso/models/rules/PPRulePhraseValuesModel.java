package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRulePhraseValuesModel implements Serializable {
    private String id;
    private String name;
    private String selectorValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelectorValue() {
        return selectorValue;
    }

    public void setSelectorValue(String selectorValue) {
        this.selectorValue = selectorValue;
    }
}
