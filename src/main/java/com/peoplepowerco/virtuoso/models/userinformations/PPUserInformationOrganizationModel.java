package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User organization model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationOrganizationModel {
    private int nId = 0;
    private String sName = null;
    private String sDomainName = null;
    private int nStatus = 0;
    private int nGroupId = 0;
    private String sGroupName = null;
    private int nGroupPoints = 0;
    private int nPoints = 0;
    private int nPointsLevel = 0;
    private String sNotes = null;

    public int getId(){
        return nId;
    }

    public void setId(int id){
        nId = id;
    }

    public String getName(){
        return sName;
    }

    public void setName(String name){
        sName = name;
    }

    public String getDonmainName(){
        return sDomainName;
    }

    public void setDomainName(String domainName){
        sDomainName = domainName;
    }

    public int getStatus(){
        return nStatus;
    }

    public void setStatus(int status){
        nStatus = status;
    }

    public int getGroupId(){
        return nGroupId;
    }

    public void setGroupId(int groupId){
        nGroupId = groupId;
    }

    public String getsGroupName(){
        return sGroupName;
    }

    public void setGroupName(String groupName){
        sGroupName = groupName;
    }

    public int getGroupPoints(){
        return nGroupPoints;
    }

    public void setnGroupPoints(int groupPoints){
        nGroupPoints = groupPoints;
    }

    public int getPoints(){
        return nPoints;
    }

    public void setPoints(int points){
        nPoints = points;
    }

    public int getPointLeve(){
        return nPointsLevel;
    }

    public void setnPointsLevel(int pointsLevel){
        nPointsLevel = pointsLevel;
    }

    public String getNotes(){
        return sNotes;
    }

    public void setNotes(String note){
        sNotes = note;
    }
}
