package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleStatesModel implements Serializable {

    List<PPRulePropertyModel> state;
    List<PPRuleAndModel> and;

    public List<PPRulePropertyModel> getState() {
        return state;
    }

    public void setState(List<PPRulePropertyModel> state) {
        this.state = state;
    }

    public List<PPRuleAndModel> getAnd() {
        return and;
    }

    public void setAnd(List<PPRuleAndModel> and) {
        this.and = and;
    }
}
