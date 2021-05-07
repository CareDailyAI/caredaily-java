/**
 * @FileName : PPCommonInfo.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.util.EventTrackingUtils;
import com.peoplepowerco.virtuoso.util.PPNotificationDBHelper;
import com.peoplepowerco.virtuoso.util.PPUtil;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : common information class
 * @date : 2014. 5. 4.
 */
public class PPCommonInfo {

    public static final String PPC_BRAND_PRESENCE = "presence";
    public static final String PPC_BRAND_FAMILY = "presencefamily";
    public static final String PPC_BRAND_CARE = "familycare";

    public static final String CACHE_FILE_PATH = "/presencefamily/";
    public static final String KEY_FAMILY_APP_HASH_KEY = "CRFamilyAppHashKey";

    public static final String AMP_EVENT_SYSTEM_TERMINATED = "Application terminated";
    public static final String AMP_EVENT_SYSTEM_MEMORY_WARN = "Memory warning";
    public static final String AMP_EVENT_SYSTEM_APP_BACKGROUND = "Background application";
    public static final String AMP_EVENT_SYSTEM_APP_LAUNCH = "Launch application";
    public static final String AMP_EVENT_SYSTEM_CONNECTION_TROUBLE = "Application had trouble connecting";

    public static final String AMP_EVENT_USER_REGISTERED = "User registered";
    public static final String AMP_EVENT_USER_ACCOUNT_MERGED = "Accounts merged";
    public static final String AMP_EVENT_USER_SIGN_IN = "Signed in";
    public static final String AMP_EVENT_USER_LOGOUT = "Logged out";
    public static final String AMP_EVENT_USER_DETAIL_EDIT = "User details edited";

    public static final String AMP_EVENT_OOBE_ENTER_STORY = "Entering OOBE story";
    public static final String AMP_EVENT_OOBE_EXIT_STORY = "Exiting OOBE story";

    public static final String AMP_EVENT_LOCATION_CREATED = "Location created";
    public static final String AMP_EVENT_LOCATION_UPDATED = "Location updated";
    public static final String AMP_EVENT_LOCATION_LEFT = "Location left";
    public static final String AMP_EVENT_LOCATION_REMOVED = "Location removed";
    public static final String AMP_EVENT_LOCATION_USER_ADDED = "Location user added";
    public static final String AMP_EVENT_LOCATION_USER_EDITED = "Location user edited";
    public static final String AMP_EVENT_LOCATION_USER_REMOVED = "Location user removed";
    public static final String AMP_EVENT_LOCATION_CALLCENTER_UPDATED = "CallCenter settings updated";
    public static final String AMP_EVENT_LOCATION_DEVICE_REMOVED = "Device removed";
    public static final String AMP_EVENT_LOCATION_CHANGED = "Change location";
    public static final String AMP_EVENT_TASK_ADDED = "Task Added";
    public static final String AMP_EVENT_TASK_COMPLETED = "Task Completed";
    public static final String AMP_EVENT_POST_CREATED = "Post created";
    public static final String AMP_EVENT_POST_EDITED = "Post edited";
    public static final String AMP_EVENT_POST_REMOVED = "Post removed";
    public static final String AMP_EVENT_COMMENT_CREATED = "Comment created";
    public static final String AMP_EVENT_COMMENT_REMOVED = "Comment removed";
    public static final String AMP_EVENT_DASHBOARD_OPENED = "Dashboard opened";
    public static final String AMP_EVENT_DASHBOARD_CLOSED = "Dashboard closed";
    public static final String AMP_EVENT_PEOPLE_OPENED = "People opened";
    public static final String AMP_EVENT_PEOPLE_CLOSED = "People closed";
    public static final String AMP_EVENT_DEVICE_OPENED = "Devices opened";
    public static final String AMP_EVENT_DEVICE_CLOSED = "Devices closed";
    public static final String AMP_EVENT_COMMUNITY_OPENED = "Community opened";
    public static final String AMP_EVENT_COMMUNITY_CLOSED = "Community closed";

    public static String SUPPORT_FAQ_URL = "https://peoplepowerco.zendesk.com";

    public static final char NETWORK_NONE = 0;
    public static final char NETWORK_WIFI = 1;
    public static final char NETWORK_MOBILE = 2;
    public static final char NETWORK_BLUETOOTH = 3;
    public static float density = 0.0f;

    public static final int PPQuestionAnswerStatusNone = -1;
    public static final int PPQuestionAnswerStatusDelayed = 0; // Delayed, the question will be asked in the future
    public static final int PPQuestionAnswerStatusReady = 1; // Ready to be asked, but it is queued
    public static final int PPQuestionAnswerStatusAvailable = 2; // Available
    public static final int PPQuestionAnswerStatusSkipped = 3; // Skipped, the user is going to answer it later
    public static final int PPQuestionAnswerStatusAnswered = 4; // Answered
    public static final int PPQuestionAnswerStatusNoAnswer = 5;

    public static final int PPInvalidValue = -1;

    public static final int PPQuestionEditableNone = -1;
    public static final int PPQuestionEditableFalse = 0;
    public static final int PPQuestionEditableTrue = 1;

    public static final int PPQuestionsPublicNone = -1;
    public static final int PPQuestionsPublicFalse = 0;
    public static final int PPQuestionsPublicTrue = 1;

    public static final int PPQuestionCollectionGeneralPublicNone = -1;
    public static final int PPQuestionCollectionGeneralPublicFalse = 0;
    public static final int PPQuestionCollectionGeneralPublicTrue = 1;

    public static final int PPQuestionsLimitNone = -1;
    public static final int PPQuestionsLimitUnlimited = 0;

    //device type
    public static final String GETTING_STARTED = "1";
    public static final String KICKSTARTER_VIDEO = "2";
    public static final String GREENX_HUB = "3";
    public static final String GREENX_DISPLAY = "4";
    public static final String GREENX_TOTAL_HOME_METER = "5";
    public static final String GREENX_5_SOCKET_POWER_STRIP = "6";
    public static final String GREENX_EGG = "7";
    public static final String CROWDFUNDING = "8";
    public static final String RTCOA_WIFI_THERMOSTAT = "11";
    public static final String VISUAL_ENERGY_UFO_POWER_STRIP = "12";
    public static final String BEC_SMARTPLUG_MOBILE_CAMARA = "13";
    public static final String WIFI_SMART_PLUG = "15";
    public static final String PEOPLE_POWER_MOBILE_CAMARA = "21";
    public static final String PRESENCE_WEB_CAMERA = "22";
    public static final String PRESENCE_ANDROID_CAMERA = "23";
    public static final String PRESENCE_IOS_CAMERA = "24";
    public static final String LINT_ALERT_PRO_PLUS = "130";
    public static final String GREEN_BUTTON = "200";
    public static final String CAPE_GROUP = "500";
    public static final String CAPE_MESSAGES = "501";
    public static final String CAPE_CHALLENGES = "502";
    public static final String CAPE_POINTS = "503";
    public static final String TED_MTU_LOAD = "1000";
    public static final String TED_MTU_SOLAR = "1001";
    public static final String TED_MTU_NET = "1002";
    public static final String TED_MTU_STANDALONE = "1003";
    public static final String TED_GATEWAY = "1004";
    public static final String TED_MTU = "1005";
    public static final String BLUE_LINE_POWERCOST_MONITOR = "1100";
    public static final String MONSTER_CENTRAL_PLUG = "2010";
    public static final String MONSTER_3700 = "2011";
    public static final String MONSTER_1_SOCKET_PS = "2012";
    public static final String MONSTER_3_SOCKET_PS = "2013";
    public static final String MONSTER_1_SOCKET_MONITOR = "2014";
    public static final String TRCOA_MONSTER_THERMOSTAT = "2022";
    public static final String SGT_BES = "2100";
    public static final String INNOVOLT_POWER_DOCTOR = "3000";
    public static final String INNOVOLT_POWER_MANAGER = "3001";
    public static final String GALILEO_30_PIN = "3100";
    public static final String GALILEO_BLUETOOTH_40 = "3101";
    public static final String KUBI_BLUETOOTH_40 = "3102";
    public static final String NAGASAKI_CONTROL_GW = "4000";
    public static final String NAGASAKI_CT_MONITOR = "4001";
    public static final String NAGASAKI_ECHO_SWITCH = "4002";
    public static final String NAGASAKI_POWER_MONITOR = "4003";
    public static final String NAGASAKI_TEMPERATURE_HUMIDITY_SENSOR = "4004";
    public static final String NAGASAKI_MOTION_SENSOR = "4005";
    public static final String NAGASAKI_PV_GENERATOR = "4006";
    public static final String NAGASAKI_2DAY_WEATHER_FORECAST = "4007";
    public static final String NAGASAKI_7DAY_WEATHER_FORECAST = "4008";
    public static final String NAGASAKI_PINPOINT_WEATHER_FORECAST = "4009";
    public static final String NAGASAKI_PREDICTED_PV_GERERATION = "4010";
    public static final String NAGASAKI_PREDICTED_SOLAR_REDIATION = "4011";
    public static final String SIMPLICIKEY_GATEWAY = "5000";
    public static final String ALFAPRO_IP_CAMERA = "7000";
    public static final String FOSCAM_IP_CAMERA = "7001";
    public static final String AMTK_IP_CAMERA = "7002";
    public static final String IN_WALL_SWITCH = "9001";
    public static final String SMART_SIREN = "9002";
    public static final String DOOR_LOCK = "9010";
    public static final String PANASONIC_SLIP = "10002";
    public static final String PANASONIC_4_SOCKET_POWER_STRIP = "10003";
    public static final String PANASONIC_1_SOCKET_POWER_STRIP = "10004";
    public static final String MORSE_CODE_APP = "10007";
    public static final String DESK_DRAWER = "10014";
    public static final String MOTION_DETECTOR = "10016";
    public static final String LEAK_DETECTOR = "10017";
    public static final String TOUCH_SENSOR = "10019";
    public static final String GREEN_GATEWAY = "10031";
    public static final String TEMPARATURE = "10032";
    public static final String TEMPERATURE_SENSOR = "10033";
    public static final String HUMIDITY_SENSOR = "10034";
    public static final String CENTRALITE_SMART_PLUG = "10035";
    public static final String GE_LIGHT_BULB = "10036";
    public static final String THERMOSTAT = "10037";
    public static final String UISCREENS = "99999";
    public static final String NOTIFICATION_MSG = "NotificationMsg";
    public static final String NOTIFICATION_DATE = "NotificationDate";
    public static final String NOTIFICATION_TIME = "NotificationTime";
    public static String sCurrentUnit = null;

