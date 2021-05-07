/**
 * @FileName : PPFriendsInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.managers.PPUserManager;
import com.peoplepowerco.virtuoso.util.PPUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Friends Information Model
 * This represents one record as there may be multiple friends
 * http://docs.fabruxapps.apiary.io/#reference/friends/friends/get-friends
 */
public class PPFriendsInfoModel {
    //3 possible list headers...
    public static final int HEADER_CURRENTLY_SHARING = 0;
    public static final int HEADER_FRIENDS_SHARING = 1;
    public static final int HEADER_SHARED_DEVICES = 2;
    public static final int HEADER_UNKNOWN = 3;

    private int iFriendshipID = 0;
    private int iUserID = 0;
    private String sFirstName = PPUtil.NULL_STRING;
    private String sLastName = PPUtil.NULL_STRING;
    private String sEmail = PPUtil.NULL_STRING;
    private String sFriendEvent = PPUtil.NULL_STRING;
    private boolean bEmailVerified = false;
    private int iEmailStatus = 0;
    private boolean bBlocked = false;
    private boolean isFriend = false;
    public List<PPSharedDeviceModel> m_OwnDevices = null;
    public List<PPSharedDeviceModel> m_FriendDevices = null;

    //since we need separators for the list, we need an identifier
    private boolean bSeparator = false;
    private int iSeparatorHeader = 0;
    private int iSeparatorEnd = 0;

    public int getSeparatorEnd() {
        return iSeparatorEnd;
    }

    public void setSeparatorEnd(int end) {
        iSeparatorEnd = end;
    }

    public void updateSeparatorEnd() {
        iSeparatorEnd++;
    }

    public int getSeparatorHeader() {
        return iSeparatorHeader;
    }

    public int getSeparatorHeaderResourceID() {
        int id = 0;
        switch (iSeparatorHeader) {
            case HEADER_CURRENTLY_SHARING:
                id = R.string.friends_im_sharing_with;
                break;
            case HEADER_FRIENDS_SHARING:
                id = R.string.friends_sharing_with_me;
                break;
            case HEADER_SHARED_DEVICES:
                id = R.string.friends;
                break;
            default:
                break;
        }
        return id;
    }

