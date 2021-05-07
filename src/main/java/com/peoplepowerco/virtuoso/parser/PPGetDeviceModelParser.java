package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceTypeModel;
import com.peoplepowerco.virtuoso.models.storybook.Desc;
import com.peoplepowerco.virtuoso.models.storybook.DeviceBundle;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfo;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoDeviceListBindings;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoOption;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoOptionName;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoParameters;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoTests;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoTestsDescription;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoTestsName;
import com.peoplepowerco.virtuoso.models.storybook.LookupParam;
import com.peoplepowerco.virtuoso.models.storybook.Manufacturer;
import com.peoplepowerco.virtuoso.models.storybook.Medium;
import com.peoplepowerco.virtuoso.models.storybook.Model;
import com.peoplepowerco.virtuoso.models.storybook.Name;
import com.peoplepowerco.virtuoso.models.storybook.PPGetDeviceCategory;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import com.peoplepowerco.virtuoso.models.storybook.Param;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Created by edwardliu on 2018/6/21.
 */

public class PPGetDeviceModelParser implements PPBaseJsonParser {

    private static final String P360_ID = "Robotics";

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        List<Model> tempBundelModels = new ArrayList<>();
        List<PPGetDeviceCategory> deviceCategories = (List<PPGetDeviceCategory>) obj[0];
        List<Model> bundleModels = (List<Model>) obj[1];
        boolean dependency = (boolean) obj[2];
        int dependencyDeviceType = PPCommonInfo.PPInvalidValue;
        if (obj.length > 3) {
            dependencyDeviceType = (int) obj[3];
        }
        JSONArray array = jso.getJSONArray("categories");
        if (null == array) {
            return false;
        }
        deviceCategories.clear();
        List<PPGetDeviceCategory> allCategories = new ArrayList<>();
        for (int i = 0; i != array.size(); ++i) {
            JSONObject cateJson = array.getJSONObject(i);
            PPGetDeviceCategory category = new PPGetDeviceCategory();
            category.setHash(cateJson.getString("hash"));
            category.setHidden(cateJson.getBooleanValue("hidden"));
            category.setIcon(cateJson.getString("icon"));
            category.setId(cateJson.getString("id"));
            if (cateJson.containsKey("name")) {
                JSONObject cnameJson = cateJson.getJSONObject("name");
                Name name = new Name();
                name.setEn(cnameJson.getString("en"));
                category.setName(name);
            }
            category.setParentId(cateJson.getString("parentId"));
            category.setSearch(cateJson.getString("search"));
            category.setSortId(cateJson.getIntValue("sortId"));

            if (cateJson.containsKey("models")) {
                int deviceType = PPCommonInfo.PPInvalidValue;
                List<Model> models = new ArrayList<>();
                JSONArray modelsArray = cateJson.getJSONArray("models");
                boolean enabled = false;
                for (int j = 0; j != modelsArray.size(); ++j) {
                    Model model = new Model();
                    JSONObject modelJson = modelsArray.getJSONObject(j);
//                    model.setHash(modelJson.getString("hash"));
                    model.setHidden(modelJson.getBooleanValue("hidden"));
                    model.setSortId(modelJson.getIntValue("sortId"));
                    model.setPairingType(modelJson.containsKey("pairingType") ? modelJson.getIntValue("pairingType") : PPCommonInfo.PPInvalidValue);
                    model.setOauthAppId(modelJson.getIntValue("oauthAppId"));
                    model.setId(modelJson.getString("id"));
                    model.setBrand(modelJson.getString("brand"));

                    if (modelJson.containsKey("dependencyDeviceTypes")) {
                        JSONArray dependencies = modelJson.getJSONArray("dependencyDeviceTypes");
                        List<Integer> dependencyDeviceTypes = new ArrayList<>();
                        for (int k = 0; k != dependencies.size(); ++k) {
                            dependencyDeviceTypes.add(dependencies.getIntValue(k));
                        }
                        model.setDependencyDeviceTypes(dependencyDeviceTypes);
                        if (dependencyDeviceType != PPCommonInfo.PPInvalidValue) {
                            //There could be multiple models and dependency types
                            //Add device list item itself should not be disabled by setEnable for other model and dependency types (Even if there is a model we need to show.)
                            if (!enabled) {
                                category.setEnable(null != dependencies && dependencies.contains(dependencyDeviceType));
                            }
                            enabled = null != dependencies && dependencies.contains(dependencyDeviceType);
                        } else {
                            category.setEnable(true);
                        }
                    }
                    if (modelJson.containsKey("media")) {
                        JSONArray mediaArray = modelJson.getJSONArray("media");
                        List<Medium> mediums = new ArrayList<>();
                        for (int k = 0; k != mediaArray.size(); ++k) {
                            JSONObject mediaJson = mediaArray.getJSONObject(k);
                            Medium medium = new Medium();
                            medium.setUrl(mediaJson.getString("url"));
                            mediums.add(medium);
                        }
                        model.setMedia(mediums);
                    }
                    if (modelJson.containsKey("desc")) {
                        Desc desc = new Desc();
                        desc.setEn(modelJson.getJSONObject("desc").getString("en"));
                        model.setDesc(desc);
                    }
                    if (modelJson.containsKey("manufacturer")) {
                        Manufacturer manufacturer = new Manufacturer();
                        manufacturer.setEn(modelJson.getJSONObject("manufacturer").getString("en"));
                        model.setManufacturer(manufacturer);
                    }
                    if (modelJson.containsKey("name")) {
                        Name name = new Name();
                        name.setEn(modelJson.getJSONObject("name").getString("en"));
                        model.setName(name);
                    }
                    if (modelJson.containsKey("lookupParams")) {
                        List<LookupParam> params = new ArrayList<>();
                        JSONArray paramArray = modelJson.getJSONArray("lookupParams");
                        for (int k = 0; k != paramArray.size(); ++k) {
                            JSONObject paramJson = paramArray.getJSONObject(k);
                            LookupParam param = new LookupParam();
                            deviceType = paramJson.getIntValue("deviceType");
                            param.setDeviceType(deviceType);
                            JSONArray paramInnerArray = paramJson.getJSONArray("params");
                            if (null != paramInnerArray) {
                                List<Param> pas = new ArrayList<>();
                                for (int l = 0; l != paramInnerArray.size(); ++l) {
                                    JSONObject paramInnerJson = paramInnerArray.getJSONObject(l);
                                    Param p = new Param();
                                    p.setName(paramInnerJson.getString("name"));
                                    p.setValue(paramInnerJson.getString("value"));
                                    pas.add(p);
                                }
                                param.setParams(pas);
                            }
                            params.add(param);
                        }
                        model.setLookupParams(params);
                    }
                    if (!category.isEnable() && (deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY ||
                        deviceType == PPCommonInfo.INT_GREEN_GATEWAY ||
                        deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101 ||
                        deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211 ||
                        deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221)) {
                        category.setEnable(true);
                    }

                    if (modelJson.containsKey("displayInfo")) {
                        JSONObject displayJson = modelJson.getJSONObject("displayInfo");
                        DisplayInfo displayInfo = new DisplayInfo();
                        displayInfo.setControllable(displayJson.getBooleanValue("controllable"));
                        if (displayJson.containsKey("locationSpaces")) {
                            List<PPLocationSpaceModel> locationSpaces = new ArrayList<>();
                            JSONArray spaceArray = displayJson.getJSONArray("locationSpaces");
                            for (int k = 0; k != spaceArray.size(); ++k) {
                                JSONObject spaceObj = spaceArray.getJSONObject(k);
                                locationSpaces.add(new PPLocationSpaceModel(spaceObj.getIntValue("type"),
                                    spaceObj.getString("name")));
                            }
                            displayInfo.setLocationSpaces(locationSpaces);
                        }
                        if (displayJson.containsKey("appStoreUrl")) {
                            JSONObject storeObj = displayJson.getJSONObject("appStoreUrl");
                            displayInfo.setAppStoreUrl(storeObj.getString("Android"));
                        }

                        if (displayJson.containsKey("tests")) {
                            List<DisplayInfoTests> displayTests = new ArrayList<>();
                            JSONArray testsArray = displayJson.getJSONArray("tests");
                            for (int l = 0; l != testsArray.size(); l++) {
                                JSONObject testObj = testsArray.getJSONObject(l);
                                DisplayInfoTests testModel = new DisplayInfoTests();
                                DisplayInfoTestsName testName = new DisplayInfoTestsName();
                                DisplayInfoTestsDescription testsDescription = new DisplayInfoTestsDescription();
                                testName.setMlName(testObj.getJSONObject("mlName").getString("en"));
                                testsDescription.setMlDescription(testObj.getJSONObject("mlDescription").getString("en"));
                                testModel.setMlName(testName);
                                testModel.setMlDescription(testsDescription);
                                testModel.setParameter(testObj.getString("parameter"));
                                displayTests.add(testModel);
                            }
                            displayInfo.setDisplayInfoTests(displayTests);
                        }
                        if (displayJson.containsKey("displayDetails")) {
                            displayInfo.setDisplayDetailsFlag(true);
                            displayInfo.setDisplayDetails(displayJson.getBooleanValue("displayDetails"));
                        }
                        if (displayJson.containsKey("customRules")) {
                            displayInfo.setCustomRuleFlag(true);
                            displayInfo.setCustomRules(displayJson.getBooleanValue("customRules"));
                        }
                        if (displayJson.containsKey("parameters")) {
                            List<DisplayInfoParameters> displayParameters = new ArrayList<>();
                            JSONArray parametersArray = displayJson.getJSONArray("parameters");
                            for (int m = 0; m != parametersArray.size(); m++) {
                                JSONObject parameter = parametersArray.getJSONObject(m);
                                DisplayInfoParameters parameterModel = new DisplayInfoParameters();

                                parameterModel.setName(parameter.getString("name"));
                                if (parameter.containsKey("options")) {
                                    List<DisplayInfoOption> optionsList = new ArrayList<>();
                                    JSONArray optionsArray = parameter.getJSONArray("options");
                                    for (int n = 0; n != optionsArray.size(); n++) {
                                        JSONObject optionObj = optionsArray.getJSONObject(n);
                                        DisplayInfoOption option = new DisplayInfoOption();
                                        DisplayInfoOptionName optionName = new DisplayInfoOptionName();
                                        optionName.setMlName(optionObj.getJSONObject("mlName").getString("en"));
                                        option.setMlName(optionName);
                                        option.setId(optionObj.getInteger("id"));
                                        option.setValue(optionObj.getString("value"));
                                        optionsList.add(option);
                                    }
                                    parameterModel.setDisplayOptionList(optionsList);
                                }
                                displayParameters.add(parameterModel);
                            }
                            displayInfo.setDisplayInfoParameters(displayParameters);
                        }
                        if (displayJson.containsKey("deviceListBindings")) {
                            List<DisplayInfoDeviceListBindings> displayInfoDeviceListBindings = new ArrayList<>();
                            JSONArray deviceListBindingsArray = displayJson.getJSONArray("deviceListBindings");
                            for (int n = 0; n != deviceListBindingsArray.size(); n++) {
                                JSONObject bindings = deviceListBindingsArray.getJSONObject(n);
                                DisplayInfoDeviceListBindings bindingModel = new DisplayInfoDeviceListBindings();
                                bindingModel.setName(bindings.containsKey("name") ? bindings.getString("name") : null);
                                bindingModel.setDisplayType(bindings.containsKey("displayType") ? bindings.getInteger("displayType") : 0);
                                bindingModel.setPosition(bindings.containsKey("position") ? bindings.getInteger("position") : 0);
                                displayInfoDeviceListBindings.add(bindingModel);
                            }
                            displayInfo.setDisplayInfoDeviceListBindings(displayInfoDeviceListBindings);
                        }
                        if (displayJson.containsKey("deviceBundle")) {
                            JSONObject bundleObj = displayJson.getJSONObject("deviceBundle");
                            DeviceBundle bundle = new DeviceBundle();
                            if (bundleObj.containsKey(PPAppCenter.BRAND_NAME)) {
                                JSONObject brandObj = bundleObj.getJSONObject(PPAppCenter.BRAND_NAME);
                                if (brandObj.containsKey("models")) {
                                    JSONArray modelArray = brandObj.getJSONArray("models");
                                    for (int k = 0; k != modelArray.size(); ++k) {
                                        JSONObject modelObj = modelArray.getJSONObject(k);
                                        int count = modelObj.getIntValue("count");
                                        List<Integer> indexes = new ArrayList<>();
                                        if (modelObj.containsKey("indexes") && count > 0) {
                                            JSONArray indexArray = modelObj.getJSONArray("indexes");
                                            for (int m = 0; m != indexArray.size(); ++m) {
                                                indexes.add(indexArray.getIntValue(m));
                                            }
                                        }
                                        List<String> altIds = new ArrayList<>();
                                        if (modelObj.containsKey("altModelIds")) {
                                            JSONArray modelIdArray = modelObj.getJSONArray("altModelIds");
                                            for (int m = 0; m != modelIdArray.size(); ++m) {
                                                altIds.add(modelIdArray.getString(m));
                                            }
                                        } else if (modelObj.containsKey("altModelId")) {
                                            altIds.add(modelObj.getString("altModelId"));
                                        }
                                        Model brandModel = new Model();
                                        brandModel.setCompressed(modelObj.getBooleanValue("compressed"));
                                        brandModel.setCount(count);
                                        brandModel.setIcon(null);
                                        brandModel.setId(modelObj.getString("modelId"));
                                        brandModel.setIndexes(indexes);
                                        brandModel.setAltIds(altIds);
                                        bundle.models.add(brandModel);
                                    }
                                }
                                if (brandObj.containsKey("iconIndexes")) {
                                    bundle.iconIndexes = new ArrayList<>();
                                    JSONArray iconArray = brandObj.getJSONArray("iconIndexes");
                                    for (int k = 0; k != iconArray.size(); ++k) {
                                        bundle.iconIndexes.add(iconArray.getIntValue(k));
                                    }
                                }
                                if (brandObj.containsKey("accessories")) {
                                    JSONArray accessArray = brandObj.getJSONArray("accessories");
                                    bundle.accessories = new ArrayList<>();
                                    for (int k = 0; k != accessArray.size(); ++k) {
                                        JSONObject accessObj = accessArray.getJSONObject(k);
                                        bundle.accessories.add(accessObj.getString("modelId"));
                                    }
                                    if (!bundle.accessories.isEmpty()) {
                                        bundle.accessModel = new Model();
                                        bundle.accessModel.setCompressed(true);
                                        bundle.accessModel.setIcon(PPFontIconLabel.ICON_FA_ELLIPSIS_H);
                                        bundle.accessModel.setCount(bundle.accessories.size());
                                        bundle.models.add(bundle.accessModel);
                                    }
                                }
                                bundle.storyId = brandObj.getString("storyId");
                            }
                            displayInfo.setDeviceBundle(bundle);

                            Model bundleModel = new Model();
                            bundleModel.setDisplayInfo(displayInfo);
                            bundleModel.setMedia(model.getMedia());
                            bundleModel.setLookupParams(model.getLookupParams());
                            bundleModel.setBrand(model.getBrand());
                            bundleModel.setOauthAppId(model.getOauthAppId());
                            bundleModel.setPairingType(model.getPairingType());
                            bundleModel.setName(model.getName());
                            bundleModel.setId(model.getId());
                            bundleModel.setCount(model.getCount());
                            bundleModel.setDependencyDeviceTypes(model.getDependencyDeviceTypes());
                            bundleModel.setDesc(model.getDesc());
                            tempBundelModels.add(bundleModel);
                        }
                        model.setDisplayInfo(displayInfo);
                    }
                    models.add(model);
                }
                category.setModels(models);
            }

            allCategories.add(category);
        }

