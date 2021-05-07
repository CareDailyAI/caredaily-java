package com.peoplepowerco.virtuoso.models.rules;

import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */

public class PPRuleSaveModel {
    private String name;
    private int status;
    private String hidden;
    private String timeZone;
    private PPRuleSavePropertyModel trigger;
    private PPRuleSaveStatesAndModel states;
    private List<PPRuleCalendarModel> calendar;

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public List<PPRuleCalendarModel> getCalendar() {
        return calendar;
    }

    public void setCalendar(List<PPRuleCalendarModel> calendar) {
        this.calendar = calendar;
    }

    private PPRuleSaveActionsModel actions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public PPRuleSavePropertyModel getTrigger() {
        return trigger;
    }

    public void setTrigger(PPRuleSavePropertyModel trigger) {
        this.trigger = trigger;
    }

    public PPRuleSaveStatesAndModel getStates() {
        return states;
    }

    public void setStates(PPRuleSaveStatesAndModel states) {
        this.states = states;
    }

    public PPRuleSaveActionsModel getActions() {
        return actions;
    }

    public void setActions(PPRuleSaveActionsModel actions) {
        this.actions = actions;
    }
}
