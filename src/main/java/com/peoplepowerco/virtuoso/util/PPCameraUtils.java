/**
 * @FileName : PPCameraUtils.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;

import android.content.Context;
import android.content.pm.PackageManager;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.PPDeviceCommand;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterModel;
import com.peoplepowerco.virtuoso.models.PPDevicePropertyModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Bhargav Panchal
 * @brief :
 * @date : 2014. 06. 17.
 */
public class PPCameraUtils {
    private static final String TAG = "PPCameraUtils";

    public static final int NONE = 0;
    public static final int CAMERA_BACK = 1;
    public static final int CAMERA_FRONT = 2;
    public static final int AUDIO_ON = 3;
    public static final int AUDIO_OFF = 4;
    public static final int STREAMING_ON = 5;
    public static final int STREAMING_OFF = 6;
    public static final int EXIT = 7;
    public static final int FLASH_LIGHT_ON = 8;
    public static final int FLASH_LIGHT_OFF = 9;
    public static final int OPTION_OFF = 10;
    public static final int OPTION_ON = 11;
    public static final int SEND_STREAM_CMD_ON = 12;
    public static final int SEND_STREAM_CMD_OFF = 13;
    public static final int COUNTDOWN = 14;
    public static final int VIDEO_ON = 15;
    public static final int VIDEO_OFF = 16;
    public static final int REMOTE_CONTROL_ENABLED = 17;
    public static final int REMOTE_CONTROL_DISABLED = 18;
    public static final int MOTION_STATUS_ON = 19;
    public static final int MOTION_STATUS_OFF = 20;
    public static final int CHANGE_CAMERA_NAME = 21;
    public static final int SEND_PING_MESSAGE = 22;
    public static final int RECORD_STREAM_ON = 23;
    public static final int RECORD_STREAM_OFF = 24;
    public static final int OPTION_ENABLED = 25;
    public static final int OPTION_DISABLED = 26;
    public static final int FLASH_ENABLED = 27;
    public static final int FLASH_DISABLED = 28;
    public static final int CAMERA_SWITCH_ENABLED = 29;
    public static final int CAMERA_SWITCH_DISABLED = 30;
    public static final int PRIVACY_TEXT_SHOW_HIDE = 31;
    public static final int PRIVACY_WARNING_TEXT = 32;
    public static final int CALL_ENABLED = 33;
    public static final int CALL_DISABLED = 34;
    public static final int START_CALL = 35;
    public static final int END_CALL = 36;
    public static final int IN_CALL = 37;
    public static final int OUT_CALL = 38;
    public static final int BLACKOUT_SCREEN_ON = 39;
    public static final int BLACKOUT_SCREEN_OFF = 40;
    public static final int RECORD_MOTION_MAX_DURATION = 41;
    public static final int TIME_BETWEEN_TWO_RECORDINGS = 42;
    public static final int TWITTER_AUTO_SHARE_ON = 43;
    public static final int TWITTER_AUTO_SHARE_OFF = 44;

    public static final int TWITTER_WARNING_STATUS_ON = 45;
    public static final int TWITTER_WARNING_STATUS_OFF = 46;

    public static final int TWITTER_TWEET_DESCRIPTION = 47;
    public static final int TWITTER_TWEET_SHARED_NAME = 48;

    public static final int REQUEST_ALL_PARAMETER = 49;
//	public static final int REQUEST_VIEWER_TO_UPDATE_PARAMETER = 50;

    public static final int TWITTER_WEBVIEW_ON = 51;
    public static final int TWITTER_WEBVIEW_OFF = 52;
    public static final int TWITTER_SHARED_NAME_UPDATE = 53;

    public static final int ALWAYS_RECORD_MAX_OFF = 54;
    public static final int ALWAYS_RECORD_MAX_ON = 55;
    public static final int SEND_VIDEO_CALL_SESSION_ID = 56;

    public static final int AUDIO_DETECTION_OFF = 57;
    public static final int AUDIO_DETECTION_ON = 58;

    public static final int OPTION_HIDE = 59;
    public static final int OPTION_SHOW = 60;

    public static final int COMPONENT_HIDE = 61;
    public static final int COMPONENT_SHOW = 62;

    public static final int ROBOT_STATUS_DISCONNECTED = 63;
    public static final int ROBOT_STATUS_CONNECTED = 64;
    public static final int ROBOT_MOTION_DIRECTION = 65;
    public static final int START_PROGRESS = 66;
    public static final int UPDATE_PROGRESS = 67;
    public static final int END_PROGRESS = 68;

    public static final int MOTION_SENSITIVITY = 69;
    public static final int CAMERA_FOCUS = 70;
    public static final int TIMEZONE = 71;
    public static final int CHARGING = 72;
    public static final int NOT_CHARGING = 73;
    public static final int RECORD_STATUS_ON = 74;
    public static final int RECORD_STATUS_OFF = 75;
    public static final int FLASH_WAS_ON = 76;
    public static final int MOTION_ACTIVATED_ALARM = 77;
    public static final int MOTION_ALARM_SCREEN_UNLOCK = 78;
    public static final int MOTION_ALARM_SCREEN_LOCK = 79;
    public static final int CAMERA_ALARM = 80;
    public static final int CAMERA_ALARM_SCREEN_LOCK = 81;
    public static final int CAMERA_ALARM_SCREEN_UNLOCK = 82;

