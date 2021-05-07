package io.realm;


public interface com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxyInterface {
    public String realmGet$storyId();
    public void realmSet$storyId(String value);
    public String realmGet$id();
    public void realmSet$id(String value);
    public String realmGet$title();
    public void realmSet$title(String value);
    public String realmGet$desc();
    public void realmSet$desc(String value);
    public int realmGet$bundlePageIndex();
    public void realmSet$bundlePageIndex(int value);
    public int realmGet$bundlePageSize();
    public void realmSet$bundlePageSize(int value);
    public boolean realmGet$hasEnoughDevice();
    public void realmSet$hasEnoughDevice(boolean value);
    public RealmList<Integer> realmGet$iconIndexes();
    public void realmSet$iconIndexes(RealmList<Integer> value);
    public RealmList<String> realmGet$accessories();
    public void realmSet$accessories(RealmList<String> value);
    public RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> realmGet$models();
    public void realmSet$models(RealmList<com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel> value);
}
