package com.peoplepowerco.virtuoso.bean;

import android.text.TextUtils;

import androidx.annotation.Nullable;

public class SectionObject {
    public int sectionId;
    public String sectionName;

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SectionObject) {
            SectionObject other = (SectionObject) obj;
            if (TextUtils.isEmpty(this.sectionName) && TextUtils.isEmpty(other.sectionName)) {
                return (this.sectionId == other.sectionId);
            } else if (TextUtils.isEmpty(this.sectionName)) {
                return false;
            } else if (TextUtils.isEmpty(other.sectionName)) {
                return false;
            } else {
                return (this.sectionId == other.sectionId) && (this.sectionName.equals(other.sectionName));
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (sectionName != null ? sectionName.hashCode() : 1) * 31 + sectionId;
    }
}