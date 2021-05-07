/**
 * @FileName : PPSharedPreferenceOfPresence.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : shared preference
 * @date : 2013. 8. 21.
 */
public class PPSharedPreferences {

    private Context m_context;
    private SharedPreferences m_pref;
    private SharedPreferences.Editor m_editor;

    /**
     *
     */
    public PPSharedPreferences(Context context, String strName) {
        this.m_context = context;
        m_pref = context.getSharedPreferences(strName, Activity.MODE_PRIVATE);
        m_editor = m_pref.edit();
    }

    public void setKeyStringValue(String key, String value) {
        m_editor.putString(key, value);
        m_editor.commit();
    }

    public String getKeyStringValue(String key) {
        return m_pref.getString(key, null);
    }

    public void setKeyLongValue(String key, long value) {
        m_editor.putLong(key, value);
        m_editor.commit();
    }

    public long getKeyLongValue(String key) {
        return m_pref.getLong(key, -1);
    }

    public void setKeyIntValue(String key, int value) {
        m_editor.putInt(key, value);
        m_editor.commit();
    }

    public int getKeyIntValue(String key) {
        return m_pref.getInt(key, -1);
    }

    public void setKeyBooleanValue(String key, boolean value) {
        m_editor.putBoolean(key, value);
        m_editor.commit();
    }

    public boolean getKeyBooleanValue(String key) {
        return m_pref.getBoolean(key, false);
    }

    public void increaseAppOpenTimes() {
        int openTimes = getKeyIntValue(PPCommonInfo.REFERENCE_KEY_APP_TIMES);
        if (openTimes == 10) {
            return;
        }

        ++openTimes;
        if (openTimes > 8) {
            openTimes = 10;
        }
        setKeyIntValue(PPCommonInfo.REFERENCE_KEY_APP_TIMES, openTimes);
    }

    public boolean isAppOpenOverTenTimes() {
        int openTimes = getKeyIntValue(PPCommonInfo.REFERENCE_KEY_APP_TIMES);
        return openTimes > 9;
    }

    public int getBundleStatus() {
        return m_pref.getInt(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS, -2);
    }

    public void clearCache() {
        String serverUrl = getServerCommunicationURL();
        String dynamicServerURL = getDynamicServerURL();
        String userPhone = getKeyStringValue(PPCommonInfo.REFERENCE_KEY_USER_LOGIN_PHONE);
        int countryIndex = getKeyIntValue(PPCommonInfo.REFERENCE_KEY_COUNTRY_CODE_INDEX);
        int mailLoginToggle = getKeyIntValue("MailLoginSupport");
        boolean bundleStatus = getKeyBooleanValue("bundle_finish");
        boolean isSupportWebsocketWatcher = getKeyBooleanValue("WebsocketStatusSupport");
        boolean isTutorialShowed = getKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_SHOW_TUTORIAL);
        m_editor.clear();
        m_editor.commit();

        setServerCommunicationURL(serverUrl);
        setDynamicServerURL(dynamicServerURL);
        setKeyIntValue("MailLoginSupport", mailLoginToggle);
        setKeyBooleanValue("WebsocketStatusSupport", isSupportWebsocketWatcher);
        setKeyIntValue(PPCommonInfo.REFERENCE_KEY_COUNTRY_CODE_INDEX, countryIndex);
        setKeyStringValue(PPCommonInfo.REFERENCE_KEY_USER_LOGIN_PHONE, userPhone);
        setKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_SHOW_TUTORIAL, isTutorialShowed);
        setKeyBooleanValue("bundle_finish", bundleStatus);
