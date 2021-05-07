/**
 * @FileName : PPDeviceInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;


import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.models.communities.PPPostAddressModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostCommentModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostFileModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostLocationModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostReactionModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostReminderModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostTimezoneModel;
import com.peoplepowerco.virtuoso.models.communities.PPPostUserModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel;
import io.realm.Realm;
import io.realm.RealmResults;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PPCommunityPostJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        boolean fetchAllPost = (boolean) obj[0];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZZZZ");
        JSONArray array = jso.getJSONArray("posts");
        if (null != array && !array.isEmpty()) {
            Realm realm = Realm.getDefaultInstance();
            while (realm.isInTransaction()) {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            realm.beginTransaction();

            PPPostModel searchModel = realm.where(PPPostModel.class)
                .equalTo("postId", "0x1")
                .findFirst();
            if (null == searchModel) {
                searchModel = realm.createObject(PPPostModel.class, "0x1");
                searchModel.itemType = PPPostModel.POST_ITEM_TYPE_SEARCH;
                searchModel.creationDateMs = Long.MAX_VALUE - 1;
            }
            searchModel.status = 1;
            PPPostModel filterModel = realm.where(PPPostModel.class)
                .equalTo("postId", "0x2")
                .findFirst();
            if (null == filterModel) {
                filterModel = realm.createObject(PPPostModel.class, "0x2");
                filterModel.itemType = PPPostModel.POST_ITEM_TYPE_FILTER;
                filterModel.creationDateMs = Long.MAX_VALUE - 2;
            }
            filterModel.status = 1;
            PPPostModel noPostModel = realm.where(PPPostModel.class)
                .equalTo("postId", "0x3")
                .findFirst();
            if (null == noPostModel) {
                noPostModel = realm.createObject(PPPostModel.class, "0x3");
                noPostModel.itemType = PPPostModel.POST_ITEM_TYPE_NO_POST;
                noPostModel.creationDateMs = Long.MAX_VALUE - 3;
            }
            noPostModel.status = 1;

            Set<String> postIds = new HashSet<>();
            for (int i = 0; i != array.size(); ++i) {
                JSONObject postObj = array.getJSONObject(i);
                int postStatus = postObj.getIntValue("status");
                if (postStatus == 2) {
                    continue;
                }
                String postId = postObj.getString("postId");
                postIds.add(postId);
                PPPostModel post = realm.where(PPPostModel.class)
                    .equalTo("postId", postId)
                    .findFirst();
                if (null == post) {
                    post = realm.createObject(PPPostModel.class, postId);
                }
                post.itemType = PPPostModel.POST_ITEM_TYPE_NORMAL;
                post.postType = postObj.getIntValue("postType");
                post.status = postStatus;
                post.communityId = postObj.getLongValue("communityId");
                post.locationId = postObj.getLongValue("locationId");
                post.creationDateMs = postObj.getLongValue("creationDateMs");
                post.title = postObj.getString("title");
                post.topic = postObj.getString("topic");
                post.driveUrl = postObj.getString("driveUrl");
                post.postText = postObj.getString("postText");
                post.allDay = postObj.getBooleanValue("allDay");
                post.eventDate = postObj.getString("eventDate");
                post.eventDateMs = postObj.getLongValue("eventDateMs");
                post.nextEventDate = postObj.getString("nextEventDate");
                post.eventEndDateMs = postObj.getLongValue("nextEventDateMs");
                post.duration = postObj.getLongValue("duration");
                post.eventEndDateMs = post.eventDateMs + post.duration * 1000;
                post.eventEndDate = dateFormat.format(new Date(post.eventEndDateMs));
                post.repeat = postObj.getString("repeat");
                post.repeatEndDate = postObj.getString("repeatEndDate");
                post.repeatEndDateMs = postObj.getLongValue("repeatEndDateMs");
                post.latitude = postObj.getDoubleValue("latitude");
                post.longitude = postObj.getDoubleValue("longitude");
                JSONObject userObj = postObj.getJSONObject("user");
                if (null != userObj) {
                    String userId = userObj.getString("id");
                    post.user = realm.where(PPPostUserModel.class)
                        .equalTo("id", userId)
                        .findFirst();
                    if (null == post.user) {
                        post.user = realm.createObject(PPPostUserModel.class, userId);
                    }
                    post.user.firstName = userObj.getString("firstName");
                    post.user.lastName = userObj.getString("lastName");
                    post.user.communityName = userObj.getString("communityName");
                    post.user.avatarFileId = userObj.getString("avatarFileId");
                }
                JSONObject addressObj = postObj.getJSONObject("address");
                if (null != addressObj) {
                    post.address = realm.createObject(PPPostAddressModel.class);
                    post.address.addrStreet1 = addressObj.getString("addrStreet1");
                    post.address.addrStreet2 = addressObj.getString("addrStreet2");
                    post.address.addrCity = addressObj.getString("addrCity");
                    JSONObject stateObj = addressObj.getJSONObject("state");
                    if (null != stateObj) {
                        post.address.stateId = stateObj.getString("id");
                    }
                    JSONObject countryObj = addressObj.getJSONObject("country");
                    if (null != countryObj) {
                        post.address.countryId = countryObj.getString("id");
                    }
                    post.address.zip = addressObj.getString("zip");
                }

                JSONObject locationObj = postObj.getJSONObject("location");
                if (null != locationObj) {
                    String locationId = locationObj.getString("id");
                    post.location = realm.where(PPPostLocationModel.class)
                        .equalTo("id", locationId)
                        .findFirst();
                    if (null == post.location) {
                        post.location = realm.createObject(PPPostLocationModel.class, locationId);
                    }
                    post.location.name = locationObj.getString("name");
                    post.location.latitude = locationObj.getString("latitude");
                    post.location.longitude = locationObj.getString("longitude");
                    JSONObject timezoneObj = locationObj.getJSONObject("timezone");
                    if (null != timezoneObj) {
                        String timezoneId = timezoneObj.getString("id");
                        post.location.timezone = realm.where(PPPostTimezoneModel.class)
                            .equalTo("id", timezoneId)
                            .findFirst();
                        if (null == post.location.timezone) {
                            post.location.timezone = realm.createObject(PPPostTimezoneModel.class, timezoneId);
                        }
                        post.location.timezone.name = timezoneObj.getString("name");
                        post.location.timezone.offset = timezoneObj.getIntValue("offset");
                        post.location.timezone.dst = timezoneObj.getBoolean("dst");
                    }
                }

                String locationId = PPAppCenter.m_SharedPresence.getLocationId();
                if (!TextUtils.isEmpty(locationId)) {
                    PPUserInformationLocationModel currentLocation = realm.where(PPUserInformationLocationModel.class)
                        .equalTo("id", Long.valueOf(locationId)).findFirst();
                    if (null != currentLocation) {
                        if (0d != post.latitude && 0d != post.longitude) {
                            int result = distance(currentLocation.dLatitude, currentLocation.dLongitude, post.latitude, post.longitude, 'M');
                            post.distance = String.format("%d miles away", 0 == result ? 1 : result);
                        } else if (null != post.location && !TextUtils.isEmpty(post.location.latitude)
                            && !TextUtils.isEmpty(post.location.longitude)) {
                            double latitude = Double.valueOf(post.location.latitude);
                            double longitude = Double.valueOf(post.location.longitude);
                            int result = distance(currentLocation.dLatitude, currentLocation.dLongitude, latitude, longitude, 'M');
                            if (result < 51) {
                                post.distance = String.format("%d miles away", 0 == result ? 1 : result);
                            }
                        }
                    }
                }
                JSONArray reminderArray = postObj.getJSONArray("reminders");
                post.reminders.deleteAllFromRealm();
                if (null != reminderArray && !reminderArray.isEmpty()) {
                    for (int j = 0; j != reminderArray.size(); ++j) {
                        JSONObject remindObj = reminderArray.getJSONObject(j);
                        PPPostReminderModel reminderModel = realm.createObject(PPPostReminderModel.class);
                        reminderModel.notificationText = remindObj.getString("notificationText");
                        if (remindObj.containsKey("notificationDateMs")) {
                            reminderModel.notificationDate = remindObj.getString("notificationDate");
                            reminderModel.notificationInterval = (post.eventDateMs - remindObj.getLongValue("notificationDateMs")) / 1000;
                        } else if (remindObj.containsKey("notificationInterval")) {
                            reminderModel.notificationInterval = remindObj.getLongValue("notificationInterval");
                        }
                        post.reminders.add(reminderModel);
                    }
                }
                JSONArray filesArray = postObj.getJSONArray("files");
                post.files.deleteAllFromRealm();
                if (null != filesArray && !filesArray.isEmpty()) {
                    for (int j = 0; j != filesArray.size(); ++j) {
                        JSONObject fileObj = filesArray.getJSONObject(j);
                        String fileId = fileObj.getString("id");
                        PPPostFileModel fileModel = realm.where(PPPostFileModel.class)
                            .equalTo("fileId", fileId)
                            .findFirst();
                        if (null == fileModel) {
                            fileModel = realm.createObject(PPPostFileModel.class, fileId);
                        }
                        fileModel.type = fileObj.getIntValue("type");
                        fileModel.contentType = fileObj.getString("contentType");
                        fileModel.contentUrl = fileObj.getString("contentUrl");
                        fileModel.ext = fileObj.getString("ext");
                        fileModel.duration = fileObj.getLongValue("duration");
                        fileModel.rotate = fileObj.getIntValue("rotate");
                        fileModel.size = fileObj.getLongValue("size");
                        fileModel.thumbnail = fileObj.getBooleanValue("thumbnail");
                        fileModel.m3u8 = fileObj.getBooleanValue("m3u8");
                        post.files.add(fileModel);
                    }
                }

                JSONArray reactionArray = postObj.getJSONArray("reactions");
                post.reactions.deleteAllFromRealm();
                if (null != reactionArray && !reactionArray.isEmpty()) {
                    for (int j = 0; j != reactionArray.size(); ++j) {
                        JSONObject reactionObj = reactionArray.getJSONObject(j);
                        PPPostReactionModel reactionModel = realm.createObject(PPPostReactionModel.class);
                        reactionModel.postId = postId;
                        reactionModel.reaction = reactionObj.getIntValue("reaction");
                        JSONObject reactUserObj = reactionObj.getJSONObject("user");
                        if (null != reactUserObj) {
                            String userId = reactUserObj.getString("id");
                            reactionModel.user = realm.where(PPPostUserModel.class)
                                .equalTo("id", userId)
                                .findFirst();
                            if (null == reactionModel.user) {
                                reactionModel.user = realm.createObject(PPPostUserModel.class, userId);
                            }
                            reactionModel.user.firstName = reactUserObj.getString("firstName");
                            reactionModel.user.lastName = reactUserObj.getString("lastName");
                            reactionModel.user.communityName = reactUserObj.getString("communityName");
                            reactionModel.user.avatarFileId = reactUserObj.getString("avatarFileId");
                        }
                        post.reactions.add(reactionModel);
                    }
                }

                JSONArray commentArray = postObj.getJSONArray("comments");
                post.comments.deleteAllFromRealm();
                if (null != commentArray && !commentArray.isEmpty()) {
                    for (int j = 0; j != commentArray.size(); ++j) {
                        JSONObject commentObj = commentArray.getJSONObject(j);
                        String commentId = commentObj.getString("commentId");
                        PPPostCommentModel commentModel = realm.where(PPPostCommentModel.class)
                            .equalTo("commentId", commentId)
                            .findFirst();
                        if (null == commentModel) {
                            commentModel = realm.createObject(PPPostCommentModel.class, commentId);
                        }
                        commentModel.postId = postId;
                        commentModel.replyCommentId = commentObj.getString("replyCommentId");
                        commentModel.commentDateMs = commentObj.getLongValue("commentDateMs");
                        commentModel.commentText = commentObj.getString("commentText");
                        JSONObject commentUserObj = commentObj.getJSONObject("user");
                        if (null != commentUserObj) {
                            String userId = commentUserObj.getString("id");
                            commentModel.user = realm.where(PPPostUserModel.class)
                                .equalTo("id", userId)
                                .findFirst();
                            if (null == commentModel.user) {
                                commentModel.user = realm.createObject(PPPostUserModel.class, userId);
                            }
                            commentModel.user.firstName = commentUserObj.getString("firstName");
                            commentModel.user.lastName = commentUserObj.getString("lastName");
                            commentModel.user.communityName = commentUserObj.getString("communityName");
                            commentModel.user.avatarFileId = commentUserObj.getString("avatarFileId");
                        }

                        JSONArray commentReactionArray = commentObj.getJSONArray("reactions");
                        commentModel.reactions.deleteAllFromRealm();
                        if (null != commentReactionArray && !commentReactionArray.isEmpty()) {
                            for (int k = 0; k != commentReactionArray.size(); ++k) {
                                JSONObject commentReactionObj = commentReactionArray.getJSONObject(k);
                                PPPostReactionModel commentReactionModel = realm.createObject(PPPostReactionModel.class);
                                commentReactionModel.postId = postId;
                                commentReactionModel.commentId = commentId;
                                commentReactionModel.reaction = commentReactionObj.getIntValue("reaction");
                                JSONObject commentReactUserObj = commentReactionObj.getJSONObject("user");
                                if (null != commentReactUserObj) {
                                    String userId = commentReactUserObj.getString("id");
                                    commentReactionModel.user = realm.where(PPPostUserModel.class)
                                        .equalTo("id", userId)
                                        .findFirst();
                                    if (null == commentReactionModel.user) {
                                        commentReactionModel.user = realm.createObject(PPPostUserModel.class, userId);
                                    }
                                    commentReactionModel.user.firstName = commentReactUserObj.getString("firstName");
                                    commentReactionModel.user.lastName = commentReactUserObj.getString("lastName");
                                    commentReactionModel.user.communityName = commentReactUserObj.getString("communityName");
                                    commentReactionModel.user.avatarFileId = commentReactUserObj.getString("avatarFileId");
                                    commentModel.reactions.add(commentReactionModel);
                                }
                            }
                        }
                        post.comments.add(commentModel);
                    }
                }
            }

            RealmResults<PPPostModel> posts = realm.where(PPPostModel.class)
                .equalTo("itemType", PPPostModel.POST_ITEM_TYPE_NORMAL)
                .findAll();
            if (!postIds.isEmpty() && fetchAllPost) {
                for (PPPostModel post : posts) {
                    if (!postIds.contains(post.postId) && 0 != post.status) {
                        post.deleteFromRealm();
                    }
                }
            }
            realm.commitTransaction();
            realm.close();
        }
        return true;
    }

    //https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
    private int distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (int) dist;
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
