package com.peoplepowerco.virtuoso.util;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.managers.PPDeviceManager;
import com.peoplepowerco.virtuoso.managers.PPStorybookManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPProductsParametersModel;
import com.peoplepowerco.virtuoso.models.storybook.DeviceBundle;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoParameters;
import com.peoplepowerco.virtuoso.models.storybook.Model;
import java.util.ArrayList;
import java.util.List;

public class PPDeviceBundleUtil {

    public static void checkDeviceBundleStoryInfo(List<PPDeviceInfoModel> deviceList) {
        PPAppCenter.m_SharedPresence.setKeyBooleanValue("DeviceListEmpty", null == deviceList || deviceList.isEmpty());
        PPStorybookManager storybookManager = PPStorybookManager.getInstance();
        List<Model> models = storybookManager.getDeviceBundleModels();
        if (null == models) {
            return;
        }
        for (Model bundleModel : models) {
            boolean notEnoughDevice = false;
            if (null != bundleModel && null != bundleModel.getDisplayInfo()) {
                DeviceBundle deviceBundle = bundleModel.getDisplayInfo().getDeviceBundle();
                List<Model> subModels = deviceBundle.models;
                int pageIndex = 0;
                int ingorePageIndex = -1;
                if (null != subModels) {
                    for (Model subModel : subModels) {
                        int requiredCount = subModel.getCount();
                        Model deviceModel = storybookManager.getModelByModelId(subModel.getId());
                        int deviceType = PPCommonInfo.PPInvalidValue;
                        if (null != deviceModel && null != deviceModel.getLookupParams() && !deviceModel.getLookupParams().isEmpty()) {
                            deviceType = deviceModel.getLookupParams().get(0).getDeviceType();
                        }
                        int ownedDeviceCount = getDeviceCount(deviceType, deviceList);
                        if (ownedDeviceCount == 0) {
                            ownedDeviceCount = findOwnedDeviceCount(storybookManager, subModel.getAltIds(), deviceList);
                        }
                        subModel.setOwnedCount(ownedDeviceCount);

                        List<Integer> indexes = subModel.getIndexes();
                        if (indexes != null && !indexes.isEmpty()) {
                            if (ownedDeviceCount < indexes.size()) {
                                if (ingorePageIndex != -1 && ownedDeviceCount == 0) {
                                    pageIndex = ingorePageIndex;
                                } else {
                                    pageIndex = indexes.get(ownedDeviceCount);
                                }
                                notEnoughDevice = true;
                                break;
                            } else {
                                ingorePageIndex = -1;
                                pageIndex = indexes.get(indexes.size() - 1) + 1;
                            }
                        } else {
                            if (requiredCount == 0 && ownedDeviceCount == 0) {
                                ingorePageIndex = pageIndex;
                            } else {
                                pageIndex += ownedDeviceCount < requiredCount ? ownedDeviceCount : requiredCount;
                            }
                        }
                    }
                    for (Model subModel : subModels) {
                        if (subModel.getOwnedCount() > 0) {
                            continue;
                        }

                        Model deviceModel = storybookManager.getModelByModelId(subModel.getId());
                        int deviceType = PPCommonInfo.PPInvalidValue;
                        if (null != deviceModel && null != deviceModel.getLookupParams() && !deviceModel.getLookupParams().isEmpty()) {
                            deviceType = deviceModel.getLookupParams().get(0).getDeviceType();
                        }
                        int ownedDeviceCount = getDeviceCount(deviceType, deviceList);
                        if (ownedDeviceCount == 0) {
                            ownedDeviceCount = findOwnedDeviceCount(storybookManager, subModel.getAltIds(), deviceList);
                        }
                        subModel.setOwnedCount(ownedDeviceCount);
                    }
                }
                boolean hasEnoughAccessories = true;
                if (null != deviceBundle.accessories && !deviceBundle.accessories.isEmpty()) {
                    int modelStatusCount = 0;
                    for (String modelId : deviceBundle.accessories) {
                        if (PPAppCenter.m_SharedPresence.getKeyIntValue(modelId) == 1) {
                            ++modelStatusCount;
                        }
                    }
                    deviceBundle.accessModel.setOwnedCount(modelStatusCount);
                    for (String modelId : deviceBundle.accessories) {
                        if (PPAppCenter.m_SharedPresence.getKeyIntValue(modelId) == 1 && !notEnoughDevice) {
                            ++pageIndex;
                        } else {
                            break;
                        }
                    }
                    hasEnoughAccessories = deviceBundle.accessories.size() == modelStatusCount;
                }
                bundleModel.setBundleHasEnoughDevice(!notEnoughDevice && hasEnoughAccessories);
                bundleModel.setBundlePageIndex(pageIndex);

            } else {
                bundleModel.setBundlePageIndex(0);
            }

            if (bundleModel.isLastBundlePage()) {
                PPAppCenter.m_SharedPresence.setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS, 1);
            }
        }
    }

    private static int findOwnedDeviceCount(PPStorybookManager storybookManager, List<String> altIds, List<PPDeviceInfoModel> deviceList) {
        int ownedDeviceCount = 0;
        if (null == altIds || altIds.isEmpty()) {
            return 0;
        }

        for (String altId : altIds) {
            Model deviceModel = storybookManager.getModelByModelId(altId);
            if (null == deviceModel) {
                ownedDeviceCount = getDeviceCount(altId.toLowerCase(), deviceList);
            } else {
                int deviceType = deviceModel.getLookupParams().get(0).getDeviceType();
                ownedDeviceCount = getDeviceCount(deviceType, deviceList);
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

    public static boolean supportHistoryParams(String modelId) {
        PPDeviceManager deviceManager = PPDeviceManager.getInstance();
        List<String> paramList = new ArrayList<>();
        for (PPProductsParametersModel paramModel : deviceManager.getProductParameterList()) {
            if (paramModel != null && !TextUtils.isEmpty(paramModel.getName()) && paramModel.getHistorical() >= 1) {
                if (deviceManager.isParameter(paramModel.getName()) && isSupportedParameter(paramModel.getName(), modelId)
                    && !paramModel.getDisplayModel().isHidden()) {
                    paramList.add(paramModel.getName());
                }
            }
        }
        return !paramList.isEmpty();
    }

    public static List<String> generateDisplayedParams(int deviceType) {
        PPDeviceManager deviceManager = PPDeviceManager.getInstance();
        List<String> paramList = new ArrayList<>();
        for (PPProductsParametersModel paramModel : deviceManager.getProductParameterList()) {
            if (paramModel != null && !TextUtils.isEmpty(paramModel.getName())) {
                if ((deviceManager.isHistoricalParameter(paramModel.getName()) || deviceManager.isParameter(paramModel.getName()))
                    && isSupportedParameter(paramModel.getName(), deviceType)
                    && !paramModel.getDisplayModel().isHidden()) {
                    paramList.add(paramModel.getName());
                }
            }
        }
        if (paramList.contains(IPPDeviceParameters.RSSI)) {
            paramList.remove(IPPDeviceParameters.RSSI);
        }
        return paramList;
    }

    public static boolean isElectricalMeter(int deviceType) {
        PPDeviceManager deviceManager = PPDeviceManager.getInstance();
        List<String> paramList = new ArrayList<>();
        for (PPProductsParametersModel paramModel : deviceManager.getProductParameterList()) {
            if (paramModel != null && !TextUtils.isEmpty(paramModel.getName())) {
                PPParameterDisplayModel displayModel = deviceManager.getParameterDisplayModel(paramModel.getName());
                if (deviceManager.isParameter(paramModel.getName())
                    && isSupportedParameter(paramModel.getName(), deviceType)
                    && (displayModel != null && !displayModel.isHidden())) {
                    paramList.add(paramModel.getName());
                }
            }
        }
        return paramList.contains(IPPDeviceParameters.ENERGY) || paramList.contains(IPPDeviceParameters.POWER);
    }

    public static boolean isInternalTemperature(int deviceType) {
        PPDeviceManager deviceManager = PPDeviceManager.getInstance();
        List<String> paramList = new ArrayList<>();
        for (PPProductsParametersModel paramModel : deviceManager.getProductParameterList()) {
            if (paramModel != null && !TextUtils.isEmpty(paramModel.getName())) {
                PPParameterDisplayModel displayModel = deviceManager.getParameterDisplayModel(paramModel.getName());
                if (deviceManager.isParameter(paramModel.getName())
                    && isSupportedParameter(paramModel.getName(), deviceType)
                    && (displayModel != null && !displayModel.isHidden())) {
                    paramList.add(paramModel.getName());
                }
            }
        }
        return paramList.contains(IPPDeviceParameters.INTERNAL_DEG_C);
    }

    private static boolean isSupportedParameter(String name, int deviceType) {
        List<DisplayInfoParameters> displayParameters = PPStorybookManager.getInstance().getSupportedParametersByDeviceType(deviceType);
        if (!TextUtils.isEmpty(name)) {
            //Quote: https://presence.atlassian.net/browse/IOS-5457
            //If no model is available, or the model does not prescribe a list of parameters, then show all available parameters.
            if (null == displayParameters) {
                return true;
            }

            for (DisplayInfoParameters displayParam : displayParameters) {
                if (displayParam.getName() != null && name.equals(displayParam.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSupportedParameter(String name, String modelId) {
        List<DisplayInfoParameters> displayParameters = PPStorybookManager.getInstance().getSupportedParametersByModelId(modelId);
        if (!TextUtils.isEmpty(name)) {
            //Quote: https://presence.atlassian.net/browse/IOS-5457
            //If no model is available, or the model does not prescribe a list of parameters, then show all available parameters.
            if (null == displayParameters) {
                return true;
            }

            for (DisplayInfoParameters displayParam : displayParameters) {
                if (displayParam.getName() != null && name.equals(displayParam.getName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
