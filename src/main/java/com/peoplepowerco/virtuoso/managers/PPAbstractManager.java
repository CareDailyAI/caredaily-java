package com.peoplepowerco.virtuoso.managers;

import android.content.Context;
import android.os.Handler;

import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.handlers.PPServerResultHandler;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.network.PPCloudCallCommander;

import java.util.HashMap;

/**
 * Created by laghee on 8/18/16.
 */
public abstract class PPAbstractManager {
    //main commander for JSON communications with Server
    protected PPCloudCallCommander m_CloudCommander = null;

    //registered handlers...
    protected HashMap<String, Handler> m_Handlers = null;

    //context for owner application
    protected Context m_Context = null;

    protected void init(IPPServerResultListener listener) {
        m_CloudCommander = new PPCloudCallCommander(new PPServerResultHandler(listener));
        m_Handlers = new HashMap<>(2);
        m_Context = PPVirtuoso.getInstance().getContext();
    }

    protected void releaseBase() {
        m_CloudCommander.clear();
        m_CloudCommander.exit();
        m_CloudCommander = null;
        m_Handlers.clear();
        m_Handlers = null;
    }

    /**
     * Register a handler receive server friends responses.
     *
     * @param handlerToRegister
     * @param tag
     */
    public void registerHandler(Handler handlerToRegister, String tag) {
        if(m_Handlers !=null) {
            m_Handlers.put(tag, handlerToRegister);
        }
    }

    /**
     * Unregister a handler so it no longer receives server friends responses.
     *
     * @param tag
     */
    public void unregisterHandler(String tag) {
        if(m_Handlers !=null) {
            m_Handlers.remove(tag);
        }
    }

    protected void sendResultToListeners(int reqid, int arg1, int arg2, Object result, String tag) {
        if(tag == null) {
            for (Handler listener : m_Handlers.values()) {
                listener.obtainMessage(reqid, arg1, arg2, result).sendToTarget();
            }
        } else {
            Handler listener = m_Handlers.get(tag);
            if(listener != null) {
                listener.obtainMessage(reqid, arg1, arg2, result).sendToTarget();
            }
        }
    }
}
