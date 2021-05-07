package com.peoplepowerco.virtuoso.util;

import android.app.Activity;

import java.util.ArrayList;

/**
 * @author : James Cho
 * @brief : Manager for activities termination.
 * @date : 2016. 2. 23.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPActivityTerminateManager {

    private ArrayList<Activity> m_activityList = null;
    private static PPActivityTerminateManager instance = null;

    /**
     * Constructor that is called when activity get instance.
     */
    private PPActivityTerminateManager() {
        m_activityList = new ArrayList<Activity>();
    }

    /**
     * Initialize instance once for using activity manager,
     * when instance null then call the Constructor
     */
    public static PPActivityTerminateManager getInstance() {
        synchronized (PPActivityTerminateManager.class) {
            if (instance == null) {
                instance = new PPActivityTerminateManager();
            }
        }
        return instance;
    }

    /**
     * Release activity list.
     */
    public static void release() {
        if (instance != null) {
            instance.m_activityList.clear();
            instance.m_activityList = null;
            instance = null;
        }
    }

    /**
     * Add activity to activity list need to be finished
     */
    public void addActivity(Activity activity) {
        m_activityList.add(activity);
    }

    public void removeActivity(Activity activity) {
        if (m_activityList.contains(activity)) {
            m_activityList.remove(activity);
        }
    }

    /**
     * Finish all activities in the activity list and clear list
     */
    public void finishActivityList() {
        if (instance != null) {
            if (instance.m_activityList != null) {
                for (Activity currentActivity : instance.m_activityList) {
                    currentActivity.finish();
                }
                instance.m_activityList.clear();
            }
        }
    }
}