    public static final int INT_UNDEFINED = -1;
    public static final int INT_UNKNOWN = 0;
    public static final int INT_GETTING_STARTED = 1;
    public static final int INT_KICKSTARTER_VIDEO = 2;
    public static final int INT_GREENX_HUB = 3;
    public static final int INT_GREENX_PPC_HUB = 4;
    public static final int INT_GREENX_TOTAL_HOME_METER = 5;
    public static final int INT_GREENX_5_SOCKET_POWER_STRIP = 6;
    public static final int INT_GREENX_EGG = 7;
    public static final int INT_CROWD_FUNDING = 8;
    public static final int INT_RTCOA_WIFI_THERMOSTAT = 11;
    public static final int INT_VISUAL_ENERGY_UFO_POWER_STRIP = 12;
    public static final int INT_BEC_SMARTPLUG_MOBILE_CAMARA = 13;
    public static final int INT_WIFI_SMART_PLUG = 15;
    public static final int INT_IBEACON = 16;
    public static final int INT_PRESENCE_CAMARA = 21;
    public static final int INT_PRESENCE_WEB_CAMERA = 22;
    public static final int INT_PRESENCE_ANDROID_CAMERA = 23;
    public static final int INT_PRESENCE_IOS_CAMERA = 24;
    public static final int INT_ANDROID_TOUCHPAD = 25;
    public static final int INT_PRESENCE_DEVICES = 26;
    public static final int INT_PEOPLE_POWER_GATEWAY = 31;
    public static final int INT_DEVELCO_GATEWAY_MGW221 = 32;
    public static final int INT_X5_GATEWAY = 35;
    public static final int INT_DEVELCO_GATEWAY_MGW101 = 36;
    public static final int INT_DEVELCO_GATEWAY_MGW211 = 37;
    public static final int INT_QMOTE = 120;
    public static final int INT_LINT_ALERT_PRO_PLUS = 130;
    public static final int INT_GREEN_BUTTON = 200;
    public static final int INT_CAPE_GROUP = 500;
    public static final int INT_CAPE_MESSAGES = 501;
    public static final int INT_CAPE_CHALLENGES = 502;
    public static final int INT_CAPE_POINTS = 503;
    public static final int INT_TED_MTU_LOAD = 1000;
    public static final int INT_TED_MTU_SOLAR = 1001;
    public static final int INT_TED_MTU_NET = 1002;
    public static final int INT_TED_MTU_STANDALONE = 1003;
    public static final int INT_TED_GATEWAY = 1004;
    public static final int INT_TED_MTU = 1005;
    public static final int INT_BLUE_LINE_POWERCOST_MONITOR = 1100;
    public static final int INT_OTHER_GATEWAY = 1020;
    public static final int INT_OTHER_METERS = 1021;
    public static final int INT_MONSTER_3700 = 2011;
    public static final int INT_MONSTER_1_SOCKET_PS = 2012;
    public static final int INT_MONSTER_3_SOCKET_PS = 2013;
    public static final int INT_MONSTER_1_SOCKET_MONITOR = 2014;
    public static final int INT_TRCOA_MONSTER_THERMOSTAT = 2022;
    public static final int INT_SGT_BES = 2100;
    public static final int INT_INNOVOLT_POWER_DOCTOR = 3000;
    public static final int INT_INNOVOLT_POWER_MANAGER = 3001;
    public static final int INT_GALILEO_30_PIN = 3100;
    public static final int INT_GALILEO_BLUETOOTH_40 = 3101;
    public static final int INT_KUBI_BLUETOOTH_40 = 3102;
    public static final int INT_PRESENCE_360 = 3103;
    public static final int INT_NAGASAKI_CONTROL_GW = 4000;
    public static final int INT_NAGASAKI_CT_MONITOR = 4001;
    public static final int INT_NAGASAKI_ECHO_SWITCH = 4002;
    public static final int INT_NAGASAKI_POWER_MONITOR = 4003;
    public static final int INT_NAGASAKI_TEMPERATURE_HUMIDITY_SENSOR = 4004;
    public static final int INT_NAGASAKI_MOTION_SENSOR = 4005;
    public static final int INT_NAGASAKI_PV_GENERATOR = 4006;
    public static final int INT_NAGASAKI_2DAY_WEATHER_FORECAST = 4007;
    public static final int INT_NAGASAKI_7DAY_WEATHER_FORECAST = 4008;
    public static final int INT_NAGASAKI_PINPOINT_WEATHER_FORECAST = 4009;
    public static final int INT_NAGASAKI_PREDICTED_PV_GERERATION = 4010;
    public static final int INT_NAGASAKI_PREDICTED_SOLAR_REDIATION = 4011;
    public static final int INT_NETATMO_HEALTHY_HOME_COACH = 4200;
    public static final int INT_NETATMO_WEATHER_STATION_INDOOR = 4201;
    public static final int INT_NETATMO_WEATHER_STATION_OUTDOOR = 4202;
    public static final int INT_NETATMO_VIRTUAL_GATEWAY = 4203;
    public static final int INT_NETATMO_WELCOME_CAMERA = 4204;
    public static final int INT_SENSIBO_THERMOSTAT = 4220;
    public static final int INT_HONEYWELL_LYRIC_THERMOSTAT = 4230;
    public static final int INT_ECOBEE_THERMOSTAT = 4240;
    public static final int INT_EMERSON_THERMOSTAT = 4260;
    public static final int INT_SIMPLICIKEY_GATEWAY = 5000;
    public static final int INT_ALFAPRO_IP_CAMERA = 7000;
    public static final int INT_FOSCAM_IP_CAMERA = 7001;
    public static final int INT_AMTK_IP_CAMERA = 7002;
    public static final int INT_BAYCAM_IP_CAMERA = 7003;
    public static final int INT_PPC_IP_CAMERA = 7004;
    public static final int INT_DLINK_IP_CAMERA = 7007;
    public static final int INT_IN_WALL_SWITCH = 9001;
    public static final int INT_SIREN = 9002;
    public static final int INT_HUMIDITY_TEMP_SENSOR = 9003;
    public static final int INT_HUMIDITY_TEMP_LIGHT_SENSOR = 9004;
    public static final int INT_FIRE_DETECTOR = 9006;
    public static final int INT_LH_SIREN = 9009;
    public static final int INT_DOOR_LOCK = 9010;
    public static final int INT_CO2_DETECTOR = 9011;
    public static final int INT_EWIG_BUTTON = 9014;
    public static final int INT_ENERGY_METER = 9016;
    public static final int INT_LOAD_CONTROLLER = 9017;
    public static final int INT_GE_SWITCH = 9018;
    public static final int INT_PRESSURE_PAD_SENSOR = 9039;
    public static final int INT_DEVELCO_BUTTON = 9101;
    public static final int INT_DEVELCO_SIREN = 9102;
    public static final int INT_DEVELCO_KEYPAD = 9103;
    public static final int INT_DEVELCO_DEVICEIO = 9104;
    public static final int INT_DEVELCO_SMART_CABLE = 9105;
    public static final int INT_DEVELCO_MULITI_BUTTON = 9106;
    public static final int INT_DEVELCO_AIR_QUALITY_SENSOR = 9107;
    public static final int INT_DEVELCO_HEAT_ALARM = 9108;
    public static final int INT_DEVELCO_ENTRY_SENSOR = 9114;
    public static final int INT_DEVELCO_WATER_SENSOR = 9117;
    public static final int INT_DEVELCO_VIBRATION_SENSOR = 9119;
    public static final int INT_DEVELCO_HUMIDITY_SENSOR = 9134;
    public static final int INT_DEVELCO_MOTION_SENSOR = 9138;
    public static final int INT_PANASONIC_SLIP = 10002;
    public static final int INT_PANASONIC_4_SOCKET_POWER_STRIP = 10003;
    public static final int INT_PANASONIC_1_SOCKET_POWER_STRIP = 10004;
    public static final int INT_MORSE_CODE_APP = 10007;
    public static final int INT_DOOR_WINDOW_SENSOR = 10014;
    public static final int INT_MOTION_DETECTOR = 10016;
    public static final int INT_LEAK_DETECTOR = 10017;
    public static final int INT_TOUCH_SENSOR = 10019;
    public static final int INT_GREEN_GATEWAY = 10031;
    public static final int INT_TEMPERATURE = 10032;
    public static final int INT_TEMPERATURE_SENSOR = 10033;
    public static final int INT_HUMIDITY_SENSOR = 10034;
    public static final int INT_CENTRALITE_SMART_PLUG = 10035;
    public static final int INT_GE_LIGHT_BULB = 10036;
    public static final int INT_THERMOSTAT = 10037;
    public static final int INT_MOTION_SENSOR = 10038;
    public static final int INT_MOCKUP_CAMERA = 66666;
    //Int value for UI screen(temporary value to discriminate)
    public static final int INT_UISCREENS = 99999;
    public static final int INT_ADD_PEOPLE = 100000;
    public static final int INT_SETUP_SMART_HOME = 100001;
    public static final int INT_ADD_DEVICES = 100002;
    public static final int INT_SHOP_AT_STORE = 100003;
    public static final int INT_BUY_DEVICES = 100004;
    public static final int INT_BUY_A_SUBSCRIPTION = 100005;
    public static final int INT_START_SURVEY_QUESTION = 100006;

    public static final int PPDeviceTypeCategoryUnknown = 0;
    public static final int PPDeviceTypeCategoryMeter = 1;
    //Changed from monster plug to smart plug
    public static final int PPDeviceTypeCategorySmartPlug = 2;
    public static final int PPDeviceTypeCategorySolar = 3;
    public static final int PPDeviceTypeCategoryThermostat = 4;
    public static final int PPDeviceTypeCategoryLock = 5;
    public static final int PPDeviceTypeCategoryMobileCamera = 6;
    public static final int PPDeviceTypeCategoryVideo = 7;


    public static final int PPDeviceTypeCategoryBlockMiscellaneous = 999;
    public static final int PPDeviceTypeCategoryBlockAdminTools = 1999;
    public static final int PPDeviceTypeCategoryBlockAlarms = 2999;
    public static final int PPDeviceTypeCategoryBlockAnalytics = 3999;
    public static final int PPDeviceTypeCategoryBlockSafety = 4999;
    public static final int PPDeviceTypeCategoryBlockAudio = 5999;
    public static final int PPDeviceTypeCategoryBlockCameras = 6999;
    public static final int PPDeviceTypeCategoryBlockClimateControls = 7999;
    public static final int PPDeviceTypeCategoryBlockDisplays = 8999;
    public static final int PPDeviceTypeCategoryBlockEnvironmental = 9000;
    public static final int PPDeviceTypeCategoryBlockHealth = 10999;
    public static final int PPDeviceTypeCategoryBlockLightingStart = 11000;
    public static final int PPDeviceTypeCategoryBlockLighting = 11999;
    public static final int PPDeviceTypeCategoryBlockLocks = 12999;
    public static final int PPDeviceTypeCategoryBlockMedia = 13999;
    public static final int PPDeviceTypeCategoryBlockMeters = 14999;
    public static final int PPDeviceTypeCategoryBlockPerimeterMonitoring = 15999;
    public static final int PPDeviceTypeCategoryBlockRemoteControls = 16999;
    public static final int PPDeviceTypeCategoryBlockRobotics = 17999;
    public static final int PPDeviceTypeCategoryBlockRoutersAndGateways = 18999;
    public static final int PPDeviceTypeCategoryBlockSecurity = 19999;
    public static final int PPDeviceTypeCategoryBlockSensors = 20999;
    public static final int PPDeviceTypeCategoryBlockShades = 21999;
    public static final int PPDeviceTypeCategoryBlockSocial = 22999;
    public static final int PPDeviceTypeCategoryBlockSwitches = 23999;
    public static final int PPDeviceTypeCategoryBlockToys = 24999;
    public static final int PPDeviceTypeCategoryBlockTransportation = 25999;
    public static final int PPDeviceTypeCategoryBlockVideos = 26999;
    public static final int PPDeviceTypeCategoryBlockGateway = 18000;
    public static final int PPDeviceTypeCategoryBlockWater = 27999;
    public static final int PPDeviceTypeCategoryBlockAppliances = 28999;
    public static final int PPDeviceTypeCategoryBlockOther = 30000;
    public static final int PPDeviceTypeCategoryLocalMobileCamera = 1000000;


    public static final int INT_RULE_TRIGGER = 1;
    public static final int INT_RULE_STATE = 2;
    public static final int INT_RULE_ACTION = 3;
    public static final int INT_RULE_TRIGGER_SCHEDULE = 11;
    public static final int INT_RULE_TRIGGER_HOME_AWAY = 12;
    public static final int INT_RULE_TRIGGER_DEVICE_ACTION = 13;
    public static final int INT_RULE_TRIGGER_NEW_DEVICE_DATA = 14;

    public static final int INT_RULE_VALUE_SET = 1111;
    public static final int INT_RULE_SCHEDULE_SET_TIMER = 1112;
    public static final int INT_RULE_VALUE_CONTROL_CANCEL = 1126;
    public static final int INT_RULE_VALUE_SET_ONE = 1128;
    public static final int INT_RULE_VALUE_SET_TWO = 1129;
    public static final int INT_RULE_VALUE_SET_CONTINUE = 1111;
    public static final int INT_RULE_VALUE_SET_FINISH = 1112;
    public static final int INT_RULE_VALUE_SET_TIMEZONE = 1113;
    public static final int INT_RULE_MODE_SET = 1114;

    public static final int INT_RULE_STATE_GENERAL = 21;
    public static final int INT_RULE_STATE_HOME_AWAY = 22;
    public static final int INT_RULE_STATE_DEVICE_PARAM = 23;

    public static final int INT_RULE_STATE_SCHEDULE_SET = 2121;
    public static final int INT_RULE_STATE_SCHEDULE_CANCEL = 2122;
    public static final int INT_RULE_STATE_SCHEDULE = 2123;
    public static final int INT_RULE_STATE_SCHEDULE_START = 2124;
    public static final int INT_RULE_STATE_SCHEDULE_END = 2125;