    public static final int CAMERA_SPEAKER_VOLUME = 83;
    public static final int VANTAGE_POINT_STATUS = 84;
    public static final int VANTAGE_POINT_NAME = 85;
    public static final int VANTAGE_POINT_TIME = 86;
    public static final int VANTAGE_POINT_SEQUENCE = 87;
    public static final int VANTAGE_POINT_CONFIG = 88;
    public static final int VANTAGE_POINT_LOCATION = 89;
    public static final int ROBOT_CAMERA_CONTROL_FLIP = 90;
    public static final int VANTAGE_POINT_INDEX = 91;

    public static final int CAMERA_CAPTURE_IMAGE = 92;
    public static final int CAMERA_CAPTURE_IMAGE_ALERT = 93;

    public static final int CAMERA_RECORD_STREAM_ON = 94;
    public static final int CAMERA_TAKE_PICTURE_ON = 95;
    public static final int START_RECONNECTION = 96;
    public static final int STATE_CAMERA_OFFLINE = 97;

    public interface USER {
        interface FREE {
            //Free user video and audio quality settings
            int DEFAULT_WIDTH = 320;
            int DEFAULT_HEIGHT = 240;
            int DEFAULT_MAX_VIDEO_BITRATE = 256000;
            int DEFAULT_MAX_AUDIO_BITRATE = 32000;
            int DEFAULT_FRAMES_PER_SECOND = 30;
            int DEFAULT_AUDIO_RATE = 44100;
            //int DEFAULT_KEY_FRAME_INTERVAL 	= 30;
            //double DEFAULT_BUFFER_LENGTH 	= 0.4;
        }

        interface PRO {
            //Pro user video and audio quality settings
            int DEFAULT_WIDTH = 320;
            int DEFAULT_HEIGHT = 240;
            int DEFAULT_MAX_VIDEO_BITRATE = 500000;
            int DEFAULT_MAX_AUDIO_BITRATE = 64000;
            int DEFAULT_FRAMES_PER_SECOND = 30;
            int DEFAULT_AUDIO_RATE = 44100;
            //int DEFAULT_KEY_FRAME_INTERVAL 	= 30;
            //double DEFAULT_BUFFER_LENGTH 	= 0.4;
        }
    }

    /**
     * Default value list
     *
     * @author Bhargav
     */
    public interface CameraDefaultValue {
        public static final int ON = 1;
        public static final int OFF = 0;
        public static final int MAXIMUM_PRO_USER_MOTION_RECORDING_SECONDS = 300;
        public static final int MINIMUM_RECORDING_SECONDS = 5;
        public static final int DEFAULT_RECORDING_SECONDS = 30;
        public static final int LENGTH_OF_FIRST_RECORDING = 1;
        public static final int SECONDS_BEFORE_MOTION_IS_NOT_DETECTED = 5;
        public static final int RECORD_FULL_DURATION_DISABLE = 0;
        public static final int RECORD_FULL_DURATION_ENABLE = 1;

        // FIXME please update default value , changed for testing purpose
        public static final int MOTION_DETECTION_COUNTDOWN_LENGTH_IN_SECONDS = 30;
        public static final int MOTION_RECORD_SECONDS_STEP = 1;
        public static final int MINIMUM_MOTION_RECORD_SECONDS = 5;
        public static final int MAXIMUM_FREE_USER_MOTION_RECORD_SECONDS = 60;
        public static final int DEFAULT_FREE_USER_MOTION_RECORD_SECONDS = 30;
        public static final int MAXIMUM_PRO_USER_MOTION_RECORD_SECONDS = 300;
        public static final int DEFAULT_FREE_USER_SECONDS_BETWEEN_MOTION_DETECTION = 1800;
        public static final int MINIMUM_FREE_USER_SECONDS_BETWEEN_MOTION_DETECTION = 300;//300
        public static final int MAXIMUM_FREE_USER_SECONDS_BETWEEN_MOTION_DETECTION = 3600;
        public static final int STEP_TIME_BETWEEN_MOTION_DETECTION = 300;

        public static final int DEFAULT_PRO_USER_SECONDS_BETWEEN_MOTION_DETECTION = 1800;
        public static final int MINIMUM_PRO_USER_SECONDS_BETWEEN_MOTION_DETECTION = 60;
        public static final int MAXIMUM_PRO_USER_SECONDS_BETWEEN_MOTION_DETECTION = 3600;

        public static final long FREE_USER_RECORD_STREAMING_MS = 1000 * 10;
        public static final long PRO_USER_RECORD_STREAMING_MS = 1000 * 60;

        public static final int MOTION_SENSITIVITY_STEP = 10;

        //This values have to be used when device interface and server update.(IOS Camera API DOC)
        public static final int MOTION_SENSITIVITY_DEVICE_INTERFACE_TINY = 0;
        public static final int MOTION_SENSITIVITY_DEVICE_INTERFACE_SMALL = 10;
        public static final int MOTION_SENSITIVITY_DEVICE_INTERFACE_NORMAL = 20;
        public static final int MOTION_SENSITIVITY_DEVICE_INTERFACE_LARGE = 30;
        public static final int MOTION_SENSITIVITY_DEVICE_INTERFACE_HUGE = 40;