        List<PPGetDeviceCategory> sectionCategories = new ArrayList<>();
        HashMap<String, List<PPGetDeviceCategory>> deviceCategoryMaps = new HashMap<>();
        //Sort Top level categories
        Collections.sort(allCategories, new PPGetDeviceModelParser.categoryComparator());
        Collections.reverse(allCategories);
        //Confirm section headers
        for (PPGetDeviceCategory category : allCategories) {
            String parentId = category.getParentId();
            List<Model> models = category.getModels();
            if (TextUtils.isEmpty(parentId)) {
                deviceCategories.add(category);
                sectionCategories.add(category);
                if (null != models && !models.isEmpty()) {
                    List<PPGetDeviceCategory> categories = new ArrayList<>();
                    for (Model model : models) {
                        List<Integer> dependencies = model.getDependencyDeviceTypes();
                        List<Model> modeList = new ArrayList<>();
                        modeList.add(model);
                        PPGetDeviceCategory subCategory = new PPGetDeviceCategory();
                        subCategory.setHidden(category.getHidden());
                        if (dependencyDeviceType != PPCommonInfo.PPInvalidValue) {
                            subCategory.setEnable(null != dependencies && dependencies.contains(dependencyDeviceType));
                        } else {
                            subCategory.setEnable(true);
                        }
                        subCategory.setIcon(category.getIcon());
                        subCategory.setName(model.getName());
                        subCategory.setParentId(category.getId());
                        subCategory.setSortId(model.getSortId());
                        subCategory.setModels(modeList);
                        categories.add(subCategory);
                    }
                    deviceCategoryMaps.put(category.getId(), categories);
                }
            } else {
                if (null == models || parentId.equals(P360_ID)) {
                    continue;
                }

                List<PPGetDeviceCategory> categories = null;
                if (!deviceCategoryMaps.containsKey(parentId)) {
                    categories = new ArrayList<>();
                    deviceCategoryMaps.put(parentId, categories);
                } else {
                    categories = deviceCategoryMaps.get(parentId);
                }
                //Check dependency..
                PPDeviceTypeModel typeModel = new PPDeviceTypeModel(PPAppCenter.m_Context);
                boolean gwDependency = false;
                if (dependency) {
                    for (Model model : models) {
                        if (model.getDependencyDeviceTypes() != null && !model.getDependencyDeviceTypes().isEmpty()) {
                            for (int i : model.getDependencyDeviceTypes()) {
                                if (typeModel.isGateway(i)) {
                                    gwDependency = true;
                                }
                            }
                        }
                        if (gwDependency) {
                            categories.add(category);
                            break;
                        }
                    }
                } else {
                    categories.add(category);
                }
            }
        }

        for (int i = sectionCategories.size() - 1; i != -1; --i) {
            String id = sectionCategories.get(i).getId();
            if (deviceCategoryMaps.containsKey(id)) {
                if (i + 1 >= sectionCategories.size()) {
                    deviceCategories.addAll(deviceCategoryMaps.get(id));
                } else {
                    deviceCategories.addAll(i + 1, deviceCategoryMaps.get(id));
                }
            }
        }
        for (Model tempBundleModel : tempBundelModels) {
            for (Model bundeModel : bundleModels) {
                if (bundeModel.equals(tempBundleModel)) {
                    tempBundleModel.setBundlePageIndex(bundeModel.getBundlePageIndex());
                }
            }
        }
        bundleModels.clear();
        bundleModels.addAll(tempBundelModels);
        return true;
    }

    //Sort Top level categories
    private class categoryComparator implements Comparator<PPGetDeviceCategory> {

        @Override
        public int compare(PPGetDeviceCategory lhs, PPGetDeviceCategory rhs) {
            return rhs.getSortId() - lhs.getSortId();
        }
    }
}
