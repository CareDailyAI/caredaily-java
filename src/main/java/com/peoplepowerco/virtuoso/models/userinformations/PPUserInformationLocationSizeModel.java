package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User location size model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationSizeModel {

    private int nValue = 0;
    private String sUnit = null;

    public int getValue(){
        return nValue;
    }

    public void setValue(int value){
        nValue = value;
    }

    public String getUnit(){
        return sUnit;
    }

    public void setUnit(String unit){
        sUnit = unit;
    }
}
