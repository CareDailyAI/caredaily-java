/**
 * @FileName  : PPDeviceRegistrationInfoModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief : Device Register Info Model
 * @date : Sep 8,2014
 * @author : Vaibhav Parikh
 */

public class PPDeviceRegistrationInfoModel {
	public String sAuthToken = null;
	public String sHost = null;
	public String sUri = null;
	public String sPort = null;
	public boolean bExist = false;
	// Server is returning data in String
	public String sUseSSL = null;
}
