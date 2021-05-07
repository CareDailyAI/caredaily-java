package com.peoplepowerco.virtuoso.models;

/**
 * @author : James Cho
 * @brief :
 * @date : 2017. 9. 13.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPGetServerModel {

    public String sType;
    public String sHost;
    public String sPort;
    public String sAltPort;
    public boolean bSsl;
    public String sAltSsl;
    public String sPath;

    public String getType() {
        return sType;
    }

    public void setType(String strType) {
        this.sType = strType;
    }

    public String getHost() {
        return sHost;
    }

    public void setHost(String strHost) {
        this.sHost = strHost;
    }

    public String getPort() {
        return sPort;
    }

    public void setPort(String strPort) {
        this.sPort = strPort;
    }

    public String getAltPort() {
        return sAltPort;
    }

    public void setAltPort(String strAltport) {
        this.sAltPort = strAltport;
    }

    public boolean isSsl() {
        return bSsl;
    }

    public void setSsl(boolean isSsl) {
        this.bSsl = isSsl;
    }

    public String getAltSsl() {
        return sAltSsl;
    }

    public void setAltSsl(String strSsl) {
        this.sAltSsl = strSsl;
    }

    public String getPath() {
        return sPath;
    }

    public void setPath(String sPath) {
        this.sPath = sPath;
    }
}