        public static final int MAXIMUM_MOTION_COUNT_DOWN_TIME = 60;
        public static final int MINIMUM_MOTION_COUNT_DOWN_TIME = 5;
        public static final int DEFAULT_MOTION_COUNT_DOWN_TIME = 30;
        public static final int MOTION_COUNT_DOWN_STEP_TIME = 5;
        public static final int MOTION_RECORDING_STEP_TIME = 60;

        public static final int MAXIMUM_SPEAKER_VOLUME = 16;
        public static final int MINIMUM_SPEAKER_VOLUME = 0;
        public static final int SPEAKER_VOLUME_STEP = 1;

        public static final int MOTION_ALARM_OFF = 0;
        public static final int MOTION_ALARM_SOUND = 1;
        public static final int MOTION_ALARM_1_TIME = 2;
        public static final int MOTION_ALARM_2_TIMES = 3;
        public static final int MOTION_ALARM_3_TIMES = 4;
        public static final int MOTION_ALARM_STEP = 1;

        public static final int CAMERA_ALARM_OFF = 0;
        public static final int CAMERA_ALARM_SOUND = 1;
        public static final int CAMERA_ALARM_1_TIME = 2;
        public static final int CAMERA_ALARM_2_TIMES = 3;
        public static final int CAMERA_ALARM_3_TIMES = 4;

        public static final int DEFAULT_CAMERA_MOTION_ALERT_PERIOD_SECONDS = 30;
        public static final int DEFAULT_VIEWER_IDLE_STATUS_COUNTDOWN_SECONDS_FREE = 60 * 30;
        public static final int DEFAULT_VIEWER_IDLE_STATUS_COUNTDOWN_SECONDS_PRO = 60 * 60 * 12;
        public static final int DEFAULT_VIEWER_IDLE_STATUS_CONFIRMATION_SECONDS = 30;
        public static final int DEFAULT_VIEWER_IDLE_STATUS_STOP_VIEWER_SECONDS = 180;

        public static final String DEFAULT_BLACK_OUT_CAMERA_TEXT = "This camera is being watched remotely";

        public static final int DEFAULT_AUDIO_ON = ON;
        public static final int DEFAULT_VIDEO_ON = ON;
        public static final int DEFAULT_REMOTE_CONTROL_ENABLED = ON;
        public static final int DEFAULT_HD_RECORDING = 1;
        public static final int DEFAULT_BLACKOUT_SCREEN = OFF;
        public static final int DEFAULT_MOTION_DETECTION_STATUS = OFF;
        public static final int DEFAULT_AUDIO_DETECTION_STATUS = OFF;
        public static final int DEFAULT_STOP_RECORDING_WHEN_MOTION_STOPS = OFF;

        public static final int SEND_COMMAND_TO_GREENX_SERVER = OFF;
        public static final int SEND_COMMAND_TO_WOWZA_SERVER = 1;

        public static final int DEFAULT_TWITTER_STATUS_OFF = OFF;
        public static final int DEFAULT_TWITTER_AUTO_SHARE_OFF = OFF;
        public static final int DEFAULT_TWITTER_WARNING_STATUS_OFF = OFF;
        public static final String DEFAULT_TWITTER_TWEET_DESCRIPTION = "Checkout video on my Android ";
        public static final String DEFAULT_WARNING_TEXT_DESCRIPTION = "This camera is being viewed remotely";

        public static final int DEFAULT_ALERT_ME_WITH_PICTURE = 1;
        public static final int DEFAULT_TAKE_A_PICTURE = 2;

        //Vantage Points
        public static final int MAXIMUM_VANTAGE_POINT_WAIT_TIME = 15 * 60;
        public static final int MINIMUM_VANTAGE_POINT_WAIT_TIME = 10;
        public static final int VANTAGE_POINT_WAIT_TIME_STEP = 1;
        public static final int DEFAULT_VANTAGE_POINT_WAIT_TIME = 30;

        //Record stream
        public static final int RECORD_STREAM_ON = ON;
        public static final int RECORD_STREAM_OFF = OFF;
    }

    /**
     * Default Camera value
     *
     * @author bhargav
     */
    public interface CurrentCameraValue {
        public static final int FRONT_CAMERA = 0;
        public static final int REAR_CAMERA = 1;
        public static final int REAR_ONLY_CAMERA = 2;
        public static final int FRONT_ONLY_CAMERA = 3;
        public static final int NO_CAMERA = 4;
    }

    /**
     * Default Flash value
     *
     * @author bhargav
     */
    public interface CurrentFlashValue {
        public static final int FLASH_OFF = 0;
        public static final int FLASH_ON = 1;
        public static final int NO_FLASH = -1;
        public static final int FLASH_WAS_ON = 2;
    }

    /**
     * Charging value
     */
    public interface CurrentChargingValue {
        public static final int NOT_CHARGING = 0;
        public static final int CHARGING = 1;
    }

    public interface RobotFlipValues {
        public static final int ROBOT_CAMERA_CONTROL_FLIP = 1;
    }

    public interface KeypadCountDownValues {
        int COUNTDOWN_SILENCE_KEEP_KEYPAD = -1;
        int COUNTDOWN_SILENCE_REMOVE_KEYPAD = 0;
    }

