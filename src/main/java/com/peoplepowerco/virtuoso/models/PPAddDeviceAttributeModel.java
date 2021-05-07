package com.peoplepowerco.virtuoso.models;

/**
 * @FileName : ${file_name}
 * @Project : ${project_name}
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPAddDeviceAttributeModel {
    private String sAttrName = null;
    private String sAttrValue = null;


    public String getAttrName(){
        return sAttrName;
    }

    public String getAttrValue(){ return sAttrValue; }

    public void setAttrName(String attrName){ this.sAttrName = attrName;}

    public void setsAttrValue(String attrValue){ this.sAttrValue = attrValue;}
}
