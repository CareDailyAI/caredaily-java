/**
 * @FileName : PPUtil.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.util;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.models.rules.PPRuleModel;
import com.peoplepowerco.virtuoso.models.rules.PPRuleParameterModel;
import com.peoplepowerco.virtuoso.models.rules.PPRulePhraseParameterModel;
import com.peoplepowerco.virtuoso.models.rules.PPRulePhraseValuesModel;

import java.util.ArrayList;
import java.util.List;

public class PPRulesUtil implements IPPDeviceParameters {

    private static final String TAG = PPRulesUtil.class.getSimpleName();

    public static boolean isParameterAvailable(List<PPRuleParameterModel> parameters) {
        if(parameters ==null) {
            return false;
        } else {
            if(parameters.size() == 0) {
                return false;
            }
        }
        return true;
    }

    public static String getDeviceIdParameter(List<PPRuleParameterModel> parameters) {
        if(parameters == null) {
            return "";
        }
        for(PPRuleParameterModel parameter : parameters){
            if(parameter.getCategory() == PPCommonInfo.RULES_PARAMETER_CATEGORY_DEVICEID) {
                return parameter.getValue();
            }
        }
        return "";
    }

    public static String getDeviceNameInPhraseValues(List<PPRulePhraseParameterModel> parameters, String deviceId) {
        if(parameters == null) {
            return "";
        }
        for(PPRulePhraseParameterModel parameter : parameters){
            if (parameter.getCategory() == PPCommonInfo.RULES_PARAMETER_CATEGORY_DEVICEID) {
                List<PPRulePhraseValuesModel> values = parameter.getValues();
                if(values != null && values.size() > 0) {
                    for(PPRulePhraseValuesModel value :values) {
                        if(value.getId().equals(deviceId)) {
                            return value.getName();
                        }
                    }
                }
            }

        }
        return "";
    }

    public static String getScheduleTriggerDescription(PPRuleModel ruleModel, int days){
        StringBuilder triggerDesc = new StringBuilder();

        int weekend = PPBusinessLogicParameterDOWSaturday | PPBusinessLogicParameterDOWSunday;
        int weekdays = PPBusinessLogicParameterDOWMonday
                | PPBusinessLogicParameterDOWTuesday
                | PPBusinessLogicParameterDOWWednesday
                | PPBusinessLogicParameterDOWThursday
                | PPBusinessLogicParameterDOWFriday;
        int everyday = weekend | weekdays;
        String daysOfWeek[] = new String[7];
        int i = 0;
        for(PPRuleParameterModel paramModel: ruleModel.getTrigger().getParameters()){
            if(!PPUtil.isEmpty(paramModel.getName())){
                if(paramModel.getName().equals("schedule")){
                    if(!PPUtil.isEmpty(paramModel.getValue())) {
                        String values1[] = paramModel.getValue().split(" ");
                        String mins = values1[1];
                        String hours = values1[2];
                        String time = getTimeString(hours, mins);
                        triggerDesc.append(time);
                    }
                }
            }
        }
        if((days & PPBusinessLogicParameterDOWNone) == PPBusinessLogicParameterDOWNone) {
            triggerDesc.append("");
        }
        if(days == weekend) {
            triggerDesc.append(PPAppCenter.m_Context.getString(R.string.on_weekend));
        }
        else if(days  == weekdays) {
            triggerDesc.append(PPAppCenter.m_Context.getString(R.string.on_weekdays));
        }
        else if(days == everyday) {
            triggerDesc.append(PPAppCenter.m_Context.getString(R.string.everyday));
        } else{
            if((days & PPBusinessLogicParameterDOWSunday) == PPBusinessLogicParameterDOWSunday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.sun);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWMonday) == PPBusinessLogicParameterDOWMonday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.mon);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWTuesday) == PPBusinessLogicParameterDOWTuesday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.tue);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWWednesday) == PPBusinessLogicParameterDOWWednesday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.wed);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWThursday) == PPBusinessLogicParameterDOWThursday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.thu);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWFriday) == PPBusinessLogicParameterDOWFriday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.fri);
                i ++;
            }
            if((days & PPBusinessLogicParameterDOWSaturday) == PPBusinessLogicParameterDOWSaturday) {
                daysOfWeek[i] = PPAppCenter.m_Context.getString(R.string.sat);
                i ++;
            }

            for (int j = 0; j < daysOfWeek.length; j++) {
                if (daysOfWeek[j] != null) {
                    if (j > 0) {
                        triggerDesc.append(" " + "&");
                    }
                    triggerDesc.append(" " + daysOfWeek[j]);
                }
            }
        }




        PPVirtuosoLogTrace.d(TAG, "Trigger description = " + triggerDesc.toString());
        return triggerDesc.toString();
    }


    public static PPRuleModel  getScheduleRuleModelByDay(PPRuleModel ruleModels, int days){

        List <Integer> dayOfWeekList = new ArrayList<>();

        if((days & PPBusinessLogicParameterDOWSunday) == PPBusinessLogicParameterDOWSunday) {
            dayOfWeekList.add(0);
        }
        if((days & PPBusinessLogicParameterDOWMonday) == PPBusinessLogicParameterDOWMonday) {
            dayOfWeekList.add(1);
        }
        if((days & PPBusinessLogicParameterDOWTuesday) == PPBusinessLogicParameterDOWTuesday) {
            dayOfWeekList.add(2);
        }
        if((days & PPBusinessLogicParameterDOWWednesday) == PPBusinessLogicParameterDOWWednesday) {
            dayOfWeekList.add(3);
        }
        if((days & PPBusinessLogicParameterDOWThursday) == PPBusinessLogicParameterDOWThursday) {
            dayOfWeekList.add(4);
        }
        if((days & PPBusinessLogicParameterDOWFriday) == PPBusinessLogicParameterDOWFriday) {
            dayOfWeekList.add(5);
        }
        if((days & PPBusinessLogicParameterDOWSaturday) == PPBusinessLogicParameterDOWSaturday) {
            dayOfWeekList.add(6);
        }
        ruleModels.setDayOfWeekList(dayOfWeekList);

        return ruleModels;
    }

    public static int getScheduleTriggerDays(PPRuleModel ruleModel){
        int dayOfWeek = PPBusinessLogicParameterDOWNone;
//        for(PPRuleModel ruleModel : ruleList){
            for(PPRuleParameterModel paramModel: ruleModel.getTrigger().getParameters()){
                if(!PPUtil.isEmpty(paramModel.getName())){
                    if(paramModel.getName().equals("schedule")){
                        if(!PPUtil.isEmpty(paramModel.getValue())) {
                            String values1[] = paramModel.getValue().split(" ");
                            String dowString = values1[5];
                            if (dowString.equals("*")) {
                                PPVirtuosoLogTrace.d(TAG, "dowString = " + dowString);
                                dayOfWeek = PPBusinessLogicParameterDOWSunday
                                        | PPBusinessLogicParameterDOWMonday
                                        | PPBusinessLogicParameterDOWTuesday
                                        | PPBusinessLogicParameterDOWWednesday
                                        | PPBusinessLogicParameterDOWThursday
                                        | PPBusinessLogicParameterDOWFriday
                                        | PPBusinessLogicParameterDOWSaturday;
                            } else {
                                String values2[] = dowString.split(",");
                                for (int i = 0; i < values2.length; i++) {
                                    if (values2[i].contains("1")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 1");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWSunday;
                                    } else if (values2[i].contains("2")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 2");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWMonday;
                                    } else if (values2[i].contains("3")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 3");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWTuesday;
                                    } else if (values2[i].contains("4")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 4");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWWednesday;
                                    } else if (values2[i].contains("5")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 5");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWThursday;
                                    } else if (values2[i].contains("6")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 6");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWFriday;
                                    } else if (values2[i].contains("7")) {
                                        PPVirtuosoLogTrace.d(TAG, " dayOfWeek = 7");
                                        dayOfWeek = dayOfWeek | PPBusinessLogicParameterDOWSaturday;
                                    }
                                }
                            }
                        }
                    }
                }
            }
//        }
        return dayOfWeek;
    }

    public static List<PPRuleModel> getScheduleListByDay(List<PPRuleModel> scheduleModelList){
        List<PPRuleModel> ruleModelList = new ArrayList<>();

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 0) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.sun))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.sun));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 1) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.mon))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.mon));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 2) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.tue))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.tue));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 3) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.wed))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.wed));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 4) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.thu))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.thu));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }
        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 5) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.fri))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.fri));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        for(PPRuleModel scheduleModel : scheduleModelList) {
            for (int i : scheduleModel.getDayOfWeekList()) {
                PPRuleModel ruleModel = new PPRuleModel();
                if (i == 6) {
                    if (!checkDayHeader(ruleModelList, PPAppCenter.m_Context.getString(R.string.sat))) {
                        ruleModel.setDayHeader(PPAppCenter.m_Context.getString(R.string.sat));
                        ruleModelList.add(ruleModel);
                    }
                    ruleModelList.add(scheduleModel);
                }
            }
        }

        return ruleModelList;
    }

    private static boolean checkDayHeader(List<PPRuleModel> scheduleModelList, String day){
        boolean bCheckedHeader = false;
        for(PPRuleModel ruleModel: scheduleModelList){
            if(!PPUtil.isEmpty(ruleModel.getDayHeader())){
                if(ruleModel.getDayHeader().equals(day)){
                    bCheckedHeader = true;
                }
            }
        }
        return bCheckedHeader;
    }

    private static String getTimeString(String hours, String mins){
        StringBuilder sbTime = new StringBuilder();
        int iHours = Integer.parseInt(hours);
        int iMins = Integer.parseInt(mins);
        String AMPM = "";
        if(iHours > 12){
            iHours = iHours - 12;
            sbTime.append(Integer.toString(iHours));
            sbTime.append(":");
            AMPM = PPAppCenter.m_Context.getString(R.string.pm);
        }else{
            sbTime.append(Integer.toString(iHours));
            sbTime.append(":");
            AMPM = PPAppCenter.m_Context.getString(R.string.am);
        }

        if(iMins < 10){
            sbTime.append("0");
            sbTime.append(mins);
            sbTime.append(" " + AMPM + " ");
        }else{
            sbTime.append(mins);
            sbTime.append(" " + AMPM + " ");
        }

        return sbTime.toString();
    }

    public static int PPBusinessLogicParameterDOWNone = 0;
    public static int PPBusinessLogicParameterDOWSunday = 1 << 0;
    public static int PPBusinessLogicParameterDOWMonday = 1 << 1;
    public static int PPBusinessLogicParameterDOWTuesday = 1 << 2;
    public static int PPBusinessLogicParameterDOWWednesday = 1 << 3;
    public static int PPBusinessLogicParameterDOWThursday = 1 << 4;
    public static int PPBusinessLogicParameterDOWFriday = 1 << 5;
    public static int PPBusinessLogicParameterDOWSaturday = 1 << 6;

}