    public static final int INT_RULE_VALUE_SET_ENUM = 2133;


    public static final int INT_RULE_ACTION_PUSH_NOTIFICATION = 31;
    public static final int INT_RULE_ACTION_EMAIL = 32;
    public static final int INT_RULE_ACTION_DEVICE_CMD = 33;
    public static final int INT_RULE_ACTION_HOME_AWAY = 34;
    public static final int INT_RULE_ACTION_CALL_CENTER = 35;

    public static final int INT_RULE_CATEGORY_INPUT = 1;
    public static final int INT_RULE_CATEGORY_CRON = 2;
    public static final int INT_RULE_CATEGORY_LOCATIONID = 4;
    public static final int INT_RULE_CATEGORY_DEVICEID = 5;
    public static final int INT_RULE_CATEGORY_EVENT = 9;
    public static final int INT_RULE_CATEGORY_ENUMERATION = 13;
    public static final int INT_RULE_CATEGORY_SELECT_ENUM = 15;

    //Edward: Firmware upgrade status code
    public static final int INT_FIRMWARE_UPDATE_APPROVED = 2;
    public static final int INT_FIRMWARE_UPDATE_DECLINED = 3;

    //Edward Monitor Step
    public static final int PPIAPOOBEMarkerSecurityDefault = 0;
    public static final int PPIAPOOBEMarkerSecuritySetupLocation = 1;
    public static final int PPIAPOOBEMarkerSecuritySetupUser = 2;
    public static final int PPIAPOOBEMarkerSecuritySetupContactA = 3;
    public static final int PPIAPOOBEMarkerSecuritySetupContactB = 4;
    public static final int PPIAPOOBEMarkerSecuritySetupFriend = 5;
    public static final int PPIAPOOBEMarkerSecuritySetupPassphrase = 6;
    public static final int PPIAPOOBEMarkerSecuritySetupNumericCode = 7;
    public static final int PPIAPOOBEMarkerSecuritySettings = 8;
    public static final int PPIAPOOBEMarkerSecurityComplete = 9;
    //Edward: AppInformation Access status code
    public static final int PPComposerAppAccessCategoryLocations = 1;
    public static final int PPComposerAppAccessCategoryDeviceFiles = 2;
    public static final int PPComposerAppAccessCategoryCallCenter = 3;
    public static final int PPComposerAppAccessCategoryDevices = 4;
    //Edward: AppInstance status code
    public static final int PPComposerAppInstanceStatusUndefined = -1;
    public static final int PPComposerAppInstanceStatusIncomplete = 0;
    public static final int PPComposerAppInstanceStatusActive = 1;
    public static final int PPComposerAppInstanceStatusInactive = 2;

    public static final int CALL_CENTER_DEFAULT_MIN_DEVICES = 2;

    public static final int INT_VIDEO_CALL_PUBLISHER = 1;
    public static final int INT_VIDEO_CALL_VIEVER = 2;
    public static final int INT_VIDEO_CALL_PRIMARY_STREAMER = 3;
    public static final int INT_VIDEO_CALL_SECONDARY_STREAMER = 4;

    public static final int INT_REQUEST_KUBI_CONNECT = 3111;
    public static final int INT_RESPONSE_KUBI_CONNECT_SUCESS = 3112;
    public static final int INT_REQUEST_ENABLE_BLUETOOTH = 3113;
    public static final int INT_REQUEST_CHANGE_SETTING_BEHAVIOR = 3213;
    public static final int INT_REQUEST_CHANGE_SETTING_CALLTREE = 3214;
    public static final int INT_REQUEST_CHANGE_SETTING_PASSCODE = 3215;
    public static final int INT_REQUEST_CHANGE_SETTING_PERMTID = 3216;
    public static final int INT_REQUEST_EDIT_LOCATION = 3217;
    public static final int INT_REQUEST_CHANGE_SETTING_PINCODE = 3218;
    public static final int INT_REQUEST_ADD_LOCATION = 3219;
    public static final int INT_REQUEST_EDIT_NAME = 3220;

    public static final int INT_TED_REGISTER_DONE = 3114;
    public static final int INT_SCENARIO_SETTING_DONE = 3115;
    public static final int INT_IAP_REDIRECT = 3116;
    public static final int INT_IAP_REDIRECT_DONE = 3117;
    public static final int INT_GET_PROUSER = 3118;
    public static final int INT_GET_PROVIDEO_DONE = 3119;
    public static final int INT_GET_PROSECURITY_DONE = 3120;
    public static final int INT_GET_NON_PROUSER = 3200;
    public static final int INT_CANCEL_SUBSRIPTION = 3201;
    public static final int INT_CANCEL_SUBSRIPTION_DONE = 3202;
    public static final int INT_CANCEL_SUBSRIPTION_FAIL = 3203;
    public static final int INT_ADD_CONTACT = 3204;
    public static final int INT_ADD_CONTACT_DONE = 3205;
    public static final int INT_SELECT_STATE = 3206;
    public static final int INT_SELECT_STATE_DONE = 3207;
    public static final int INT_RULE_SAVE_REQUEST = 3208;
    public static final int INT_RULE_SAVE_SUCCESS = 3209;
    public static final int INT_RESPONSE_P360_CONNECT_SUCESS = 3210;

    public static final int INT_REQUEST_ENABLE_GPS = 3211;
    public static final int INT_RULE_SAVE_SCHEDULE = 3212;

    public static final String ANDROID_PRO_COUNTDOWN_TIMER_TOTAL_SECS = "android-pro-countdown_timer_total_seconds";
    public static final String ANDROID_FREE_COUNTDOWN_TIMER_TOTAL_SECS = "android-free-countdown_timer_total_seconds";
    public static String ANDROID_TERMS_OF_SERVICE = "presence-tos";
    public static String ANDROID_TERMS_OF_SERVICE_KEY = "presence-tos-key";
    public static String BRAND_LOCATION_ACCESS;
    public static final String POST_FILE_CONTENT_LIMIT = "ppc.communityPostFile.contentLimit";
    public static final String POST_FILE_CONTENT_LIMIT_KEY = "PPCContentLimit-key";
    public static final String OOBE_PROPERTY_NAME_STANDARD = "user-standard.OOBEMarker";
    public static final String EVENT_TRACK_CLOUD_DATA_EXCEPTION = "ppc.ui.sandboxData";
    public static final String EVENT_TRACK_USER_DATA_EXCEPTION = "ppc.api.testData";
    public static final String EVENT_TRACK_BETA_DATA_EXCEPTION = "ppc.api.betaTestData";
    public static final String EVENT_TRACK_DISABLED = "family.event.track.disabled";
    public static final String APP_FABRIC_VERSION = "family.app.fabric.version";

    public static final String LOCAL_ASSETS_10014_DIR = "file:///android_asset/html/products/10014/thumbnail";
    public static final String LOCAL_ASSETS_10016_DIR = "file:///android_asset/html/products/10016/thumbnail";
    public static final String LOCAL_ASSETS_10017_DIR = "file:///android_asset/html/products/10017/thumbnail";
    public static final String LOCAL_ASSETS_10031_DIR = "file:///android_asset/html/products/10031/thumbnail";
    public static final String LOCAL_ASSETS_10032_DIR = "file:///android_asset/html/products/10032/thumbnail";

    public static final int SEC = 60;
    public static final int MIN = 60;
    public static final int HOUR = 24;
    public static final int DAY = 30;
    public static final int MONTH = 12;
    public static final int YEAR = 1;

    public static String IF;
    public static String THIS;
    public static String THAT;
    public static String THEN;
    public static final String BLANK = "____";
    public static final String BLANK_MIN = "____ minutes";
    public static final String BLANK_HOURS = "____ hours";
    public static final String TIME_MIN = "$minutes";
    public static final String TIME_HOUR = "$hours";
    public static final String EVENT = "$event";
    public static final String BLUE_LINE = "power cost";
    public static final String METER = "Meter";
    public static final String UNNAMED_DEVICE = "(unnamed device)";
    public static final String COMEHOME_GOAWAY = "I come home or go away";

    public static final String HOME_TO = "make my 'Home'";
    public static final String HOME_TO_DEFAULT = "make my MY 'Home'";
    //public static final String PUT_ME_IN_ACTION="put me into";
    public static final String GO_AWAY_DEFAULT = "go away";
    public static final String COME_HOME_DEFAULT = "come home";
    //public static final String I_GO="I go";
    public static final String TEMP_SENSOR = "temp";
    public static final String DEGC = "$degC";
    public static final String DEGCL = "$degCl";
    public static final String DEGCH = "$degCh";
    public static final String DEGF = "$degF";
    public static final String DEGFL = "$degFl";
    public static final String DEGFH = "$degFh";
    public static final String DEGREE = "$deg";
    public static final String BRIGHTNESS = "$currentLevel";
    public static final String HUMIDITY = "$humidity";
    public static final String COMMON_EVENT_TRIGGER = "Common event trigger";
    public static final String HOME_EVENT_TRIGGER = "Home event trigger";
    public static final String SCHEDULE_TRIGGER = "schedule trigger";
    public static final String AWAY_TRIGGER = "Away event trigger";
    public static final String CAMERA_TRIGGER = "Presence camera";
    public static final String LOCATION_EVENT_ACTION = "location event action";
    public static final String EVENT_STATE = "Event state";

    public static final int RULES_PARAMETER_CATEGORY_USER_INPUT = 1;
    public static final int RULES_PARAMETER_CATEGORY_CRON_EXPRESSION = 2;
    public static final int RULES_PARAMETER_CATEGORY_LOCATIONID = 4;
    public static final int RULES_PARAMETER_CATEGORY_DEVICEID = 5;
    public static final int RULES_PARAMETER_CATEGORY_DEVICE_PART_INDEX = 6;
    public static final int RULES_PARAMETER_CATEGORY_TIME = 7;
    public static final int RULES_PARAMETER_CATEGORY_DAYOFWEEK = 8;
    public static final int RULES_PARAMETER_CATEGORY_LOCATION_EVENT = 9;
    public static final int RULES_PARAMETER_CATEGORY_AUTOGEN_NOTIFICATION_TEXT = 10;

    public static final String BLUE_LINE_GUIDE_ANDROID = "http://www.presencepro.com/blue-line-computer";
    public static String SUPPORT_EMAIL = "support@peoplepowerco.com";
    public static String DEFAULT_SERVER_URL = "https://app.presencepro.com";
    
    public static final int NONE = 0;
    public static final int SYSTEM_GET_VIDEO = 1;
    public static final int SYSTEM_GET_FRIST_TIME_VIDEO = 2;
    public static final int SYSTEM_GET_NEXT_VIDEO = 3;
    public static final int SYSTEM_GET_OLD_VIDEO = 4;
    public static final int USER_FAV_ACTION = 5;
    public static final int USER_VIDEO_VIEW_ACTION = 6;
    public static final int USER_CANCEL_ACTION = 7;
    public static final int USER_DELETE_ACTION = 8;
    public static final int USER_SHARE_ACTION = 9;
    public static final int USER_OPTION_BUTTON_ACTION = 10;
    public static final int USER_DOWNLOAD_ACTION = 11;
    public static final int USER_VIDEOBAR_CLICK_ACTION = 12;
    public static final int USER_TIMELINE_SCROLL_ACTION = 13;
    public static final int USER_RECOVER_VIDEO_PIC = 14;

    // New Icons
    // Common
    public static final String ICON_DEFAULT = "\uEA4D";
    public static final String ICON_PRESENCE = "\uEA4D";

    public static final String ICON_CAMERA = "\uEA6A";

    public static final String ICON_VIDEO = "\uEA6D";

    public static final String ICON_STORE = "\uEA5D";

    public static final String ICON_SETTINGS = "\uEA58";

    public static final String ICON_GROUPS = "\uEA31";

    public static final String ICON_CHALLENGES = "\uEA18";

    public static final String ICON_RULES = "\uEA55";
    public static final String ICON_FRIENDS = "\uEA2C";

