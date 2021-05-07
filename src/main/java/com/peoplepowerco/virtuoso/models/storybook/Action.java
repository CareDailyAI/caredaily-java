package com.peoplepowerco.virtuoso.models.storybook;

import com.peoplepowerco.virtuoso.PPCommonInfo;

import java.io.Serializable;

public class Action implements Serializable {

    private static final long serialVersionUID = 8476098628534035148L;
    private Integer index;
    private Integer type = PPCommonInfo.ACTION_TYPE_LINK_NONE;
    private Integer style = 0;
    private String storyId;
    private String desc;
    private String url;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStyle() {
        return style;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStoryId() {
        return storyId;
    }

    public void setStoryId(String storyId) {
        this.storyId = storyId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
