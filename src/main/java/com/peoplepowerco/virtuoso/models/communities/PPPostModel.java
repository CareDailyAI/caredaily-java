package com.peoplepowerco.virtuoso.models.communities;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.bean.FAPost;
import com.peoplepowerco.virtuoso.managers.PPLocationUserManager;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPUserInfoModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.Sort;
import io.realm.annotations.PrimaryKey;

public class PPPostModel extends RealmObject {

    @PrimaryKey
    public String postId;
    public int postType;
    public int status;
    public PPPostUserModel user;
    public PPPostLocationModel location;
    public PPPostAddressModel address;
    public long locationId;
    public long communityId;
    public long creationDateMs;
    public long eventDateMs;
    public long eventEndDateMs;
    public long nextEventDateMs;
    public boolean allDay;
    public String title;
    public String topic;
    public String driveUrl;
    public String eventDate;
    public String eventEndDate;
    public String nextEventDate;
    public long duration;
    public String postText;
    public double latitude;
    public double longitude;
    public int itemType;
    public String distance;
    public String repeat;
    public String repeatEndDate;
    public String localFilePath;
    public long repeatEndDateMs;

    public RealmList<PPPostReminderModel> reminders = new RealmList<>();
    public RealmList<PPPostReactionModel> reactions = new RealmList<>();
    public RealmList<PPPostCommentModel> comments = new RealmList<>();
    public RealmList<PPPostFileModel> files = new RealmList<>();

    public static final int POST_TYPE_INDIVIDUAL = 1;
    public static final int POST_TYPE_LOCATION = 2;
    public static final int POST_TYPE_COMMUNITY = 3;

    public static final int POST_ITEM_TYPE_SEARCH = 1;
    public static final int POST_ITEM_TYPE_FILTER = 2;
    public static final int POST_ITEM_TYPE_NORMAL = 3;
    public static final int POST_ITEM_TYPE_NO_POST = 4;

    public static final int POST_STATUS_ACTIVE = 1;
    public static final int POST_STATUS_REJECTED = 2;

