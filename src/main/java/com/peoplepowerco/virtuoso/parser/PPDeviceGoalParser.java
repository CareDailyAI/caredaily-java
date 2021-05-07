package com.peoplepowerco.virtuoso.parser;

import android.content.Context;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel;
import java.util.ArrayList;


public class PPDeviceGoalParser implements PPBaseJsonParser {

    public static final String TAG = "PPDeviceGoalParser";
    public ArrayList<PPDeviceGoalsModel> m_deviceGoalArrayList;

    private Context ctx = PPVirtuoso.getInstance().getContext();

    private final String SECURITY = ctx.getString(R.string.goal_category_security);
    private final String ELDERLYCARE = ctx.getString(R.string.goal_category_care);
    private final String LIFESTYLE = ctx.getString(R.string.goal_category_life);
    private final String WELLNESS = ctx.getString(R.string.goal_category_wellness);
    private final String ENERGY = ctx.getString(R.string.goal_category_energy);
    private final String HEALTH = ctx.getString(R.string.goal_category_health);

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaArrayGoal = null;
        JSONObject json = null;
        String sCategory = null;

        try {
            m_deviceGoalArrayList = (ArrayList<PPDeviceGoalsModel>) obj[0];

            if (m_deviceGoalArrayList != null) {
                m_deviceGoalArrayList.clear();
            }

            jaArrayGoal = (jso.containsKey("goals")) ? jso.getJSONArray("goals") : null;
            if (jaArrayGoal != null && jaArrayGoal.size() > 0) {
                int nArrayName = jaArrayGoal.size();
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayGoal.getJSONObject(i);
                    PPDeviceGoalsModel deviceGoalModel = new PPDeviceGoalsModel();
                    deviceGoalModel.id = (json.getInteger("id"));
                    deviceGoalModel.sName = ((json.containsKey("name")) ? json.getString("name") : null);
                    deviceGoalModel.sDesc = ((json.containsKey("desc")) ? json.getString("desc") : null);
                    m_deviceGoalArrayList.add(deviceGoalModel);
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

    private String setCategoryString(String sInitial) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> arCategory = new ArrayList<String>();
        if (sInitial.contains("S")) {
            arCategory.add(SECURITY);
        }
        if (sInitial.contains("L")) {
            arCategory.add(LIFESTYLE);
        }
        if (sInitial.contains("W")) {
            arCategory.add(WELLNESS);
        }
        if (sInitial.contains("E")) {
            arCategory.add(ENERGY);
        }
        if (sInitial.contains("H")) {
            arCategory.add(HEALTH);
        }
        for (int i = 0; i < arCategory.size(); i++) {
            sb.append(arCategory.get(i) + ", ");
        }
        String sCategory = sb.toString();
        if (!sb.toString().equals("")) {
            sCategory = sCategory.substring(0, sCategory.lastIndexOf(","));
        }
        return sCategory;
    }
}
