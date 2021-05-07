package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User badge model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationBadgeModel {
    private int nType = 0;
    private int nCount = 0;

    public int getType(){
        return nType;
    }

    public void setType(int type){
        nType = type;
    }
    public int getCount(){
        return nCount;
    }

    public void setCount(int count){
        nCount = count;
    }
}
