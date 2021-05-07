package com.peoplepowerco.virtuoso.util.cssstyle;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.TextAppearanceSpan;

public class CSSBuilder {

    private static String sCSSText;

    public static String getCSSText(Context context) {
        return sCSSText;
    }

    private static String colorRule(int color) {
        return "color: rgb(" + Color.red(color) + "," + Color.green(color) + "," + Color.blue(color) + ");";
    }

    /*
     * This is a bit of hack, but didn't have the time to find a better way
     *
     */
    private static float sDensity = -1;

    public static String getCSSStyle(Context context, int styleResourceId, String cssSelector) {
        if (sDensity < 0) {
            sDensity = context.getResources().getDisplayMetrics().density;
        }

        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(context, styleResourceId);

        String textStyle = null;
        boolean isBold = false;
        if (textAppearanceSpan.getTextStyle() > 0) {
            switch (textAppearanceSpan.getTextStyle()) {
                case Typeface.BOLD_ITALIC:
                    isBold = true;
                    textStyle = "italic";
                    break;
                case Typeface.BOLD:
                    isBold = true;
                    break;
                case Typeface.ITALIC:
                    textStyle = "italic";
                    break;
                case Typeface.NORMAL:
                    textStyle = "normal";
                    break;
            }
        }

        String cssStyle = cssSelector + " ";
        cssStyle += "{ font-family: " + textAppearanceSpan.getFamily() + "; ";
        if (textStyle != null) {
            cssStyle += "font-style: " + textStyle + "; ";
        }
        if (isBold) {
            cssStyle += "font-weight: bold; ";
        }

        int textSize = textAppearanceSpan.getTextSize();
        if (textSize > 0) {
            // size in pixels
            float textSizeInPixels = ((float) textSize) / sDensity;
            int textSizeInPixelsRounded = Math.round(textSizeInPixels);
            cssStyle += "font-size: " + textSizeInPixelsRounded + "px; ";
        }

        ColorStateList textColorStateList = textAppearanceSpan.getTextColor();
        if (textColorStateList != null) {
            int textColor = textColorStateList.getDefaultColor();
            cssStyle += colorRule(textColor);
        }
        cssStyle += "}\n";

        ColorStateList linkTextColorStateList = textAppearanceSpan.getLinkTextColor();
        if (linkTextColorStateList != null) {
            int textColor = linkTextColorStateList.getDefaultColor();
            cssStyle += cssSelector + " a {";
            cssStyle += colorRule(textColor);
            cssStyle += "}\n";
        }

        return cssStyle;
    }
}