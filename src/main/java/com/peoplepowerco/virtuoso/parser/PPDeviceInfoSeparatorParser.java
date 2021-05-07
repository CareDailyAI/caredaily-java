/**
 * @FileName : PPDeviceInfoSeparatorParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import static com.peoplepowerco.virtuoso.PPCommonInfo.INT_CENTRALITE_SMART_PLUG;
import static com.peoplepowerco.virtuoso.PPCommonInfo.INT_GE_LIGHT_BULB;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.bean.CRSwitchDevice;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.managers.PPDeviceManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPDevicePropertyModel;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceParameterModel;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import com.peoplepowerco.virtuoso.util.PPDeviceBundleUtil;
import com.peoplepowerco.virtuoso.util.PPDeviceNewBundleUtil;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPUtil;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author : Justin Tan Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Device information separator
 * @date : 2016. 6. 15.
 */
public class PPDeviceInfoSeparatorParser implements PPBaseJsonParser, IPPDeviceParameters {

    List<PPDeviceInfoModel> mDeviceList;
    PPSharedPreferences mPrefs = PPVirtuoso.getInstance().getPrefs();

    @SuppressWarnings("unchecked")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        mDeviceList = (List<PPDeviceInfoModel>) obj[0];
        if (mDeviceList != null) {
            mDeviceList.clear();
        }
        if (jso.containsKey("devices")) {
            final List<PPDevicePropertyModel> outletProperties = new ArrayList<>();
            List<PPDeviceInfoModel> cameras = new ArrayList<>();
            List<PPDeviceInfoModel> controllableDevices = new ArrayList<>();
            List<PPDeviceInfoModel> gateways = new ArrayList<>();
            List<PPDeviceInfoModel> otherDevices = new ArrayList<>();

            try {
                parseDeviceList(jso, outletProperties, cameras, controllableDevices, gateways, otherDevices);
                PPDeviceNameAlphabetical sort = new PPDeviceNameAlphabetical();
                if (!controllableDevices.isEmpty()) {
                    Collections.sort(controllableDevices, sort);
                    PPDeviceInfoModel headInfo = new PPDeviceInfoModel();
                    headInfo.bSeparator = true;
                    headInfo.itemType = PPDeviceInfoModel.TYPE_SECTION;
                    headInfo.sListTitle = "CONTROLLABLE DEVICES";
                    mDeviceList.add(headInfo);
                    mDeviceList.addAll(controllableDevices);
                }
                if (!cameras.isEmpty()) {
                    Collections.sort(cameras, sort);
                    PPDeviceInfoModel headInfo = new PPDeviceInfoModel();
                    headInfo.bSeparator = true;
                    headInfo.itemType = PPDeviceInfoModel.TYPE_SECTION;
                    headInfo.sListTitle = "CAMERAS";
                    mDeviceList.add(headInfo);
                    mDeviceList.addAll(cameras);
                }
                if (!otherDevices.isEmpty()) {
                    Collections.sort(otherDevices, sort);
                    PPDeviceInfoModel headInfo = new PPDeviceInfoModel();
                    headInfo.bSeparator = true;
                    headInfo.itemType = PPDeviceInfoModel.TYPE_SECTION;
                    headInfo.sListTitle = "OTHER DEVICES";
                    mDeviceList.add(headInfo);
                    mDeviceList.addAll(otherDevices);
                }
                if (!gateways.isEmpty()) {
                    Collections.sort(gateways, sort);
                    PPDeviceInfoModel headInfo = new PPDeviceInfoModel();
                    headInfo.bSeparator = true;
                    headInfo.itemType = PPDeviceInfoModel.TYPE_SECTION;
                    headInfo.sListTitle = "";
                    mDeviceList.add(headInfo);
                    mDeviceList.addAll(gateways);
                }

                Realm.getDefaultInstance().executeTransaction(new Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        if (outletProperties.isEmpty()) {
                            realm.delete(CRSwitchDevice.class);
                            return;
                        }

                        String[] outletDeviceIds = new String[outletProperties.size()];
                        long currentTimeMs = System.currentTimeMillis();
                        for (int i = 0; i != outletProperties.size(); ++i) {
                            PPDevicePropertyModel outletProperty = outletProperties.get(i);
                            outletDeviceIds[i] = outletProperty.strIndex;
                            CRSwitchDevice switchDevice = CRSwitchDevice.findItemById(realm, outletProperty.strIndex);
                            if (null == switchDevice) {
                                switchDevice = realm.createObject(CRSwitchDevice.class, outletProperty.strIndex);
                            }
                            switchDevice.paramName = outletProperty.strName;
                            if (currentTimeMs - switchDevice.updateTimeMs > 70000) {
                                switchDevice.updateTimeMs = currentTimeMs;
                                switchDevice.isChecked = outletProperty.strContent.equals("1") || outletProperty.strContent.equals("ON");
                            }
                        }
                        realm.where(CRSwitchDevice.class)
                            .beginGroup()
                            .not().in("deviceId", outletDeviceIds)
                            .endGroup()
                            .findAll().deleteAllFromRealm();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError ex) {
                Runtime.getRuntime().gc();
            }
        }
        if (PPAppCenter.BUNDLE_VERSION == 1) {
            PPDeviceBundleUtil.checkDeviceBundleStoryInfo(mDeviceList);
        } else {
            PPDeviceNewBundleUtil.checkDeviceBundleStoryInfo(mDeviceList);
        }
        return true;
    }

