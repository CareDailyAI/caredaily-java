package com.peoplepowerco.virtuoso.handlers;

import android.os.Bundle;
import android.os.Message;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import com.peoplepowerco.virtuoso.util.PPWeakHandler;

/**
 * Created by laghee on 1/11/18.
 */

public class PPDeviceIOResultHandler extends PPWeakHandler<IPPServerResultListener> implements IPPVirtuosoTypes {

    private static final String TAG = PPDeviceIOResultHandler.class.getSimpleName();
    public PPDeviceIOResultHandler(IPPServerResultListener owner) {
        super(owner);
    }

    @Override
    public void handleMessage(Message msg) {
        String sTag = null;
        IPPServerResultListener owner = getTheOwner();
        try {
            if((owner != null) && (!PPAppCenter.m_restartRequested)) {
                if(msg.peekData() != null) {
                    Bundle tagBun = msg.getData();
                    sTag = tagBun.getString("TAG");
                    PPVirtuosoLogTrace.d(TAG, "TAG DATA:" + sTag);
                }
                switch (msg.arg1) {
                    case RES_SUCCESS:
                        owner.onResultSuccess(msg.what, msg.arg1, msg.arg2, msg.obj, sTag);
                        PPVirtuosoLogTrace.d(TAG, "RES_SUCCESS!");
                        break;
                    default:
                        owner.onResultFailure(msg.what, msg.arg1, msg.arg2, msg.obj, sTag);
                        PPVirtuosoLogTrace.e(TAG, "FAIL ON SERVER CALL!");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            PPVirtuosoLogTrace.e(TAG, e.getLocalizedMessage());
        }
    }

}
