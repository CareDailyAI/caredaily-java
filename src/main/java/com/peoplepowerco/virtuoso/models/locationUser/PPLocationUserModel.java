package com.peoplepowerco.virtuoso.models.locationUser;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.managers.PPLocationUserManager;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import java.util.List;

public class PPLocationUserModel {

    private int id = PPCommonInfo.PPInvalidValue;
    private String userName;
    private String altUsername;
    private String firstName;
    private String lastName;
    private Email email;
    private String phone;
    private int phoneType;
    private int smsStatus;
    private int locationAccess = PPCommonInfo.PPInvalidValue;
    private String accessEndDate;
    private long accessEndDateMs;
    private int category = PPCommonInfo.PPInvalidValue;
    private String temporary;
    private String nickname;
    private String smsPhone;
    private String avatarFileId;
    private List<Schedule> schedules = null;
    private int sectionType = PPLocationUserManager.LOCATION_SECTION_TYPE_NOT;
    private int position;
    public PPDeviceInfoModel attentionModel;

    public String getFullName() {
        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)) {
            return String.format("%s %s", firstName, lastName);
        }
        if (!TextUtils.isEmpty(nickname)) {
            return nickname;
        }
        if (!TextUtils.isEmpty(firstName)) {
            return firstName;
        }
        if (!TextUtils.isEmpty(lastName)) {
            return lastName;
        }
        if (!TextUtils.isEmpty(userName)) {
            return userName;
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectionType() {
        return sectionType;
    }

    public void setSectionType(int sectionType) {
        this.sectionType = sectionType;
    }

    public String getUserName() {
        return null == userName ? "" : userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAltUsername() {
        return null == altUsername ? "" : altUsername;
    }

    public void setAltUsername(String altUsername) {
        this.altUsername = altUsername;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(int phoneType) {
        this.phoneType = phoneType;
    }

    public int getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(int smsStatus) {
        this.smsStatus = smsStatus;
    }

    public int getLocationAccess() {
        return locationAccess;
    }

    public void setLocationAccess(int locationAccess) {
        this.locationAccess = locationAccess;
    }

    public String getAccessEndDate() {
        return accessEndDate;
    }

    public void setAccessEndDate(String accessEndDate) {
        this.accessEndDate = accessEndDate;
    }

    public long getAccessEndDateMs() {
        return accessEndDateMs;
    }

    public void setAccessEndDateMs(long accessEndDateMs) {
        this.accessEndDateMs = accessEndDateMs;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTemporary() {
        return temporary;
    }

    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }

    public String getSmsPhone() {
        return smsPhone;
    }

    public void setSmsPhone(String smsPhone) {
        this.smsPhone = smsPhone;
    }

    public String getAvatarFileId() {
        return avatarFileId;
    }

    public void setAvatarFileId(String avatarFileId) {
        this.avatarFileId = avatarFileId;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String jsonData() {
//        String scheduleStr = "";
//        if (null != schedules && !schedules.isEmpty()) {
//            scheduleStr = JSONArray.toJSONString(schedules);
//        }
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        if (PPCommonInfo.PPInvalidValue != id) {
            builder.append(String.format("\"id\":%d,", id));
        }
        builder.append(String.format("\"locationAccess\":%d,", locationAccess));
        builder.append(String.format("\"category\":%d", category));
        if (!TextUtils.isEmpty(temporary)) {
            builder.append(",");
            builder.append(String.format("\"temporary\":%s", temporary));
        }
//        builder.append(String.format("\"userName\": \"%s\"", userName));
//        builder.append(String.format("\"schedules\": \"%s\"", scheduleStr));
        builder.append("}");
        return builder.toString();
    }
}