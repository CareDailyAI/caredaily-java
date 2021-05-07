/**
 * @FileName  : PPCloudCallCommander.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.network;

import android.os.AsyncTask;
import android.os.Handler;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.Vector;

/**
 * The DeviceIO Call will take care of pooling and sending
 * calls to the DeviceIO server(s).
 *
 * It will use a thread pool to take care of multiple calls simultaneously.
 *
 * It is expected that all calls will come from the "managers" and execution results
 * will be returned via Handlers using a Message.
 */
public class PPDeviceIOApiCall {
    private static final String TAG = PPDeviceIOApiCall.class.getSimpleName();


    //active tasks
    private static Vector<PPDeviceIOTask> m_vector = new Vector<>();


    /**
     * Post Data to the server via thread pool.
     * @param nID
     * @param jsonObj
     */
    public static void PostDataThreadPool(int nID, Handler handler, JSONObject jsonObj, Object... args) {
        PPDeviceIOTask m_serverTask = new PPDeviceIOTask();

        m_serverTask.m_nReqID 			= nID;
        m_serverTask.m_jsonObjArgs 		= jsonObj;
        m_serverTask.m_bExit				= false;
        m_serverTask.m_nLastError 		= PPHttpDeviceIOTransfer.ERROR_OK;
        m_serverTask.m_handler = handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "PostDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpDeviceIOTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpDeviceIOTransfer.TRANS_POST);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Get data from server via thread pool.
     * @param nID
     * @param jsonObj
     */
    public static void GetDataThreadPool(int nID, Handler handler,JSONObject jsonObj, Object... args) {
        PPDeviceIOTask m_serverTask = new PPDeviceIOTask();

        m_serverTask.m_nReqID            = nID;
        m_serverTask.m_jsonObjArgs       = jsonObj;
        m_serverTask.m_bExit             = false;
        m_serverTask.m_nLastError        = PPHttpDeviceIOTransfer.ERROR_OK;
        m_serverTask.m_handler = handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "GetDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpDeviceIOTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpDeviceIOTransfer.TRANS_GET);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Put data to the server via thread pool.
     * @param nID
     * @param jsonObj
     */
    public void PutDataThreadPool(int nID, Handler handler, JSONObject jsonObj, Object... args) {
        PPDeviceIOTask m_serverTask = new PPDeviceIOTask();

        m_serverTask.m_nReqID            = nID;
        m_serverTask.m_jsonObjArgs       = jsonObj;
        m_serverTask.m_bExit             = false;
        m_serverTask.m_nLastError        = PPHttpDeviceIOTransfer.ERROR_OK;
        m_serverTask.m_handler = handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "PutDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpDeviceIOTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpDeviceIOTransfer.TRANS_PUT);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Delete data from the server via thread pool.
     * @param nID
     * @param jsonObj
     */
    public static void DeleteDataThreadPool(int nID, Handler handler, JSONObject jsonObj, Object... args) {
        PPDeviceIOTask m_serverTask = new PPDeviceIOTask();

        m_serverTask.m_nReqID            = nID;
        m_serverTask.m_jsonObjArgs       = jsonObj;
        m_serverTask.m_bExit             = false;
        m_serverTask.m_nLastError        = PPHttpDeviceIOTransfer.ERROR_OK;
        m_serverTask.m_handler = handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "DeleteDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpDeviceIOTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpDeviceIOTransfer.TRANS_DELETE);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }


    /**
     * Finish the server communication
     */
    public static void exit() {
        for(PPDeviceIOTask dt : m_vector) {
            if( dt.m_httpTransfer != null )
            {
                dt.m_bExit = true;
                dt.m_nLastError = PPHttpDeviceIOTransfer.ERROR_CANCEL;

                //dt.m_httpTransfer.exit(PPHttpDeviceIOTransfer.ERROR_CANCEL);

                if (!dt.isCancelled()) {
                    dt.cancel(true);
                }
            }
        }
    }

    public static void clear() {
        allCancelDataTransTask();
        for(PPDeviceIOTask dt : m_vector) {
            if(dt.m_httpTransfer != null) {
                dt.m_httpTransfer.clear();
            }
        }
    }

    public static void allCancelDataTransTask()
    {
        for(PPDeviceIOTask dt : m_vector) {
            dt.cancel(true);
            PPVirtuosoLogTrace.d(TAG, "Canceling Server task m_vector.size = " + m_vector.size());
        }
    }
}
