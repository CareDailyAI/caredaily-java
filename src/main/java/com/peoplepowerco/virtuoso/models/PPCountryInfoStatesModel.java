package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief :
 * @date : 15. 11. 14.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPCountryInfoStatesModel {
    private int nId = 0;
    private String sName = null;
    private String sTimezoneId = null;
    private boolean bPreffered = false;

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

    public String getTimezoneId(){
        return sTimezoneId;
    }

    public void setTimezoneId(String timezoneId){
        sTimezoneId = timezoneId;
    }

    public boolean getPreffered(){
        return bPreffered;
    }

    public void setPreffered(boolean preffered){
        bPreffered = preffered;
    }
}
