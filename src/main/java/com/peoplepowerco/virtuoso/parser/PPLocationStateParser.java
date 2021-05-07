package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel;
import com.peoplepowerco.virtuoso.models.PPLocationStateReportModel;
import com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationStateModel;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PPLocationStateParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPLocationStateModel stateModel = (PPLocationStateModel) obj[0];
        String locationId = (String) obj[1];
        String stateName = null;
        if (obj.length > 2) {
            stateName = (String) obj[2];
            if (stateName.equals(PPCommonInfo.LOCATION_STATE_REPORTS)) {
                stateModel.reports.clear();
            }
        }
        if (jso.containsKey("states")) {
            JSONArray statesArray = jso.getJSONArray("states");
            for (int i = 0; i != statesArray.size(); ++i) {
                JSONObject stateObj = statesArray.getJSONObject(i);
                String name = stateObj.getString("name");
                if (!stateObj.containsKey("value")) {
                    continue;
                }
                JSONObject valObj = stateObj.getJSONObject("value");
                if (name.equals(PPCommonInfo.LOCATION_STATE_SECURITY_STATE)) {
                    stateModel.locationId = locationId;
                    stateModel.state = valObj.containsKey("state") ? valObj.getIntValue("state") : -1;
                    stateModel.description = valObj.getString("description");
                    stateModel.timestamp_ms = valObj.getLongValue("timestamp_ms");
                    stateModel.next_timestamp_ms = valObj.getLongValue("next_timestamp_ms");
                    long delta = (stateModel.next_timestamp_ms - System.currentTimeMillis()) / 1000;
                    stateModel.seconds = new Long(delta).intValue();
                } else if (name.equals(PPCommonInfo.LOCATION_STATE_SOCIAL_CONNECTOR)) {
                    stateModel.hasSocialConnector = valObj.getBooleanValue("has_social_connector");
                } else if (name.equals(PPCommonInfo.LOCATION_STATE_PROPERTIES)) {
                    stateModel.enableUserAuthentication = valObj.getBooleanValue("requires_user_authentication");
                } else if (name.equals(PPCommonInfo.LOCATION_STATE_DEVICE_BUNDLES)) {
                    Set<String> keys = valObj.keySet();
                    for (String key : keys) {
                        PPAppCenter.m_SharedPresence.setKeyIntValue(key, valObj.getIntValue(key));
                    }
                    PPAppCenter.m_SharedPresence.setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS,
                        getBundleStatus(valObj, keys, DeviceBundle.findAllBundles(Realm.getDefaultInstance())));
                } else if (name.equals(PPCommonInfo.LOCATION_STATE_REPORTS)) {
                    PPLocationStateReportModel headerModel = new PPLocationStateReportModel();
                    headerModel.reportType = PPLocationStateReportModel.REPORT_TYPE_HEADER;
                    headerModel.title = valObj.getString("title");
                    headerModel.subtitle = valObj.getString("subtitle");
                    headerModel.timestampMs = valObj.getLongValue("created_ms");
                    stateModel.reports.add(headerModel);

                    JSONArray sectionsArray = valObj.getJSONArray("sections");
                    if (null != sectionsArray && !sectionsArray.isEmpty()) {
                        List<PPLocationStateReportModel> sectionModels = new ArrayList<>();
                        for (int j = 0; j != sectionsArray.size(); ++j) {
                            JSONObject sectionObj = sectionsArray.getJSONObject(j);
                            PPLocationStateReportModel sectionModel = new PPLocationStateReportModel();
                            sectionModel.weight = sectionObj.getIntValue("weight");
                            sectionModel.reportType = PPLocationStateReportModel.REPORT_TYPE_SECTION;
                            sectionModel.id = sectionObj.getString("id");
                            sectionModel.title = sectionObj.getString("title");
                            sectionModel.subtitle = sectionObj.getString("subtitle");
                            sectionModel.icon = sectionObj.getString("icon");
                            sectionModel.color = sectionObj.getString("color");
                            if (sectionObj.containsKey("items")) {
                                JSONArray itemsArray = sectionObj.getJSONArray("items");
                                if (null != itemsArray && !itemsArray.isEmpty()) {
                                    sectionModel.itemsArray = itemsArray;
                                }
                            }

                            sectionModels.add(sectionModel);
                        }
                        Collections.sort(sectionModels, new SectionComparator());

                        for (PPLocationStateReportModel sectionModel : sectionModels) {
                            if (!stateModel.reports.contains(sectionModel)) {
                                stateModel.reports.add(sectionModel);
                            }

                            if (null == sectionModel.itemsArray) {
                                continue;
                            }
                            for (int j = 0; j != sectionModel.itemsArray.size(); ++j) {
                                JSONObject itemObj = sectionModel.itemsArray.getJSONObject(j);
                                String comment = itemObj.getString("comment");
                                if (TextUtils.isEmpty(comment)) {
                                    continue;
                                }
                                PPLocationStateReportModel itemModel = new PPLocationStateReportModel();
                                itemModel.weight = itemObj.getIntValue("weight");
                                itemModel.id = itemObj.getString("id");
                                itemModel.reportType = PPLocationStateReportModel.REPORT_TYPE_TEXT;
                                itemModel.title = comment;
                                itemModel.timestampMs = itemObj.getLongValue("timestamp_ms");
                                itemModel.comment_raw = itemObj.getString("comment_raw");
                                itemModel.timestampStr = itemObj.getString("timestamp_str");
                                stateModel.reports.add(itemModel);
                            }
                        }
                    }
                }
//                else if (name.equals(PPCommonInfo.LOCATION_STATE_DEVICE_BUNDLES)) {
//                    Model bundleModel = PPStorybookManager.getInstance().getDeviceBundleModel();
//                    if (null != bundleModel) {
//                        Set<String> keys = valObj.keySet();
//                        if (!keys.isEmpty()) {
//                            for (String key : keys) {
//                                PPAppCenter.m_SharedPresence.setKeyIntValue(key.equals(bundleModel.getId()) ?
//                                    PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS : key, valObj.getIntValue(key));
//                            }
//                        }
//                    }
//                }
                if (valObj.containsKey("test_data") && valObj.getBooleanValue("test_data")) {
                    PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.EVENT_TRACK_DISABLED, true);
                }
            }
        } else if (jso.containsKey("value") && null != stateName) {
            final JSONObject valObj = jso.getJSONObject("value");
            if (stateName.equals(PPCommonInfo.LOCATION_STATE_BEHAVIORS)) {
                final Set<String> keys = valObj.keySet();
                if (!keys.isEmpty()) {
                    Realm.getDefaultInstance().executeTransaction(new Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            for (String key : keys) {
                                JSONArray array = valObj.getJSONArray(key);
                                for (int i = 0; i != array.size(); ++i) {
                                    JSONObject goalObj = array.getJSONObject(i);
                                    int goalId = goalObj.getIntValue("id");
                                    PPDeviceGoalsModel deviceGoalModel = realm.where(PPDeviceGoalsModel.class).equalTo("id", goalId)
                                        .and().equalTo("deviceType", Integer.valueOf(key)).findFirst();
                                    if (null == deviceGoalModel) {
                                        deviceGoalModel = realm.createObject(PPDeviceGoalsModel.class);
                                    }
                                    deviceGoalModel.id = goalObj.getIntValue("id");
                                    deviceGoalModel.deviceType = Integer.valueOf(key);
                                    deviceGoalModel.sName = goalObj.getString("name");
                                    deviceGoalModel.sIcon = goalObj.getString("icon");
                                    deviceGoalModel.sIconFont = goalObj.getString("icon_font");
                                    deviceGoalModel.sDesc = goalObj.getString("description");
                                    deviceGoalModel.nWeight = goalObj.getIntValue("weight");
                                    deviceGoalModel.suggestionList.deleteAllFromRealm();
                                    JSONArray suggestions = goalObj.getJSONArray("suggestions");
                                    if (null != suggestions) {
                                        for (int j = 0; j != suggestions.size(); j++) {
                                            deviceGoalModel.suggestionList.add(suggestions.getString(j));
                                        }
                                    }
                                    deviceGoalModel.spaceList.deleteAllFromRealm();
                                    JSONArray spaces = goalObj.getJSONArray("spaces");
                                    if (null != spaces) {
                                        for (int j = 0; j != spaces.size(); j++) {
                                            StringBuilder builder = new StringBuilder();
                                            JSONArray space = spaces.getJSONArray(j);
                                            for (int k = 0; k != space.size(); ++k) {
                                                builder.append(space.getIntValue(k));
                                                if (k != space.size() - 1) {
                                                    builder.append(",");
                                                }
                                            }
                                            deviceGoalModel.spaceList.add(builder.toString());
                                        }
                                    }
                                }
                            }
                        }
                    });
                }
            } else if (stateName.equals(PPCommonInfo.LOCATION_STATE_DEVICE_BUNDLES)) {
                Set<String> keys = valObj.keySet();
                for (String key : keys) {
                    PPAppCenter.m_SharedPresence.setKeyIntValue(key, valObj.getIntValue(key));
                }
                PPAppCenter.m_SharedPresence.setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS,
                    getBundleStatus(valObj, keys, DeviceBundle.findAllBundles(Realm.getDefaultInstance())));
            } else if (stateName.equals(PPCommonInfo.LOCATION_STATE_PROPERTIES)) {
                if (valObj.containsKey("timeseries_properties")) {
                    JSONObject timeseriesObj = valObj.getJSONObject("timeseries_properties");
                    if (timeseriesObj.containsKey("dailyreport")) {
                        stateModel.dailyreport_ms = timeseriesObj.getLongValue("dailyreport");
                    }
                }
            }
        } else if (!jso.containsKey("value") && null != stateName) {
            PPAppCenter.m_SharedPresence.setKeyIntValue(PPCommonInfo.REFERENCE_KEY_BUNDLE_STATUS, -2);
        }
        return true;
    }

    private int getBundleStatus(JSONObject valObj, Set<String> keys, RealmResults<DeviceBundle> bundles) {
        if (bundles.isEmpty()) {
            return -2;
        }
        Set<Integer> values = new HashSet<>();
        for (DeviceBundle bundle : bundles) {
            for (String key : keys) {
                if (key.equals(bundle.id)) {
                    values.add(valObj.getIntValue(key));
                }
            }
        }
        if (values.contains(1)) {
            return 1;
        } else if (values.contains(0)) {
            return 0;
        }
        return -1;
    }

    private class SectionComparator implements Comparator<PPLocationStateReportModel> {

        @Override
        public int compare(PPLocationStateReportModel o1, PPLocationStateReportModel o2) {
            if (o1.weight > o2.weight) {
                return 1;
            } else if (o1.weight < o2.weight) {
                return -1;
            }
            return 0;
        }
    }
}
