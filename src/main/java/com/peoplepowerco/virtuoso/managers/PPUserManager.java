/**
 * @FileName : PPUserManager.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.managers;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.handlers.PPServerResultHandler;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPCountryInfoModel;
import com.peoplepowerco.virtuoso.models.PPCountryInfoStatesModel;
import com.peoplepowerco.virtuoso.models.PPLocationModel;
import com.peoplepowerco.virtuoso.models.PPLoginByKeyModel;
import com.peoplepowerco.virtuoso.models.PPNotificationsModel;
import com.peoplepowerco.virtuoso.models.PPOperationTokenModel;
import com.peoplepowerco.virtuoso.models.PPSceneChangeResultModel;
import com.peoplepowerco.virtuoso.models.PPTermsOfServiceModel;
import com.peoplepowerco.virtuoso.models.PPUIScreenModel;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.models.PPUserModel;
import com.peoplepowerco.virtuoso.models.PPUserTotalsModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserCodeModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationBadgeModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationOrganizationModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserModel;
import com.peoplepowerco.virtuoso.network.PPCloudCallCommander;
import com.peoplepowerco.virtuoso.util.PPUtil;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;


/**
 * Manager for User's Information
 */
public class PPUserManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPUserManager.class.getSimpleName();
    private static PPUserManager instance = null;

    private PPUserModel m_UserModel;
    private PPOperationTokenModel m_operationalTokenModel = null;
    private PPUserInformationUserModel m_UserInformationUser = null;
    private PPLocationModel m_LocationModel;

    //    private List<PPUserInformationLocationModel> m_UserInformationLocationArrayList = null;
    private List<PPUserInformationServiceModel> m_UserInformationServiceArrayList = null;
    private List<PPUserInformationBadgeModel> m_UserInformationBadgeArrayList = null;
    private List<PPUserInformationOrganizationModel> m_UserInformationOrganizationArrayList = null;

    private List<PPCountryInfoModel> m_CountryInfoList = null;
    private Map<String, PPCountryInfoModel> m_CountryInfoMap = null;
    private Map<String, PPCountryInfoStatesModel> m_CountryStatesMap = null;
    private List<PPTermsOfServiceModel> m_TermsOfModelArrayList = null;

    private PPUserTotalsModel m_UserTotals = null;
    private PPLoginByKeyModel m_LoginByKeyModel = null;
    private List<PPUIScreenModel> m_UIScreenModelList = null;
    private List<PPNotificationsModel> m_notificationList = null;
    private List<PPUserCodeModel> m_UserCodeList = null;

    //LOCATION SCENES SUPPORT
    //result holder for scene change of a location
    public PPSceneChangeResultModel m_SceneChangeResult;
    private Realm m_Realm;

    public static final String PPOperationTokenTypeUserRegistration = "1";

    //Hardcoded default locations...
    public static final int MODE_HOME = 0;
    public static final int MODE_AWAY = 1;
    public static final int MODE_VACATION = 2;
    public static final int MODE_SLEEP = 3;
    public static final int MODE_STAY = 4;
    public static final int MODE_TEST = 5;
    public static final int MODE_UNKNOWN = 6;

    //Hardcoded default locations... TODO: make sure this is correct
    public static final String EVENT_OFF = "OFF";
    public static final String EVENT_HOME = "HOME";
    public static final String EVENT_AWAY = "AWAY";
    public static final String EVENT_VACATION = "VACATION";
    public static final String EVENT_SLEEP = "SLEEP";
    public static final String EVENT_STAY = "STAY";
    public static final String EVENT_TEST = "TEST";
    public static final String EVENT_UNKNOWN = "UNKNOWN";

    public static final String STR_HOME = PPVirtuoso.getInstance().getContext().getString(R.string.mode_home_readable);
    public static final String STR_AWAY = PPVirtuoso.getInstance().getContext().getString(R.string.mode_away_readable);
    public static final String STR_VACATION = PPVirtuoso.getInstance().getContext().getString(R.string.mode_vacation_readabale);
    public static final String STR_STAY = PPVirtuoso.getInstance().getContext().getString(R.string.mode_stay_readable);
    public static final String STR_SLEEP = PPVirtuoso.getInstance().getContext().getString(R.string.mode_sleep_readable);
    public static final String STR_TEST = PPVirtuoso.getInstance().getContext().getString(R.string.mode_test_readable);
    public static final String STR_UNKNOWN = PPVirtuoso.getInstance().getContext().getString(R.string.rules_mode_unknown);

    private String strCurrentEvent = EVENT_UNKNOWN;
    private String sLastPostedEvent = EVENT_UNKNOWN;

    /**
     * Hidden class constructor.
     */
    private PPUserManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPUserManager getInstance() {
        synchronized (PPUserManager.class) {
            if (instance == null) {
                instance = new PPUserManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        m_Realm = Realm.getDefaultInstance();
        m_CloudCommander = new PPCloudCallCommander(new PPServerResultHandler(this));
        m_Handlers = new HashMap<>(2);
        m_UserModel = new PPUserModel();
        m_LoginByKeyModel = new PPLoginByKeyModel();
        m_UserTotals = new PPUserTotalsModel();
        m_LocationModel = new PPLocationModel();
        m_SceneChangeResult = new PPSceneChangeResultModel();
        //For all user information
        m_UserInformationUser = new PPUserInformationUserModel();
        m_operationalTokenModel = new PPOperationTokenModel();
        m_UserInformationServiceArrayList = new ArrayList<>();
        m_UserInformationBadgeArrayList = new ArrayList<>();
        m_UserInformationOrganizationArrayList = new ArrayList<>();
        m_CountryInfoList = new ArrayList<>();
        m_CountryInfoMap = new HashMap<>();
        m_CountryStatesMap = new HashMap<>();
        m_TermsOfModelArrayList = new ArrayList<>();
        m_UIScreenModelList = new ArrayList<>();
        m_notificationList = new ArrayList<>();
        m_UserCodeList = new ArrayList<>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.m_Realm.close();
            instance.m_CloudCommander.clear();
            instance.m_Handlers.clear();
            instance.m_SceneChangeResult = null;
            instance.m_UserModel = null;
            instance.m_LoginByKeyModel = null;
            instance.m_UserTotals = null;
            instance.m_UserInformationUser = null;
            instance.m_UserInformationServiceArrayList.clear();
            instance.m_UserInformationServiceArrayList = null;
            instance.m_UserInformationBadgeArrayList.clear();
            instance.m_UserInformationBadgeArrayList = null;
            instance.m_UserInformationOrganizationArrayList.clear();
            instance.m_UserInformationOrganizationArrayList = null;
            instance.m_CountryInfoList.clear();
            instance.m_CountryInfoList = null;
            instance.m_CountryInfoMap.clear();
            instance.m_CountryInfoMap = null;
            instance.m_CountryStatesMap.clear();
            instance.m_CountryStatesMap = null;
            instance.m_TermsOfModelArrayList.clear();
            instance.m_TermsOfModelArrayList = null;
            instance.m_notificationList.clear();
            instance.m_notificationList = null;
            instance.m_UserCodeList.clear();
            instance.m_UserCodeList = null;
            instance.m_CloudCommander.exit();
            instance.m_CloudCommander = null;
            instance.m_Handlers = null;
            instance = null;
        }
    }

    public List<PPCountryInfoModel> getCountryInfo() {
        return m_CountryInfoList;
    }

    public PPCountryInfoModel getCountryInfoByCode(String countryCode) {
        if (!TextUtils.isEmpty(countryCode) && m_CountryInfoMap.containsKey(countryCode)) {
            return m_CountryInfoMap.get(countryCode);
        }
        return null;
    }

    public PPCountryInfoStatesModel getCountryStateByName(String name) {
        if (!TextUtils.isEmpty(name) && m_CountryStatesMap.containsKey(name)) {
            return m_CountryStatesMap.get(name);
        }
        return null;
    }

    public PPUserInfoModel getUserInfoModel() {
        String userId = PPAppCenter.m_SharedPresence.getUserId();
        return m_Realm.where(PPUserInfoModel.class)
            .equalTo("sUserInfoId", userId).findFirst();
    }

    public void updateCurrentUserInfo(final String firstName, final String lastName, final String communityName) {
        m_Realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                PPUserInfoModel userInfoModel = realm.where(PPUserInfoModel.class).equalTo("sUserInfoId",
                    PPAppCenter.m_SharedPresence.getUserId()).findFirst();
                if (null != userInfoModel) {
                    if (!TextUtils.isEmpty(firstName)) {
                        userInfoModel.sUserFirstName = firstName;
                    }
                    if (!TextUtils.isEmpty(firstName)) {
                        userInfoModel.sUserLastName = lastName;
                    }
                    if (!TextUtils.isEmpty(communityName)) {
                        userInfoModel.sCommunityName = communityName;
                    }
                }
            }
        });
    }

    public PPOperationTokenModel getOperationalTokenModel() {
        return m_operationalTokenModel;
    }

    public PPUserTotalsModel getUserTotals() {
        return m_UserTotals;
    }

    public List<PPUIScreenModel> getUIScreens() {
        return m_UIScreenModelList;
    }

    public List<PPTermsOfServiceModel> getTermsOfModelList() {
        return m_TermsOfModelArrayList;
    }

    public List<PPUserInformationLocationModel> getUserLocation() {
        return m_Realm.where(PPUserInformationLocationModel.class).equalTo("userId", PPAppCenter.m_SharedPresence.getUserId()).findAll();
    }

    public String getNewlyAddedLocationId() {
        return m_LocationModel.sLocationId;
    }

    public PPUserInformationLocationModel getCurrentUserLocation() {
        String locationId = PPAppCenter.m_SharedPresence.getLocationId();
        if (TextUtils.isEmpty(locationId)) {
            return null;
        }
        return m_Realm.where(PPUserInformationLocationModel.class).equalTo("id", Long.valueOf(locationId)).findFirst();
    }

    public boolean isCurrentLocationSiteOwner() {
        PPUserInformationLocationModel currentLocation = getCurrentUserLocation();
        return null != currentLocation && currentLocation.locationAccess == PPLocationUserManager.LOCATION_SECTION_TYPE_OWNER;
    }

    public int getLocationAccessLevel(String locationId) {
        if (null != locationId) {
            PPUserInformationLocationModel locationModel = m_Realm.where(PPUserInformationLocationModel.class)
                .equalTo("id", Long.valueOf(locationId))
                .findFirst();
            if (null != locationModel) {
                return locationModel.locationAccess;
            }
        }
        return PPLocationUserManager.LOCATION_SECTION_TYPE_NOT;
    }

    public List<PPNotificationsModel> getNotificationList() {
        return m_notificationList;
    }

    public List<PPUserInformationLocationModel> getAccessableLocations() {
        return m_Realm.where(PPUserInformationLocationModel.class)
            .notEqualTo("locationAccess", PPLocationUserManager.LOCATION_SECTION_TYPE_NONE)
            .findAll();
    }

    public void deleteLocation(String locationId) {
        long currentLocationId = getCurrentUserLocation().id;
        long deleteLocationId = Long.valueOf(locationId);
        final PPUserInformationLocationModel locationModel = m_Realm.where(PPUserInformationLocationModel.class)
            .equalTo("id", deleteLocationId).findFirst();
        if (null != locationModel) {
            m_Realm.executeTransaction(new Transaction() {
                @Override
                public void execute(Realm realm) {
                    locationModel.deleteFromRealm();
                }
            });
        }
        if (currentLocationId == deleteLocationId) {
            switchLocation(m_Realm.where(PPUserInformationLocationModel.class).findFirst());
        }
    }

    public PPUserInformationLocationModel getLocation(String locationId) {
        if (TextUtils.isEmpty(locationId)) {
            return m_Realm.where(PPUserInformationLocationModel.class)
                .notEqualTo("locationAccess", PPLocationUserManager.LOCATION_SECTION_TYPE_NONE)
                .findFirst();
        } else {
            return m_Realm.where(PPUserInformationLocationModel.class)
                .equalTo("id", Long.valueOf(locationId))
                .and()
                .notEqualTo("locationAccess", PPLocationUserManager.LOCATION_SECTION_TYPE_NONE)
                .findFirst();
        }
    }

    public boolean isCommunitiesInUserInfo() {
        PPUserCommunityModel userCommunityModel = m_Realm.where(PPUserCommunityModel.class).findFirst();
        PPUserInformationCommunityModel locationCommunityModel = m_Realm.where(PPUserInformationCommunityModel.class).findFirst();
        return null != userCommunityModel || null != locationCommunityModel;
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        switch (reqid) {
            case REQ_GET_ALL_USER_INFORMATION_NO_SWITCH:
                PPAppCenter.m_SharedPresence.setLocationId(null);
                initUserInfo();
                break;
            case REQ_GET_ALL_USER_INFORMATION:
                //Find out when to refresh user info;
                PPUserInformationLocationModel locationModel = getLocation(PPAppCenter.m_SharedPresence.getLocationId());
                if (null == locationModel) {
                    locationModel = getLocation(null);
                }
                if (null != locationModel && !TextUtils.isEmpty(locationModel.getEvent())) {
                    switchLocation(locationModel);
                } else {
                    PPAppCenter.m_SharedPresence.setLocationId(null);
                    initUserInfo();
                }
                break;
            case REQ_GET_USER_INFO_REFRESH:
//                PPUserInformationLocationModel switchedLocation = getLocation(PPAppCenter.m_SharedPresence.getLocationId());
//                if (null != switchedLocation && !TextUtils.isEmpty(switchedLocation.getEvent())) {
//                    switchLocation(switchedLocation);
//                }
                break;
            case REQ_POST_CHANGE_SCENE_AT_LOCATION:
                setCurrentLocation(sLastPostedEvent);
                break;
            default:
                break;
        }
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    private void initUserInfo() {
        m_Realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                String userId = String.valueOf(m_UserInformationUser.nId);
                PPUserInfoModel userInfo = realm.where(PPUserInfoModel.class)
                    .equalTo("sUserInfoId", userId)
                    .findFirst();
                if (null == userInfo) {
                    userInfo = realm.createObject(PPUserInfoModel.class, userId);
                }

                userInfo.sUserInfoName = m_UserInformationUser.sUserName;
                userInfo.sUserFirstName = m_UserInformationUser.sFirstName;
                userInfo.sUserLastName = m_UserInformationUser.sLastName;
                userInfo.sCommunityName = m_UserInformationUser.sCommunityName;
                userInfo.sFileUploadPolicy = String.valueOf(m_UserInformationUser.nFileUploadPolicy);
                userInfo.sPhoneNumber = m_UserInformationUser.sPhone;
                userInfo.sLanguage = m_UserInformationUser.sLanguage;
                userInfo.bAnonymous = m_UserInformationUser.bAnonymous;
                userInfo.sUserEmail = m_UserInformationUser.sUserEmail;
                userInfo.nMailStatus = m_UserInformationUser.nEmailStatus;
                userInfo.nPhoneType = m_UserInformationUser.nPhoneType;
                userInfo.nSmsStatus = m_UserInformationUser.nSmsType;
                userInfo.sUserVerified = m_UserInformationUser.bEmailVerified;
                userInfo.sUserStatus = String.valueOf(m_UserInformationUser.nEmailStatus);
                userInfo.iLocationCount = 0;

                PPAppCenter.m_SharedPresence.setUserId(userInfo.sUserInfoId);
                setCurrentLocation(userInfo.sUserInfoLoEvent);
            }
        });
    }

    public void switchLocation(final PPUserInformationLocationModel locationModel) {
        m_Realm.executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                String userId = String.valueOf(m_UserInformationUser.nId);
                PPUserInfoModel userInfo = realm.where(PPUserInfoModel.class)
                    .equalTo("sUserInfoId", userId)
                    .findFirst();
                if (null == userInfo) {
                    userInfo = realm.createObject(PPUserInfoModel.class, userId);
                }
                userInfo.sUserInfoName = m_UserInformationUser.sUserName;
                userInfo.sUserFirstName = m_UserInformationUser.sFirstName;
                userInfo.sUserLastName = m_UserInformationUser.sLastName;
                userInfo.sCommunityName = m_UserInformationUser.sCommunityName;
                userInfo.sFileUploadPolicy = String.valueOf(m_UserInformationUser.nFileUploadPolicy);
                userInfo.sPhoneNumber = m_UserInformationUser.sPhone;
                userInfo.sLanguage = m_UserInformationUser.sLanguage;
                userInfo.bAnonymous = m_UserInformationUser.bAnonymous;
                userInfo.sUserEmail = m_UserInformationUser.sUserEmail;
                userInfo.sUserVerified = m_UserInformationUser.bEmailVerified;
                userInfo.nMailStatus = m_UserInformationUser.nEmailStatus;
                userInfo.nPhoneType = m_UserInformationUser.nPhoneType;
                userInfo.nSmsStatus = m_UserInformationUser.nSmsType;
                userInfo.sUserStatus = String.valueOf(m_UserInformationUser.nEmailStatus);
                userInfo.iLocationCount = realm.where(PPUserInformationLocationModel.class).equalTo("userId", userId).findAll().size();
                userInfo.sUserInfoLoId = String.valueOf(locationModel.id);
                userInfo.sUserInfoLoName = locationModel.sName;
                userInfo.sUserInfoLoEvent = locationModel.sEvent;
                userInfo.sUserInfoStartDay = locationModel.sStartDate;
                userInfo.dLatitude = locationModel.dLatitude;
                userInfo.dLongitude = locationModel.dLongitude;

                if (null != locationModel.getUserInformationLocationTimezoneModel()) {
                    userInfo.stimezoneId = locationModel.getUserInformationLocationTimezoneModel().getId();
                    userInfo.stimezoneName = locationModel.getUserInformationLocationTimezoneModel().getName();
                    PPAppCenter.m_SharedPresence.setTimeZone(userInfo.stimezoneId);
                }

                PPAppCenter.m_SharedPresence.setUserId(userInfo.sUserInfoId);
                PPAppCenter.m_SharedPresence.setLocationId(userInfo.sUserInfoLoId);
                setCurrentLocation(userInfo.sUserInfoLoEvent);
            }
        });
    }

    public int getBadgeCountByType(int type) {
        if (!m_UserInformationBadgeArrayList.isEmpty()) {
            for (PPUserInformationBadgeModel badgeModel : m_UserInformationBadgeArrayList) {
                if (badgeModel.getType() == type) {
                    return badgeModel.getCount();
                }
            }
        }
        return 0;
    }

    /**
     * Find user has pro security or not.
     */
    public boolean isUserProSecurity() {
        PPUserInformationLocationModel currentLocation = getCurrentUserLocation();
        if (null != currentLocation) {
            for (PPUserInformationServiceModel ppUserInfoServiceModel : currentLocation.userInformationLocationServiceArrayList) {
                if (ppUserInfoServiceModel.getName() != null && ppUserInfoServiceModel.getName().contains("Avantguard")) {
                    int amount = ppUserInfoServiceModel.getAmount();
                    if (amount > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isServiceFamilyPredicate() {
        PPUserInformationLocationModel currentLocation = getCurrentUserLocation();
        if (null != currentLocation) {
            for (PPUserInformationServiceModel ppUserInfoServiceModel : currentLocation.userInformationLocationServiceArrayList) {
                if (ppUserInfoServiceModel.getName() != null && ppUserInfoServiceModel.getName().toLowerCase().contains("family")) {
                    int amount = ppUserInfoServiceModel.getAmount();
                    if (amount > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isServiceFamilyTrialPredicate() {
        PPUserInformationLocationModel currentLocation = getCurrentUserLocation();
        if (null != currentLocation) {
            for (PPUserInformationServiceModel ppUserInfoServiceModel : currentLocation.userInformationLocationServiceArrayList) {
                if (ppUserInfoServiceModel.getName() != null && ppUserInfoServiceModel.getName().equalsIgnoreCase("family.trial")) {
                    int amount = ppUserInfoServiceModel.getAmount();
                    if (amount > 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getCurrentState() {
        return strCurrentEvent;
    }

    public void setCurrentState(String state) {
        strCurrentEvent = state;
    }

    public boolean isStayMode() {
        return StringUtils.containsIgnoreCase(strCurrentEvent, EVENT_STAY);
    }

    public boolean isHomeMode(String mode) {
        return EVENT_HOME.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_HOME.toLowerCase());
    }

    public boolean isAwayMode(String mode) {
        return EVENT_AWAY.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_AWAY.toLowerCase());
    }

    public boolean isVacationMode(String mode) {
        return EVENT_VACATION.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_VACATION.toLowerCase());
    }

    public boolean isSleepMode(String mode) {
        return EVENT_SLEEP.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_SLEEP.toLowerCase());
    }

    public boolean isStayMode(String mode) {
        return EVENT_STAY.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_STAY.toLowerCase());
    }

    public boolean isTestMode(String mode) {
        return EVENT_TEST.equalsIgnoreCase(mode) || mode.toLowerCase().contains(EVENT_TEST.toLowerCase());
    }

    /**
     * Sets the users currently location in app only. This does not change the active location on the server. To change location with the server, use the proper server request method. The user of this
     * method has likely gotten the scene as part of the system/user properties and is updating things locally for users of this manager.
     */
    public void setCurrentLocation(String location) {
        if (StringUtils.containsIgnoreCase(location, EVENT_TEST)) {
            strCurrentEvent = EVENT_TEST;
        } else if (StringUtils.containsIgnoreCase(location, EVENT_AWAY)) {
            strCurrentEvent = EVENT_AWAY;
        } else if (StringUtils.containsIgnoreCase(location, EVENT_STAY)) {
            strCurrentEvent = EVENT_STAY;
        } else {
            strCurrentEvent = EVENT_HOME;
        }
    }

    public String getModeString(String eventName) {
        String sMode = STR_HOME;
        if (StringUtils.containsIgnoreCase(strCurrentEvent, EVENT_TEST)) {
            sMode = STR_TEST;
        } else if (StringUtils.containsIgnoreCase(strCurrentEvent, EVENT_AWAY)) {
            sMode = STR_AWAY;
        } else if (StringUtils.containsIgnoreCase(strCurrentEvent, EVENT_STAY)) {
            sMode = STR_STAY;
        } else {
            sMode = STR_HOME;
        }
        return sMode;
    }

    public List<PPUserCodeModel> getUserCodesList() {
        return m_UserCodeList;
    }

    /**
     * Get the final parsed result of the last request to change the scene.
     */
    public PPSceneChangeResultModel getSceneChangeResult() {
        return m_SceneChangeResult;
    }

    public void setSceneChangeResult(PPSceneChangeResultModel result) {
        this.m_SceneChangeResult = result;
    }

    public void serverRequestGetUserTotals(String tag) {
        JSONObject jsonObj = new JSONObject();

        try {
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
            jsonObj.put("devices", "true");
            jsonObj.put("files", "true");
            jsonObj.put("rules", "true");
            jsonObj.put("friends", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_TOTALS, jsonObj, m_UserTotals);
    }

    public void serverRequestGetUserTotalsOld(String tag) {
        JSONObject jsonObj = new JSONObject();

        try {
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
            jsonObj.put("devices", "true");
            jsonObj.put("files", "true");
            jsonObj.put("rules", "true");
            jsonObj.put("friends", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_TOTALS_OLD, jsonObj, m_UserTotals);
    }

    public void serverRequestUpdateSceneAtLocation(String tag, String location) {
        //first attempt to update the app location for validity
        sLastPostedEvent = location;

        //now make the server request
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("eventName", String.format("%s.%s", location, PPAppCenter.m_SharedPresence.getUserId()));
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_CHANGE_SCENE_AT_LOCATION, jsonObj, m_SceneChangeResult);
    }


    /**
     * Login to the selected cloud. https://<cloud>/cloud/json/login?username=username&expiry=expiry
     */
    public void serverRequestGetLoginUsername(String tag, String username, String pwd, String expiry) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", username);
            jsonObj.put("password", pwd);
            jsonObj.put("expiry", expiry);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_USERNAME, jsonObj, m_UserModel);
    }

    public void serverRequestGetLoginUsername(String tag, String username, String pwd, String expiry, PPUserModel userModel) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", username);
            jsonObj.put("password", pwd);
            jsonObj.put("expiry", expiry);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_USERNAME, jsonObj, userModel);
    }

    public void serverRequestGetLoginUsernameWithPasscode(String tag, String username, String passcode, String expiry) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", username);
            jsonObj.put("passcode", passcode);
            jsonObj.put("expiry", expiry);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_USERNAME, jsonObj, m_UserModel);
    }

    public void serverRequestGetLoginUsernameWithPasscode(String tag, String username, String passcode, String expiry,
        PPUserModel userModel) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", username);
            jsonObj.put("passcode", passcode);
            jsonObj.put("expiry", expiry);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_USERNAME, jsonObj, userModel);
    }

    /**
     * Login to the selected cloud by user key. https://<cloud>/cloud/json/loginByKey?keyType=keyType&expiry=expiry&clientId=clientId
     */
    public void serverRequestGetLoginKey(String tag, String keytype, String clientid, String expiry) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("clientId", clientid);
            jsonObj.put("keyType", keytype);
            jsonObj.put("expiry", expiry);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGIN_KEY, jsonObj, m_LoginByKeyModel);
    }

    /**
     * Logout of the selected cloud. https://<cloud>/cloud/json/logout
     */
    public void serverRequestGetLogout(String tag) {
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOGOUT, jsonObj);
    }

    //    // https://app.presencepro.com/cloud/json/user
