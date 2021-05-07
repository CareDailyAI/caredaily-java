/**
 * @FileName  : PPStreamingInfoJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPStreamingInfo;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * @brief :
 * @date : 2014. 06. 17.
 * @author : Bhargav Panchal Copyright (c) 2014 People Power. All rights
 *         reserved.
 */
public class PPStreamingInfoJsonParser implements PPBaseJsonParser {

	@Override
	public boolean setData(JSONObject jso, Object[] obj) {
		// TODO Auto-generated method stub
		try {
			PPStreamingInfo streamingInfo = (PPStreamingInfo) obj[0];

			streamingInfo.sVideoServer = (jso.containsKey("videoServer")) ? jso.getString("videoServer") : null;
			streamingInfo.bVideoServerSsl = (jso.containsKey("videoServerSsl")) ? jso.getBoolean("videoServerSsl") : false;
			streamingInfo.sSessionId = (jso.containsKey("sessionId")) ? jso.getString("sessionId") : null;

			//NOTE: This was a temporary testing fix.
//			if(streamingInfo.sVideoServer.contains("streamtest.")) {
//				streamingInfo.sVideoServer = streamingInfo.sVideoServer.replace("stream.", "stream.");
//			}

			PPVirtuosoLogTrace.d("PPStreamingInfoJsonParser", "VideoServer = %s, port = %s, isSSL: %s", streamingInfo.sVideoServer, streamingInfo.sVideoPort, streamingInfo.bVideoServerSsl);
			PPVirtuosoLogTrace.d("PPStreamingInfoJsonParser", "SessionId =" + streamingInfo.sSessionId);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} catch (OutOfMemoryError ex) {
			Runtime.getRuntime().gc();
		}

		return false;
	}

}
