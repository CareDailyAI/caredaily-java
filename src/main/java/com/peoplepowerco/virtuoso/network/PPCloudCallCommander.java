/**
 * @FileName : PPCloudCallCommander.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.network;

import android.os.Handler;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.util.Vector;

/**
 * The Cloud Call Commander (CCC) will take care of pooling and sending calls to the Ensemble server(s).
 *
 * It will use a thread pool to take care of multiple calls simultaneously.
 *
 * It is expected that all calls will come from the "managers" and execution results will be returned via Handlers using a Message.
 */
public class PPCloudCallCommander implements IPPVirtuosoTypes {

    private static final String TAG = PPCloudCallCommander.class.getSimpleName();
    private Handler m_handler;
    //active tasks
    private Vector<PPEnsembleTask> m_vector = null;

    /**
     *
     */
    public PPCloudCallCommander(Handler handler) {
        this.m_handler = handler;
        m_vector = new Vector<>();
    }

    /**
     * Post Data to the server via thread pool.
     */
    public void PostDataThreadPool(int nID, JSONObject jsonObj, Object... args) {
        PPEnsembleTask m_serverTask = new PPEnsembleTask();

        m_serverTask.m_nReqID = nID;
        m_serverTask.m_jsonObjArgs = jsonObj;
        m_serverTask.m_bExit = false;
        m_serverTask.m_nLastError = PPHttpTransfer.ERROR_OK;
        m_serverTask.m_handler = m_handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "PostDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpTransfer.TRANS_POST);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(PPThreadPoolManager.getInstance().getExecutor());
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Get data from server via thread pool.
     */
    public void GetDataThreadPool(int nID, JSONObject jsonObj, Object... args) {
        PPEnsembleTask m_serverTask = new PPEnsembleTask();

        m_serverTask.m_nReqID = nID;
        m_serverTask.m_jsonObjArgs = jsonObj;
        m_serverTask.m_bExit = false;
        m_serverTask.m_nLastError = PPHttpTransfer.ERROR_OK;
        m_serverTask.m_handler = m_handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "GetDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpTransfer.TRANS_GET);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(PPThreadPoolManager.getInstance().getExecutor());
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Put data to the server via thread pool.
     */
    public void PutDataThreadPool(int nID, JSONObject jsonObj, Object... args) {
        PPEnsembleTask m_serverTask = new PPEnsembleTask();

        m_serverTask.m_nReqID = nID;
        m_serverTask.m_jsonObjArgs = jsonObj;
        m_serverTask.m_bExit = false;
        m_serverTask.m_nLastError = PPHttpTransfer.ERROR_OK;
        m_serverTask.m_handler = m_handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "PutDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpTransfer.TRANS_PUT);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(PPThreadPoolManager.getInstance().getExecutor());
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }

    /**
     * Delete data from the server via thread pool.
     */
    public void DeleteDataThreadPool(int nID, JSONObject jsonObj, Object... args) {
        PPEnsembleTask m_serverTask = new PPEnsembleTask();

        m_serverTask.m_nReqID = nID;
        m_serverTask.m_jsonObjArgs = jsonObj;
        m_serverTask.m_bExit = false;
        m_serverTask.m_nLastError = PPHttpTransfer.ERROR_OK;
        m_serverTask.m_handler = m_handler;
        m_serverTask.m_vector = m_vector;

        int nLen = args.length;
        m_serverTask.m_objList = new Object[nLen];
        for (int i = 0; i < nLen; ++i) {
            m_serverTask.m_objList[i] = args[i];
        }

        PPVirtuosoLogTrace.d(TAG, "DeleteDataThreadPool");
        m_serverTask.m_httpTransfer = new PPHttpTransfer();
        m_serverTask.m_httpTransfer.setTransMode(PPHttpTransfer.TRANS_DELETE);
        m_serverTask.m_httpTransfer.setContentType("application/json");

        m_serverTask.executeOnExecutor(PPThreadPoolManager.getInstance().getExecutor());
        m_vector.add(m_serverTask);
        PPVirtuosoLogTrace.e(TAG, "TaskCount = " + m_vector.size());
    }


    /**
     * Finish the server communication
     */
    public void exit() {
        for (PPEnsembleTask dt : m_vector) {
            if (dt.m_httpTransfer != null) {
                dt.m_bExit = true;
                dt.m_nLastError = PPHttpTransfer.ERROR_CANCEL;

                //dt.m_httpTransfer.exit(PPHttpTransfer.ERROR_CANCEL);

                if (!dt.isCancelled()) {
                    dt.cancel(true);
                }
            }
        }
    }

    public void clear() {
        allCancelDataTransTask();
        for (PPEnsembleTask dt : m_vector) {
            if (dt.m_httpTransfer != null) {
                dt.m_httpTransfer.clear();
            }
        }
    }

    public void allCancelDataTransTask() {
        for (PPEnsembleTask dt : m_vector) {
            dt.cancel(true);
            PPVirtuosoLogTrace.d(TAG, "Canceling Server task m_vector.size = " + m_vector.size());
        }
    }
}
