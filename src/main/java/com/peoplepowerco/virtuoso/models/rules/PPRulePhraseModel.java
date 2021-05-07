package com.peoplepowerco.virtuoso.models.rules;

import java.io.Serializable;
import java.util.List;

/**
 * Created by justintan on 4/22/16.
 */
public class PPRulePhraseModel implements Serializable {
    private int id;
    private String name;
    private int type;
    private int display;
    private boolean timezone;
    private String ruleText;
    private String desc;
    private String past;
    List<PPRulePhraseParameterModel> parameters;
    private boolean isMode;
    private boolean isSelected;

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

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
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

    public List<PPRulePhraseParameterModel> getParameters() {
        return parameters;
    }

    public void setParameters(List<PPRulePhraseParameterModel> parameters) {
        this.parameters = parameters;
    }

    public boolean isMode() {
        return isMode;
    }

    public void setMode(boolean mode) {
        isMode = mode;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
