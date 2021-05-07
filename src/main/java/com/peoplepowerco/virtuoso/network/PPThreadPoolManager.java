package com.peoplepowerco.virtuoso.network;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PPThreadPoolManager {

    private Executor mExecutor;
    private static PPThreadPoolManager sInstance;

    public static PPThreadPoolManager getInstance() {
        synchronized (PPThreadPoolManager.class) {
            if (sInstance == null) {
                sInstance = new PPThreadPoolManager();
            }
        }
        return sInstance;
    }

    private PPThreadPoolManager() {
        mExecutor = Executors.newFixedThreadPool(10);
    }

    public Executor getExecutor() {
        return mExecutor;
    }

    public void init() {
    }
}
