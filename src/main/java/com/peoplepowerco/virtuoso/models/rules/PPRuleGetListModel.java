package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by Justin on 4/22/16.
 */
public class PPRuleGetListModel {

    private List<PPRuleModel> rules;

    public PPRuleGetListModel(){}

    public List<PPRuleModel> getRules() {
        return rules;
    }

    public void setRules(List<PPRuleModel> rules) {
        this.rules = rules;
    }
}
