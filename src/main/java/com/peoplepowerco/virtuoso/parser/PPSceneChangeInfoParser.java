/**
 * @FileName : PPSceneChangeInfoParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.models.PPFriendsInfoModel;
import com.peoplepowerco.virtuoso.models.PPSceneChangeModel;
import com.peoplepowerco.virtuoso.models.PPSceneChangeResultModel;
import com.peoplepowerco.virtuoso.models.PPSharedDeviceModel;
import com.peoplepowerco.virtuoso.util.PPUtil;

public class PPSceneChangeInfoParser implements PPBaseJsonParser {
    private PPSceneChangeResultModel m_SceneChangeResult;

    public PPSceneChangeInfoParser() {
    }

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONArray jaShared = null;
        JSONArray jaStop = null;
        JSONArray jaFriends = null;

        PPSceneChangeModel sharedDeviceEntry = null;

        try {
            m_SceneChangeResult = (PPSceneChangeResultModel) obj[0];

            //clear the previous results...
            m_SceneChangeResult.getSharedDevices().clear();
            m_SceneChangeResult.getStopSharingDevices().clear();

            jaShared = (jso.containsKey("sharedDevices")) ? jso.getJSONArray("sharedDevices") : null;

            //Do we have shared devices?
            if (jaShared != null) {

                int iDevices = jaShared.size();
                for (int deviceIdx = 0; deviceIdx < iDevices; deviceIdx++) {
                    sharedDeviceEntry = new PPSceneChangeModel();
                    JSONObject jsonDevice = jaShared.getJSONObject(deviceIdx);

                    //first set the device
                    PPSharedDeviceModel sharedDevice = new PPSharedDeviceModel();
                    sharedDeviceEntry.setSharedDevice(sharedDevice);

                    //id
                    sharedDevice.setDeviceID((jsonDevice.containsKey("id")) ? jsonDevice.getString("id") : PPUtil.NULL_STRING);
                    //type
                    sharedDevice.setType((jsonDevice.containsKey("type")) ? jsonDevice.getInteger("type") : 0);
                    //typeCategory
                    sharedDevice.setTypeCategory((jsonDevice.containsKey("typeCategory")) ? jsonDevice.getString("typeCategory") : PPUtil.NULL_STRING);
                    //desc
                    sharedDevice.setDescription((jsonDevice.containsKey("desc")) ? jsonDevice.getString("desc") : PPUtil.NULL_STRING);

                    //Now get the friends tied to this device
                    jaFriends = (jsonDevice.containsKey("friends")) ? jsonDevice.getJSONArray("friends") : null;
                    if (jaFriends != null) {
                        int iFriends = jaFriends.size();
                        for (int friendIdx = 0; friendIdx < iFriends; friendIdx++) {
                            PPFriendsInfoModel friendInfoModel = new PPFriendsInfoModel();
                            JSONObject jsonFriend = jaFriends.getJSONObject(friendIdx);

                            //user id
                            friendInfoModel.setUserID((jsonFriend.containsKey("id")) ? jsonFriend.getInteger("id") : 0);
                            //first name
                            friendInfoModel.setFirstName((jsonFriend.containsKey("firstName")) ? jsonFriend.getString("firstName") : PPUtil.NULL_STRING);
                            //last name
                            friendInfoModel.setLastName((jsonFriend.containsKey("lastName")) ? jsonFriend.getString("lastName") : PPUtil.NULL_STRING);

                            //Now let's grab email details
                            JSONObject jsonEmail = (jsonFriend.containsKey("email")) ? jsonFriend.getJSONObject("email") : null;
                            if (jsonEmail != null) {
                                //email
                                friendInfoModel.setEmail((jsonEmail.containsKey("email")) ? jsonEmail.getString("email") : PPUtil.NULL_STRING);
                                //verified
                                friendInfoModel.setEmailVerified((jsonEmail.containsKey("verified")) ? jsonEmail.getBoolean("verified") : false);
                                //status
                                friendInfoModel.setEmailStatus((jsonEmail.containsKey("status")) ? jsonEmail.getInteger("status") : 0);
                            }

                            //add this friend to the list for the current shared device
                            sharedDeviceEntry.addFriend(friendInfoModel);
                        }
                    }

                    //add the final shared device entry to the result holder
                    m_SceneChangeResult.addSharedDevice(sharedDeviceEntry);
                }
            }

            jaStop = (jso.containsKey("stopSharingDevices")) ? jso.getJSONArray("stopSharingDevices") : null;

            //Do we have stop sharing devices?
            if (jaStop != null) {

                int iDevices = jaStop.size();
                for (int deviceIdx = 0; deviceIdx < iDevices; deviceIdx++) {
                    sharedDeviceEntry = new PPSceneChangeModel();
                    JSONObject jsonDevice = jaStop.getJSONObject(deviceIdx);

                    //first set the device
                    PPSharedDeviceModel sharedDevice = new PPSharedDeviceModel();
                    sharedDeviceEntry.setSharedDevice(sharedDevice);

                    //id
                    sharedDevice.setDeviceID((jsonDevice.containsKey("id")) ? jsonDevice.getString("id") : PPUtil.NULL_STRING);
                    //type
                    sharedDevice.setType((jsonDevice.containsKey("type")) ? jsonDevice.getInteger("type") : 0);
                    //typeCategory
                    sharedDevice.setTypeCategory((jsonDevice.containsKey("typeCategory")) ? jsonDevice.getString("typeCategory") : PPUtil.NULL_STRING);
                    //desc
                    sharedDevice.setDescription((jsonDevice.containsKey("desc")) ? jsonDevice.getString("desc") : PPUtil.NULL_STRING);

                    //Now get the friends tied to this device
                    jaFriends = (jsonDevice.containsKey("friends")) ? jsonDevice.getJSONArray("friends") : null;
                    if (jaFriends != null) {
                        int iFriends = jaFriends.size();
                        for (int friendIdx = 0; friendIdx < iFriends; friendIdx++) {
                            PPFriendsInfoModel friendInfoModel = new PPFriendsInfoModel();
                            JSONObject jsonFriend = jaFriends.getJSONObject(friendIdx);

                            //user id
                            friendInfoModel.setUserID((jsonFriend.containsKey("id")) ? jsonFriend.getInteger("id") : 0);
                            //first name
                            friendInfoModel.setFirstName((jsonFriend.containsKey("firstName")) ? jsonFriend.getString("firstName") : PPUtil.NULL_STRING);
                            //last name
                            friendInfoModel.setLastName((jsonFriend.containsKey("lastName")) ? jsonFriend.getString("lastName") : PPUtil.NULL_STRING);

                            //Now let's grab email details
                            JSONObject jsonEmail = (jsonFriend.containsKey("email")) ? jsonFriend.getJSONObject("email") : null;
                            if (jsonEmail != null) {
                                //email
                                friendInfoModel.setEmail((jsonEmail.containsKey("email")) ? jsonEmail.getString("email") : PPUtil.NULL_STRING);
                                //verified
                                friendInfoModel.setEmailVerified((jsonEmail.containsKey("verified")) ? jsonEmail.getBoolean("verified") : false);
                                //status
                                friendInfoModel.setEmailStatus((jsonEmail.containsKey("status")) ? jsonEmail.getInteger("status") : 0);
                            }

                            //add this friend to the list for the current shared device
                            sharedDeviceEntry.addFriend(friendInfoModel);
                        }
                    }

                    //add the final shared device entry to the result holder
                    m_SceneChangeResult.addStopSharingDevice(sharedDeviceEntry);
                }
            }
            // Need to update the instance of ScenceChangeResult.
            PPUserManager.getInstance().setSceneChangeResult(m_SceneChangeResult);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }

        return false;
    }
}