//    public static final short REQ_POST_NEW_USER_AND_LOCATION        = 107;
    public void serverRequestPostNewUserAndLocation(String tag, String email, String pwd, String token, JSONObject userinfo) {

        if (userinfo == null) {
            JSONObject jsonObj = new JSONObject();
            try {
                jsonObj.put("username", email);
                jsonObj.put("password", pwd);
                jsonObj.put("email", email);
                jsonObj.put("TAG", tag);
                //NOTE For GCM Notification appName must be "androidPresence". Dmitry can change it later.
                //The appName value must be "Presence". Please check the ANDROID-136
                jsonObj.put("appName", PPAppCenter.APP_NAME);

            } catch (JSONException e) {
                e.printStackTrace();
            }

            m_CloudCommander.PostDataThreadPool(REQ_POST_NEW_USER_AND_LOCATION, jsonObj, m_UserModel, token);
        } else {
            userinfo.put("TAG", tag);
            m_CloudCommander.PostDataThreadPool(REQ_POST_NEW_USER_AND_LOCATION, userinfo, m_UserModel, token);
        }
    }

    public void serverRequestPostNewUserAndLocation(String token, PPUserModel userModel, JSONObject userinfo) {
        m_CloudCommander.PostDataThreadPool(REQ_POST_NEW_USER_AND_LOCATION, userinfo, userModel, token);
    }

    public void serverRequestGetOperationToken(String tag, String tokenType) {
        JSONObject jsonObj = new JSONObject();
        if (m_operationalTokenModel != null) {
            m_operationalTokenModel = null;
            m_operationalTokenModel = new PPOperationTokenModel();
        }
        try {
            jsonObj.put("tokenType", tokenType);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_OPERATION_TOKEN, jsonObj, m_operationalTokenModel);
    }

    public void serverRequestGetSendPasscode(String tag, String username, String type, String brand, String appName) {
        String hashKey = PPAppCenter.m_SharedPresence.getKeyStringValue(PPCommonInfo.KEY_FAMILY_APP_HASH_KEY);
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", username);
            jsonObj.put("type", type);
            jsonObj.put("brand", brand);
            jsonObj.put("appName", appName);
            if (!TextUtils.isEmpty(hashKey)) {
                jsonObj.put("prefix", "1");
                jsonObj.put("appHash", hashKey);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_SEND_PASSCODE, jsonObj);
    }

    public void serverRequestGetUserInfo(String tag, String userid, String organizationid, boolean needSwitchLocation) {
        if (needSwitchLocation) {
            serverRequestGetAllUserInfo(tag, userid, organizationid);
        } else {
            serverRequestGetUserInfoNoSwitchLocation(tag, userid, organizationid);
        }
    }

    public void serverRequestGetUserInfoNoSwitchLocation(String tag, String userid, String organizationid) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", userid);
            jsonObj.put("organizationId", organizationid);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_ALL_USER_INFORMATION_NO_SWITCH, jsonObj, m_UserInformationUser, m_UserInformationServiceArrayList,
            m_UserInformationBadgeArrayList, m_UserInformationOrganizationArrayList);
    }

    //Get all user information (include getting all information data from server. ex: user, location, service, badge, organization)
    public void serverRequestGetAllUserInfo(String tag, String userid, String organizationid) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", userid);
            jsonObj.put("organizationId", organizationid);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_ALL_USER_INFORMATION, jsonObj, m_UserInformationUser, m_UserInformationServiceArrayList,
            m_UserInformationBadgeArrayList, m_UserInformationOrganizationArrayList);
    }

    public void serverRequestGetCurrentEvent(String tag, String userid, String organizationid) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", userid);
            jsonObj.put("organizationId", organizationid);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_LOCATION_EVENT, jsonObj);
    }

    public void serverRequestRefreshUserInfo(String tag, String userid, String organizationid) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", userid);
            jsonObj.put("organizationId", organizationid);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //last param means need refresh all locations info;
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_INFO_REFRESH, jsonObj, m_UserInformationUser, m_UserInformationBadgeArrayList, true);
    }

    public void serverRequestRefreshUserLocation(String tag, String userid, String organizationid) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("userId", userid);
            jsonObj.put("organizationId", organizationid);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //last param means need refresh all locations info false means only current location;
        if (null != m_CloudCommander) {
            m_CloudCommander.GetDataThreadPool(REQ_GET_USER_LOCATION_REFRESH, jsonObj, m_UserInformationUser, m_UserInformationBadgeArrayList, false);
        }
    }

    public void serverRequestGetOtherUserInfo(String tag, String apiKey, PPUserModel userModel) {
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("apiKey", apiKey);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_OTHER_USER_INFORMATION, jsonObj, userModel);
    }

    //    // https://app.presencepro.com/cloud/json/user?userId=userId
