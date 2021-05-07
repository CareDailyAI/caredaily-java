/**
 * @FileName  : PPServerInformationModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @author James Cho 
 * Server Information Class
 */
public class PPServerInformationModel {
	public String sType = null;
	public String sHost = null;
	public String sPort = null;
	public String sAltPort = null;
	public String sSsl = null;
	public String sAltSsl = null;
    public String sBrand = null;

    public String getType()
	{
		return sType;
	}

	public void setType(String strType)
	{
		this.sType = strType;
	}
	
	public String getHost()
	{
		return sHost;
	}

	public void setHost(String strHost)
	{
		this.sHost = strHost;
	}
	
	public String getPort()
	{
		return sPort;
	}

	public void setPort(String strPort)
	{
		this.sPort = strPort;
	}
	
	public String getAltPort()
	{
		return sAltPort;
	}

	public void setAltPort(String strAltport)
	{
		this.sAltPort = strAltport;
	}
	
	public String getSsl()
	{
		return sSsl;
	}

	public void setSsl(String strSsl)
	{
		this.sSsl = strSsl;
	}
	
	public String getAltSsl()
	{
		return sAltSsl;
	}

	public void setAltSsl(String strSsl)
	{
		this.sAltSsl = strSsl;
	}

    public String getBrand() {
        return sBrand;
    }

    public void setBrand(String sBrand) {
        this.sBrand = sBrand;
    }
}
