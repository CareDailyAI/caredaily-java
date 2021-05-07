/**
 * @FileName : PPWeakHandler.java
 * @Project : Virtuoso
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.util;

import android.os.Handler;

import java.lang.ref.WeakReference;

public abstract class PPWeakHandler<T> extends Handler {

    private WeakReference<T> mTheOwner;

    public PPWeakHandler(T owner) {
        mTheOwner = new WeakReference<T>(owner);
    }

    public T getTheOwner() {
        return mTheOwner.get();
    }
}
