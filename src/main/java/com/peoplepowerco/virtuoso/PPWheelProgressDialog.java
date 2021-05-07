/**
 * PPWheelProgressDialog.java Presence Pro
 * <p>
 * Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;

/**
 * @author : James Cho Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Common process wheel.
 * @date : 2014. 2. 9.
 */
public class PPWheelProgressDialog extends Dialog {


    /**
     * Dialog Contructor
     */
    public PPWheelProgressDialog(Context context) {
        super(context, R.style.TransDialog);
    }

    public static PPWheelProgressDialog show(Context context, CharSequence title) {
        return show(context, title, false);
    }

    public static PPWheelProgressDialog show(Context context, CharSequence title, boolean cancelable) {
        return show(context, title, cancelable, null);
    }

    /**
     * wheel progress dialog (can cancel using back key)
     */
    public static PPWheelProgressDialog show(Context context, CharSequence title, boolean cancelable, OnCancelListener cancelListener) {
        PPWheelProgressDialog dialog = null;
        try {
            dialog = new PPWheelProgressDialog(context);
//            dialog.setTitle(title);
            dialog.setCancelable(cancelable);
            dialog.setOnCancelListener(cancelListener);
            dialog.addContentView(new ProgressBar(context), new LayoutParams(PPCommonInfo.dipToPix(context, 40), PPCommonInfo.dipToPix(context, 40)));
            dialog.setOnKeyListener(new Dialog.OnKeyListener() {

                @Override
                public boolean onKey(DialogInterface dialog, int keyCode,
                    KeyEvent event) {
                    // TODO Auto-generated method stub
                    //User can dismiss the loading wheel only back key.
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        dialog.dismiss();
                    }
                    return false;
                }
            });
            dialog.show();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return dialog;
    }

}
