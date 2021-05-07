package com.peoplepowerco.virtuoso.models.storybook;

import com.peoplepowerco.virtuoso.PPCommonInfo;
import java.util.List;

public class Story {

    private String id;
    private List<Model> models = null;
    private Integer storyType;
    private String lang;
    private String title;
    private String search;
    private List<Page> pages = null;
    private Integer pairingType;
    private int deviceType = PPCommonInfo.PPInvalidValue;
    private int oauthAppId;
    private String generatedCode;
    private String deviceName;
    private int pageIndex = 0;
    private int prePageIndex = -1;
    private String modelId;
    private List<Integer> deviceTypes;
    private List<String> publishedOSVersion;
    private DisplayInfo displayInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Integer getStoryType() {
        return storyType;
    }

    public void setStoryType(Integer storyType) {
        this.storyType = storyType;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Integer getPairingType() {
        return pairingType;
    }

    public void setPairingType(Integer pairingType) {
        this.pairingType = pairingType;
    }

    public int getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(int deviceType) {
        this.deviceType = deviceType;
    }

    public void setDeviceTypes(List<Integer> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public List<Integer> getDeviceTypes() {
        return deviceTypes;
    }

    public String getGeneratedCode() {
        return generatedCode;
    }

    public void setGeneratedCode(String generatedCode) {
        this.generatedCode = generatedCode;
    }

    public int getOauthAppId() {
        return oauthAppId;
    }

    public void setOauthAppId(int oauthAppId) {
        this.oauthAppId = oauthAppId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public int getPrePageIndex() {
        return prePageIndex;
    }

    public void setPrePageIndex(int prePageIndex) {
        this.prePageIndex = prePageIndex;
    }

    public List<String> getPublishedOSVersion() {
        return publishedOSVersion;
    }

    public void setPublishedOSVersion(List<String> publishedOSVersion) {
        this.publishedOSVersion = publishedOSVersion;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }
}
