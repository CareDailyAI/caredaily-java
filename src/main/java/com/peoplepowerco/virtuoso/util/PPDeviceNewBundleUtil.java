package com.peoplepowerco.virtuoso.util;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.managers.PPStorybookManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel;
import com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle;
import com.peoplepowerco.virtuoso.models.storybook.LookupParam;
import com.peoplepowerco.virtuoso.models.storybook.Model;
import io.realm.Realm;
import io.realm.RealmResults;
import java.util.List;

public class PPDeviceNewBundleUtil {

    public static void checkDeviceBundleStoryInfo(List<PPDeviceInfoModel> deviceList) {
        PPAppCenter.m_SharedPresence.setKeyBooleanValue("DeviceListEmpty", null == deviceList || deviceList.isEmpty());
        PPStorybookManager storybookManager = PPStorybookManager.getInstance();
        Realm realm = Realm.getDefaultInstance();
        RealmResults<DeviceBundle> bundles = DeviceBundle.findAllBundles(realm);
        if (bundles.isEmpty()) {
            return;
        }
        for (DeviceBundle bundle : bundles) {
            boolean notEnoughDevice = false;
            int pageIndex = 0;
            int ingorePageIndex = -1;
            for (BundleModel subModel : bundle.models) {
                int requiredCount = subModel.count;
                int ownedDeviceCount = findOwnedDeviceCount(storybookManager, subModel.modelIds, deviceList);
                subModel.setOwnedCount(realm, ownedDeviceCount);

                if (!subModel.indexes.isEmpty()) {
                    if (ownedDeviceCount < subModel.indexes.size()) {
                        if (ingorePageIndex != -1 && ownedDeviceCount == 0) {
                            pageIndex = ingorePageIndex;
                        } else {
                            pageIndex = subModel.indexes.get(ownedDeviceCount);
                        }
                        notEnoughDevice = true;
                        break;
                    } else {
                        ingorePageIndex = -1;
                        pageIndex = subModel.indexes.get(subModel.indexes.size() - 1) + 1;
                    }
                } else {
                    if (requiredCount == 0 && ownedDeviceCount == 0) {
                        ingorePageIndex = pageIndex;
                    } else {
                        pageIndex += ownedDeviceCount < requiredCount ? ownedDeviceCount : requiredCount;
                    }
                }
            }
            for (BundleModel subModel : bundle.models) {
                if (subModel.ownedCount > 0) {
                    continue;
                }

                int ownedDeviceCount = findOwnedDeviceCount(storybookManager, subModel.modelIds, deviceList);
                subModel.setOwnedCount(realm, ownedDeviceCount);
            }
            boolean hasEnoughAccessories = true;
//            if (null != bundle.accessories && !bundle.accessories.isEmpty()) {
//                int modelStatusCount = 0;
//                for (String modelId : bundle.accessories) {
//                    if (PPAppCenter.m_SharedPresence.getKeyIntValue(modelId) == 1) {
//                        ++modelStatusCount;
//                    }
//                }
//                deviceBundle.accessModel.setOwnedCount(modelStatusCount);
//                for (String modelId : bundle.accessories) {
//                    if (PPAppCenter.m_SharedPresence.getKeyIntValue(modelId) == 1 && !notEnoughDevice) {
//                        ++pageIndex;
//                    } else {
//                        break;
//                    }
//                }
//                hasEnoughAccessories = bundle.accessories.size() == modelStatusCount;
//            }
            bundle.setHasEnoughDevice(realm, !notEnoughDevice && hasEnoughAccessories);
            bundle.updatePageIndex(realm, pageIndex);

            if (bundle.isLastBundlePage()) {
                PPAppCenter.m_SharedPresence.setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS, 1);
            }
        }
    }

    private static int findOwnedDeviceCount(PPStorybookManager storybookManager, List<String> altIds, List<PPDeviceInfoModel> deviceList) {
        int ownedDeviceCount = 0;
        if (altIds.isEmpty()) {
            return 0;
        }

        for (String altId : altIds) {
            Model deviceModel = storybookManager.getModelByModelId(altId);
            if (null == deviceModel) {
                ownedDeviceCount = getDeviceCount(altId.toLowerCase(), deviceList);
            } else {
                List<LookupParam> lookupParams = deviceModel.getLookupParams();
                for (LookupParam param : lookupParams) {
                    int deviceType = param.getDeviceType();
                    ownedDeviceCount = getDeviceCount(deviceType, deviceList);
                    if (ownedDeviceCount > 0) {
                        break;
                    }
                }
            }
            if (ownedDeviceCount != 0) {
                break;
            }
        }
        return ownedDeviceCount;
    }

    private static int getDeviceCount(int deviceType, List<PPDeviceInfoModel> deviceList) {
        if (deviceType == PPCommonInfo.PPInvalidValue) {
            return 0;
        }
        int deviceCount = 0;
        for (PPDeviceInfoModel device : deviceList) {
            if (device != null && !device.bSeparator && device.type == deviceType) {
                deviceCount++;
            }
        }
        return deviceCount;
    }

    private static int getDeviceCount(String modelId, List<PPDeviceInfoModel> deviceList) {
        int deviceCount = 0;
        for (PPDeviceInfoModel device : deviceList) {
            if (device != null && !device.bSeparator && null != device.modelId && device.modelId.toLowerCase().equals(modelId)) {
                deviceCount++;
            }
        }
        return deviceCount;
    }
}
