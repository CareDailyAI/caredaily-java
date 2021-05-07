package com.peoplepowerco.virtuoso.models.devices;

import android.content.Context;
import android.text.TextUtils;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.managers.PPDeviceManager;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 08/03/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPDeviceParameterStringModel implements IPPDeviceParameters {

    private final static String TAG = PPDeviceParameterStringModel.class.getSimpleName();
    private Context m_Context;

    public PPDeviceParameterStringModel(Context context) {
        m_Context = context;
    }

    public String stringForDeviceParameter(String param, HashMap option) {
        String value = "";
        String sReturnValue = null;
        int deviceTypeId = -1;

        if (option != null) {
            if (option.get("deviceTypeId") != null) {
                deviceTypeId = Integer.parseInt((String) option.get("deviceTypeId"));
            }
            if (option.get("value") != null) {
                value = (String) option.get("value");
            }
        }

        PPVirtuosoLogTrace.d(TAG, "value =" + value);
        PPVirtuosoLogTrace.d(TAG, "deviceTypeId" + deviceTypeId);

        if (value.equals("true") || value.equals("ON") || value.equals("1")) {
            value = "1";
        } else if (value.equals("false") || value.equals("OFF") || value.equals("0")) {
            value = "0";
        }

        if (param.equals(SYSTEM_MODE)) {

            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.sys_mode);
            } else {
                float systemMode = Float.parseFloat(value);
                switch ((int) systemMode) {
                    case PPDeviceParameterSystemModeOff:
                        sReturnValue = m_Context.getString(R.string.sys_mode_off);
                        break;
                    case PPDeviceParameterSystemModeCool:
                        sReturnValue = m_Context.getString(R.string.sys_mode_cool);
                        break;
                    case PPDeviceParameterSystemModeHeat:
                        sReturnValue = m_Context.getString(R.string.sys_mode_heat);
                        break;
                    case PPDeviceParameterSystemModeAuto:
                        sReturnValue = m_Context.getString(R.string.sys_mode_auto);
                        break;
                    case PPDeviceParameterSystemModeEmergencyHeat:
                        sReturnValue = m_Context.getString(R.string.sys_mode_emergency_heat);
                        break;
                    case PPDeviceParameterSystemModePrecooling:
                        sReturnValue = m_Context.getString(R.string.sys_mode_precooling);
                        break;
                    case PPDeviceParameterSystemModeFanOnly:
                        sReturnValue = m_Context.getString(R.string.sys_mode_fan_only);
                        break;
                    case PPDeviceParameterSystemModeDry:
                        sReturnValue = m_Context.getString(R.string.sys_mode_dry);
                        break;
                    case PPDeviceParameterSystemModeAuxiliaryHeat:
                        sReturnValue = m_Context.getString(R.string.sys_mode_auxiliary);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }

            }
        } else if (param.equals(SYSTEM_MODE_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.sys_mode_status);
            } else {
                float systemModeStatus = Float.parseFloat(value);
                switch ((int) systemModeStatus) {
                    case PPDeviceParameterSystemModeStatusOff:
                        sReturnValue = m_Context.getString(R.string.sys_mode_off);
                        break;
                    case PPDeviceParameterSystemModeStatusCool:
                        sReturnValue = m_Context.getString(R.string.sys_mode_cool);
                        break;
                    case PPDeviceParameterSystemModeStatusHeat:
                        sReturnValue = m_Context.getString(R.string.sys_mode_heat);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(FAN_MODE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.fan_mode);
            } else {
                float fanMode = Float.parseFloat(value);
                switch ((int) fanMode) {
                    case PPDeviceParameterFanModeOff:
                        sReturnValue = m_Context.getString(R.string.fan_mode_off);
                        break;
                    case PPDeviceParameterFanModeLow:
                        sReturnValue = m_Context.getString(R.string.fan_mode_low);
                        break;
                    case PPDeviceParameterFanModeMedium:
                        sReturnValue = m_Context.getString(R.string.fan_mode_medium);
                        break;
                    case PPDeviceParameterFanModeHigh:
                        sReturnValue = m_Context.getString(R.string.fan_mode_high);
                        break;
                    case PPDeviceParameterFanModeOn:
                        sReturnValue = m_Context.getString(R.string.fan_mode_on);
                        break;
                    case PPDeviceParameterFanModeAuto:
                        sReturnValue = m_Context.getString(R.string.fan_mode_auto);
                        break;
                    case PPDeviceParameterFanModeSmart:
                        sReturnValue = m_Context.getString(R.string.fan_mode_smart);
                        break;
                    case PPDeviceParameterFanModeCirculate:
                        sReturnValue = m_Context.getString(R.string.fan_mode_circulate);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
                PPVirtuosoLogTrace.d(TAG, "Current fan Mode = " + sReturnValue);
            }
        } else if (param.equals(SWING_MODE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.swing_mode);
            } else {
                float swingMode = Float.parseFloat(value);
                switch ((int) swingMode) {
                    case PPDeviceParameterSwingModeStopped:
                        sReturnValue = m_Context.getString(R.string.swing_mode_stop);
                        break;
                    case PPDeviceParameterSwingModeRangeFull:
                    case PPDeviceParameterSwingModeRangeTop:
                    case PPDeviceParameterSwingModeRangeMiddle:
                    case PPDeviceParameterSwingModeRangeBottom:
                        sReturnValue = m_Context.getString(R.string.swing_mode_range);
                        break;
                    case PPDeviceParameterSwingModeFixedTop:
                    case PPDeviceParameterSwingModeFixedMiddleTop:
                    case PPDeviceParameterSwingModeFixedMiddle:
                    case PPDeviceParameterSwingModeFixedMiddleBottom:
                    case PPDeviceParameterSwingModeFixedBottom:
                        sReturnValue = m_Context.getString(R.string.swing_mode_fix);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(STATE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.state_state);
            } else {
                float state = Float.parseFloat(value);
                switch ((int) state) {
                    case PPDeviceParameterStateOff:
                        sReturnValue = m_Context.getString(R.string.state_off);
                        break;
                    case PPDeviceParameterStateOn:
                        sReturnValue = m_Context.getString(R.string.state_on);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }

        } else if (param.equals(CURRENT_LEVEL)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.light_brightness);
            } else {
                sReturnValue = String.format("%s%%", value);
            }
        } else if (param.equals(OUTLET_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.fan_mode);
            } else {
                float outletStatus = Float.parseFloat(value);
                switch ((int) outletStatus) {
                    case PPDeviceParameterOutletStatusOff:
                        sReturnValue = m_Context.getString(R.string.sys_mode_off);
                        break;
                    case PPDeviceParameterOutletStatusOn:
                        sReturnValue = m_Context.getString(R.string.sys_mode_on);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(POWER_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.power_status);
            } else {
                float powerStatus = Float.parseFloat(value);
                switch ((int) powerStatus) {
                    case PPDeviceParameterPowerStatusOff:
                        sReturnValue = m_Context.getString(R.string.switch_off);
                        break;
                    case PPDeviceParameterPowerStatusOn:
                        sReturnValue = m_Context.getString(R.string.switch_on);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(BUTTON_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.button_status);
            } else {
                float powerStatus = Float.parseFloat(value);
                switch ((int) powerStatus) {
                    case PPDeviceParameterPowerStatusOff:
                        sReturnValue = m_Context.getString(R.string.state_released);
                        break;
                    case PPDeviceParameterPowerStatusOn:
                        sReturnValue = m_Context.getString(R.string.state_pressed);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(POWER)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.power);
            } else {
                sReturnValue = String.format("%s" + " " + m_Context.getString(R.string.watts), value);
            }
        } else if (param.equals(DEG_C)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.history_temperature);
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(COOLING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.cooling_setpoint);
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(HEATING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.heating_setpoint);
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(RELATIVE_HUMIDITY)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.relative_humidity);
            } else {
                sReturnValue = String.format("%s", value);
            }
        } else if (param.equals(DOOR_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.door_status);
            } else {
                float doorStatus = Float.parseFloat(value);
                switch ((int) doorStatus) {
                    case PPDeviceParameterDoorStatusClosed:
                        sReturnValue = m_Context.getString(R.string.status_entry_closed);
                        break;
                    case PPDeviceParameterDoorStatusOpen:
                        sReturnValue = m_Context.getString(R.string.status_entry_open);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(VIBRATION_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.vibration_status);
            } else {
                float vibrationStatus = Float.parseFloat(value);
                switch ((int) vibrationStatus) {
                    case PPDeviceParameterVibrationStatusStill:
                        sReturnValue = m_Context.getString(R.string.movement_sensor_still);
                        break;
                    case PPDeviceParameterVibrationStatusMoved:
                        sReturnValue = m_Context.getString(R.string.movement_sensor_moved);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(MOTION_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.motion_status);
            } else {
                float motionStatus = Float.parseFloat(value);
                switch ((int) motionStatus) {
                    case PPDeviceParameterMotionStatusNoMotion:
                        sReturnValue = m_Context.getString(R.string.motion_detector_no_motion);
                        break;
                    case PPDeviceParameterMotionStatusMotion:
                        sReturnValue = m_Context.getString(R.string.motion_detector_motion);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(BATTERY_DEFECT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = BATTERY_DEFECT;
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(BATTERY_LEVEL)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = BATTERY_LEVEL;
            } else {
                sReturnValue = value + "%";
            }
        } else if (param.equals(CHARGING)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.charging);
            } else {
                float charging = Float.parseFloat(value);
                switch ((int) charging) {
                    case PPDeviceParameterNotCharging:
                        sReturnValue = m_Context.getString(R.string.not_charging);
                        break;
                    case PPDeviceParameterCharging:
                        sReturnValue = m_Context.getString(R.string.charging);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(WATER_LEAK)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.water_leak);
            } else {
                float waterLeak = Float.parseFloat(value);
                switch ((int) waterLeak) {
                    case PPDeviceParameterWaterLeakDry:
                        sReturnValue = m_Context.getString(R.string.leak_detector_dry);
                        break;
                    case PPDeviceParameterWaterLeakWet:
                        sReturnValue = m_Context.getString(R.string.leak_detector_wet);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(LOCK_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.lock_status);
            } else {
                float lockStatus = Float.parseFloat(value);
                switch ((int) lockStatus) {
                    case PPDeviceParameterLockStatusUnlocked:
                        sReturnValue = m_Context.getString(R.string.door_unlocked);
                        break;
                    case PPDeviceParameterLockStatusLocked:
                        sReturnValue = m_Context.getString(R.string.door_locked);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(ALARM_STATUS)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.alarm_status);
            } else {
                float alarmStatus = Float.parseFloat(value);
                switch ((int) alarmStatus) {
                    case PPDeviceParameterAlarmStatusInactive:
                        sReturnValue = m_Context.getString(R.string.alarm_status_inactive);
                        break;
                    case PPDeviceParameterAlarmStatusActive:
                        sReturnValue = m_Context.getString(R.string.alarm_status_active);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(IBEACON_STATUS)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.ibeacon_status);
            } else {
                float iBeaconStatus = Float.parseFloat(value);
                switch ((int) iBeaconStatus) {
                    case PPDeviceParameterIBeaconStatusOn:
                        sReturnValue = m_Context.getString(R.string.state_on);
                        break;
                    case PPDeviceParameterIBeaconStatusOff:
                        sReturnValue = m_Context.getString(R.string.state_off);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(IBEACON_PROXIMITY)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.ibeacon_status);
            } else {
                float iBeaconProximity = Float.parseFloat(value);
                switch ((int) iBeaconProximity) {
                    case PPDeviceParameterIBeaconProximityUnknown:
                        sReturnValue = m_Context.getString(R.string.unknown);
                        break;
                    case PPDeviceParameterIBeaconProximityImmediate:
                        sReturnValue = m_Context.getString(R.string.ibeacon_immediate);
                        break;
                    case PPDeviceParameterIBeaconProximityNear:
                        sReturnValue = m_Context.getString(R.string.ibeacon_near);
                        break;
                    case PPDeviceParameterIBeaconProximityFar:
                        sReturnValue = m_Context.getString(R.string.ibeacon_far);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(SIG_STATUS)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.lint_alert_status);
            } else {
                float sigStatus = Float.parseFloat(value);
                switch ((int) sigStatus) {
                    case PPDeviceParameterSigStatusOff:
                        sReturnValue = m_Context.getString(R.string.lint_alert_device_dryer_off);
                        break;
                    case PPDeviceParameterSigStatusOn:
                        sReturnValue = m_Context.getString(R.string.lint_alert_device_dryer_on);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(SIG_CUR_MAX_LED)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.lint_alert_current_led);
            } else {
                float sigCurMaxLed = Float.parseFloat(value);
                switch ((int) sigCurMaxLed) {
                    case PPDeviceParameterSigCurMaxLedOK:
                        sReturnValue = m_Context.getString(R.string.sys_mode_off);
                        break;
                    case PPDeviceParameterSigCurMaxLedWarning:
                        sReturnValue = m_Context.getString(R.string.sys_mode_off);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
                if (sigCurMaxLed <= PPDeviceParameterSigCurMaxLedOK) {
                    sReturnValue = m_Context.getString(R.string.lint_alert_device_status_ok);
                } else if (sigCurMaxLed <= PPDeviceParameterSigCurMaxLedWarning) {
                    sReturnValue = m_Context.getString(R.string.lint_alert_device_status_warning);
                } else {
                    sReturnValue = m_Context.getString(R.string.lint_alert_device_status_blocked);
                }
            }
        } else if (param.equals(NAM_HEALTH_IDX)) {
            if (value == null || value.isEmpty()) {
                return m_Context.getString(R.string.nemato_health_coach_status);
            } else {
                float namHealthIdx = Float.parseFloat(value);
                switch ((int) namHealthIdx) {
                    case PPDeviceParameterNamHealthIdxHealthy:
                        sReturnValue = m_Context.getString(R.string.netatmo_status_healthy);
                        break;
                    case PPDeviceParameterNamHealthIdxFine:
                        sReturnValue = m_Context.getString(R.string.netatmo_status_fine);
                        break;
                    case PPDeviceParameterNamHealthIdxFair:
                        sReturnValue = m_Context.getString(R.string.netatmo_status_fair);
                        break;
                    case PPDeviceParameterNamHealthIdxPoor:
                        sReturnValue = m_Context.getString(R.string.netatmo_status_poor);
                        break;
                    case PPDeviceParameterNamHealthIdxUnhealthy:
                        sReturnValue = m_Context.getString(R.string.netatmo_status_unhealthy);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(FAN_MODE_SEQUENCE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "FAN_MODE_SEQUENCE";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(FAN_MODE_VALUES)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "FAN_MODE_VALUES";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(MIN_COOLING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "MIN_COOLING_SETPOINT";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(MAX_COOLING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "MAX_COOLING_SETPOINT";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(MIN_HEATING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "MIN_HEATING_SETPOINT";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(MAX_HEATING_SETPOINT)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "MAX_HEATING_SETPOINT";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(TEMP_VALUES)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "TEMP_VALUES";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(SWING_MODE_VALUES)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "SWING_MODE_VALUES";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(ENERGY)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "Energy usage";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(BATTERY_VOLTAGE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = "Battery Voltage";
            } else {
                sReturnValue = value;
            }
        } else if (param.equals(PRESSURE_PAD_STATUS)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = m_Context.getString(R.string.pressure_pad_status);
            } else {
                float pressureStatus = Float.parseFloat(value);
                switch ((int) pressureStatus) {
                    case PPDevicePressureStatusNoPressure:
                        sReturnValue = m_Context.getString(R.string.pressure_pad_no_pressure);
                        break;
                    case PPDevicePressureStatusPressureApplied:
                        sReturnValue = m_Context.getString(R.string.pressure_pad_pressure_applied);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        } else if (param.equals(ARM_MODE)) {
            if (!TextUtils.isEmpty(value)) {
                if (value.equals("ArmAllZones")) {
                    sReturnValue = "Away";
                } else if (value.equals("ArmDay_HomeZonesOnly")) {
                    sReturnValue = "Stay";
                } else if (value.equals("ArmNight_SleepZonesOnly")) {
                    sReturnValue = "Sleep";
                } else if (value.equals("Disarm")) {
                    sReturnValue = "Home";
                }
            }
        } else if (param.equals(CODE_TYPE)) {
            if (TextUtils.isEmpty(value)) {
                sReturnValue = m_Context.getString(R.string.code_type);
            } else {
                int codeType = Integer.parseInt(value);
                switch (codeType) {
                    case PPDeviceCodeTypeFromInitialCode:
                        sReturnValue = m_Context.getString(R.string.code_type_initial);
                        break;
                    default:
                        sReturnValue = m_Context.getString(R.string.undefined);
                        break;
                }
            }
        }
        PPVirtuosoLogTrace.d(TAG, "Parameter name = " + sReturnValue);
        return sReturnValue;
    }

    public String fontIconStringForDeviceParameter(String param, String value) {
        String sReturnValue = null;
        if (param.equals(FAN_MODE)) {
            return PPAppCenter.m_IconFontLabel.ICON_AIR;
        } else if (param.equals(SWING_MODE)) {
            if (value == null || value.isEmpty()) {
                sReturnValue = PPAppCenter.m_IconFontLabel.ICON_FA_MAP_MARKER;
            } else {
                float swingMode = Float.parseFloat(value);
                switch ((int) swingMode) {
                    case PPDeviceParameterSwingModeStopped:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_FA_POWER_OFF;
                        break;
                    case PPDeviceParameterSwingModeRangeFull:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeRangeTop:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeRangeMiddle:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeRangeBottom:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeFixedTop:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeFixedMiddleTop:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeFixedMiddle:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeFixedMiddleBottom:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    case PPDeviceParameterSwingModeFixedBottom:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_AC;
                        break;
                    default:
                        sReturnValue = PPAppCenter.m_IconFontLabel.ICON_FA_QUESTION_CIRCLE;
                        break;
                }
            }
        } else if (param.equals(POWER_STATUS)) {
            return PPAppCenter.m_IconFontLabel.ICON_FA_POWER_OFF;
        } else if (param.equals(RELATIVE_HUMIDITY)) {
            return PPAppCenter.m_IconFontLabel.ICON_HUMIDITY;
        } else if (param.equals(SYSTEM_MODE_STATUS)) {
            return PPAppCenter.m_IconFontLabel.ICON_FA_INFO_CIRCLE;
        }
        PPVirtuosoLogTrace.d(TAG, "ReturnValue = " + sReturnValue);
        return sReturnValue;
    }

    public HashMap parameterOptionWithValue(String value, int deviceTypeId) {
        HashMap<String, String> option = new HashMap<>();
        if (value != null) {
            option.put("value", value);
        }

        if (deviceTypeId != PPCommonInfo.INT_UNDEFINED) {
            option.put("deviceTypeId", Integer.toString(deviceTypeId));
        }
        return option;
    }

    public List<Integer> fanModesForSequence(int fanModeSequence) {
        List<Integer> availableModes = new ArrayList<Integer>();
        if (fanModeSequence == PPDeviceParameterFanModeSequenceLowMedHigh) {
            availableModes.add(PPDeviceParameterFanModeLow);
            availableModes.add(PPDeviceParameterFanModeMedium);
            availableModes.add(PPDeviceParameterFanModeHigh);
        } else if (fanModeSequence == PPDeviceParameterFanModeSequenceLowHigh) {
            availableModes.add(PPDeviceParameterFanModeLow);
            availableModes.add(PPDeviceParameterFanModeHigh);
        } else if (fanModeSequence == PPDeviceParameterFanModeSequenceLowMedHighAuto) {
            availableModes.add(PPDeviceParameterFanModeLow);
            availableModes.add(PPDeviceParameterFanModeMedium);
            availableModes.add(PPDeviceParameterFanModeHigh);
            availableModes.add(PPDeviceParameterFanModeAuto);
        } else if (fanModeSequence == PPDeviceParameterFanModeSequenceLowHighAuto) {
            availableModes.add(PPDeviceParameterFanModeLow);
            availableModes.add(PPDeviceParameterFanModeHigh);
            availableModes.add(PPDeviceParameterFanModeAuto);
        } else if (fanModeSequence == PPDeviceParameterFanModeSequenceOnAuto) {
            availableModes.add(PPDeviceParameterFanModeOn);
            availableModes.add(PPDeviceParameterFanModeAuto);
        }
        return availableModes;
    }

    public List<Integer> powerStatuses() {
        List<Integer> statuses = new ArrayList<Integer>();
        statuses.add(PPDeviceParameterPowerStatusOff);
        statuses.add(PPDeviceParameterPowerStatusOn);
        return statuses;
    }

    public int parameterSupportHistoricalMeasurement(String parameter) {
        int iSupportsHistoricalMeasurements = 0;
        if (parameter.endsWith(COOLING_SETPOINT)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(HEATING_SETPOINT)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(DEG_C)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(RELATIVE_HUMIDITY)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(POWER)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(ENERGY)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(DOOR_STATUS)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(VIBRATION_STATUS)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(WATER_LEAK)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(LOCK_STATUS)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(SIG_PRESSURE)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(SIG_WCI_PRESSURE)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }

        if (parameter.endsWith(MOTION_STATUS)) {
            int nSupportsHistoricalMeasurements = 1;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        } else {
            int nSupportsHistoricalMeasurements = 0;
            iSupportsHistoricalMeasurements |= nSupportsHistoricalMeasurements;
        }
        return iSupportsHistoricalMeasurements;
    }

    public String getReadableParameterValue(String name, String value) {
        PPDeviceManager mDeviceManager = PPDeviceManager.getInstance();
        String readableValue = mDeviceManager.getDisplayParameterValue(name, value);

        return readableValue;
    }

    public String getReadableRangedParameterValue(String name, String value) {
        PPDeviceManager mDeviceManager = PPDeviceManager.getInstance();
        String readableValue = mDeviceManager.getRangedOptionName(value, name);

        return readableValue;
    }

    public String getReadableParameterValueByIndex(String name, String value, int index) {
        PPDeviceManager mDeviceManager = PPDeviceManager.getInstance();
        String readableValue = mDeviceManager.getDisplayParameterValueByIndex(name, value, index);
        return readableValue;
    }

}




