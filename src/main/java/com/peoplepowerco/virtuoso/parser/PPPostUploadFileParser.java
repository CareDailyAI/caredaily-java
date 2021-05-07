package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.bean.FAPostUploadFile;
import java.util.HashMap;

public class PPPostUploadFileParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        FAPostUploadFile postFile = (FAPostUploadFile) obj[0];
        postFile.fileId = jso.getString("fileId");
        postFile.contentUrl = jso.getString("contentUrl");
        if (jso.containsKey("uploadHeaders")) {
            postFile.uploadHeaders = new HashMap<>();
            JSONObject headObj = jso.getJSONObject("uploadHeaders");
            for (String key : headObj.keySet()) {
                postFile.uploadHeaders.put(key, headObj.getString(key));
            }
        }
        return true;
    }
}
