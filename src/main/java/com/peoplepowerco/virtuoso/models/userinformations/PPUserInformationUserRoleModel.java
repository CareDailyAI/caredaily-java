package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User role model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserRoleModel {
    private int nId = 0;
    private String sName = null;
    private String sDescription = null;

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

    public String getDescription(){
        return sDescription;
    }

    public void setDescription(String description){
        sDescription = description;
    }

}
