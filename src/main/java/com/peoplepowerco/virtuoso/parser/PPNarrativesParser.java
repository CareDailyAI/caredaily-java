package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.bean.FAEvent;
import com.peoplepowerco.virtuoso.bean.FAEventUtils;
import com.peoplepowerco.virtuoso.bean.SectionObject;
import com.peoplepowerco.virtuoso.models.narratives.PPNarrativeModel;

import java.util.List;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPNarrativesParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArrayProperty = null;
        JSONObject json = null;
        SectionObject pageMarker = (SectionObject) obj[0];
        List<FAEvent> events = (List<FAEvent>) obj[1];
        events.clear();
        try {
            jaArrayProperty = (jso.containsKey("narratives")) ? jso.getJSONArray("narratives") : null;
            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                pageMarker.sectionName = jso.getString("nextMarker");
                for (int i = 0; i < jaArrayProperty.size(); i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    PPNarrativeModel narrativeModel = new PPNarrativeModel();
                    narrativeModel.narrativeId = json.containsKey("id") ? Integer.valueOf(json.getString("id")) : PPCommonInfo.PPInvalidValue;
                    narrativeModel.locationId = json.containsKey("locationId") ? Integer.valueOf(json.getString("locationId")) : PPCommonInfo.PPInvalidValue;
                    narrativeModel.priority = json.containsKey("priority") ? Integer.valueOf(json.getString("priority")) : PPCommonInfo.PPInvalidValue;
                    narrativeModel.icon = json.getString("icon");
                    narrativeModel.title = json.getString("title");
                    narrativeModel.description = json.getString("description");
                    narrativeModel.narrativeDate = json.getString("narrativeDate");
                    narrativeModel.creationDate = json.getString("creationDate");
                    narrativeModel.appInstanceId = json.getString("appInstanceId");
                    narrativeModel.creationDateMS = json.getLongValue("creationDateMs");
                    narrativeModel.narrativeDateMS = json.getLongValue("narrativeDateMs");

                    FAEvent event = FAEventUtils.createEvent(narrativeModel);
                    events.add(event);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
