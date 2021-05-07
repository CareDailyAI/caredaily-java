package com.peoplepowerco.virtuoso.interfaces;

/**
 * Interface to be implemented by classes which handle server results.
 */
public interface IPPServerResultListener {
    void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag);
    void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag);
}