    public static final String ICON_POINTS_1 = "\uEA36";
    public static final String ICON_POINTS_2 = "\uEA37";
    public static final String ICON_POINTS_3 = "\uEA38";
    public static final String ICON_POINTS_4 = "\uEA39";
    public static final String ICON_POINTS_5 = "\uEA3A";
    public static final String ICON_LEVEL_1 = "\uEA36";
    public static final String ICON_LEVEL_2 = "\uEA37";
    public static final String ICON_LEVEL_3 = "\uEA38";
    public static final String ICON_LEVEL_4 = "\uEA39";
    public static final String ICON_LEVEL_5 = "\uEA3A";

    public static final String ICON_GET_PRO = "\uEA2F";

    // Settings
    public static final String ICON_SIGN_OUT = "\uEA5A";

    public static final String ICON_ACCOUNT_INFO = "\uEA04";
//	public static final String ICON_USER_ADMIN = "\uEA04";

    public static final String ICON_VIDEO_SETTINGS = "\uEA6C";
    public static final String ICON_GEOFENCING = "\uEA2E";


    public static final String ICON_RATE = "\uEA5B";


    public static final String ICON_HELP = "\uEA32";

    public static final String ICON_FAQ = "\uEA23";
    public static final String ICON_FEEDBACK_FEATURE = "\uEA26";

    public static final String ICON_FEEDBACK_BUG = "\uEA24";

    public static final String ICON_FEEDBACK_PRO = "\uEA27";

    public static final String ICON_FEEDBACK = "\uEA28";


    public static final String ICON_TERMS = "\uEA5F";


    public static final String ICON_PRIVATE = "\uEA3B";

    public static final String ICON_ABOUT = "\uEA34";

    public static final String ICON_YOUTUBE = "\uEA70";

    public static final String ICON_FACEBOOK = "\uEA22";
//	public static final String ICON_FA_FACEBOOK = "\uEA22";

    public static final String ICON_TWITTER = "\uEA66";
//	public static final String ICON_FA_TWITTER = "\uEA66";

    public static final String ICON_DELETE = "\uEA1C";

    public static final String ICON_REPLAY = "\uEA53";

    public static final String ICON_RECOVER = "\uEA51";

    public static final String ICON_MESSAGE = "\uEA3D";

    public static final String ICON_PHONE = "\uEA47";
//	public static final String ICON_FA_PHONE = "\uEA47";

    public static final String ICON_TIMEZONE = "\uEA64";

    public static final String ICON_TIME = "\uEA61";
//	public static final String ICON_TIME_FORMAT = "\uEA61";

    public static final String ICON_PASSWARD = "\uEA44";

    public static final String ICON_CONTACT = "\uEA1B";

    public static final String ICON_SEARCH = "\uEA56";

    public static final String ICON_QRCODE = "\uEA4E";

    public static final String ICON_ADMIN = "\uEA07";

    public static final String ICON_ADMIN_SYSTEM = "\uEA06";

    public static final String ICON_ADMIN_SUPER = "\uEA05";

    public static final String ICON_USER = "\uEA68";

    public static final String ICON_POLICE = "\uEA71";


    public static final String ICON_DEVICE_GATEWAY = "\uEA2D";

    public static final String ICON_DEVICE_BULB = "\uEA0E";

    public static final String ICON_DEVICE_CAMERA_ANDROID = "\uEA11";
//	public static final String ICON_CAMERA_ANDROID = "\uEA11";

    public static final String ICON_DEVICE_CAMERA_GALILEO = "\uEA12";
//	public static final String ICON_CAMERA_GALILEO = "\uEA12";

    public static final String ICON_DEVICE_CAMERA_IOS = "\uEA13";
//	public static final String ICON_CAMERA_IOS = "\uEA13";

    public static final String ICON_DEVICE_CAMERA_KUBI = "\uEA14";
//	public static final String ICON_CAMERA_KUBI = "\uEA14";

    public static final String ICON_DEVICE_CAMERA_P360 = "\uEA7C";
//	public static final String ICON_360 = "\uEA7C";

    public static final String ICON_DEVICE_CAMERA_IP = "\uEA45";
//	public static final String ICON_CAMERA_IP = "\uEA45";

    public static final String ICON_DEVICE_CAMERA = "\uEA16";
//	public static final String ICON_FA_CAMERA = "\uEA16";

    public static final String ICON_DEVICE_DRYER = "\uEA1E";
//	public static final String ICON_DRYER = "\uEA1E";

    public static final String ICON_DEVICE_METER = "\uEA3E";

    public static final String ICON_DEVICE_MOTION = "\uEA42";
//	public static final String ICON_MOTION = "\uEA42";

    public static final String ICON_DEVICE_PLUG = "\uEA4A";
//	public static final String ICON_PLUG = "\uEA4A";

    public static final String ICON_DEVICE_TEMPERATURE = "\uEA5E";
//	public static final String ICON_TEMPERATURE = "\uEA5E";

    public static final String ICON_DEVICE_THERMOSTAT = "\uEA60";
//	public static final String ICON_THERMOSTAT = "\uEA60";

    public static final String ICON_DEVICE_TEMPERATURE_HUMIDITY = "\uEA8F";
//	public static final String ICON_CONDITION = "\uEA8F";

    public static final String ICON_DEVICE_TOUCH = "\uEA65";
//	public static final String ICON_TOUCH = "\uEA65";

    public static final String ICON_DEVICE_WATER = "\uEA6F";
//	public static final String ICON_WATER = "\uEA6F";

    public static final String ICON_DEVICE_HUMIDITY = "\uEA33";
//	public static final String ICON_HUMIDITY = "\uEA33";

    public static final String ICON_DEVICE_ENTRY = "\uEA21";
//	public static final String ICON_ENTRY = "\uEA21";


    public static final String ICON_DEVICE_HEALTH = "\uEA20";

    public static final String ICON_DEVICE_SWITCH = "\uEA74";
//	public static final String ICON_SWITCH = "\uEA74";


    public static final String ICON_DEVICE_SIREN = "\uEA78";

    public static final String ICON_DEVICE_HEALTHY_COACH = "\uEA86";
//	public static final String ICON_AIR = "\uEA86";

    public static final String ICON_DEVICE_WEATHER_STATION = "\uEA87";
//	public static final String ICON_WEATHER = "\uEA87";

    public static final String ICON_DEVICE_HUMIDITY_TEMP = "\uEA91";
//	public static final String ICON_TEMP_HUMIDITY = "\uEA91";

    public static final String ICON_DEVICE_TOUCH_PAD = "\uEA90";
//	public static final String ICON_TOUCHPAD = "\uEA90";

    public static final String ICON_CAMERA_TOUCH_PAD_BUTTON = "\uEA77";
//	public static final String ICON_KEYPAD = "\uEA77";

    public static final String ICON_DEVICE_LOCK = "\uEA3B";

    public static final String ICON_RULE_PHONE_ALERT = "\uEA46";
//	public static final String ICON_PHONE_ALERT = "\uEA46";

    public static final String ICON_RULE_EMAIL_ALERT = "\uEA3C";
//	public static final String ICON_MESSAGES_ALERT = "\uEA3C";

    public static final String ICON_RULE_MODE = "\uEA40";

    public static final String ICON_RULE_CALENDAR = "\uEA73";

    public static final String ICON_RULE_TIMER = "\uEA63";

    public static final String ICON_OPTIONS_CAMERA_NAME = "\uEA15";

    public static final String ICON_OPTIONS_FLASHLIGHT_OFF = "\uEA29";
//	public static final String ICON_FLASHLIGHT_OFF = "\uEA29";

    public static final String ICON_OPTIONS_FLASHLIGHT_ON = "\uEA2A";

    public static final String ICON_OPTIONS_REMOTE = "\uEA52";
//	public static final String ICON_REMOTE = "\uEA52";

    public static final String ICON_OPTIONS_MOTION_RECORDING = "\uEA41";
//	public static final String ICON_MOTION_RECORDING = "\uEA41";

    public static final String ICON_TEST = "\uEA42";

    public static final String ICON_OPTIONS_RECORDING_TIME = "\uEA4F";
//	public static final String ICON_RECORDING_TIME = "\uEA4F";

    public static final String ICON_OPTIONS_RECORD_MAX = "\uEA50";

    public static final String ICON_OPTIONS_TIME_BETWEEN = "\uEA62";
    //ICON_FA_STOPWATCH

    public static final String ICON_OPTIONS_SENSITY = "\uEA57";
//	public static final String ICON_SENSITIVITY = "\uEA57";

    public static final String ICON_OPTIONS_COUNTDOWN = "\uEA4F";
//	public static final String ICON_RECORDING_TIMEN = "\uEA4F";

    public static final String ICON_OPTIONS_ALLOW_VIDEO = "\uEA6A";

    public static final String ICON_OPTIONS_ALLOW_MIC = "\uEA3F";

    public static final String ICON_OPTIONS_PRIVACY_TEXT = "\uEA3B";

    public static final String ICON_OPTIONS_ALLOW_VOLUME = "\uEA6E";

    public static final String ICON_STAR = "\uEA5B";


    public static final String ICON_WORLD = "\uEA30";

    public static final String ICON_CIRCLE_X = "\uEA35";

    public static final String ICON_FLASHLIGHT = "\uEA2A";

    public static final String ICON_BULB = "\uEA0E";

    public static final String ICON_SENSIBO_SKY = "\uEA8E";
//	public static final String ICON_AC = "\uEA8E";

    //Code and Password for keypad
    public static final String ICON_CIRCLE_PASSWORD = "\uEA82";
//	public static final String ICON_KEY_CIRCLE = "\uEA82";

    public static final String ICON_CIRCLE_CODE = "\uEA83";
//	public static final String ICON_KEYPAD_CIRCLE = "\uEA83";


    public static final String ICON_CLEAR = "\uEA35";

    public static final String ICON_BACK = "\uEA0B";

    //modes
    public static final String ICON_MODE_HOME = "\uEA76";
//	public static final String ICON_FA_HOME = "\uEA76";

    public static final String ICON_MODE_AWAY = "\uEA75";
//	public static final String ICON_AWAY = "\uEA75";

    public static final String ICON_MODE_SLEEP = "\uEA79";
//	public static final String ICON_SLEEP = "\uEA79";

    public static final String ICON_MODE_VACATION = "\uEA7B";
//	public static final String ICON_VACATION = "\uEA7B";

    public static final String ICON_MODE_STAY = "\uEA8A";
//	public static final String ICON_STAY = "\uEA8A";

    public static final String ICON_MODE_TEST = "\uEA7A";
//	public static final String ICON_FONT_TEST = "\uEA7A";

    public static final String ICON_MODE_FILL = "\uEA88";

    public static final String ICON_MODE_NOFILL = "\uEA89";

    public static final String ICON_SOUND_OFF = "\uEA84";
//	public static final String ICON_MUTE_CIRCLE = "\uEA84";

    public static final String ICON_SOUND_ON = "\uEA85";
//	public static final String ICON_UNMUTE_CIRCLE = "\uEA85";

    //Monitor Call Tree
    public static final String ICON_CONTACT_ADD = "\uEA72";
//	public static final String ICON_USER_ADD = "\uEA72";

    //Firmware update jobs
    public static final String ICON_FIRMWARE_JOBS = "\uEA7A";
//    public static final String ICON_TEST = "\uEA7A";


    public static final String ICON_DEVICE_HISTORY = "\uEA1D";
    //	public static final String ICON_FA_HISTORY;

    public static final String ICON_AUTOMATE = "\uEA0A";
//	ICON_FA_SLIDERS_H

    public static final String ICON_LEAF = "\uEA8B";

    public static final String ICON_HOME_NEW = "\uEA93";

    public static final String ICON_AWAY_NEW = "\uEA92";

    //IOT Icons
    public static final String ICON_PUSH_BUTTON = "\uEA02";


    //Rate this app value
    public static final int USER_DEFAULT_RATE_RESET_MIN_REJECT_DAYS = 90;
    public static final int USER_DEFAULT_RATE_RESET_MIN_DAYS = 30;
    public static final int USER_DEFAULT_RATE_APP_OPEN_FREQUENCY_RANGE = 7;
    public static final int USER_DEFAULT_RATE_APP_OPEN_FREQUENCY_COUNT = 10;
    public static final int USER_DEFAULT_RATE_CAMERA_STREAM_FREQUENCY_RANGE = 7;
    public static final int USER_DEFAULT_RATE_CAMERA_STREAM_FREQUENCY_MIN = 10;
    public static final int USER_DEFAULT_RATE_CAMERA_STREAM_FREQUENCY_MAX = 100;
    public static final int USER_DEFAULT_RATE_USER_TOTALS_MIN = 10;
    public static final int RATE_APP_SEQUENCE_DEFAULT = 0;
    public static final int RATE_APP_SEQUENCE_PALYSTORE = 1;
    public static final int RATE_APP_SEQUENCE_FEEDBACK = 2;
    public static final int RATE_APP_SEQUENCE_MESSAGE = 3;
    public static final int RATE_APP_SEQUENCE_DONE = 4;

