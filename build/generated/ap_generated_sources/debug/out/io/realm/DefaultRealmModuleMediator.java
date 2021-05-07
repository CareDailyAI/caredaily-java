package io.realm;


import android.util.JsonReader;
import io.realm.ImportFlag;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>(27);
        modelClasses.add(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
        modelClasses.add(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
        modelClasses.add(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Map<Class<? extends RealmModel>, OsObjectSchemaInfo> getExpectedObjectSchemaInfoMap() {
        Map<Class<? extends RealmModel>, OsObjectSchemaInfo> infoMap = new HashMap<Class<? extends RealmModel>, OsObjectSchemaInfo>(27);
        infoMap.put(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class, io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class, io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class, io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class, io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class, io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class, io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class, io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class, io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class, io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class, io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.getExpectedObjectSchemaInfo());
        infoMap.put(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class, io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.getExpectedObjectSchemaInfo());
        return infoMap;
    }

    @Override
    public ColumnInfo createColumnInfo(Class<? extends RealmModel> clazz, OsSchemaInfo schemaInfo) {
        checkClass(clazz);

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            return io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            return io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.createColumnInfo(schemaInfo);
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            return io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.createColumnInfo(schemaInfo);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getSimpleClassNameImpl(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            return "CRSimpleQuestionItem";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            return "CRSwitchDevice";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            return "PPCardServiceModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            return "PPPostReactionModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            return "PPPostLocationModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            return "PPPostCommentModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            return "PPPostUserModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            return "PPPostModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            return "PPPostTimezoneModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            return "PPPostFileModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            return "PPPostReminderModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            return "PPPostAddressModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            return "PPSurveyQuestionModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            return "PPLocationServicePlanModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            return "PPUserInformationLocationModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            return "PPUserInformationLocationStateModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            return "PPUserInformationUserAuthClientModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            return "PPUserInformationCommunityModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            return "PPUserInformationLocationTimezoneModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            return "PPUserInformationLocationCountryModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            return "PPUserInformationLocationOrgModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            return "PPUserCommunityModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            return "PPUserInformationServiceModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            return "BundleModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            return "DeviceBundle";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            return "PPUserInfoModel";
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            return "PPDeviceGoalsModel";
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy());
            }
            if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
                return clazz.cast(new io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.CRSimpleQuestionItemColumnInfo columnInfo = (com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.CRSimpleQuestionItemColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.CRSwitchDeviceColumnInfo columnInfo = (com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.CRSwitchDeviceColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.PPCardServiceModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.PPCardServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.PPCardServiceModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.PPPostReactionModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.PPPostReactionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.PPPostLocationModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.PPPostLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.PPPostCommentModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.PPPostCommentModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.PPPostUserModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.PPPostUserModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.PPPostModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.PPPostModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.PPPostTimezoneModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.PPPostTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.PPPostFileModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.PPPostFileModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.PPPostReminderModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.PPPostReminderModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.PPPostAddressModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.PPPostAddressModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.PPSurveyQuestionModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.PPSurveyQuestionModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.PPLocationServicePlanModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.PPLocationServicePlanModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.PPUserInformationLocationModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.PPUserInformationLocationModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.PPUserInformationLocationStateModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.PPUserInformationLocationStateModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.PPUserInformationUserAuthClientModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.PPUserInformationUserAuthClientModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.PPUserInformationCommunityModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.PPUserInformationCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.PPUserInformationLocationTimezoneModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.PPUserInformationLocationTimezoneModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.PPUserInformationLocationCountryModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.PPUserInformationLocationCountryModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.PPUserInformationLocationOrgModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.PPUserInformationLocationOrgModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.PPUserCommunityModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.PPUserCommunityModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.PPUserInformationServiceModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.PPUserInformationServiceModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.BundleModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.BundleModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.DeviceBundleColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.DeviceBundleColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.PPUserInfoModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.PPUserInfoModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.PPUserInfoModel) obj, update, cache, flags));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.PPDeviceGoalsModelColumnInfo columnInfo = (com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.PPDeviceGoalsModelColumnInfo) realm.getSchema().getColumnInfo(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class);
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.copyOrUpdate(realm, columnInfo, (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) obj, update, cache, flags));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPCardServiceModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPUserInfoModel) object, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
                io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
                io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPCardServiceModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPUserInfoModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insert(realm, (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
                    io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
                    io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPCardServiceModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPUserInfoModel) obj, cache);
        } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
                io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
                io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.bean.CRSwitchDevice) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPCardServiceModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPUserInfoModel) object, cache);
            } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
                io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insertOrUpdate(realm, (com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
                    io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
                    io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
                    io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSimpleQuestionItemRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.bean.CRSimpleQuestionItem) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.bean.CRSwitchDevice.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_bean_CRSwitchDeviceRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.bean.CRSwitchDevice) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPCardServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPCardServiceModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.PPCardServiceModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReactionModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostLocationModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostCommentModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostUserModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostUserModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostUserModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostTimezoneModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostFileModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostFileModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostFileModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostReminderModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_communities_PPPostAddressModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPSurveyQuestionModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.PPSurveyQuestionModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPLocationServicePlanModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationStateModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationUserAuthClientModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationCommunityModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationTimezoneModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationCountryModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationLocationOrgModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserCommunityModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_userinformations_PPUserInformationServiceModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_BundleModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.deviceBundle.BundleModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_deviceBundle_DeviceBundleRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.deviceBundle.DeviceBundle) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPUserInfoModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPUserInfoModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.PPUserInfoModel) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel.class)) {
            return clazz.cast(io.realm.com_peoplepowerco_virtuoso_models_PPDeviceGoalsModelRealmProxy.createDetachedCopy((com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
