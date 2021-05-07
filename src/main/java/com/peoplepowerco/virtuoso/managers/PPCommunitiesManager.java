package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.communities.PPPostModel;

public class PPCommunitiesManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {

    private static PPCommunitiesManager instance = null;

    private PPCommunitiesManager() {
        init();
    }

    private void init() {
        init(this);
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPCommunitiesManager getInstance() {
        synchronized (PPCommunitiesManager.class) {
            if (instance == null) {
                instance = new PPCommunitiesManager();
            }
        }
        return instance;
    }

    //https://app.presencepro.com/cloud/json/communityPosts?postId=&postType=&locationId=&communityId=&startDate=&endDate=
    public void requestGetPosts(String tag, String postId, String postType, String locationId, String communityId) {
        JSONObject jsonObj = new JSONObject();
        if (null != postId) {
            jsonObj.put("postId", postId);
        }
        if (null != postType) {
            jsonObj.put("postType", postType);
        }
        if (null != locationId) {
            jsonObj.put("locationId", locationId);
        }
        if (null != communityId) {
            jsonObj.put("communityId", communityId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_COMMUNITY_POSTS, jsonObj, null == postId ? true : false);
    }

    public void requestGetPostFileUrl(String tag, String postId, String fileId) {
        JSONObject jsonObj = new JSONObject();
        if (null != postId) {
            jsonObj.put("postId", postId);
        }
        if (null != fileId) {
            jsonObj.put("fileId", fileId);
        }
        jsonObj.put("TAG", tag);
        m_CloudCommander.GetDataThreadPool(REQ_GET_POST_FILE_URL, jsonObj, postId);
    }

    public void requestDeleteFile(String tag, String postId, String fileId) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("postId", postId);
        jsonObj.put("fileId", fileId);
        jsonObj.put("TAG", tag);
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_POST_FILE, jsonObj);
    }

    public void requestCreatePost(String tag, String postJson, boolean notification) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("data", postJson);
        jsonObj.put("notification", notification);
        jsonObj.put("TAG", tag);
        m_CloudCommander.PostDataThreadPool(REQ_CREATE_COMMUNITY_POST, jsonObj);
    }

    public void requestUpdatePost(String tag, PPPostModel post) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("data", post.updateJsonData());
        jsonObj.put("TAG", tag);
        jsonObj.put("postId", post.postId);
        m_CloudCommander.PutDataThreadPool(REQ_UPDATE_COMMUNITY_POST, jsonObj);
    }

    public void requestDeletePost(String tag, String postId) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("postId", postId);
        jsonObj.put("TAG", tag);
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_COMMUNITY_POST, jsonObj);
    }

    public void requestCreateComment(String tag, String postId, String commentId, String replyCommentId, String commentJson) {
        JSONObject jsonObj = new JSONObject();
        if (null != postId) {
            jsonObj.put("postId", postId);
        }
        if (null != commentId) {
            jsonObj.put("commentId", commentId);
        }
        if (null != replyCommentId) {
            jsonObj.put("replyCommentId", replyCommentId);
        }
        jsonObj.put("data", commentJson);
        jsonObj.put("TAG", tag);
        m_CloudCommander.PostDataThreadPool(REQ_CREATE_COMMUNITY_COMMENT, jsonObj);
    }

    public void requestDeleteComment(String tag, String postId, String commentId) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("postId", postId);
        jsonObj.put("commentId", commentId);
        jsonObj.put("TAG", tag);
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_COMMUNITY_COMMENT, jsonObj);
    }

    public void requestCreateReaction(String tag, String postId, String commentId, int reaction) {
        JSONObject jsonObj = new JSONObject();
        if (null != postId) {
            jsonObj.put("postId", postId);
        }
        if (null != commentId) {
            jsonObj.put("commentId", commentId);
        }
        jsonObj.put("reaction", reaction);
        jsonObj.put("TAG", tag);
        m_CloudCommander.PutDataThreadPool(REQ_CREATE_COMMUNITY_REACTION, jsonObj);
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }
}
