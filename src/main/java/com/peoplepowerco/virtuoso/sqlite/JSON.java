package com.peoplepowerco.virtuoso.sqlite;

import android.net.Uri;
import android.provider.BaseColumns;

import com.peoplepowerco.virtuoso.VirtuosoCommonSettings;

/**
 * Created by edwardliu on 19/4/2.
 */
public class JSON {
    public static final String AUTHORITY = VirtuosoCommonSettings.JSON_PROVIDER_AUTH;

    private JSON() {
    }

    public static final class JSONColumn implements BaseColumns {
        private JSONColumn() {
        }

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/");

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.json";

        public static final String DEFAULT_SORT_ORDER = " _id DESC";

        public static final String URL = "url";
        public static final String JSON = "json";
        public static final String CREATED_TIME = "created_time";
    }
}
