package com.peoplepowerco.virtuoso.managers;

import android.content.Context;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.VirtuosoCommonSettings;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.rules.PPRuleAndModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleCalendarModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleGetListModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleGetPhrasesModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleParameterModel;
import com.peoplepowerco.virtuoso.models.rules.PPRulePropertyModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleStatesModel;
import com.peoplepowerco.virtuoso.util.PPCronExpressionUtils;
import com.peoplepowerco.virtuoso.util.PPRulesStringOperation;
import com.peoplepowerco.virtuoso.util.PPRulesUtil;
import com.peoplepowerco.virtuoso.util.PPUtil;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by laghee on 5/22/16.
 */
public class PPRulesManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPRulesManager.class.getSimpleName();
    private static PPRulesManager instance = null;

    public static boolean sNeedRefresh = true;

    //local members
    private PPRuleGetListModel mGetRuleListModel = null;

    // for rules list
    private HashMap<String, List<PPRuleModel>> m_MainRuleGroup = null;

    private PPRuleGetPhrasesModel mPhrasesModel = null;

    private PPDeviceManager mDeviceManager = PPDeviceManager.getInstance();

    //Rules Businees logic status
    public final static int BUSINESS_LOGIC_STATUS_OPTIONS = -1;
    public final static int BUSINESS_LOGIC_STATUS_INVALID = 0;
    public final static int BUSINESS_LOGIC_STATUS_ON = 1;
    public final static int BUSINESS_LOGIC_STATUS_OFF = 2;

    // Rules for Presence Camera
    public final static String RULE_TRIGGER_MOTION_DETECTION = "Presence camera detects motion trigger";
    //    public final static String RULE_TRIGGER_NOT_MOTION_DETECTION = "Presence camera does not detects motion trigger";
    public final static String RULE_TRIGGER_LOSS_POWER = "Presence camera loses power trigger";
    public final static String RULE_TRIGGER_GET_POWER = "Presence camera gets plugged into power trigger";
    public final static String RULE_TRIGGER_LOW_BATTERY = "Presence camera running low on battery trigger";
    public final static String RULE_TRIGGER_NOT_MOTION_DETECTION_TIMER = "Presence camera does not detects motion timer";
    public final static String RULE_TRIGGER_NOT_MOTION_DETECTION_HOUR_TIMER = "Presence camera does not detects motion for hours timer";
    public final static String RULE_STATE_ENABLE_DETECTION = "Presence camera motion detection enabled state";
    public final static String RULE_STATE_DISABLE_DETECTION = "Presence camera motion detection disabled state";
    public final static String RULE_STATE_PLUG_POWER = "Presence camera is plugged into power state";
    public final static String RULE_STATE_UNPLUG_POWER = "Presence camera is running on battery state";
    public final static String RULE_ACTION_ENABLE_DETECTION = "Presence camera enable motion detection action";
    public final static String RULE_ACTION_DISABLE_DETECTION = "Presence camera disable motion detection action";
    public final static String RULE_ACTION_ENABLE_TWITTER = "Enable auto-sharing to Twitter";
    public final static String RULE_ACTION_DISABLE_TWITTER = "Disable auto-sharing to Twitter";
    public final static String RULE_ACTION_FLIP_FRONT_CAMERA = "Presence camera flip to the front camera";
    public final static String RULE_ACTION_FLIP_REAR_CAMERA = "Presence camera flip to the rear camera";
    public final static String RULE_ACTION_SWITCH_ON_FLAGHLIGHT = "Presence camera switch on the flashlight";
    public final static String RULE_ACTION_SWITCH_OFF_FLASH_LIGHT = "Presence camera switch off the flashlight";
    public final static String RULE_ACTION_ALERT_WITH_PICTURE = "Presence camera alert me with a picture";
    public final static String RULE_ACTION_TAKE_PICTURE = "Presence camera take a picture";
    public final static String RULE_ACTION_ENABLE_ALARM = "Presence Camera sound alarm action";
    public final static String RULE_ACTION_DISABLE_ALARM = "Presence Camera disable alarm action";
    public final static String RULE_ACTION_BEEP_ONCE = "Presence Camera beep once action";
    public final static String RULE_ACTION_BEEP_TWICE = "Presence Camera beep twice action";
    public final static String RULE_ACTION_BEEP_TRIICE = "Presence Camera beep three times action";

    // Rules for Security Sensors
    public final static String RULE_TRIGGER_SENSOR_LOW_BATTERY = "Sensor low on battery trigger";
    public final static String RULE_TRIGGER_SENSOR_DEAD_BATTERY = "Sensor battery is dead trigger";
    public final static String RULE_TRIGGER_SENSOR_ENTRY_OPEN = "RS trigger door/window opens";
    public final static String RULE_TRIGGER_SENSOR_ENTRY_CLOSE = "RS trigger door/window closes";
    public final static String RULE_TRIGGER_SENSOR_ENTRY_OPEN_TIMER = "RS door open timer";
    public final static String RULE_TRIGGER_SENSOR_TOUCH_MOVE = "RS trigger touch sensor moves";
    public final static String RULE_TRIGGER_SENSOR_TOUCH_STOP = "RS trigger stops moving";
    public final static String RULE_TRIGGER_SENSOR_TOUCH_TIMER = "RS timer touch movement not detected";
    public final static String RULE_TRIGGER_SENSOR_MOTION_DETECT = "RS trigger motion detected";
    public final static String RULE_TRIGGER_SENSOR_MOTION_NOT_DETECT = "RS Motion not detected timer";
    public final static String RULE_TRIGGER_SENSOR_LEAK_DETECT = "RS trigger leak detected";
    public final static String RULE_TRIGGER_SENSOR_LEAK_NOT_DETECT = "RS trigger leak not detected";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_ABOVE_C = "RS trigger temperature goes above";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_ABOVE_F = "RS trigger temperature goes above Fahrenheit";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_BELOW_C = "RS trigger temperature goes below";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_BELOW_F = "RS trigger temperature goes below Fahrenheit";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_REACH_C = "RS trigger temperature reaches";
    public final static String RULE_TRIGGER_SENSOR_TEMPERATURE_REACH_F = "RS trigger temperature reaches Fahrenheit";
    public final static String RULE_TRIGGER_SENSOR_HUMIDITY_ABOVE = "RS trigger Humidity goes above";
    public final static String RULE_TRIGGER_SENSOR_HUMIDITY_BELOW = "RS trigger Humidity goes below";
    public final static String RULE_TRIGGER_METER_NOT_SEND_DATA = "Meter does not send data trigger";
    public final static String RULE_TRIGGER_METER_NOT_SEND_DATA_24 = "Meter does not send data for 24 hours trigger";
    public final static String RULE_TRIGGER_GATEWAY_NO_DATA_TIMER = "Gateway does not send data timer";
    public final static String RULE_TRIGGER_SMART_PLUG_ON = "Smart plug turned on trigger";
    public final static String RULE_TRIGGER_SMART_PLUG_OFF = "Smart plug turned off trigger";
    public final static String RULE_STATE_SENSOR_ENTRY_OPEN = "RS state door/window is open";
    public final static String RULE_STATE_SENSOR_ENTRY_CLOSE = "RS state door/window is closed";
    public final static String RULE_STATE_SENSOR_LEAK_DETECT = "RS state is detecting leak";
    public final static String RULE_STATE_SENSOR_LEAK_NOT_DETECT = "RS state is dry";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_ABOVE_C = "RS state temperature is above";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_ABOVE_F = "RS state temperature is above Fahrenheit";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_BELOW_C = "RS state temperature is below";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_BELOW_F = "RS state temperature is below Fahrenheit";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_BETWEEN_C = "RS state temperature is between";
    public final static String RULE_STATE_SENSOR_TEMPERATURE_BETWEEN_F = "RS state temperature is between Fahrenheit";
    public final static String RULE_STATE_SMART_PLUG_ON = "Smart plug is on state";
    public final static String RULE_STATE_SMART_PLUG_OFF = "Smart plug is off state";
    public final static String RULE_ACTION_BULB_TURN_ON = "LED bulb turn on action";
    public final static String RULE_ACTION_BULB_TURN_OFF = "LED bulb turn off action";
    public final static String RULE_ACTION_BULB_CHANGE_BRIGHTNESS = "LED bulb change brightness action";
    public final static String RULE_ACTION_SMART_PLUG_ON = "Smart plug turn on action binary";
    public final static String RULE_ACTION_SMART_PLUG_OFF = "Smart plug turn off action binary";
    public final static String RULE_ACTION_POINT_VANTAGE_POINT = "Presence camera point to vantage point action";

    public final static String LOCATION_TRIGGER = "05";
    public final static String SCHEDULAR = "01";
    public final static String PHONE_ACTION = "02";
    public final static String EMAIL_ACTION = "03";
    public final static String LOCATION_ACTION = "06";
    public final static String LOCATION_STATE = "04";

    public final static String RULE_TRIGGER_SCHEDULE = "trigger_schedule";
    public final static String RULE_TRIGGER_EVENT = "trigger_event";
    public final static String RULE_STATE_SCHEDULE = "state_schedule";
    public final static String RULE_STATE_EVENT = "state_event";
    public final static String RULE_ACTION_EVENT = "action_event";
    public final static String RULE_ACTION_NOTIFICATION = "action_notification";
    public final static String RULE_ACTION_EMAIL = "action_email";


    public final static String TYPE_TEMPERATURE = "temperature";
    public final static String TYPE_HUMIDITY = "humidity";
    public final static String PARAMETER_EVENT = "event";
    public final static String PARAMETER_SCHEDULE = "schedule";
    public final static String PARAMETER_DEVICE_ID = "deviceId";
    public final static String PARAMETER_LOCATION_ID = "locationId";
    public final static String PARAMETER_LOCATION = "location";
    public final static String PARAMETER_DEVICE = "device";
    public final static String PARAMETER_TEXT = "text";
    public final static String PARAMETER_TIME_START = "time_start";
    public final static String PARAMETER_TIME_END = "time_end";
    public final static String PARAMETER_DEGF = "degF";
    public final static String PARAMETER_DEGC = "degC";
    public final static String PARAMETER_VANTAGE = "ppc.robotVantageMoveToIndex";
    //This is for sensibo device
    public final static String PARAMETER_SWING_MODE = "swingMode";
    public final static String PARAMETER_FAN_MODE = "fanMode";
    public final static String PARAMETER_SYSTEM_MODE = "systemMode";

    // Use following constant names only we can not find specific rules type by "display"
    public final static String NAME_TRIGGER_TEMPERATURE_REACHES = "RS trigger temperature reaches";
    public final static String NAME_STATE_TEMPERATURE_BETWEEN = "RS state temperature is between";
    public final static String NAME_TRIGGER_TEMPERATURE_REACHES_F = "RS trigger temperature reaches Fahrenheit";
    public final static String NAME_STATE_TEMPERATURE_BETWEEN_F = "RS state temperature is between Fahrenheit";
    public final static String NAME_SIREN_SOUND_BURGLARY_ALRAM = "Siren sound a burglary alarm action";
    public final static String NAME_SIREN_SOUND_FIRE_ALARM = "Siren sound a fire alarm action";
    public final static String NAME_SIREN_SOUND_EMERMEGENCY_ALARM = "Siren sound an emergency alarm action";
    public final static String NAME_SIREN_SOUND_DOORBELL_ALARM = "Siren ring the doorbell action";

    public final static String TRIGGER_HOME_EVENT = "Home event trigger";
    public final static String TRIGGER_AWAY_EVENT = "Away event trigger";

    /**
     * Hidden class constructor.
     */
    private PPRulesManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     *
     * @return
     */
    public static PPRulesManager getInstance() {
        synchronized (PPRulesManager.class) {
            if (instance == null) {
                instance = new PPRulesManager();
            }
        }

        return instance;
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            if (instance.mGetRuleListModel.getRules() != null) {
                instance.mGetRuleListModel.getRules().clear();
            }
            instance.mGetRuleListModel = null;
            instance.mPhrasesModel = null;
            instance = null;
        }
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        mPhrasesModel = new PPRuleGetPhrasesModel();
        mGetRuleListModel = new PPRuleGetListModel();
    }

    /**
     * Gets the number of rules retrieved for the current user.
     * No server request is made. It is up to the caller to ensure that
     * the server request to get rules has completed successfully.
     *
     * @return
     */
    public int getRulesCount() {
        if (mGetRuleListModel != null && mGetRuleListModel.getRules() != null) {
            return mGetRuleListModel.getRules().size();
        }

        return 0;
    }

    /**
     * Get the list of rules...
     *
     * @return
     */
    public List<PPRuleModel> getRulesList() {
        if (mGetRuleListModel != null && mGetRuleListModel.getRules() != null) {
            return mGetRuleListModel.getRules();
        }

        return new ArrayList<PPRuleModel>();
    }

    public HashMap<String, List<PPRuleModel>> getGroupRulesMap() {
        return m_MainRuleGroup;
    }

    public void setGroupRulesMap(HashMap<String, List<PPRuleModel>> groupRulesMap) {
        this.m_MainRuleGroup = groupRulesMap;
    }

    public PPRuleGetPhrasesModel getPhrases() {
        return mPhrasesModel;
    }

    /**
     * Retrieves a current list of rules from the server for the active user.
     */
    public void serverRequestGetRuleList(String tag, boolean details) {
        List<PPRuleModel> ruleList = mGetRuleListModel.getRules();
        if (ruleList == null) {
            ruleList = new ArrayList<PPRuleModel>();
            mGetRuleListModel.setRules(ruleList);
        } else {
            ruleList.clear();
        }
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("details", details);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_RULES, jsonObj, new Object[]{mGetRuleListModel});
    }

    /**
     * Create a new rule on the server.
     */
    public void serverRequestCreateRule(String tag, StringBuilder json) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_CREATE_RULE, jsonObj, json);
    }

    /**
     * Sends a server request to delete a rule by rule id.
     *
     * @param ruleID
     */
    public void serverRequestDeleteRule(String tag, int ruleID) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("ruleId", ruleID);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_RULE, jsonObj);
    }

    /**
     * Updates a give rule with provided info.
     *
     * @param ruleID Id of the Rule to update.
     * @param json   Stringbuilder object containing JSON of updated values.
     */
    public void serverRequestUpdateRule(String tag, int ruleID, StringBuilder json) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("ruleId", ruleID);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_RULE, jsonObj, json);
    }

    /**
     * @param ruleId
     * @param ruleStatus
     */
    public void serverRequestRuleStatuChange(String tag, int ruleId, int ruleStatus) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("ruleId", ruleId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("status", ruleStatus);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_RULE_ATTRIBUTE, jsonObj);
    }


    /**
     * Get rule conditions...
     */
    public void serverRequestGetRulePhrases(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("version", 2);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_RULE_PHRASES, jsonObj, new Object[]{mPhrasesModel});
    }

    /*
     * Group the rules based on Device Id.
     */
    public void inputGroupRulesMap(boolean bShowHidden) {
        if (m_MainRuleGroup == null) {
            m_MainRuleGroup = new HashMap<>();
        } else {
            m_MainRuleGroup.clear();
        }

        List<PPRuleModel> ruleList = mGetRuleListModel.getRules();
        if (ruleList == null) {
            return;
        }

        List<PPRuleModel> infoListModels = null;
        for (PPRuleModel ruleInfo : ruleList) {
            // Check that rule is hidden or not. (Schedule in device detail UI should show the "hidden = true" rule.)
            if (!bShowHidden) {
                if (ruleInfo.isHidden())
                    continue;
            } else {
                if (!ruleInfo.isHidden() || ruleInfo.getTrigger().getDisplay() != PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE)
                    continue;
            }

            //Set Trigger
            /*
             *	11 - schedule (used in display type)
             *	12 - event (used in display type)
             *	13 - device action (used in display type)
             *	14 - new device data (parameters or alerts)
             */

            PPRulePropertyModel trigger = ruleInfo.getTrigger();
            if (trigger != null) {
                //If there are incomplete rules, don't load, there should be parameter value to load.
                List<PPRuleParameterModel> parameters = trigger.getParameters();

                if (PPRulesUtil.isParameterAvailable(parameters)) {
                    int displayId = trigger.getDisplay();

                    String triggerKey = "";

                    if (displayId == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE) {
                        triggerKey = SCHEDULAR;
                    } else if (displayId == PPCommonInfo.INT_RULE_TRIGGER_HOME_AWAY) {
                        triggerKey = LOCATION_TRIGGER;
                    } else {
                        triggerKey = PPRulesUtil.getDeviceIdParameter(parameters);
                    }
                    if (m_MainRuleGroup != null && m_MainRuleGroup.size() > 0 && m_MainRuleGroup.containsKey(triggerKey)) {
                        PPVirtuosoLogTrace.d(TAG, "contained m_TriggerKey = " + triggerKey);
                        infoListModels = m_MainRuleGroup.get(triggerKey);
                        infoListModels.add(ruleInfo);
                    } else {
                        infoListModels = new ArrayList<PPRuleModel>();
                        infoListModels.add(ruleInfo);
                    }
                    m_MainRuleGroup.put(triggerKey, infoListModels);
                }
            }
            //Set Calendar
            /*
             *	21 - general state condition (used in display type)
             */
            List<PPRuleCalendarModel> ruleCalendarList = ruleInfo.getCalendars();
            if (ruleCalendarList != null && ruleCalendarList.size() > 0) {
                if (m_MainRuleGroup != null && m_MainRuleGroup.size() > 0 && m_MainRuleGroup.containsKey(SCHEDULAR)) {
                    infoListModels = m_MainRuleGroup.get(SCHEDULAR);
                    infoListModels.add(ruleInfo);
                } else {
                    infoListModels = new ArrayList<PPRuleModel>();
                    infoListModels.add(ruleInfo);
                }
                m_MainRuleGroup.put(SCHEDULAR, infoListModels);
            }
            //Set States
            /*
             *	22 - location state (used in display type)
             *	23 - device parameters state (used in display type)
             *
             */
            PPRuleStatesModel states = ruleInfo.getStates();
            if (states != null) {
                List<PPRulePropertyModel> stateList = states.getState();
                if (stateList == null) {
                    List<PPRuleAndModel> andStateList = states.getAnd();
                    if (andStateList != null) {
                        stateList = andStateList.get(0).getState();
                    }
                }
                if (stateList != null) {
                    for (PPRulePropertyModel state : stateList) {
                        int displayId = state.getDisplay();
                        String stateKey = "";

                        if (displayId == PPCommonInfo.INT_RULE_STATE_GENERAL) {
                            stateKey = SCHEDULAR;
                        } else if (displayId == PPCommonInfo.INT_RULE_STATE_HOME_AWAY) {
                            stateKey = LOCATION_STATE;
                        } else {
                            stateKey = PPRulesUtil.getDeviceIdParameter(state.getParameters());
                        }
                        if (m_MainRuleGroup != null && m_MainRuleGroup.size() > 0 && m_MainRuleGroup.containsKey(stateKey)) {
                            infoListModels = m_MainRuleGroup.get(stateKey);
                            if (!isExistingRuleInGroup(infoListModels, ruleInfo)) {
                                infoListModels.add(ruleInfo);
                            }
                        } else {
                            infoListModels = new ArrayList<PPRuleModel>();
                            infoListModels.add(ruleInfo);
                        }
                        m_MainRuleGroup.put(stateKey, infoListModels);
                    }
                }
            }

            //Set Actions
            /*
             *  31 - push notification action
             *	32 - email action
             *	33 - send a command action
             *  34 - set event action
             */
            List<PPRulePropertyModel> actionList = ruleInfo.getActions();
            if (actionList != null) {
                //If there are incomplete rules, don't load, there should be parameter value to load.
                String actionKey = "";
                for (PPRulePropertyModel action : actionList) {

                    List<PPRuleParameterModel> parameters = action.getParameters();
                    if (PPRulesUtil.isParameterAvailable(parameters)) {
                        int displayId = action.getDisplay();

                        if (displayId == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION) {
                            actionKey = PHONE_ACTION;
                        } else if (displayId == PPCommonInfo.INT_RULE_ACTION_EMAIL) {
                            actionKey = EMAIL_ACTION;
                        } else if (displayId == PPCommonInfo.INT_RULE_ACTION_HOME_AWAY) {
                            //It need to consider other condition..
                            actionKey = LOCATION_ACTION;
                        } else {
                            actionKey = PPRulesUtil.getDeviceIdParameter(parameters);
                        }
                        if (m_MainRuleGroup != null && m_MainRuleGroup.size() > 0 && m_MainRuleGroup.containsKey(actionKey)) {
                            infoListModels = m_MainRuleGroup.get(actionKey);
                            if (!isExistingRuleInGroup(infoListModels, ruleInfo)) {
                                infoListModels.add(ruleInfo);
                            }
                        } else {
                            infoListModels = new ArrayList<PPRuleModel>();
                            infoListModels.add(ruleInfo);
                        }
                        m_MainRuleGroup.put(actionKey, infoListModels);
                    }
                }
            }
        }
    }

    public String makeRuleString(PPRuleModel ruleInfo) {

        StringBuilder sbRuleString = new StringBuilder(PPAppCenter.m_Context.getString(R.string.rule_mode_if) + " ");
        Context ctx = PPAppCenter.m_Context;

        // Start Trigger Data

        PPRulePropertyModel trigger = ruleInfo.getTrigger();
        if (trigger != null) {
            String triggerString = getTriggerString(trigger);
            trigger.setRuleText(triggerString);
            sbRuleString.append(triggerString);

        }
        /*
         * End Trigger Data
         */

        /*
         * Start State Data
         */
        PPRuleStatesModel states = ruleInfo.getStates();
        if (states != null) {
            List<PPRulePropertyModel> stateList = states.getState();
            if (stateList == null) {
                List<PPRuleAndModel> andStateList = states.getAnd();
                if (andStateList != null) {
                    stateList = andStateList.get(0).getState();
                }
            }
            if (stateList != null) {
                int maxStateCount = stateList.size();

                for (int i = 0; i < maxStateCount; i++) {
                    sbRuleString.append(" " + ctx.getString(R.string.rule_and) + " ");

                    PPRulePropertyModel state = stateList.get(i);
                    String stateString = getStateString(state);
                    state.setRuleText(stateString);
                    sbRuleString.append(stateString);
                }
            }

        }
        /*
         * End State Data
         */

        /*
         * Start Calendar Data
         */
        List<PPRuleCalendarModel> calendarList = ruleInfo.getCalendars();
        String calendarString = "";
        if (calendarList != null && calendarList.size() > 0) {
            PPRuleCalendarModel calendar = calendarList.get(0);
            String noun = PPRulesStringOperation.getTextNoun(PPCommonInfo.INT_RULE_STATE_GENERAL, "");
            calendarString = noun + " ";
            if (calendar != null) {
                sbRuleString.append(" " + ctx.getString(R.string.rule_and) + " ");
                //Set Start Date
                String desc = PPCronExpressionUtils.getTimeStringFromSecond(calendar.getStartTime());
                //Set "and" String
                desc += " " + ctx.getString(R.string.time_and) + " ";
                //Set End Date
                desc += PPCronExpressionUtils.getTimeStringFromSecond(calendar.getEndTime());
                //Set Day
                if (calendar.getDaysOfWeek() != 0) {
                    String day = PPCronExpressionUtils.getDaysOfweek(String.valueOf(calendar.getDaysOfWeek()));
                    desc = ctx.getString(R.string.schedule_time_day_apm, desc, ctx.getString(R.string.schedule_on) + " " + day);
                }
                calendarString += desc;
                sbRuleString.append(calendarString);
            }
        }
        /*
         * End Calendar Data
         */

        /*
         * Start Action Data
         */
        //Set Then Text after state is set
        sbRuleString.append(" " + ctx.getString(R.string.rule_then) + " ");
        //Finally get actions
        List<PPRulePropertyModel> actionList = ruleInfo.getActions();
        if (actionList != null) {
            //If there are incomplete rules, don't load, there should be parameter value to load.
            int i = 0;
            for (PPRulePropertyModel action : actionList) {
                String actionString = getActionString(action);
                action.setRuleText(actionString);
                sbRuleString.append(actionString);
                if (i < actionList.size() - 1)
                    sbRuleString.append(" " + ctx.getString(R.string.rule_and) + " ");
                i++;
            }
        }
        /*
         * End Action Data
         */
        //PPVirtuosoLogTrace.i(TAG, "RULES STRING = " + m_sbRuleString.toString());
        return sbRuleString.toString();
    }

    private String getTriggerString(PPRulePropertyModel trigger) {
        String triggerString = "";
        Context ctx = PPAppCenter.m_Context;

        List<PPRuleParameterModel> parameters = trigger.getParameters();

        if (PPRulesUtil.isParameterAvailable(parameters)) {
            int displayType = trigger.getDisplay();

            if (displayType == PPCommonInfo.INT_RULE_TRIGGER_SCHEDULE) {
                String ruleText = PPRulesStringOperation.getTextNoun(displayType, "");
                triggerString = ruleText + " ";
                String m_sCronString = PPCronExpressionUtils.getStringFromCronExpression(trigger.getParameters().get(0).getValue());
                triggerString += m_sCronString;
            } else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_HOME_AWAY) {
                String eventName = trigger.getParameters().get(0).getValue();
                if (eventName.contains(",")) {
                    String[] array = eventName.split(",");
                    StringBuilder sbEvent = new StringBuilder();
                    for (int i = 0; i < array.length; i++) {
                        sbEvent.append("'" + array[i] + "'");
                        if (i < array.length - 1) {
                            sbEvent.append(" " + "or" + " ");
                        }
                    }
                    triggerString = String.format(ctx.getString(R.string.rule_i_go_into_mode), sbEvent.toString());
                } else {
                    triggerString = String.format(ctx.getString(R.string.rule_i_go_into_mode), "'" + eventName + "'");
                }

            } else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_NEW_DEVICE_DATA) {

                String deviceId = this.getDeviceIdInParameter(parameters);
                String deviceName = mDeviceManager.findDeviceDescriptionById(deviceId);
                String noun = PPRulesStringOperation.getTextNoun(displayType, deviceName); // Set Noun Text for rule.
                String sReplaceTemp = "";


                // deal with the space holders "$xxx"
                // temperature between trigger
                String name = trigger.getName();
                if (name.equals(NAME_TRIGGER_TEMPERATURE_REACHES)
                        || name.equals(NAME_TRIGGER_TEMPERATURE_REACHES_F)) {
                    sReplaceTemp = trigger.getDesc().replace("$" + parameters.get(0).getName(), parameters.get(0).getValue());
                    sReplaceTemp = sReplaceTemp.replace("$" + parameters.get(1).getName(), parameters.get(1).getValue());
                } else {
                    boolean isReplaced = false;
                    if (parameters.size() > 0 && !PPUtil.isEmpty(trigger.getDesc()) && trigger.getDesc().contains("$")) {
                        for (PPRuleParameterModel parameter : parameters) {
                            if (!parameter.getName().equals(PPRulesManager.PARAMETER_DEVICE_ID)) {
                                sReplaceTemp = trigger.getDesc().replace("$" + parameter.getName(), parameter.getValue());
                                isReplaced = true;
                                break;
                            }
                        }
                    }
                    if (!isReplaced) {
                        sReplaceTemp = trigger.getDesc();
                    }
                }

                triggerString = noun + " ";
                triggerString += sReplaceTemp;

            } else if (displayType == PPCommonInfo.INT_RULE_TRIGGER_DEVICE_ACTION) {
                String deviceId = this.getDeviceIdInParameter(parameters);
                String deviceName = mDeviceManager.findDeviceDescriptionById(deviceId);
                String sReplaceTemp = "";
                String desc = trigger.getDesc();
                if (parameters.size() > 0 && !PPUtil.isEmpty(desc) && desc.contains("$")) {
                    sReplaceTemp = desc.replace("$" + parameters.get(1).getName(), parameters.get(1).getValue());
                } else {
                    sReplaceTemp = desc;
                }
                String noun = PPRulesStringOperation.getTextNoun(displayType, deviceName); // Set Noun Text for rule.
                triggerString = noun + " ";
                triggerString += sReplaceTemp;
            }
        }

        return triggerString;
    }

    private String getStateString(PPRulePropertyModel state) {
        String stateString = "";
        Context ctx = PPAppCenter.m_Context;

        List<PPRuleParameterModel> parameters = state.getParameters();

        if (PPRulesUtil.isParameterAvailable(parameters)) {
            int displayType = state.getDisplay();

            if (displayType == PPCommonInfo.INT_RULE_STATE_HOME_AWAY) {

                String eventName = parameters.get(0).getValue();
                stateString = setModeString(eventName);

            } else if (displayType == PPCommonInfo.INT_RULE_STATE_DEVICE_PARAM) {

                String deviceId = this.getDeviceIdInParameter(parameters);
                String deviceName = mDeviceManager.findDeviceDescriptionById(deviceId);
                String noun = PPRulesStringOperation.getTextNoun(displayType, deviceName); // Set Noun Text for rule.
                String sReplaceTemp = "";

                String name = state.getName();
                if (name.equals(NAME_TRIGGER_TEMPERATURE_REACHES)
                        || name.equals(NAME_TRIGGER_TEMPERATURE_REACHES_F)
                        || name.equals(NAME_STATE_TEMPERATURE_BETWEEN)
                        || name.equals(NAME_STATE_TEMPERATURE_BETWEEN_F)) {
                    sReplaceTemp = state.getDesc().replace("$" + parameters.get(0).getName(), parameters.get(0).getValue());
                    sReplaceTemp = sReplaceTemp.replace("$" + parameters.get(1).getName(), parameters.get(1).getValue());
                    state.setDesc(sReplaceTemp);
                    String pastStr = state.getPast().replace("$" + parameters.get(0).getName(), parameters.get(0).getValue());
                    pastStr = pastStr.replace("$" + parameters.get(1).getName(), parameters.get(1).getValue());
                    state.setPast(pastStr);
                } else {
                    if (parameters.size() > 0) {
                        if (!PPUtil.isEmpty(state.getDesc())) {
                            for (PPRuleParameterModel parameter : parameters) {
                                if (!parameter.getName().equals(PPRulesManager.PARAMETER_DEVICE_ID)) {
                                    sReplaceTemp = state.getDesc().replace("$" + parameter.getName(), parameter.getValue());
                                    state.setDesc(sReplaceTemp);
                                    if (!PPUtil.isEmpty(state.getPast())) {
                                        String pastStr = state.getPast().replace("$" + parameter.getName(), parameter.getValue());
                                        state.setPast(pastStr);
                                    }
                                    break;
                                }
                            }
                            if (PPUtil.isEmpty(sReplaceTemp)) {
                                sReplaceTemp = state.getDesc();
                            }
                        }
                    }
                }

                stateString = noun + " ";
                stateString += sReplaceTemp;
            }
        }

        return stateString;
    }

    private String setModeString(String modeValue) {
        String stateString = "";
        Context ctx = PPAppCenter.m_Context;
        StringBuilder sbMode = new StringBuilder();
        if (!PPUtil.isEmpty(modeValue) && modeValue.contains(",")) {
            String[] modes = modeValue.split(",");
            sbMode.append(ctx.getString(R.string.rules_i_am_in) + " ");
            int i = 0;
            for (String mode : modes) {
                sbMode.append(getSingleModeText(mode));
                if (i < modes.length - 1) {
                    sbMode.append(" " + ctx.getString(R.string.rules_or) + " ");
                }
                i++;
            }
            sbMode.append(" " + ctx.getString(R.string.mode_rule));
            stateString = sbMode.toString();
        } else {
            stateString = ctx.getString(R.string.rules_i_am_in) + " " + getSingleModeText(modeValue) + " " + ctx.getString(R.string.mode_rule);
        }
        return stateString;
    }

    private String getSingleModeText(String modeValue) {
        String stateString = "";
        Context ctx = PPAppCenter.m_Context;
        if (modeValue.equals(PPUserManager.EVENT_HOME) || modeValue.equals(PPUserManager.EVENT_OFF)) {
            stateString = ctx.getString(VirtuosoCommonSettings.supportOffMode ? R.string.rules_mode_off : R.string.rules_mode_home);
        } else if (modeValue.equals(PPUserManager.EVENT_AWAY)) {
            stateString = ctx.getString(R.string.rules_mode_away);
        } else if (modeValue.equals(PPUserManager.EVENT_VACATION)) {
            stateString = ctx.getString(R.string.rules_mode_vacation);
        } else if (modeValue.equals(PPUserManager.EVENT_SLEEP)) {
            stateString = ctx.getString(R.string.rules_mode_sleep);
        } else if (modeValue.equals(PPUserManager.EVENT_STAY)) {
            stateString = ctx.getString(R.string.rules_mode_stay);
        } else if (modeValue.equals(PPUserManager.EVENT_TEST)) {
            stateString = ctx.getString(R.string.rules_mode_test);
        }
        return stateString;
    }

    private String getActionString(PPRulePropertyModel action) {
        String actionString = "";
        Context ctx = PPAppCenter.m_Context;

        List<PPRuleParameterModel> parameters = action.getParameters();
        int displayType = action.getDisplay();

        if (displayType == PPCommonInfo.INT_RULE_ACTION_EMAIL) {
            actionString = ctx.getString(R.string.rule_str_notify_by_email);
        } else if (displayType == PPCommonInfo.INT_RULE_ACTION_PUSH_NOTIFICATION) {
            actionString = ctx.getString(R.string.rule_str_notify_by_phone);
        } else if (displayType == PPCommonInfo.INT_RULE_ACTION_DEVICE_CMD) {
            if (PPRulesUtil.isParameterAvailable(parameters)) {
                String deviceId = this.getDeviceIdInParameter(parameters);
                String deviceName = mDeviceManager.findDeviceDescriptionById(deviceId);
                String noun = PPRulesStringOperation.getTextNoun(displayType, deviceName);
                actionString = noun + " ";
                String desc = action.getDesc();

                // replace the place holder if it has
                if (desc.indexOf("$") != -1) {
                    for (PPRuleParameterModel parameter : parameters) {
                        if (!parameter.getName().equals(PARAMETER_DEVICE_ID)) {
                            if (parameter.getName().equals(PARAMETER_VANTAGE)
                                    || parameter.getCategory() == PPCommonInfo.INT_RULE_CATEGORY_INPUT
                                    || parameter.getCategory() == PPCommonInfo.INT_RULE_CATEGORY_ENUMERATION) {
                                if (parameter.getDesc() != null) {
                                    desc = desc.replace("$" + parameter.getName(), parameter.getDesc());
                                } else {
                                    desc = desc.replace("$" + parameter.getName(), parameter.getValue());
                                }
                            } else {
                                desc = desc.replace("$" + parameter.getName(), parameter.getValue());
                            }
                        }
                    }
                }
                if (parameters.size() > 1) {
                    if (desc.indexOf("$") != -1) {
                        desc = desc.replace("$" + parameters.get(1).getName(), parameters.get(1).getValue());
                    }
                }
                actionString += desc;
            }
        } else if (displayType == PPCommonInfo.INT_RULE_ACTION_HOME_AWAY) {
            if (PPRulesUtil.isParameterAvailable(parameters)) {
                String eventName = parameters.get(0).getValue();

                if (eventName.equals(PPUserManager.EVENT_HOME) || eventName.equals(PPUserManager.EVENT_OFF)) {
                    actionString = ctx.getString(VirtuosoCommonSettings.supportOffMode ? R.string.rule_mode_put_off : R.string.rule_mode_put_home);
                } else if (eventName.equals(PPUserManager.EVENT_AWAY)) {
                    actionString = ctx.getString(R.string.rule_mode_put_away);
                } else if (eventName.equals(PPUserManager.EVENT_VACATION)) {
                    actionString = ctx.getString(R.string.rule_mode_put_vacation);
                } else if (eventName.equals(PPUserManager.EVENT_SLEEP)) {
                    actionString = ctx.getString(R.string.rule_mode_put_sleep);
                } else if (eventName.equals(PPUserManager.EVENT_STAY)) {
                    actionString = ctx.getString(R.string.rule_mode_put_stay);
                } else if (eventName.equals(PPUserManager.EVENT_TEST)) {
                    actionString = ctx.getString(R.string.rule_mode_put_test);
                }

                // replace $event
                String eventString = PPUserManager.getInstance().getModeString(eventName);
                action.getDesc().replace("$" + parameters.get(0).getName(), eventString);
            }
        }

        return actionString;
    }


    /*
     * Get deviceID from rules parameter model list
     */
    public String getDeviceIdInParameter(List<PPRuleParameterModel> parameters) {
        for (PPRuleParameterModel parameter : parameters) {
            ;
            String name = parameter.getName();
            String value = parameter.getValue();
            if (name != null && name.equals("deviceId")) {
                if (value != null) {
                    return value;
                } else {
                    return "";
                }
            }
        }
        return "";
    }

    /*
     * Get Noun text from based on Rule.
     */
    public String getGroupTextNoun(String deviceDesc) {
        if (deviceDesc.equals(PPRulesManager.SCHEDULAR)) {
            return PPAppCenter.m_Context.getString(R.string.when_time_is);
        } else if (deviceDesc.equals(PPRulesManager.LOCATION_TRIGGER)) {
            return PPAppCenter.m_Context.getString(R.string.when_change_mode);
        } else if (deviceDesc.equals(PPRulesManager.PHONE_ACTION)) {
            return PPAppCenter.m_Context.getString(R.string.text_your_phone);
        } else if (deviceDesc.equals(PPRulesManager.EMAIL_ACTION)) {
            return PPAppCenter.m_Context.getString(R.string.send_email_when);
        } else if (deviceDesc.equals(PPRulesManager.LOCATION_ACTION)) {
            return PPAppCenter.m_Context.getString(R.string.set_your_mode);
        } else if (deviceDesc.equals(PPRulesManager.LOCATION_STATE)) {
            return PPAppCenter.m_Context.getString(R.string.you_in_mode);
        } else {
            String rulesFor = PPAppCenter.m_Context.getString(R.string.rules_for);
            return String.format(rulesFor, mDeviceManager.findDeviceDescriptionById(deviceDesc));
        }
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    public boolean isExistingRuleInGroup(List<PPRuleModel> infoListModels, PPRuleModel ruleInfo) {
        boolean isExisting = false;

        for (PPRuleModel rulesModel : infoListModels) {
            if (rulesModel.getId() == ruleInfo.getId() && rulesModel.getName().equals(ruleInfo.getName())) {
                isExisting = true;
                PPVirtuosoLogTrace.d(TAG, "This rules already in group don't add it");
                return isExisting;
            }
        }
        return isExisting;
    }

//    /* RULES ENGINE */
//    // https://app.presencepro.com/cloud/json/ruleConditions?version=version
//    public static final short REQ_GET_RULE_PHRASES                          = 230;
//
//    // https://app.presencepro.com/cloud/json/rules
//    public static final short REQ_POST_CREATE_RULE                          = 231;
//
//    // https://app.presencepro.com/cloud/json/rules/ruleId
//    public static final short REQ_PUT_UPDATE_RULE                           = 232;
//
//    // https://app.presencepro.com/cloud/json/rules/ruleId/attrs
//    public static final short REQ_PUT_UPDATE_RULE_ATTRIBUTE                 = 233;
//
//    // https://app.presencepro.com/cloud/json/rules?deviceId=deviceId&details=details
//    public static final short REQ_GET_RULES                                 = 234;
//
//    // https://app.presencepro.com/cloud/json/rules/ruleId?details=details
//    public static final short REQ_GET_RULE                                  = 235;
//
//    // https://app.presencepro.com/cloud/json/rules/ruleId
//    public static final short REQ_DELETE_RULE                               = 236;
//
//    // https://app.presencepro.com/cloud/json/rulesCreateDefault?deviceId=deviceId&userId=userId
//    public static final short REQ_POST_CREATE_RULE_FOR_DEVICE               = 237;
}