    /**
     * Checks if a given device is being shared with this friend.
     * Thus, this friend "can access" this device in one or more scenes.
     *
     * @param deviceID Device id of the device in question.
     * @return Returns true if the device is shared to this friend and false otherwise.
     */
    public boolean canAccessDevice(String deviceID) {
        if (m_OwnDevices != null) {
            for (PPSharedDeviceModel sharedDevice : m_OwnDevices) {
                if (deviceID.equals(sharedDevice.getDeviceID())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checkes to see if you are sharing anything with this friend on a given
     * scene event.
     *
     * @param scene
     * @param deviceID
     * @return
     */
    public boolean containsScene(String scene, String deviceID) {
        if (m_OwnDevices != null) {
            for (PPSharedDeviceModel sharedDevice : m_OwnDevices) {
                if (deviceID.equals(sharedDevice.getDeviceID())) {
                    if (sharedDevice.getEvents().contains(scene)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @param header
     */
    public void setSeparatorHeader(int header) {
        switch (header) {
            case HEADER_CURRENTLY_SHARING:
                iSeparatorHeader = HEADER_CURRENTLY_SHARING;
                break;
            case HEADER_FRIENDS_SHARING:
                iSeparatorHeader = HEADER_FRIENDS_SHARING;
                break;
            case HEADER_SHARED_DEVICES:
                iSeparatorHeader = HEADER_SHARED_DEVICES;
                break;
            default:
                iSeparatorHeader = HEADER_UNKNOWN;
                break;
        }
    }

    public void setAsSeparator(boolean separator) {
        bSeparator = separator;
    }

    public boolean isSeparator() {
        return bSeparator;
    }

    public JSONObject getFriendJSON() {
        JSONObject friend = new JSONObject();

        //create json object from this classes fields
        try {
            //TODO: BUILD ME!
            friend.put("stuff", "and more stuff");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return friend;
    }

    public boolean isCurrentlySharedTo() {
        boolean sharedTo = false;
        if (m_OwnDevices != null) {
            //check each entry to see if our current mode matches an event mode
            for (PPSharedDeviceModel sdm : m_OwnDevices) {
                if (sdm.isCurrentlySharedTo()) {
                    sharedTo = true;
                    break;
                }
            }
        }
        return sharedTo;
    }

    public boolean isCurrentlySharing() {
        boolean sharing = false;
        if (m_FriendDevices != null) {
            //check each entry to see if its current mode matches an event mode
            for (PPSharedDeviceModel sdm : m_FriendDevices) {
                if (sdm.isCurrentlySharedTo()) {
                    sharing = true;
                    break;
                }
            }
        }
        return sharing;
    }

    public String getFullName() {
        String fullName = sEmail;

        //do we have a real name?
        if (PPUtil.isEmpty(sFirstName) || PPUtil.isEmpty(sLastName)) {
            return sEmail;
        } else {
            return sFirstName + " " + sLastName;
        }
    }

    public String getSharedDevicesStatus(PPDeviceInfoModel sharedDevice) {
        StringBuilder sbFinal = new StringBuilder();
        StringBuilder sbModes = new StringBuilder();
        int lastIdx = 0;

        String sHome = PPAppCenter.m_Context.getString(R.string.rules_mode_home);
        String sAway = PPAppCenter.m_Context.getString(R.string.rules_mode_away);
        String sVacation = PPAppCenter.m_Context.getString(R.string.rules_mode_vacation);
        String sSleep = PPAppCenter.m_Context.getString(R.string.rules_mode_sleep);
        String sStay = PPAppCenter.m_Context.getString(R.string.rules_mode_stay);

        String ssHome = PPAppCenter.m_Context.getString(R.string.mode_home_readable);
        String ssAway = PPAppCenter.m_Context.getString(R.string.mode_away_readable);
        String ssVacation = PPAppCenter.m_Context.getString(R.string.mode_vacation_readabale);
        String ssSleep = PPAppCenter.m_Context.getString(R.string.mode_sleep_readable);
        String ssStay = PPAppCenter.m_Context.getString(R.string.mode_stay_readable);

        if (m_OwnDevices != null) {
            //check each entry to see if our current mode matches an event mode
            for (PPSharedDeviceModel sdm : m_OwnDevices) {
                if (sdm.getDeviceID().equals(sharedDevice.id)) {
                    String events = sdm.getEvents();
                    if (events != null) {
                        String[] eventArray = events.split(",");
                        for (int i = 0; i < eventArray.length; i++) {
                            if (eventArray[i].equalsIgnoreCase(sHome)) {
                                eventArray[i] = ssHome;
                            } else if (eventArray[i].equalsIgnoreCase(sAway)) {
                                eventArray[i] = ssAway;
                            } else if (eventArray[i].equalsIgnoreCase(sVacation)) {
                                eventArray[i] = ssVacation;
                            } else if (eventArray[i].equalsIgnoreCase(sSleep)) {
                                eventArray[i] = ssSleep;
                            } else if (eventArray[i].equalsIgnoreCase(sStay)) {
                                eventArray[i] = ssStay;
                            }
                            if (i > 0) {
                                sbModes.append(",");
                            }
                            sbModes.append(eventArray[i]);
                        }
                    }
                    lastIdx = sbModes.lastIndexOf(",");
                    if (lastIdx > 0) {
                        sbModes.replace(lastIdx, lastIdx + 1, " " + PPAppCenter.m_Context.getString(R.string.friend_share_mode_and));
                    }
                    break;
                }
            }
        }

        //build final string
        if (lastIdx > 0) {
            //multiple modes
            sbFinal.append(PPAppCenter.m_Context.getString(R.string.in_n_modes, sbModes.toString()));
        } else {
            //one mode
            sbFinal.append(PPAppCenter.m_Context.getString(R.string.in_one_mode, sbModes.toString()));
        }

        return sbFinal.toString();
    }

    /**
     * Puts together a string containing modes which are shared in to this friend.
     *
     * @return
     */
    private String getCurrentSharingModes() {
        StringBuilder sbFinal = new StringBuilder();
        StringBuilder sbModes = new StringBuilder();
        boolean bHome = false;
        boolean bAway = false;
        boolean bVacation = false;
        boolean bSleep = false;
        String sHome = PPAppCenter.m_Context.getString(R.string.rules_mode_home);
        String sAway = PPAppCenter.m_Context.getString(R.string.rules_mode_away);
        String sVacation = PPAppCenter.m_Context.getString(R.string.rules_mode_vacation);
        String sSleep = PPAppCenter.m_Context.getString(R.string.rules_mode_sleep);
        String sStay = PPAppCenter.m_Context.getString(R.string.rules_mode_stay);

        String ssHome = PPAppCenter.m_Context.getString(R.string.mode_home_readable);
        String ssAway = PPAppCenter.m_Context.getString(R.string.mode_away_readable);
        String ssVacation = PPAppCenter.m_Context.getString(R.string.mode_vacation_readabale);
        String ssSleep = PPAppCenter.m_Context.getString(R.string.mode_sleep_readable);
        String ssStay = PPAppCenter.m_Context.getString(R.string.mode_stay_readable);

        List<String> modeList = new ArrayList<>(4);
        int iModes = 0;

        if (m_OwnDevices != null) {
            //check each entry to see if our current mode matches an event mode
            for (PPSharedDeviceModel sdm : m_OwnDevices) {
                String events = sdm.getEvents();
                if (!bHome) {
                    if (events.contains(sHome)) {
                        bHome = true;
                        iModes++;
                    }
                }
                if (!bAway) {
                    if (events.contains(sAway)) {
                        bAway = true;
                        iModes++;
                    }
                }
                if (!bVacation) {
                    if (events.contains(sVacation)) {
                        bVacation = true;
                        iModes++;
                    }
                }
                if (!bSleep) {
                    if (events.contains(sSleep)) {
                        bSleep = true;
                        iModes++;
                    }
                }

                if (iModes >= 4) {
                    break;
                }
            }
        }

        //now build just the modes portion of the string...
        int index = iModes;
        if (bHome) {
            sbModes.append(ssHome);
            if (index > 1) {
                if (index == 2) {
                    sbModes.append(" ");
                    sbModes.append(PPAppCenter.m_Context.getString(R.string.friend_share_mode_and));
                    sbModes.append(" ");
                } else {
                    sbModes.append(", ");
                }
            }
            index--;
        }
        if (bAway) {
            sbModes.append(ssAway);
            if (index > 1) {
                if (index == 2) {
                    sbModes.append(" ");
                    sbModes.append(PPAppCenter.m_Context.getString(R.string.friend_share_mode_and));
                    sbModes.append(" ");
                } else {
                    sbModes.append(", ");
                }
            }
            index--;
        }
        if (bVacation) {
            sbModes.append(ssVacation);
            if (index > 1) {
                sbModes.append(" ");
                sbModes.append(PPAppCenter.m_Context.getString(R.string.friend_share_mode_and));
                sbModes.append(" ");
            }
        }
        if (bSleep) {
            sbModes.append(ssSleep);
        }


        //now place the modes inside the final string
        if (iModes == 1) {
            //sharing_in_one_mode
            sbFinal.append(PPAppCenter.m_Context.getString(R.string.sharing_in_one_mode, sbModes.toString()));
        } else {
            //sharing_in_n_modes
            sbFinal.append(PPAppCenter.m_Context.getString(R.string.sharing_in_n_modes, sbModes.toString()));
        }

        return sbFinal.toString();
    }

    /**
     * Gets the status line for your shared devices to this friend.
     *
     * @return Returns a string containing the count of devices you share to this friend.
     */
    public String getOwnDevicesStatus() {
        String status = PPAppCenter.m_Context.getString(R.string.friends_invitation_sent);
        int count = getOwnDevicesCount();

        if (isFriend) {
            if (count > 0) {
                if (count == 1) {
                    if (isCurrentlySharedTo()) {
                        status = PPAppCenter.m_Context.getString(R.string.friends_can_access_one_device);
                    } else {
                        status = getCurrentSharingModes();
                    }
                } else {
                    if (isCurrentlySharedTo()) {
                        status = PPAppCenter.m_Context.getString(R.string.friends_can_access_n_devices, count);
                    } else {
                        status = getCurrentSharingModes();
                    }
                }
            } else {
                status = PPAppCenter.m_Context.getString(R.string.friends_nothing_shared);
            }
        }

        return status;
    }

    public int getOwnDevicesCount() {
        int count = 0;

        if (m_OwnDevices != null) {
            count = m_OwnDevices.size();
        }

        return count;
    }

    /**
     * Gets the status line for a friends shared devices.
     * Note: If nothing is shared, this should not get called.
     * By default, one shared device will be returned.
     *
     * @return Returns a string containing the count of this friends shared devices.
     */
    public String getFriendDevicesStatus() {
        StringBuilder sbStatus = new StringBuilder();
        String status = PPAppCenter.m_Context.getString(R.string.friend_not_currently_sharing);
        if (!sFriendEvent.isEmpty()) {
            String sMode = PPUserManager.getInstance().getModeString(sFriendEvent);
            sbStatus.append(PPAppCenter.m_Context.getString(R.string.friend_sharing_with_me_status, sMode));
            sbStatus.append(" ");

            int iCount = 0;

            if (m_FriendDevices != null) {
                //check each entry to see if its current mode matches an event mode
                for (PPSharedDeviceModel sdm : m_FriendDevices) {
                    if (sdm.isCurrentlySharedTo()) {
                        iCount++;
                    }
                }
            }

            if (iCount == 1) {
                //singular device
                sbStatus.append(PPAppCenter.m_Context.getString(R.string.friends_sharing_one_device));
            } else if (iCount > 1) {
                //multiple devices
                sbStatus.append(PPAppCenter.m_Context.getString(R.string.friends_sharing_n_devices, iCount));
            } else {
                //nothing shared
                sbStatus.append(status);
            }

            //finalize string to return
            status = sbStatus.toString();
        }

        return status;
    }

    public int getFriendDevicesCount() {
        int count = 0;

        if (m_FriendDevices != null) {
            count = m_FriendDevices.size();
        }

        return count;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isMyFriend) {
        isFriend = isMyFriend;
    }

    public int getFriendshipID() {
        return iFriendshipID;
    }

    public void setFriendshipID(int friendshipID) {
        iFriendshipID = friendshipID;
    }

    public int getUserID() {
        return iUserID;
    }

    public void setUserID(int userID) {
        iUserID = userID;
    }

    public String getFirstName() {
        return sFirstName;
    }

    public void setFirstName(String firstName) {
        sFirstName = firstName;
    }

    public String getsFriendEvent() {
        return sFriendEvent;
    }

    public void setFriendEvent(String event) {
        sFriendEvent = event;
    }

    public String getLastName() {
        return sLastName;
    }

    public void setLastName(String lastName) {
        sLastName = lastName;
    }

    public String getEmail() {
        return sEmail;
    }

    public void setEmail(String email) {
        sEmail = email;
    }

    public boolean isEmailVerified() {
        return bEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        bEmailVerified = emailVerified;
    }

    public int getEmailStatus() {
        return iEmailStatus;
    }

    public void setEmailStatus(int emailStatus) {
        iEmailStatus = emailStatus;
    }

    public boolean isBlocked() {
        return bBlocked;
    }

    public void setBlocked(boolean blocked) {
        bBlocked = blocked;
    }
}
