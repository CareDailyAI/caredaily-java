package com.peoplepowerco.virtuoso.models;


import java.util.ArrayList;

public class PPCallCenterAlertsModel {

    private String sAlertDate = null;
    private String sAlertDateMs = null;
    private int nAlertStatus = 0;
    private String sSignalType = null;
    private String sSignalMessage = null;
    private ArrayList<PPCallCenterAlertsDeviceModel> callCenterAlertsDeviceModelsArrayList = null;

    public String getAlertDate(){
        return sAlertDate;
    }
    public void setAlertDate(String alertDate){
        sAlertDate = alertDate;
    }
    public String getAlertDateMs(){
        return sAlertDateMs;
    }
    public void setAlertDateMs(String alertDateMs){
        sAlertDateMs = alertDateMs;
    }
    public int getAlertStatus(){
        return nAlertStatus;
    }
    public void setAlertStatus(int alertStatus){
        nAlertStatus = alertStatus;
    }
    public String getSignalType(){
        return sSignalType;
    }
    public void setSignalType(String signalType){
        sSignalType = signalType;
    }
    public String getSignalMessage(){
        return sSignalMessage;
    }
    public void setSignalMessage(String signalMessage){
        sSignalMessage = signalMessage;
    }
    public ArrayList<PPCallCenterAlertsDeviceModel> getCallCenterAlertsDeviceModelsArrayList(){
        return callCenterAlertsDeviceModelsArrayList;
    }
    public void setCallCenterAlertsDeviceModelsArrayList(ArrayList<PPCallCenterAlertsDeviceModel> CallCenterAlertsDeviceModelsList){
        callCenterAlertsDeviceModelsArrayList = CallCenterAlertsDeviceModelsList;
    }

}
