package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief :
 * @date : 2017. 2. 17.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPOperationTokenModel {
    private String token = null;
    private String tokenType = null;
    private String validFrom = null;
    private String expire= null;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getTokenType(){
        return tokenType;
    }

    public void setTokenType(String tokenType){
        this.tokenType = tokenType;
    }

    public String getValidFrom(){
        return validFrom;
    }

    public void setValidFrom(String validFrom){
        this.validFrom = validFrom;
    }

    public String getexpire(){
        return expire;
    }

    public void setExpire(String expire){
        this.expire = expire;
    }
}
