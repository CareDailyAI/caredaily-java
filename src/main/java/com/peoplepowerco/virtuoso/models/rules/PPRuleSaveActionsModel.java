package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleSaveActionsModel {
    private List<PPRuleSavePropertyModel> action;

    public List<PPRuleSavePropertyModel> getAction() {
        return action;
    }

    public void setAction(List<PPRuleSavePropertyModel> action) {
        this.action = action;
    }
}
