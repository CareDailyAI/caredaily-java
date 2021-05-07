package com.peoplepowerco.virtuoso.bean;

import com.peoplepowerco.virtuoso.managers.PPLocationUserManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;

public class FAPeopleUtils {

    public static PPLocationUserModel createAttentionItem(String title) {
        PPLocationUserModel sectionModel = new PPLocationUserModel();
        sectionModel.setSectionType(PPLocationUserManager.LOCATION_SECTION_TYPE_ATTENTION_SECTION);
        sectionModel.setNickname(title);
        return sectionModel;
    }

    public static PPLocationUserModel createAttentionItem(PPDeviceInfoModel model) {
        PPLocationUserModel attentionUserModel = new PPLocationUserModel();
        attentionUserModel.setSectionType(PPLocationUserManager.LOCATION_SECTION_TYPE_ATTENTION);
        attentionUserModel.attentionModel = model;
        return attentionUserModel;
    }
}
