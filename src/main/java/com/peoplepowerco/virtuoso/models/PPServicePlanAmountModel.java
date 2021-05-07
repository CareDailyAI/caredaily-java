package com.peoplepowerco.virtuoso.models;

public class PPServicePlanAmountModel {
    private String sCurrencyCode;
    private String sCurrencySymbol;
    private String sValue;


    public String getCurrencyCode(){
        return sCurrencyCode;
    }

    public void setCurrencyCode(String code){
        sCurrencyCode = code;
    }

    public String getCurrencySymbol(){
        return sCurrencySymbol;
    }

    public void setCurrencySymbol(String symbol){
        sCurrencySymbol = symbol;
    }

    public String getValue(){
        return sValue;
    }

    public void setValue(String value){
        sValue = value;
    }

}
