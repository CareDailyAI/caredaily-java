package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleSavePropertyModel {
    private int id;
    private List<PPRuleSaveParameterModel> parameter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PPRuleSaveParameterModel> getParameter() {
        return parameter;
    }

    public void setParameter(List<PPRuleSaveParameterModel> parameter) {
        this.parameter = parameter;
    }
}
