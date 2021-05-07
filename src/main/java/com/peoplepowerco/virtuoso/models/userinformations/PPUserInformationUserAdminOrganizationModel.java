package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User admin organization model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserAdminOrganizationModel {
    private int nId = 0;
    private String sName = null;
    private String sDomainName = null;
    private String sFeatures = null;

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

    public String getFeatures(){
        return sFeatures;
    }

    public void setFeatures(String features){
        sFeatures = features;
    }
}
