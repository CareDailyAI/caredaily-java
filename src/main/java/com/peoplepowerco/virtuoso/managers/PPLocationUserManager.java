package com.peoplepowerco.virtuoso.managers;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.bean.FAEvent;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationStateModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import java.util.ArrayList;
import java.util.List;

public class PPLocationUserManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static final String TAG = PPLocationUserManager.class.getSimpleName();
    private static PPLocationUserManager instance = null;

    private List<PPLocationUserModel> mUserModels;
    private List<PPLocationUserModel> mFilteredUserModels;
    private List<PPLocationUserModel> mOwnerUserModels;
    private PPLocationStateModel mLocationState;
    private PPLocationStateModel mOtherLocationState;

    public static final int LOCATION_PEOPLE_TYPE_HEADLINE = 0;
    public static final int LOCATION_PEOPLE_TYPE_ITEM = 1;
    public static final int LOCATION_PEOPLE_TYPE_ATTENTION = 2;

    public static final int LOCATION_SECTION_TYPE_NOT = -1;
    public static final int LOCATION_SECTION_TYPE_NONE = 0;
    public static final int LOCATION_SECTION_TYPE_READ = 10;
    public static final int LOCATION_SECTION_TYPE_CONTROLL = 20;
    public static final int LOCATION_SECTION_TYPE_OWNER = 30;
    public static final int LOCATION_SECTION_TYPE_ATTENTION = 1024;
    public static final int LOCATION_SECTION_TYPE_ATTENTION_SECTION = 1025;

    public static final int LOCATION_CATEGORY_TYPE_NONE = 0;
    public static final int LOCATION_CATEGORY_TYPE_HOMEOWNER = 1;
    public static final int LOCATION_CATEGORY_TYPE_SUPPORTER = 2;
    public static final int LOCATION_CATEGORY_TYPE_REMINDER = 3;

    public static final int PPUserSMSStatusUnknown = 0;
    public static final int PPUserSMSStatusVerified = 1;
    public static final int PPUserSMSStatusNotVerified = 2;
    public static final int PPUserSMSStatusInvalid = 3;

    public static final int PPLocationTemporaryFalse = 0;
    public static final int PPLocationTemporaryTrue = 1;

    private PPLocationUserManager() {
        init();
    }

    private void init() {
        init(this);
        mUserModels = new ArrayList<>();
        mOwnerUserModels = new ArrayList<>();
        mFilteredUserModels = new ArrayList<>();
        mLocationState = new PPLocationStateModel();
        mOtherLocationState = new PPLocationStateModel();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPLocationUserManager getInstance() {
        synchronized (PPLocationUserManager.class) {
            if (instance == null) {
                instance = new PPLocationUserManager();
            }
        }
        return instance;
    }

    public PPLocationUserModel findUserById(String userId) {
        if (!TextUtils.isEmpty(userId)) {
            for (PPLocationUserModel userModel : mUserModels) {
                if (String.valueOf(userModel.getId()).equals(userId)) {
                    return userModel;
                }
            }
        }
        return null;
    }

    public PPLocationUserModel getCurrentUser() {
        if (null != mUserModels && !mUserModels.isEmpty()) {
            PPUserInfoModel userInfo = PPUserManager.getInstance().getUserInfoModel();
            for (PPLocationUserModel userModel : mUserModels) {
                if (TextUtils.isEmpty(userModel.getPhone())) {
                    continue;
                }
                if (null != userInfo.sPhoneNumber && userInfo.sPhoneNumber.equals(userModel.getPhone())) {
                    return userModel;
                }
            }
            for (PPLocationUserModel userModel : mUserModels) {
                if (TextUtils.isEmpty(userModel.getUserName())) {
                    continue;
                }
                if (!TextUtils.isEmpty(userInfo.sUserInfoName)
                    && userInfo.sUserInfoName.equals(userModel.getUserName())) {
                    return userModel;
                }
            }
        }
        return null;
    }

    public List<PPLocationUserModel> getUserModels() {
        return mUserModels;
    }

    public boolean hasAddedPeople() {
        return mUserModels.size() > 2;
    }

    public List<PPLocationUserModel> getOwnerUserModels() {
        return mOwnerUserModels;
    }

    public List<PPLocationUserModel> getFilteredOwnerUserModels() {
        return mFilteredUserModels;
    }

    public PPLocationStateModel getLocationState() {
        return mLocationState;
    }

    public PPLocationStateModel getOtherLocationState() {
        return mOtherLocationState;
    }

    public void updateLocationState(PPLocationStateModel stateModel) {
        mLocationState.locationId = stateModel.locationId;
        mLocationState.state = stateModel.state;
        mLocationState.description = stateModel.description;
        mLocationState.timestamp_ms = stateModel.timestamp_ms;
        mLocationState.next_timestamp_ms = stateModel.next_timestamp_ms;
    }

    public void updateOtherState(PPLocationStateModel stateModel) {
        mLocationState.hasSocialConnector = stateModel.hasSocialConnector;
        mLocationState.enableUserAuthentication = stateModel.enableUserAuthentication;
    }

    public void getLocationServicePlans(String tag, String locationId, int status) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        if (status != PPCommonInfo.PPInvalidValue) {
            jsonObj.put("status", status);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_SERVICE_PLANS, jsonObj);
    }

    public void getLocationUsers(String tag, String locationId) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_USERS, jsonObj, new Object[]{mUserModels, mOwnerUserModels});
    }

    public void getLocationUsers(String tag, String locationId, List<PPLocationUserModel> userModels) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_USERS, jsonObj, new Object[]{userModels});
    }

    public void getLocationUsersFiltered(String tag, String locationId) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_USERS_WITH_FILTERS, jsonObj, new Object[]{mUserModels, mFilteredUserModels});
    }

    public void getLocationUsersSupportTask(String tag, String locationId, List<PPLocationUserModel> userModels) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_TASK_USERS, jsonObj, new Object[]{userModels});
    }

    public void updateLocationUsers(String tag, String locationId, String data) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("data", data);
        jsonObj.put("TAG", tag);
        m_CloudCommander.PostDataThreadPool(REQ_POST_LOCATION_USERS, jsonObj);
    }

    public void removeLocationUser(String tag, String locationId, String userId) {
        JSONObject jsonObj = new JSONObject();
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        jsonObj.put("userId", userId);
        jsonObj.put("TAG", tag);
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_LOCATION_USER, jsonObj);
    }

    public void serverRequestGetLocationStateByName(String tag, String locationId, PPLocationStateModel stateModel, String stateName) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != locationId) {
                jsonObj.put("locationId", locationId);
            }
            jsonObj.put("names", String.format("name=%s", stateName));
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_OTHER_STATE, jsonObj, new Object[]{stateModel, locationId, stateName});
    }

    public void serverRequestGetLocationTimeStateByName(String tag, String locationId, String stateName,
        long startDate, long endDate, PPLocationStateModel stateModel) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != locationId) {
                jsonObj.put("locationId", locationId);
            }
            if (startDate > 0) {
                jsonObj.put("startDate", startDate);
            }
            if (endDate > 0) {
                jsonObj.put("endDate", endDate);
            }
            jsonObj.put("name", stateName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_TIME_STATE, jsonObj, new Object[]{stateModel, locationId, stateName});
    }

    public void serverRequestGetDashboard(String tag, String locationId, String[] names, List<FAEvent> dashboards) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != locationId) {
                jsonObj.put("locationId", locationId);
            }
            if (null != names && names.length > 0) {
                int index = 0;
                StringBuilder builder = new StringBuilder();
                for (String name : names) {
                    builder.append(String.format("name=%s", name));
                    if (index++ != names.length - 1) {
                        builder.append("&");
                    }
                }
                jsonObj.put("names", builder.toString());
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //True means we need to use new dashboard with daily report support.
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_DASHBOARD, jsonObj, dashboards);
    }

    public void serverRequestGetStates(String tag, String locationId, String[] names, PPLocationStateModel stateModel) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != locationId) {
                jsonObj.put("locationId", locationId);
            }
            if (null != names && names.length > 0) {
                int index = 0;
                StringBuilder builder = new StringBuilder();
                for (String name : names) {
                    builder.append(String.format("name=%s", name));
                    if (index++ != names.length - 1) {
                        builder.append("&");
                    }
                }
                jsonObj.put("names", builder.toString());
            }
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_STATE, jsonObj, new Object[]{stateModel, locationId});
    }

    public void serverRequestPutStates(String tag, String locationId, String name, String data) {
        JSONObject jsonObj = new JSONObject();

        try {
            if (null != locationId) {
                jsonObj.put("locationId", locationId);
            }
            jsonObj.put("name", name);
            jsonObj.put("data", data);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_LOCATION_STATE, jsonObj);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }
}
