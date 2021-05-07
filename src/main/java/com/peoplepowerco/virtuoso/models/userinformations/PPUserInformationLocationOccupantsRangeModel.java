package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User Occupant range model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationLocationOccupantsRangeModel {
    private int nStart = 0;
    private int nEnd = 0;
    private int nNumber = 0;

    public int getStart(){
        return nStart;
    }

    public void setStart(int start){
        nStart = start;
    }

    public int getEnd(){
        return nEnd;
    }

    public void setEnd(int end){
        nEnd = end;
    }

    public int getNumber(){
        return nNumber;
    }

    public void setNumber(int number){
        nNumber = number;
    }
}
