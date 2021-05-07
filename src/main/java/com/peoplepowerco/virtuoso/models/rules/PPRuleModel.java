package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRuleModel implements Serializable {

    private int id;
    private String name;
    private int status;
    private boolean hidden;
    private PPRulePropertyModel trigger;
    private PPRuleStatesModel states;
    private List<PPRulePropertyModel> actions;
    private List<PPRuleCalendarModel> calendars;
    private boolean conditionHeader;
    private boolean actionHeader;
    //This is for schedule list header (Mon, Tue,..)
    private String dayHeader;
    private List<Integer> dayOfWeekList;


    public PPRulePropertyModel getTrigger() {
        return trigger;
    }

    public void setTrigger(PPRulePropertyModel trigger) {
        this.trigger = trigger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public PPRuleStatesModel getStates() {
        return states;
    }

    public void setStates(PPRuleStatesModel states) {
        this.states = states;
    }

    public List<PPRulePropertyModel> getActions() {
        return actions;
    }

    public void setActions(List<PPRulePropertyModel> actions) {
        this.actions = actions;
    }

    public List<PPRuleCalendarModel> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<PPRuleCalendarModel> calendars) {
        this.calendars = calendars;
    }

    public boolean isConditionHeader() {
        return conditionHeader;
    }

    public void setConditionHeader(boolean conditionHeader) {
        this.conditionHeader = conditionHeader;
    }

    public boolean isActionHeader() {
        return actionHeader;
    }

    public void setActionHeader(boolean actionHeader) {
        this.actionHeader = actionHeader;
    }

    public String getDayHeader() {
        return dayHeader;
    }

    public void setDayHeader(String dayHeader) {
        this.dayHeader = dayHeader;
    }

    public List<Integer> getDayOfWeekList() {
        return dayOfWeekList;
    }

    public void setDayOfWeekList(List<Integer> dayOfWeekList) {
        this.dayOfWeekList = dayOfWeekList;
    }
}