//    public static final short REQ_PUT_UPDATE_USER_INFO              = 109;
    public void serverRequestPutUserInfo(String tag, String userid, String password, JSONObject userinfoJson) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (userid != null && !userid.isEmpty()) {
                jsonObj.put("userId", userid);
            }
            if (!TextUtils.isEmpty(password)) {
                jsonObj.put("password", password);
            }
            if (null != userinfoJson) {
                jsonObj.put("data", userinfoJson);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_USER_INFO, jsonObj);
    }

    public void serverRequestPutOtherUserInfo(String tag, String userid, String password, String token, JSONObject userinfoJson) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (userid != null && !userid.isEmpty()) {
                jsonObj.put("userId", userid);
            }
            if (!TextUtils.isEmpty(password)) {
                jsonObj.put("password", password);
            }
            if (!TextUtils.isEmpty(token)) {
                jsonObj.put("token", token);
            }
            if (null != userinfoJson) {
                jsonObj.put("data", userinfoJson);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_OTHER_USER_INFO, jsonObj);
    }

    //    // https://app.presencepro.com/cloud/json/user?userId=userId
//    public static final short REQ_DELETE_USER                       = 110;
    public void serverRequestDeleteUserInfo(String tag, String userid, int mergeOption, String mergeUserId, String mergeUserApiKey) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != userid) {
                jsonObj.put("userId", userid);
            }
            if (mergeOption != -1) {
                jsonObj.put("merge", mergeOption == 1 ? "true" : "false");
            }
            if (null != mergeUserId) {
                jsonObj.put("mergeUserId", mergeUserId);
            }
            if (null != mergeUserApiKey) {
                jsonObj.put("mergeUserApiKey", mergeUserApiKey);
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_USER, jsonObj);
    }

