package com.peoplepowerco.virtuoso.models.devices;

/**
 * Created by edwardliu on 2018/2/7.
 */

public class PPDeviceFAQModel {

    private String question;
    private String answer;
    private boolean android;
    private boolean expand;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isAndroid() {
        return android;
    }

    public void setAndroid(boolean android) {
        this.android = android;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}
