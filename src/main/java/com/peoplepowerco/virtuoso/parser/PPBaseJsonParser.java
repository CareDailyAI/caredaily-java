/**
 * @FileName  : PPBaseJsonParser.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;

/**
 * @brief : Base json parser
 * @date  : 2013. 8. 13.
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public interface PPBaseJsonParser {
	
	public boolean setData(JSONObject jso, Object[] obj);

}
