package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPNotificationsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 14/06/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPNotificationJsonParser implements PPBaseJsonParser {
    private static final String TAG = PPNotificationJsonParser.class.getSimpleName();
    private List<PPNotificationsModel> notificationsModelList = null;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray notificationArray = null;
        JSONObject notificationObj = null;
        try {
            notificationArray = jso.getJSONArray("notifications");
            notificationsModelList = (ArrayList<PPNotificationsModel>) obj[0];
            if (notificationsModelList != null) {
                notificationsModelList.clear();
            }
            if (notificationArray != null) {
                int count = notificationArray.size();
                for (int i = 0; i < count; i++) {
                    if (notificationArray != null && notificationArray.size() > 0) {
                        notificationObj = notificationArray.getJSONObject(i);
                        PPNotificationsModel notificationsModel = new PPNotificationsModel();
                        notificationsModel.setSendDate(notificationObj.containsKey("sendDate") ? notificationObj.getString("dasendDatete") : null);
                        notificationsModel.setSendDateMs(notificationObj.containsKey("sendDateMs") ? notificationObj.getLong("sendDateMs") : 0L);
                        notificationsModel.setDeliveryType(notificationObj.containsKey("deliveryType") ? notificationObj.getInteger("deliveryType") : 0);
                        notificationsModel.setNotificationType(notificationObj.containsKey("notificationType") ? notificationObj.getInteger("notificationType") : 0);
                        notificationsModel.setBrand(notificationObj.containsKey("brand") ? notificationObj.getString("brand") : null);
                        notificationsModel.setTemplateName(notificationObj.containsKey("templateName") ? notificationObj.getString("templateName") : null);
                        notificationsModel.setLanguage(notificationObj.containsKey("language") ? notificationObj.getString("language") : null);
                        notificationsModel.setSound(notificationObj.containsKey("sound") ? notificationObj.getString("sound") : null);
                        notificationsModel.setBadge(notificationObj.containsKey("badge") ? notificationObj.getInteger("badge") : 0);
                        notificationsModel.setSentCound(notificationObj.containsKey("sentCount") ? notificationObj.getInteger("sentCount") : 0);
                        notificationsModel.setSourceType(notificationObj.containsKey("sourceType") ? notificationObj.getInteger("sourceType") : 0);
                        notificationsModel.setSourceId(notificationObj.containsKey("sourceId") ? notificationObj.getString("sourceId") : null);
                        notificationsModel.setMessageText(notificationObj.containsKey("messageText") ? notificationObj.getString("messageText") : null);
                        notificationsModelList.add(notificationsModel);
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}