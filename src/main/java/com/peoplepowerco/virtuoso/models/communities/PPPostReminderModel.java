package com.peoplepowerco.virtuoso.models.communities;

import io.realm.RealmObject;

public class PPPostReminderModel extends RealmObject {

    public String notificationText;
    public long notificationInterval;
    public String notificationDate;

    public PPPostReminderModel copy() {
        PPPostReminderModel reminderModel = new PPPostReminderModel();
        reminderModel.notificationText = notificationText;
        reminderModel.notificationInterval = notificationInterval;
        reminderModel.notificationDate = notificationDate;
        return reminderModel;
    }
}