    private void parseDeviceList(JSONObject jso, List<PPDevicePropertyModel> outletProperties,
        List<PPDeviceInfoModel> cameras, List<PPDeviceInfoModel> controllableDevices,
        List<PPDeviceInfoModel> gateways, List<PPDeviceInfoModel> otherDevices) {
        PPDeviceInfoModel localCameraDevice = null;
        JSONArray devicesArray = jso.getJSONArray("devices");
        for (int i = 0; i != devicesArray.size(); ++i) {
            JSONObject deviceObj = devicesArray.getJSONObject(i);
            int deviceType = deviceObj.getIntValue("type");
            if (deviceType == PPCommonInfo.INT_PRESENCE_CAMARA
                || deviceType == PPCommonInfo.INT_PRESENCE_DEVICES) {
                continue;
            }

            PPDeviceInfoModel device = new PPDeviceInfoModel();
            device.id = deviceObj.getString("id");
            device.proxyId = deviceObj.getString("proxyId");
            device.type = deviceType;
            device.typeCategory = deviceObj.getIntValue("typeCategory");
            device.goalId = deviceObj.getIntValue("goalId");
            device.locationId = deviceObj.getIntValue("locationId");
            device.modelId = deviceObj.getString("modelId");
            device.desc = deviceObj.getString("desc");
            if (device.newDevice) {
                String defaultName = getLocalizedDeviceName(device.type);
                if (!PPUtil.isEmpty(defaultName) && TextUtils.isEmpty(device.desc)) {
                    device.desc = defaultName;
                }
            }

            device.connected = deviceObj.getBooleanValue("connected");
            device.newDevice = deviceObj.getBooleanValue("newDevice");
            device.shared = deviceObj.getBooleanValue("shared");
            device.lastDataReceivedDate = deviceObj.getString("lastDataReceivedDate");
            device.lastDataReceivedDateMs = deviceObj.getLongValue("lastDataReceivedDateMs");
            device.lastConnectedDate = deviceObj.getString("lastConnectedDate");
            device.lastConnectedDateMs = deviceObj.getLongValue("lastConnectedDateMs");
            device.lastMeasureDate = deviceObj.getString("lastMeasureDate");
            device.lastMeasureDateMs = deviceObj.getLongValue("lastMeasureDateMs");
            if (TextUtils.isEmpty(device.lastMeasureDate)) {
                long defaultDateTime = PPVirtuoso.getInstance().getPrefs().getDefaultDateTimes();
                if (0 == defaultDateTime) {
                    long currentTimeMillis = System.currentTimeMillis();
                    device.lastMeasureDateMs = currentTimeMillis;
                    PPVirtuoso.getInstance().getPrefs().setDefaultDateTimes(currentTimeMillis);
                } else {
                    device.lastMeasureDateMs = defaultDateTime;
                }
            }

            if (deviceObj.containsKey("spaces")) {
                device.spaces = new ArrayList<>();
                JSONArray spaceArray = deviceObj.getJSONArray("spaces");
                for (int j = 0; j != spaceArray.size(); ++j) {
                    JSONObject spaceObj = spaceArray.getJSONObject(j);
                    PPLocationSpaceModel space = new PPLocationSpaceModel();
                    space.setId(spaceObj.getIntValue("id"));
                    space.setType(spaceObj.getIntValue("type"));
                    space.setName(spaceObj.getString("name"));
                    device.spaces.add(space);
                }
            }
            String deviceListParameters = null;
            if (deviceObj.containsKey("typeAttributes")) {
                JSONArray typeArray = deviceObj.getJSONArray("typeAttributes");
                for (int j = 0; j != typeArray.size(); ++j) {
                    JSONObject typeObj = typeArray.getJSONObject(j);
                    String name = typeObj.getString("name");
                    String value = typeObj.getString("value");
                    if (name.equals("deviceListIcon")) {
                        device.sDeviceListIcon = value;
                    } else if (name.equals("deviceListParameters")) {
                        deviceListParameters = value;
                    }
                }
            }
            if (TextUtils.isEmpty(device.sDeviceListIcon)) {
                device.icon = deviceObj.getString("icon");
            }

            List<PPDeviceParameterModel> parameters = new ArrayList<>();
            if (deviceObj.containsKey("parameters")) {
                JSONArray paramArray = deviceObj.getJSONArray("parameters");
                for (int j = 0; j != paramArray.size(); ++j) {
                    PPDeviceParameterModel parameter = new PPDeviceParameterModel();
                    JSONObject paramObj = paramArray.getJSONObject(j);
                    parameter.setName(paramObj.getString("name"));
                    parameter.setValue(paramObj.getString("value"));
                    if (parameter.getName().equals(OUTLET_STATUS) ||
                        (device.type == INT_GE_LIGHT_BULB && parameter.getName().equals(STATE))) {
                        outletProperties.add(new PPDevicePropertyModel(device.id,
                            parameter.getName(), parameter.getValue()));
                    }
                    parameters.add(parameter);
                }
                device.addDeviceParameters(parameters);
            }
            if (parameters.isEmpty()) {
                if (device.type == INT_CENTRALITE_SMART_PLUG) {
                    outletProperties.add(new PPDevicePropertyModel(device.id,
                        OUTLET_STATUS, "1"));
                } else if (device.type == INT_GE_LIGHT_BULB) {
                    outletProperties.add(new PPDevicePropertyModel(device.id,
                        STATE, "1"));
                }
            }

            // is local camera or not
            String localDeviceId = mPrefs.getUuidForUserId(mPrefs.getUserId());
            if ((device.type == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA)
                && device.id.equals(localDeviceId)) {
                localCameraDevice = device;
                device.bLocalCamera = true;
                PPDeviceManager.localCamera = device;
                PPDeviceManager.isLocalCameraRemoved = false;
                PPAppCenter.m_SharedPresence.setCameraName(device.desc);
                continue;
            }

            //take care of TED
            if (device.type == PPCommonInfo.INT_TED_GATEWAY) {
                mPrefs.setGatewayDeviceId(device.id);
                continue;
            }

            if (device.type == PPCommonInfo.INT_GREEN_GATEWAY
                || device.type == PPCommonInfo.INT_X5_GATEWAY
                || device.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221
                || device.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                || device.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
                || device.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211) {
                gateways.add(device);
                continue;
            }
            if (device.type == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA
                || device.type == PPCommonInfo.INT_PRESENCE_IOS_CAMERA) {
                if (device.connected && deviceListParameters.contains(ACCESS_CAMERA_SETTINGS)
                    && null != device.getDeviceParameters()
                    && !device.getDeviceParameters().isEmpty()) {
                    cameras.add(device);
                }
                continue;
            }
            if ((device.typeCategory > PPCommonInfo.PPDeviceTypeCategoryBlockLightingStart - 1000
                && device.typeCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockLightingStart)
                || (device.typeCategory > PPCommonInfo.PPDeviceTypeCategoryBlockLightingStart && device.typeCategory <= 12000)
                || (device.typeCategory > 22000 && device.typeCategory <= 23000)
                || device.typeCategory == PPCommonInfo.PPDeviceTypeCategorySmartPlug
                || device.typeCategory == PPCommonInfo.PPDeviceTypeCategoryThermostat
                || (device.typeCategory > PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls - 1000) && (
                device.typeCategory < PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls)) {
                controllableDevices.add(device);
                continue;
            }
            if (device.type == PPCommonInfo.INT_IN_WALL_SWITCH
                || device.type == PPCommonInfo.INT_CENTRALITE_SMART_PLUG
                || device.type == PPCommonInfo.INT_WIFI_SMART_PLUG
                || device.type == PPCommonInfo.INT_DOOR_LOCK
                || device.type == INT_GE_LIGHT_BULB
                || device.type == PPCommonInfo.INT_ALFAPRO_IP_CAMERA
            ) {
                controllableDevices.add(device);
                continue;
            }
            otherDevices.add(device);
        }
        if (localCameraDevice == null) {
            PPDeviceManager.isLocalCameraRemoved = true;
        }
    }

