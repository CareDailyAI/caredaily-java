/**
 * @FileName : PPSceneChangeModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This model will be used to hold an array entry of the result of a server call to change scenes.
 */
public class PPSceneChangeModel {
    private PPSharedDeviceModel m_SharedDevice = null;
    private List<PPFriendsInfoModel> m_Friends = null;

    public PPSceneChangeModel() {
        m_Friends = new ArrayList<PPFriendsInfoModel>(5);
    }

    public void setSharedDevice(PPSharedDeviceModel device) {
        m_SharedDevice = device;
    }

    public PPSharedDeviceModel getSharedDevice() {
        return m_SharedDevice;
    }

    public void addFriend(PPFriendsInfoModel friend) {
        m_Friends.add(friend);
    }

    public List<PPFriendsInfoModel> getFriends() {
        return m_Friends;
    }
}
