package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleSaveStatesModel {
    private List<PPRuleSavePropertyModel> state;

    public List<PPRuleSavePropertyModel> getState() {
        return state;
    }

    public void setState(List<PPRuleSavePropertyModel> state) {
        this.state = state;
    }
}
