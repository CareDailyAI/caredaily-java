/**
 * @FileName  : PPDeviceActivateModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief : Device activate model
 * @date  : 2014. 5. 4.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPDeviceActivateModel {
	private String sActivationKey = null;
	private String sActivationURL = null;
	private String sMessage = null;
	private String sHost = null;
	private String sPort = null;
	private String sURL = null;
	private String sSSL = null;
	public String sDownloadURL;

	public String getActivationKey() {
		return sActivationKey;
	}

	public void setActivationKey(String sActivationKey) {
		this.sActivationKey = sActivationKey;
	}

	public String getActivationURL() {
		return sActivationURL;
	}

	public void setActivationURL(String sActivationURL) {
		this.sActivationURL = sActivationURL;
	}

	public String getMessage() {
		return sMessage;
	}

	public void setMessage(String sMessage) {
		this.sMessage = sMessage;
	}

	public String getHost() {
		return sHost;
	}

	public void setHost(String sHost) {
		this.sHost = sHost;
	}

	public String getPort() {
		return sPort;
	}

	public void setPort(String sPort) {
		this.sPort = sPort;
	}

	public String getURL() {
		return sURL;
	}

	public void setURL(String sURL) {
		this.sURL = sURL;
	}

	public String getSSL() {
		return sSSL;
	}

	public void setSSL(String sSSL) {
		this.sSSL = sSSL;
	}
}
