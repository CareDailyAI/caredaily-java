package com.peoplepowerco.virtuoso.interfaces;

/**
 * @author : James Cho
 * @brief :
 * @date : 08/03/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public interface IPPDeviceParameters {

    //Climate Control
    String FAN_MODE = "fanMode";
    String FAN_MODE_SEQUENCE = "fanModeSequence";
    String FAN_MODE_VALUES = "fanModeValues";
    String SYSTEM_MODE = "systemMode";
    String SYSTEM_MODE_STATUS = "systemModeStatus";
    String COOLING_SETPOINT = "coolingSetpoint";
    String HEAT_COOLING_MINDELTA = "heatCoolMinDelta";
    String MIN_COOLING_SETPOINT = "minCoolingSetpoint";
    String MAX_COOLING_SETPOINT = "maxCoolingSetpoint";
    String HEATING_SETPOINT = "heatingSetpoint";
    String MIN_HEATING_SETPOINT = "minHeatingSetpoint";
    String MAX_HEATING_SETPOINT = "maxHeatingSetpoint";
    String TEMP_VALUES = "tempValues";
    String POWER_STATUS = "powerStatus";
    String SWING_MODE = "swingMode";
    String SWING_MODE_VALUES = "swingModeValues";
    String DEG_C = "degC";
    String INTERNAL_DEG_C = "internalDegC";
    String RELATIVE_HUMIDITY = "relativeHumidity";
    String STATE = "state";
    String CURRENT_LEVEL = "currentLevel";
    String OUTLET_STATUS = "outletStatus";
    String BUTTON_STATUS = "buttonStatus";
    String POWER = "power";

    String ENERGY = "energy";

    String BILLING = "billing";
    String ECO = "eco";
    String RSSI = "rssi";
    // Entry Sensor
    String DOOR_STATUS = "doorStatus";
    // Touch Sensor
    String VIBRATION_STATUS = "vibrationStatus";
    // Water Sensor
    String WATER_LEAK = "waterLeak";
    String BATTERY_VOLTAGE = "batteryVoltage";
    // Lock
    String LOCK_STATUS = "lockStatus";
    String LOCK_STATUS_ALARM = "lockStatusAlarm";
    // Alarm
    String ALARM_STATUS = "alarmStatus";
    String ALARM_WARN = "ppc.alarmWarn";
    String ALARM_DURATION = "ppc.alarmDuration";
    String ALARM_STROBE = "ppc.alarmStrobe";
    String ALARM_SQUAWK = "ppc.alarmSquawk";
    String ALARM_LEVEL = "ppc.alarmLevel";
    // iBeacon
    String IBEACON_STATUS = "ppc.iBeaconStatus";
    String IBEACON_PROXIMITY = "ppc.iBeaconProximity";
    // LintAlert
    String SIG_STATUS = "sig.status";
    String SIG_CUR_MAX_LED = "sig.curMaxLed";
    // Netatmo
    String NAM_HEALTH_IDX = "nam.healthIdx";
    String SIG_PRESSURE = "sig.pressure";
    String SIG_WCI_PRESSURE = "sig.wciPressure";

    String RECORD_STATUS = "recordStatus";
    String ACCESS_CAMERA_SETTINGS = "accessCameraSettings";
    String AUDIO_STREAMING = "audioStreaming";
    String VIDEO_STREAMING = "videoStreaming";
    String HD_STATUS = "ppc.hdStatus";
    String RAPID_MOTION_STATUS = "ppc.rapidMotionStatus";
    String BATTERY_LEVEL = "batteryLevel";
    String BATTERY_DEFECT = "batteryDefect";
    String CHARGING = "ppc.charging";
    String MOTION_STATUS = "motionStatus";
    String AUTO_FOCUS = "ppc.autoFocus";
    String AUDIO_STATUS = "audioStatus";
    String SELECTED_CAMERA = "selectedCamera";
    String RECORD_SECONDS = "ppc.recordSeconds";
    String MOTION_SENSITIVITY = "ppc.motionSensitivity";
    String VERSION = "version";
    String ROBOT_CONNECTED = "ppc.robotConnected";
    String ROBOT_MOTION_DIRECTION = "ppc.robotMotionDirection";
    String ROBOT_VANTAGE_SPHERICAL_COORDINATES = "ppc.robotVantageSphericalCoordinates";
    String ROBOT_VANTAGE_TIME = "ppc.robotVantageTimer";
    String ROBOT_VANTAGE_NAME = "ppc.robotVantageName";
    String ROBOT_VANTAGE_SEQUENCE = "ppc.robotVantageSequence";
    String ROBOT_VANTAGE_MOVE_TO_INDEX = "ppc.robotVantageMoveToIndex";
    String ROBOT_VANTAGE_CONFIGURATION_STATUS = "ppc.robotVantageConfigurationStatus";
    String ROBOT_ORIENTATION = "ppc.robotOrientation";
    String AVAILABLE_BYTES = "ppc.availableBytes";
    String TWITTER_AUTO_SHARE = "twitterAutoShare";
    String TWITTER_DESCRIPTION = "twitterDescription";
    String TWITTER_REMINDER = "ppc.twitterReminder";
    String TWITTER_STATUS = "ppc.twitterStatus";
    String MOTION_COUNTDOWN_TIME = "ppc.motionCountDownTime";
    String BLACKOUT_SCREEN_ON = "ppc.blackoutScreenOn";
    String WARNING_STATUS = "ppc.warningStatus";
    String WARNING_TEXT = "ppc.warningText";
    String KEYPAD_STATUS = "ppc.keypadStatus";
    String RECORD_FULL_DURATION = "ppc.recordFullDuration";
    String FLASH_ON = "ppc.flashOn";
    String SUPPORTS_VIDEO_CALL = "ppc.supportsVideoCall";
    String OUTPUT_VOLUME = "ppc.outputVolume";
    String CAPTURE_IMAGE = "ppc.captureImage";
    String ALARM = "ppc.alarm";
    String PLAY_SOUND = "ppc.playSound";
    String COUNTDOWN = "ppc.countdown";
    String VISUAL_COUNTDOWN = "ppc.visualCountdown";
    String MOTION_ALARM = "ppc.motionAlarm";
    String FIRMWARE = "firmware";
    String MODEL = "model";
    String FIRMWARE_UPDATE_STATUS = "firmwareUpdateStatus";
    String FIRMWARE_URL = "firmwareUrl";
    String FIRMWARE_CHECK_SUM = "firmwareCheckSum";
    String PRESSURE_PAD_STATUS = "pressureStatus";
    String ARM_MODE = "armMode";
    String CODE_TYPE = "codeType";
    String ILLUMINACE = "illuminance";
    String TEMPERATURE = "temperature";
    String NETWORKTYPE = "netType";
    String WIFISIGNAL = "wifiSignal";
    String VOC = "voc";

    int PPDialControlItemNone        = 0;
    int PPDialControlItemDual        = 1 << 0;
    int PPDialControlItemDial        = 1 << 1;
    int PPDialControlItemMarker      = 1 << 2;
    int PPDialControlItemIncremental = 1 << 3;
    int PPDialControlItemMode        = 1 << 4;
    int PPDialControlItemSecondary   = 1 << 5;
    int PPDialControlItemTertiary    = 1 << 6;
    int PPDialControlItemQuarternary = 1 << 7;
    int PPDialControlItemQuinary     = 1 << 8;



    float DEFAULT_DEG_MIN_C_THERMOSTAT = 7f;
    float DEFAULT_DEG_MAX_C_THERMOSTAT = 30f;
    float DEFAULT_DEG_STEP_C_THERMOSTAT = 0.5f;
    float DEFAULT_DEG_MIN_F_THERMOSTAT = 45f;
    float DEFAULT_DEG_MAX_F_THERMOSTAT = 86f;
    float DEFAULT_DEG_STEP_F_THERMOSTAT = 1.0f;

    int PPDeviceParameterSystemModeOff = 0;
    int PPDeviceParameterSystemModeAuto = 1;
    int PPDeviceParameterSystemModeCool = 3;
    int PPDeviceParameterSystemModeHeat = 4;
    int PPDeviceParameterSystemModeEmergencyHeat = 5;
    int PPDeviceParameterSystemModePrecooling = 6;
    int PPDeviceParameterSystemModeFanOnly = 7;
    int PPDeviceParameterSystemModeDry = 8;
    int PPDeviceParameterSystemModeAuxiliaryHeat = 9;

    int PPDeviceParameterSystemModeStatusOff = 0;
    int PPDeviceParameterSystemModeStatusCool = 1;
    int PPDeviceParameterSystemModeStatusHeat = 2;

    int PPDeviceParameterFanModeOff = 0;
    int PPDeviceParameterFanModeLow = 1;
    int PPDeviceParameterFanModeMedium = 2;
    int PPDeviceParameterFanModeHigh = 3;
    int PPDeviceParameterFanModeOn = 4;
    int PPDeviceParameterFanModeAuto = 5;
    int PPDeviceParameterFanModeSmart = 6;
    int PPDeviceParameterFanModeCirculate = 7;

    int PPDeviceParameterFanModeSequenceLowMedHigh = 0;
    int PPDeviceParameterFanModeSequenceLowHigh = 1;
    int PPDeviceParameterFanModeSequenceLowMedHighAuto = 2;
    int PPDeviceParameterFanModeSequenceLowHighAuto = 3;
    int PPDeviceParameterFanModeSequenceOnAuto = 4;

    int PPDeviceParameterSwingModeStopped = 0;
    int PPDeviceParameterSwingModeRangeFull = 1;
    int PPDeviceParameterSwingModeRangeTop = 2;
    int PPDeviceParameterSwingModeRangeMiddle = 3;
    int PPDeviceParameterSwingModeRangeBottom = 4;
    int PPDeviceParameterSwingModeFixedTop = 5;
    int PPDeviceParameterSwingModeFixedMiddleTop = 6;
    int PPDeviceParameterSwingModeFixedMiddle = 7;
    int PPDeviceParameterSwingModeFixedMiddleBottom = 8;
    int PPDeviceParameterSwingModeFixedBottom = 9;

    int PPDeviceParameterStateOff = 0;
    int PPDeviceParameterStateOn = 1;

    int PPDeviceParameterOutletStatusOff = 0;
    int PPDeviceParameterOutletStatusOn = 1;

    int PPDeviceParameterPowerStatusOff = 0;
    int PPDeviceParameterPowerStatusOn = 1;

    int PPDeviceParameterDoorStatusClosed = 0;
    int PPDeviceParameterDoorStatusOpen = 1;

    int PPDeviceParameterVibrationStatusStill = 0;
    int PPDeviceParameterVibrationStatusMoved = 1;

    int PPDeviceParameterNotCharging = 0;
    int PPDeviceParameterCharging = 1;

    int PPDeviceParameterMotionStatusNoMotion = 0;
    int PPDeviceParameterMotionStatusMotion = 1;

    int PPDeviceParameterWaterLeakDry = 0;
    int PPDeviceParameterWaterLeakWet = 1;

    int PPDeviceParameterLockStatusUnlocked = 0;
    int PPDeviceParameterLockStatusLocked = 1;

    int PPDeviceParameterAlarmStatusInactive = 0;
    int PPDeviceParameterAlarmStatusActive = 1;

    int PPDeviceParameterIBeaconStatusOn = 0;
    int PPDeviceParameterIBeaconStatusOff = 1;

    int PPDeviceParameterIBeaconProximityUnknown = 0;
    int PPDeviceParameterIBeaconProximityImmediate = 1;
    int PPDeviceParameterIBeaconProximityNear = 2;
    int PPDeviceParameterIBeaconProximityFar = 3;

    int PPDeviceParameterSigStatusOff = 0;
    int PPDeviceParameterSigStatusOn = 1;

    int PPDeviceParameterSigCurMaxLedNone = 0;
    int PPDeviceParameterSigCurMaxLedOK = 3;
    int PPDeviceParameterSigCurMaxLedWarning = 4;
    int PPDeviceParameterSigCurMaxLedBlocked = 5;

    int PPDeviceParameterNamHealthIdxHealthy = 0;
    int PPDeviceParameterNamHealthIdxFine = 1;
    int PPDeviceParameterNamHealthIdxFair = 2;
    int PPDeviceParameterNamHealthIdxPoor = 3;
    int PPDeviceParameterNamHealthIdxUnhealthy = 4;

    int PPDialScaleDefault = 0;
    int PPDialScalePercent = 1;
    int PPDialScaleDegreeCelsius = 2;
    int PPDialScaleDegreeFahrenheit = 3;

    int PPDevicePressureStatusNoPressure = 0;
    int PPDevicePressureStatusPressureApplied = 1;

    int PPDeviceCodeTypeUnknown = 0;
    int PPDeviceCodeTypeManuallyEnter = 1;
    int PPDeviceCodeTypeScannedCard = 2;
    int PPDeviceCodeTypeCombinedCodeCard = 3;
    int PPDeviceCodeTypeFromKeypad = 4;
    int PPDeviceCodeTypeFromInitialCode = 8;
    int PPDeviceCodeTypeFromDuressCode = 9;

}
