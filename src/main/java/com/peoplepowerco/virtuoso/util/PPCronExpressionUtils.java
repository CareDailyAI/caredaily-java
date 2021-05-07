/**
 * @FileName : PPCronExpressionUtils.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;

import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.R;

import java.text.DecimalFormat;

public class PPCronExpressionUtils {

    private static DecimalFormat m_Format = new DecimalFormat("00");

    public static String getStringFromCronExpression(String cronString) {
        String m_CronDate = null;
        String[] m_CronSplit = cronString.split(" ");

        //	int m_Hour = (Integer.valueOf(m_CronSplit[2]) <= 12 ? Integer.valueOf(m_CronSplit[2]):Integer.valueOf(m_CronSplit[2]) - 12);
        int m_Hour = Integer.valueOf(m_CronSplit[2]);
        if (m_Hour != 12) {
            m_Hour = m_Hour % 12 == 0 ? 12 : m_Hour % 12;
        }
        //	String m_Minutes = Integer.valueOf(m_CronSplit[1])>10?m_CronSplit[1]:"0"+m_CronSplit[1];
        String m_Minutes = m_Format.format(Integer.valueOf(m_CronSplit[1]));
        //	int m_Seconds = Integer.valueOf(m_CronSplit[0]);
        String m_AMPM = Integer.valueOf(m_CronSplit[2]) < 12 ? PPAppCenter.m_Context.getString(R.string.am) : PPAppCenter.m_Context.getString(R.string.pm);
        String m_Days = m_CronSplit[5];
        String day = "";
        if (m_Days.equals("*")) {
            day = PPAppCenter.m_Context.getString(R.string.rule_schedule_everyday_repeats);
        } else if (m_Days.equals("2,3,4,5,6")) {
            day = PPAppCenter.m_Context.getString(R.string.rule_schedule_workday_repeats);
        } else if (m_Days.contains(",")) {
            day = PPAppCenter.m_Context.getString(R.string.on) + " ";
            String[] m_DayArray = m_Days.split(",");
            for (int i = 0; i < m_DayArray.length; i++) {
                if (i == m_DayArray.length - 1) {
                    day += getDayById(m_DayArray[i]);
                } else {
                    day += getDayById(m_DayArray[i]) + " & ";
                }
            }
        } else {
            day = PPAppCenter.m_Context.getString(R.string.on) + " ";
            day += getDayById(m_Days);
        }
        String timeStr = m_Hour + ":" + m_Minutes;
        m_CronDate = PPAppCenter.m_Context.getString(R.string.schedule_str, timeStr, m_AMPM, day);
        return m_CronDate;

    }

    public static String getTimeStringFromCron(String cronString) {
        String m_CronDate = null;
        String[] m_CronSplit = cronString.split(" ");

        //	int m_Hour = (Integer.valueOf(m_CronSplit[2]) <= 12 ? Integer.valueOf(m_CronSplit[2]):Integer.valueOf(m_CronSplit[2]) - 12);
        int m_Hour = Integer.valueOf(m_CronSplit[2]);
        if (m_Hour != 12) {
            m_Hour = m_Hour % 12;
        }
        //	String m_Minutes = Integer.valueOf(m_CronSplit[1])>10?m_CronSplit[1]:"0"+m_CronSplit[1];
        String m_Minutes = m_Format.format(Integer.valueOf(m_CronSplit[1]));
        //	int m_Seconds = Integer.valueOf(m_CronSplit[0]);
        String m_AMPM = Integer.valueOf(m_CronSplit[2]) < 12 ? PPAppCenter.m_Context.getString(R.string.am) : PPAppCenter.m_Context.getString(R.string.pm);

        String timeStr = m_Hour + ":" + m_Minutes;
        m_CronDate = PPAppCenter.m_Context.getString(R.string.schedule_time_day_apm, timeStr, m_AMPM);
        return m_CronDate;

    }

    public static String getDaysOfweek(String value) {
        if (value == null)
            return "";
        String day = "";
        if (value.equals("127")) {
            day = PPAppCenter.m_Context.getString(R.string.rule_schedule_everyday_repeats);
        } else {
            int[] m_DayArray = decToBin(Integer.valueOf(value));
            int length = m_DayArray.length;
            int j = 0;
            for (int i = 0; i < length; i++) {
                if (m_DayArray[i] == 1) {
                    if (i > 0 && j > 0) {
                        day += " & ";
                    }
                    j++;
                    day += getDayById(String.valueOf(i + 1));
                }
            }
        }
        return day;
    }

    public static String getTimeStringFromSecond(int seconds) {
        long m_Seconds = seconds;
        int m_Hours = (int) m_Seconds / 3600;
        int remainder = (int) m_Seconds - m_Hours * 3600;
        int m_Min = remainder / 60;
        remainder = remainder - m_Min * 60;
        String m_AMPM = m_Hours < 12 ? PPAppCenter.m_Context.getString(R.string.am) : PPAppCenter.m_Context.getString(R.string.pm);
        m_Hours = m_Hours > 12 ? m_Hours - 12 : m_Hours;
        String timeStr = m_Format.format(m_Hours) + ":" + m_Format.format(m_Min);
        String ret = PPAppCenter.m_Context.getString(R.string.schedule_time_day_apm, timeStr, m_AMPM);
        return ret;
    }

    /*
     * long[0] = Second
     * long[1] = min
     * long[2] = hours
     */
    public static String getSecondsFromTime(long[] m_Time) {
        return String.valueOf(m_Time[0] + (m_Time[1] * 60) + (m_Time[2] * 3600));
    }

    public static String generateCronTrigger(String[] m_String) {
        String m_CronDate = "0";
        m_CronDate += " " + m_String[1];  //minutes
        m_CronDate += " " + m_String[0];  //hours
        m_CronDate += " ?";              //
        m_CronDate += " *";
        m_CronDate += " " + m_String[2];  //day of weeks
        m_CronDate += " *";
        return m_CronDate;
    }

    private static int[] decToBin(int number) {
        int[] array = new int[7];
        int k = 0;
        while (number != 0) {
            array[k] = number & 1;
            number >>>= 1;
            k++;
        }
        return array;
    }

    private static String getDayById(String id) {
        if (id.equals("1")) {
            return PPAppCenter.m_Context.getString(R.string.sun);
        } else if (id.equals("2")) {
            return PPAppCenter.m_Context.getString(R.string.mon);
        } else if (id.equals("3")) {
            return PPAppCenter.m_Context.getString(R.string.tue);
        } else if (id.equals("4")) {
            return PPAppCenter.m_Context.getString(R.string.wed);
        } else if (id.equals("5")) {
            return PPAppCenter.m_Context.getString(R.string.thu);
        } else if (id.equals("6")) {
            return PPAppCenter.m_Context.getString(R.string.fri);
        } else if (id.equals("7")) {
            return PPAppCenter.m_Context.getString(R.string.sat);
        }
        return null;
    }
}
