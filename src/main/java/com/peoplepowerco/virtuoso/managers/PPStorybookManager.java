package com.peoplepowerco.virtuoso.managers;

import static com.peoplepowerco.virtuoso.PPCommonInfo.INT_DEVICETYPE_DEVICEMODEL_HIDDEN_NONE;
import static com.peoplepowerco.virtuoso.PPCommonInfo.STORY_TYPE_NONE;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfo;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoDeviceListBindings;
import com.peoplepowerco.virtuoso.models.storybook.DisplayInfoSub.DisplayInfoParameters;
import com.peoplepowerco.virtuoso.models.storybook.LookupParam;
import com.peoplepowerco.virtuoso.models.storybook.Model;
import com.peoplepowerco.virtuoso.models.storybook.PPGetDeviceCategory;
import com.peoplepowerco.virtuoso.models.storybook.PPGetStoryModel;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import com.peoplepowerco.virtuoso.models.storybook.Page;
import com.peoplepowerco.virtuoso.models.storybook.Story;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by edwardliu on 2018/6/20.
 */

public class PPStorybookManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static PPStorybookManager instance = null;

    private PPGetStoryModel m_StoriesModel;
    private List<PPGetDeviceCategory> m_DeviceCategories;
    private PPLocationSpaceModel m_UpdateSpace;
    private Model m_BundleModel;
    private List<Model> m_BundleModels;

    /**
     * Hidden class constructor.
     */
    private PPStorybookManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPStorybookManager getInstance() {
        synchronized (PPStorybookManager.class) {
            if (instance == null) {
                instance = new PPStorybookManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_StoriesModel = new PPGetStoryModel();
        m_DeviceCategories = new ArrayList<>();
        m_BundleModels = new ArrayList<>();
    }

    public List<PPGetDeviceCategory> getPrimaryDeviceCategories() {
        return m_DeviceCategories;
    }

    public List<Story> getFAQDisplayStories() {
        List<Story> faqStories = new ArrayList<>();
        if (null == m_StoriesModel.getStories()) {
            return faqStories;
        }
        for (Story story : m_StoriesModel.getStories()) {
            if (story.getStoryType() == PPCommonInfo.STORY_TYPE_FAQ
                && (null == story.getModels() || story.getModels().isEmpty())) {
                faqStories.add(story);
            }
        }
        return faqStories;
    }

    public List<Story> getFAQStories() {
        List<Story> faqStories = new ArrayList<>();
        if (null == m_StoriesModel.getStories()) {
            return faqStories;
        }
        for (Story story : m_StoriesModel.getStories()) {
            if (story.getStoryType() == PPCommonInfo.STORY_TYPE_FAQ) {
                faqStories.add(story);
            }
        }
        return faqStories;
    }

    public Story getDeviceFAQStory(String modelId) {
        if (null == m_StoriesModel.getStories()) {
            return null;
        }
        for (Story story : m_StoriesModel.getStories()) {
            if (story.getStoryType() == PPCommonInfo.STORY_TYPE_FAQ
                && null != story.getModels()
                && !story.getModels().isEmpty()) {
                for (Model model : story.getModels()) {
                    if (model.getId().equals(modelId)) {
                        return story;
                    }
                }
            }
        }
        return null;
    }

    public Story getStoryById(String storyId) {
        List<Story> stories = m_StoriesModel.getStories();
        if (null != stories) {
            for (Story story : stories) {
                if (null != story.getId() && story.getId().equals(storyId)) {
                    return story;
                }
            }
        }
        return null;
    }

    public Story getStoryByType(int storyType) {
        List<Story> stories = m_StoriesModel.getStories();
        if (null != stories) {
            for (Story story : stories) {
                if (story.getStoryType() == storyType) {
                    return story;
                }
            }
        }
        return null;
    }

    public Story getStoryByModelIdAndStoryType(String modelId, int storyType) {
        if (null == modelId) {
            return null;
        }
        List<Story> stories = m_StoriesModel.getStories();
        if (null != stories) {
            for (Story story : stories) {
                List<Model> models = story.getModels();
                if (null == models) {
                    continue;
                }
                for (Model model : models) {
                    if (model.getId().equals(modelId) && story.getStoryType() == storyType) {
                        return story;
                    }
                }
            }
        }
        return null;
    }

    public PPGetStoryModel getStoryModel() {
        return m_StoriesModel;
    }

    public void setStoryModel(PPGetStoryModel storyModel) {
        m_StoriesModel = storyModel;
    }

    public List<Story> getStories() {
        return m_StoriesModel.getStories();
    }

    public int getUpdatedLocationSpaceId(List<PPLocationSpaceModel> locationSpaceModels) {
        boolean found = false;
        for (PPLocationSpaceModel existingSpace : locationSpaceModels) {
            if (existingSpace.getId() == m_UpdateSpace.getId()) {
                found = true;
                existingSpace.setType(m_UpdateSpace.getType());
                existingSpace.setName(m_UpdateSpace.getName());
                break;
            }
        }
        if (!found) {
            locationSpaceModels.add(m_UpdateSpace);
        }
        return m_UpdateSpace.getId();
    }

    public void serverRequestGetDeviceModelByType(String tag, String brand, Model model, int deviceType) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("brand", brand);
            jsonObj.put("visitDatabase", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(IPPVirtuosoTypes.REQ_GET_DEVICE_MODEL_BY_DEVICETYPE, jsonObj, new Object[]{model, deviceType, false});
    }

    public void serverRequestGetDeviceModels(String tag, String brand, int hidden, String search, boolean dependency) {
        JSONObject jsonObj = new JSONObject();
        String language = Locale.getDefault().getLanguage();
        try {
            jsonObj.put("TAG", tag);
            if (null != brand) {
                jsonObj.put("brand", brand);
            }
            if (INT_DEVICETYPE_DEVICEMODEL_HIDDEN_NONE != hidden) {
                jsonObj.put("hidden", hidden);
            }
            if (null != search) {
                jsonObj.put("searchBy", search);
            }
            if (null != language) {
                jsonObj.put("lang", language);
            }
            jsonObj.put("visitDatabase", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_MODELS, jsonObj, new Object[]{m_DeviceCategories, m_BundleModels, dependency});
    }

    public void serverRequestGetDeviceModels(String tag, String brand, int hidden, String search, int dependencyType) {
        JSONObject jsonObj = new JSONObject();
        String language = Locale.getDefault().getLanguage();
        try {
            jsonObj.put("TAG", tag);
            if (null != brand) {
                jsonObj.put("brand", brand);
            }
            if (INT_DEVICETYPE_DEVICEMODEL_HIDDEN_NONE != hidden) {
                jsonObj.put("hidden", hidden);
            }
            if (null != search) {
                jsonObj.put("searchBy", search);
            }
            if (null != language) {
                jsonObj.put("lang", language);
            }
            jsonObj.put("visitDatabase", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_MODELS, jsonObj, new Object[]{m_DeviceCategories, m_BundleModels, false, dependencyType});
    }

    public void serverRequestGetStories(String tag, String storyId, String modelId, int storyType,
        String brand, int hidden, String search, boolean visitDatabase) {
        JSONObject jsonObj = new JSONObject();
        String language = Locale.getDefault().getLanguage();
        try {
            jsonObj.put("TAG", tag);
            if (null != storyId) {
                jsonObj.put("storyId", storyId);
            }
            if (null != modelId) {
                jsonObj.put("modelId", modelId);
            }
            if (null != brand) {
                jsonObj.put("brand", brand);
            }
            if (STORY_TYPE_NONE != storyType) {
                jsonObj.put("storyType", storyType);
            }
            if (null != language) {
                jsonObj.put("lang", language);
            }
            if (INT_DEVICETYPE_DEVICEMODEL_HIDDEN_NONE != hidden) {
                jsonObj.put("hidden", hidden == 1 ?  "true" : "false");
            }
            if (null != search) {
                jsonObj.put("searchBy", search);
            }
            jsonObj.put("visitDatabase", visitDatabase);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_STORIES, jsonObj, m_StoriesModel);
    }

    public void serverRequestGetLocationSpaces(String tag, int locationId, List<PPLocationSpaceModel> locationSpaceModels) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", locationId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_LOCATION_SPACES, jsonObj, locationSpaceModels);
    }

    public void serverRequestLinkDeviceSpace(int locationId, String deviceId, int spaceId, String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", locationId);
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("spaceId", spaceId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_LINK_DEVICE_SPACE, jsonObj);
    }

    public void serverRequestUnlinkDeviceSpace(int locationId, String deviceId, int spaceId, String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", locationId);
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("spaceId", spaceId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_UNLINK_DEVICE_SPACE, jsonObj);
    }

    public void serverRequestUpdateLocationSpace(int locationId, PPLocationSpaceModel updateSpace, String tag) {
        m_UpdateSpace = updateSpace;
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", locationId);
            if (updateSpace.getId() != -1) {
                jsonObj.put("spaceId", updateSpace.getId());
            }
            jsonObj.put("TAG", tag);
            jsonObj.put("data", updateSpace.getJsonStr());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_UPDATE_LOCATION_SPACE, jsonObj, new Object[]{m_UpdateSpace});
    }

    public void serverRequestDeleteLocationSpace(int locationId, int spaceId, String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", locationId);
            jsonObj.put("spaceId", spaceId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_LOCATION_SPACE, jsonObj);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    public String getModelIdByDeviceType(int deviceType) {
        for (PPGetDeviceCategory deviceCategories : m_DeviceCategories) {
            List<Model> models = deviceCategories.getModels();
            if (models != null && !models.isEmpty()) {
                Model model = models.get(0);
                if (model.getLookupParams() != null) {
                    for (LookupParam param : model.getLookupParams()) {
                        if (param.getDeviceType() == deviceType) {
                            return model.getId();
                        }
                    }
                }
            }
        }
        return null;
    }

    public Model getModelByModelId(String modelId) {
        for (PPGetDeviceCategory deviceCategories : m_DeviceCategories) {
            List<Model> models = deviceCategories.getModels();
            if (null == models || models.isEmpty()) {
                continue;
            }
            for (Model model : models) {
                if (model.getId().equals(modelId)) {
                    return model;
                }
            }
        }
        return null;
    }

    public String getMediaUrlByModelId(String modelId){
        Model model = getModelByModelId(modelId);
        if(model!=null) {
            if (model.getMedia() != null && !model.getMedia().isEmpty()) {
                String Url = model.getMedia().get(0).getUrl();
                return Url;
            }
        }
        return null;
    }

    public void setDeviceBundleModel(String modelId) {
        if (null != m_BundleModels && !m_BundleModels.isEmpty()) {
            for (Model bundleModel : m_BundleModels) {
                if (bundleModel.getId().equals(modelId)) {
                    PPAppCenter.m_SharedPresence.setKeyStringValue("CRCurrentModelId", modelId);
                    m_BundleModel = bundleModel;
                    break;
                }
            }
        }
    }

    public List<Model> getDeviceBundleModels() {
        return m_BundleModels;
    }

    public void setDeviceBundleModels(List<Model> bundleModels) {
        m_BundleModels.clear();
        m_BundleModels.addAll(bundleModels);
    }

    public Model getDeviceBundleModel() {
        Model savedModel = restoreCurrentModel();
        if (null != savedModel && (null == m_BundleModel
            || m_BundleModel.getBundlePageIndex() < savedModel.getBundlePageIndex())) {
            m_BundleModel = savedModel;
        }
        return m_BundleModel;
    }

    public Page getDeviceBundlePage() {
        getDeviceBundleModel();
        if (null != m_BundleModel && null != m_BundleModel.getDisplayInfo()) {
            Story story = getStoryById(m_BundleModel.getDisplayInfo().getDeviceBundle().storyId);
            if (story != null) {
                int pageIndex = m_BundleModel.getBundlePageIndex();
                List<Page> pages = story.getPages();
                if (null != pages && !pages.isEmpty()) {
                    if (m_BundleModel.getBundlePageSize() != pages.size()) {
                        m_BundleModel.setBundlePageSize(pages.size());
                    }
                    if (pageIndex < pages.size()) {
                        return pages.get(pageIndex);
                    }
                }
            }
        }
        return null;
    }

    public Page getDeviceBundlePage(String storyId, int bundlePageIndex) {
        Story story = getStoryById(storyId);
        if (story != null) {
            List<Page> pages = story.getPages();
            if (null != pages && !pages.isEmpty()) {
                if (bundlePageIndex < pages.size()) {
                    return pages.get(bundlePageIndex);
                }
            }
        }
        return null;
    }

    public void setDeviceBundlePageIndex(int index) {
        if (m_BundleModel != null) {
            m_BundleModel.setBundlePageIndex(index);
        }
    }

    public boolean isInLastBundlePage() {
        return m_BundleModel.isLastBundlePage();
    }

    public void increaseBundleIndex() {
        m_BundleModel.increaseBundleIndex();
    }

    public DisplayInfo getDisplayInfoByType(int deviceType) {
        for (PPGetDeviceCategory deviceCategories : m_DeviceCategories) {
            List<Model> models = deviceCategories.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getLookupParams() != null) {
                        for (LookupParam param : model.getLookupParams()) {
                            if (param.getDeviceType() == deviceType) {
                                return model.getDisplayInfo();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean hideRule(String id) {
        for (PPGetDeviceCategory deviceCategories : m_DeviceCategories) {
            List<Model> models = deviceCategories.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(model.getId())) {
                        if (id.equals(model.getId())) {
                            if (model.getDisplayInfo().isCustomRuleFlag()
                                && !model.getDisplayInfo().isCustomRules()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getIconByDeviceType(int deviceType) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getLookupParams() != null) {
                        for (LookupParam param : model.getLookupParams()) {
                            if (param.getDeviceType() == deviceType) {
                                return deviceCategory.getIcon();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<DisplayInfoParameters> getSupportedParametersByDeviceType(int deviceType) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getLookupParams() != null) {
                        for (LookupParam param : model.getLookupParams()) {
                            if (param.getDeviceType() == deviceType
                                && model.getDisplayInfo() != null) {
                                return model.getDisplayInfo().getDisplayInfoParameters();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public List<DisplayInfoParameters> getSupportedParametersByModelId(String modelId) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getDisplayInfo() != null && model.getId().equals(modelId)) {
                        return model.getDisplayInfo().getDisplayInfoParameters();
                    }
                }
            }
        }
        return null;
    }

    public List<DisplayInfoParameters> getParameterByContainModelId(String modelId) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getDisplayInfo() != null && model.getId().toLowerCase().contains(modelId.toLowerCase())) {
                        return model.getDisplayInfo().getDisplayInfoParameters();
                    }
                }
            }
        }
        return null;
    }

    public List<DisplayInfoDeviceListBindings> getDeviceListBindingParameter(int deviceType) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getLookupParams() != null) {
                        for (LookupParam param : model.getLookupParams()) {
                            if (param.getDeviceType() == deviceType
                                && model.getDisplayInfo() != null) {
                                return model.getDisplayInfo().getDisplayInfoDeviceListBindings();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getDeviceMediaURL(int deviceType) {
        for (PPGetDeviceCategory deviceCategory : m_DeviceCategories) {
            List<Model> models = deviceCategory.getModels();
            if (models != null && !models.isEmpty()) {
                for (Model model : models) {
                    if (model != null && model.getLookupParams() != null) {
                        for (LookupParam param : model.getLookupParams()) {
                            if (param.getDeviceType() == deviceType
                                && model.getMedia() != null) {
                                return model.getMedia().get(0).getUrl();
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private Model restoreCurrentModel() {
        Model currentModel = null;
        String currentModelId = PPAppCenter.m_SharedPresence.getKeyStringValue("CRCurrentModelId");
        if (TextUtils.isEmpty(currentModelId)) {
            currentModel = m_BundleModels.get(0);
        } else if (!m_BundleModels.isEmpty()) {
            for (Model bundleModel : m_BundleModels) {
                if (bundleModel.getId().equals(currentModelId)) {
                    currentModel = bundleModel;
                    break;
                }
            }
        }
        return currentModel;
    }
}