    private class PPDeviceNameAlphabetical implements Comparator<PPDeviceInfoModel> {

        @Override
        public int compare(PPDeviceInfoModel lDevice, PPDeviceInfoModel rDevice) {
            int result = 0;
            try {
                if (!PPUtil.isEmpty(lDevice.desc) && !PPUtil.isEmpty(rDevice.desc)) {
                    result = lDevice.desc.compareToIgnoreCase(rDevice.desc);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }

    }

    private String getLocalizedDeviceName(int deviceType) {
        Context ctx = PPVirtuoso.getInstance().getContext();
        String result = null;
        switch (deviceType) {
            case PPCommonInfo.INT_GREEN_GATEWAY:
                result = ctx.getString(R.string.device_name_presence_gateway);
                break;
            case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
                result = ctx.getString(R.string.device_name_entry_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221:
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101:
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211:
                result = ctx.getString(R.string.device_name_develco_gateway);
                break;
            case PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR:
                result = ctx.getString(R.string.device_name_develco_entry_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_KEYPAD:
                result = ctx.getString(R.string.device_name_develco_kepad);
                break;
            case PPCommonInfo.INT_DEVELCO_SIREN:
                result = ctx.getString(R.string.device_name_develco_siren);
                break;
            case PPCommonInfo.INT_DEVELCO_WATER_SENSOR:
                result = ctx.getString(R.string.device_name_develco_water_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_BUTTON:
                result = ctx.getString(R.string.device_name_develco_button);
                break;
            case PPCommonInfo.INT_DEVELCO_MOTION_SENSOR:
                result = ctx.getString(R.string.device_name_develco_motion_sensor);
                break;
            case PPCommonInfo.INT_LEAK_DETECTOR:
                result = ctx.getString(R.string.device_name_water_sensor);
                break;
            case PPCommonInfo.INT_TOUCH_SENSOR:
                result = ctx.getString(R.string.device_name_touch_sensor);
                break;
            case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                result = ctx.getString(R.string.device_name_temperature_sensor);
                break;
            case PPCommonInfo.INT_HUMIDITY_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_temp_sensor);
                break;
            case PPCommonInfo.INT_MOTION_SENSOR:
                result = ctx.getString(R.string.device_name_motion_sensor);
                break;
            case INT_GE_LIGHT_BULB:
                result = ctx.getString(R.string.device_name_smart_led);
                break;
            case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                result = ctx.getString(R.string.device_name_smart_plug);
                break;
            case PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_temp_sensor);
                break;
            case PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_temp_light_sensor);
                break;
        }
        return result;
    }
}
