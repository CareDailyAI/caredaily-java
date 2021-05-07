package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.managers.PPCallCenterManager;
import com.peoplepowerco.virtuoso.models.PPCallCenterContactsModel;
import com.peoplepowerco.virtuoso.models.PPCallCenterModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PPLocationUserFilteredParser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<PPLocationUserModel> userModels = (List<PPLocationUserModel>) obj[0];
        List<PPLocationUserModel> filteredUserModels = (List<PPLocationUserModel>) obj[1];
        userModels.clear();
        filteredUserModels.clear();

        PPCallCenterModel model = PPCallCenterManager.getInstance().getCallCenterModel();
        ArrayList<PPCallCenterContactsModel> contacts = null;
        if (null != model) {
            contacts = model.getCallCenterContactsModelArrayList();
        }
        Set<Integer> filteredIds = new HashSet<>();
        if (!TextUtils.isEmpty(model.getUserId())) {
            filteredIds.add(Integer.valueOf(model.getUserId()));
        }
        if (null != contacts && !contacts.isEmpty()) {
            for (PPCallCenterContactsModel callModel : contacts) {
                filteredIds.add(callModel.getUserId());
            }
        }

        if (jso.containsKey("users")) {
            JSONArray array = jso.getJSONArray("users");
            List<PPLocationUserModel> results = JSON.parseArray(array.toString(), PPLocationUserModel.class);
            if (null != results) {
                HashMap<Integer, ArrayList<PPLocationUserModel>> sections = new HashMap<>();
                for (PPLocationUserModel userModel : results) {
                    if (filteredIds.isEmpty() || !filteredIds.contains(userModel.getId())) {
                        if (!sections.containsKey(userModel.getLocationAccess())) {
                            ArrayList<PPLocationUserModel> values = new ArrayList<>();
                            values.add(userModel);
                            sections.put(userModel.getLocationAccess(), values);
                        } else {
                            ArrayList<PPLocationUserModel> values = sections.get(userModel.getLocationAccess());
                            values.add(userModel);
                        }
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
                    PPLocationUserModel sectionModel = new PPLocationUserModel();
                    sectionModel.setSectionType(key);
                    filteredUserModels.add(sectionModel);
                    filteredUserModels.addAll(categoryUsers);
                }

                sections.clear();
                sortedKeys.clear();
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
                for (int key : sections.keySet()) {
                    sortedKeys.add(key);
                }
                Collections.sort(sortedKeys);
                for (int i = sortedKeys.size() - 1; i != -1; --i) {
                    int key = sortedKeys.get(i);
                    ArrayList<PPLocationUserModel> categoryUsers = sections.get(key);
                    PPLocationUserModel sectionModel = new PPLocationUserModel();
                    sectionModel.setSectionType(key);
                    userModels.add(sectionModel);
                    userModels.addAll(categoryUsers);
                }
                return true;
            }
        }
        return false;
    }
}
