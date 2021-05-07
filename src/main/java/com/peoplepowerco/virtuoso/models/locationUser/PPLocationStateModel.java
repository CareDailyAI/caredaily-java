package com.peoplepowerco.virtuoso.models.locationUser;

import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.models.PPLocationStateReportModel;
import java.util.ArrayList;
import java.util.List;

public class PPLocationStateModel {

    public String locationId = "";
    public int state = stateUnknown;
    public String description;
    public long timestamp_ms;
    public long next_timestamp_ms;
    public long dailyreport_ms;
    public int seconds;
    public boolean hasSocialConnector = false;
    public boolean enableUserAuthentication = false;
    public boolean enableEmergencyCallCenter = true;
    public int deviceBundleStatus = PPCommonInfo.PPInvalidValue;
    public List<PPLocationStateReportModel> reports = new ArrayList<>();

    public PPLocationStateModel() {
        this.state = stateUnknown;
    }

    public static int stateUnknown = -1;
    public static int stateDisarmed = 0;
    public static int stateExitDelayFull = 1;
    public static int stateExitDelayPerimeter = 2;
    public static int stateArmedFully = 3;
    public static int stateArmedPerimeter = 4;
    public static int stateEntryDelay = 5;
    public static int stateAlarmingRecentClosing = 6;
    public static int stateAlarming = 7;
    public static int stateTestMode = 8;
}
