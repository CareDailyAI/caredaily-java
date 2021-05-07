package com.peoplepowerco.virtuoso.bean;


import androidx.annotation.Nullable;
import com.peoplepowerco.virtuoso.models.PPCardServiceModel;
import com.peoplepowerco.virtuoso.models.PPCardStatusModel;
import com.peoplepowerco.virtuoso.models.PPDashboardHeaderModel;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPTaskModel;
import com.peoplepowerco.virtuoso.models.narratives.PPNarrativeModel;

/**
 * Created by edwardliu on 2018/11/23.
 */

public class FAEvent {

    //    public PPQuestionsModel question;
    public PPNarrativeModel narrative;
    public PPCardStatusModel cardStatus;
    public PPCardServiceModel cardService;
    public PPTaskModel task;
    public PPDeviceInfoModel attentionModel;
    public PPDashboardHeaderModel headerModel;

    public int eventType;
    public String date;
    public String preDate;
    public String title;
    public String subTitle;
    public long createDateMs;
    public long narrativeDateMs;

    @Override
    public boolean equals(@Nullable Object obj) {
        FAEvent other = (FAEvent) obj;
        if (createDateMs != other.createDateMs || narrativeDateMs != other.narrativeDateMs) {
            return false;
        }
        if (eventType != other.eventType) {
            return false;
        }
        if (null == title && null == other.title && null == subTitle && null == other.subTitle) {
            return true;
        }
        if ((null == title && null != other.title) || (null != title && null == other.title)) {
            return false;
        }
        if ((null == subTitle && null != other.subTitle) || (null != subTitle && null == other.subTitle)) {
            return false;
        }
        if (!title.equals(other.title) || !subTitle.equals(other.subTitle)) {
            return false;
        }
        return true;
    }
}
