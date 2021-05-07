/**
 * @FileName  : PPBlueLineNetworkInfoModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

public class PPBlueLineNetworkInfoModel {
	public String strPcmwifiBLVersion = null;
	public String strPcmwifiAppVersion = null;
	public String strPcmwifiMACAddress = null;
	public String strPcmwifiIpAddress = null;
	public String strPcmwifiTime = null;
	public String strSensorKhTimes10 = null;
	public String strSensorAddress = null;
	public String strHostTarget = null;
	public String strHostUploadPath = null;
	public String strHostUploadPort = null;
	public String strHostUseSSL = null;
	public String strHostLinkStatus = null;
	
	public PPBlueLineNetworkInfoModel(){}
	
	public String getWifiBLVersion()
	{
		return strPcmwifiBLVersion;
	}

	public void setWifiBLVersion(String sPcmwifiBLVersion)
	{
		this.strPcmwifiBLVersion = sPcmwifiBLVersion;
	}
	
	public String getPcmwifiAppVersion()
	{
		return strPcmwifiBLVersion;
	}

	public void setPcmwifiAppVersion(String sPcmwifiAppVersion)
	{
		this.strPcmwifiAppVersion = sPcmwifiAppVersion;
	}
	
	public String getPcmwifiMACAddress()
	{
		return strPcmwifiMACAddress;
	}

	public void setPcmwifiMACAddress(String sPcmwifiMACAddress)
	{
		this.strPcmwifiMACAddress = sPcmwifiMACAddress;
	}
	
	
	public String getPcmwifiIpAddress()
	{
		return strPcmwifiIpAddress;
	}

	public void setPcmwifiIpAddress(String sIpAddress)
	{
		this.strPcmwifiIpAddress = sIpAddress;
	}
	
	public String getPcmwifiTime()
	{
		return strPcmwifiTime;
	}

	public void setPcmwifiTime(String sTime)
	{
		this.strPcmwifiTime = sTime;
	}
	
	
	public String getSensorKhTimes10()
	{
		return strSensorKhTimes10;
	}

	public void setSensorKhTimes10(String sSensorKhTimes10)
	{
		this.strSensorKhTimes10 = sSensorKhTimes10;
	}
	
	public String getSensorAddress()
	{
		return strSensorAddress;
	}

	public void setSensorAddress(String sSensorAddress)
	{
		this.strSensorAddress = sSensorAddress;
	}
	
	public String getHostTarget()
	{
		return strHostTarget;
	}

	public void setHostTarget(String sHostTarget)
	{
		this.strHostTarget = sHostTarget;
	}
	
	public String getHostUploadPath()
	{
		return strHostUploadPath;
	}

	public void setHostUploadPath(String sHostUploadPath)
	{
		this.strHostUploadPath = sHostUploadPath;
	}
	
	public String getHostUploadPort()
	{
		return strHostUploadPort;
	}

	public void setHostUploadPort(String sHostUploadPort)
	{
		this.strHostUploadPort = sHostUploadPort;
	}
	
	public String getHostUseSSL()
	{
		return strHostUseSSL;
	}

	public void setHostUseSSL(String sHostUseSSL)
	{
		this.strHostUseSSL = sHostUseSSL;
	}
	
	public String getHostLinkStatus()
	{
		return strHostLinkStatus;
	}

	public void setHostLinkStatus(String sHostLinkStatus)
	{
		this.strHostLinkStatus = sHostLinkStatus;
	}

}
