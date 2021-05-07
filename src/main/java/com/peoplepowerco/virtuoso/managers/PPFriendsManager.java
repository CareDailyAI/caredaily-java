package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPFriendsInfoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laghee on 5/22/16.
 */
public class PPFriendsManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPFriendsManager.class.getSimpleName();
    private static PPFriendsManager instance = null;

    //list of friends for the active user
    private List<PPFriendsInfoModel> m_FriendsList = null;
    private PPFriendsInfoModel m_FriendProspect = null;

    //new members to handle selection and modification of a selected friend
    private int m_selectedFriendshipID = 0;
    private List<PPDeviceInfoModel> m_selectedDevices = null;

    /**
     * Hidden class constructor.
     */
    private PPFriendsManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     * @return
     */
    public static PPFriendsManager getInstance() {
        synchronized(PPFriendsManager.class) {
            if (instance == null) {
                instance = new PPFriendsManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_FriendProspect = new PPFriendsInfoModel();
        m_FriendsList = new ArrayList<PPFriendsInfoModel>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if(instance != null) {
            instance.releaseBase();
            instance.m_FriendsList.clear();
            instance.m_FriendsList = null;
            instance.m_FriendProspect = null;
            instance = null;
        }
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    /**
     * Set the selected friend for modification
     * @param friendshipID
     */
    public void setSelectedFriend(int friendshipID) {
        m_selectedFriendshipID = friendshipID;
    }

    /**
     * Get the selected friend for modification
     * @return
     */
    public PPFriendsInfoModel getSelectedFriend() {
        return getFriendByFriendshipID(m_selectedFriendshipID);
    }

    /**
     * Return a list of selected devices for possible sharing
     * with the currently selected friend.
     * @return
     */
    public List<PPDeviceInfoModel> getSelectedDevices() {
        if(m_selectedDevices == null) {
            initSelectedDevices();
        }
        return m_selectedDevices;
    }

    /**
     * Reset the list of selected devices.
     */
    public void resetSelectedDevices() {
        if (m_selectedDevices != null) {
            m_selectedDevices.clear();
        } else {
            initSelectedDevices();
        }
    }

    /**
     * Init selected devices for first time...
     */
    private void initSelectedDevices() {
        m_selectedDevices = new ArrayList<>(10);
    }

    /**
     * Add a device to the list of selected devices for
     * possible sharing with the selected friend.
     * @param device
     */
    public void addSelectedDevice(PPDeviceInfoModel device) {
        if((m_selectedDevices != null) && (!m_selectedDevices.contains(device))) {
            m_selectedDevices.add(device);
        }
    }

    public void removeSelectedDevice(PPDeviceInfoModel device) {
        if(m_selectedDevices != null) {
            m_selectedDevices.remove(device);
        }
    }

    public void removeAllSelectedDevice(){
        if(m_selectedDevices != null) {
            m_selectedDevices.clear();
        }
    }

    /**
     * Gets the current list of friends.
     * If the list is empty, a call to get friends will be made.
     * @return
     */
    public List<PPFriendsInfoModel> getFriendList() {
        return m_FriendsList;
    }

    /**
     * Looks to see if our current friends list contains any blocked friends.
     * It will return true upon the first encounter of a blocked friend.
     * @return
     */
    public boolean containsBlocked() {
        for(PPFriendsInfoModel friend : m_FriendsList) {
            if(friend.isBlocked()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a friend object by their email address.
     * @param email
     * @return
     */
    public PPFriendsInfoModel getFriendByEmail(String email) {
        for(PPFriendsInfoModel friend : m_FriendsList) {
            if(friend.getEmail().equals(email)) {
                return friend;
            }
        }
        return null;
    }

    /**
     * Get a friend object by their friendship ID.
     * @param friendshipID
     * @return
     */
    public PPFriendsInfoModel getFriendByFriendshipID(int friendshipID) {
        for(PPFriendsInfoModel friend : m_FriendsList) {
            if(friendshipID == friend.getFriendshipID()) {
                return friend;
            }
        }
        return null;
    }

    /**
     * Get the count of friends from current list.
     * Since we separators are included in this list, we ignore 3 entries.
     * @return
     */
    public int getFriendCount() {
        int count = m_FriendsList.size();
        if(count > 3) {
            count -= 3;
        } else {
            count = 0;
        }
        return count;
    }

    /**
     * Gets the current list of friends.(except separator)
     * If the list is empty, a call to get friends will be made.
     * @return
     */
    public List<PPFriendsInfoModel> getFriendListNoSeparator() {
        List<PPFriendsInfoModel> friendsList = new ArrayList<PPFriendsInfoModel>();

        for(PPFriendsInfoModel friend : m_FriendsList){
            if(!friend.isSeparator()){
                friendsList.add(friend);
            }
        }
        return friendsList;
    }

    /**
     * Gets the current friend prospect from the last
     * call to serverRequestGetFriendProspect.  This does
     * not make any server calls so its up to the user
     * to make the proper call and wait for a successful
     * return before calling this method to get the result.
     * @return
     */
    public PPFriendsInfoModel getCurrentProspect() {
        return m_FriendProspect;
    }

    /**
     * Make a server call to see if the provided email is a valid Presence user.
     * @param prospectEmail
     *
     * THIS IS A HIDDEN API
     * GET /users?email=email1
     *
     * {
     *  "resultCode": 0,
     *  "users": [
     *  {
     *   "id": 71,
     *   "firstName": "Dmitry",
     *   "lastName": "Shirkalin",
     *   "email": {
     *             "email": "dmitry@peoplepowerco.com",
     *             "verified": true,
     *             "status": 0
     *            }
     *  }]
     * }
     */
    public void serverRequestGetFriendProspect(String tag, String prospectEmail) {
        //set fields to a default state
        m_FriendProspect = new PPFriendsInfoModel();

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("email", prospectEmail);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_USER_BY_EMAIL, jsonObj, m_FriendProspect);
    }


    /**
     * Get list of friends from server.
     * http://docs.fabruxapps.apiary.io/#reference/friends/friends/get-friends
     */
    public void serverRequestGetFriends(String tag, String checkConnected) {
        if(m_FriendsList != null) {
            m_FriendsList.clear();
        }

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("checkConnected", checkConnected);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_FRIENDS, jsonObj, new Object[]{m_FriendsList});
    }

    /**
     * Add friend(s)
     * http://docs.fabruxapps.apiary.io/#reference/friends/friends/add-friends
     */
    public void serverRequestAddFriends(String tag, List<String> friendEmails) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsonObjFriends = new JSONObject();
        JSONArray jaFriends = new JSONArray();

        try {
            //convert friends to json array
            for(String email : friendEmails) {
                JSONObject emailObj = new JSONObject();
                emailObj.put("email", email);
                jaFriends.add(emailObj);
            }

            jsonObjFriends.put("friends", jaFriends);
            jsonObj.put("friendsObj", jsonObjFriends);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_ADD_FRIENDS, jsonObj);
    }

    /**
     * Delete a friend.
     * http://docs.fabruxapps.apiary.io/#reference/friends/manage-friends/delete-friendship
     */
    public void serverRequestDeleteFriendship(String tag, int friendshipID) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("friendshipId", friendshipID);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_FRIENDSHIP, jsonObj);
    }

//    /**
//     * Update a friendship with given values...
//     * http://docs.fabruxapps.apiary.io/#reference/friends/friends/update-friendship
//     */
//    public void serverRequestUpdateFriendship(PPFriendsInfoModel friend) {
//        JSONObject jsonObj = new JSONObject();
//        JSONObject jsonObjFriend = new JSONObject();
//        try {
//            jsonObjFriend.put("friend", friend.getFriendJSON());
//
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
//            jsonObj.put("friendshipID", friend.getFriendshipID());
//            jsonObj.put("friendObj", jsonObjFriend);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        m_parserMain.PutDataThreadPool(REQ_PUT_UPDATE_FRIEND, jsonObj);
//    }

    /**
     * Update a friendship with given values...
     * http://docs.fabruxapps.apiary.io/#reference/friends/friends/update-friendship
     */
    public void serverRequestUpdateFriendship(String tag, JSONObject jsonObj) {
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_FRIENDSHIP, jsonObj);
    }

    /**
     * Block or unblock a friendship. This is an ease of use method.
     * http://docs.fabruxapps.apiary.io/#reference/friends/update-friendship
     */
    public void serverRequestBlockFriendship(String tag, int friendshipID, boolean blocked) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsonObjFriend = new JSONObject();
        JSONObject jsonBlocked = new JSONObject();
        try {
            //created blocked entry
            jsonBlocked.put("blocked", blocked);

            jsonObjFriend.put("friend", jsonBlocked);

            jsonObj.put("friendshipId", friendshipID);
            jsonObj.put("friendObj", jsonObjFriend);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_FRIENDSHIP, jsonObj);
    }

    /**
     * Delete a shared device from a given friendship.
     * This is used to stop sharing ones own device with a friend.
     * http://docs.fabruxapps.apiary.io/#reference/friends/manage-shared-devices
     */
    public void serverRequestDeleteSharedDevice(String tag, int friendshipID, String deviceID) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("friendshipId", friendshipID);
            jsonObj.put("deviceId", deviceID);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_SHARED_DEVICE, jsonObj);
    }

//    /* FRIENDS */
//    // https://app.presencepro.com/cloud/json/friends
//    public static final short REQ_POST_ADD_FRIENDS                          = 290;
//
//    // https://app.presencepro.com/cloud/json/friends?friendshipId=friendshipId&deviceId=deviceId&checkConnected=checkConnected
//    public static final short REQ_GET_FRIENDS                               = 291;
//
//    // https://app.presencepro.com/cloud/json/friends/friendshipId
//    public static final short REQ_PUT_UPDATE_FRIENDSHIP                     = 292;
//
//    // https://app.presencepro.com/cloud/json/friends/friendshipId
//    public static final short REQ_DELETE_FRIENDSHIP                         = 293;
//
//    // https://app.presencepro.com/cloud/json/friends/friendshipId/devices/deviceId
//    public static final short REQ_DELETE_SHARED_DEVICE                      = 294;
}
