/**
 * @FileName : PPDeviceCommand.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import android.text.TextUtils;
import android.util.SparseArray;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.util.PPCameraUtils;
import com.peoplepowerco.virtuoso.util.PPVantagePoint;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhargav
 *
 */
public class PPDeviceCommand {
    private static final String TAG = "PPDeviceCommand";

    public static final String EMPTY_SEQUENCE = "-1";

    public static final int CONFIG_STATUS_REBOOT = -1;
    public static final int CONFIG_STATUS_STOP = 0;
    public static final int CONFIG_STATUS_FIRST = 1;
    public static final int CONFIG_STATUS_SECOND = 2;
    public static final int CONFIG_STATUS_THIRD = 3;

    private int streamStatus;
    private int audioStreaming;
    private int videoStreaming;
    private int blackOutScreenOn;
    private int flashOn;
    private int cameraFocus;
    private int motionCountDownTime;
    private int motionSensitivity;
    private int motionStatus;
    private int audioDetectionStatus;
    private int motionRecordSeconds;
    private int rapidMotionStatus;
    private int selectedCamera;
    private int accessCameraSettings;
    private int recordStreamStatus;
    private int alwaysRecordMax;
    private int robotConnectionStatus;
    private int robotMotionDirection;
    private int robotMovementAngle;
    private int twitterAutoShare;
    private int twitterReminder;
    private int twitterStatus;
    private int twitterWarningStatus;
    private int twitterWebViewStatus;
    private int streamMode;
    private int callStatus;
    private int startCall;
    private int isInCall;
    private int charging;
    private int batteryLevel = 100;
    private int recordStatus;
    private int motionAlarmTimes;
    private int cameraAlarmTimes;
    //private int alarmTimesDisplay;
    private int motionAlarm;
    private int cameraAlarm;
    private int speakerVolume;

    //P360 support
    private String robotVantageSequence = EMPTY_SEQUENCE;
    private String robotVantagePointIndex;
    private List<PPVantagePoint> vantagePoints;
    private PPVantagePoint m_BadVantageData = new PPVantagePoint();
    private int vantageConfigurationStatus = 0;
    private int previousConfigurationsStatus = 0;

    private String cameraName;
    private String privacyWarningText;
    private String twitterDescription;
    private String twitterWarningText;
    private String timeZone;
    private String version;

    private int viewerCount;
    private int errorCode;
    private List<PPViewerDetails> m_ViewerDetails;
    private PPDeviceCommandInterface m_CommandInterface;
    private String m_sCommandValue;
    private boolean isRequestAllParam;
    private int requestAllParamCount = 0;

    //command queue hack for handled ids
    private static SparseArray<String> m_LastHandledCommands = new SparseArray<>(100);
    long m_LastHandledTimestamp = 0;

    /**
     * if true that means it is camera else it is viewer.
     * @param isCamera
     */
    public PPDeviceCommand(boolean isCamera) {
        m_sCommandValue = isCamera ? "setValue" : "value";
        vantagePoints = new ArrayList<>(3);
        PPVantagePoint vp1 = new PPVantagePoint();
        vp1.setIndex(0);
        PPVantagePoint vp2 = new PPVantagePoint();
        vp2.setIndex(1);
        PPVantagePoint vp3 = new PPVantagePoint();
        vp3.setIndex(2);
        vantagePoints.add(vp1);
        vantagePoints.add(vp2);
        vantagePoints.add(vp3);
    }

    /**
     * Gets and existing vantage point from a given index.
     * If the point does not exist, a new one is created and added to the list.
     * New vantage points will have their index set by this method.
     * @param index
     * @return
     */
    public PPVantagePoint getVantagePointAtIndex(int index) {
        if (index < vantagePoints.size()) {
            return vantagePoints.get(index);
        }
        return m_BadVantageData;
    }

    public void setVantagePointLocation(int index, String value) {
        //set index
        PPVantagePoint point = getVantagePointAtIndex(index);

        //handle seperation of 3 values (zoom, horiz, vert)
        String[] values = value.replace("[", "").replace("]", "").split(",");
        if (values.length == 3) {
            point.setZoom(values[0]);
            point.setHorizontalRotation(values[1]);
            point.setVerticalRotation(values[2]);
        }
    }

    public List<PPVantagePoint> getVantagePointLocations() {
        return vantagePoints;
    }

    public void setVantagePointTimer(int index, int seconds) {
        PPVantagePoint point = getVantagePointAtIndex(index);
        point.setTimerInSeconds(seconds);
    }

    public void setVantagePointName(int index, String name) {
        PPVantagePoint point = getVantagePointAtIndex(index);
        point.setName(name);
    }

    public void setVantageSequence(String sequence) {
        robotVantageSequence = sequence;
    }

    public void setVantagePointIndex(String index) {
        robotVantagePointIndex = index;
    }

    public String getVantagePointIndex() {
        return robotVantagePointIndex;
    }

    public String getVantageSequence() {
        return robotVantageSequence;
    }

    public int getVantageSequenceAtIndex(int index) {
        String[] sequence = getVantageSequence().split(",");
        int iRetVal = Integer.parseInt(sequence[index]);
        return iRetVal;
    }

