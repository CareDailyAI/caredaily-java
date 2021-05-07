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

public class PPLocationUserParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPLocationUserModel> userModels = (List<PPLocationUserModel>) obj[0];
        List<PPLocationUserModel> ownerUserModels = obj.length > 1 ? (List<PPLocationUserModel>) obj[1] : null;
        userModels.clear();
        if (null != ownerUserModels) {
            ownerUserModels.clear();
        }

        if (jso.containsKey("users")) {
            JSONArray array = jso.getJSONArray("users");
            List<PPLocationUserModel> results = JSON.parseArray(array.toString(), PPLocationUserModel.class);
            if (null != results) {
                if (null == ownerUserModels) {
                    userModels.addAll(results);
                    return true;
                }

                HashMap<Integer, ArrayList<PPLocationUserModel>> sections = new HashMap<>();
                for (PPLocationUserModel userModel : results) {
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
                    userModels.add(sectionModel);
                    userModels.addAll(categoryUsers);
                }
                for (int i = sortedKeys.size() - 1; i != -1; --i) {
                    int key = sortedKeys.get(i);
                    if (key == PPLocationUserManager.LOCATION_SECTION_TYPE_OWNER) {
                        ArrayList<PPLocationUserModel> categoryUsers = sections.get(key);
                        PPLocationUserModel sectionModel = new PPLocationUserModel();
                        sectionModel.setSectionType(key);
                        ownerUserModels.add(sectionModel);
                        ownerUserModels.addAll(categoryUsers);
                        break;
                    }
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