    public static final int PPSMSSubscriberStatusNone = 0;
    public static final int PPSMSSubscriberStatusSubscribed = 1;
    public static final int PPSMSSubscriberStatusOptOut = 2;

    public static final int PPSMSSubscriberCategoryMeOnly = 0;
    public static final int PPSMSSubscriberCategoryGeneralFriends = 1;
    public static final int PPSMSSubscriberCategoryFamilyAndCaregivers = 2;

    //Rate this key (use with user id)
    public static final String APP_RATING_REJECT_DATE = "RatingRejectDate";
    public static final String APP_RATING_DATE = "RatingDate";
    public static final String APP_STARTING_DATE = "StaringDate";
    public static final String APP_OPEN_FREQUENCY = "AppOpenFrequency";
    public static final String CAMERA_STREAM_FREQUENCY = "CameraStreamFrequency";
    public static String APP_PRO_SECURITY_BUNDLE = "com.ppc.ProSecurity";
    public static String APP_INFO_BUNDLE = "com.ppc.ProSecurity";

    public static final String MONITOR_SERVICE_PHONE_NUMBER = "";
    public static final String MONITOR_SUPPORT_PHONE_NUMBER = "";

    //Badge type
    public static final int TYPE_MESSAGE = 1;
    public static final int TYPE_CHALLENGE = 2;
    public static final int TYPE_MOTION = 3; // motion detection device alert
    public static final int TYPE_NEW_DEVICE = 4;
    public static final int TYPE_FRIENDS = 5;
    public static final int TYPE_CIRCLE = 6;

    // Device actions constant
    public static final int SERVER_GET_INTERVAL_MS = 3000;
    public static final int PAIRING_INTERVAL_MS = 1000 * 60;
    // Notification DB Helper
    private static PPNotificationDBHelper m_notificationDBHelper = null;

    // PP Font Icon Names
    public static final String PP_ICON_2WAY_VIDEO = "2way-video";
    public static final String PP_ICON_50MB_STORAGE = "50mb-storage";
    public static final String PP_ICON_5GB_STORAGE = "5gb-storage";
    public static final String PP_ICON_ACCOUNT_INFO = "account-info";
    public static final String PP_ICON_ADMIN_SUPER = "admin-super";
    public static final String PP_ICON_ADMIN_SYSTEM = "admin-system";
    public static final String PP_ICON_ADMIN = "admin";
    public static final String PP_ICON_ALARM = "alarm";
    public static final String PP_ICON_ANONYMOUS = "anonymous";
    public static final String PP_ICON_AUTOMATE = "automate";
    public static final String PP_ICON_BACK = "back";
    public static final String PP_ICON_BLOCKED = "blocked";
    public static final String PP_ICON_BUDGET = "budget";
    public static final String PP_ICON_BULB = "bulb";
    public static final String PP_ICON_BULLET_ACTIVE = "bullet-active";
    public static final String PP_ICON_BULLET = "bullet";
    public static final String PP_ICON_CAMERA_ANDROID = "camera-android";
    public static final String PP_ICON_CAMERA_GALILEO = "camera-galileo";
    public static final String PP_ICON_CAMERA_IOS = "camera-ios";
    public static final String PP_ICON_CAMERA_KUBI = "camera-kubi";
    public static final String PP_ICON_CAMERA_P360 = "camera-p360";
    public static final String PP_ICON_CAMERA_NAME = "camera-name";
    public static final String PP_ICON_CAMERA = "camera";
    public static final String PP_ICON_CHALLENGES_ALERT = "challenges-alert";
    public static final String PP_ICON_CHALLENGES = "challenges";
    public static final String PP_ICON_CHECKBOX_ACTIVE = "checkbox-active";
    public static final String PP_ICON_CHECKBOX = "checkbox";
    public static final String PP_ICON_CONTACTS = "contacts";
    public static final String PP_ICON_DELETE = "delete";
    public static final String PP_ICON_DEVICE_HISTORY = "device-history";
    public static final String PP_ICON_DRYER = "dryer";
    public static final String PP_ICON_CALL_CENTER = "call-center";
    public static final String PP_ICON_EMERGENCY = "emergency";
    public static final String PP_ICON_ENTRY = "entry";
    public static final String PP_ICON_FACEBOOK = "facebook";
    public static final String PP_ICON_FAQ = "faq";
    public static final String PP_ICON_FEEDBACK_BUG = "feedback-bug";
    public static final String PP_ICON_FEEDBACK_CROWD = "feedback-crowd";
    public static final String PP_ICON_FEEDBACK_FEATURE = "feedback-feature";
    public static final String PP_ICON_FEEDBACK_PRO = "feedback-pro";
    public static final String PP_ICON_FEEDBACK = "feedback";
    public static final String PP_ICON_FLASHLIGHT_OFF = "flashlight-off";
    public static final String PP_ICON_FLASHLIGHT = "flashlight";
    public static final String PP_ICON_FLIP_CAMERA = "flip-camera";
    public static final String PP_ICON_FRIENDS = "friends";
    public static final String PP_ICON_GATEWAY = "gateway";
    public static final String PP_ICON_GEOFENCING = "geofencing";
    public static final String PP_ICON_GET_PRO = "get-pro";
    public static final String PP_ICON_GLOBE = "globe";
    public static final String PP_ICON_GROUPS = "groups";
    public static final String PP_ICON_HELP = "help";
    public static final String PP_ICON_HUMIDITY = "humidity";
    public static final String PP_ICON_INFO = "info";
    public static final String PP_ICON_INVALID = "invalid";
    public static final String PP_ICON_LEVEL_1 = "level-1";
    public static final String PP_ICON_LEVEL_2 = "level-2";
    public static final String PP_ICON_LEVEL_3 = "level-3";
    public static final String PP_ICON_LEVEL_4 = "level-4";
    public static final String PP_ICON_LEVEL_5 = "level-5";
    public static final String PP_ICON_LOCK = "lock";
    public static final String PP_ICON_MESSAGES_ALERT = "messages-alert";
    public static final String PP_ICON_MESSAGES = "messages";
    public static final String PP_ICON_METER = "meter";
    public static final String PP_ICON_MIC = "mic";
    public static final String PP_ICON_MODE = "mode";
    public static final String PP_ICON_HOME = "home";
    public static final String PP_ICON_AWAY = "away";
    public static final String PP_ICON_VACATION = "vacation";
    public static final String PP_ICON_SLEEP = "sleep";
    public static final String PP_ICON_TEST = "test";
    public static final String PP_ICON_MOTION_RECORDING = "motion-recording";
    public static final String PP_ICON_MOTION = "motion";
    public static final String PP_ICON_NOTIFICATION_SETTINGS = "notification-settings";
    public static final String PP_ICON_PASSWORD = "password";
    public static final String PP_ICON_PHONE_ALERT = "phone-alert";
    public static final String PP_ICON_PHONE = "phone";
    public static final String PP_ICON_PICTURE = "picture";
    public static final String PP_ICON_PILL = "pill";
    public static final String PP_ICON_PLUG = "plug";
    public static final String PP_ICON_POINTS = "points";
    public static final String PP_ICON_PRESENCE_PRO = "presence-pro";
    public static final String PP_ICON_PRESENCE = "presence";
    public static final String PP_ICON_QR_CODE = "qr-code";
    public static final String PP_ICON_RECORDING_TIME = "recording-time";
    public static final String PP_ICON_RECORDING = "recording";
    public static final String PP_ICON_RECOVER = "recover";
    public static final String PP_ICON_REMOTE = "remote";
    public static final String PP_ICON_REPLAY = "replay";
    public static final String PP_ICON_RIGHT_ARROW = "right-arrow";
    public static final String PP_ICON_RULES = "rules";
    public static final String PP_ICON_SEARCH = "search";
    public static final String PP_ICON_SENSITIVITY = "sensitivity";
    public static final String PP_ICON_SETTINGS = "settings";
    public static final String PP_ICON_SHARE_ALERTS = "share-alerts";
    public static final String PP_ICON_SIGN_OUT = "sign-out";
    public static final String PP_ICON_STAR = "star";
    public static final String PP_ICON_STICKER = "sticker";
    public static final String PP_ICON_STORE = "store";
    public static final String PP_ICON_TEMPERATURE = "temperature";
    public static final String PP_ICON_TERMS = "terms";
    public static final String PP_ICON_THERMOSTAT = "thermostat";
    public static final String PP_ICON_TIME_FORMAT = "time-format";
    public static final String PP_ICON_TIME = "time";
    public static final String PP_ICON_TIMER = "timer";
    public static final String PP_ICON_TIMEZONE = "timezone";
    public static final String PP_ICON_TOUCH = "touch";
    public static final String PP_ICON_TWITTER = "twitter";
    public static final String PP_ICON_USER_BACK = "user-back";
    public static final String PP_ICON_USER = "user";
    public static final String PP_ICON_VALID = "valid";
    public static final String PP_ICON_VIDEO_ALLOW = "video-allow";
    public static final String PP_ICON_VIDEO_QUALITY = "video-quality";
    public static final String PP_ICON_VIDEO_SETTINGS = "video-settings";
    public static final String PP_ICON_VIDEO = "video";
    public static final String PP_ICON_VOLUME = "volume";
    public static final String PP_ICON_WATER = "water";
    public static final String PP_ICON_YOUTUBE = "youtube";
    public static final String PP_ICON_POLICE = "police";
    public static final String PP_ICON_USER_ADD = "user-add";
    public static final String PP_ICON_CALENDAR = "calendar";
    public static final String PP_ICON_CAMERA_IP = "camera-ip";
    public static final String PP_ICON_SWITCH = "switch";
    public static final String PP_ICON_KEYPAD = "keypad";
    public static final String PP_ICON_SIREN = "siren";
    public static final String PP_ICON_ARROW_DOWN = "arrow-down";
    public static final String PP_ICON_ARROW_LEFT = "arrow-left";
    public static final String PP_ICON_ARROW_RIGHT = "arrow-right";
    public static final String PP_ICON_ARROW_UP = "arrow-up";
    public static final String PP_ICON_FINGERPRINT_CIRCLE = "fingerprint-circle";
    public static final String PP_ICON_KEY_CIRCLE = "key-circle";
    public static final String PP_ICON_KEYPAD_CIRCLE = "keypad-circle";
    public static final String PP_ICON_MUTE_CIRCLE = "mute-circle";
    public static final String PP_ICON_UNMUTE_CIRCLE = "unmute-circle";
    public static final String PP_ICON_AIR = "air";
    public static final String PP_ICON_WEATHER = "weather";
    public static final String PP_ICON_CIRCLE_FILLED = "circle-filled";
    public static final String PP_ICON_CIRCLE_NO_FILL = "circle-nofill";
    public static final String PP_ICON_STAY = "stay";
    public static final String PP_ICON_LEAF = "leaf";
    public static final String PP_ICON_NOISE = "noise";
    public static final String PP_ICON_PRESSURE = "pressure";
    public static final String PP_ICON_AC = "ac";
    public static final String PP_ICON_CONDITION = "condition";
    public static final String PP_ICON_TOUCHPAD = "touchpad";
    public static final String PP_ICON_TEMP_HUMIDITY = "temp-humidity";
    public static final String PP_ICON_AWAY_NEW = "away-new";
    public static final String PP_ICON_HOME_NEW = "home-new";
    public static final String PP_ICON_STAY_NEW = "stay-new";
    public static final String PP_ICON_TEST_NEW = "test-new";
    public static final String PP_ICON_SECURITY_SETTINGS = "security-settings";
    public static final String PP_ICON_SECURITY = "security";

    public static final int CELL_DEFAULT_SLIDER_MIN = 0;
    public static final int CELL_DEFAULT_SLIDER_MAX = 100;
    public static final int CELL_DEFAULT_SLIDER_MAX_TIME = 3600;
    public static final int CELL_DEFAULT_SLIDER_INC = 5;
    public static final int CELL_DEFAULT_SLIDER_INC_TIME = 15;

