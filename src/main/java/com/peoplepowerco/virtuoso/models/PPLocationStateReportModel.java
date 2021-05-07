package com.peoplepowerco.virtuoso.models;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONArray;

public class PPLocationStateReportModel {

    public String id;
    public String title;
    public String subtitle;
    public String icon;
    public String color;
    public String timestampStr;
    public String comment_raw;
    public int weight;
    public long timestampMs;
    public int reportType;
    public JSONArray itemsArray;

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof PPLocationStateReportModel) {
            PPLocationStateReportModel other = (PPLocationStateReportModel) obj;
            if (TextUtils.isEmpty(title) && TextUtils.isEmpty(other.title)) {
                return this.id.equals(other.id);
            } else {
                return this.id.equals(other.id) && this.title.equals(other.title);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int titleHashcode = null == title ? 0 : title.hashCode();
        return titleHashcode + id.hashCode() * 31;
    }

    public static final int REPORT_TYPE_HEADER = 0;
    public static final int REPORT_TYPE_SECTION = 1;
    public static final int REPORT_TYPE_TEXT = 2;
    public static final int REPORT_TYPE_IMAGE = 3;
}