    /**
     * Modified the vantage point sequence based on drag and drop tags.
     * Note: The index stored in drag and drop are absolute screen based index. (Not vantage index)
     * Thus a drag or drop value of "2" means there are 3 active Vantage points.
     * Any drag/drop other than 2 and we need to check our sequence split length to know
     * how to create the new sequence.
     * @param drag String value of the index that was dragged.
     * @param drop String value of the index that was dropped.
     * @return Returns the new vantage sequence string.
     */
    public String swapVantageSequence(String drag, String drop) {
        if (drag != null && drop != null &&
                !drag.isEmpty() && !drop.isEmpty() && !drag.equals(drop)) {
            try {
                StringBuilder sbNewOrder = new StringBuilder();
                String[] values = robotVantageSequence.split(",");
                int iDrag = Integer.parseInt(drag);
                int iDrop = Integer.parseInt(drop);

                switch (iDrag) {
                    case 2:
                        if (iDrop == 1) {
                            // order is 0, 2, 1
                            sbNewOrder.append(values[0]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[2]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[1]);
                            robotVantageSequence = sbNewOrder.toString();
                        } else {
                            // order is 2, 0, 1
                            sbNewOrder.append(values[2]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[0]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[1]);
                            robotVantageSequence = sbNewOrder.toString();
                        }
                        break;
                    case 1:
                        if (iDrop == 2) {
                            // order is 0, 2, 1
                            sbNewOrder.append(values[0]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[2]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[1]);
                            robotVantageSequence = sbNewOrder.toString();
                        } else {
                            // order is 1,0,2
                            sbNewOrder.append(values[1]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[0]);
                            if (values.length > 2) {
                                sbNewOrder.append(",");
                                sbNewOrder.append(values[2]);
                            }
                            robotVantageSequence = sbNewOrder.toString();
                        }
                        break;
                    case 0:
                        if (iDrop == 2) {
                            // order is 1,2,0
                            sbNewOrder.append(values[1]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[2]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[0]);
                            robotVantageSequence = sbNewOrder.toString();
                        } else {
                            // order is 1,0,2
                            sbNewOrder.append(values[1]);
                            sbNewOrder.append(",");
                            sbNewOrder.append(values[0]);
                            if (values.length > 2) {
                                sbNewOrder.append(",");
                                sbNewOrder.append(values[2]);
                            }
                            robotVantageSequence = sbNewOrder.toString();
                        }
                        break;
                    default:
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                PPVirtuosoLogTrace.e(TAG, "UNABLE TO CHANGE VANTAGE POINT SEQUENCE");
            }
        }

        return robotVantageSequence;
    }

    public int getFirstAvailableIndex() {
        if (!EMPTY_SEQUENCE.equals(robotVantageSequence)) {
            for (PPVantagePoint vp : vantagePoints) {
                if (!robotVantageSequence.contains("" + vp.getIndex())) {
                    vp.setName(null);
                    return vp.getIndex();
                }
            }
        }
        return 0;
    }

    public void addIndexToVantageSequence(int index) {
        if (EMPTY_SEQUENCE.equals(robotVantageSequence)) {
            robotVantageSequence = "" + index;
        } else {
            if (!robotVantageSequence.contains("" + index)) {
                robotVantageSequence += "," + index;
            }
        }
    }

    public String removeIndexFromVantageSequence(int index) {
        if (!EMPTY_SEQUENCE.equals(robotVantageSequence)) {
            String sIndex = "" + index;

            //set timer back to default
            vantagePoints.get(index).setTimerInSeconds(PPCameraUtils.CameraDefaultValue.DEFAULT_VANTAGE_POINT_WAIT_TIME);

            robotVantageSequence = robotVantageSequence.replace(sIndex, "");
            robotVantageSequence = robotVantageSequence.replace(",,", ",");

            if (robotVantageSequence.startsWith(",")) {
                robotVantageSequence = robotVantageSequence.substring(1);
            }

            if (robotVantageSequence.endsWith(",")) {
                int stopIndex = robotVantageSequence.length() - 1;
                robotVantageSequence = robotVantageSequence.substring(0, stopIndex);
            }

            if (robotVantageSequence.length() == 0) {
                robotVantageSequence = EMPTY_SEQUENCE;
            }
        }
        return robotVantageSequence;
    }

    public void setVantageConfigurationStatus(int status, boolean reset) {
        vantageConfigurationStatus = status;
        //reset is a fix for ANDROID-2198
        if (reset) {
            switch (vantageConfigurationStatus) {
                case CONFIG_STATUS_FIRST:
                    vantagePoints.get(0).reset();
                    break;
                case CONFIG_STATUS_SECOND:
                    vantagePoints.get(1).reset();
                    break;
                case CONFIG_STATUS_THIRD:
                    vantagePoints.get(2).reset();
                    break;
                default:
                    break;
            }
        }
    }

    public int getVantageConfigurationStatus() {
        return vantageConfigurationStatus;
    }

    public int getPreviousConfigurationStatus() {
        return previousConfigurationsStatus;
    }

    /**
     * Add viewer details
     * @param m_ViewerDetail
     */
    public void addViewer(PPViewerDetails m_ViewerDetail) {
        if (m_ViewerDetails == null)
            m_ViewerDetails = new ArrayList<PPDeviceCommand.PPViewerDetails>();
        m_ViewerDetails.add(m_ViewerDetail);
    }

    /**
     * Delete viewer details
     * @param viewerId
     */
    public void deleteViewer(String viewerId) {
        PPViewerDetails m_ViewerDetail = findViewerById(viewerId);
        if (m_ViewerDetail != null)
            m_ViewerDetails.remove(m_ViewerDetail);
    }

    /**
     * Find viewer details
     * @param viewerId
     * @return
     */
    public PPViewerDetails findViewerById(String viewerId) {
        if (m_ViewerDetails == null)
            return null;

        for (PPViewerDetails m_ViewerDetail : m_ViewerDetails) {
            if (m_ViewerDetail.viewerId.equals(viewerId))
                return m_ViewerDetail;
        }

        return null;
    }

    /**
     * Set CallBack according to web-socket command
     * @param m_CommandInterface
     */
    public void setCommandListner(PPDeviceCommandInterface m_CommandInterface) {
        if (m_CommandInterface == null)
            throw new NullPointerException("m_CommandInterface is null.");
        this.m_CommandInterface = m_CommandInterface;
    }

    /**
     * Check request all Param flag
     * @return
     */
    public boolean isRequestAllParam() {
        return this.isRequestAllParam;
    }

    /**
     * Set Request all Param flag
     */
    public void setRequestAllParam(int value) {
        this.isRequestAllParam = value == 0 ? false : true;
    }

    /**
     * get request all parameter count
     * @return
     */
    public int getRequestAllParamCount() {
        return requestAllParamCount;
    }

    /**
     * reset request all parameter count
     */
    public void resetRequestAllParamCount() {
        requestAllParamCount = 0;
    }

    /**
     * increment request all parameter count
     */
    public void incrementRequestAllParamCount() {
        requestAllParamCount++;
    }

    /**
     * Get current stream status
     * @return
     */
    public int getStreamStatus() {
        return streamStatus;
    }


    /**
     * Set stream status
     * @param streamStatus
     */
    public void setStreamStatus(int streamStatus) {
        this.streamStatus = streamStatus;
    }

    /**
     * Get Audio streaming status
     * @return
     */
    public int getAudioStreaming() {
        return audioStreaming;
    }

    /**
     * Set Audio streaming status
     * @param audioStreaming
     */
    public void setAudioStreaming(int audioStreaming) {
        this.audioStreaming = audioStreaming;
    }


    /**
     * Get Video streaming status
     * @return
     */
    public int getVideoStreaming() {
        return videoStreaming;
    }

    /**
     * Set Video streaming status
     * @param videoStreaming
     */
    public void setVideoStreaming(int videoStreaming) {
        this.videoStreaming = videoStreaming;
    }

    /**
     * Get Black out status
     * @return
     */
    public int getBlackOutScreenOn() {
        return blackOutScreenOn;
    }

    /**
     * Set Black out status
     * @param blackOutScreenOn
     */
    public void setBlackOutScreenOn(int blackOutScreenOn) {
        this.blackOutScreenOn = blackOutScreenOn;
    }

    public int getCameraFocus() {
        return cameraFocus;
    }

    public void setCameraFocus(int focus) {
        cameraFocus = focus;
    }

    /**
     * Get Flash status
     * @return
     */
    public int getFlashOn() {
        return flashOn;
    }

    /**
     * Set Flash status
     * @param flashOn
     */
    public void setFlashOn(int flashOn) {
        this.flashOn = flashOn;
    }

    /**
     * Get Motion sensitivity
     * @return
     */
    public int getMotionSensitivity() {
        return motionSensitivity;
    }

    /**
     * Set Motion sensitivity
     * @param sensitivity
     */
    public void setMotionSensitivity(int sensitivity) {
        this.motionSensitivity = sensitivity;
    }

    /**
     * Get Motion count-down time
     * @return
     */
    public int getMotionCountDownTime() {
        return motionCountDownTime;
    }

    /**
     * Set Motion count-down time
     * @param motionCountDownTime
     */
    public void setMotionCountDownTime(int motionCountDownTime) {
        this.motionCountDownTime = motionCountDownTime;
    }

    /**
     * Get Motion status
     * @return
     */
    public int getAudioDetectionStatus() {
        return audioDetectionStatus;
    }

    public void setAudioDetectionStatus(int audioDetectionStatus) {
        this.audioDetectionStatus = audioDetectionStatus;
    }

    public int getRobotConnectionStatus() {
        return robotConnectionStatus;
    }


    public void setRobotConnectionStatus(int robotConnectionStatus) {
        this.robotConnectionStatus = robotConnectionStatus;
    }


    public int getRobotMotionDirection() {
        return robotMotionDirection;
    }

    public void setRobotMotionDirection(int robotMotionDirection) {
        this.robotMotionDirection = robotMotionDirection;
    }


    public int getMotionStatus() {
        return motionStatus;
    }

    /**
     * Set Motion status
     * @param motionStatus
     */
    public void setMotionStatus(int motionStatus) {
        this.motionStatus = motionStatus;
    }

    /**
     * Get Motion Record seconds
     * @return
     */
    public int getMotionRecordSeconds() {
        return motionRecordSeconds;
    }

    /**
     * Set Motion Record seconds
     * @param motionRecordSeconds
     */
    public void setMotionRecordSeconds(int motionRecordSeconds) {
        this.motionRecordSeconds = motionRecordSeconds;
    }

    /**
     * Get Rapid motion status
     * @return
     */
    public int getRapidMotionStatus() {
        return rapidMotionStatus;
    }

    /**
     * Set Rapid motion status
     * @param rapidMotionStatus
     */
    public void setRapidMotionStatus(int rapidMotionStatus) {
        this.rapidMotionStatus = rapidMotionStatus;
    }

    /**
     * Set Always record max status
     * @param alwaysRecordMax
     */
    public void setAlwaysRecordMaxStatus(int alwaysRecordMax) {
        this.alwaysRecordMax = alwaysRecordMax;
    }

    /**
     * Get always record max status
     * @return
     */
    public int getAlwaysRecordMaxStatus() {
        return alwaysRecordMax;
    }

    /**
     * Get selected camera.
     * @return
     */
    public int getSelectedCamera() {
        return selectedCamera;
    }

    /**
     * Set selected camera
     * @param selectedCamera
     */
    public void setSelectedCamera(int selectedCamera) {
        this.selectedCamera = selectedCamera;
    }

    /**
     * Get camera access setting
     * @return
     */
    public int getAccessCameraSettings() {
        return accessCameraSettings;
    }

    /**
     * Set camera access setting
     * @param accessCameraSettings
     */
    public void setAccessCameraSettings(int accessCameraSettings) {
        this.accessCameraSettings = accessCameraSettings;
    }

    /**
     * Get camera name
     * @return
     */
    public String getCameraName() {
        return cameraName;
    }

    /**
     * Set camera name
     * @param cameraName
     */
    public void setCameraName(String cameraName) {
        this.cameraName = cameraName;
    }

    /**
     * Get privacy warning text
     * @return
     */
    public String getPrivacyWarningText() {
        return privacyWarningText;
    }

    /**
     * Set privacy warning text
     * @param privacyWarningText
     */
    public void setPrivacyWarningText(String privacyWarningText) {
        this.privacyWarningText = privacyWarningText;
    }

    /**
     * getTimeZone
     * @return
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * setTimeZone
     * @param strTimeZone
     */
    public void setTimeZone(String strTimeZone) {
        this.timeZone = strTimeZone;
    }

    /**
     *
     * @return
     */
    public int getRecordStreamStatus() {
        return recordStreamStatus;
    }

    /**
     *
     * @param recordStreamStatus
     */
    public void setRecordStreamStatus(int recordStreamStatus) {
        this.recordStreamStatus = recordStreamStatus;
    }

    /**
     * Get record status
     */
    public int getRecordStatus() {
        return recordStatus;
    }

    /**
     * Set record status
     */
    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    /**
     * Get call status
     * @return
     */
    public int getStartCall() {
        return startCall;
    }

    /**
     * Set call status
     * @param startCall
     */
    public void setStartCall(int startCall) {
        this.startCall = startCall;
    }

    /**
     * Get Half and full duplex streaming(command and notify to other viewer,viewer is in call).
     * @return
     */
    public int getIsInCall() {
        return isInCall;
    }

    /**
     * Set Half and full duplex streaming(command and notify to other viewer,viewer is in call).
     * @param isInCall
     */
    public void setIsInCall(int isInCall) {
        this.isInCall = isInCall;
    }

    /**
     * Get Primary and secondary stream.
     * @return
     */
    public int getStreamMode() {
        return streamMode;
    }

    /**
     * Set Primary and secondary stream.
     * @param streamMode
     */
    public void setStreamMode(int streamMode) {
        this.streamMode = streamMode;
    }

    /**
     * Get call status
     * @return
     */
    public int getCallStatus() {
        return callStatus;
    }

    /**
     * Set call status
     * @param callStatus
     */
    public void setCallStatus(int callStatus) {
        this.callStatus = callStatus;
    }

    /**
     *
     * @return
     */
    public int getTwitterAutoShare() {
        return twitterAutoShare;
    }


    public void setTwitterAutoShare(int twitterAutoShare) {
        this.twitterAutoShare = twitterAutoShare;
    }


    public String getTwitterDescription() {
        return twitterDescription;
    }


    public void setTwitterDescription(String twitterDescription) {
        this.twitterDescription = twitterDescription;
    }


    public int getTwitterReminder() {
        return twitterReminder;
    }


    public void setTwitterReminder(int twitterReminder) {
        this.twitterReminder = twitterReminder;
    }


    public int getTwitterStatus() {
        return twitterStatus;
    }


    public void setTwitterStatus(int twitterStatus) {
        this.twitterStatus = twitterStatus;
    }


    public int getTwitterWarningStatus() {
        return twitterWarningStatus;
    }


    public void setTwitterWarningStatus(int twitterWarningStatus) {
        this.twitterWarningStatus = twitterWarningStatus;
    }


    public String getTwitterWarningText() {
        return twitterWarningText;
    }


    public void setTwitterWarningText(String twitterWarningText) {
        this.twitterWarningText = twitterWarningText;
    }

    public int getTwitterWebViewStatus() {
        return twitterWebViewStatus;
    }


    public void setTwitterWebViewStatus(int twitterWebViewStatus) {
        this.twitterWebViewStatus = twitterWebViewStatus;
    }

    public int getMotionActivatedAlarm() {
        return motionAlarmTimes;
    }

    public void setMotionActivatedAlarm(int times) {
        this.motionAlarmTimes = times;
    }

    public int getCameraAlarm() {
        return cameraAlarmTimes;
    }

    public void setCameraAlarm(int times) {
        this.cameraAlarmTimes = times;
    }

    public int getSpeakerVolume() {
        return speakerVolume;
    }

    public void setSpeakerVolume(int speakerVolume) {
        this.speakerVolume = speakerVolume;
    }
    //	public int getMotionActivatedDisplayAlarm(){
//		return alarmTimesDisplay;
//	}
//
//	public void setMotionActivatedDisplayAlarm(int times){
//		this.alarmTimesDisplay = times;
//	}

    /**
     * Get Record status.
     * @return
     */
    public int getAlwaysRecordMax() {
        return alwaysRecordMax;
    }

    /**
     * Set Record status.
     * @param alwaysRecordMax
     */
    public void setAlwaysRecordMax(int alwaysRecordMax) {
        this.alwaysRecordMax = alwaysRecordMax;
    }

    /**
     * Get number of viewer.
     * @return
     */
    public int getViewerCount() {
        return viewerCount;
    }

    /**
     * Set viewer count
     * @param viewerCount
     */
    public void setViewerCount(int viewerCount) {
        this.viewerCount = viewerCount;
    }

    /**
     * Get error code.
     * @return
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Set error code
     * @param errorCode
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Get charging value
     */
    public int getCharging() {
        return charging;
    }

    /**
     * Set charing value
     */
    public void setCharging(int charging) {
        this.charging = charging;
    }

    /**
     * Get battery level
     */
    public int getBatteryLevel() {
        return batteryLevel;
    }

    /**
     * Set battery level
     */
    public void setBatteryLevel(int level) {
        batteryLevel = level;
    }

    /**
     * Get App version
     */
    public String getAppVersion() {
        return version = PPCommonInfo.getAppVersion(PPAppCenter.m_Context);
    }

    /**
     * Parse data from json object
     * @param m_JsonObject
     */
    public void parseDataFromJson(JSONObject m_JsonObject) {
        if (m_JsonObject.containsKey("resultCode")) {
            try {
                int resultCode = m_JsonObject.getInteger("resultCode");
                JSONArray m_JsonParamArray = (m_JsonObject.containsKey("params")) ? m_JsonObject.getJSONArray("params") : null;
                JSONArray m_JsonViewerArray = (m_JsonObject.containsKey("viewers")) ? m_JsonObject.getJSONArray("viewers") : null;
                int viewerCount = (m_JsonObject.containsKey("viewersCount")) ? m_JsonObject.getInteger("viewersCount") : -1;
                if (viewerCount >= 0) {
                    if (m_CommandInterface != null)
                        m_CommandInterface.viewerCount(viewerCount);
                }
                switch (resultCode) {
                    case 0:
                        if (m_JsonParamArray != null) {
                            int jsonParamArrayCount = m_JsonParamArray.size();
                            for (int i = 0; i < jsonParamArrayCount; i++) {
                                JSONObject m_JsonObjectDataFromJsonParamArray = m_JsonParamArray.getJSONObject(i);
                                parseParamFromJsonObjectData(m_JsonObjectDataFromJsonParamArray, null);
                            }
                        }
                        if (m_JsonViewerArray != null) {
                            int jsonArrayCount = m_JsonViewerArray.size();
                            for (int i = 0; i < jsonArrayCount; i++) {
                                JSONObject m_JsonObjectDataFromJsonViewerArray = m_JsonViewerArray.getJSONObject(i);
                                parseViewerFromJsonObject(m_JsonObjectDataFromJsonViewerArray);
                            }
                        }
                        break;
                    case 1:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 2:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 3:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 4:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 5:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 6:
                        if (m_CommandInterface != null)
                            m_CommandInterface.cameraConnectedStatus(resultCode);
                        break;
                    case 7:
                        if (m_CommandInterface != null)
                            m_CommandInterface.cameraConnectedStatus(resultCode);
                        break;
                    case 8:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 9:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    case 10:
                        if (m_CommandInterface != null)
                            m_CommandInterface.pingPong(resultCode);
                        break;
                    case 30:
                        if (m_CommandInterface != null)
                            m_CommandInterface.errorCode(resultCode);
                        break;
                    default:
                        if (m_CommandInterface != null)
                            m_CommandInterface.unknownResultCode(resultCode);
                        break;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Parse the json object and request to server to update.
     * @param m_JsonObject
     */
    public synchronized boolean parseJsonInformationFromHttp(JSONObject m_JsonObject) {
        if (m_JsonObject.containsKey("status")) {
            try {
                String result = m_JsonObject.getString("status");
                if (result.equals("ACK") || result.equals("CONT")) {
                    if (!m_JsonObject.containsKey("commands")) {
                        return false;
                    }
                    JSONArray m_JsonParamArray = (m_JsonObject.containsKey("commands")) ? m_JsonObject.getJSONArray("commands") : null;
                    if (m_JsonParamArray != null) {
                        int jsonParamArrayCount = m_JsonParamArray.size();
                        for (int i = 0; i < jsonParamArrayCount; i++) {
                            JSONObject m_JsonObjectDataFromJsonParamArray = m_JsonParamArray.getJSONObject(i);
                            String m_sCommandId = (m_JsonObjectDataFromJsonParamArray.containsKey("commandId")) ? m_JsonObjectDataFromJsonParamArray.getString("commandId") : null;
                            int iCommandId = Integer.parseInt(m_sCommandId);
                            if (m_LastHandledCommands.get(iCommandId) == null) {
                                JSONArray m_JsonParameterArray = (m_JsonObjectDataFromJsonParamArray.containsKey("parameters")) ? m_JsonObjectDataFromJsonParamArray.getJSONArray("parameters") : null;
                                int jsonParameterArrayCount = m_JsonParameterArray.size();
                                for (int j = 0; j < jsonParameterArrayCount; j++) {
                                    if (m_JsonParameterArray != null) {
                                        JSONObject m_JsonObjectParameter = m_JsonParameterArray.getJSONObject(j);
                                        parseParamFromJsonObjectData(m_JsonObjectParameter, m_sCommandId);
                                    }
                                }

                                if (jsonParameterArrayCount > 0) {
                                    //TODO send to delete command...
                                    m_CommandInterface.commandResponse(m_sCommandId);

                                }
                                //TODO fix this clearing with proper timestamp
                                long elapsedTime = 0;
                                if (m_LastHandledTimestamp > 0) {
                                    elapsedTime = System.currentTimeMillis() - m_LastHandledTimestamp;
                                }
                                if ((elapsedTime >= 30000) || (m_LastHandledCommands.size() >= 100)) {
                                    m_LastHandledCommands.clear();
                                }
                                m_LastHandledCommands.put(iCommandId, m_sCommandId);
                                m_LastHandledTimestamp = System.currentTimeMillis();
                            } else {
                                PPVirtuosoLogTrace.e(TAG, "FOUND DUPLICATE COMMAND ID: " + iCommandId);
                                m_CommandInterface.commandResponse(m_sCommandId);
                            }
                            return true;
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * Parse Param from json object
     * @param m_JsonObject
     * @throws JSONException
     */
    private void parseParamFromJsonObjectData(JSONObject m_JsonObject, String sCommandId) throws JSONException {
        String m_sCommandName = (m_JsonObject.containsKey("name")) ? m_JsonObject.getString("name") : null;
        PPVirtuosoLogTrace.d(TAG, "Camera Parameter command Name = " + m_sCommandName);
        String commandValue = null;
        //TODO: Ensure that this is correct for handling stream status
//		if(!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equals(PPCameraUtils.CameraParameter.STREAM_STATUS)){
//			commandValue =(m_JsonObject.containsKey("setValue")) ? m_JsonObject.getString("setValue") : "0";
//		}else if (!TextUtils.isEmpty(m_sCommandName) && !m_sCommandName.equals(PPCameraUtils.CameraParameter.STREAM_STATUS)) {
        if (!TextUtils.isEmpty(m_sCommandName)) {
            if (m_JsonObject.containsKey("value")) {
                commandValue = (m_JsonObject.containsKey("value")) ? m_JsonObject.getString("value") : "0";
            } else if (m_JsonObject.containsKey("setValue")) {
                commandValue = (m_JsonObject.containsKey("setValue")) ? m_JsonObject.getString("setValue") : "0";
            } else if (m_JsonObject.containsKey("setValue") && m_JsonObject.containsKey("value")) {
                commandValue = (m_JsonObject.containsKey("value")) ? m_JsonObject.getString("value") : "0";
            }
        }
        PPVirtuosoLogTrace.d(TAG, "commandValue = " + commandValue);
        if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.STREAM_STATUS)) {
            if (m_sCommandValue.equalsIgnoreCase("value")) {
                streamStatus = (commandValue != null && !commandValue.equalsIgnoreCase("")) ? 1 : 0;
                PPVirtuosoLogTrace.d(TAG, "value ppc.streamStatus = " + streamStatus);
            } else if (m_sCommandValue.equalsIgnoreCase("setValue")) {
                streamStatus = Integer.parseInt(commandValue);
                PPVirtuosoLogTrace.d(TAG, "setValue ppc.streamStatus = " + streamStatus);
            }
            if (m_CommandInterface != null) {
                m_CommandInterface.streamStatus(streamStatus, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.AUDIO_ON)) {
            audioStreaming = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "audioStreaming= " + audioStreaming);
            if (m_CommandInterface != null) {
                m_CommandInterface.audioStreaming(audioStreaming);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VIDEO_ON)) {
            videoStreaming = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "videoStreaming= " + videoStreaming);
            if (m_CommandInterface != null) {
                m_CommandInterface.videoStreaming(videoStreaming);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.AVAILABLE_BYTES)) {
            //TODO

        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.BATTERY_LEVEL)) {
            //TODO

        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.CHARGING)) {
            //TODO

        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.BLACKOUT_SCREEN)) {
            blackOutScreenOn = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.blackoutScreenOn= " + blackOutScreenOn);
            if (m_CommandInterface != null) {
                m_CommandInterface.blackOutScreenStatus(blackOutScreenOn, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.FLASH_ON)) {
            flashOn = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.flashOn= " + flashOn);
            if (m_CommandInterface != null) {
                m_CommandInterface.flashStatus(flashOn, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.CAMERA_FOCUS)) {
            cameraFocus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.autoFocus= " + cameraFocus);
            if (m_CommandInterface != null) {
                m_CommandInterface.cameraFocus(cameraFocus, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.HD_RECORDING)) {
            //TODO

        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.MOTION_COUNTDOWN_TIME)) {
            motionCountDownTime = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.motionCountDownTime= " + motionCountDownTime);
            if (m_CommandInterface != null) {
                m_CommandInterface.motionCountDownTime(motionCountDownTime);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.MOTION_SENSITIVITY)) {
            motionSensitivity = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.motionSensitivity= " + motionSensitivity);
            if (m_CommandInterface != null) {
                m_CommandInterface.motionSensitivity(motionSensitivity, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.MOTION_STATUS)) {
            motionStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "motionStatus= " + motionStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.motionStatus(motionStatus, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.AUDIO_DETECTION_STATUS)) {
            audioDetectionStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "audioDetectionStatus= " + audioDetectionStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.detectAudio(audioDetectionStatus);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.MOTION_RECORD_SECONDS)) {
            motionRecordSeconds = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.recordSeconds= " + motionRecordSeconds);
            if (m_CommandInterface != null) {
                m_CommandInterface.motionRecordSeconds(motionRecordSeconds, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.ALWAYS_RECORD_MAX)) {
            alwaysRecordMax = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.alwaysRecordMax= " + alwaysRecordMax);
            if (m_CommandInterface != null) {
                m_CommandInterface.alwaysRecordMax(alwaysRecordMax);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.REMOTE_CONNECTED_ROBOT)) {
            robotConnectionStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.ppc.robotConnected= " + robotConnectionStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotConnection(robotConnectionStatus);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.ACCESS_CAMERA_SETTINGS)) {
            accessCameraSettings = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "accessCameraSettings= " + accessCameraSettings);
            if (m_CommandInterface != null) {
                m_CommandInterface.accessCameraSettings(accessCameraSettings);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.RAPID_MOTION_STATUS)) {
            rapidMotionStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.rapidMotionStatus= " + rapidMotionStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.rapidMotionStatus(rapidMotionStatus);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.SELECTED_CAMERA)) {
            selectedCamera = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "selectedCamera= " + selectedCamera);
            if (m_CommandInterface != null) {
                m_CommandInterface.selectedCamera(selectedCamera, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.CAMERA_NAME)) {
            cameraName = commandValue;
            PPVirtuosoLogTrace.d(TAG, "ppc.cameraName= " + cameraName);
            if (m_CommandInterface != null) {
                m_CommandInterface.cameraName(cameraName);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.RECORD_STREAM_STATUS)) {
            recordStreamStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "recordStatus= " + recordStreamStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.recordStreamStatus(recordStreamStatus);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.START_CALL)) {
            if (m_CommandInterface != null) {
                m_CommandInterface.startCall(commandValue);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.IN_CALL)) {
            isInCall = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "isInCall= " + isInCall);
            if (m_CommandInterface != null) {
                m_CommandInterface.isInCall(isInCall);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VIDEO_CAll_SESSION_ID)) {
            if (m_CommandInterface != null) {
                m_CommandInterface.videoCallSessionId(commandValue);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.ROBOT_MOVEMENT_ANGLE)) {
            robotMovementAngle = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.robotMovementAngle= " + robotMovementAngle);
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.ROBOT_MOTION_DIRECTION)) {
            robotMotionDirection = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.robotMotionDirection= " + robotMotionDirection);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotMotionDirection(robotMotionDirection, robotMovementAngle, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.TWITTER_REMINDER)) {
            twitterWarningStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.twitterReminder= " + twitterWarningStatus);
            if (m_CommandInterface != null) {
                m_CommandInterface.twitterWarningStatus(twitterWarningStatus);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.TWITTER_STATUS_ON)) {
            twitterAutoShare = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.twitterStatus= " + twitterAutoShare);
            if (m_CommandInterface != null) {
                m_CommandInterface.twitterAutoShareStatus(twitterAutoShare, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.PRIVACY_TEXT)) {
            privacyWarningText = commandValue;
            PPVirtuosoLogTrace.d(TAG, "ppc.warningText= " + privacyWarningText);
            if (m_CommandInterface != null) {
                m_CommandInterface.privacyText(privacyWarningText);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.TIMEZONE)) {
            timeZone = commandValue;
            PPVirtuosoLogTrace.d(TAG, "timeZoneId= " + timeZone);
            if (m_CommandInterface != null) {
                m_CommandInterface.timeZone(timeZone);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.MOTION_ACTIVATED_ALARM)) {
            motionAlarm = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.motionAlarm = " + motionAlarm);
            if (m_CommandInterface != null) {
                m_CommandInterface.motionActivatedAlarm(motionAlarm, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.CAMERA_ALARM)) {
            cameraAlarm = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.alarm = " + cameraAlarm);
            if (m_CommandInterface != null) {
                m_CommandInterface.cameraAlarm(cameraAlarm, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.SPEACKER_VOLUME)) {
            speakerVolume = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.outputVolume = " + speakerVolume);
            if (m_CommandInterface != null) {
                m_CommandInterface.speakerVolume(speakerVolume, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.ROBOT_ORIENTATION)) {
            int iValue = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.robotOrientation = " + iValue);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotOrientation(iValue, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.CAMERA_CAPTURE_IMAGE)) {
            int iValue = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, "ppc.captureImage = " + iValue);
            if (m_CommandInterface != null) {
                m_CommandInterface.cameraCaptureImage(iValue, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_NAME)) {
            if (commandValue.contains(":")) {
                String[] values = commandValue.replace("{", "").replace("}", "").split(":");
                int index = Integer.parseInt(values[0]);
                String name = values[1];
                PPVantagePoint point = getVantagePointAtIndex(index);
                point.setName(name);
                PPVirtuosoLogTrace.d(TAG, PPCameraUtils.CameraParameter.VANTAGE_POINT_NAME + " = " + commandValue);
                if (m_CommandInterface != null) {
                    m_CommandInterface.robotVantageName(point, sCommandId);
                }
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_TIMER)) {
            if (commandValue.contains(":")) {
                String[] values = commandValue.replace("{", "").replace("}", "").split(":");
                int index = Integer.parseInt(values[0]);
                int iSeconds = Integer.parseInt(values[1]);
                PPVantagePoint point = getVantagePointAtIndex(index);
                point.setTimerInSeconds(iSeconds);
                PPVirtuosoLogTrace.d(TAG, PPCameraUtils.CameraParameter.VANTAGE_POINT_TIMER + " = " + commandValue);
                if (m_CommandInterface != null) {
                    m_CommandInterface.robotVantageTimer(point, sCommandId);
                }
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_SEQUENCE)) {
            robotVantageSequence = commandValue;
            PPVirtuosoLogTrace.d(TAG, PPCameraUtils.CameraParameter.VANTAGE_POINT_SEQUENCE + " = " + commandValue);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotVantageSequence(commandValue, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_CONFIG_STATUS)) {
            previousConfigurationsStatus = vantageConfigurationStatus;
            vantageConfigurationStatus = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, PPCameraUtils.CameraParameter.VANTAGE_POINT_CONFIG_STATUS + " = " + commandValue);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotVantageConfigurationStatus(vantageConfigurationStatus, sCommandId);
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_LOCATION)) {
            if (commandValue.contains(":")) {
                String[] values = commandValue.replace("{", "").replace("}", "").split(":");
                int index = Integer.parseInt(values[0]);
                String sLocation = values[1];
                setVantagePointLocation(index, sLocation);
                PPVantagePoint point = getVantagePointAtIndex(index);
                if (m_CommandInterface != null) {
                    m_CommandInterface.robotVantageSphericalCoordinates(point, sCommandId);
                }
            }
        } else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VANTAGE_POINT_MOVE_INDEX)) {
            int moveToIndex = Integer.parseInt(commandValue);
            PPVirtuosoLogTrace.d(TAG, PPCameraUtils.CameraParameter.VANTAGE_POINT_MOVE_INDEX + " = " + commandValue);
            if (m_CommandInterface != null) {
                m_CommandInterface.robotVantageMoveToIndex(moveToIndex, sCommandId);
            }
		} else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.VISUAL_COUNTDOWN)) {
			int value = Integer.parseInt(commandValue);
			PPVirtuosoLogTrace.d(TAG, "ppc.visualCountdown = " + value);
			if(m_CommandInterface != null) {
				m_CommandInterface.visualCountDown(value, sCommandId);
			}
		} else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.COUNTDOWN)) {
			int value = Integer.parseInt(commandValue);
			PPVirtuosoLogTrace.d(TAG, "ppc.countdown = " + value);
			if(m_CommandInterface != null) {
				m_CommandInterface.countDown(value, sCommandId);
			}
		} else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.PLAY_SOUND)) {
			PPVirtuosoLogTrace.d(TAG, "ppc.playSound = " + commandValue);
			if(m_CommandInterface != null) {
				m_CommandInterface.playSound(commandValue, sCommandId);
			}
		} else if (!TextUtils.isEmpty(m_sCommandName) && m_sCommandName.equalsIgnoreCase(PPCameraUtils.CameraParameter.NOTIFICATION)) {
			PPVirtuosoLogTrace.d(TAG, "ppc.notification = " + commandValue);
			if(m_CommandInterface != null) {
				m_CommandInterface.notification(commandValue, sCommandId);
			}
		} else {
			//THROW THIS FEATURE AWAY BUT WARN DEVELOPER!!!
			PPVirtuosoLogTrace.e(TAG, "You are not handling Command: %s, CommandId: %s", m_sCommandName, commandValue);
            m_CommandInterface.throwAway(m_sCommandName, sCommandId);
        }
    }

    /**
     * Parse viewer from json oject
     * @param m_JsonObject
     * @throws JSONException
     */
    public void parseViewerFromJsonObject(JSONObject m_JsonObject) throws JSONException {
        PPViewerDetails m_ViewerDetail = new PPViewerDetails();
        m_ViewerDetail.viewerId = (m_JsonObject.containsKey("id")) ? m_JsonObject.getString("id") : null;
        m_ViewerDetail.viewerStatus = (m_JsonObject.containsKey("status")) ? m_JsonObject.getString("status") : null;
        if (m_CommandInterface != null)
            m_CommandInterface.viewerStatus(m_ViewerDetail);
        if (m_ViewerDetail.viewerStatus.equals("-1"))
            deleteViewer(m_ViewerDetail.viewerId);
        else if (m_ViewerDetail.viewerStatus.equals("1"))
            addViewer(m_ViewerDetail);
    }

    /**
     *
     * @param m_DeviceParamModelArrayList
     */
    public void setValueToDeviceCommand(ArrayList<PPDeviceParameterModel> m_DeviceParamModelArrayList) {
        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand", "Invoked");
        if (m_DeviceParamModelArrayList != null) {
            ArrayList<PPDeviceParameterInfoModel> m_DeviceParameterInfoModels = m_DeviceParamModelArrayList.get(0).getDeviceParametersInfoModel();
            if (m_DeviceParameterInfoModels != null) {
                for (PPDeviceParameterInfoModel m_DeviceParameterInfoModel : m_DeviceParameterInfoModels) {
                    String m_sCommandName = m_DeviceParameterInfoModel.getName();
                    String commandValue = m_DeviceParameterInfoModel.getValue();
                    if (m_sCommandName.equals(PPCameraUtils.CameraParameter.STREAM_STATUS)) {
                        streamStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Stream Status ", "" + streamStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.AUDIO_ON)) {
                        audioStreaming = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Audio Streaming ", "" + audioStreaming);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.VIDEO_ON)) {
                        videoStreaming = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Video Streaming ", "" + videoStreaming);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.HD_RECORDING)) {
                        //TODO

                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.BATTERY_LEVEL)) {
                        //TODO

                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.CHARGING)) {
                        //TODO

                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.BLACKOUT_SCREEN)) {
                        blackOutScreenOn = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Black out Screen On ", "" + blackOutScreenOn);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.FLASH_ON)) {
                        flashOn = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Flash On ", "" + flashOn);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.MOTION_COUNTDOWN_TIME)) {
                        motionCountDownTime = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Motion Count Down Time ", "" + motionCountDownTime);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.MOTION_STATUS)) {
                        motionStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Motion Status", "" + motionStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.AUDIO_DETECTION_STATUS)) {
                        audioDetectionStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Audio Detection Status", "" + audioDetectionStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.MOTION_RECORD_SECONDS)) {
                        motionRecordSeconds = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Record Seconds ", "" + motionRecordSeconds);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.RAPID_MOTION_STATUS)) {
                        rapidMotionStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Rapid Motion Status ", "" + rapidMotionStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.SELECTED_CAMERA)) {
                        selectedCamera = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Selected Camera", "" + selectedCamera);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.ACCESS_CAMERA_SETTINGS)) {
                        accessCameraSettings = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand access Camera Settings ", "" + accessCameraSettings);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.CAMERA_NAME)) {
                        cameraName = m_sCommandName;
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Camera Name ", "" + cameraName);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.MOTION_SENSITIVITY)) {
                        motionSensitivity = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Motion Count Down Time ", "" + motionSensitivity);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TWITTER_AUTO_SHARING_ON)) {
                        twitterAutoShare = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Twitter Auto Share ", "" + twitterAutoShare);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TWITTER_DESCRIPTION)) {
                        twitterDescription = commandValue;
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Twitter DisplayInfoTestsDescription ", "" + twitterDescription);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TWITTER_REMINDER)) {
                        twitterReminder = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Twitter Reminder ", "" + twitterReminder);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TWITTER_STATUS_ON)) {
                        twitterStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Twitter Status ", "" + twitterStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TWITTER_WARNING_STATUS_ON)) {
                        twitterWarningStatus = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Warning Status ", "" + twitterWarningStatus);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.PRIVACY_WARNING_TEXT)) {
                        privacyWarningText = commandValue;
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand twitterWarningText ", "" + twitterWarningText);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.ALWAYS_RECORD_MAX)) {
                        alwaysRecordMax = Integer.parseInt(commandValue);
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand alwaysRecordMax ", "" + alwaysRecordMax);
                    } else if (m_sCommandName.equals("viewerRequestAllParams")) {
                        isRequestAllParam = Integer.parseInt(commandValue) == 0 ? false : true;
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand Request All Params ", "" + isRequestAllParam);
                    } else if (m_sCommandName.equals(PPCameraUtils.CameraParameter.TIMEZONE)) {
                        timeZone = commandValue;
                        PPVirtuosoLogTrace.d("Camera Parameter setValueToDeviceCommand TIMEZONE ", "" + timeZone);
                    } else if (m_sCommandName.equals("")) {

                    }
                }
            }
        }
    }

    public Object[] setDeviceParameters(ArrayList<PPDeviceParameterModel> m_DeviceParamModelArrayList) throws JSONException {
        ArrayList<JSONObject> m_DeviceParameterList = new ArrayList<JSONObject>();
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject("selectedCamera", String.valueOf(selectedCamera)));
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject("ppc.flashOn", String.valueOf(flashOn)));
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject("audioStreaming", String.valueOf(audioStreaming)));
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject("videoStreaming", String.valueOf(videoStreaming)));
        m_DeviceParameterList.add(PPCameraUtils.prepareParameterObject("accessCameraSettings", String.valueOf(accessCameraSettings)));
        return m_DeviceParameterList.toArray();

    }

    /**
     * @brief Get callback from web-socket command
     * @author bhargav
     *
     */
    public interface PPDeviceCommandInterface {
        void streamStatus(int value, String commandId);

        void audioStreaming(int value);

        void videoStreaming(int value);

        void blackOutScreenStatus(int value, String commandId);

        void flashStatus(int value, String commandId);

        void cameraFocus(int value, String commandId);

        void motionCountDownTime(int value);

        void motionSensitivity(int value, String commandID);

        void motionStatus(int value, String commandId);

        void detectAudio(int value);

        void motionRecordSeconds(int value, String commandId);

        void rapidMotionStatus(int value);

        void selectedCamera(int value, String commandId);

        void accessCameraSettings(int value);

        void cameraName(String sValue);

        void recordStreamStatus(int value);

        void startCall(String value);

        void isInCall(int value);

        void videoCallSessionId(String value);

        void robotConnection(int value);

        void robotMotionDirection(int value, int angle, String commandId);

        void robotOrientation(int value, String commandId);

        void cameraCaptureImage(int value, String commandId);

        void robotVantageConfigurationStatus(int value, String commandId);

        void robotVantageSphericalCoordinates(PPVantagePoint point, String commandId);

        void robotVantageTimer(PPVantagePoint point, String commandId);

        void robotVantageName(PPVantagePoint point, String commandId);

        void robotVantageSequence(String sequence, String commandId);

        void robotVantageMoveToIndex(int value, String commandId);

        void twitterAutoShareStatus(int value, String commandId);

        void twitterWarningStatus(int value);

        void privacyText(String sValue);

        void timeZone(String sValue);

        void alwaysRecordMax(int value);

        void motionActivatedAlarm(int times, String commandId);

        void cameraAlarm(int times, String commandId);

        void speakerVolume(int vol, String commandId);

		void countDown(int value, String commandId);
		void visualCountDown(int value, String commandId);
		void playSound(String sounds, String commandId);
		void notification(String message, String commandId);
		
		void viewerCount(int value);
		void errorCode(int value);
		void pingPong(int value);
		void viewerStatus(PPViewerDetails m_ViewerDetail);
		void cameraConnectedStatus(int value);
		void unknownResultCode(int value);
		void getLatestParamFromServer(boolean value);
		void charging(int value);
		void version(String sValue);
		void throwAway(String name, String commandId);

        void commandResponse(String commandId);
    }

    /**
     * @brief Save viewer details
     * @author bhargav
     *
     */
    public class PPViewerDetails {
        public String viewerStatus;
        public String viewerId;

        @Override
        public String toString() {
            return "viewerStatus:" + viewerStatus + " viewerId:" + viewerId;
        }
    }
}
