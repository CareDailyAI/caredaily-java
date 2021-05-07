package com.peoplepowerco.virtuoso.models.storybook;

import androidx.annotation.Nullable;
import com.google.zxing.qrcode.decoder.Mode;
import java.util.List;

public class Model {

    private String id;
    private String icon;
    private Name name;
    private Manufacturer manufacturer;
    private Integer pairingType;
    private Integer oauthAppId;
    private Boolean hidden;
    private Integer sortId;
    private List<Medium> media = null;
    private List<LookupParam> lookupParams = null;
    private Desc desc;
    private String brand;
    private List<Integer> dependencyDeviceTypes;
    private DisplayInfo displayInfo;
    private int count;
    private int ownedCount;
    private boolean compressed;
    private List<Integer> indexes = null;
    private List<String> altIds = null;

    private int bundlePageIndex = 0;
    private int bundlePageSize = 0;
    private boolean hasEnoughDevice = false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPairingType() {
        return pairingType;
    }

    public void setPairingType(Integer pairingType) {
        this.pairingType = pairingType;
    }

    public Integer getOauthAppId() {
        return oauthAppId;
    }

    public void setOauthAppId(Integer oauthAppId) {
        this.oauthAppId = oauthAppId;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public List<LookupParam> getLookupParams() {
        return lookupParams;
    }

    public void setLookupParams(List<LookupParam> lookupParams) {
        this.lookupParams = lookupParams;
    }

    public Desc getDesc() {
        return desc;
    }

    public void setDesc(Desc desc) {
        this.desc = desc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public List<Integer> getDependencyDeviceTypes() {
        return dependencyDeviceTypes;
    }

    public void setDependencyDeviceTypes(List<Integer> dependencyDeviceTypes) {
        this.dependencyDeviceTypes = dependencyDeviceTypes;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    public void setDisplayInfo(DisplayInfo displayInfo) {
        this.displayInfo = displayInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOwnedCount() {
        return ownedCount;
    }

    public void setOwnedCount(int ownedCount) {
        this.ownedCount = ownedCount;
    }

    public boolean isCompressed() {
        return compressed;
    }

    public void setCompressed(boolean compressed) {
        this.compressed = compressed;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Integer> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
    }

    public int getBundlePageIndex() {
        return bundlePageIndex;
    }

    public boolean isLastBundlePage() {
        return bundlePageIndex == bundlePageSize - 1;
    }

    public void setBundlePageIndex(int bundlePageIndex) {
        this.bundlePageIndex = bundlePageIndex;
        if (bundlePageSize > 0 && bundlePageIndex > bundlePageSize - 1) {
            this.bundlePageIndex = bundlePageSize - 1;
        }
    }

    public void setBundleHasEnoughDevice(boolean hasEnoughDevice) {
        this.hasEnoughDevice = hasEnoughDevice;
    }

    public boolean bundleHasEnoughDevice() {
        return hasEnoughDevice;
    }

    public void increaseBundleIndex() {
        if (bundlePageIndex < bundlePageSize - 1) {
            bundlePageIndex += 1;
        }
    }

    public int getBundlePageSize() {
        return bundlePageSize;
    }

    public void setBundlePageSize(int bundlePageSize) {
        this.bundlePageSize = bundlePageSize;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Mode)) {
            return false;
        }
        Model other = (Model) obj;
        return id.equals(other.getId());
    }

    public List<String> getAltIds() {
        return altIds;
    }

    public void setAltIds(List<String> altIds) {
        this.altIds = altIds;
    }
}