//        setUserKey(null);
//        setLocationId(null);
//        setNotificationToken("");
//        setRegisteredCamera(false);
//        setFcmRegistered(false);
//        setNumericCode("----");
//        setDuressCode("9111");
//        setKeyIntValue("LocationUserState", -1);
//        setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS, -1);
//        setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED, false);
//        setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_BETA_DATA_EXCEPTION, false);
//        setKeyBooleanValue("SandBoxKey", false);
    }

    /**
     * Set user password
     */
    public void setUserPwd(String sUserPwd) {
        m_editor.putString("UserPwd", sUserPwd);
        m_editor.commit();
    }

    /**
     * Get user password
     */
    public String getUserPwd() {
        return m_pref.getString("UserPwd", null);
    }

    /**
     * Set user duress
     */
    public void setDuressCode(String duress) {
        m_editor.putString("DuressCode", duress);
        m_editor.commit();
    }

    /**
     * Get user duress
     */
    public String getDuressCode() {
        return m_pref.getString("DuressCode", "9111");
    }

    /**
     * Set user code
     */
    public void setNumericCode(String code) {
        m_editor.putString("NumericCode", code);
        m_editor.commit();
    }

    /**
     * Get user code
     */
    public String getNumericCode() {
        return m_pref.getString("NumericCode", "----");
    }

    public void setDefaultDateTimes(long times) {
        m_editor.putLong("DefaultTimes", times);
        m_editor.commit();
    }

    /**
     * Get user code
     */
    public long getDefaultDateTimes() {
        return m_pref.getLong("DefaultTimes", 0);
    }

    /**
     * Set user key
     */
    public void setUserKey(String sUserKey) {
        m_editor.putString("UserKey", sUserKey);
        m_editor.commit();
    }

    /**
     * Get user key
     */
    public String getUserKey() {
        return m_pref.getString("UserKey", null);
    }

    /**
     * Set key expire
     */
    public void setKeyExpire(String sUserKey) {
        m_editor.putString("KeyExpire", sUserKey);
        m_editor.commit();
    }

    /**
     * Get key expire
     */
    public String getKeyExpire() {
        return m_pref.getString("KeyExpire", null);
    }

    /**
     * Set user name
     */
    public void setUserName(String sUserName) {
        m_editor.putString("UserName", sUserName);
        m_editor.commit();
    }

    public void setLoginUserName(String sUserName) {
        m_editor.putString("LoginUserName", sUserName);
        m_editor.commit();
    }

    /**
     * Get user name
     */
    public String getUserName() {
        return m_pref.getString("UserName", null);
    }

    public String getLoginUserName() {
        return m_pref.getString("LoginUserName", null);
    }

    /**
     * Set first name
     */
    public void setFirstName(String sUserName) {
        m_editor.putString("FirstName", sUserName);
        m_editor.commit();
    }

    /**
     * Get user name
     */
    public String getFirstName() {
        return m_pref.getString("FirstName", null);
    }

    /**
     * Set user name
     */
    public void setLastName(String sUserName) {
        m_editor.putString("LastName", sUserName);
        m_editor.commit();
    }

    /**
     * Get user name
     */
    public String getLastName() {
        return m_pref.getString("LastName", null);
    }

    /**
     * Set Notification(FCM) token
     */
    public void setNotificationToken(String sToken) {
        m_editor.putString("token", sToken);
        m_editor.commit();
    }

    /**
     * Get Notification(FCM) token
     */
    public String getNotificationToken() {
        return m_pref.getString("token", "");
    }

    /**
     * Set application version
     */
    public void setAppVersion(int nAppVer) {
        m_editor.putInt("AppVer", nAppVer);
        m_editor.commit();
    }

    /**
     * Get application version
     */
    public int getAppVersion() {
        return m_pref.getInt("AppVer", 0);
    }


    public void recordLastDegree(int lastDegree) {
        m_editor.putInt("P360LastDegree", lastDegree);
        m_editor.commit();
    }

    /**
     * Get application version
     */
    public int getLastDegree() {
        return m_pref.getInt("P360LastDegree", -1);
    }

    /**
     * Set user Id
     */
    public void setUserId(String sUserId) {
        m_editor.putString("UserId", sUserId);
        m_editor.commit();
    }

    /**
     * Get current user email
     */
    public String getUserEmail() {
        return m_pref.getString("UserEmail", null);
    }

    /**
     * Set current user email
     */
    public void setUserEmail(String sUserEmail) {
        m_editor.putString("UserEmail", sUserEmail);
        m_editor.commit();
    }

    /**
     * Get current event for user location
     */
    public String getLocationEvent() {
        return m_pref.getString("LocationEvent", null);
    }

    /**
     * Set location event
     */
    public void setLocationEvent(String sLocationEvent) {
        m_editor.putString("LocationEvent", sLocationEvent);
        m_editor.commit();
    }

    /**
     * Get user Id
     */
    public String getUserId() {
        return m_pref.getString("UserId", null);
    }

    /**
     * Set location Id
     */
    public void setLocationId(String sLocationId) {
        m_editor.putString("LocationId", sLocationId);
        m_editor.commit();
    }

    /**
     * Get location Id
     */
    public String getLocationId() {
        return m_pref.getString("LocationId", null);
    }

    /**
     * Set location name
     */
    public void setLocationName(String sLocationName) {
        m_editor.putString("LocationName", sLocationName);
        m_editor.commit();
    }

    /**
     * GET location name
     */
    public String getLocationName() {
        return m_pref.getString("LocationName", null);
    }

    /**
     * Set isIdentityEnable
     */
    public void setIdentityEnable(boolean isIdentityEnable) {
        m_editor.putBoolean("ValidateIdentity", isIdentityEnable);
        m_editor.commit();
    }

    /**
     * Is Validate Identity
     */
    public boolean isValidateIdentity() {
        return m_pref.getBoolean("ValidateIdentity", true);
    }

    /**
     * Set NeedAddCallCenterContact
     */
    public void setNeedAddCallCenterContact(boolean needAddCallCenterContact) {
        m_editor.putBoolean("shouldAddCallCenterContact", needAddCallCenterContact);
        m_editor.commit();
    }

    /**
     * Is NeedAddCallCenterContact
     */
    public boolean isNeedAddCallCenterContact() {
        return m_pref.getBoolean("shouldAddCallCenterContact", true);
    }

    /**
     * Set timeStamp
     */
    public void setLastValidationTimeStamp(long timeStamp) {
        m_editor.putLong("LastValidationTimeStamp", timeStamp);
        m_editor.commit();
    }

    /**
     * get last ValidateTimeStamp
     */
    public long getLastValidationTimeStamp() {
        return m_pref.getLong("LastValidationTimeStamp", 0);
    }

    /**
     * Set step
     */
    public void setMonitorStep(int step) {
        m_editor.putInt("PlaceMonitorStep", step);
        m_editor.commit();
    }

    /**
     * Is Validate Identity
     */
    public int getMonitorStep() {
        return m_pref.getInt("PlaceMonitorStep", PPCommonInfo.PPIAPOOBEMarkerSecurityDefault);
    }

    /**
     * Set location demo
     */
    public void setLocationDemo(String sLocationDemo) {
        m_editor.putString("LocationDemo", sLocationDemo);
        m_editor.commit();
    }

    /**
     * Get Location Demo
     */
    public String getLocationDemo() {
        return m_pref.getString("LocationDemo", null);
    }

    /**
     * Set first time friend user
     */
    public void setFirstTimeFriend(boolean first) {
        m_editor.putBoolean("FirstTimeFriend", first);
        m_editor.commit();
    }

    /**
     * Get first time friend status
     */
    public boolean getFirstTimeFriend() {
        return m_pref.getBoolean("FirstTimeFriend", true);
    }

    /**
     * Set auto replay on/off
     *
     * @param replay true if on and false if off
     */
    public void setAutoReplay(boolean replay) {
        m_editor.putBoolean("AutoReplay", replay);
        m_editor.commit();
    }

    /**
     * Is auto replay on/off
     *
     * @return True if on and false otherwise
     */
    public boolean isAutoReplay() {
        return m_pref.getBoolean("AutoReplay", false);
    }

    /**
     * Set initialize setup
     */
    public void setInfoInitSetup(String sInitSetupDone) {
        m_editor.putString("InitSetupDone", sInitSetupDone);
        m_editor.commit();
    }

    /**
     * Get initialize setup
     */
    public String getInfoInitSetup() {
        return m_pref.getString("InitSetupDone", null);
    }

    /**
     * Set start day
     */
    public void setInfoStartDay(String sStartDay) {
        m_editor.putString("StartDay", sStartDay);
        m_editor.commit();
    }

    /**
     * Get start day
     */
    public String getInfoStartDay() {
        return m_pref.getString("StartDay", null);
    }

    public void setExedIntro(boolean bExedIntro) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("ExedIntro", bExedIntro);
        edit.commit();

    }

    public boolean getExedIntro() {
        return m_pref.getBoolean("ExedIntro", false);
    }

    /**
     * Set Login
     */
    public void setLongin(boolean bLogin) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("Login", bLogin);
        edit.commit();

    }

    /**
     * Get Login
     */
    public boolean getLogin() {
        return m_pref.getBoolean("Login", false);
    }

    /**
     * Set device page overlay
     */
    public void setOverlayDevice(boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("OverlayDevice", bOverlay);
        edit.commit();

    }

    /**
     * Get device page overlay
     */
    public boolean getOverlayDevice() {
        return m_pref.getBoolean("OverlayDevice", true);
    }

    /**
     * Set remote control overlay
     */
    public void setOverlayRemoteControl(boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("OverlayRemoteControl", bOverlay);
        edit.commit();

    }

    /**
     * Get remote control overlay
     */
    public boolean getOverlayRemoteControl() {
        return m_pref.getBoolean("OverlayRemoteControl", true);
    }

    /**
     * Set remote control overlay
     */
    public void setOverlayModes(boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("OverlayModes", bOverlay);
        edit.commit();

    }

    /**
     * Get remote control overlay
     */
    public boolean getOverlayModes() {
        return m_pref.getBoolean("OverlayModes", true);
    }


    public void setOverlayElectricity(String overlay, boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(overlay, bOverlay);
        edit.commit();

    }

    public boolean getOverlayElectricity(String overlay) {
        return m_pref.getBoolean(overlay, true);
    }

    public void setOverlayThermostat(String content, boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(content, bOverlay);
        edit.commit();

    }

    public boolean getOverlayThermostat(String content) {
        return m_pref.getBoolean(content, true);
    }

    /**
     * Set register
     */
    public void setRegister(boolean bRegister) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("Register", bRegister);
        edit.commit();
    }

    /**
     * Get register
     */
    public boolean getRegister() {
        return m_pref.getBoolean("Register", false);
    }

    /**
     * Set first video
     */
    public void setFirstVideo(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("SetVideo", bSet);
        edit.commit();
    }

    /**
     * Get first video
     */
    public boolean getFirstVideo() {
        return m_pref.getBoolean("SetVideo", true);
    }

    /**
     * Set device usage read
     */
    public void setUsageRead(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("SetRead", bSet);
        edit.commit();
    }

    /**
     * Get device usage read
     */
    public boolean getUsageRead() {
        return m_pref.getBoolean("SetRead", false);
    }

    /**
     * Set camera device
     */
    public void setCameraDevice(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("setCamera", bSet);
        edit.commit();
    }

    /**
     * Get cameram device
     */
    public boolean getCameraDevice() {
        return m_pref.getBoolean("setCamera", false);
    }

    /**
     * Set temp key
     */
    public void setTempKey(String sTempkey) {
        m_editor.putString("Tempkey", sTempkey);
        m_editor.commit();
    }

    /**
     * Get temp key
     */
    public String getTempKey() {
        return m_pref.getString("Tempkey", null);
    }

    /**
     * Set change password
     */
    public void setChangePassword(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("ChangePassword", bSet);
        edit.commit();
    }

    /**
     * Get change password
     */
    public boolean getChangePassword() {
        return m_pref.getBoolean("ChangePassword", false);
    }

    /**
     * Set billing rate
     */
    public void setBillingRate(String sBillRate) {
        m_editor.putString("BillRate", sBillRate);
        m_editor.commit();
    }

    /**
     * Get billing grate
     */
    public String getBillingRate() {
        return m_pref.getString("BillRate", null);
    }

    /**
     * Set device id
     */
    public void setDeviceId(String sId) {
        m_editor.putString("deviceId", sId);
        m_editor.commit();
    }

    /**
     * Get device id
     */
    //returned device id should be checked when using this Method (PPRuleDefaultList.java)
    public String getDeviceId() {
        return m_pref.getString("deviceId", null);
    }

    public Set<String> getAllKeys() {
        return m_pref.getAll().keySet();
    }

    //For notification. sKey NotificationMsg~ used.
    public void setNotificationMessage(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //For notification. sKey NotificationMsg~ used.
    public String getNotificationMessage(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //For notification. sKey NotificationMsg~ used.
    public void clearValue(String sKey) {
        m_editor.remove(sKey);
        m_editor.commit();
    }

    //For notification. sKey NotificationTime~ used.
    public void setNotificationDate(String sKey, String sDate) {
        m_editor.putString(sKey, sDate);
        m_editor.commit();
    }

    //For notification. sKey NotificationTime~ used.
    public String getNotificationDate(String sKey) {
        return m_pref.getString(sKey, null);
    }

    public void setNotificationTime(String sKey, Long when) {
        m_editor.putLong(sKey, when);
        m_editor.commit();
    }

    //For notification. sKey NotificationTime~ used.
    public long getNotificationTime(String sKey) {
        return m_pref.getLong(sKey, 0);
    }

    //For developerMode set
    public void setDeveloperMode(boolean setDeveloper) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("Deloper", setDeveloper);
        edit.commit();
    }

    //For check the current Mode
    public boolean isDeveloperMode() {
        return m_pref.getBoolean("Deloper", false);
    }

    //For developerMode Dialog popup
    public void setDeveloperDialog(boolean setDialog) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("Dialog", setDialog);
        edit.commit();
    }

    //For check the Dialog popup
    public boolean getDeveloperDialog() {
        return m_pref.getBoolean("Dialog", false);
    }

    //Store UUID
    public void setUuid(String sUuid) {
        m_editor.putString("uuid", sUuid);
        m_editor.commit();
    }

    //Get UUID
    public String getUuid() {
        return m_pref.getString("uuid", null);
    }

    public String getUuidForUserId(String sKey) {
        return m_pref.getString(sKey, null);
    }

    public void setUuidForUserId(String sKey, String sUuid) {
        m_editor.putString(sKey, sUuid);
        m_editor.commit();
    }

    //Set register camera when Camera register first login
    public void setRegisteredCamera(boolean setCamera) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("Camera", setCamera);
        edit.commit();
    }

    //Get register camera
    public boolean getRegisteredCamera() {
        return m_pref.getBoolean("Camera", false);
    }

    //set All Currency Unit
    public void setCurrencyUnit(String sUnit) {
        m_editor.putString("Unit", sUnit);
        m_editor.commit();
    }

    //Get All Currency Unit
    public String getCurrencyUnit() {
        return m_pref.getString("Unit", null);
    }

    //set All Current Device id
    public void setCurrentDeviceId(String sKey, String sId) {
        m_editor.putString(sKey, sId);
        m_editor.commit();
    }

    //Get All Current Device id
    public String getCurrentDeviceId(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Current time
    public void setCurrentTimeInfo(long mSec) {
        m_editor.putLong("timeInfo", mSec);
        m_editor.commit();
    }

    //Get Current time
    public long getCurrentTimeInfo() {
        return m_pref.getLong("timeInfo", 0L);
    }

    public void setCurrentTime(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("time", bSet);
        edit.commit();
    }

    public boolean getCurrentTime() {
        return m_pref.getBoolean("time", false);
    }

    //Set Firmware Version for monster key:monster device ID
    public void setFirmwareVersion(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Set Firmware Version for monster key:monster device ID
    public String getFirmwareVersion(String sKey) {
        return m_pref.getString(sKey, null);
    }


    //set Current Currency Code
    public void setCurrencyCode(String sUnit) {
        m_editor.putString("code", sUnit);
        m_editor.commit();
    }

    //Get Current Currency Symbol
    public String getCurrencyCode() {
        return m_pref.getString("code", null);
    }

    //set Current Currency Country name
    public void setCurrencyCountryName(String sUnit) {
        m_editor.putString("save_countryname", sUnit);
        m_editor.commit();
    }

    //Get Current Currency Country name
    public String getCurrencyCountryName() {
        return m_pref.getString("save_countryname", null);
    }

    //set Currency Code key: code ~
    public void setCurrencyCode(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Currency Code key: code ~
    public String getCurrencyCode(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Currency Symbol key: symbol ~
    public void setCurrencySymbol(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Currency Symbol key: symbol ~
    public String getCurrencySymbol(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Currency Symbol by country key: country ~
    public void setCurrencySymbolByCountryName(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Currency Symbol by country key: country ~
    public String getCurrencySymbolByCountryName(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Currency Symbol by country key: code ~
    public void setCurrencySymbolByCode(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Currency Symbol by country key: code ~
    public String getCurrencySymbolByCode(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Currency Symbol by country key: country ~
    public void setCurrencyCodeByCountryName(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Currency Symbol by country key: country ~
    public String getCurrencyCodeByCountryName(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set Country Name key: name ~
    public void setCountryNameByKey(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //Get Country Name key: name ~
    public String getCountryNameBykey(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //Being edited Email store
    public void setEditedEmail(String sEditeAccount) {
        m_editor.putString("editedaccount", sEditeAccount);
        m_editor.commit();
    }

    //Get edited Email address
    public String getEditedEmail() {
        return m_pref.getString("editedaccount", null);
    }

    //set Device id by key (key: "devicetype + number")
    public void setDeviceIdByKey(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //get Device id by key (key: "devicetype + number")
    public String getDeviceIdByKey(String sKey) {
        return m_pref.getString(sKey, null);
    }

    //set number of device by key (key: hdplug, monster ...)
    public void setDeviceNumByKey(String sKey, int nNum) {
        m_editor.putInt(sKey, nNum);
        m_editor.commit();
    }

    //get number of device
    public int getDeviceNumByKey(String sKey) {
        return m_pref.getInt(sKey, 0);
    }

    public void setRegistedDeviceName(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("registername", bSet);
        edit.commit();
    }

    public boolean getRegisteredDeviceName() {
        return m_pref.getBoolean("registername", false);
    }

    public void setFcmRegistered(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("fcmregistred", bSet);
        edit.commit();
    }

    public boolean getFcmRegistered() {
        return m_pref.getBoolean("fcmregistred", false);
    }

    //set H&D outlet update time (key: outlet)
    public void setDeviceStatusUpdatedTime(String sKey, String sMsg) {
        m_editor.putString(sKey, sMsg);
        m_editor.commit();
    }

    //get H&D outlet update time  (key: outlet)
    public String getDeviceStatusUpdatedTime(String sKey) {
        return m_pref.getString(sKey, null);
    }

    public void setUpdateTime(boolean bSet) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("updatetime", bSet);
        edit.commit();
    }

    public boolean getUpdateTime() {
        return m_pref.getBoolean("updatetime", false);
    }

    //set Dynamic ServerURL
    public void setDynamicServerURL(String sMsg) {
        m_editor.putString("SERVER_URL", sMsg);
        m_editor.commit();
    }

    //get Dynamic SeverURL
    public String getDynamicServerURL() {
        return m_pref.getString("SERVER_URL", null);
    }

    //set Server URL
    public void setServerCommunicationURL(String sUrl) {
        m_editor.putString("COMMUNICATION_URL", sUrl);
        m_editor.commit();
    }

    //get Sever URL
    public String getServerCommunicationURL() {
        return m_pref.getString("COMMUNICATION_URL", null);
    }

    // set Device Communication port
    public void setDeviceCommunicationPort(String sPort) {
        m_editor.putString("COMMUNICATION_PORT", sPort);
        m_editor.commit();
    }

    // get Device Communication port
    public String getDeviceCommunicationPort() {
        return m_pref.getString("COMMUNICATION_PORT", "8443");
    }

    // set WebApp Communication port
    public void setWebAppCommunicationPort(String sPort) {
        m_editor.putString("COMMUNICATION_PORT_WEBAPP", sPort);
        m_editor.commit();
    }

    // get WebApp Communication port
    public String getWebAppCommunicationPort() {
        return m_pref.getString("COMMUNICATION_PORT_WEBAPP", "443");
    }

    // set ESP Token for PPCAuthorization header value
    public void setEspToken(String authToken) {
        m_editor.putString("EspToken", authToken);
        m_editor.commit();
    }

    // Get ESP Token for PPCAuthorization header value
    public String getEspToken() {
        return m_pref.getString("EspToken", null);
    }

    /**
     *
     */
    public void setDeviceCommunicationHost(String sUri) {
        m_editor.putString("COMMUNICATION_HOST", sUri);
        m_editor.commit();
    }

    /**
     *
     */
    public String getDeviceCommunicationHost() {
        return m_pref.getString("COMMUNICATION_HOST", PPAppCenter.getServerUrl());
    }

    /**
     *
     */
    public void setWebAppCommunicationHost(String sUri) {
        m_editor.putString("COMMUNICATION_HOST_WEBAPP", sUri);
        m_editor.commit();
    }

    /**
     *
     */
    public String getWebAppsCommunicationHost() {
        return m_pref.getString("COMMUNICATION_HOST_WEBAPP", PPAppCenter.getServerUrl());
    }

    /**
     *
     */
    public void setDeviceCommunicationSSL(String sSsl) {
        m_editor.putString("COMMUNICATION_SSL", sSsl);
        m_editor.commit();
    }

    /**
     *
     */
    public String getDeviceCommunicationSSL() {
        return m_pref.getString("COMMUNICATION_SSL", "true");
    }

    /**
     *
     */
    public void setWebAppCommunicationSSL(String sSsl) {
        m_editor.putString("COMMUNICATION_SSL_WEBAPP", sSsl);
        m_editor.commit();
    }

    /**
     *
     */
    public String getWebAppCommunicationSSL() {
        return m_pref.getString("COMMUNICATION_SSL_WEBAPP", "true");
    }

    /**
     * Set Camera overlay
     */
    public void setOverlayCamera(boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("OverlayCamera", bOverlay);
        edit.commit();

    }

    /**
     * Get Camera overlay
     */
    public boolean getOverlayCamera() {
        return m_pref.getBoolean("OverlayCamera", true);
    }

    /**
     * Set Robot Mac Address
     */
    public void setRobotMacAddress(String sRobotAddress) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("RobotAddress", sRobotAddress);
        edit.commit();

    }

    /**
     * Get Robot Mac Address
     */
    public String getRobotMacAddress() {
        return m_pref.getString("RobotAddress", null);
    }

    /**
     * Set Kubi Mac Address
     */
    public void setKubiMacAddress(String sKubiAddress) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("KubiAddress", sKubiAddress);
        edit.commit();

    }

    /**
     * Get Kubi Mac Address
     */
    public String getKubiMacAddress() {
        return m_pref.getString("KubiAddress", null);
    }

    /**
     * set camera-motion_alert_period_seconds system property
     */
    public void setCameraMotionAlertPeriod(int seconds) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putInt("cameraMotionAlertPeriod", seconds);
        edit.commit();
    }

    /**
     * get camera-motion_alert_period_seconds system property
     */
    public int getCameraMotionAlertPeriod() {
        return m_pref.getInt("cameraMotionAlertPeriod", PPCameraUtils.CameraDefaultValue.DEFAULT_CAMERA_MOTION_ALERT_PERIOD_SECONDS);
    }


    /**
     * Maintain total number of motion recording files uploaded from device
     */
    public void incrementNumberOfFileUpload() {
        int m_TotalUpload = getTotalNumberOfFileUpload() + 1;
        m_editor.putInt("cameraMotionFileUpload", m_TotalUpload);
        m_editor.commit();
    }

    /**
     * Returns total numbers of video uploaded by this device
     */
    public int getTotalNumberOfFileUpload() {
        return m_pref.getInt("cameraMotionFileUpload", 1);
    }


    /**
     * Returns total numbers of seconds for video recorded for this device
     */
    public int getTotalNumberOfSecondsRecorded() {
        return m_pref.getInt("cameraMotionSecondsRecorded", 0);
    }


    /**
     * Maintain total number of seconds for Motion video recorded
     */
    public void incrementTotalNumberOfSecondsRecorded(int seconds) {
        int m_TotalSeconds = getTotalNumberOfSecondsRecorded() + seconds;
        m_editor.putInt("cameraMotionSecondsRecorded", m_TotalSeconds);
        m_editor.commit();

    }

    /**
     * To set dynamic changing cloud from url
     * @param url
     */
/*
    public void setCloudName(String url){
        String cloudName = "Production";
        if(url.contains("sbox.presencepro.com")){
            cloudName = "sbox";
        }else if(url.contains("app.presencepro.com")){
            cloudName = "Production";
        }else if(url.contains("developer")){
            cloudName = "Developer";
        }else if(url.contains("app.presencepro.cn")){
            cloudName = "China";
        }else if(url.contains("sbox.presencepro.cn")){
            cloudName = "China Sbox";
        }
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("cloudName", cloudName);
        edit.commit();
    }
*/

    /**
     * To get dynamic changing cloud url
     * @return
     */
    /*
	public String getCloudName(){
		return m_pref.getString("cloudName", "production");
	}
	*/

    /**
     * set previous flash value
     */
    public void setPreviousFlashValue(int value) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putInt("flashValue", value);
        edit.commit();
    }

    /**
     * get previous flash value
     */
    public int getPreviousFlashValue() {
        return m_pref.getInt("flashValue", 0);
    }

    /**
     * Set the next sequence value. this is called internally as it should be incremented each time we get the next value.
     */
    private void setSequenceValue(int value) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putInt("sequence", value);
        edit.commit();
    }

    /**
     * Get next available sequence value for device IO calls
     */
    synchronized public int getNextSequenceValue() {
        int iSequence = 10;
        iSequence = m_pref.getInt("sequence", iSequence);
        setSequenceValue(iSequence + 1);
        return iSequence;
    }

    /**
     * Set camera privacy warning text
     *
     * @param sText sKey: camera device id
     */
    public void setPrivacyWarningTxt(String sText, String sKey) {
        m_editor.putString(sKey, sText);
        m_editor.commit();
    }

    /**
     * Get camera privacy warning text sKey: camera device id
     */
    public String getPrivacyWarningTxt(String sKey) {
        return m_pref.getString(sKey, null);
    }


    /**
     * Set Camera Parameter value
     *
     * @param sKey: camera parameter name example: "audioStreaming"
     */
    public void setCameraParamInt(int nValue, String sKey) {
        m_editor.putInt(sKey, nValue);
        m_editor.commit();
    }

    /**
     * Get Camera Parameter value sKey: camera parameter name example: "audioStreaming"
     */
    public int getCameraParamInt(String sKey) {
        try {
            return m_pref.getInt(sKey, 0);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * Set Camera Parameter value
     *
     * @param sKey: camera parameter name example: "audioStreaming"
     */
    public void setCameraParamString(String sValue, String sKey) {
        m_editor.putString(sKey, sValue);
        m_editor.commit();
    }

    /**
     * Get Camera Parameter value sKey: camera parameter name example: "audioStreaming"
     */
    public String getCameraParamString(String sKey) {
        try {
            return m_pref.getString(sKey, null);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Get flag about changed camera parameter sKey: device id + "setCameraParam"
     */
    public boolean getChangedCameraParameter(String sKey) {
        return m_pref.getBoolean(sKey, false);
    }

    /**
     * Set if camera parameter change sKey: device id + "setCameraParam"
     */
    public void setChangedCameraParameter(boolean bChange, String sKey) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(sKey, bChange);
        edit.commit();

    }

    /**
     *
     */
    public void setGatewayDeviceId(String sDevceId) {
        m_editor.putString("gatewayId", sDevceId);
        m_editor.commit();
    }

    /**
     *
     */
    public String getGatewayDeviceId() {
        return m_pref.getString("gatewayId", null);
    }

    /**
     * Set device as Remote Control
     */
    public void setRemoteControl(boolean useRemote) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("useRemote", useRemote);
        edit.commit();

    }

    /**
     * Get device Remote Control setting
     */
    public boolean getRemoteControl() {
        return m_pref.getBoolean("useRemote", false);
    }

    /**
     * Set camera publisher mode
     */
    public void setPulibsherMode(boolean bPublisher) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("IsPublisher", bPublisher);
        edit.commit();

    }

    /**
     * Get camera publisher mode
     */
    public boolean getPulibsherMode() {
        return m_pref.getBoolean("IsPublisher", false);
    }

    /**
     * Set camera viewer mode
     */
    public void setViewerMode(boolean bViewer) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("IsViewer", bViewer);
        edit.commit();

    }

    /**
     * Get camera viewer mode
     */
    public boolean getViewerMode() {
        return m_pref.getBoolean("IsViewer", false);
    }


    /**
     * Set camera mode
     */
    public void setCameraMode(boolean bMode) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("CameraMode", bMode);
        edit.commit();
    }


    /**
     * Get camera mode
     */
    public boolean getCameraMode() {
        return m_pref.getBoolean("CameraMode", false);
    }

    /**
     * Set last camera device description
     */
    public void setLastCameraDescription(String description) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("LastCameraDesc", description);
        edit.commit();
    }


    /**
     * Get last camera device description
     */
    public String getLastCameraDescription() {
        return m_pref.getString("LastCameraDesc", "");
    }

    /**
     * Set last viewed device description
     */
    public void setLastViewedDescription(String description) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("LastViewedDesc", description);
        edit.commit();
    }


    /**
     * Get last viewed device description
     */
    public String getLastViewedDescription() {
        return m_pref.getString("LastViewedDesc", "");
    }

    /**
     * Set last viewed or camera device id
     */
    public void setLastDeviceId(String id) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("LastDeviceId", id);
        edit.commit();
    }


    /**
     * Get last viewed or camera device id
     */
    public String getLastDeviceId() {
        return m_pref.getString("LastDeviceId", null);
    }

    /**
     * Set last viewed or camera device type value
     */
    public void setLastDeviceType(int value) {
        m_editor.putInt("LastDeviceType", value);
        m_editor.commit();
    }

    /**
     * Get last viewed or camera device type value
     */
    public int getLastDeviceType() {
        return m_pref.getInt("LastDeviceType", 0);
    }

//    /**
//     * Set last viewed or camera robot type value
//     * @param value
//     */
//    public void setLastRobotType(int value) {
//        m_editor.putInt("LastRobotType", value);
//        m_editor.commit();
//    }
//
//    /**
//     * Get last viewed or camera robot type value
//     * @return
//     */
//    public int getLastRobotType() {
//        return m_pref.getInt("LastRobotType", 0);
//    }

    /**
     * Set camera name
     */
    public void setCameraName(String name) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("CameraName", name);
        edit.commit();
    }


    /**
     * Get camera name
     */
    public String getCameraName() {
        return m_pref.getString("CameraName", null);
    }


    public void setTermsOfServiceSignature(String sKey, String sTos) {
        m_editor.putString(sKey, sTos);
        m_editor.commit();
    }

    //Set Firmware Version for monster key:monster device ID
    public String getTermsOfServiceSignature(String sKey) {
        return m_pref.getString(sKey, null);
    }

    /**
     * Set Lint Alert
     */
    public void setLintAlert(boolean isLintAlert) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("LintAlert", isLintAlert);
        edit.commit();
    }

    /**
     * Get Lint Alert
     */
    public boolean getLintAlert() {
        return m_pref.getBoolean("LintAlert", false);
    }

    /**
     * Set DDNS for IP Camera
     */
    public void setIPCamDDNS(String sDDNS) {
        m_editor.putString("IPCamDDNS", sDDNS);
        m_editor.commit();
    }

    /**
     * Get DDNS for IP Camera
     */
    public String getIPCamDDNS() {
        return m_pref.getString("IPCamDDNS", null);
    }

    /**
     * Set IP Address for IP Camera
     */
    public void setIPCamIPAddress(String sIPAdd) {
        m_editor.putString("IPCamIPAdd", sIPAdd);
        m_editor.commit();
    }

    /**
     * Get IP Address for IP Camera
     */
    public String getIPCamIPAddress() {
        return m_pref.getString("IPCamIPAdd", null);
    }

    /**
     * Set Port for IP Camera
     */
    public void setIPCamPort(String sIPCamPort) {
        m_editor.putString("IPCamPort", sIPCamPort);
        m_editor.commit();
    }

    /**
     * Get Port for IP Camera
     */
    public String getIPCamPort() {
        return m_pref.getString("IPCamPort", null);
    }

    /**
     * Set Admin for IP Camera
     */
    public void setIPCamAdmin(String sIPCamAdmin) {
        m_editor.putString("IPCamAdmin", sIPCamAdmin);
        m_editor.commit();
    }

    /**
     * Get Admin for IP Camera
     */
    public String getIPCamAdmin() {
        return m_pref.getString("IPCamAdmin", null);
    }

    /**
     * Set Password for IP Camera
     */
    public void setIPCamPassword(String sIPCamPass) {
        m_editor.putString("IPCamPass", sIPCamPass);
        m_editor.commit();
    }

    /**
     * Get Password for IP Camera
     */
    public String getIPCamPassword() {
        return m_pref.getString("IPCamPass", null);
    }

    /**
     * Set Timezone
     */
    public void setTimeZone(String tz) {
        m_editor.putString("TimeZone", tz);
        m_editor.commit();
    }

    /**
     * Get Timezone
     */
    public String getTimeZone() {
        return m_pref.getString("TimeZone", null);
    }

    /**
     * Set Rate this app date.
     * @param key
     * @param value
     */
//	public void setRateThisAppDate(String key, String value){
//		m_editor.putString(key, value);
//		m_editor.commit();
//	}
//
//	/**
//	 * Get Rate this app date.
//	 */
//	public String getRateThisAppDate(String key){
//		return m_pref.getString(key, null);
//	}
//
//	/**
//	 * Set Rate this app frequency.
//	 */
//	public void setRateThisAppFrequency(String key, int count){
//		m_editor.putInt(key, count);
//		m_editor.commit();
//	}
//	/**
//	 * Get Rate this app date.
//	 */
//	public int getRateThisAppFrequency(String key){
//		try {
//			return m_pref.getInt(key, 0);
//		} catch (Exception e) {
//			return 0;
//		}
//	}

    /**
     * Set send default parameter to server
     */
    public void setDefaultParamToServer(boolean bSent) {
        m_editor.putBoolean("defaultParam", bSent);
        m_editor.commit();
    }

    /**
     * Get send default parameter to server
     */
    public boolean getDefaultParamToServer() {
        return m_pref.getBoolean("defaultParam", false);
    }

    /**
     * Set Geofencing longitude
     */
    public void setLongitude(String userId, double longitude) {
        Double dLongitude = new Double(longitude);
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString(userId + "Longitude", dLongitude.toString());
        edit.commit();
    }

    /**
     * Get Geofencing longitude
     */
    public double getLongitude(String userId) {
        String sLongitude = m_pref.getString(userId + "Longitude", "0");
        double retVal = Double.parseDouble(sLongitude);
        return retVal;
    }

    /**
     * Set Geofencing latitude
     */
    public void setLatitude(String userId, double latitude) {
        Double dLatitude = new Double(latitude);
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString(userId + "Latitude", dLatitude.toString());
        edit.commit();
    }

    /**
     * Get Geofencing latitude
     */
    public double getLatitude(String userId) {
        String sLatitude = m_pref.getString(userId + "Latitude", "0");
        double retVal = Double.parseDouble(sLatitude);
        return retVal;
    }

    public boolean isDefaultLocation(String userId) {
        double latitude = getLatitude(userId);
        double longitude = getLongitude(userId);
        return isZero(latitude, 0.0000001) && isZero(longitude, 0.0000001);
    }

    private boolean isZero(double value, double threshold) {
        return value >= -threshold && value <= threshold;
    }

    /**
     * Set Geofencing overlay
     */
    public void setOverlayGeofencing(boolean bOverlay) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("OverlayGeofencing", bOverlay);
        edit.commit();

    }

    /**
     * Get Geofencing overlay
     */
    public boolean getOverlayGeofencing() {
        return m_pref.getBoolean("OverlayGeofencing", false);
    }

    /**
     * Set Allow Geofencing
     */
    public void setAllowGeofencing(String userId, boolean bAllow) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(userId + "AllowGeofencing", bAllow);
        edit.commit();

    }

    /**
     * Get Geofencing
     */
    public boolean getAllowGeofencing(String userId) {
        return m_pref.getBoolean(userId + "AllowGeofencing", false);
    }

    /**
     * Set skip new device setting
     */
    public void setSkipNewDeviceSetting(boolean bSkip) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean("SkipNewDeviceSetting", bSkip);
        edit.commit();

    }

    /**
     * Get skip new device setting
     */
    public boolean getSkipNewDeviceSetting() {
        return m_pref.getBoolean("SkipNewDeviceSetting", false);
    }

    public void setUserPermission(String userId, String menu, boolean bAllow) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(userId + menu, bAllow);
        edit.commit();
    }

    public boolean getUserPermission(String userId, String menu) {
        return m_pref.getBoolean(userId + menu, false);
    }


    public int getFlippedCamera(String userId) {
        return m_pref.getInt("flipRobotControl" + userId, -1);
    }


    public void setFlippedCamera(String userId, int cameraId) {
        m_editor.putInt("flipRobotControl" + userId, cameraId);
        m_editor.commit();
    }

    /**
     * Set TimeFormat
     */
    public void setTimeFormat(String userId, String timeFormat) {
        m_editor.putString(userId + "TimeFormat", timeFormat);
        m_editor.commit();
    }

    /**
     * Get TimeFormat
     */
    public String getTimeFormat(String userId) {
        return m_pref.getString(userId + "TimeFormat", "12");
    }

    public void setBadgeCount(String type, int count, String userId) {
        m_editor.putInt("BadgeCount" + type + userId, count);
        m_editor.commit();
    }

    public int getBadgeCount(String type, String userId) {
        return m_pref.getInt("BadgeCount" + type + userId, 0);
    }

    public void setBadgeTotal(int total, String userId) {
        m_editor.putInt("BadgeTotal" + userId, total);
        m_editor.commit();
    }

    public int getBadgeTotal(String userId) {
        return m_pref.getInt("BadgeTotal" + userId, 0);
    }

    public void setContactInformation(boolean bSet, String userId) {
        m_editor.putBoolean("SetContactInfo" + userId, bSet);
        m_editor.commit();
    }

    public boolean getContactInformation(String userId) {
        return m_pref.getBoolean("SetContactInfo" + userId, false);
    }

    public void setUploadFileList(String fileList) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString("UploadFileList", fileList);
        edit.commit();
    }

    public String getUploadFileList() {
        return m_pref.getString("UploadFileList", "");
    }


    public void setStoryBook(String type, boolean enable) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(type, enable);
        edit.commit();
    }

    public boolean isStoryBook(String type) {
        return m_pref.getBoolean(type, true);
    }

    public void setStoryBookTest(String type, boolean enable) {
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putBoolean(type, enable);
        edit.commit();
    }

    public boolean isStoryBookTest(String type) {
        return m_pref.getBoolean(type, false);
    }

    public void setDefaultSpaces(List<PPLocationSpaceModel> spaceList, String deviceType) {
        String spaceStr = "";
        if (null != spaceList && !spaceList.isEmpty()) {
            JSONArray array = JSONArray.parseArray(JSON.toJSONString(spaceList));
            spaceStr = array.toString();
        }
        int iDeviceType = Integer.parseInt(deviceType);
        if (iDeviceType == PPCommonInfo.INT_MOTION_SENSOR
            || iDeviceType == PPCommonInfo.INT_DEVELCO_MOTION_SENSOR) {
            deviceType = "MotionSensor";
        }
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString(String.format("type_%s", deviceType), spaceStr);
        edit.commit();
    }

    public List<PPLocationSpaceModel> getDefaultSpaces(String deviceType) {
        int iDeviceType = Integer.parseInt(deviceType);
        if (iDeviceType == PPCommonInfo.INT_MOTION_SENSOR
            || iDeviceType == PPCommonInfo.INT_DEVELCO_MOTION_SENSOR) {
            deviceType = "MotionSensor";
        }
        String json = m_pref.getString(String.format("type_%s", deviceType), "");
        return TextUtils.isEmpty(json) ? null : JSONObject.parseArray(json, PPLocationSpaceModel.class);
    }

    public void setDeviceSpace(List<PPLocationSpaceModel> spaceList, String deviceId) {
        String spaceStr = "";
        if (null != spaceList && !spaceList.isEmpty()) {
            JSONArray array = JSONArray.parseArray(JSON.toJSONString(spaceList));
            spaceStr = array.toString();
        }
        SharedPreferences.Editor edit = m_pref.edit();
        edit.putString(deviceId, spaceStr);
        edit.commit();
    }

    public List<PPLocationSpaceModel> getDeviceSpace(String deviceId) {
        String json = m_pref.getString(deviceId, "");
        return TextUtils.isEmpty(json) ? null : JSONObject.parseArray(json, PPLocationSpaceModel.class);
    }

    //Rate this App
    public void clearRateThisAppData() {
        SharedPreferences.Editor editor = m_pref.edit();
        editor.remove("rateInstallDate");
        editor.remove("rateLaunchTimes");
        editor.apply();
    }

    public void setAgreeShowDialog(boolean isAgree) {
        SharedPreferences.Editor editor = m_pref.edit();
        editor.putBoolean("rateShowDialog", isAgree);
        editor.apply();
    }

    public boolean getIsAgreeShowDialog() {
        return m_pref.getBoolean("rateShowDialog", true);
    }

    public void setRemindInterval() {
        SharedPreferences.Editor editor = m_pref.edit();
        editor.remove("rateRemindInterval");
        editor.putLong("rateRemindInterval", new Date().getTime());
        editor.apply();
    }

    public long getRemindInterval() {
        return m_pref.getLong("rateRemindInterval", 0);
    }

    public void setInstallDate() {
        SharedPreferences.Editor editor = m_pref.edit();
        editor.putLong("rateInstallDate", new Date().getTime());
        editor.apply();
    }

    public long getInstallDate() {
        return m_pref.getLong("rateInstallDate", 0);
    }

    public void setLaunchTimes(int launchTimes) {
        SharedPreferences.Editor editor = m_pref.edit();
        editor.putInt("rateLaunchTimes", launchTimes);
        editor.apply();
    }

    public int getLaunchTimes() {
        return m_pref.getInt("rateLaunchTimes", 0);
    }

    public boolean isFirstLaunch() {
        return m_pref.getLong("rateInstallDate", 0) == 0L;
    }
}
