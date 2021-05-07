package com.peoplepowerco.virtuoso.models;

import java.util.List;

public class PPDashboardHeaderModel {

    public String name;
    public int priority;
    public String icon;
    public String icon_font;
    public String title;
    public String comment;
    public boolean call;
    public boolean ecc;
    public long updated_ms;
    public Resolution resolution;
    public FeedBack feedBack;


    public static class Resolution {

        public String button;
        // Title at the top of the bottom modal action sheet
        public String title;
        public String datastream_address;
        public Content content;
        public List<ResponseOption> options;
    }

    public static class Content {

        public String microservice_id;
        public String conversation_id;
        public String timestamp_ms;
        public String quantified;
        public String verbatim;
        public String user_id;
    }

    public static class ResponseOption {

        public String text;
        public String ack;
        public String icon;
        public String icon_font;

        public int contentAnswer;
    }

    public static class FeedBack {

        public String quantified;
        public String verbatim;
        public String datastream_address;
        public Content content;
    }
}
