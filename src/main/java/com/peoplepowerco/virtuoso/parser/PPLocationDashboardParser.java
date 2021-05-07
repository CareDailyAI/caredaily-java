package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.VirtuosoCommonSettings;
import com.peoplepowerco.virtuoso.bean.FAEvent;
import com.peoplepowerco.virtuoso.bean.FAEventUtils;
import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPCardServiceModel;
import com.peoplepowerco.virtuoso.models.PPCardStatusModel;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel.Content;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel.FeedBack;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel.Resolution;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel.ResponseOption;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel;
import com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel;
import com.peoplepowerco.virtuoso.models.PPTaskModel;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PPLocationDashboardParser implements PPBaseJsonParser {

    private boolean isReportAdded = false;
    private int enabledServiceCount = -1;
    private int serviceCount = 0;
    private int securitySectionIndex = -1;
    private SimpleDateFormat mDateFormat;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<FAEvent> events = (List<FAEvent>) obj[0];
        events.clear();
        if (jso.containsKey("states")) {
            JSONArray statesArray = jso.getJSONArray("states");
            boolean bSecurity = false;
            HashMap<String, JSONObject> dashboards = new HashMap<>();
            if (VirtuosoCommonSettings.supportNewDashboard && PPAppCenter.SPRINT_VERSION > 21) {
                for (int i = 0; i != statesArray.size(); ++i) {
                    JSONObject stateObj = statesArray.getJSONObject(i);
                    String name = stateObj.getString("name");
                    if (!stateObj.containsKey("value")) {
                        continue;
                    }
                    JSONObject valObj = stateObj.getJSONObject("value");
                    if (name.equals(PPCommonInfo.LOCATION_STATE_PROPERTIES)) {
                        JSONObject timeseriesObj = valObj.getJSONObject("timeseries_properties");
                        if (null != timeseriesObj) {
                            if (timeseriesObj.containsKey("dailyreport")) {
                                long dailyreport_ms = timeseriesObj.getLongValue("dailyreport");
                                PPAppCenter.m_SharedPresence.setKeyLongValue(PPCommonInfo.REFERENCE_KEY_REPORT_TIME, dailyreport_ms);
                            }
                        }
                        if (valObj.containsKey("has_security")) {
                            bSecurity = valObj.getBooleanValue("has_security");
                        }
                        PPUserManager userManager = PPUserManager.getInstance();
                        if (!userManager.getCurrentState().equalsIgnoreCase("HOME")) {
                            bSecurity = true;
                        }

                    } else if (valObj.size() > 0 && PPUserManager.getInstance().isServiceFamilyPredicate()
                        && (name.equals(PPCommonInfo.LOCATION_STATE_DASHBOARD_HEADER)
                        || name.equals(PPCommonInfo.LOCATION_STATE_NOW)
                        || name.equals(PPCommonInfo.LOCATION_STATE_TASKS)
                        || name.equals(PPCommonInfo.LOCATION_STATE_SERVICES))) {
                        dashboards.put(name, valObj);
                    }
                }

                addDefaultHeader(events);
                if (dashboards.containsKey(PPCommonInfo.LOCATION_STATE_DASHBOARD_HEADER)) {
                    parseDashboardHeader(dashboards.get(PPCommonInfo.LOCATION_STATE_DASHBOARD_HEADER), events);
                }
                if (dashboards.containsKey(PPCommonInfo.LOCATION_STATE_NOW)) {
                    parseCards(dashboards.get(PPCommonInfo.LOCATION_STATE_NOW), events);
                }
                addAttentionItem(events);
                if (dashboards.containsKey(PPCommonInfo.LOCATION_STATE_TASKS)) {
                    parseTasks(dashboards.get(PPCommonInfo.LOCATION_STATE_TASKS), events);
                }
                if (dashboards.containsKey(PPCommonInfo.LOCATION_STATE_SERVICES)) {
                    parseServices(dashboards.get(PPCommonInfo.LOCATION_STATE_SERVICES));
                }
            } else {
                for (int i = 0; i != statesArray.size(); ++i) {
                    JSONObject stateObj = statesArray.getJSONObject(i);
                    String name = stateObj.getString("name");
                    if (!stateObj.containsKey("value")) {
                        continue;
                    }
                    JSONObject valObj = stateObj.getJSONObject("value");
                    if (valObj.size() > 0 && PPUserManager.getInstance().isServiceFamilyPredicate()) {
                        if (name.equals(PPCommonInfo.LOCATION_STATE_NOW)) {
                            parseCards(valObj, events);
                        } else if (name.equals(PPCommonInfo.LOCATION_STATE_TASKS)) {
                            parseTasks(valObj, events);
                        }
                    }
                }
                for (int i = 0; i != statesArray.size(); ++i) {
                    JSONObject stateObj = statesArray.getJSONObject(i);
                    String name = stateObj.getString("name");
                    if (!stateObj.containsKey("value")) {
                        continue;
                    }
                    JSONObject valObj = stateObj.getJSONObject("value");
                    if (valObj.size() > 0 && PPUserManager.getInstance().isServiceFamilyPredicate()) {
                        if (name.equals(PPCommonInfo.LOCATION_STATE_SERVICES)) {
                            parseServices(valObj, events);
                        } else if (name.equals(PPCommonInfo.LOCATION_STATE_PROPERTIES)) {
                            JSONObject timeseriesObj = valObj.getJSONObject("timeseries_properties");
                            if (timeseriesObj !=null && timeseriesObj.containsKey("dailyreport")) {
                                long dailyreport_ms = timeseriesObj.getLongValue("dailyreport");
                                PPAppCenter.m_SharedPresence.setKeyLongValue(PPCommonInfo.REFERENCE_KEY_REPORT_TIME, dailyreport_ms);
                            }
                        }
                    }
                }
            }

            //Security system section should be before tasks.
            if (bSecurity) {
                addSecuritySystem(events);
            }
            if (!isReportAdded) {
                addReports(events);
            }
        } else {
            if (VirtuosoCommonSettings.supportNewDashboard) {
                addAttentionItem(events);
            }
            if (!isReportAdded) {
                addReports(events);
            }
        }
        return true;
    }

    private void addDefaultHeader(List<FAEvent> events) {
        PPUserManager userManager = PPUserManager.getInstance();
        boolean isDeviceListEmpty = PPAppCenter.m_SharedPresence.getKeyBooleanValue("DeviceListEmpty");
        PPDashboardHeaderModel model = new PPDashboardHeaderModel();
        if (!userManager.isServiceFamilyPredicate()) {
            model.priority = -1;
            model.title = "Subscription Expired";
            model.comment = "You need a subscription.";
            model.icon_font = "far";
            model.icon = PPFontIconLabel.ICON_FA_BAN;
        } else if (isDeviceListEmpty) {
            model.priority = PPCommonInfo.PRIORITY_EMPTY_LOCATION;
            model.title = userManager.isServiceFamilyTrialPredicate() ? "Buy Devices" : "Shop at our store";
            model.comment = "All systems are disabled.";
            model.icon_font = "far";
            model.icon = PPFontIconLabel.ICON_FA_SHOPPING_CART;
        } else {
            model.priority = -1;
            model.title = "No Services";
            model.comment = "All systems are disabled.";
            model.icon_font = "far";
            model.icon = PPFontIconLabel.ICON_FA_BAN;
        }
        events.add(FAEventUtils.createEvent(model));
    }

    private void addAttentionItem(final List<FAEvent> events) {
        PPUserManager userManager = PPUserManager.getInstance();
        boolean isDeviceListEmpty = PPAppCenter.m_SharedPresence.getKeyBooleanValue("DeviceListEmpty");
        boolean hasAttentionAlready = false;

        List<PPSurveyQuestionModel> surveyQuestionModels = PPSurveyQuestionModel.getSurveyQuestions(Realm.getDefaultInstance());
        if (!surveyQuestionModels.isEmpty()) {
            hasAttentionAlready = true;
            events.add(FAEventUtils.createEvent("ATTENTION NEEDED"));
            for (PPSurveyQuestionModel surveyQuestionModel : surveyQuestionModels) {
                PPDeviceInfoModel surveyItem = new PPDeviceInfoModel();
                surveyItem.type = PPCommonInfo.INT_START_SURVEY_QUESTION;
                surveyItem.connected = true;
                surveyItem.questionId = surveyQuestionModel.id;
                surveyItem.desc = surveyQuestionModel.title;
                surveyItem.icon = PPFontIconLabel.ICON_FA_POLL;
                events.add(FAEventUtils.createEvent(surveyItem));
            }
        }

        if (!userManager.isCurrentLocationSiteOwner()
            || PPAppCenter.m_SharedPresence.getKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_HIDE_SUBSCRIPTION)) {
            return;
        }

        if (!userManager.isServiceFamilyPredicate()) {
            if (!hasAttentionAlready) {
                events.add(FAEventUtils.createEvent("ATTENTION NEEDED"));
            }
            PPDeviceInfoModel setupItem = new PPDeviceInfoModel();
            setupItem.type = PPCommonInfo.INT_BUY_A_SUBSCRIPTION;
            setupItem.connected = true;
            setupItem.desc = "Get a Subscription";
            setupItem.icon = PPFontIconLabel.ICON_FA_SHOPPING_CART;
            events.add(FAEventUtils.createEvent(setupItem));
        } else {
            if (isDeviceListEmpty && VirtuosoCommonSettings.supportStore) {
                if (!hasAttentionAlready) {
                    hasAttentionAlready = true;
                    events.add(FAEventUtils.createEvent("ATTENTION NEEDED"));
                }
                if (userManager.isServiceFamilyTrialPredicate() || userManager.isServiceFamilyPredicate()) {
                    PPDeviceInfoModel setupItem = new PPDeviceInfoModel();
                    setupItem.type = PPCommonInfo.INT_BUY_DEVICES;
                    setupItem.connected = true;
                    setupItem.desc = "Buy Devices";
                    setupItem.icon = PPFontIconLabel.ICON_FA_CART_PLUS;
                    events.add(FAEventUtils.createEvent(setupItem));
                } else {
                    PPDeviceInfoModel setupItem = new PPDeviceInfoModel();
                    setupItem.type = PPCommonInfo.INT_SHOP_AT_STORE;
                    setupItem.connected = true;
                    setupItem.desc = "Shop at our store";
                    setupItem.icon = PPFontIconLabel.ICON_FA_SHOPPING_CART;
                    events.add(FAEventUtils.createEvent(setupItem));
                }
            }

            final boolean finalHasAttentionAlready = hasAttentionAlready;
            Realm.getDefaultInstance().executeTransaction(new Transaction() {
                @Override
                public void execute(Realm realm) {
                    PPLocationServicePlanModel renewedPlan = PPLocationServicePlanModel.getRenewServicePlan(realm,
                        PPAppCenter.m_SharedPresence.getLocationId());
                    if (null != renewedPlan) {
                        long expiredDays = PPCommonInfo.getExpiredTime(renewedPlan.endDateMs);
                        if (expiredDays <= 15) {
                            if (!finalHasAttentionAlready) {
                                events.add(FAEventUtils.createEvent("ATTENTION NEEDED"));
                            }
                            PPDeviceInfoModel setupItem = new PPDeviceInfoModel();
                            setupItem.type = PPCommonInfo.INT_BUY_A_SUBSCRIPTION;
                            setupItem.connected = true;
                            setupItem.desc = "Renew your Subscription";
                            if (expiredDays == 1) {
                                setupItem.sSecondaryDescription = "Expiring in 1 day";
                            } else {
                                setupItem.sSecondaryDescription = String.format("Expiring in %d days", expiredDays);
                            }
                            setupItem.icon = PPFontIconLabel.ICON_FA_SHOPPING_CART;
                            events.add(FAEventUtils.createEvent(setupItem));
                        }
                    }
                }
            });
        }
    }

    public static void parseDashboardHeader(JSONObject valObj, List<FAEvent> events) {
        for (FAEvent event : events) {
            if (event.eventType == FAEventUtils.FAEventTypeHeader) {
                parseDashboardData(valObj, event);
                break;
            }
        }
    }

    public static void parseDashboardData(JSONObject valObj, FAEvent event) {
        event.headerModel.name = valObj.getString("name");
        event.headerModel.priority = valObj.getIntValue("priority");
        event.headerModel.icon = valObj.getString("icon");
        event.headerModel.icon_font = valObj.getString("icon_font");
        event.headerModel.title = valObj.getString("title");
        event.headerModel.comment = valObj.getString("comment");
        event.headerModel.call = valObj.getBooleanValue("call");
        event.headerModel.ecc = valObj.getBooleanValue("ecc");
        event.headerModel.updated_ms = valObj.getLongValue("updated_ms");
        JSONObject resolutionObj = valObj.getJSONObject("resolution");
        if (null != resolutionObj) {
            event.headerModel.resolution = new Resolution();
            event.headerModel.resolution.button = resolutionObj.getString("button");
            event.headerModel.resolution.title = resolutionObj.getString("title");
            event.headerModel.resolution.datastream_address = resolutionObj.getString("datastream_address");

            JSONObject contentObj = resolutionObj.getJSONObject("content");
            if (null != contentObj) {
                event.headerModel.resolution.content = new Content();
                event.headerModel.resolution.content.microservice_id = contentObj.getString("microservice_id");
                event.headerModel.resolution.content.conversation_id = contentObj.getString("conversation_id");
                event.headerModel.resolution.content.timestamp_ms = contentObj.getString("timestamp_ms");
                event.headerModel.resolution.content.user_id = contentObj.getString("user_id");
            }
            JSONArray optionsArray = resolutionObj.getJSONArray("response_options");
            if (null != optionsArray && !optionsArray.isEmpty()) {
                event.headerModel.resolution.options = new ArrayList<>();
                for (int i = 0; i != optionsArray.size(); ++i) {
                    JSONObject optionObj = optionsArray.getJSONObject(i);
                    ResponseOption option = new ResponseOption();
                    option.text = optionObj.getString("text");
                    option.icon = optionObj.getString("icon");
                    option.icon_font = optionObj.getString("icon_font");
                    option.ack = optionObj.getString("ack");
                    JSONObject optionContentObj = optionObj.getJSONObject("content");
                    if (null != optionContentObj) {
                        option.contentAnswer = optionContentObj.getIntValue("answer");
                    }
                    event.headerModel.resolution.options.add(option);
                }
            }
        } else {
            event.headerModel.resolution = null;
        }
        JSONObject feedObj = valObj.getJSONObject("feedback");
        if (null != feedObj) {
            event.headerModel.feedBack = new FeedBack();
            event.headerModel.feedBack.quantified = feedObj.getString("quantified");
            event.headerModel.feedBack.verbatim = feedObj.getString("verbatim");
            event.headerModel.feedBack.datastream_address = feedObj.getString("datastream_address");

            JSONObject contentObj = feedObj.getJSONObject("content");
            if (null != contentObj) {
                event.headerModel.feedBack.content = new Content();
                event.headerModel.feedBack.content.microservice_id = contentObj.getString("microservice_id");
                event.headerModel.feedBack.content.quantified = contentObj.getString("quantified");
                event.headerModel.feedBack.content.verbatim = contentObj.getString("verbatim");
                event.headerModel.feedBack.content.user_id = contentObj.getString("user_id");
            }
        } else {
            event.headerModel.feedBack = null;
        }
    }

    private void parseTasks(JSONObject valObj, List<FAEvent> events) {
        mDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<PPTaskModel> tasks = new ArrayList<>();
        for (String key : valObj.keySet()) {
            JSONObject contentObj = valObj.getJSONObject(key);
            if (null == contentObj) {
                continue;
            }
            tasks.add(createTaskModel(key, contentObj));
        }
        if (tasks.isEmpty()) {
            return;
        }
        if (PPAppCenter.m_SharedPresence.getKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS) == 1) {
            Iterator<PPTaskModel> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                PPTaskModel task = iterator.next();
                if (!TextUtils.isEmpty(task.url) && task.url.endsWith("oobe")) {
                    iterator.remove();
                    break;
                }
            }
        }
        if (tasks.isEmpty()) {
            return;
        }

        securitySectionIndex = events.size();
        events.add(FAEventUtils.createEvent("TASKS"));
        Collections.sort(tasks, new TaskComparator(TaskComparator.SORT_BY_ALPHABETICAL));
        Collections.sort(tasks, new TaskComparator(TaskComparator.SORT_BY_DUE_DATE));
        Iterator<PPTaskModel> iterator = tasks.iterator();
        List<PPTaskModel> myTasks = new ArrayList<>();
        while (iterator.hasNext()) {
            PPTaskModel task = iterator.next();
            if (!TextUtils.isEmpty(task.assigned_to)
                && task.assigned_to.equals(PPAppCenter.m_SharedPresence.getUserId())) {
                iterator.remove();
                myTasks.add(task);
            }
        }

        for (int i = 0; i != myTasks.size(); ++i) {
            events.add(FAEventUtils.createEvent(myTasks.get(i)));
        }

        for (int i = 0; i != tasks.size(); ++i) {
            events.add(FAEventUtils.createEvent(tasks.get(i)));
        }
    }

    private void parseCards(JSONObject valObj, List<FAEvent> events) {
        JSONArray cardsArray = valObj.getJSONArray("cards");
        if (!cardsArray.isEmpty() && (PPAppCenter.SPRINT_VERSION < 22
            || !VirtuosoCommonSettings.supportNewDashboard)) {
            events.add(FAEventUtils.createEvent("NOW"));
        }
        for (int i = 0; i != cardsArray.size(); ++i) {
            JSONObject cardObj = cardsArray.getJSONObject(i);
            JSONArray contentArray = cardObj.getJSONArray("content");
            for (int j = 0; j != contentArray.size(); ++j) {
                PPCardStatusModel cardStatusModel = createCardStatusModel(contentArray.getJSONObject(j));
                if (cardStatusModel.status != -1) {
                    events.add(FAEventUtils.createEvent(cardStatusModel));
                }
            }
        }
    }

    private void parseServices(JSONObject valObj, List<FAEvent> events) {
        JSONArray array = valObj.getJSONArray("cards");
        if (!isReportAdded) {
            addReports(events);
        }
        for (int j = 0; j != array.size(); ++j) {
            JSONObject cardObj = array.getJSONObject(j);
            events.add(FAEventUtils.createEvent(cardObj.getString("title")));
            JSONArray contentArray = cardObj.getJSONArray("content");
            for (int l = 0; l != contentArray.size(); ++l) {
                JSONObject contentObj = contentArray.getJSONObject(l);
                if (null == contentObj) {
                    continue;
                }
                events.add(FAEventUtils.createEvent(createCardServiceModel(contentObj)));
            }
        }
    }

    private void parseServices(final JSONObject valObj) {
        Realm.getDefaultInstance().executeTransaction(new Transaction() {
            @Override
            public void execute(Realm realm) {
                JSONArray cardsArray = valObj.getJSONArray("cards");
                for (int i = 0; i != cardsArray.size(); ++i) {
                    JSONObject cardObj = cardsArray.getJSONObject(i);
                    JSONArray contentArray = cardObj.getJSONArray("content");
                    serviceCount = contentArray.size();
                    String[] ids = new String[serviceCount];
                    for (int j = 0; j != contentArray.size(); ++j) {
                        JSONObject contentObj = contentArray.getJSONObject(j);
                        String id = contentObj.getString("id");
                        createCardServiceModel(realm, contentObj);
                        ids[j] = id;
                    }
                    realm.where(PPCardServiceModel.class).beginGroup()
                        .not()
                        .in("id", ids)
                        .endGroup()
                        .findAll().deleteAllFromRealm();

                    enabledServiceCount = realm.where(PPCardServiceModel.class).equalTo("active", true).findAll().size();
                    serviceCount = PPCardServiceModel.findAll(realm).size();
                }
            }
        });
    }

    private void addReports(List<FAEvent> events) {
        if (VirtuosoCommonSettings.supportSimplifyDashboard) {
            isReportAdded = true;
            if (PPAppCenter.SPRINT_VERSION > 21 && VirtuosoCommonSettings.supportNewDashboard) {
                isReportAdded = true;
                events.add(FAEventUtils.createEvent("DETAILS"));
                if (serviceCount > 0) {
                    String alertsDescription = "None enabled.";
                    if (enabledServiceCount > 0) {
                        if (enabledServiceCount == serviceCount) {
                            alertsDescription = "All enabled.";
                        } else {
                            alertsDescription = String.format("%d out of %d enabled.", enabledServiceCount, serviceCount);
                        }
                    }
                    events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeAlertService, "Services & Alerts", alertsDescription));
                }
                if (PPUserManager.getInstance().isServiceFamilyPredicate()) {
                    events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeReport, "Daily Report", "Consolidated history of the day."));
                }
                events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeNotification, "Detailed History", "Full history of tasks and events."));
            } else {
                events.add(FAEventUtils.createEvent("REPORTS"));
                if (PPUserManager.getInstance().isServiceFamilyPredicate()) {
                    events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeReport, "Daily Report", null));
                }
                events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeNotification, "History", null));
            }
        }
    }

    private void addSecuritySystem(List<FAEvent> events) {
        if (securitySectionIndex == -1) {
            events.add(FAEventUtils.createEvent("SECURITY SYSTEM"));
            events.add(FAEventUtils.createEvent(FAEventUtils.FAEventTypeSecuritySystem, "OFF", "Disarmed."));
        } else {
            events.add(securitySectionIndex, FAEventUtils.createEvent("SECURITY SYSTEM"));
            events.add(securitySectionIndex + 1, FAEventUtils.createEvent(FAEventUtils.FAEventTypeSecuritySystem, "OFF", "Disarmed."));
        }
    }

    private PPTaskModel createTaskModel(String key, JSONObject contentObj) {
        PPTaskModel model = new PPTaskModel();
        model.id = key;
        model.title = contentObj.getString("title");
        model.due_date = contentObj.getString("due_date");
        model.priority = contentObj.containsKey("priority") ? contentObj.getIntValue("priority") : PPCommonInfo.PPInvalidValue;
        model.assigned_to = contentObj.getString("assigned_to");
        model.created_by = contentObj.getString("created_by");
        model.comment = contentObj.getString("comment");
        model.icon = contentObj.getString("icon");
        model.color = contentObj.getString("color");
        model.uiStyle = contentObj.getString("ui_style");
        model.updated = contentObj.getLongValue("updated");
        model.editable = contentObj.getBooleanValue("editable");
        model.url = contentObj.getString("url");
        return model;
    }

    private PPCardStatusModel createCardStatusModel(JSONObject contentObj) {
        PPCardStatusModel model = new PPCardStatusModel();
        model.id = contentObj.getString("id");
        model.deviceId = contentObj.getString("device_id");
        model.status = contentObj.getIntValue("status");
        model.comment = contentObj.getString("comment");
        model.updatedMs = contentObj.getLongValue("updated");
        model.icon = contentObj.getString("icon");
        model.fontType = contentObj.getString("font_type");
        return model;
    }

    private PPCardServiceModel createCardServiceModel(JSONObject contentObj) {
        PPCardServiceModel model = new PPCardServiceModel();
        model.id = contentObj.getString("id");
        model.icon = contentObj.getString("icon");
        model.title = contentObj.getString("title");
        model.description = contentObj.getString("description");
        model.comment = contentObj.getString("comment");
        model.status = contentObj.getIntValue("status");
        model.percent = contentObj.containsKey("percent") ? contentObj.getFloatValue("percent") : 100;
        model.active = contentObj.getBooleanValue("active");
        model.questionId = contentObj.getString("question_id");
        model.collectionId = contentObj.getString("collection_id");
        model.sectionId = contentObj.getString("section_id");
        model.updatedMs = contentObj.getLongValue("updated");
        return model;
    }

    private void createCardServiceModel(Realm realm, JSONObject contentObj) {
        String serviceId = contentObj.getString("id");
        PPCardServiceModel model = realm.where(PPCardServiceModel.class)
            .equalTo("id", serviceId).findFirst();
        if (null == model) {
            model = realm.createObject(PPCardServiceModel.class, serviceId);
        }
        model.icon = contentObj.getString("icon");
        model.title = contentObj.getString("title");
        model.description = contentObj.getString("description");
        model.comment = contentObj.getString("comment");
        model.statusText = contentObj.getString("status_text");
        model.status = contentObj.getIntValue("status");
        model.percent = contentObj.containsKey("percent") ? contentObj.getFloatValue("percent") : 100;
        model.active = contentObj.getBooleanValue("active");
        model.questionId = contentObj.getString("question_id");
        model.collectionId = contentObj.getString("collection_id");
        model.sectionId = contentObj.getString("section_id");
        model.updatedMs = contentObj.getLongValue("updated");
        model.weight = contentObj.getIntValue("weight");
        model.displayType = PPCardServiceModel.TYPE_NORMAL;
    }

    private boolean isStatusType(JSONArray array) {
        for (int j = 0; j != array.size(); ++j) {
            JSONObject cardObj = array.getJSONObject(j);
            int cardType = cardObj.getIntValue("type");
            if (cardType == 0) {
                return true;
            }
        }
        return false;
    }

    private class TaskComparator implements Comparator<PPTaskModel> {

        private int sortWay;
        private String currentDate;

        public static final int SORT_BY_ALPHABETICAL = 0;
        public static final int SORT_BY_DUE_DATE = 1;

        public TaskComparator(int sortWay) {
            this.sortWay = sortWay;
            this.currentDate = mDateFormat.format(new Date());
        }

        @Override
        public int compare(PPTaskModel o1, PPTaskModel o2) {
            if (sortWay == SORT_BY_ALPHABETICAL) {
                return o1.title.compareTo(o2.title);
            } else {
                if (null != o1.due_date && null != o2.due_date) {
                    return o1.due_date.compareTo(o2.due_date);
                } else if (null == o1.due_date && null == o2.due_date) {
                    return 0;
                } else {
                    if (null != o1.due_date) {
                        return o1.due_date.compareTo(currentDate);
                    } else {
                        return currentDate.compareTo(o2.due_date);
                    }
                }
            }
        }
    }
}
