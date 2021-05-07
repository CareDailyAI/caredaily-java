package com.peoplepowerco.virtuoso.bean;

import android.text.TextUtils;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwardliu on 2018/11/30.
 */

public class FAPost {

    public int itemType;
    public String userID;
    public String userFirstName;
    public String userLastName;
    public String userCommunityName;
    public String userAvatarFileId;

    //Post
    public String postId;
    public long communityId;
    public long creationDateMs;
    public String distance;
    public String title;
    public String postText;
    public long eventDateMs;
    public long nextEventDateMs;
    public String address;
    public double latitude;
    public double longitude;
    public String driveUrl;
    public String repeat;
    public boolean allDay;
    public List<PPPostReminderModel> reminders = new ArrayList<>();

    //Comment
    public String commentId;
    public String replyCommentId;
    public long commentDateMs;
    public String commentText;

    public FAPost(PPPostModel postModel) {
        this.postId = postModel.postId;
        this.communityId = postModel.communityId;
        if (null != postModel.user) {
            this.userID = postModel.user.id;
            this.userFirstName = postModel.user.firstName;
            this.userLastName = postModel.user.lastName;
            this.userCommunityName = postModel.user.communityName;
            this.userAvatarFileId = postModel.user.avatarFileId;
        }
        this.creationDateMs = postModel.creationDateMs;
        this.eventDateMs = postModel.eventDateMs;
        this.allDay = postModel.allDay;
        this.repeat = postModel.repeat;
        this.nextEventDateMs = postModel.eventEndDateMs;
        this.distance = postModel.distance;
        this.title = postModel.title;
        this.postText = postModel.postText;
        for (PPPostReminderModel reminder : postModel.reminders) {
            reminders.add(reminder);
        }
        if (null != postModel.address) {
            address = postModel.address.getReadableLocation();
            this.latitude = postModel.latitude;
            this.longitude = postModel.longitude;
        }
        this.driveUrl = postModel.driveUrl;
        this.itemType = FAEventTypePost;
    }

    public FAPost(PPPostCommentModel commentModel) {
        if (null != commentModel.user) {
            this.userID = commentModel.user.id;
            this.userFirstName = commentModel.user.firstName;
            this.userLastName = commentModel.user.lastName;
            this.userCommunityName = commentModel.user.communityName;
            this.userAvatarFileId = commentModel.user.avatarFileId;
        }
        this.commentId = commentModel.commentId;
        this.replyCommentId = commentModel.replyCommentId;
        this.commentDateMs = commentModel.commentDateMs;
        this.commentText = commentModel.commentText;
        this.postId = commentModel.postId;
        this.itemType = TextUtils.isEmpty(this.replyCommentId) ? FAEventTypeComment : FAEventTypeCommentReply;
    }

    public String getFullName() {
        PPUserInfoModel userInfo = PPUserManager.getInstance().getUserInfoModel();
        if (null != userInfo && !TextUtils.isEmpty(userInfo.sCommunityName)
            && !TextUtils.isEmpty(userID) && userID.equals(userInfo.sUserInfoId)) {
            return userInfo.sCommunityName;
        }
        if (!TextUtils.isEmpty(userCommunityName)) {
            return userCommunityName;
        }
        if (!TextUtils.isEmpty(userFirstName) && !TextUtils.isEmpty(userLastName)) {
            return String.format("%s %s", userFirstName, userLastName);
        }
        if (!TextUtils.isEmpty(userFirstName)) {
            return userFirstName;
        }
        if (!TextUtils.isEmpty(userLastName)) {
            return userLastName;
        }
        return null;
    }

    public static final int FAEventTypePost = 1;
    public static final int FAEventTypeComment = 2;
    public static final int FAEventTypeCommentReply = 3;
    public static final int FAEventTypeLoadMore = 4;

    public static final int REACTION_REMOVE = 0;
    public static final int REACTION_LIKE = 1;
    public static final int REACTION_LOVE = 2;
    public static final int REACTION_HAHA = 3;
    public static final int REACTION_WOW = 4;
    public static final int REACTION_SAD = 5;
    public static final int REACTION_ANGRY = 6;
    public static final int REACTION_FLAGGED = 7;
}
