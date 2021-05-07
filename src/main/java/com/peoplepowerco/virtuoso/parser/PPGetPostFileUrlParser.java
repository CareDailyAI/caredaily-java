package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.communities.PPPostFileModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostModel;
import io.realm.Realm;

public class PPGetPostFileUrlParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        boolean result = false;
        String postId = (String) obj[0];
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        PPPostModel model = PPPostModel.findById(realm, postId);
        if (jso.containsKey("files")) {
            JSONArray array = jso.getJSONArray("files");
            for (int i = 0; i != array.size(); ++i) {
                JSONObject fileObj = array.getJSONObject(i);
                String fileId = fileObj.getString("id");
                for (int j = 0; j != model.files.size(); ++j) {
                    PPPostFileModel fileModel = model.files.get(j);
                    if (fileModel.fileId.equals(fileId)) {
                        fileModel.contentUrl = fileObj.getString("contentUrl");
                        fileModel.thumbnailUrl = fileObj.getString("thumbnailUrl");
                    }
                }
            }
            result = true;
        }
        realm.commitTransaction();
        realm.close();
        return result;
    }
}
