package com.peoplepowerco.virtuoso.models.devices;

import android.content.Context;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : James Cho
 * @brief :
 * @date : 28/03/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPDeviceTypeModel implements IPPDeviceParameters {

    private final static String TAG = PPDeviceTypeModel.class.getSimpleName();
    private Context m_Context;

    public PPDeviceTypeModel(Context context) {
        m_Context = context;
    }


    public List<String> defaultDisplayParameterNames(int deviceType, int deviceCategory) {

        List<List> deviceTypeParams = new ArrayList<>();
        List<String> deviceTypeParamsList = new CopyOnWriteArrayList<String>();

        List<List> categoryTypeParams = new ArrayList<>();
        List<String> categoryTypeParamsList = new CopyOnWriteArrayList<String>();

        switch (deviceType) {
            case PPCommonInfo.INT_RTCOA_WIFI_THERMOSTAT:
                deviceTypeParamsList.add(SYSTEM_MODE);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_WIFI_SMART_PLUG:
                deviceTypeParamsList.add(POWER);
                deviceTypeParamsList.add(OUTLET_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_IBEACON:
                deviceTypeParamsList.add(IBEACON_STATUS);
                deviceTypeParamsList.add(IBEACON_PROXIMITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_PRESENCE_CAMARA:
            case PPCommonInfo.INT_PRESENCE_WEB_CAMERA:
            case PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA:
            case PPCommonInfo.INT_PRESENCE_IOS_CAMERA:
                deviceTypeParamsList.add(MOTION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_ANDROID_TOUCHPAD:
                deviceTypeParamsList.add(ALARM);
                deviceTypeParamsList.add(BATTERY_LEVEL);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_LINT_ALERT_PRO_PLUS:
                deviceTypeParamsList.add(SIG_STATUS);
                deviceTypeParamsList.add(SIG_CUR_MAX_LED);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_GREEN_BUTTON:
                deviceTypeParamsList.add(POWER);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_TED_MTU_LOAD:
                deviceTypeParamsList.add(POWER);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_TED_MTU_NET:
                deviceTypeParamsList.add(POWER);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR:
                deviceTypeParamsList.add(POWER);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH:
                deviceTypeParamsList.add(NAM_HEALTH_IDX);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR:
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR:
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_SENSIBO_THERMOSTAT:
                deviceTypeParamsList.add(COOLING_SETPOINT);
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT:
                deviceTypeParamsList.add(COOLING_SETPOINT);
                deviceTypeParamsList.add(HEATING_SETPOINT);
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_ECOBEE_THERMOSTAT:
                deviceTypeParamsList.add(COOLING_SETPOINT);
                deviceTypeParamsList.add(HEATING_SETPOINT);
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_EMERSON_THERMOSTAT:
                deviceTypeParamsList.add(COOLING_SETPOINT);
                deviceTypeParamsList.add(HEATING_SETPOINT);
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_FOSCAM_IP_CAMERA:
                deviceTypeParamsList.add(MOTION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_AMTK_IP_CAMERA:
                deviceTypeParamsList.add(MOTION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_PPC_IP_CAMERA:
                deviceTypeParamsList.add(MOTION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_IN_WALL_SWITCH:
                deviceTypeParamsList.add(OUTLET_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR:
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_DOOR_LOCK:
                deviceTypeParamsList.add(LOCK_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
            case PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR:
                deviceTypeParamsList.add(DOOR_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_LEAK_DETECTOR:
            case PPCommonInfo.INT_DEVELCO_WATER_SENSOR:
                deviceTypeParamsList.add(WATER_LEAK);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_TOUCH_SENSOR:
            case PPCommonInfo.INT_DEVELCO_VIBRATION_SENSOR:
                deviceTypeParamsList.add(VIBRATION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_HUMIDITY_SENSOR:
            case PPCommonInfo.INT_DEVELCO_HUMIDITY_SENSOR:
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                deviceTypeParamsList.add(POWER);
                deviceTypeParamsList.add(OUTLET_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_GE_LIGHT_BULB:
                deviceTypeParamsList.add(CURRENT_LEVEL);
                deviceTypeParamsList.add(STATE);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_THERMOSTAT:
                deviceTypeParamsList.add(COOLING_SETPOINT);
                deviceTypeParamsList.add(HEATING_SETPOINT);
                deviceTypeParamsList.add(DEG_C);
                deviceTypeParamsList.add(RELATIVE_HUMIDITY);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_MOTION_SENSOR:
            case PPCommonInfo.INT_DEVELCO_MOTION_SENSOR:
                deviceTypeParamsList.add(MOTION_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_SIREN:
            case PPCommonInfo.INT_LH_SIREN:
            case PPCommonInfo.INT_DEVELCO_SIREN:
                deviceTypeParamsList.add(ALARM_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_EWIG_BUTTON:
            case PPCommonInfo.INT_DEVELCO_BUTTON:
            case PPCommonInfo.INT_DEVELCO_MULITI_BUTTON:
                deviceTypeParamsList.add(BUTTON_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_PRESSURE_PAD_SENSOR:
                deviceTypeParamsList.add(PRESSURE_PAD_STATUS);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_DEVELCO_AIR_QUALITY_SENSOR:
                deviceTypeParamsList.add(VOC);
                deviceTypeParams.add(deviceTypeParamsList);
                break;
            case PPCommonInfo.INT_UNKNOWN:
            case PPCommonInfo.INT_GETTING_STARTED:
            case PPCommonInfo.INT_GREENX_HUB:
            case PPCommonInfo.INT_GREENX_PPC_HUB:
            case PPCommonInfo.INT_CROWD_FUNDING:
            case PPCommonInfo.INT_PEOPLE_POWER_GATEWAY:
            case PPCommonInfo.INT_QMOTE:
            case PPCommonInfo.INT_TED_MTU_SOLAR:
            case PPCommonInfo.INT_TED_MTU_STANDALONE:
            case PPCommonInfo.INT_TED_GATEWAY:
            case PPCommonInfo.INT_MONSTER_3_SOCKET_PS:
            case PPCommonInfo.INT_MONSTER_1_SOCKET_PS:
            case PPCommonInfo.INT_GALILEO_30_PIN:
            case PPCommonInfo.INT_GALILEO_BLUETOOTH_40:
            case PPCommonInfo.INT_KUBI_BLUETOOTH_40:
            case PPCommonInfo.INT_PRESENCE_360:
            case PPCommonInfo.INT_NETATMO_VIRTUAL_GATEWAY:
            case PPCommonInfo.INT_NETATMO_WELCOME_CAMERA:
            case PPCommonInfo.INT_GREEN_GATEWAY:
                // not supported
            default:
                break;
        }

        if (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockMiscellaneous) {
            if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryUnknown) {
                // not supported
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryMeter) {
                categoryTypeParamsList.add(POWER);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategorySmartPlug) {
                categoryTypeParamsList.add(POWER);
                categoryTypeParamsList.add(OUTLET_STATUS);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategorySolar) {
                categoryTypeParamsList.add(POWER);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryThermostat) {
                categoryTypeParamsList.add(COOLING_SETPOINT);
                categoryTypeParamsList.add(HEATING_SETPOINT);
                categoryTypeParamsList.add(DEG_C);
                categoryTypeParamsList.add(RELATIVE_HUMIDITY);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryLock) {
                categoryTypeParamsList.add(LOCK_STATUS);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryMobileCamera) {
                categoryTypeParamsList.add(MOTION_STATUS);
                categoryTypeParams.add(categoryTypeParamsList);
            } else if (deviceCategory == PPCommonInfo.PPDeviceTypeCategoryVideo) {
                // not supported
            } else {
                // not supported
            }
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockAdminTools - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockAdminTools)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockAlarms - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockAlarms)) {
            categoryTypeParamsList.add(ALARM_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockAnalytics - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockAnalytics)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockSafety - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockSafety)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockAudio - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockAudio)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockCameras - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockCameras)) {
            categoryTypeParamsList.add(MOTION_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls)) {
            categoryTypeParamsList.add(COOLING_SETPOINT);
            categoryTypeParamsList.add(HEATING_SETPOINT);
            categoryTypeParamsList.add(DEG_C);
            categoryTypeParamsList.add(RELATIVE_HUMIDITY);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockDisplays - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockDisplays)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockEnvironmental - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockEnvironmental)) {
            categoryTypeParamsList.add(DEG_C);
            categoryTypeParamsList.add(RELATIVE_HUMIDITY);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockHealth - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockHealth)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockLighting - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockLighting)) {
            categoryTypeParamsList.add(CURRENT_LEVEL);
            categoryTypeParamsList.add(STATE);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockLocks - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockLocks)) {
            categoryTypeParamsList.add(LOCK_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockMedia - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockMedia)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockMeters - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockMeters)) {
            categoryTypeParamsList.add(POWER);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockPerimeterMonitoring - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockPerimeterMonitoring)) {
            categoryTypeParamsList.add(DOOR_STATUS);
            categoryTypeParamsList.add(MOTION_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockRemoteControls - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockRemoteControls)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockRobotics - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockRobotics)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockRoutersAndGateways - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockRoutersAndGateways)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockSecurity - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockSecurity)) {
            categoryTypeParamsList.add(ALARM_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockSensors - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockSensors)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockShades - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockShades)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockSocial - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockSocial)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockSwitches - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockSwitches)) {
            categoryTypeParamsList.add(OUTLET_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockToys - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockToys)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockTransportation - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockTransportation)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockVideos - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockVideos)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockWater - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockWater)) {
            categoryTypeParamsList.add(WATER_LEAK);
            categoryTypeParams.add(categoryTypeParamsList);
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryBlockAppliances - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryBlockAppliances)) {
            // not supported
        } else if ((deviceCategory > PPCommonInfo.PPDeviceTypeCategoryLocalMobileCamera - 1000) && (deviceCategory <= PPCommonInfo.PPDeviceTypeCategoryLocalMobileCamera)) {
            categoryTypeParamsList.add(MOTION_STATUS);
            categoryTypeParams.add(categoryTypeParamsList);
        }

        for (String param : categoryTypeParamsList) {
            for (String deviceParam : deviceTypeParamsList) {
                if (deviceParam.equals(param)) {
                    deviceTypeParamsList.add(param);
                    PPVirtuosoLogTrace.d(TAG, "PARAM ADDED TO DEVICE PARAM = " + param);
                }
            }
        }

        return deviceTypeParamsList;
    }

    public String localizedDeviceTypeDefaultDescriptionFromName(String name, boolean bAppName) {
        String sDefaultDescription = name;

        if (name.equals("Presence Gateway")
            || name.equals("People Power Gateway")) {
            if (bAppName) {
                sDefaultDescription = PPAppCenter.APP_NAME + " " + m_Context.getString(R.string.device_description_gateway);
            } else {
                sDefaultDescription = m_Context.getString(R.string.device_description_gateway);
            }
        } else if (name.equals("Entry Sensor")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_entry_sensor);
        } else if (name.equals("Water Sensor")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_water_sensor);
        } else if (name.equals("Touch Sensor")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_touch_sensor);
        } else if (name.equals("Temperature Sensor")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_temerature_sensor);
        } else if (name.equals("Humidity Sensor")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_temparature_humidity_sensor);
        } else if (name.equals("Motion Detector")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_motion_sensor);
        } else if (name.equals("Smart Bulb")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_smart_bulb);
        } else if (name.equals("Presence Smart Plug")) {
            if (bAppName) {
                sDefaultDescription = PPAppCenter.APP_NAME + " " + m_Context.getString(R.string.device_description_smart_plug);
            } else {
                sDefaultDescription = m_Context.getString(R.string.device_description_smart_plug);
            }
        } else if (name.equals("Smart Plug")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_smart_plug);
        } else if (name.equals("LintAlert Pro Plus")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_lint_alert_pro_plus);
        } else if (name.equals("London Hydro Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_london_hydro_meter);
        } else if (name.equals("TED Solar Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_ted_solor_meter);
        } else if (name.equals("TED Load Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_ted_load_meter);
        } else if (name.equals("TED Energy Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_ted_energy_meter);
        } else if (name.equals("TED Gateway")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_ted_gateway);
        } else if (name.equals("Saturn South Gateway")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_saturn_south_gateway);
        } else if (name.equals("Mini Three Phase Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_mini_three_phase_meter);
        } else if (name.equals("Mini CT Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_mini_ct_meter);
        } else if (name.equals("PowerCost Meter")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_power_cost_meter);
        } else if (name.equals("Monster Central Plug")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_monster_central_plug);
        } else if (name.equals("KUBI Bluetooth 4.0")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_kubi_bluetooth_40);
        } else if (name.equals("Blueguard Gateway")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_blueguard_gateway);
        } else if (name.equals("Blueguard Lock")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_blueguard_lock);
        } else if (name.equals("In-Wall Switch")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_in_wall_switich);
        } else if (name.equals("Siren")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_siren);
        } else if (name.equals("Thermostat")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_thermostat);
        } else if (name.equals("Presence Thermostat")) {
            if (bAppName) {
                sDefaultDescription = PPAppCenter.APP_NAME + " " + m_Context.getString(R.string.device_description_thermostat);
            } else {
                sDefaultDescription = m_Context.getString(R.string.device_description_thermostat);
            }
        } else if (name.equals("Temperature")) {
            sDefaultDescription = m_Context.getString(R.string.device_description_temparature_humidity_sensor);
        }

        return sDefaultDescription;
    }

    public boolean isTemperatureSensor(int category, int deviceType) {
        if (category == PPCommonInfo.PPDeviceTypeCategoryThermostat) {
            return true;
        } else if ((category > PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls - 1000) && (category <= (PPCommonInfo.PPDeviceTypeCategoryBlockClimateControls))) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_RTCOA_WIFI_THERMOSTAT) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR || deviceType == PPCommonInfo.INT_DEVELCO_MOTION_SENSOR || deviceType == PPCommonInfo.INT_DEVELCO_WATER_SENSOR
            || deviceType == PPCommonInfo.INT_DEVELCO_SMART_CABLE || deviceType == PPCommonInfo.INT_DEVELCO_AIR_QUALITY_SENSOR || deviceType == PPCommonInfo.INT_DEVELCO_HUMIDITY_SENSOR
            || deviceType == PPCommonInfo.INT_DEVELCO_VIBRATION_SENSOR) {
            return true;
        }
        return false;
    }

    public boolean isElectricalMeter(int category) {
        if (category == PPCommonInfo.PPDeviceTypeCategoryMeter) {
            return true;
        } else if (category == PPCommonInfo.PPDeviceTypeCategorySmartPlug) {
            return true;
        } else if (category == PPCommonInfo.PPDeviceTypeCategorySolar) {
            return true;
        } else if ((category > PPCommonInfo.PPDeviceTypeCategoryBlockMeters - 1000) && (category <= PPCommonInfo.PPDeviceTypeCategoryBlockMeters)) {
            return true;
        } else if ((category > PPCommonInfo.PPDeviceTypeCategoryBlockLighting - 1000) && (category <= PPCommonInfo.PPDeviceTypeCategoryBlockLighting)) {
            return true;
        } else if ((category > PPCommonInfo.PPDeviceTypeCategoryBlockSwitches - 1000) && (category <= PPCommonInfo.PPDeviceTypeCategoryBlockSwitches)) {
            return true;
        }
        return false;
    }

    public boolean isGateway(int category, int deviceType) {
        if ((category > PPCommonInfo.PPDeviceTypeCategoryBlockRoutersAndGateways - 1000) && (category <= PPCommonInfo.PPDeviceTypeCategoryBlockRoutersAndGateways)) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_GREEN_GATEWAY) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY) {
            return true;
        }
        return false;
    }

    public boolean isGateway(int deviceType) {
        if (deviceType == PPCommonInfo.INT_GREEN_GATEWAY
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221
            || deviceType == PPCommonInfo.INT_X5_GATEWAY
            || deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
            || deviceType == PPCommonInfo.INT_GREENX_PPC_HUB
            || deviceType == PPCommonInfo.INT_TED_GATEWAY) {
            return true;
        }
        return false;
    }

    public boolean isCameraDevice(int deviceType) {
        if (deviceType == PPCommonInfo.INT_PRESENCE_CAMARA
            || deviceType == PPCommonInfo.INT_PRESENCE_IOS_CAMERA
            || deviceType == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA
            || deviceType == PPCommonInfo.INT_ALFAPRO_IP_CAMERA
            || deviceType == PPCommonInfo.INT_FOSCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_AMTK_IP_CAMERA
            || deviceType == PPCommonInfo.INT_BAYCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_PPC_IP_CAMERA) {
            return true;
        }
        return false;
    }

    public boolean isPresenceSecurityDevice(int deviceType) {
        if (deviceType == PPCommonInfo.INT_DOOR_WINDOW_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_LEAK_DETECTOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_TOUCH_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_MOTION_SENSOR) {
            return true;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR) {
            return true;
        }

        return false;
    }

    public static boolean supportsLocalDeviceUI(int deviceType) {
        if (deviceType == PPCommonInfo.INT_HUMIDITY_SENSOR
            || deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
            || deviceType == PPCommonInfo.INT_TED_MTU_NET
            || deviceType == PPCommonInfo.INT_TED_MTU_LOAD
            || deviceType == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR
            || deviceType == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS
            || deviceType == PPCommonInfo.INT_GREEN_BUTTON
            || deviceType == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean supportLocalDeviceUI(int deviceType) {
        if (deviceType == PPCommonInfo.INT_TED_MTU_NET
            || deviceType == PPCommonInfo.INT_TED_MTU_LOAD
            || deviceType == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR
            || deviceType == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS
            || deviceType == PPCommonInfo.INT_GREEN_BUTTON
            || deviceType == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isLighting(int category) {
        if (category > PPCommonInfo.PPDeviceTypeCategoryBlockLighting - 1000 && category <= PPCommonInfo.PPDeviceTypeCategoryBlockLighting) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLocks(int category) {
        if (category > PPCommonInfo.PPDeviceTypeCategoryBlockLocks - 1000 && category <= PPCommonInfo.PPDeviceTypeCategoryBlockLocks) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isSecurity(int category) {
        boolean isSecurity = false;
        switch (category) {
            case 19000:
                isSecurity = true;
                break;
            default:
                isSecurity = false;
                break;

        }
        return isSecurity;
    }

    public static boolean isThermostat(int deviceType) {
        if (deviceType == PPCommonInfo.INT_SENSIBO_THERMOSTAT
            || deviceType == PPCommonInfo.INT_THERMOSTAT
            || deviceType == PPCommonInfo.INT_ECOBEE_THERMOSTAT
            || deviceType == PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT
            || deviceType == PPCommonInfo.INT_EMERSON_THERMOSTAT) {
            return true;
        } else {
            return false;
        }
    }
}
