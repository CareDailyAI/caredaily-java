package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by Justin on 4/22/16.
 */
public class PPRuleGetPhrasesModel {

    private List<PPRulePhraseModel> triggers;
    private List<PPRulePhraseModel> states;
    private List<PPRulePhraseModel> actions;

    public List<PPRulePhraseModel> getTriggers() {
        return triggers;
    }

    public void setTriggers(List<PPRulePhraseModel> triggers) {
        this.triggers = triggers;
    }

    public List<PPRulePhraseModel> getStates() {
        return states;
    }

    public void setStates(List<PPRulePhraseModel> states) {
        this.states = states;
    }

    public List<PPRulePhraseModel> getActions() {
        return actions;
    }

    public void setActions(List<PPRulePhraseModel> actions) {
        this.actions = actions;
    }
}