    public static final String GEOFENCING_BOT_BUNDLE = "com.ppc.Geofencing";
    public static final String QUESTIONS_BOT_BUNDLE = "com.ppc.Questions";

    public static final String LOCATION_STATE_SECURITY_STATE = "security_state";
    public static final String LOCATION_STATE_SOCIAL_CONNECTOR = "social_connector";
    public static final String LOCATION_STATE_PROPERTIES = "location_properties";
    public static final String LOCATION_STATE_BEHAVIORS = "behaviors";
    public static final String LOCATION_STATE_DEVICE_BUNDLES = "device_bundles";
    public static final String LOCATION_STATE_DASHBOARD = "dashboard";
    public static final String LOCATION_STATE_DASHBOARD_HEADER = "dashboard_header";
    public static final String LOCATION_STATE_TASKS = "tasks";
    public static final String LOCATION_STATE_NOW = "now";
    public static final String LOCATION_STATE_SERVICES = "services";
    public static final String LOCATION_STATE_REPORTS = "dailyreport";
    public static final String LOCATION_STATE_UPDATE_DEVICEBUNDLE = "update_device_bundles";
    public static final String LOCATION_STATE_TIMESERIES_PROPERTIES = "timeseries_properties";
    public static final String LOCATION_STATE_CONVERSION_RESOLVED = "conversation_resolved";
    public static final String LOCATION_STATE_CONTACT_ECC = "contact_ecc";
    public static final String LOCATION_STATE_USER_ACTIVITY = "user_activity";

    //The IoT Software Suite supports following notification types:
    public static final int NOTIFICATION_ALLOW_TO_UNSUBSCRIBE = 0;
    public static final int NOTIFICATION_MARKETING_MESSAGES = 1;
    public static final int NOTIFICATION_DEVICE_SHARING = 2;
    public static final int NOTIFICATION_RULES = 3;
    public static final int NOTIFICATION_BOTS = 4;
    public static final int NOTIFICATION_QUESTIONS = 5;
    public static final int NOTIFICATION_USER_ACCOUNT_CREATION_FOLLOW_UP = 6;
    public static final int NOTIFICATION_DEVICE_ALERTS = 7;
    public static final int NOTIFICATION_BY_API_CALL = 8;
    public static final int NOTIFICATION_IN_APP_MESSAGE = 9;
    public static final int NOTIFICATION_NEW_DEVICE_ADD = 10;
    public static final int NOTIFICATION_ACCOUNT_ISSUES = 11;
    public static final int NOTIFICATION_ADDING_FRIENDS = 12;
    public static final int NOTIFICATION_BY_API_CALL_FROM_OAUTH_CLIENT = 13;
    public static final int NOTIFICATION_ADDING_CIRCLE_MEMBERS = 15;
    public static final int NOTIFICATION_DEVICE_FIRMWARE_UPDATE = 16;
    public static final int NOTIFICATION_SMS_SUBSCRIPTION = 17;
    public static final int NOTIFICATION_ERRORS_WITH_OAUTH_APPS = 18;
    public static final int NOTIFICATION_BOTS_ERRORS_TO_DEVELOPERS = 19;
    public static final int NOTIFICATION_APP_BADGE_CHAGNE = 20;
    public static final int NOTIFICATION_COMMUNITIES = 21;

    //Storybook hidden type
    public static final int INT_DEVICETYPE_DEVICEMODEL_HIDDEN_NONE = -1;
    public static final int INT_DEVICETYPE_DEVICEMODEL_HIDDEN_FALSE = 0;
    public static final int INT_DEVICETYPE_DEVICEMODEL_HIDDEN_TRUE = 1;
    //Storybook Pair Type
    public static final int PAIR_TYPE_NONE = -1;
    public static final int PAIR_TYPE_LINK_APP = 0;
    public static final int PAIR_TYPE_SCAN_QRCODE = 1;
    public static final int PAIR_TYPE_NATIVE = 2;
    public static final int PAIR_TYPE_OAUTH = 4;
    public static final int PAIR_TYPE_ZIGBEE = 8;
    public static final int PAIR_TYPE_WIFI = 16;
    public static final int PAIR_TYPE_GENERATE_QRCODE = 32;
    //Storybook Story Type
    public static final int STORY_TYPE_NONE = 0;
    public static final int STORY_TYPE_CONNECT_DEVICE = 1;
    public static final int STORY_TYPE_CONNECTED_SUCCESS = 2;
    public static final int STORY_TYPE_CONNECT_FAILED = 3;
    public static final int STORY_TYPE_INSTALLATION_HELPER = 4;
    public static final int STORY_TYPE_PAID_SERVICE = 5;
    public static final int STORY_TYPE_SCENARIOS = 6;
    public static final int STORY_TYPE_PROMOTIONS = 7;
    public static final int STORY_TYPE_LINKOTHER = 8;
    public static final int STORY_TYPE_BOT = 10;
    public static final int STORY_TYPE_RECONNECTION_DISCONNECT = 11;
    public static final int STORY_TYPE_RECONNECTION_BATTERY = 12;
    public static final int STORY_TYPE_RECONNECTION_WIFI = 13;
    public static final int STORY_TYPE_OAUTH_FAILED = 21;
    public static final int STORY_TYPE_OAUTH_SUCCESS = 20;
    public static final int STORY_TYPE_FAQ = 30;
    public static final int STORY_TYPE_TERMS_SERVICES = 40;
    public static final int STORY_TYPE_PRIVACY_POLICY = 41;
    public static final int STORY_TYPE_MONITORING_SERVICES = 42;
    public static final int STORY_TYPE_COOKIES_SERVICES = 43;
    public static final int STORY_TYPE_MANUFACTURER_DEVELOPER_TERMS_CONDITIONS = 44;
    public static final int STORY_TYPE_CONSENT_TO_PARTICIPATE = 45;
    public static final int STORY_TYPE_HIPAA_STATEMENT = 46;
    public static final int STORY_TYPE_ONBORADING_FIST_TIME_STORIES = 50;
    public static final int STORY_TYPE_ONBOARDING_PAYWALL_STORIES = 51;
    public static final int STORY_TYPE_ONBOARDING_NEW_STORIES = 52;

    //Storybook MediaType
    public static final int MEDIA_TYPE_VIDEO = 1;
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_AUDIO = 3;
    public static final int MEDIA_TYPE_TEXT = 6;
    //Storybook ActionType
    public static final int ACTION_TYPE_LINK_NONE = 0;
    public static final int ACTION_TYPE_LINK_STORY = 1;
    public static final int ACTION_TYPE_IN_APP_LINK = 2;
    public static final int ACTION_TYPE_MAKE_PHOTO = 3;
    public static final int ACTION_TYPE_RECORD_VIDEO = 4;
    public static final int ACTION_TYPE_OPEN_CONTACTS = 5;
    public static final int ACTION_TYPE_IP_CAMERA = 6;
    public static final int ACTION_TYPE_CONTACT_HELP = 7;
    public static final int ACTION_TYPE_QRCODE_SCANNER = 8;

    //Storybook ActionStyle
    public static final int ACTION_STYLE_TYPE_NEXT = 0;
    public static final int ACTION_STYLE_TYPE_BUTTON = 1;
    public static final int ACTION_STYLE_TYPE_LINK = 2;
    public static final int ACTION_STYLE_TYPE_SHOWIT = 3;

    //Permission
    public static final int REQUEST_PERMISSIONS = 0;
    public static final int REQUEST_READ_PHONE_STATE = 1;
    public static final int REQUEST_CAMERA = 2;
    public static final int REQUEST_RECORD_AUDIO = 3;
    public static final int REQUEST_READ_CONTACTS = 4;
    public static final int REQUEST_WRITE_CONTACTS = 5;
    public static final int REQUEST_ACCESS_FINE_LOCATION = 6;
    public static final int REQUEST_ACCESS_FINE_LOCATION_SETTINGS = 7;
    public static final int REQUEST_ACCESS_FINE_LOCATION_SETTINGS_TOGGLE = 8;
    public static final int REQUEST_SMS = 9;
    public static final int REQUEST_WRITE_SETTINGS = 10;
    public static final int REQUEST_CAMERA_SCAN = 11;
    public static final int REQUEST_FILE_ACCESS = 12;
    public static final int REQUEST_ACCESS_COARSE_LOCATION = 13;
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE = 14;
    public static final int REQUEST_READ_EXTERNAL_STORAGE = 15;
    public static final int REQUEST_PHONE_CALL = 16;

    public static final int REQUEST_IN_APP_LINK = 0x1001;

    public static boolean bPermissionDialog = false;

    public static final String REFERENCE_KEY_SHOW_BUNDLE = "CRIsShowingBundlePage";
    public static final String REFERENCE_KEY_BUNDLE_STATUS = "CRBundlePageStatus";
    public static final String REFERENCE_KEY_BUNDLE_DEVICES = "CRBundlePageDevices";
    public static final String REFERENCE_KEY_SHOW_TUTORIAL = "CRTutorialOverlapShowed";
    public static final String REFERENCE_KEY_SHOW_TUTORIAL_COMMUNITY = "CRCommunityOverlapShowed";
    public static final String REFERENCE_KEY_APP_TIMES = "CRAPPOpenedTimes";
    public static final String REFERENCE_KEY_SURVEY_TIME = "CRAPPSurveyAnswerTime";
    public static final String REFERENCE_KEY_CURRENT_BUNDLE = "CRCurrentBundleId";
    public static final String REFERENCE_KEY_IS_USER_ADMIN = "CRIsUserAdminUser";
    public static final String REFERENCE_KEY_USER_LOGIN_PHONE = "CRUserPhone";
    public static final String REFERENCE_KEY_COUNTRY_CODE = "CRCountryRegion";
    public static final String REFERENCE_KEY_COUNTRY_CODE_INDEX = "CRCountryRegionIndex";
    public static final String REFERENCE_KEY_REPORT_TIME = "CRDailyReportTime";
    public static final String REFERENCE_KEY_HIDE_SUBSCRIPTION = "CRHideSubscription";
    public static final String REFERENCE_KEY_DEVICE_LIST = "CRDeviceList";
    public static final String REFERENCE_KEY_ONBOARDING_FIRSTTIME ="CROnboardingStoiresFirstTime";
    public static final String REFERENCE_KEY_ONBOARDING_PAYWALL ="CROnboardingStoiresPaywall";
    public static final String REFERENCE_KEY_ONBOARDING_NEW_STORIES="CROnboardingStoiresNew";

    public static final String BROAD_MSG_DEVICE_ADDED = "CR_BROAD_MSG_DEVICE_ADDED";

    // Status fields for color coding
    public static final int STATUS_HIDDEN = -1;
    public static final int STATUS_GOOD = 0;
    public static final int STATUS_WARNING = 1;
    public static final int STATUS_CRITICAL = 2;

    //Status fields for dashboard header color
    public static final int PRIORITY_EMPTY_LOCATION = 0;
    public static final int PRIORITY_RUNNING_FINE = 1;
    public static final int PRIORITY_LEARNING = 2;
    public static final int PRIORITY_INSTALL_INCOMPLETE = 3;
    public static final int PRIORITY_SYSTEM_PROBLEM = 4;
    public static final int PRIORITY_SUBJECTIVE_WARNING = 5;
    public static final int PRIORITY_CRITICAL_ALERT = 6;

    // Timestamped commands
    public static final int COMMAND_DELETE = -2;
    public static final int COMMAND_SET_STATUS_HIDDEN = -1;
    public static final int COMMAND_SET_STATUS_GOOD = 0;
    public static final int COMMAND_SET_STATUS_WARNING = 1;
    public static final int COMMAND_SET_STATUS_CRITICAL = 2;

    public static final int BADGE_TYPE_COMMUNITY = 6;
    public static final String BADGE_EXTRA_COUNT = "CRBadgeExtraNumber";

