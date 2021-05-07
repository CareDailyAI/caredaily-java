package com.peoplepowerco.virtuoso.models.communities;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PPPostUserModel extends RealmObject {

    @PrimaryKey
    public String id;
    public String firstName;
    public String lastName;
    public String communityName;
    public String avatarFileId;

    public String getDisplayName() {
        PPUserInfoModel userInfo = PPUserManager.getInstance().getUserInfoModel();
        if (null != userInfo && !TextUtils.isEmpty(userInfo.sCommunityName)
            && !TextUtils.isEmpty(id) && id.equals(userInfo.sUserInfoId)) {
            return userInfo.sCommunityName;
        }
        if (!TextUtils.isEmpty(communityName)) {
            return communityName;
        }
        if (!TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName)) {
            return String.format("%s %s", firstName, lastName);
        }
        if (!TextUtils.isEmpty(firstName)) {
            return firstName;
        }
        if (!TextUtils.isEmpty(lastName)) {
            return lastName;
        }
        return null;
    }
}