    /**
     * Default Param list
     *
     * @author Bhargav
     */
    public interface CameraParameter {
        public static final String RESULT_CODE = "resultCode";
        public static final String SESSION_ID = "sessionId";
        public static final String PARAMS = "params";
        public static final String NAME = "name";
        public static final String SET_VALUE = "setValue";
        public static final String INDEX = "index";
        public static final String VALUE = "value";
        public static final String VIEWER_COUNT = "viewersCount";
        public static final String STREAM_STATUS = "ppc.streamStatus";
        public static final String ACCESS_CAMERA_SETTINGS = "accessCameraSettings";
        public static final String AUDIO_ON = "audioStreaming";// included
        public static final String VIDEO_ON = "videoStreaming";// included
        public static final String HD_RECORDING = "ppc.hdStatus";// included
        public static final String RAPID_MOTION_STATUS = "ppc.rapidMotionStatus";// Time between...
        public static final String BATTERY_LEVEL = "batteryLevel";
        public static final String CHARGING = "ppc.charging";
        public static final String MOTION_STATUS = "motionStatus";
        public static final String MOTION_STATUS_PARAM = "motionStatusParam";
        public static final String AUDIO_DETECTION_STATUS = "audioDetectionStatus";
        public static final String SELECTED_CAMERA = "selectedCamera";
        public static final String MOTION_RECORD_SECONDS = "ppc.recordSeconds";
        public static final String MOTION_SENSITIVITY = "ppc.motionSensitivity";
        public static final String STATUS = "status";
        public static final String VERSION = "version";
        public static final String MANUFACTURER = "manufacturer";
        public static final String MODEL = "model";
        public static final String CONNECTED_VIEWER_NAME = "connectedViewerName";
        public static final String STREAM_ID = "streamId";
        public static final String REMOTE_CONNECTED_ROBOT = "ppc.robotConnected";
        public static final String AVAILABLE_BYTES = "ppc.availableBytes";
        public static final String MOTION_COUNTDOWN_TIME = "ppc.motionCountDownTime";
        public static final String BLACKOUT_SCREEN = "ppc.blackoutScreenOn";
        public static final String RECORD_FULL_DURATION = "ppc.recordFullDuration";
        public static final String FLASH_ON = "ppc.flashOn";
        public static final String CAMERA_FOCUS = "ppc.autoFocus";
        public static final String CAMERA_NAME = "ppc.cameraName";
        //This is for HD on demand video record on C1 Camera
        public static final String RECORD_CAPTURE_VIDEO = "ppc.captureVideo";
        public static final String RECORD_STREAM = "recordStream";
        public static final String RECORD_STREAM_FORWARD = "forward";
        public static final String RECORD_STREAM_FORMAT = "recordFormat";
        public static final String RECORD_STREAM_STATUS = "recordStatus";
        public static final String RECORD_STATUS = "recordStatus";
        public static final String START_CALL = "startCall";
        public static final String IN_CALL = "isInCall";
        public static final String CAMERA_ALARM = "ppc.alarm";
        public static final String MOTION_ACTIVATED_ALARM = "ppc.motionAlarm";
        public static final String CAMERA_CAPTURE_IMAGE = "ppc.captureImage";

        public static final String TWITTER_WARNING_STATUS_ON = "ppc.warningStatus";
        public static final String PRIVACY_WARNING_TEXT = "ppc.warningText";

        public static final String TWITTER_AUTO_SHARING_ON = "twitterAutoShare";
        public static final String TWITTER_DESCRIPTION = "twitterDescription";
        public static final String TWITTER_REMINDER = "ppc.twitterReminder";
        public static final String TWITTER_STATUS_ON = "ppc.twitterStatus";
        public static final String ALWAYS_RECORD_MAX = "ppc.recordFullDuration";
        public static final String VIDEO_CAll_SESSION_ID = "ppc.VideoCallsessionId";

        public static final String ROBOT_MOTION_DIRECTION = "ppc.robotMotionDirection";
        public static final String MOTION_ACTIVITY = "ppc.motionActivity";

        public static final String ROBOT_MOVEMENT_ANGLE = "ppc.robotMovementAngle";
        public static final String PRIVACY_TEXT = "ppc.warningText";
        public static final String TIMEZONE = "timeZoneId";
        //For use Camera param set in shared preference
        public static final String SET_PARAM = "setCameraParam";
        public static final String SPEACKER_VOLUME = "ppc.outputVolume";

        //P360
        public static final String VANTAGE_POINT_LOCATION = "ppc.robotVantageSphericalCoordinates";
        public static final String VANTAGE_POINT_TIMER = "ppc.robotVantageTimer";
        public static final String VANTAGE_POINT_CONFIG_STATUS = "ppc.robotVantageConfigurationStatus";
        public static final String VANTAGE_POINT_NAME = "ppc.robotVantageName";
        public static final String VANTAGE_POINT_SEQUENCE = "ppc.robotVantageSequence";
        public static final String VANTAGE_POINT_MOVE_INDEX = "ppc.robotVantageMoveToIndex";
        public static final String ROBOT_ORIENTATION = "ppc.robotOrientation";
        public static final String COUNTDOWN = "ppc.countdown";
        public static final String VISUAL_COUNTDOWN = "ppc.visualCountdown";
        public static final String PLAY_SOUND = "ppc.playSound";
        public static final String NOTIFICATION = "ppc.notification";
    }

    /**
     * Generate web-socket command
     *
     * @param m_sSessionId
     * @param m_JsonObjectForCommand
     * @return
     */
    public static String getCommandJson(String m_sSessionId, JSONObject... m_JsonObjectForCommand) {
        // String m_sJsonCommand=
        // "{\"sessionId\":\""+m_sSessionId+"\",\"params\":[";
        String m_sJsonCommand = "{\"params\":";
        m_sJsonCommand += Arrays.toString(m_JsonObjectForCommand);
        m_sJsonCommand += "}";
        PPVirtuosoLogTrace.d(TAG, m_sJsonCommand);
        return m_sJsonCommand;
    }

