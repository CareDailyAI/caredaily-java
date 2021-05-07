package com.peoplepowerco.virtuoso.models;


public class PPCallCenterAlertsDeviceModel {
    private String sId = null;
    private int nType = 0;
    private int nGoalId = 0;
    private int nCategoryType = 0;
    private String sDesc = null;

    public String getId(){
        return sId;
    }
    public void setId(String id){
        sId = id;
    }
    public int getType(){
        return nType;
    }
    public void setType(int type){
        nType = type;
    }
    public int getGoalId(){
        return nGoalId;
    }
    public void setGoalId(int goalId){
        nGoalId = goalId;
    }
    public int getCategoryType(){
        return nCategoryType;
    }
    public void setCategoryType(int nCategoryType){
        nCategoryType = nCategoryType;
    }
    public String getDesc(){
        return sDesc;
    }
    public void setDesc(String desc){
        sDesc = desc;
    }
}
