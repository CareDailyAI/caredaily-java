package com.peoplepowerco.virtuoso.util;

import android.app.Application;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.amplitude.api.Amplitude;
import com.amplitude.api.AmplitudeClient;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPLocationModel;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EventTrackingHelper {

    private AmplitudeClient mAmplitudeClient;
    private static EventTrackingHelper sInstance;

    public static final String OOBE_REFER_TYPE_STORY = "story";
    public static final String OOBE_REFER_TYPE_OOBE = "oobe";
    public static final String OOBE_REFER_TYPE_DEVICE = "device";

    public static final String General = "General";
    public static final String Account = "Account";
    public static final String OOBE = "OOBE";
    public static final String Setup = "Setup";
    public static final String Dashboard = "Dashboard";
    public static final String Devices = "Devices";
    public static final String People = "People";
    public static final String Community = "Community";
    public static final String Other = "Other";

    public static final String System = "System";
    public static final String Page = "Page";
    public static final String User = "User";
    public static final String Location = "Location";
    public static final String Device = "Device";
    public static final String Post = "Post";

    private static final String DATA_CATEGORIES = "Data Categories";
    private static final String EVENT_TYPE = "Event Type";
    private String mEventProperties;
    private String mUserProperties;

    private EventTrackingHelper() {
        mAmplitudeClient = Amplitude.getInstance();
    }

    public static EventTrackingHelper getInstance() {
        if (null == sInstance) {
            sInstance = new EventTrackingHelper();
        }
        return sInstance;
    }

    public void init(Application context, String content) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)) {
            try {
                String trackingInitial = initKeyForApps(context);
                mAmplitudeClient.initialize(context, trackingInitial).enableForegroundTracking(context);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void initWithSandBox(Application context, String content) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)) {
            try {
                String trackingInitial = "";
                mAmplitudeClient.initialize(context, trackingInitial).enableForegroundTracking(context);
                PPAppCenter.m_SharedPresence.setKeyBooleanValue("SandBoxKey", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void uploadEvents() {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            mAmplitudeClient.uploadEvents();
        }
    }

    public void logEvent(String event, JSONArray categories, String type) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            JSONObject eventProperties = new JSONObject();
            try {
                eventProperties.put(DATA_CATEGORIES, categories);
                eventProperties.put(EVENT_TYPE, type);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logEvent(String event, JSONArray categories, String type, JSONObject eventProperties) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            try {
                eventProperties.put(DATA_CATEGORIES, categories);
                eventProperties.put(EVENT_TYPE, type);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logSystemEvent(String event) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            JSONObject eventProperties = new JSONObject();
            try {
                JSONArray array = new JSONArray();
                array.put(System);
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, General);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logUserEvent(String event) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            JSONObject eventProperties = new JSONObject();
            try {
                JSONArray array = new JSONArray();
                array.put(User);
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, Account);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logUserEvent(String event, JSONObject eventProperties) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            try {
                JSONArray array = new JSONArray();
                array.put(User);
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, Account);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logSetupEvent(String event, JSONObject eventProperties) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            try {
                JSONArray array = new JSONArray();
                array.put(Location);
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, Setup);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logSetupEvent(String event, JSONArray array, JSONObject eventProperties) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            try {
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, Setup);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }


    public void logTabMenuUseEvent(String event, String type) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            JSONObject eventProperties = new JSONObject();
            try {
                JSONArray array = new JSONArray();
                array.put(Location);
                array.put(Page);
                eventProperties.put(DATA_CATEGORIES, array);
                eventProperties.put(EVENT_TYPE, type);
                mEventProperties = eventProperties.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            mAmplitudeClient.logEvent(event, eventProperties);
        }
    }

    public void logUserProperties(JSONObject userProperties) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            mUserProperties = userProperties.toString();
            mAmplitudeClient.setUserProperties(userProperties);
        }
    }

    public void setUserId(String userId) {
        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)
            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
            && !PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED)) {
            mAmplitudeClient.setUserId(userId);
        }
    }

    public void logUserRegistered(String userId, String mail, String firstName, String lastName) {
        setUserId(userId);
        logUserEvent(PPCommonInfo.AMP_EVENT_USER_REGISTERED);
    }

    public void logUserAccountMerged(String userId) {
        PPUserInfoModel userInfoModel = PPUserManager.getInstance().getUserInfoModel();
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("email Status", userInfoModel.nMailStatus);
            userProperties.put("smsStatus", userInfoModel.nSmsStatus);
            userProperties.put("phoneType", userInfoModel.nPhoneType);
        } catch (JSONException exception) {
        }
        setUserId(userId);
        logUserProperties(userProperties);
        logUserEvent(PPCommonInfo.AMP_EVENT_USER_ACCOUNT_MERGED);
    }

    public void logUserSignIn(String userId) {
        PPUserInfoModel userInfoModel = PPUserManager.getInstance().getUserInfoModel();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("email Status", userInfoModel.nMailStatus);
            userProperties.put("smsStatus", userInfoModel.nSmsStatus);
            userProperties.put("locationId", userInfoModel.sUserInfoLoId);
            if (null != locationModel) {
                if (locationModel.getUserInformationLocationCountryModel() != null) {
                    userProperties.put("country", locationModel.getUserInformationLocationCountryModel().getCountryCode());
                    userProperties.put("state", locationModel.getUserInformationLocationCountryModel().getStateName());
                }
                userProperties.put("locationAccess", locationModel.locationAccess);
                userProperties.put("category", locationModel.userCategory);
                if (null != locationModel.getOrganizationId()) {
                    userProperties.put("organizationId", locationModel.getOrganizationId());
                }
            }
        } catch (JSONException exception) {
        }
        setUserId(userId);
        logUserProperties(userProperties);
        JSONArray array = new JSONArray();
        array.put(User);
        array.put(Location);
        logEvent(PPCommonInfo.AMP_EVENT_USER_SIGN_IN, array, Account);
    }

    public void logUserLogout(String userId, boolean logoutAllDevice) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("allDevices", logoutAllDevice);
            mEventProperties = eventProperties.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUserId(userId);
        logUserEvent(PPCommonInfo.AMP_EVENT_USER_LOGOUT, eventProperties);
    }

    public void logUserDetailEdited(String userId) {
        PPUserInfoModel userInfoModel = PPUserManager.getInstance().getUserInfoModel();
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("email Status", userInfoModel.nMailStatus);
            userProperties.put("smsStatus", userInfoModel.nSmsStatus);
        } catch (JSONException exception) {
        }
        setUserId(userId);
        logUserProperties(userProperties);
        logUserEvent(PPCommonInfo.AMP_EVENT_USER_DETAIL_EDIT);
    }

    public void logOOBEEnterStory(String modelId, String storyId, String referType) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("modelId", modelId);
            eventProperties.put("storyId", storyId);
            eventProperties.put("referType", referType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(User);
        array.put(Location);
        array.put(Page);
        this.logEvent(PPCommonInfo.AMP_EVENT_OOBE_ENTER_STORY, array, OOBE, eventProperties);
    }

    public void logOOBEExitStory(String modelId, String storyId) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("modelId", modelId);
            eventProperties.put("storyId", storyId);
            eventProperties.put("pageIndex", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(User);
        array.put(Location);
        this.logEvent(PPCommonInfo.AMP_EVENT_OOBE_EXIT_STORY, array, OOBE, eventProperties);
    }

    public void logLocationCreated(PPLocationModel locationModel) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("locationId", locationModel.sLocationId);
            eventProperties.put("name", locationModel.sLocationName);
            eventProperties.put("country", locationModel.sAddCountry);
            eventProperties.put("state", locationModel.sAddState);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_CREATED, eventProperties);
    }

    public void logLocationUpdated(PPUserInformationLocationModel userInfoLocationModel, PPLocationModel locationModel) {
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("locationId", userInfoLocationModel.getId());
            if (null != userInfoLocationModel.getUserInformationLocationCountryModel()) {
                userProperties.put("country", userInfoLocationModel.getUserInformationLocationCountryModel().getCountryCode());
                userProperties.put("state", userInfoLocationModel.getUserInformationLocationCountryModel().getStateName());
            }
            userProperties.put("locationAccess", userInfoLocationModel.locationAccess);
            userProperties.put("category", userInfoLocationModel.userCategory);
            if (null != userInfoLocationModel.getOrganizationId()) {
                userProperties.put("organizationId", userInfoLocationModel.getOrganizationId());
            }
        } catch (JSONException exception) {
        }
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("locationId", locationModel.sLocationId);
            eventProperties.put("name", locationModel.sLocationName);
            eventProperties.put("country", locationModel.sAddCountry);
            eventProperties.put("state", locationModel.sAddState);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUserId(PPAppCenter.m_SharedPresence.getUserId());
        logUserProperties(userProperties);
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_UPDATED, eventProperties);
    }

    public void logLocationLeft(PPUserInformationLocationModel userInfoLocationModel, PPUserInformationLocationModel nextLocationModel) {
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("locationId", userInfoLocationModel.getId());
            if (null != userInfoLocationModel.getUserInformationLocationCountryModel()) {
                userProperties.put("country", userInfoLocationModel.getUserInformationLocationCountryModel().getCountryCode());
                userProperties.put("state", userInfoLocationModel.getUserInformationLocationCountryModel().getStateName());
            }
            userProperties.put("locationAccess", userInfoLocationModel.locationAccess);
            userProperties.put("category", userInfoLocationModel.userCategory);
            if (null != userInfoLocationModel.getOrganizationId()) {
                userProperties.put("organizationId", userInfoLocationModel.getOrganizationId());
            }
        } catch (JSONException exception) {
        }
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("locationId", nextLocationModel.getId());
            eventProperties.put("name", nextLocationModel.getName());
            eventProperties.put("locationAccess", nextLocationModel.locationAccess);
            eventProperties.put("category", nextLocationModel.userCategory);
            if (null != nextLocationModel.getOrganizationId()) {
                eventProperties.put("organizationId", nextLocationModel.getOrganizationId());
            }
            mEventProperties = eventProperties.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUserId(PPAppCenter.m_SharedPresence.getUserId());
        logUserProperties(userProperties);
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_LEFT, eventProperties);
    }

    public void logLocationRemoved(PPUserInformationLocationModel userInfoLocationModel, PPUserInformationLocationModel nextLocationModel) {
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            userProperties.put("locationId", userInfoLocationModel.getId());
            if (null != userInfoLocationModel.getUserInformationLocationCountryModel()) {
                userProperties.put("country", userInfoLocationModel.getUserInformationLocationCountryModel().getCountryCode());
                userProperties.put("state", userInfoLocationModel.getUserInformationLocationCountryModel().getStateName());
            }
            userProperties.put("locationAccess", userInfoLocationModel.locationAccess);
            userProperties.put("category", userInfoLocationModel.userCategory);
            if (null != userInfoLocationModel.getOrganizationId()) {
                userProperties.put("organizationId", userInfoLocationModel.getOrganizationId());
            }
        } catch (JSONException exception) {
        }
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("locationId", nextLocationModel.getId());
            eventProperties.put("name", nextLocationModel.getName());
            if (null != nextLocationModel.getOrganizationId()) {
                eventProperties.put("organizationId", nextLocationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUserId(PPAppCenter.m_SharedPresence.getUserId());
        logUserProperties(userProperties);
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_REMOVED, eventProperties);
    }

    public void logLocationUserAdded(PPLocationUserModel userModel) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", userModel.getId());
            eventProperties.put("temporary", userModel.getTemporary().equals("1"));
            eventProperties.put("locationAccess", userModel.getLocationAccess());
            eventProperties.put("category", userModel.getCategory());
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_USER_ADDED, eventProperties);
    }

    public void logLocationUserEdited(PPLocationUserModel userModel) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", userModel.getId());
            eventProperties.put("temporary", userModel.getTemporary().equals("1"));
            eventProperties.put("locationAccess", userModel.getLocationAccess());
            eventProperties.put("category", userModel.getCategory());
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_USER_EDITED, eventProperties);
    }

    public void logLocationUserRemoved(PPLocationUserModel userModel) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", userModel.getId());
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_USER_REMOVED, eventProperties);
    }

    public void logLocationCallCenterUpdated(String userId, int count) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", userId);
            eventProperties.put("count", count);
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Location);
        array.put(User);
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_CALLCENTER_UPDATED, array, eventProperties);
    }

    public void logLocationDeviceRemoved(String deviceId, String modelId, int deviceType, String name) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("deviceId", deviceId);
            eventProperties.put("modelId", modelId);
            eventProperties.put("deviceType", deviceType);
            eventProperties.put("name", name);
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Location);
        array.put(Device);
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_LOCATION_DEVICE_REMOVED, array, eventProperties);
    }

    public void logLocationChanged(PPUserInformationLocationModel userInfoLocationModel, PPUserInformationLocationModel locationModel) {
        JSONObject userProperties = new JSONObject();
        try {
            userProperties = setBaseUserProperties(userProperties);
            if (null != userInfoLocationModel.getUserInformationLocationCountryModel()) {
                userProperties.put("country", userInfoLocationModel.getUserInformationLocationCountryModel().getCountryCode());
                userProperties.put("state", userInfoLocationModel.getUserInformationLocationCountryModel().getStateName());
            }
            userProperties.put("locationId", userInfoLocationModel.getId());
            userProperties.put("locationAccess", userInfoLocationModel.locationAccess);
            userProperties.put("category", userInfoLocationModel.userCategory);
            if (null != userInfoLocationModel && null != userInfoLocationModel.getOrganizationId()) {
                userProperties.put("organizationId", userInfoLocationModel.getOrganizationId());
            }
        } catch (JSONException exception) {
        }
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("locationId", locationModel.getId());
            eventProperties.put("locationAccess", locationModel.locationAccess);
            eventProperties.put("category", locationModel.userCategory);
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUserId(PPAppCenter.m_SharedPresence.getUserId());
        logUserProperties(userProperties);
        JSONArray array = new JSONArray();
        array.put(Location);
        this.logEvent(PPCommonInfo.AMP_EVENT_LOCATION_CHANGED, array, Other, eventProperties);
    }

    public void logPostCreated(String postId, int postType, long communityId, String eventDate) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("postId", postId);
            eventProperties.put("postType", postType);
            eventProperties.put("communityId", communityId);
            eventProperties.put("eventDate", eventDate);
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", PPAppCenter.m_SharedPresence.getUserId());
            if (null != locationModel.getUserInformationLocationCountryModel()) {
                eventProperties.put("country", locationModel.getUserInformationLocationCountryModel().getCountryCode());
                eventProperties.put("state", locationModel.getUserInformationLocationCountryModel().getStateName());
            }
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Post);
        this.logEvent(PPCommonInfo.AMP_EVENT_POST_CREATED, array, Community, eventProperties);
    }

    public void logPostEdited(String postId, int postType, long communityId, String eventDate) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("postId", postId);
            eventProperties.put("postType", postType);
            eventProperties.put("communityId", communityId);
            eventProperties.put("eventDate", eventDate);
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", PPAppCenter.m_SharedPresence.getUserId());
            if (null != locationModel.getUserInformationLocationCountryModel()) {
                eventProperties.put("country", locationModel.getUserInformationLocationCountryModel().getCountryCode());
                eventProperties.put("state", locationModel.getUserInformationLocationCountryModel().getStateName());
            }
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Post);
        this.logEvent(PPCommonInfo.AMP_EVENT_POST_EDITED, array, Community, eventProperties);
    }

    public void logPostRemoved(String postId, int postType) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("postId", postId);
            eventProperties.put("postType", postType);
            mEventProperties = eventProperties.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Post);
        this.logEvent(PPCommonInfo.AMP_EVENT_POST_REMOVED, array, Community, eventProperties);
    }

    public void logCommentCreated(String postId, String commentId, String replyCommentId, String replyUserId) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("postId", postId);
            eventProperties.put("commentId", commentId);
            eventProperties.put("replyCommentId", replyCommentId);
            eventProperties.put("replyUserId", replyUserId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Post);
        this.logEvent(PPCommonInfo.AMP_EVENT_COMMENT_CREATED, array, Community, eventProperties);
    }

    public void logCommentRemoved(String postId, String commentId) {
        JSONObject eventProperties = new JSONObject();
        try {
            eventProperties.put("postId", postId);
            eventProperties.put("commentId", commentId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONArray array = new JSONArray();
        array.put(Post);
        this.logEvent(PPCommonInfo.AMP_EVENT_COMMENT_REMOVED, array, Community, eventProperties);
    }

    public void logTaskAdded(String userId) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            if (!TextUtils.isEmpty(userId)) {
                eventProperties.put("userId", userId);
            }
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_TASK_ADDED, eventProperties);
    }

    public void logTaskCompleted(String userId, String createdByUserId) {
        JSONObject eventProperties = new JSONObject();
        PPUserInformationLocationModel locationModel = PPUserManager.getInstance().getCurrentUserLocation();
        try {
            eventProperties.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            eventProperties.put("userId", userId);
            eventProperties.put("createdByUserId", createdByUserId);
            if (null != locationModel && null != locationModel.getOrganizationId()) {
                eventProperties.put("organizationId", locationModel.getOrganizationId());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.logSetupEvent(PPCommonInfo.AMP_EVENT_TASK_COMPLETED, eventProperties);
    }


    private String initKeyForApps(Application context) {
        String trackingInitial = "";
        return trackingInitial;
    }

    private JSONObject setBaseUserProperties(JSONObject properties) throws JSONException {
        properties.put("platform", "android");
        properties.put("device_id", PPAppCenter.m_SharedPresence.getKeyStringValue("CRPresenceFamilyAppUUID"));
        properties.put("device_type", Build.MANUFACTURER + " " + Build.MODEL);
        properties.put("version", PPAppCenter.m_SharedPresence.getKeyStringValue("VERSION_NAME"));
        properties.put("library", "Peoplepower-Analytics/1.0.0");
        properties.put("os", VERSION.RELEASE);
        return properties;
    }

    public String getCurrentEventProperties() {
        return mEventProperties;
    }

    public String getCurrentUserProperties() {
        return mUserProperties;
    }
}
