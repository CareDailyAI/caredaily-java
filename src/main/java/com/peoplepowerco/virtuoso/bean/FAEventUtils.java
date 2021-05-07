package com.peoplepowerco.virtuoso.bean;


import com.peoplepowerco.virtuoso.models.PPCardServiceModel;
import com.peoplepowerco.virtuoso.models.PPCardStatusModel;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPTaskModel;
import com.peoplepowerco.virtuoso.models.narratives.PPNarrativeModel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by edwardliu on 2018/11/28.
 */

public class FAEventUtils {

    public static final int FAEventTypeSection = 1;
    public static final int FAEventTypeNotification = 2;
    public static final int FAEventTypeStatus = 3;
    public static final int FAEventTypeService = 4;
    public static final int FAEventTypeAttention = 5;
    public static final int FAEventTypeTask = 6;
    public static final int FAEventTypeNotificationFilter = 7;
    public static final int FAEventTypeReport = 8;
    public static final int FAEventTypeAlertService = 9;
    public static final int FAEventTypeHeader = 10;
    public static final int FAEventTypeLoadMore = 11;
    public static final int FAEventTypeSecuritySystem = 12;

    private static SimpleDateFormat sDateFormat = new SimpleDateFormat("MMM d");
    private static SimpleDateFormat sTimeFormat = new SimpleDateFormat("hh:mm a EEEE");
//    private static SimpleDateFormat fTimeFormat = new SimpleDateFormat("yyyy-mm-dd ");

    public static FAEvent createEvent(PPNarrativeModel model) {
        FAEvent event = new FAEvent();
        event.narrative = model;
        event.eventType = FAEventTypeNotification;
        event.date = sTimeFormat.format(new Date(model.narrativeDateMS));
        event.preDate = sDateFormat.format(new Date(model.narrativeDateMS));
        event.createDateMs = model.creationDateMS;
        event.narrativeDateMs = model.narrativeDateMS;
        return event;
    }

    public static FAEvent createEvent(PPCardStatusModel model) {
        FAEvent event = new FAEvent();
        event.cardStatus = model;
        event.eventType = FAEventTypeStatus;
        event.date = sTimeFormat.format(new Date(model.updatedMs));
        return event;
    }

    public static FAEvent createEvent(PPCardServiceModel model) {
        FAEvent event = new FAEvent();
        event.cardService = model;
        event.eventType = FAEventTypeService;
        event.date = sTimeFormat.format(new Date(model.updatedMs));
        return event;
    }

    public static FAEvent createEvent(PPDashboardHeaderModel model) {
        FAEvent event = new FAEvent();
        event.headerModel = model;
        event.eventType = FAEventTypeHeader;
        return event;
    }

    public static FAEvent createEvent(PPTaskModel model) {
        FAEvent event = new FAEvent();
        event.task = model;
        event.eventType = FAEventTypeTask;
        event.date = sTimeFormat.format(new Date(model.updated));
        return event;
    }

    public static FAEvent createEvent(long narrativeDateMs) {
        FAEvent event = new FAEvent();
        event.eventType = FAEventTypeSection;
        event.narrativeDateMs = narrativeDateMs;
        event.date = sDateFormat.format(new Date(narrativeDateMs));
        return event;
    }

    public static FAEvent createEvent(String sectionName) {
        FAEvent event = new FAEvent();
        event.eventType = FAEventTypeSection;
        event.date = sectionName;
        return event;
    }

    public static FAEvent createEvent(int eventType, String title, String subTitle) {
        FAEvent event = new FAEvent();
        event.eventType = eventType;
        event.title = title;
        event.subTitle = subTitle;
        return event;
    }

    public static FAEvent createEvent(PPDeviceInfoModel attentionModel) {
        FAEvent event = new FAEvent();
        event.eventType = FAEventTypeAttention;
        event.attentionModel = attentionModel;
        return event;
    }

    public static FAEvent createEvent(int eventType) {
        FAEvent event = new FAEvent();
        event.eventType = eventType;
        return event;
    }
}