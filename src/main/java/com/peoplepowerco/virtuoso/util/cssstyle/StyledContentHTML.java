package com.peoplepowerco.virtuoso.util.cssstyle;

import android.content.Context;
import androidx.core.content.ContextCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StyledContentHTML {

    public static String html(Context context, String fileName, String bodyHTML) {
        HashMap<String, String> content = new HashMap<String, String>();
        content.put("BODY", bodyHTML);
//        content.put("THEME-CSS", CSSBuilder.getCSSText(context));
        return populateTemplate(context, fileName, content);
    }

    public static String html(Context context, String fileName, String bodyHTML, int bodyColor, int bodyTextColor) {
        HashMap<String, String> content = new HashMap<>();
        content.put("BODY", bodyHTML);
        content.put("BODYCOLOR", "#" + Integer.toHexString(ContextCompat.getColor(context, bodyColor)).substring(2));
        content.put("BODYTEXTCOLOR", "#" + Integer.toHexString(ContextCompat.getColor(context, bodyTextColor)).substring(2));
        return populateTemplate(context, fileName, content);
    }

    public static String htmlAbout(Context context, String fileName, String VERSION, String attributionText, String attributions) {
        HashMap<String, String> content = new HashMap<String, String>();
        content.put("VERSION", VERSION);
        content.put("ATTRIBUTION", attributionText);
        content.put("ATTRIBUTIONS", attributions);
//        content.put("THEME-CSS", CSSBuilder.getCSSText(context));
        return populateTemplate(context, fileName, content);
    }

    public static String htmlAttribution(Context context, String fileName, String attribution) {
        HashMap<String, String> content = new HashMap<String, String>();
        content.put("ATTRIBUTION", attribution);
        return populateTemplate(context, fileName, content);
    }

    public static String htmlAttribution(Context context, String fileName, String attribution, int bodyColor, int bodyTextColor) {
        HashMap<String, String> content = new HashMap<>();
        content.put("ATTRIBUTION", attribution);
        content.put("ATTRIBUTIONCOLOR", "#" + Integer.toHexString(ContextCompat.getColor(context, bodyColor)).substring(2));
        content.put("ATTRIBUTIONTEXTCOLOR", "#" + Integer.toHexString(ContextCompat.getColor(context, bodyTextColor)).substring(2));
        return populateTemplate(context, fileName, content);
    }

    public static String populateTemplate(Context context, String html, Map<String, String> content) {
        String template = ResourceReader.readTextFromResource(context, html);
        return replaceTokens(template, content);
    }

    /*
     * Thanks to stack overflow for this code snippet
     * http://stackoverflow.com/questions/959731/how-to-replace-a-set-of-tokens-in-a-java-string
     */
    public static String replaceTokens(String template, Map<String, String> replacements) {
        Pattern pattern = Pattern.compile("__(.+?)__");
        Matcher matcher = pattern.matcher(template);

        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            String replacement = replacements.get(matcher.group(1));

            if (replacement != null) {
                matcher.appendReplacement(buffer, "");
                buffer.append(replacement);
            }
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
