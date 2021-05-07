package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.managers.PPStorybookManager;
import com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel;
import com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfo;
import com.peoplepowerco.virtuoso.models.storybook.Model;
import com.peoplepowerco.virtuoso.models.storybook.PPGetStoryModel;
import com.peoplepowerco.virtuoso.models.storybook.Story;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by edwardliu on 2018/6/21.
 */

public class PPGetStoryModelParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        PPGetStoryModel storyModel = (PPGetStoryModel) obj[0];
        storyModel.stories.clear();
        if (jso.containsKey("stories")) {
            HashSet<String> brands = new HashSet<>();
            JSONArray storyArray = jso.getJSONArray("stories");
            boolean findNewBundle = false;
            for (int i = 0; i != storyArray.size(); ++i) {
                JSONObject storyObj = storyArray.getJSONObject(i);
                int storyType = storyObj.getIntValue("storyType");
                if (storyType == 9) {
                    findNewBundle = true;
                    break;
                }
            }

            PPAppCenter.BUNDLE_VERSION = findNewBundle ? 2 : 1;
            for (int i = 0; i != storyArray.size(); ++i) {
                JSONObject storyObj = storyArray.getJSONObject(i);
                final Story story = JSON.parseObject(storyObj.toString(), Story.class);
                int storyType = storyObj.getIntValue("storyType");
                if (storyType == 52) {
                    JSONObject displayInfo = storyObj.getJSONObject("displayInfo");
                    if(displayInfo !=null) {
                        JSONArray osArray = displayInfo.getJSONArray("android");
                        List osList = new ArrayList();
                        if (osArray != null && !osArray.isEmpty()) {
                            for (int k = 0; k != osArray.size(); ++k) {
                                osList.add(osArray.getString(k));
                            }
                            story.setPublishedOSVersion(osList);
                        }
                    }
                }
                if (storyType == 30) {
                    JSONObject displayInfo = storyObj.getJSONObject("displayInfo");
                    if(displayInfo !=null) {
                        DisplayInfo display = new DisplayInfo();
                        display.setIconName(displayInfo.containsKey("iconName") ? displayInfo.getString("iconName") : null);
                        display.setIconType(displayInfo.containsKey("iconType") ? displayInfo.getString("iconType") : null);
                        story.setDisplayInfo(display);
                    }
                }
                storyModel.stories.add(story);
                if (PPAppCenter.BUNDLE_VERSION == 1) {
                    continue;
                }

                JSONArray brandsArray = storyObj.getJSONArray("brands");
                if (story.getStoryType() == 9) {
                    brands.clear();
                    if (null != brandsArray && !brandsArray.isEmpty()) {
                        for (int j = 0; j != brandsArray.size(); ++j) {
                            brands.add(brandsArray.getString(j));
                        }
                    }
                    if (!brands.contains(PPAppCenter.BRAND_NAME)) {
                        continue;
                    }
                    JSONObject displayObj = storyObj.getJSONObject("displayInfo");
                    if (null == displayObj) {
                        continue;
                    }
                    final JSONObject bundleObj = displayObj.getJSONObject("deviceBundle");
                    if (null == bundleObj) {
                        continue;
                    }

                    Realm.getDefaultInstance().executeTransaction(new Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            DeviceBundle deviceBundle = realm.where(DeviceBundle.class).equalTo("storyId", story.getId()).findFirst();
                            if (null == deviceBundle) {
                                deviceBundle = realm.createObject(DeviceBundle.class, story.getId());
                            }
                            deviceBundle.id = bundleObj.getString("id");
                            deviceBundle.title = story.getTitle();
                            deviceBundle.desc = bundleObj.getString("desc");
                            if (null != story.getPages()) {
                                deviceBundle.bundlePageSize = story.getPages().size();
                            }
                            deviceBundle.iconIndexes.deleteAllFromRealm();
                            JSONArray iconArray = bundleObj.getJSONArray("iconIndexes");
                            for (int k = 0; k != iconArray.size(); ++k) {
                                deviceBundle.iconIndexes.add(iconArray.getIntValue(k));
                            }
                            deviceBundle.models.deleteAllFromRealm();
                            if (bundleObj.containsKey("models")) {
                                JSONArray modelArray = bundleObj.getJSONArray("models");
                                for (int k = 0; k != modelArray.size(); ++k) {
                                    BundleModel bundleModel = realm.createObjectFromJson(BundleModel.class,
                                        modelArray.getJSONObject(k).toJSONString());
                                    Model model = PPStorybookManager.getInstance().getModelByModelId(bundleModel.modelIds.first());
                                    if (null != model && null != model.getMedia() && !model.getMedia().isEmpty()) {
                                        bundleModel.mediaUrl = model.getMedia().get(0).getUrl();
                                    }
                                    deviceBundle.models.add(bundleModel);
                                }
                            }
                            deviceBundle.accessories.deleteAllFromRealm();
                            if (bundleObj.containsKey("accessories")) {
                                JSONArray accessArray = bundleObj.getJSONArray("accessories");
                                for (int k = 0; k != accessArray.size(); ++k) {
                                    JSONObject accessObj = accessArray.getJSONObject(k);
                                    deviceBundle.accessories.add(accessObj.getString("modelId"));
                                }
                                if (!deviceBundle.accessories.isEmpty()) {
                                    BundleModel accessModel = realm.createObject(BundleModel.class);
                                    accessModel.compressed = true;
                                    accessModel.icon = PPFontIconLabel.ICON_FA_ELLIPSIS_H;
                                    accessModel.count = deviceBundle.accessories.size();
                                    deviceBundle.models.add(accessModel);
                                }
                            }
                        }
                    });
                }
            }
        }
        return true;
    }
}
