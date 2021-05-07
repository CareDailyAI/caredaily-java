/**
 * @FileName : PPDeviceInfoModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.fonticon.PPFontIconLabel;
import com.peoplepowerco.virtuoso.interfaces.IPPRobotDefines;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceParameterModel;
import com.peoplepowerco.virtuoso.models.storybook.PPLocationSpaceModel;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief :  Device information model
 * @date : 2014. 5. 4.
 */
public class PPDeviceInfoModel {

    public String id;
    public String proxyId;
    public String icon;
    public long questionId;

    public int type;
    public int typeCategory;
    public int goalId = PPCommonInfo.PPInvalidValue;
    public int locationId;

    public String modelId;
    public String desc;
    public String sSecondaryDescription;
    public String sDeviceListIcon;
    public String sListTitle;

    public boolean connected = false;
    public boolean newDevice = false;
    public boolean shared = false;
    public boolean bEnableMultiSpaces = false;

    public String lastDataReceivedDate;
    public long lastDataReceivedDateMs;
    public String lastConnectedDate;
    public long lastConnectedDateMs;
    public String lastMeasureDate;
    public long lastMeasureDateMs;

    //Mockup cameras
    public boolean isMockupCamera = false;
    public String title;
    public String url;
    public String deviceId;
    public String remoteHost;
    public String auth;
    public String protocol;
    public int port;

    public List<PPLocationSpaceModel> spaces;
    private List<PPDeviceParameterInfoModel> m_DeviceParameters;

    public boolean bLocalCamera = false;
    public int iRobotType = IPPRobotDefines.PPRobotType.ROBOT_DISCONNECTED;
    public boolean bSeparator = false;

    public int itemType = TYPE_DEVICE_ITEM;

    public static final int TYPE_SECTION = 0;
    public static final int TYPE_DEVICE_ITEM = 1;


    public PPDeviceInfoModel() {
        this.id = PPUtil.NULL_STRING;
    }

    public PPDeviceInfoModel(boolean isMockupCamera) {
        this.id = PPUtil.NULL_STRING;
        this.isMockupCamera = isMockupCamera;
        if (isMockupCamera) {
            this.type = PPCommonInfo.INT_MOCKUP_CAMERA;
            this.sDeviceListIcon = PPFontIconLabel.ICON_CAMERA;
            this.connected = true;
        }
    }

    public PPDeviceInfoModel(String listTitle, boolean bHeader) {
        this.sListTitle = listTitle;
        this.bSeparator = bHeader;
        this.id = PPUtil.NULL_STRING;
        if (bHeader) {
            this.itemType = TYPE_SECTION;
        } else {
            this.itemType = TYPE_DEVICE_ITEM;
        }
    }


    public List<PPLocationSpaceModel> getDeviceSpaces() {
        return spaces;
    }

    public void setDeviceSpaces(List<PPLocationSpaceModel> spaces) {
        this.spaces = spaces;
    }

    public List<PPDeviceParameterInfoModel> getDeviceParameters() {
        return m_DeviceParameters;
    }

    public void addDeviceParameter(PPDeviceParameterInfoModel parameter) {
        if (m_DeviceParameters == null) {
            m_DeviceParameters = new ArrayList<>();
        }
        m_DeviceParameters.add(parameter);
    }

    public void addDeviceParameters(List<PPDeviceParameterModel> parameters) {
        if (m_DeviceParameters == null) {
            m_DeviceParameters = new ArrayList<>();
        } else {
            m_DeviceParameters.clear();
        }

        for (PPDeviceParameterModel parameter : parameters) {
            PPDeviceParameterInfoModel deviceParameter = new PPDeviceParameterInfoModel();
            deviceParameter.setName(parameter.getName());
            deviceParameter.setValue(parameter.getValue());
            deviceParameter.setIndex(parameter.getIndex());
            deviceParameter.setLastUpdatedTime(parameter.getLastUpdateTime());
            deviceParameter.setLastUpdatedTimeMS(parameter.getLastUpdateTimeMs());

            String name = parameter.getName();
            if (PPUtil.isEmpty(name)) {
                continue;
            }

            if (parameter.getName().equals("ppc.robotConnected")) {
                int iValue = Integer.parseInt(parameter.getValue());
                iRobotType = iValue;
            }

            PPSharedPreferences mPrefs = PPVirtuoso.getInstance().getPrefs();
            if (parameter.getName().equals("outletStatus")) {
                mPrefs.setDeviceStatusUpdatedTime("outletStatus", parameter.getLastUpdateTime());
            }
            if (parameter.getName().equals("motionStatus")) {
                mPrefs.setDeviceStatusUpdatedTime("motionStatus", parameter.getLastUpdateTime());
            }

            m_DeviceParameters.add(deviceParameter);
        }
    }
}
