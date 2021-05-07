package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPPostFileModel extends RealmObject {

    @PrimaryKey
    public String fileId;
    public int type;
    public String contentType;
    public String ext;
    public long duration;
    public int rotate;
    public long size;
    public boolean thumbnail;
    public boolean m3u8;
    public String contentUrl;
    public String thumbnailUrl;
    public String m3u8Url;

    public PPPostFileModel copy() {
        PPPostFileModel fileModel = new PPPostFileModel();
        fileModel.fileId = fileId;
        fileModel.type = type;
        fileModel.contentType = contentType;
        fileModel.contentUrl = contentUrl;
        fileModel.ext = ext;
        fileModel.duration = duration;
        fileModel.rotate = rotate;
        fileModel.size = size;
        fileModel.thumbnail = thumbnail;
        fileModel.m3u8 = m3u8;
        return fileModel;
    }
}
