package com.peoplepowerco.virtuoso.models.userinformations;

/**
 * @author : James Cho
 * @brief : User email model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserEmailModel {

    private String sEmail = null;
    private boolean bVerified = false;
    private int nStatus = 0;

    public String getEmail(){
        return sEmail;
    }

    public void setEmail(String email){
        sEmail = email;
    }

    public boolean getVerified(){
        return bVerified;
    }

    public void setVerified(boolean verified){
        bVerified = verified;
    }

    public int getStatus(){
        return nStatus;
    }

    public void setStatus(int status){
        nStatus = status;
    }
}