//    // https://app.presencepro.com/cloud/json/devices/<proxyId>/user
//    public static final short REQ_GET_USER_BY_DEVICE                = 111;

//    // https://app.presencepro.com/cloud/json/location?userId=userId
//    public static final short REQ_POST_ADD_USER_LOCATION            = 112;

//    // https://app.presencepro.com/cloud/json/location/<locationId>
//    public static final short REQ_PUT_UPDATE_LOCATION               = 113;

    /**
     * Request Update User Location
     */
    public void serverRequestPostUserAddLocation(JSONObject locationJson) {
        m_CloudCommander.PostDataThreadPool(REQ_POST_ADD_USER_LOCATION, locationJson, m_LocationModel);
    }

    /**
     * Request Update User Location
     */
    public void serverRequestPutUpdateLocation(JSONObject locationJson) {
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_LOCATION, locationJson);
    }

    /**
     * Request Delte User Location
     */
    public void serverRequestDeleteLocation(JSONObject locationJson) {
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_LOCATION, locationJson);
    }

//    // https://app.presencepro.com/cloud/json/location/<locationId>/event/<eventName>
//    public static final short REQ_POST_CHANGE_SCENE_AT_LOCATION     = 114;
//
//    // https://app.presencepro.com/cloud/json/location/<locationId>/events
//    public static final short REQ_GET_LOCATION_SCENE_HISTORY        = 115;
//
//    // https://app.presencepro.com/cloud/json/emailVerificationMessage?forward=forward&type=type
//    public static final short REQ_GET_SEND_VERIFICATION_MESSAGE     = 116;
//
//    // https://app.presencepro.com/cloud/json/emailVerificationMessage?type=type&code=code
//    public static final short REQ_PUT_PROVIDE_VERIFICATION_CODE     = 117;
//
//    // https://app.presencepro.com/cloud/json/newPassword?username=username&forward=forward
//    public static final short REQ_GET_RECOVER_PASSWORD              = 118;
//
//    // https://app.presencepro.com/cloud/json/newPassword?forward=forward
//    public static final short REQ_PUT_NEW_PASSWORD                  = 119;
//
//    // https://app.presencepro.com/cloud/json/badges?type=type
//    public static final short REQ_PUT_RESET_BADGES                  = 120;
//
//    // https://app.presencepro.com/cloud/json/termsOfServices/<signatureId>
//    public static final short REQ_PUT_SIGN_TOS                      = 121;

    /**
     * Put system property terms of service
     */
    public void serverRequestPutSignedTOS(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj
                .put("signatureId", PPVirtuoso.getInstance().getPrefs().getTermsOfServiceSignature(PPCommonInfo.ANDROID_TERMS_OF_SERVICE));
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SIGN_TOS, jsonObj);
    }

