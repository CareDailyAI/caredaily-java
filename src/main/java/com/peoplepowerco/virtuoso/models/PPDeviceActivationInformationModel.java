/**
 * @FileName  : PPDeviceActivationInformationModel
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief : TED Device Register Model
 * @date  : Sep 14, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceActivationInformationModel {
	public String sDeviceActivationKey = null;
	public String sHost = null;
	public String sPort = null;
	public String sUri = null;
	public String sSsl =null;
	
	
	public PPDeviceActivationInformationModel(){}
	
	public String getDevcieActivationKey(){
		return sDeviceActivationKey;
	}
	
	public void setDeviceActivationKey(String sKey){
		sDeviceActivationKey = sKey;
	}
	
	public String getHost(){
		return sHost;
	}
	
	public void setHost(String HostName){
		sHost = HostName;
	}
	
	public String getUri()
	{
		return sUri;
	}
	
	public void setUri(String Uri){
		sUri = Uri;
	}
	
	public void setPort(String PortName){
		sPort = PortName;
	}
	
	public String getPort()
	{
		return sPort;
	}
	

	
	public String getSsl(){
		return sSsl;
	}
	
	public void setSsl(String Ssl)
	{
		sSsl = Ssl;
	}
}
