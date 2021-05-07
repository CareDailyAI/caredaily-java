package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.managers.PPLocationUserManager;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import com.peoplepowerco.virtuoso.util.PPUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class PPLocationUserSupportTaskParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPLocationUserModel> filteredUserModels = (List<PPLocationUserModel>) obj[0];
        filteredUserModels.clear();

        if (jso.containsKey("users")) {
            JSONArray array = jso.getJSONArray("users");
            List<PPLocationUserModel> results = JSON.parseArray(array.toString(), PPLocationUserModel.class);
            if (null != results) {
                HashMap<Integer, ArrayList<PPLocationUserModel>> sections = new HashMap<>();
                List<PPLocationUserModel> filteredResults = new ArrayList<>();
                for (PPLocationUserModel userModel : results) {
                    if (userModel.getLocationAccess() != PPLocationUserManager.LOCATION_SECTION_TYPE_NONE
                        && userModel.getCategory() != PPLocationUserManager.LOCATION_CATEGORY_TYPE_NONE) {
                        filteredResults.add(userModel);
                    }
                }
                for (PPLocationUserModel userModel : filteredResults) {
                    if (!sections.containsKey(userModel.getLocationAccess())) {
                        ArrayList<PPLocationUserModel> values = new ArrayList<>();
                        values.add(userModel);
                        sections.put(userModel.getLocationAccess(), values);
                    } else {
                        ArrayList<PPLocationUserModel> values = sections.get(userModel.getLocationAccess());
                        values.add(userModel);
                    }
                }
                ArrayList<Integer> sortedKeys = new ArrayList<>();
                for (int key : sections.keySet()) {
                    sortedKeys.add(key);
                }
                Collections.sort(sortedKeys);
                for (int i = sortedKeys.size() - 1; i != -1; --i) {
                    int key = sortedKeys.get(i);
                    ArrayList<PPLocationUserModel> categoryUsers = sections.get(key);
                    Collections.sort(categoryUsers, new PPLastNameAlphabetical());
                    PPLocationUserModel sectionModel = new PPLocationUserModel();
                    sectionModel.setSectionType(key);
                    filteredUserModels.add(sectionModel);
                    filteredUserModels.addAll(categoryUsers);
                }
                return true;
            }
        }
        return false;
    }

    private class PPLastNameAlphabetical implements Comparator<PPLocationUserModel> {

        @Override
        public int compare(PPLocationUserModel lUserModel, PPLocationUserModel rUserModel) {
            int result = 0;
            try {
                if (!PPUtil.isEmpty(lUserModel.getLastName()) && !PPUtil.isEmpty(rUserModel.getLastName())) {
                    result = lUserModel.getLastName().compareToIgnoreCase(rUserModel.getLastName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }
    }
}