//    // https://app.presencepro.com/cloud/json/termsOfServices
//    public static final short REQ_GET_SIGNATURES                    = 122;

    /**
     * Request terms of service list
     */
    public void serverRequestGetSignatures(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SIGNATURES, jsonObj, new Object[]{m_TermsOfModelArrayList});
    }
//    // https://app.presencepro.com/cloud/json/callCenter
//    public static final short REQ_GET_CALL_CENTER                   = 123;
//
//    // https://app.presencepro.com/cloud/json/callCenter
//    public static final short REQ_PUT_UPDATE_CALL_CENTER            = 124;
//
//    // https://app.presencepro.com/cloud/json/callCenterAlerts
//    public static final short REQ_GET_CALL_CENTER_ALERTS            = 125;
//
//    // https://app.presencepro.com/cloud/json/countries?organizationId=organizationId&countryCode=countryCode
//    public static final short REQ_GET_COUNTRIES_STATES_TIME_ZONES   = 126;

    /**
     * Get country information
     */
    public void serverRequestGetCountryInformation(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("visitDatabase", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_COUNTRIES_STATES_TIME_ZONES, jsonObj,
            new Object[]{m_CountryInfoList, m_CountryInfoMap, m_CountryStatesMap});
        //User can dismiss loading wheel dialog only back key
    }

    public void serverRequestGetUiScreens(String tag, String appName, String version) {
        JSONObject jsonObj = new JSONObject();

        try {
//            jsonObj.put("appName", "presence-web");
            jsonObj.put("appName", appName);
            jsonObj.put("version", version);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_UI_SCREENS, jsonObj, m_UIScreenModelList);
    }

    /**
     * Request server login
     */
    public void serverRequestRecoverPassword(String tag, String sEmail) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("username", sEmail);
            jsonObj.put("brand", PPAppCenter.BRAND_NAME);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_RECOVER_PASSWORD, jsonObj);
    }

    public int getOrganizationIdByAppName(String appName) {
        for (PPUserInformationOrganizationModel organizationModel : m_UserInformationOrganizationArrayList) {
            if (organizationModel.getDonmainName().equals(appName)) {
//                PPLogTrace.i(TAG, "Domain name = " + organizationModel.getDonmainName());
//                PPLogTrace.i(TAG, "Organization ID = " + organizationModel.getId());
                return organizationModel.getId();
            }
        }
        return 0;
    }

    public void serverRequestResetBadges(String tag, String type) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("type", type);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_RESET_BADGES, jsonObj);
    }

    public void serverRequestNotifications(String tag, String startDate, String endDate) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("startDate", startDate);
            jsonObj.put("endDate", endDate);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_NOTIFICATIONS, jsonObj, m_notificationList);
    }

    public void serverRequestGetUserByPhoneOrMail(String tag, String phone, String mail, List<PPLocationUserModel> userModels) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_BY_PHONEORMAIL, jsonObj, m_notificationList);
    }

    public void serverRequestPostUserByPhoneOrMail(String tag, String phone, String mail, List<PPLocationUserModel> userModels) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            StringBuilder builder = new StringBuilder();
            builder.append("{");
            boolean appendComma = false;
            if (null != phone) {
                builder.append("\"phones\": [");
                builder.append(String.format("\"%s\"", phone));
                builder.append("]");
                appendComma = true;
            }
            if (null != mail) {
                if (appendComma) {
                    builder.append(",");
                }
                builder.append("\"emails\": [");
                builder.append(String.format("\"%s\"", mail));
                builder.append("]");
            }
            builder.append("}");
            jsonObj.put("data", builder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_USER_BY_PHONEORMAIL, jsonObj, new Object[]{userModels});
    }

    public void serverRequestNewPassword(String tag, String newPassword, String passcode) {
        JSONObject jsonParamObj = new JSONObject();
        JSONObject jsonBodyObj = new JSONObject();
        try {
            jsonParamObj.put("TAG", tag);
            jsonParamObj.put("brand", PPAppCenter.BRAND_NAME);
            jsonBodyObj.put("newPassword", newPassword);
            if (!PPUtil.isEmpty(passcode)) {
                jsonBodyObj.put("passcode", passcode);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_NEW_PASSWORD, jsonParamObj, jsonBodyObj);
    }

    public void serverRequestPutNewPassword(String tag, String oldPassword, String newPassword, String hashKey) {
        JSONObject jsonParamObj = new JSONObject();
        JSONObject jsonBodyObj = new JSONObject();
        try {
            jsonParamObj.put("TAG", tag);
            jsonParamObj.put("brand", PPAppCenter.BRAND_NAME);
            if (!TextUtils.isEmpty(hashKey)) {
                jsonParamObj.put("prefix", "1");
                jsonParamObj.put("appHash", hashKey);
            }

            jsonBodyObj.put("newPassword", newPassword);
            jsonBodyObj.put("oldPassword", oldPassword);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_NEW_PASSWORD, jsonParamObj, jsonBodyObj);
    }

    public void serverRequestUserCode(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_CODE, jsonObj, m_UserCodeList);
    }

    public void serverRequestPutUserCode(String tag, String name, String type, String userCode, String locationId) {
        JSONObject jsonParamObj = new JSONObject();
        JSONObject jsonBodyObj = new JSONObject();
        try {
            jsonParamObj.put("TAG", tag);
            jsonParamObj.put("name", name);
            if (!PPUtil.isEmpty(locationId)) {
                jsonParamObj.put("locationId", locationId);
            }
            jsonBodyObj.put("type", type);
            jsonBodyObj.put("code", userCode);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_USER_CODE, jsonParamObj, jsonBodyObj);
    }

    public void serverRequestDeleteUserCode(String tag, String name, String locationId) {
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("name", name);
            if (!PPUtil.isEmpty(locationId)) {
                jsonObj.put("locationId", locationId);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_USER_CODE, jsonObj);
    }

    public void serverRequestPutUserCodeByDeviceId(String tag, String name, String type, String deviceId, String locationId, String expiry) {
        JSONObject jsonParamObj = new JSONObject();
        JSONObject jsonBodyObj = new JSONObject();
        try {
            jsonParamObj.put("TAG", tag);
            jsonParamObj.put("name", name);
            if (!PPUtil.isEmpty(locationId)) {
                jsonParamObj.put("locationId", locationId);
            }
            jsonBodyObj.put("type", type);
            jsonBodyObj.put("deviceId", deviceId);
            jsonBodyObj.put("setExpiry", expiry);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_USER_CODE_DEVICE_ID, jsonParamObj, jsonBodyObj);
    }
}