    public static void init() {
        IF = PPAppCenter.m_Context.getString(R.string.rule_mode_if);
        THIS = PPAppCenter.m_Context.getString(R.string.rule_str_this);
        THAT = PPAppCenter.m_Context.getString(R.string.rule_str_that);
        THEN = PPAppCenter.m_Context.getString(R.string.rule_then);
        DEFAULT_SERVER_URL = "https://app.presencepro.com";
        if (PPAppCenter.APP_NAME.equals(PPC_BRAND_FAMILY)) {
            ANDROID_TERMS_OF_SERVICE = "presencefamily-tos";
        }
        BRAND_LOCATION_ACCESS = String.format("ppc.api.%s-LocationAccess", PPAppCenter.APP_NAME);
        EventTrackingUtils.EventKey = "F@m1ly#Presence!";
    }

    /**
     * Returns whether or not we have an active network connection. This means that booth the hardware is enabled and connected.
     *
     * @return Returns true if we have an active network connection and false otherwise.
     */
    public static boolean isNetworkConnected() {
        boolean isConnected = true;
        char networkType = getNetworkType(PPAppCenter.m_Context);

        if ((networkType != PPCommonInfo.NETWORK_WIFI) &&
            (networkType != PPCommonInfo.NETWORK_MOBILE) &&
            (networkType != PPCommonInfo.NETWORK_BLUETOOTH)) {
            isConnected = false;
        }

        return isConnected;
    }

    public static boolean isNetworkConnectedNoBT() {
        boolean isConnected = true;
        char networkType = getNetworkType(PPAppCenter.m_Context);

        if ((networkType != PPCommonInfo.NETWORK_WIFI) &&
            (networkType != PPCommonInfo.NETWORK_MOBILE)) {
            isConnected = false;
        }

        return isConnected;
    }

