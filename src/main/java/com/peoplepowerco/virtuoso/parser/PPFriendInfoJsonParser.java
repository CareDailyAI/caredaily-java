/**
 * @FileName : PPFriendInfoJsonParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPFriendsInfoModel;
import com.peoplepowerco.virtuoso.models.PPSharedDeviceModel;
import com.peoplepowerco.virtuoso.util.PPUtil;

import java.util.ArrayList;
import java.util.List;

public class PPFriendInfoJsonParser implements PPBaseJsonParser {
    private List<PPFriendsInfoModel> m_FriendInfoList;

    public PPFriendInfoJsonParser()
    {
    }

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaFriends = null;
        JSONArray jaOwnDevices = null;
        JSONArray jaFriendDevices = null;

        PPFriendsInfoModel friendInfoModel = null;

        try
        {
            m_FriendInfoList = (ArrayList<PPFriendsInfoModel>)obj[0];

            jaFriends = (jso.containsKey("friends")) ? jso.getJSONArray("friends") : null;

            //first grab the top level friend info
            if(jaFriends != null) {

                m_FriendInfoList.clear();

                //take care of the 3 separators
                for(int idx = 0; idx < 3; idx++) {
                    PPFriendsInfoModel separator = new PPFriendsInfoModel();
                    separator.setAsSeparator(true);
                    separator.setSeparatorHeader(idx);
                    m_FriendInfoList.add(separator);
                }

                int iFriends = jaFriends.size();
                for(int friendsIdx = 0; friendsIdx < iFriends; friendsIdx++) {
                    friendInfoModel = new PPFriendsInfoModel();
                    JSONObject jsonFriends = jaFriends.getJSONObject(friendsIdx);

                    //friendship id
                    friendInfoModel.setFriendshipID((jsonFriends.containsKey("id")) ? jsonFriends.getInteger("id") : 0);
                    //email
                    friendInfoModel.setEmail((jsonFriends.containsKey("email")) ? jsonFriends.getString("email") : PPUtil.NULL_STRING);
                    //blocked
                    friendInfoModel.setBlocked((jsonFriends.containsKey("blocked")) ? jsonFriends.getBoolean("blocked") : false);

                    //Now let's grab the friends object
                    JSONObject jsonFriend = (jsonFriends.containsKey("friend")) ? jsonFriends.getJSONObject("friend") : null;
                    if(jsonFriend != null) {
                        friendInfoModel.setIsFriend(true);
                        //user id
                        friendInfoModel.setUserID((jsonFriend.containsKey("id")) ? jsonFriend.getInteger("id") : 0);
                        //first name
                        friendInfoModel.setFirstName((jsonFriend.containsKey("firstName")) ? jsonFriend.getString("firstName") : PPUtil.NULL_STRING);
                        //last name
                        friendInfoModel.setLastName((jsonFriend.containsKey("lastName")) ? jsonFriend.getString("lastName") : PPUtil.NULL_STRING);

                        //Now let's grab email details
                        JSONObject jsonEmail = (jsonFriend.containsKey("email")) ? jsonFriend.getJSONObject("email") : null;
                        if(jsonEmail != null) {
                            //email
                            friendInfoModel.setEmail((jsonEmail.containsKey("email")) ? jsonEmail.getString("email") : PPUtil.NULL_STRING);
                            //verified
                            friendInfoModel.setEmailVerified((jsonEmail.containsKey("verified")) ? jsonEmail.getBoolean("verified") : false);
                            //status
                            friendInfoModel.setEmailStatus((jsonEmail.containsKey("status")) ? jsonEmail.getInteger("status") : 0);
                        }
                    }

                    //Now let's get ownDevices array
                    jaOwnDevices = (jsonFriends.containsKey("ownDevices")) ? jsonFriends.getJSONArray("ownDevices") : null;
                    if(jaOwnDevices != null) {
                        friendInfoModel.m_OwnDevices = new ArrayList<PPSharedDeviceModel>(jaOwnDevices.size());
                        int iOwnDevices = jaOwnDevices.size();
                        for(int ownDeviceIdx = 0; ownDeviceIdx < iOwnDevices; ownDeviceIdx++) {
                            PPSharedDeviceModel ownDeviceModel = new PPSharedDeviceModel();
                            JSONObject jsonOwnDevice = jaOwnDevices.getJSONObject(ownDeviceIdx);

                            //id
                            ownDeviceModel.setDeviceID((jsonOwnDevice.containsKey("id")) ? jsonOwnDevice.getString("id") : PPUtil.NULL_STRING);
                            //type
                            ownDeviceModel.setType((jsonOwnDevice.containsKey("type")) ? jsonOwnDevice.getInteger("type") : 0);
                            //typeCategory
                            ownDeviceModel.setTypeCategory((jsonOwnDevice.containsKey("typeCategory")) ? jsonOwnDevice.getString("typeCategory") : PPUtil.NULL_STRING);
                            //desc
                            ownDeviceModel.setDescription((jsonOwnDevice.containsKey("desc")) ? jsonOwnDevice.getString("desc") : PPUtil.NULL_STRING);
                            //events
                            ownDeviceModel.setEvents((jsonOwnDevice.containsKey("events")) ? jsonOwnDevice.getString("events") : PPUtil.NULL_STRING);
                            //currentEvent
                            ownDeviceModel.setCurrentEvent((jsonOwnDevice.containsKey("currentEvent")) ? jsonOwnDevice.getString("currentEvent") : PPUtil.NULL_STRING);
                            //shared
                            ownDeviceModel.setShared((jsonOwnDevice.containsKey("shared")) ? jsonOwnDevice.getBoolean("shared") : false);
                            //mute
                            ownDeviceModel.setMute((jsonOwnDevice.containsKey("mute")) ? jsonOwnDevice.getBoolean("mute") : false);

                            friendInfoModel.m_OwnDevices.add(ownDeviceModel);
                        }
                    }

                    //Now let's get friendDevices array
                    jaFriendDevices = (jsonFriends.containsKey("friendDevices")) ? jsonFriends.getJSONArray("friendDevices") : null;
                    if(jaFriendDevices != null) {
                        friendInfoModel.m_FriendDevices = new ArrayList<PPSharedDeviceModel>(jaFriendDevices.size());
                        int iFriendDevices = jaFriendDevices.size();
                        for(int friendDeviceIdx = 0; friendDeviceIdx < iFriendDevices; friendDeviceIdx++) {
                            PPSharedDeviceModel friendDeviceModel = new PPSharedDeviceModel();
                            JSONObject jsonFriendDevice = jaFriendDevices.getJSONObject(friendDeviceIdx);

                            //id
                            friendDeviceModel.setDeviceID((jsonFriendDevice.containsKey("id")) ? jsonFriendDevice.getString("id") : PPUtil.NULL_STRING);
                            //type
                            friendDeviceModel.setType((jsonFriendDevice.containsKey("type")) ? jsonFriendDevice.getInteger("type") : 0);
                            //typeCategory
                            friendDeviceModel.setTypeCategory((jsonFriendDevice.containsKey("typeCategory")) ? jsonFriendDevice.getString("typeCategory") : PPUtil.NULL_STRING);
                            //desc
                            friendDeviceModel.setDescription((jsonFriendDevice.containsKey("desc")) ? jsonFriendDevice.getString("desc") : PPUtil.NULL_STRING);
                            //events
                            friendDeviceModel.setEvents((jsonFriendDevice.containsKey("events")) ? jsonFriendDevice.getString("events") : PPUtil.NULL_STRING);
                            //currentEvent
                            friendDeviceModel.setCurrentEvent((jsonFriendDevice.containsKey("currentEvent")) ? jsonFriendDevice.getString("currentEvent") : PPUtil.NULL_STRING);
                            friendInfoModel.setFriendEvent(friendDeviceModel.getCurrentEvent());
                            //shared
                            friendDeviceModel.setShared((jsonFriendDevice.containsKey("shared")) ? jsonFriendDevice.getBoolean("shared") : false);
                            //mute
                            friendDeviceModel.setMute((jsonFriendDevice.containsKey("mute")) ? jsonFriendDevice.getBoolean("mute") : false);
                            //connected
                            friendDeviceModel.setConnected((jsonFriendDevice.containsKey("connected")) ? jsonFriendDevice.getBoolean("connected") : false);

                            friendInfoModel.m_FriendDevices.add(friendDeviceModel);
                        }
                    }

                    m_FriendInfoList.add(friendInfoModel);
                }
            }

            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        catch (OutOfMemoryError ex)
        {
            Runtime.getRuntime().gc();
        }

        return false;
    }
}