    public static RealmResults<PPPostModel> findAll(Realm realm) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        return realm.where(PPPostModel.class).equalTo("status", 1)
            .sort("creationDateMs", Sort.DESCENDING).findAll();
    }

    public static RealmResults<PPPostModel> findByPostType(Realm realm, String content, int postType) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        RealmResults<PPPostModel> results = null;
        if (TextUtils.isEmpty(content)) {
            results = realm.where(PPPostModel.class)
                .equalTo("status", 1)
                .sort("creationDateMs", Sort.DESCENDING)
                .beginGroup()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_SEARCH)
                .or()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_FILTER)
                .or()
                .equalTo("postType", postType)
                .endGroup()
                .findAll();
        } else {
            results = realm.where(PPPostModel.class)
                .equalTo("status", 1)
                .sort("creationDateMs", Sort.DESCENDING)
                .beginGroup()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_SEARCH)
                .or()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_FILTER)
                .or()
                .equalTo("postType", postType)
                .beginGroup()
                .contains("user.firstName", content, Case.INSENSITIVE)
                .or()
                .contains("user.lastName", content, Case.INSENSITIVE)
                .or()
                .contains("title", content, Case.INSENSITIVE)
                .or()
                .contains("postText", content, Case.INSENSITIVE)
                .or()
                .contains("driveUrl", content, Case.INSENSITIVE)
                .endGroup()
                .endGroup()
                .findAll();
        }
        if (results.size() == 2) {
            results = realm.where(PPPostModel.class)
                .equalTo("status", 1)
                .sort("creationDateMs", Sort.DESCENDING)
                .beginGroup()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_SEARCH)
                .or()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_FILTER)
                .or()
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_NO_POST)
                .endGroup()
                .findAll();
        }
        return results;
    }

    public static PPPostModel findById(Realm realm, String postId) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        return realm.where(PPPostModel.class).equalTo("postId", postId).findFirst();
    }

    public static PPPostModel findByStatus(Realm realm, int status) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        return realm.where(PPPostModel.class).equalTo("status", status).findFirst();
    }

    public static PPPostModel findPostWithReactionUserId(Realm realm, String postId, String userId) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        RealmResults<PPPostModel> results = realm.where(PPPostModel.class).equalTo("postId", postId).findAll();
        PPPostModel result = results.where().equalTo("reactions.user.id", userId).findFirst();
        return result;
    }

    public static RealmResults<PPPostCommentModel> findTopComments(Realm realm, String postId) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        RealmResults<PPPostCommentModel> results = realm.where(PPPostCommentModel.class).isNull("replyCommentId")
            .and().equalTo("postId", postId).findAll();
        return results;
    }

    public static RealmResults<PPPostCommentModel> findSubComments(Realm realm, String replyCommentId) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        RealmResults<PPPostCommentModel> results = realm.where(PPPostCommentModel.class).equalTo("replyCommentId", replyCommentId).findAll();
        return results;
    }

    public static PPPostCommentModel findCommentReactionUser(Realm realm, String commentId, String userId) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        RealmResults<PPPostCommentModel> results = realm.where(PPPostCommentModel.class).equalTo("commentId", commentId).findAll();
        PPPostCommentModel result = results.where().equalTo("reactions.user.id", userId).findFirst();
        return result;
    }

    public static boolean isPostFlagged(Realm realm, String postId) {
        if (realm == null || realm.isClosed()) {
            return false;
        }

        PPPostReactionModel result = realm.where(PPPostReactionModel.class).equalTo("postId", postId)
            .and().equalTo("reaction", FAPost.REACTION_FLAGGED).findFirst();
        return null != result;
    }

    public static boolean isPostFlaggedByUser(Realm realm, String postId, String userId) {
        if (realm == null || realm.isClosed()) {
            return false;
        }

        PPPostReactionModel result = realm.where(PPPostReactionModel.class)
            .equalTo("postId", postId)
            .and()
            .equalTo("user.id", userId)
            .and()
            .equalTo("reaction", FAPost.REACTION_FLAGGED).findFirst();
        return null != result;
    }

    public static boolean isCommentFlagged(Realm realm, String commentId) {
        if (realm == null || realm.isClosed()) {
            return false;
        }

        PPPostReactionModel result = realm.where(PPPostReactionModel.class).equalTo("commentId", commentId)
            .and().equalTo("reaction", FAPost.REACTION_FLAGGED).findFirst();
        return null != result;
    }

    public static RealmResults<PPPostModel> search(Realm realm, String content) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        return realm.where(PPPostModel.class).
            contains("user.firstName", content, Case.INSENSITIVE)
            .or()
            .contains("user.lastName", content, Case.INSENSITIVE)
            .or()
            .contains("title", content, Case.INSENSITIVE)
            .or()
            .contains("postText", content, Case.INSENSITIVE)
            .or()
            .contains("driveUrl", content, Case.INSENSITIVE)
            .sort("creationDateMs", Sort.DESCENDING).findAll();
    }

    public static RealmResults<PPPostModel> searchByType(Realm realm, String content) {
        if (realm == null || realm.isClosed()) {
            return null;
        }

        return realm.where(PPPostModel.class).
            contains("user.firstName", content, Case.INSENSITIVE)
            .or()
            .contains("user.lastName", content, Case.INSENSITIVE)
            .or()
            .contains("title", content, Case.INSENSITIVE)
            .or()
            .contains("postText", content, Case.INSENSITIVE)
            .or()
            .contains("driveUrl", content, Case.INSENSITIVE)
            .sort("creationDateMs", Sort.DESCENDING).findAll();
    }

    public void updateReaction(String postId, String commentId, int reactionType) {
        PPUserInfoModel currentUser = PPUserManager.getInstance().getUserInfoModel();
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        if (reactionType == FAPost.REACTION_REMOVE) {
            if (null != commentId) {
                realm.where(PPPostReactionModel.class).equalTo("commentId", commentId)
                    .and().equalTo("user.id", currentUser.sUserInfoId).findAll().deleteAllFromRealm();
            } else {
                realm.where(PPPostReactionModel.class).equalTo("postId", postId)
                    .and().equalTo("user.id", currentUser.sUserInfoId).and().isNull("commentId").findAll().deleteAllFromRealm();
            }
        } else {
            PPPostUserModel postUser = realm.where(PPPostUserModel.class).equalTo("id", currentUser.sUserInfoId).findFirst();
            if (null == postUser) {
                postUser = realm.createObject(PPPostUserModel.class, currentUser.sUserInfoId);
            }
            PPLocationUserModel locationUser = PPLocationUserManager.getInstance().findUserById(currentUser.sUserInfoId);
            postUser.firstName = currentUser.sUserFirstName;
            postUser.lastName = currentUser.sUserLastName;
            if (null != locationUser) {
                postUser.avatarFileId = locationUser.getAvatarFileId();
            }
            PPPostReactionModel reactionModel = realm.createObject(PPPostReactionModel.class);
            reactionModel.reaction = reactionType;
            reactionModel.user = postUser;
            if (null != postId) {
                reactionModel.postId = postId;
            }
            if (null != commentId) {
                reactionModel.commentId = commentId;
            }

            if (null != commentId) {
                for (PPPostCommentModel comment : comments) {
                    if (comment.commentId.equals(commentId)) {
                        comment.reactions.add(reactionModel);
                        break;
                    }
                }
            } else {
                reactions.add(reactionModel);
            }
        }
        realm.commitTransaction();
        realm.close();
    }

    public void saveLocally(Realm realm) {
        realm.beginTransaction();
        realm.insertOrUpdate(this);
        realm.commitTransaction();
        realm.close();
    }

    public void deleteSelf(Realm realm) {
        realm.beginTransaction();
        PPPostModel result = realm.where(PPPostModel.class).equalTo("postId", postId).findFirst();
        if (null != result) {
            result.deleteFromRealm();
        }
        realm.commitTransaction();
        realm.close();
    }

    public void deleteComment(Realm realm, String commentId) {
        if (null == commentId) {
            return;
        }

        PPPostCommentModel result = realm.where(PPPostCommentModel.class).equalTo("commentId", commentId).findFirst();
        if (null != result) {
            realm.beginTransaction();
            result.deleteFromRealm();
            realm.commitTransaction();
            realm.close();
        }
    }

    public void deleteFile(Realm realm, String fileId) {
        if (null == fileId) {
            return;
        }

        PPPostFileModel result = realm.where(PPPostFileModel.class).equalTo("fileId", fileId).findFirst();
        if (null != result) {
            realm.beginTransaction();
            result.deleteFromRealm();
            realm.commitTransaction();
            realm.close();
        }
    }

    public String updateJsonData() {
        JSONObject dataObj = new JSONObject();
        JSONObject postObj = new JSONObject();
        postObj.put("postType", postType);
        if (communityId > 0) {
            postObj.put("communityId", communityId);
        }
        if (locationId > 0) {
            postObj.put("locationId", locationId);
        }
        postObj.put("title", title);
        postObj.put("status", status);
        if (null != topic) {
            postObj.put("topic", topic);
        }
        if (!TextUtils.isEmpty(driveUrl)) {
            postObj.put("driveUrl", driveUrl);
        }
        postObj.put("postText", postText);
        if (!TextUtils.isEmpty(eventDate)) {
            postObj.put("eventDate", eventDate);
        }
        postObj.put("duration", duration);
        if (!TextUtils.isEmpty(repeat)) {
            postObj.put("repeat", repeat);
        }
        if (!TextUtils.isEmpty(repeatEndDate)) {
            postObj.put("repeatEndDate", repeatEndDate);
        }
        postObj.put("allDay", allDay);
        if (null != address) {
            JSONObject addressObj = new JSONObject();
            addressObj.put("addrStreet1", address.addrStreet1);
//            addressObj.put("addrStreet2", address.addrStreet2);
            addressObj.put("addrCity", address.addrCity);
            addressObj.put("zip", address.zip);
            JSONObject stateObj = new JSONObject();
            stateObj.put("id", address.stateId);
            addressObj.put("state", stateObj);
            JSONObject countryObj = new JSONObject();
            countryObj.put("id", address.countryId);
            addressObj.put("country", countryObj);
            postObj.put("address", addressObj);
        }
        if (0d != latitude) {
            postObj.put("latitude", latitude);
        }
        if (0d != longitude) {
            postObj.put("longitude", longitude);
        }
        if (null != reminders && !reminders.isEmpty()) {
            JSONArray reminderArray = new JSONArray();
            for (int i = 0; i != reminders.size(); ++i) {
                JSONObject reminderObj = new JSONObject();
                PPPostReminderModel reminder = reminders.get(i);
                if (reminder.notificationDate != null) {
                    reminderObj.put("notificationDate", reminder.notificationDate);
                } else {
                    reminderObj.put("notificationInterval", reminder.notificationInterval);
                }
                reminderObj.put("notificationText", reminder.notificationText);
                reminderArray.add(reminderObj);
            }
            postObj.put("reminders", reminderArray);
        }
        dataObj.put("post", postObj);
        return dataObj.toJSONString();
    }

    public String createJsonData(String locationId) {
        JSONObject dataObj = new JSONObject();
        JSONObject postObj = new JSONObject();
        postObj.put("postType", postType);
        postObj.put("locationId", locationId);
        if (communityId > 0) {
            postObj.put("communityId", communityId);
        }
        if (!TextUtils.isEmpty(title)) {
            postObj.put("title", title);
        }
        postObj.put("status", status);
        if (null != topic) {
            postObj.put("topic", topic);
        }
        if (!TextUtils.isEmpty(driveUrl)) {
            postObj.put("driveUrl", driveUrl);
        }
        if (!TextUtils.isEmpty(postText)) {
            postObj.put("postText", postText);
        }
        if (!TextUtils.isEmpty(eventDate)) {
            postObj.put("eventDate", eventDate);
        }
        postObj.put("duration", duration);
        if (!TextUtils.isEmpty(repeat)) {
            postObj.put("repeat", repeat);
        }
        if (!TextUtils.isEmpty(repeatEndDate)) {
            postObj.put("repeatEndDate", repeatEndDate);
        }
        postObj.put("allDay", allDay);
        if (null != address) {
            JSONObject addressObj = new JSONObject();
            addressObj.put("addrStreet1", address.addrStreet1);
//            addressObj.put("addrStreet2", address.addrStreet2);
            addressObj.put("addrCity", address.addrCity);
            addressObj.put("zip", address.zip);
            JSONObject stateObj = new JSONObject();
            stateObj.put("id", address.stateId);
            addressObj.put("state", stateObj);
            JSONObject countryObj = new JSONObject();
            countryObj.put("id", address.countryId);
            addressObj.put("country", countryObj);
            postObj.put("address", addressObj);
        }
        if (0d != latitude) {
            postObj.put("latitude", latitude);
        }
        if (0d != longitude) {
            postObj.put("longitude", longitude);
        }
        if (null != reminders && !reminders.isEmpty()) {
            JSONArray reminderArray = new JSONArray();
            for (int i = 0; i != reminders.size(); ++i) {
                JSONObject reminderObj = new JSONObject();
                PPPostReminderModel reminder = reminders.get(i);
                if (reminder.notificationDate != null) {
                    reminderObj.put("notificationDate", reminder.notificationDate);
                } else {
                    reminderObj.put("notificationInterval", reminder.notificationInterval);
                }
                reminderObj.put("notificationText", reminder.notificationText);
                reminderArray.add(reminderObj);
            }
            postObj.put("reminders", reminderArray);
        }
        dataObj.put("post", postObj);
        return dataObj.toJSONString();
    }

    public void copyDatas(PPPostModel postModel) {
        postId = postModel.postId;
        postType = postModel.postType;
        status = postModel.status;
        user = postModel.user;
        locationId = postModel.locationId;
        communityId = postModel.communityId;
        creationDateMs = postModel.creationDateMs;
        eventDate = postModel.eventDate;
        eventDateMs = postModel.eventDateMs;
        eventEndDate = postModel.eventEndDate;
        eventEndDateMs = postModel.eventEndDateMs;
        allDay = postModel.allDay;
        repeat = postModel.repeat;
        repeatEndDate = postModel.repeatEndDate;
        repeatEndDateMs = postModel.repeatEndDateMs;
        title = postModel.title;
        topic = postModel.topic;
        driveUrl = postModel.driveUrl;
        postText = postModel.postText;
        latitude = postModel.latitude;
        longitude = postModel.longitude;
        itemType = postModel.itemType;
        distance = postModel.distance;
        localFilePath = postModel.localFilePath;
        if (null != postModel.address) {
            address = new PPPostAddressModel();
            address.addrStreet1 = postModel.address.addrStreet1;
            address.addrStreet2 = postModel.address.addrStreet2;
            address.addrCity = postModel.address.addrCity;
            address.stateId = postModel.address.stateId;
            address.countryId = postModel.address.countryId;
            address.zip = postModel.address.zip;
        }
        for (PPPostReminderModel reminder : postModel.reminders) {
            reminders.add(reminder.copy());
        }
        for (PPPostFileModel file : postModel.files) {
            files.add(file.copy());
        }
        reactions.addAll(postModel.reactions);
        comments.addAll(postModel.comments);
    }
}
