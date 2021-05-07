package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPCommonInfo;

/**
 * Created by edwardliu on 2018/11/30.
 */

public class ParserHelper {

    public static int getIntValue(JSONObject object, String key) {
        if (object.containsKey(key)) {
            return object.getIntValue(key);
        } else {
            return PPCommonInfo.PPInvalidValue;
        }
    }

    public static String getStringValue(JSONObject object, String key) {
        if (object.containsKey(key)) {
            return object.getString(key);
        } else {
            return null;
        }
    }

    public static long getLongValue(JSONObject object, String key) {
        if (object.containsKey(key)) {
            return object.getLongValue(key);
        } else {
            return PPCommonInfo.PPInvalidValue;
        }
    }

    public static boolean getBooleanValue(JSONObject object, String key) {
        if (object.containsKey(key)) {
            return object.getBooleanValue(key);
        } else {
            return false;
        }
    }
}