    /**
     * Get current network type
     */
    public static char getNetworkType(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (connManager == null) {
            return NETWORK_NONE;
        }

        if ((netInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)) != null
            && netInfo.isConnected() == true) {
            return NETWORK_WIFI;
        } else if ((netInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)) != null
            && netInfo.isConnected() == true) {
            return NETWORK_MOBILE;
        }
        //Added the Bluetooth type for CES
        else if ((netInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_BLUETOOTH)) != null
            && netInfo.isConnected() == true) {
            return NETWORK_BLUETOOTH;
        }

        return NETWORK_NONE;
    }

    /**
     * Get current mac address
     */
    public static String getMacAddress(Context context) {
        try {
            WifiManager wifiMan = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            if (wifiMan == null) {
                return null;
            }
            return wifiMan.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get OS Version
     */
    public static String getOSVersion(String strTag) {
        try {
            if (strTag == null) {
                return Build.VERSION.RELEASE;
            }
            return strTag + " " + Build.VERSION.RELEASE;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get UUID
     */
    @SuppressWarnings("unused")
    public static String GetDevicesUUID(Context context) {
        String uniqueId = "";
        try {
            //Let's use just android id to register device for local camera without any runtime permissions
            uniqueId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            PPVirtuosoLogTrace.d("PPCommonInfo", "uniqueId =================================================== " + uniqueId);
            return uniqueId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueId;
    }

    /**
     * This is for sending device unique Id to server.
     */
    public static String getDeviceUniqueId(Context context) {
        String uniqueId = "";
        String userId = "";
        String DeviceUniqueId = "";
        try {
            //Let's use just android id to register device for local camera without any runtime permissions
            uniqueId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            userId = PPAppCenter.m_SharedPresence.getUserId();
            DeviceUniqueId = uniqueId + "::" + userId;
            PPVirtuosoLogTrace.d("PPCommonInfo", "DeviceUniqueId = " + DeviceUniqueId);
            return DeviceUniqueId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DeviceUniqueId;
    }

    /**
     * Get application  version
     */
    public static String getAppVersion(Context context) {
        String version = null;
        try {

            PackageInfo i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = i.versionName;
            return version;

        } catch (NameNotFoundException e) {
        }
        return null;
    }

    /**
     * Get phone model
     */
    public static String getPhoneModel() {
        String model = Build.MODEL;

        return model;
    }

    /**
     * Get product name
     */
    public static String getProductName() {
        String model = Build.PRODUCT;

        return model;
    }

    /**
     * Get Device Manufaturer
     */
    public static String getDeviceManufacturer() {
        String manufacturer = Build.MANUFACTURER;
        return manufacturer;
    }

    /**
     * Get kenel name
     */
    public static String getKernelName() {
        String kernelName = System.getProperty("os.name");
        return kernelName;
    }

    String userAgent = System.getProperty("http.agent");

    public static String GetAccount(Context context) {
        AccountManager manager = AccountManager.get(context);
        Account[] accounts = manager.getAccounts();
        final int count = accounts.length;
        Account account = null;

        for (int i = 0; i < count; i++) {
            account = accounts[i];
            if (account.type.equals("com.google")) {
            }
        }
        return null;
    }

    /**
     * dip to pixel
     */
    public static int dipToPix(Context con, double dip) {
        density = con.getResources().getDisplayMetrics().density;
        return (int) (dip * density);
    }

    /**
     * Get display
     */
    public static Display getDisPlay(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

        Display display = wm.getDefaultDisplay();

        return display;
    }

    /**
     * Get resolution
     */
    public static DisplayMetrics getResolution(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics m_DisplayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(m_DisplayMetrics);
        return m_DisplayMetrics;
    }

    /**
     * Get package name
     */
    public static String getPackageName(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName topActivity = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            List<ActivityManager.AppTask> tasks = am.getAppTasks();
            topActivity = tasks.get(0).getTaskInfo().topActivity;
        } else {
            List<RunningTaskInfo> Info = am.getRunningTasks(1);
            topActivity = Info.get(0).topActivity;
        }
        String sPackageyname = null;
        if (null != topActivity) {
            sPackageyname = topActivity.getPackageName();
        }
        return sPackageyname;
    }

    /**
     * Get top activity name
     */
    public static String getTopActivity(Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> Info = am.getRunningTasks(1);
        ComponentName topActivity = Info.get(0).topActivity;
        String sTopactivityname = topActivity.toString();
        return sTopactivityname;
    }

    /**
     * Calculate time
     */
    public static String getCalculateTime(Date date, Context context) {

        long curTime = System.currentTimeMillis();
        long regTime = date.getTime();
        long sec = (curTime - regTime) / 1000;

        int seconds = (int) sec;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int weeks = days / 7;
        int months = weeks / 4;
        int years = months / 12;

        String msg = null;

        if (seconds < 30) {
            // just now
            msg = context.getResources().getString(R.string.just_now);
        } else if (seconds < 60) {
            // sec
            msg = String.format(context.getString(R.string.secs_ago), seconds);
        } else if (minutes == 1) {
            msg = context.getString(R.string.time_a_minutes_ago);
        } else if (minutes < 60) {
            msg = String.format(context.getString(R.string.mins_ago), minutes);
        } else if (hours == 1) {
            msg = context.getString(R.string.time_an_hour_ago);
        } else if (hours < 24) {
            msg = String.format(context.getString(R.string.hours_ago), hours);
        } else if (days == 1) {
            msg = context.getString(R.string.time_yesterday);
        } else if (days < 7) {
            msg = String.format(context.getString(R.string.days_ago), days);
        } else if (weeks == 1) {
            msg = context.getString(R.string.time_a_week_ago);
        } else if (weeks < 4) {
            msg = String.format(context.getString(R.string.week_ago), weeks);
        } else if (months == 1) {
            msg = context.getString(R.string.time_a_month_ago);
        } else if (months < 12) {
            msg = String.format(context.getString(R.string.mons_ago), months);
        } else if (years == 1) {
            msg = context.getString(R.string.time_a_year_ago);
        } else {
            msg = String.format(context.getString(R.string.years_ago), years);
        }
        return msg;
    }

    public static String getCalculateTime(long regTime, Context context) {

        long curTime = System.currentTimeMillis();
        long sec = (curTime - regTime) / 1000;
        int seconds = (int) sec;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int weeks = days / 7;
        int months = weeks / 4;
        int years = months / 12;
        String msg = null;

        if (seconds < 10) {
            msg = context.getResources().getString(R.string.just_now);
        } else if (seconds < 60) {
            msg = String.format(context.getString(R.string.secs_ago), seconds);
        } else if (minutes == 1) {
            msg = context.getString(R.string.time_a_minutes_ago);
        } else if (minutes < 60) {
            msg = String.format(context.getString(R.string.mins_ago), minutes);
        } else if (hours == 1) {
            msg = context.getString(R.string.time_an_hour_ago);
        } else if (hours < 24) {
            msg = String.format(context.getString(R.string.hours_ago), hours);
        } else if (days == 1) {
            msg = context.getString(R.string.time_yesterday);
        } else if (days < 7) {
            msg = String.format(context.getString(R.string.days_ago), days);
        } else if (weeks == 1) {
            msg = context.getString(R.string.time_a_week_ago);
        } else if (weeks < 4) {
            msg = String.format(context.getString(R.string.week_ago), weeks);
        } else if (months == 1) {
            msg = context.getString(R.string.time_a_month_ago);
        } else if (months < 12) {
            msg = String.format(context.getString(R.string.mons_ago), months);
        } else if (years == 1) {
            msg = context.getString(R.string.time_a_year_ago);
        } else {
            msg = String.format(context.getString(R.string.years_ago), years);
        }
        return msg;
    }

    public static long getExpiredTime(long regTime) {
        long curTime = System.currentTimeMillis();
        long sec = (regTime - curTime) / 1000;
        long seconds = sec;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        return days;
    }

    public static String getReminderDisplayTime(long interval, Context context) {
        int minutes = (int) Math.ceil(interval / 60.d);
        int hours = minutes / 60;
        int days = hours / 24;
        int weeks = days / 7;
        int months = weeks / 4;
        int years = months / 12;
        String msg = null;

        if (minutes < 60) {
            msg = String.format(context.getString(R.string.mins_before), minutes);
        } else if (hours == 1) {
            msg = context.getString(R.string.one_hour_before);
        } else if (hours < 24) {
            msg = String.format(context.getString(R.string.hours_before), hours);
        } else if (days == 1) {
            msg = context.getString(R.string.one_day_before);
        } else if (days < 7) {
            msg = String.format(context.getString(R.string.days_before), days);
        } else if (weeks == 1) {
            msg = context.getString(R.string.one_week_before);
        } else if (weeks < 4) {
            msg = String.format(context.getString(R.string.week_before), weeks);
        } else if (months == 1) {
            msg = context.getString(R.string.one_month_before);
        } else if (months < 12) {
            msg = String.format(context.getString(R.string.mons_before), months);
        } else {
            msg = String.format(context.getString(R.string.years_before), years);
        }
        return msg;
    }

    public static String getEasyCalculateTime(long regTime, Context context) {
        long curTime = getTodayEndTime();
        long sec = (curTime - regTime) / 1000;
        int seconds = (int) sec;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int weeks = days / 7;
        int months = weeks / 4;
        int years = months / 12;
        String msg = null;

        if (hours < 24) {
            msg = context.getString(R.string.today);
        } else if (days == 1) {
            msg = context.getString(R.string.yesterday);
        } else if (days < 7) {
            msg = String.format(context.getString(R.string.days_ago), days);
        } else if (weeks == 1) {
            msg = context.getString(R.string.time_a_week_ago);
        } else if (weeks < 4) {
            msg = String.format(context.getString(R.string.week_ago), weeks);
        } else if (months == 1) {
            msg = context.getString(R.string.time_a_month_ago);
        } else if (months < 12) {
            msg = String.format(context.getString(R.string.mons_ago), months);
        } else if (years == 1) {
            msg = context.getString(R.string.time_a_year_ago);
        } else {
            msg = String.format(context.getString(R.string.years_ago), years);
        }
        return msg;
    }

    private static long getTodayEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime().getTime();
    }

    /**
     * Calculate time
     */
    public static boolean getCalculateTimeForWebCacheClear(long storedTime) {

        long curTime = System.currentTimeMillis();
        long regTime = storedTime;
        long diffTime = (curTime - regTime) / 1000;

        if ((diffTime /= HOUR) < DAY) {
            if (diffTime > 14) {
                return true;
            }

        }
        return false;
    }

    /**
     * Calculate time
     */
    public static boolean getCalculateTimeForIdleSilentUpdate(long storedTime) {
        long curTime = System.currentTimeMillis();
        long regTime = storedTime;
        long diffTime = (curTime - regTime) / 1000;
        if (diffTime > 10) {
            return true;
        }
        return false;
    }

    public static boolean isIdleTimeOverSeconds(long storedTime, int seconds) {
        long curTime = System.currentTimeMillis();
        long regTime = storedTime;
        long diffTime = (curTime - regTime) / 1000;
        if (diffTime > seconds) {
            return true;
        }
        return false;
    }

    /**
     * check currency unit
     */
    public static Boolean checkCurrencyCode(String sUnit) {
        if (sUnit != null) {
            if (sUnit.equals("USD\n")
                || sUnit.equals("CAD\n")
                || sUnit.equals("CNY\n")
                || sUnit.equals("JPY\n")
                || sUnit.equals("EUR\n")
                || sUnit.equals("AUD\n")
                || sUnit.equals("HKD\n")
                || sUnit.equals("INR\n")
                || sUnit.equals("ILS\n")
                || sUnit.equals("MXN\n")
                || sUnit.equals("ZAR\n")
                || sUnit.equals("CHF\n")
                || sUnit.equals("AED\n")
                || sUnit.equals("GBP\n")) {
                return true;
            }
        }
        return false;
    }

    /**
     * check currency unit
     */
    public static Boolean checkCurrencyCountry(String sCountry) {
        if (sCountry != null) {
            if (sCountry.equals("United States\n")
                || sCountry.equals("Canada\n")
                || sCountry.equals("China\n")
                || sCountry.equals("Japan\n")
                || sCountry.equals("Andorra\n")
                || sCountry.equals("Australia\n")
                || sCountry.equals("Austria\n")
                || sCountry.equals("Belgium\n")
                || sCountry.equals("Estonia\n")
                || sCountry.equals("Finland\n")
                || sCountry.equals("France\n")
                || sCountry.equals("Germany\n")
                || sCountry.equals("Greece\n")
                || sCountry.equals("Hong Kong\n")
                || sCountry.equals("India\n")
                || sCountry.equals("Ireland\n")
                || sCountry.equals("Israel\n")
                || sCountry.equals("Italy\n")
                || sCountry.equals("Latvia\n")
                || sCountry.equals("Luxembourg\n")
                || sCountry.equals("Malta\n")
                || sCountry.equals("Mexico\n")
                || sCountry.equals("Monaco\n")
                || sCountry.equals("Montenegro\n")
                || sCountry.equals("Netherlands\n")
                || sCountry.equals("Portugal\n")
                || sCountry.equals("San Marino\n")
                || sCountry.equals("Slovakia\n")
                || sCountry.equals("Slovenia\n")
                || sCountry.equals("South Africa\n")
                || sCountry.equals("Spain\n")
                || sCountry.equals("Switzerland\n")
                || sCountry.equals("UAE\n")
                || sCountry.equals("United Kingdom\n")
                || sCountry.equals("Vatican City\n")) {
                return true;
            }
        }
        return false;
    }

    /**
     * set currency unit
     */
    public static void setCurrencyCode(String sUnit) {
        if (sUnit != null) {
            PPAppCenter.m_SharedPresence.setCurrencyCode(sUnit);
        }
    }

    public static String getCurrentSymbol() {
        String sCode = PPCommonInfo.getCurrencyCode();
        String sCurrencySymbol = null;
        if (sCode != null) {
            if (sCode.equals("CNY") || sCode.equals("JPY")) {
                sCurrencySymbol = "¥";
            } else if (sCode.equals("USD")) {
                sCurrencySymbol = "$";
            } else {
                sCurrencySymbol = PPAppCenter.m_SharedPresence.getCurrencySymbolByCode(sCode + "symbol");
            }
        } else {
            sCurrencySymbol = "$";
        }
        return sCurrencySymbol;
    }

    /**
     * Get currency unit
     */
    public static String getCurrencyCode() {
        return PPAppCenter.m_SharedPresence.getCurrencyCode();
    }

    /**
     * Clear web view cache
     */
    public static void clearWebViewCache(Context context) {
        if (context == null) {
            return;
        }

        try {
            File cacheDir = new File(context.getCacheDir() + "/webviewCache");
            if (!cacheDir.exists()) {
                return;
            }
            if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                return;
            }

            File[] files = cacheDir.listFiles();
            if (files == null) {
                return;
            }

            for (File f : files) {
                if (f.exists()) {
                    f.delete();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * String encode
     */
    public static String encode(String input) {
        StringBuilder resultStr = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (isUnsafe(ch)) {
                resultStr.append('%');
                resultStr.append(toHex(ch / 16));
                resultStr.append(toHex(ch % 16));
            } else {
                resultStr.append(ch);
            }
        }
        return resultStr.toString();
    }

    /**
     * change to HEX
     */
    private static char toHex(int ch) {
        return (char) (ch < 10 ? '0' + ch : 'A' + ch - 10);
    }

    /**
     * special character check
     */
    private static boolean isUnsafe(char ch) {
        if (ch > 128 || ch < 0) {
            return true;
        }
        return " %$&+,/:;=?@<>#%".indexOf(ch) >= 0;
    }

    /**
     * check application installed
     */
    public static boolean isInstalledApplication(Context context, String packageName) {

        {
            List<ApplicationInfo> appList = context.getPackageManager()
                .getInstalledApplications(PackageManager.GET_META_DATA);

            for (ApplicationInfo appInfo : appList) {
                if (appInfo.packageName.equals(packageName)) {
                    return true;
                }
            }

            return false;
        }

    }

    /**
     * check app background
     */
    public static boolean isAppBackground(Context context, String sPkgName) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String runningPackageName = null;
        try {
            RunningTaskInfo info = activityManager.getRunningTasks(1).get(0);
            runningPackageName = info.topActivity.getPackageName();
        } catch (Exception e) {
        }
        if (context.getPackageName().equals(runningPackageName)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Determine if the device is a tablet (i.e. it has a large screen).
     *
     * @param context The calling context.
     */
    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout
            & Configuration.SCREENLAYOUT_SIZE_MASK)
            >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /**
     * extract only digit from string
     */
    public static String getDigitInString(String str) {
        if (str != null && str.length() != 0) {
            String tmpStr = str;
            StringBuffer sb = new StringBuffer();
            if (tmpStr.length() != 0) {
                Pattern p = Pattern.compile("[^\\d]");
                Matcher m = p.matcher(str);
                while (m.find()) {
                    m.appendReplacement(sb, "");
                }
                m.appendTail(sb);
            } else {
                sb.append("");
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * Get User Agent Information (we can add more if we need)
     */
    public static String getUserAgentInformation(Context context) {
        StringBuilder agentInfo = new StringBuilder();
        agentInfo.append(VirtuosoCommonSettings.USERAGENT_HEADER);
        agentInfo.append("/");
        agentInfo.append(getAppVersion(context));
        return agentInfo.toString();
    }

    /**
     * Check valid Json format
     */
    public static boolean isJSONValid(String strData) {
        try {
            JSONObject.parseObject(strData);
        } catch (Exception ex) {
            try {
                JSONArray.parseObject(strData);
            } catch (Exception ex1) {
                return false;
            }
        }
        return true;
    }


    /**
     * Error message according to server result
     */
    public static String errorMessage(int resultCode) {

        String strErrorMsg = null;
        switch (resultCode) {
            case 0:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_success);
                break;
            case 1:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_sth_went_wrong);
                break;
            case 2:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_no_longer_signed_in);
                break;
            case 3:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_location);
                break;
            case 4:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_device_not_belong);
                break;
            case 5:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_command_not_found);
                break;
            case 6:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_that_not_belong);
                break;
            case 7:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_access_deny);
                break;
            case 8:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_sth_wrong);
                break;
            case 9:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_required_field);
                break;
            case 10:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_no_available_devices);
                break;
            case 11:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_username);
                break;
            case 12:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_username);
                break;
            case 13:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_index);
                break;
            case 14:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_parsing);
                break;
            case 15:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_cosumer_id);
                break;
            case 16:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_cosumer_type_id);
                break;
            case 17:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_activation_key);
                break;
            case 18:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_rule_format);
                break;
            case 19:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_rule_id);
                break;
            case 20:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_duplicate_user);
                break;
            case 21:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_offline);
                break;
            case 22:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_device_belong_other);
                break;
            case 23:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_strange_problem);
                break;
            case 24:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_reg_code);
                break;
            case 25:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_pending_number);
                break;
            case 26:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_duplicate_entity);
                break;
            case 27:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_device_timeout);
                break;
            case 28:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_device_not_linked);
                break;
            case 10000:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_trouble_in_connecting);
                break;
            case 10001:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_camera_not_available);
                break;
            case 10002:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_create_camera);
                break;
            case 10003:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_communication);
                break;
            case 10004:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_lost_connection);
                break;
            case 10005:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_recording_motion);
                break;
            case 10006:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_not_have_good_connection);
                break;
            case 10007:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_pwd_less_than);
                break;
            case 10008:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_camera_already_view);
                break;
            case 10009:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_barcode);
                break;
            case 10010:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_corrupted_barcode);
                break;
            case 10011:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_not_connect_bluetooth);
                break;
            case 10012:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_not_support_bluetooth);
                break;
            case 10013:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_auth_bluetooth);
                break;
            case 10014:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_power_off_bluetooth);
                break;
            case 10015:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wait_power_up);
                break;
            case 10016:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_wrong_save_video);
                break;
            case 10017:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_corrupted_video);
                break;
            case 10018:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_no_permission_save);
                break;
            case 10019:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_upload);
                break;
            case 10020:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_play_video);
                break;
            case 10021:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_select_one_day);
                break;
            case 10022:
                strErrorMsg = PPAppCenter.m_Context.getString(R.string.err_msg_name_device);
                break;
        }
        return strErrorMsg;
    }

    /**
     * Check screen is on and off deprecated isScreenOn()is can be changed to isInteractive () later.
     */
    public static boolean isScreenOn(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService(context.POWER_SERVICE);
        boolean isScreenOn = powerManager.isScreenOn();
        if (isScreenOn) {
            return true;
        }
        return false;
    }

    /**
     * Append language value
     */
    public static StringBuilder languageSet(StringBuilder sbUrl) {
        sbUrl.append("&setLng=");
        sbUrl.append(Locale.getDefault().getLanguage());
        return sbUrl;
    }

    //ex 2016-03-12 12:00 or 2016-03-12
    public static String getElapsedDay(String startDate, String format) {
        String result = "";
        String start = startDate.substring(0, 10);
        String end = getDate(format).substring(0, 10);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = formatter.parse(start);
            Date endDate = formatter.parse(end);

            long diff = endDate.getTime() - beginDate.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);

            result = (diffDays + 1) + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getDate(String format) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(format, java.util.Locale.getDefault());
            Date date = new Date();
            String strDate = dateFormat.format(date);
            return strDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PPNotificationDBHelper getNotificationDBHelper(Context context) {
        if (m_notificationDBHelper == null) {
            StringBuilder sbDBName = new StringBuilder();
            sbDBName.append(PPAppCenter.APP_NAME);
            sbDBName.append("_");
            sbDBName.append("notification");
            sbDBName.append(".db");
            m_notificationDBHelper = new PPNotificationDBHelper(context, sbDBName.toString(), null, 1);
        }
        return m_notificationDBHelper;
    }

    public static void initNotificationDBHelper() {
        if (m_notificationDBHelper != null) {
            m_notificationDBHelper = null;
        }
    }

    /**
     * Get Elapsed Day
     */
    public static long getElapsedDay(String startTime) {
        long days = 0;
        try {
            long endMs = System.currentTimeMillis();
            long startMs = Long.parseLong(startTime);
            long deltaMs = endMs - startMs;
            long seconds = deltaMs / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            days = hours / 24;
            return days;
        } catch (Exception e) {
        }
        return days;
    }

    public static boolean checkGPSService(Context context) {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Email format check
     */
    public static boolean checkEmail(String email) {
        String regex = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        boolean isNormal = m.matches();
        return isNormal;
    }

    //This is used for IOT icon check for now.
    public static boolean isIOTIcon(int deviceType) {
        if (INT_EWIG_BUTTON == deviceType) {
            return true;
        }
        return false;
    }

    public static boolean isValidUrl(String urlStr) {
        if (PPUtil.isEmpty(urlStr)) {
            return false;
        }
        if (!urlStr.contains(".")) {
            return false;
        }
        boolean isValid = URLUtil.isValidUrl(urlStr);
        return isValid;
    }
}
