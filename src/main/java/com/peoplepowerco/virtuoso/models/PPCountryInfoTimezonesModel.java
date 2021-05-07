package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief : Timezone model
 * @date : 15. 11. 14.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPCountryInfoTimezonesModel {
    private String sId = null;
    private int nOffset = 0;
    private boolean bDst = false;
    private String sName = null;

    public String getId(){
        return sId;
    }

    public void setId(String id){
        sId = id;
    }

    public int getOffset(){
        return nOffset;
    }

    public void setnOffset(int offset){
        nOffset = offset;
    }

    public boolean getDst(){
        return bDst;
    }

    public void setDst(boolean dst){
        bDst = dst;
    }

    public String getName(){
        return sName;
    }

    public void setName(String name){
        sName = name;
    }
}
