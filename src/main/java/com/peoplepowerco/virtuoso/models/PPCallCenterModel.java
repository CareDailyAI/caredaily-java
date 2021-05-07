package com.peoplepowerco.virtuoso.models;


import java.io.Serializable;
import java.util.ArrayList;

public class PPCallCenterModel implements Serializable {
    private static final long serialVersionUID = 2742951225624379426L;

    private String sUserId = null;
    private int nStatus = 0;
    private int nAlertStatus = 0;
    private String sCodeWord = null;
    private String sPermitId = null;
    private String sAlertDate = null;
    private String sAlertDateMs = null;
    private String sAlertStatusDate = null;
    private String sAlertStatisDateMs = null;
    private ArrayList<PPCallCenterContactsModel> callCenterContactsModelArrayList = null;
    private ArrayList<String> callCenterMissingFields = null;

    public String getUserId() {
        return sUserId;
    }

    public void setUserId(String userId) {
        sUserId = userId;
    }

    public String getCodeWord() {
        return sCodeWord;
    }

    public void setCodeWord(String codeword) {
        sCodeWord = codeword;
    }

    public String getPermitId() {
        return sPermitId;
    }

    public void setPermitId(String permitId) {
        sPermitId = permitId;
    }

    public int getStatus() {
        return nStatus;
    }

    public void setStatus(int status) {
        nStatus = status;
    }

    public int getAlertStatus() {
        return nAlertStatus;
    }

    public void setAlertStatus(int alertStatus) {
        nAlertStatus = alertStatus;
    }

    public String getAlertDate() {
        return sAlertDate;
    }

    public void setAlertDate(String alertDate) {
        sAlertDate = alertDate;
    }

    public String getAlertDateMs() {
        return sAlertDateMs;
    }

    public void setAlertDateMs(String alertDateMs) {
        sAlertDateMs = alertDateMs;
    }

    public String getAlertStatusDate() {
        return sAlertStatusDate;
    }

    public void setAlertStatusDate(String alertStatusDate) {
        sAlertStatusDate = alertStatusDate;
    }

    public String getAlertStatusDateMs() {
        return sAlertStatisDateMs;
    }

    public void setAlertStatusDateMs(String alertStatusDateMs) {
        sAlertStatisDateMs = alertStatusDateMs;
    }

    public ArrayList<PPCallCenterContactsModel> getCallCenterContactsModelArrayList() {
        return callCenterContactsModelArrayList;
    }

    public void setCallCenterContactsModelArrayList(ArrayList<PPCallCenterContactsModel> callCenterContactsModelList) {
        callCenterContactsModelArrayList = callCenterContactsModelList;
    }

    public ArrayList<String> getCallCenterMissingFieldsArrayList() {
        return callCenterMissingFields;
    }

    public void setCallCenterMissingFieldsArrayList(ArrayList<String> callCenterMissingFieldList) {
        callCenterMissingFields = callCenterMissingFieldList;
    }
}
