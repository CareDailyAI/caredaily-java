package com.peoplepowerco.virtuoso.models;

import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * @author : James Cho
 * @brief :
 * @date : 2016. 8. 17.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPRemoteControlDeviceViewModel {
    private String sDeviceId = null;
    private ToggleButton tbMotionDetection =null;
    private TextView tvRemoteCameraStatus = null;


    public String getDeviceId(){
        return sDeviceId;
    }

    public void setDeviceId(String deviceId){
        this.sDeviceId = deviceId;
    }

    public ToggleButton getTbMotionDetection(){
        return tbMotionDetection;
    }

    public void setTbMotionDetection(ToggleButton tbMotionDetection){
        this.tbMotionDetection = tbMotionDetection;
    }

    public TextView getsRemoteCameraStatus(){
        return tvRemoteCameraStatus;
    }

    public void setsRemoteCameraStatus(TextView remoteCameraStatus){
        this.tvRemoteCameraStatus = remoteCameraStatus;
    }
}
