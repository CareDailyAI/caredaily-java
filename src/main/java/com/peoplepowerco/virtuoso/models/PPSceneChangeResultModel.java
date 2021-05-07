/**
 * @FileName : PPSceneChangeResultModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;

import java.util.ArrayList;
import java.util.List;

/**
 * This model holds the final full parsed result of a server call to change the scene at a location.
 */
public class PPSceneChangeResultModel {
    private List<PPSceneChangeModel> m_SharedDevices = null;
    private List<PPSceneChangeModel> m_StopSharingDevices = null;

    /**
     * Constructor
     */
    public PPSceneChangeResultModel() {
        m_SharedDevices = new ArrayList<PPSceneChangeModel>();
        m_StopSharingDevices = new ArrayList<PPSceneChangeModel>();
    }

    /**
     * Add a shared device to this result.
     * @param device
     */
    public void addSharedDevice(PPSceneChangeModel device) {
        m_SharedDevices.add(device);
    }

    /**
     * Add a stop sharing device to this result.
     * @param device
     */
    public void addStopSharingDevice(PPSceneChangeModel device) {
        m_StopSharingDevices.add(device);
    }

    /**
     * Get the list of shared devices from the result.
     * @return
     */
    public List<PPSceneChangeModel> getSharedDevices() {
        return m_SharedDevices;
    }

    /**
     * Get the list of stop sharing devices from the result.
     * @return
     */
    public List<PPSceneChangeModel> getStopSharingDevices() {
        return m_StopSharingDevices;
    }
}
