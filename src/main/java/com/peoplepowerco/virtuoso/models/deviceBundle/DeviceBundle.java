package com.peoplepowerco.virtuoso.models.deviceBundle;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.PrimaryKey;

public class DeviceBundle extends RealmObject {

    @PrimaryKey
    public String storyId;
    public String id;
    public String title;
    public String desc;

    public int bundlePageIndex = 0;
    public int bundlePageSize = 0;
    public boolean hasEnoughDevice = false;

    public RealmList<Integer> iconIndexes = new RealmList<>();
    public RealmList<String> accessories = new RealmList<>();
    public RealmList<BundleModel> models = new RealmList<>();

    public static RealmResults<DeviceBundle> findAllBundles(Realm realm) {
        return realm.where(DeviceBundle.class).sort("title", Sort.DESCENDING).findAll();
    }

    public static DeviceBundle getCurrentBundle(Realm realm) {
        DeviceBundle bundle = null;
        String bundleStoryId = PPAppCenter.m_SharedPresence.getKeyStringValue(PPCommonInfo.REFERENCE_KEY_CURRENT_BUNDLE);
        if (TextUtils.isEmpty(bundleStoryId)) {
            bundle = realm.where(DeviceBundle.class).findFirst();
        } else {
            bundle = realm.where(DeviceBundle.class).equalTo("storyId", bundleStoryId).findFirst();
        }
        if (null != bundle) {
            PPAppCenter.m_SharedPresence.setKeyStringValue(PPCommonInfo.REFERENCE_KEY_CURRENT_BUNDLE, bundle.storyId);
        }
        return bundle;
    }

    public static DeviceBundle findBundleById(Realm realm, String bundleId) {
        if (TextUtils.isEmpty(bundleId)) {
            return realm.where(DeviceBundle.class).findFirst();
        }
        return realm.where(DeviceBundle.class).equalTo("id", bundleId).findFirst();
    }

    public static void increasePageIndexForBundle(Realm realm, final String bundleId) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                DeviceBundle bundle = realm.where(DeviceBundle.class).equalTo("id", bundleId).findFirst();
                if (null != bundle) {
                    bundle.bundlePageIndex = bundle.bundlePageIndex + 1;
                }
            }
        });
    }

    public static void resetPageIndexForBundle(Realm realm, final String bundleId) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                DeviceBundle bundle = realm.where(DeviceBundle.class).equalTo("id", bundleId).findFirst();
                if (null != bundle) {
                    bundle.bundlePageIndex = 0;
                }
            }
        });
    }

    public void setHasEnoughDevice(Realm realm, final boolean enoughDevice) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                hasEnoughDevice = enoughDevice;
                PPAppCenter.m_SharedPresence.setKeyBooleanValue("bundle_finish", hasEnoughDevice);
            }
        });
    }

    public void updatePageIndex(Realm realm, final int pageIndex) {
        realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                bundlePageIndex = pageIndex;
            }
        });
    }


    public void increasePageIndex(Realm realm) {
        updatePageIndex(realm, bundlePageIndex + 1);
    }

    public boolean isLastBundlePage() {
        return bundlePageIndex == bundlePageSize - 1;
    }

}
