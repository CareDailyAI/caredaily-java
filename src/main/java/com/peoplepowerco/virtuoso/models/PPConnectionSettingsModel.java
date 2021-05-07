/**
 * @FileName  : PPConnectionSettingsModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.List;

/**
 * @author James Cho 
 * Connection setting model
 */
public class PPConnectionSettingsModel {
	public String sName = null;
	public String sVersion = null;
	public List<PPServerInformationModel> serverInfoList;

	public String getName()
	{
		return sName;
	}

	public void setName(String strName)
	{
		this.sName = strName;
	}

	public String getVersion() {
		return sVersion;
	}

	public void setVersion(String sVersion) {
		this.sVersion = sVersion;
	}

	public List<PPServerInformationModel> getServerInformation() {
		return serverInfoList;
	}
	public void setServerInformation(
			List<PPServerInformationModel> lstServerInformation) {
		this.serverInfoList = lstServerInformation;
	}
}
