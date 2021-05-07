/**
 * @FileName  : PPVirtuosoLogTrace.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.util;

import android.util.Log;

import java.util.IllegalFormatException;

/**
 * Common Log Trace for the Virtuoso SDK.
 */
public class PPVirtuosoLogTrace {
    public static boolean	m_bDebug = true;

    public static void setDebug( boolean bflag ) {
        m_bDebug = bflag;
    }

    public static void d(String strTag, String strMsg, Object... args ) {
        if( m_bDebug == false ) return;
        try {
            Log.d( strTag, (strMsg != null && args.length > 0) ? String.format(strMsg, args) : strMsg );
        } catch(IllegalFormatException e) {
            e.printStackTrace();
        }
    }

//    public static void i(String strTag, String strMsg, Object... args ) {
//        if( m_bDebug == false ) return;
//        try {
//            Log.i( strTag, (strMsg != null && args.length > 0) ? String.format(strMsg, args) : strMsg );
//        } catch(IllegalFormatException e) {
//            e.printStackTrace();
//        }
//    }

    public static void e(String strTag, String strMsg, Object... args ) {
        if( m_bDebug == false ) return;
        try {
            Log.e( strTag, (strMsg != null && args.length > 0) ? String.format(strMsg, args) : strMsg );
        } catch(IllegalFormatException e) {
            e.printStackTrace();
        }
    }

    public static void e(String strTag, String strMsg, Throwable thr ) {
        if( m_bDebug == false ) return;
        Log.e( strTag, strMsg, thr );
    }

//    public static void w(String strTag, String strMsg, Object... args ) {
//        if( m_bDebug == false ) return;
//        try {
//            Log.w( strTag, (strMsg != null && args.length > 0) ? String.format(strMsg, args) : strMsg );
//        } catch(IllegalFormatException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void v(String strTag, String strMsg, Object... args ) {
//        if( m_bDebug == false ) return;
//        try {
//            Log.v( strTag, (strMsg != null && args.length > 0) ? String.format(strMsg, args) : strMsg );
//        } catch(IllegalFormatException e) {
//            e.printStackTrace();
//        }
//    }
}
