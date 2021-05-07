/**
 * @FileName  : PPStreamingInfo.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief :
 * @date : 2014. 06. 17.
 * @author Bhargav Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPStreamingInfo {
	public String sSessionId;
	public String sVideoServer;
	public String sWebsocketServer;
	public String sWebsocketPort;
    public String sVideoPort = "1935";
	public boolean bWebsocketServerSsl;
	public boolean bVideoServerSsl;
}