    /**
     * Device is supporting flashlight or not
     *
     * @param m_Context
     * @return
     */
    public static boolean isFlashLightSupport(Context m_Context) {
        return m_Context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    /**
     * Set camera setting into model
     * TODO update @param base on get device parameter.
     */
    public static void setCameraSettingParam(List<PPDeviceParameterModel> m_DeviceParamModelList, PPDeviceCommand m_DeviceCommand) {
        //TODO: Since we only use the latest (last entry) this could be viewed as a memory leak (restart of camera takes it back to 1)
        int iListSize = m_DeviceParamModelList.size();
        if (iListSize > 0) {
            List<PPDeviceParameterInfoModel> m_DeviceParameterInfoModels = m_DeviceParamModelList.get(iListSize - 1).getDeviceParametersInfoModel();
            if (m_DeviceParameterInfoModels != null) {
                for (PPDeviceParameterInfoModel m_PPDeviceParameterInfoModel : m_DeviceParameterInfoModels) {
                    if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.STREAM_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.ACCESS_CAMERA_SETTINGS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setAccessCameraSettings(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "ACCESS_CAMERA_SETTINGS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.AUDIO_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setAudioStreaming(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "AUDIO_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.VIDEO_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setVideoStreaming(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "VIDEO_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.RECORD_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setRecordStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "RECORD_STATUS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.HD_RECORDING)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        //TODO

                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.RAPID_MOTION_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setRapidMotionStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "RAPID_MOTION_STATUS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.BATTERY_LEVEL)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        //TODO

                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.CHARGING)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        //TODO

                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.SELECTED_CAMERA)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setSelectedCamera(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "SELECTED_CAMERA == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.MOTION_RECORD_SECONDS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setMotionRecordSeconds(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "MOTION_RECORD_SECONDS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.MOTION_SENSITIVITY)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setMotionSensitivity(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "MOTION_SENSITIVITY == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.TWITTER_AUTO_SHARING_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setTwitterAutoShare(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "TWITTER_AUTO_SHARING_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.TWITTER_DESCRIPTION)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setTwitterDescription(m_PPDeviceParameterInfoModel.getValue());
                        PPVirtuosoLogTrace.d(TAG, "TWITTER_DESCRIPTION == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.TWITTER_REMINDER)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setTwitterReminder(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "TWITTER_REMINDER == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.TWITTER_STATUS_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setTwitterStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "TWITTER_STATUS_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.MOTION_COUNTDOWN_TIME)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setMotionCountDownTime(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "MOTION_COUNTDOWN_TIME == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.BLACKOUT_SCREEN)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setBlackOutScreenOn(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "BLACKOUT_SCREEN == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.TWITTER_WARNING_STATUS_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setTwitterWarningStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "TWITTER_WARNING_STATUS_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.PRIVACY_WARNING_TEXT)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setPrivacyWarningText(String.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "PRIVACY_WARNING_TEXT == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.RECORD_FULL_DURATION)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setAlwaysRecordMax(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "RECORD_FULL_DURATION == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.FLASH_ON)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setFlashOn(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "FLASH_ON == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.MOTION_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setMotionStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "MOTION_STATUS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.AUDIO_DETECTION_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setAudioDetectionStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "AUDIO_DETECTION_STATUS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.ALWAYS_RECORD_MAX)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setAlwaysRecordMaxStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "ALWAYS_RECORD_MAX == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.REMOTE_CONNECTED_ROBOT)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setRobotConnectionStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "REMOTE_CONNECTED_ROBOT == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.PRIVACY_TEXT)) {
                        m_DeviceCommand.setPrivacyWarningText(String.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "PRIVACY_TEXT == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(PPCameraUtils.CameraParameter.CAMERA_NAME)) {
                        m_DeviceCommand.setPrivacyWarningText(String.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "CAMERA_NAME == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.MOTION_ACTIVATED_ALARM)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setMotionActivatedAlarm(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "MOTION_ACTIVATED_ALARM == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.CAMERA_ALARM)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setCameraAlarm(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "CAMERA_ALARM == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.SPEACKER_VOLUME)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setSpeakerVolume(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "SPEAKER_VOLUME == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_LOCATION)
                            && m_PPDeviceParameterInfoModel.getValue() != null && m_PPDeviceParameterInfoModel.getIndex() != null) {
                        m_DeviceCommand.setVantagePointLocation(Integer.valueOf(m_PPDeviceParameterInfoModel.getIndex()), m_PPDeviceParameterInfoModel.getValue());
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_LOCATION == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_TIMER)
                            && m_PPDeviceParameterInfoModel.getValue() != null && m_PPDeviceParameterInfoModel.getIndex() != null) {
                        m_DeviceCommand.setVantagePointTimer(Integer.valueOf(m_PPDeviceParameterInfoModel.getIndex()), Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()));
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_TIMER == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_CONFIG_STATUS)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setVantageConfigurationStatus(Integer.valueOf(m_PPDeviceParameterInfoModel.getValue()), false);
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_CONFIG_STATUS == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_NAME)
                            && m_PPDeviceParameterInfoModel.getValue() != null && m_PPDeviceParameterInfoModel.getIndex() != null) {
                        m_DeviceCommand.setVantagePointName(Integer.valueOf(m_PPDeviceParameterInfoModel.getIndex()), m_PPDeviceParameterInfoModel.getValue());
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_NAME == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_SEQUENCE)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setVantageSequence(m_PPDeviceParameterInfoModel.getValue());
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_SEQUENCE == " + m_PPDeviceParameterInfoModel.getValue());
                    } else if (m_PPDeviceParameterInfoModel.getName().equals(CameraParameter.VANTAGE_POINT_MOVE_INDEX)
                            && m_PPDeviceParameterInfoModel.getValue() != null) {
                        m_DeviceCommand.setVantagePointIndex(m_PPDeviceParameterInfoModel.getValue());
                        PPVirtuosoLogTrace.d(TAG, "VANTAGE_POINT_MOVE_INDEX == " + m_PPDeviceParameterInfoModel.getValue());
                    } else {
                        PPVirtuosoLogTrace.e(TAG, "You are not handling: %s with value %s",
                                m_PPDeviceParameterInfoModel.getName(),
                                m_PPDeviceParameterInfoModel.getValue());
                    }
                }
            }
        }
    }


    /**
     * Set Camera setting properties
     *
     * @param m_DevicePropertyModelArrayList
     * @param m_DeviceCommand
     */
    public static void setCameraSettingProperties(List<PPDevicePropertyModel> m_DevicePropertyModelArrayList,
                                                  PPDeviceCommand m_DeviceCommand) {

        if (m_DevicePropertyModelArrayList.size() > 0 && m_DevicePropertyModelArrayList.get(0) != null) {
            for (PPDevicePropertyModel m_PPDevicePropertyInfoModel : m_DevicePropertyModelArrayList) {
                if (m_PPDevicePropertyInfoModel.getStrName().equals(PPCameraUtils.CameraParameter.TWITTER_AUTO_SHARING_ON)
                        && m_PPDevicePropertyInfoModel.getStrContent() != null) {
                    m_DeviceCommand.setTwitterAutoShare(Integer.valueOf(m_PPDevicePropertyInfoModel.getStrContent()));
                } else if (m_PPDevicePropertyInfoModel.getStrName().equals(PPCameraUtils.CameraParameter.TWITTER_DESCRIPTION)
                        && m_PPDevicePropertyInfoModel.getStrContent() != null) {
                    m_DeviceCommand.setTwitterDescription(String.valueOf(m_PPDevicePropertyInfoModel.getStrContent()));
                }

            }
        }
    }


    /**
     * Getting device default parameter list to set on server
     *
     * @return {@link ArrayList} of {@link JSONObject} for default device
     * parameter list
     * @throws JSONException
     */
    public static ArrayList<JSONObject> prepareJSONForDeviceCamera(Context m_Context) throws JSONException {

        ArrayList<JSONObject> m_deviceDefaultParametersList = new ArrayList<JSONObject>();
        if (hasBackCamera(m_Context) && !hasFrontCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.REAR_ONLY_CAMERA)));
        } else if (hasBackCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.REAR_CAMERA)));
        } else if (hasFrontCamera(m_Context) && !hasBackCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.FRONT_ONLY_CAMERA)));
        } else if (hasFrontCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.FRONT_CAMERA)));
        } else {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.NO_CAMERA)));
        }

        if (hasBackCamera(m_Context) || hasFrontCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.CAMERA_CAPTURE_IMAGE, String.valueOf(CameraDefaultValue.DEFAULT_TAKE_A_PICTURE)));
        }

        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.CAMERA_CAPTURE_IMAGE, String.valueOf(CameraDefaultValue.DEFAULT_ALERT_ME_WITH_PICTURE)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.AUDIO_ON, String.valueOf(CameraDefaultValue.DEFAULT_AUDIO_ON)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.VIDEO_ON, String.valueOf(CameraDefaultValue.DEFAULT_VIDEO_ON)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.HD_RECORDING, String.valueOf(CameraDefaultValue.DEFAULT_HD_RECORDING)));
        // TODO add logic to seperate pro user and free user to add different
        // default values for seconds between motion detection
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.RAPID_MOTION_STATUS, String.valueOf(CameraDefaultValue.DEFAULT_FREE_USER_SECONDS_BETWEEN_MOTION_DETECTION)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.BLACKOUT_SCREEN, String.valueOf(CameraDefaultValue.DEFAULT_BLACKOUT_SCREEN)));
        if (isFlashLightSupport(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.FLASH_ON, String.valueOf(CurrentFlashValue.FLASH_OFF)));
        } else {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.FLASH_ON, String.valueOf(CurrentFlashValue.NO_FLASH)));
        }
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.ACCESS_CAMERA_SETTINGS, String.valueOf(1)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_COUNTDOWN_TIME, String.valueOf(CameraDefaultValue.DEFAULT_MOTION_COUNT_DOWN_TIME)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_STATUS, String.valueOf(CameraDefaultValue.DEFAULT_MOTION_DETECTION_STATUS)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.AUDIO_DETECTION_STATUS, String.valueOf(CameraDefaultValue.DEFAULT_AUDIO_DETECTION_STATUS)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.ALWAYS_RECORD_MAX, String.valueOf(CameraDefaultValue.RECORD_FULL_DURATION_DISABLE)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_SENSITIVITY, String.valueOf(CameraDefaultValue.MOTION_SENSITIVITY_DEVICE_INTERFACE_TINY)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_ACTIVATED_ALARM, String.valueOf(CameraDefaultValue.MOTION_ALARM_OFF)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.CAMERA_ALARM, String.valueOf(CameraDefaultValue.CAMERA_ALARM_OFF)));

        return m_deviceDefaultParametersList;
    }

    /**
     * Getting device parameter on server
     */
    public static ArrayList<JSONObject> JSONForEachParameterDeviceCamera(Context m_Context, String cameraParameter, String value) throws JSONException {

        ArrayList<JSONObject> deviceDefaultParameter = new ArrayList<JSONObject>();
        deviceDefaultParameter.add(prepareParameterObject(cameraParameter, value));

        return deviceDefaultParameter;
    }

    /**
     * Getting device previously set
     *
     * @return {@link ArrayList} of {@link JSONObject} for default device
     * parameter list
     * @throws JSONException
     */
    public static ArrayList<JSONObject> preparePreviousJSONForDeviceCamera(Context m_Context) throws JSONException {

        ArrayList<JSONObject> m_deviceDefaultParametersList = new ArrayList<JSONObject>();
        if (hasBackCamera(m_Context) && !hasFrontCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.REAR_ONLY_CAMERA)));
        } else if (hasBackCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.SELECTED_CAMERA))));
        } else if (hasFrontCamera(m_Context) && !hasBackCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.SELECTED_CAMERA))));
        } else if (hasFrontCamera(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.SELECTED_CAMERA))));
        } else {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.SELECTED_CAMERA, String.valueOf(CurrentCameraValue.NO_CAMERA)));
        }

        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.AUDIO_ON, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.AUDIO_ON))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.VIDEO_ON, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.VIDEO_ON))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.HD_RECORDING, String.valueOf(CameraDefaultValue.DEFAULT_HD_RECORDING)));
        // TODO add logic to seperate pro user and free user to add different
        // default values for seconds between motion detection
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.RAPID_MOTION_STATUS, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.RAPID_MOTION_STATUS))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.BLACKOUT_SCREEN, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.BLACKOUT_SCREEN))));
        if (isFlashLightSupport(m_Context)) {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.FLASH_ON, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.FLASH_ON))));
        } else {
            m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.FLASH_ON, String.valueOf(CurrentFlashValue.NO_FLASH)));
        }
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.ACCESS_CAMERA_SETTINGS, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.ACCESS_CAMERA_SETTINGS))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_COUNTDOWN_TIME, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.MOTION_COUNTDOWN_TIME))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_STATUS, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.MOTION_STATUS_PARAM))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.AUDIO_DETECTION_STATUS, String.valueOf(CameraDefaultValue.DEFAULT_AUDIO_DETECTION_STATUS)));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.ALWAYS_RECORD_MAX, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.ALWAYS_RECORD_MAX))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.MOTION_SENSITIVITY, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.MOTION_SENSITIVITY))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.TWITTER_WARNING_STATUS_ON, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.TWITTER_WARNING_STATUS_ON))));
        m_deviceDefaultParametersList.add(prepareParameterObject(CameraParameter.TWITTER_AUTO_SHARING_ON, String.valueOf(PPAppCenter.m_SharedPresence.getCameraParamInt(CameraParameter.TWITTER_AUTO_SHARING_ON))));

        return m_deviceDefaultParametersList;
    }

    public static ArrayList<JSONObject> prepareJSONForMotionAlert(JSONObject params) throws JSONException {
        ArrayList<JSONObject> m_MotionAlertParameterList = new ArrayList<JSONObject>();
//		if (PPApp.m_IsDebug) {
//			m_MotionAlertParameterList.add(prepareParameterObject("debug", params.getString("debug")));
//		}
        m_MotionAlertParameterList.add(prepareParameterObject("mediaType", params.getString("mediaType")));
        m_MotionAlertParameterList.add(prepareParameterObject("deviceModel", params.getString("deviceModel")));
//		m_MotionAlertParameterList.add(prepareParameterObject("deviceDesc", params.getString("deviceDesc")));
        m_MotionAlertParameterList.add(prepareParameterObject("videoCount", params.getString("videoCount")));
        m_MotionAlertParameterList.add(prepareParameterObject("fileRef", params.getString("fileRef")));
        return m_MotionAlertParameterList;
    }

    public static JSONObject prepareParameterObjectWithIndex(String name, String content, int index) throws JSONException {
        JSONObject m_deviceParameter = new JSONObject();
        m_deviceParameter.put("name", name);
        m_deviceParameter.put("value", content);
        m_deviceParameter.put("index", index);
        return m_deviceParameter;
    }

    /**
     * Get {@link JSONObject} of name and value of parameters attribute of
     * device
     *
     * @param name
     * @param content
     * @return {@link JSONObject}
     * @throws JSONException
     */
    public static JSONObject prepareParameterObject(String name, String content) throws JSONException {
        JSONObject m_deviceParameter = new JSONObject();
        m_deviceParameter.put("name", name);
        m_deviceParameter.put("value", content);
        return m_deviceParameter;
    }

    public static JSONObject preparePropertiesObject(String name, String content) throws JSONException {
        JSONObject m_deviceParameter = new JSONObject();
        m_deviceParameter.put("name", name);
        m_deviceParameter.put("content", content);
        return m_deviceParameter;
    }

    /**
     * Detect front camera
     *
     * @param m_Context
     * @return
     */
    public static boolean hasFrontCamera(Context m_Context) {
        if (m_Context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)) {
            return true;
        }
        return false;
    }

    /**
     * Detect back camera
     *
     * @param m_Context
     * @return
     */
    public static boolean hasBackCamera(Context m_Context) {
        if (m_Context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        }
        return false;
    }

    public static Object[] prepareDeviceParameters(PPDeviceCommand m_DeviceCommand) throws JSONException {
        ArrayList<JSONObject> m_DeviceParameterList = new ArrayList<JSONObject>();

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.SELECTED_CAMERA,
                String.valueOf(m_DeviceCommand.getSelectedCamera())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.STREAM_STATUS,
                String.valueOf(m_DeviceCommand.getStreamStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.FLASH_ON,
                String.valueOf(m_DeviceCommand.getFlashOn())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.AUDIO_ON,
                String.valueOf(m_DeviceCommand.getAudioStreaming())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.VIDEO_ON,
                String.valueOf(m_DeviceCommand.getVideoStreaming())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MOTION_STATUS,
                String.valueOf(m_DeviceCommand.getMotionStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.AUDIO_DETECTION_STATUS,
                String.valueOf(m_DeviceCommand.getAudioDetectionStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.RAPID_MOTION_STATUS,
                String.valueOf(m_DeviceCommand.getRapidMotionStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MOTION_RECORD_SECONDS,
                String.valueOf(m_DeviceCommand.getMotionRecordSeconds())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.ACCESS_CAMERA_SETTINGS,
                String.valueOf(m_DeviceCommand.getAccessCameraSettings())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MOTION_COUNTDOWN_TIME,
                String.valueOf(m_DeviceCommand.getMotionCountDownTime())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.BLACKOUT_SCREEN,
                String.valueOf(m_DeviceCommand.getBlackOutScreenOn())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.TWITTER_WARNING_STATUS_ON,
                String.valueOf(m_DeviceCommand.getTwitterWarningStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.TWITTER_AUTO_SHARING_ON,
                String.valueOf(m_DeviceCommand.getTwitterAutoShare())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.ALWAYS_RECORD_MAX,
                String.valueOf(m_DeviceCommand.getAlwaysRecordMaxStatus())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MOTION_SENSITIVITY,
                String.valueOf(m_DeviceCommand.getMotionSensitivity())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MOTION_ACTIVATED_ALARM,
                String.valueOf(m_DeviceCommand.getMotionActivatedAlarm())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.CAMERA_ALARM,
                String.valueOf(m_DeviceCommand.getCameraAlarm())));

        //Adding based on JIRA tickets..
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.VERSION,
                String.valueOf(m_DeviceCommand.getAppVersion())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.BATTERY_LEVEL,
                String.valueOf(m_DeviceCommand.getBatteryLevel())));

//		m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.CHARGING,
//				String.valueOf(m_DeviceCommand.getCharging())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MANUFACTURER,
                String.valueOf(PPCommonInfo.getDeviceManufacturer())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.MODEL,
                String.valueOf(PPCommonInfo.getPhoneModel())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.PRIVACY_WARNING_TEXT,
                String.valueOf(m_DeviceCommand.getPrivacyWarningText())));

        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject(CameraParameter.SPEACKER_VOLUME,
                String.valueOf(m_DeviceCommand.getSpeakerVolume())));

        return m_DeviceParameterList.toArray();
    }

    public static Object[] prepareDeviceProperties(PPDeviceCommand m_DeviceCommand) throws JSONException {
        ArrayList<JSONObject> m_DeviceParameterList = new ArrayList<JSONObject>();
        m_DeviceParameterList.add(PPCameraUtils.preparePropertiesObject(CameraParameter.TWITTER_AUTO_SHARING_ON,
                String.valueOf(m_DeviceCommand.getTwitterAutoShare())));

        m_DeviceParameterList.add(PPCameraUtils.preparePropertiesObject(CameraParameter.TWITTER_DESCRIPTION, String.valueOf(m_DeviceCommand.getTwitterDescription())));
        return m_DeviceParameterList.toArray();
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /**
     * Get error message.
     *
     * @param resultCode
     * @return
     */
    public static String getErrorMessage(int resultCode) {
        String strErrorMsg;
        switch (resultCode) {
            case 0:
                strErrorMsg = "successful";
                break;
            case 1:
                strErrorMsg = "internal error";
                break;
            case 2:
                strErrorMsg = "wrong API key";
                break;
            case 3:
                strErrorMsg = "wrong device authentication token";
                break;
            case 4:
                strErrorMsg = "wrong device ID or device has not been found";
                break;
            case 5:
                strErrorMsg = "wrong session ID";
                break;
            case 6:
                strErrorMsg = "camera not connected";
                break;
            case 7:
                strErrorMsg = "camera connected";
                break;
            case 8:
                strErrorMsg = "wrong parameter value";
                break;
            case 9:
                strErrorMsg = "missed mandatory parameter value";
                break;
            case 10:
                strErrorMsg = "ping received from server";
                break;
            default:
                strErrorMsg = "Unknown Error";
                break;
        }
        return strErrorMsg;
    }
}
