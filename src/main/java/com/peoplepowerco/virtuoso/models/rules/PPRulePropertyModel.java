package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRulePropertyModel implements Serializable {
    private int id;
    private String name;
    private String ruleText;
    private int type;
    private int display;
    private boolean timezone;
    private String desc;
    private String past;
    List<PPRuleParameterModel> parameters;

    public PPRulePropertyModel() {}

    public PPRulePropertyModel(PPRulePhraseModel phrase, List<PPRuleParameterModel> parameters) {
        this.id = phrase.getId();
        this.name = phrase.getName();
        this.ruleText = phrase.getRuleText();
        this.type = phrase.getType();
        this.display = phrase.getDisplay();
        this.desc = phrase.getDesc();
        this.past = phrase.getPast();
        this.parameters = parameters;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }

    public boolean isTimezone() {
        return timezone;
    }

    public void setTimezone(boolean timezone) {
        this.timezone = timezone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPast() {
        return past;
    }

    public void setPast(String past) {
        this.past = past;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    public List<PPRuleParameterModel> getParameters() {
        return parameters;
    }

    public void setParameters(List<PPRuleParameterModel> parameters) {
        this.parameters = parameters;
    }
}
