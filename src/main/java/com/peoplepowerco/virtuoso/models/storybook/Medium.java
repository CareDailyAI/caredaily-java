package com.peoplepowerco.virtuoso.models.storybook;

import java.io.Serializable;

public class Medium implements Serializable {

    private static final long serialVersionUID = 260531311700832565L;
    private String id;
    private Integer mediaType;
    private String url;
    private String contentType;
    private Desc desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMediaType() {
        return mediaType;
    }

    public void setMediaType(Integer mediaType) {
        this.mediaType = mediaType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

}