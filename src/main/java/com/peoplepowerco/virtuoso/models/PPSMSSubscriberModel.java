package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;

/**
 * Created by edwardliu on 2017/8/21.
 */

public class PPSMSSubscriberModel {
    public ArrayList<Integer> categories;
    public int status;
    public String firstName;
    public String lastName;
    public String phone;
    public String initials;

    public interface PPSMSSubscriberStatus {
        public static final int PPSMSSubscriberStatusNone = 0;
        public static final int PPSMSSubscriberStatusSubscribed = 1;
        public static final int PPSMSSubscriberStatusOptOut = 2;
    }
}
