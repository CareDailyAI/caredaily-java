package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleAndModel implements Serializable {

    List<PPRulePropertyModel> state;

    public List<PPRulePropertyModel> getState() {
        return state;
    }

    public void setState(List<PPRulePropertyModel> state) {
        this.state = state;
    }
}
