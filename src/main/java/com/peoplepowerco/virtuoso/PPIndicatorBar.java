package com.peoplepowerco.virtuoso;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.peoplepowerco.virtuoso.util.PPUtil;

public class PPIndicatorBar extends LinearLayout {

    public PPIndicatorBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setIndicators(int count) {
        removeAllViews();
        for (int i = 0; i != count; ++i) {
            ImageView iv = new ImageView(getContext());
            LayoutParams lp = new LayoutParams(PPUtil.dip2px(getContext(), 6),
                    PPUtil.dip2px(getContext(), 6));
            if (i != 0) {
                lp.leftMargin = PPUtil.dip2px(getContext(), 5);
            } else {
                iv.setSelected(true);
            }
            iv.setLayoutParams(lp);
            iv.setImageResource(R.drawable.indicator_bg);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            addView(iv);
        }
        requestLayout();
    }

    public void setCurrentIndicator(int index) {
        for (int i = 0; i != getChildCount(); ++i) {
            if (i != index) {
                getChildAt(i).setSelected(false);
            } else {
                getChildAt(i).setSelected(true);
            }
        }
    }
}