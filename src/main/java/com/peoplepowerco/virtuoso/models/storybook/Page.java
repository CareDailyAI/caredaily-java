package com.peoplepowerco.virtuoso.models.storybook;

import android.os.Build;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Page implements Serializable {

    private static final long serialVersionUID = -7244872742883784985L;
    private Integer index;
    private Boolean hidden;
    private Boolean dismissible;
    private String subtitle;
    private String desc;
    private String style;
    private String content;
    private Integer actionType = PPCommonInfo.ACTION_TYPE_LINK_NONE;
    private Integer actionStyle = 0;
    private String actionStoryId;
    private String actionDesc;
    private List<Action> actions;
    private List<Medium> media = null;
    private String htmlContent;
    private String htmlSubContent;
    private String faqHtmlContent;
    public boolean isExpand = false;
    public String modelId;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getDismissible() {
        return dismissible;
    }

    public void setDismissible(Boolean dismissible) {
        this.dismissible = dismissible;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Integer getActionStyle() {
        return actionStyle;
    }

    public void setActionStyle(Integer actionStyle) {
        this.actionStyle = actionStyle;
    }

    public String getActionStoryId() {
        return actionStoryId;
    }

    public void setActionStoryId(String actionStoryId) {
        this.actionStoryId = actionStoryId;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public List<Medium> getMedia() {
        return media;
    }

    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    public String getHtmlSubContent() {
        StringBuilder builder = new StringBuilder();
        if (null == htmlSubContent && null != content) {
            Pattern pattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)");
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("<a href=\\\"$2\\\">$1</a>");
            content = content.replaceAll("\\*\\*\\\n\\\n", "</b><br><br>");
            content = content.replaceAll("\n\n", "<br><br>");
            content = content.replaceAll("\n", "<br>");
            content = content.replaceAll("- __", "<br><b>");
            content = content.replaceAll("__", "</b>");
            content = content.replaceAll("\\.\\*\\*", ".</b>");
            content = content.replaceAll("\\*\\*\\.", "</b>.");
            content = content.replaceAll("\\*\\* ", "</b> ");
            content = content.replaceAll("\\*\\*", "<b>");
            content = content.replaceAll("_", "");
            builder.append(String.format("<p>%s</p>", content));
            htmlSubContent = builder.toString();
        }
        return htmlSubContent;
    }

    public String getMediaVideoUrl() {
        if (null != media && !media.isEmpty()) {
            int mediaType = media.get(0).getMediaType();
            if (mediaType == PPCommonInfo.MEDIA_TYPE_VIDEO) {
                return media.get(0).getUrl();
            }
        }
        return null;
    }

    public String getHtmlContent(String filePath) {
        if (null == htmlContent) {
            StringBuilder builder = new StringBuilder();
            if (null != media && !media.isEmpty()) {
                int mediaType = media.get(0).getMediaType();
                if (mediaType == PPCommonInfo.MEDIA_TYPE_IMAGE) {
                    builder.append(String.format("<div><img src='%s'/></div>", media.get(0).getUrl()));
                } else if (mediaType == PPCommonInfo.MEDIA_TYPE_VIDEO) {
                    String controls = "autoplay";
                    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
                        controls = "controls";
                    }
                    if (filePath == null) {
                        filePath = media.get(0).getUrl();
                        builder.append(String.format("<div><video %s src=\"%s\"/></div>", controls, filePath));
                    } else {
                        builder.append(String.format("<div><video %s src=\"file://%s\"/></div>", controls, filePath));
                    }
                }
            }
            if (null != subtitle) {
                builder.append(String.format("<h1><b>%s</b></h1>", subtitle));
            }
            if (null != content) {
                Pattern pattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)");
                Matcher matcher = pattern.matcher(content);
                content = matcher.replaceAll("<a href=\\\"$2\\\">$1</a>");
                content = content.replaceAll("\\*\\*\\\n\\\n", "</b><br><br>");
                content = content.replaceAll("\n\n", "<br><br>");
                content = content.replaceAll("\n", "<br>");
                content = content.replaceAll("- __", "<br><b>");
                content = content.replaceAll("__", "</b>");
                content = content.replaceAll("\\.\\*\\*", ".</b>");
                content = content.replaceAll("\\*\\*\"", "\"</b>");
                content = content.replaceAll("\\*\\*\\”", "\\”</b>");
                content = content.replaceAll("\\*\\*\\.", "</b>.");
                content = content.replaceAll("\\*\\*\\,", "</b>,");
                content = content.replaceAll("\\*\\* ", "</b> ");
                content = content.replaceAll("\\*\\* ", "</b> ");
                content = content.replaceAll("\\*\\*\\\"\\.", "</b>\".");
                content = content.replaceAll("\\*\\*", "<b>");
                content = content.replaceAll("_", "");
                content = content.replace("\\u00B0", "&#176");
                builder.append(String.format("<p>%s</p>", content));
            }
            htmlContent = builder.toString();
        }
        return htmlContent;
    }

    public String getFAQMediaContent(String filePath){
        StringBuilder builder = new StringBuilder();
        if (null != media && !media.isEmpty()) {
            int mediaType = media.get(0).getMediaType();
            if (mediaType == PPCommonInfo.MEDIA_TYPE_IMAGE) {
                builder.append(String.format("<div><img src='%s'/></div>", media.get(0).getUrl()));
            } else if (mediaType == PPCommonInfo.MEDIA_TYPE_VIDEO) {
                String controls = "autoplay";
                if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.LOLLIPOP_MR1) {
                    controls = "controls";
                }
                if (filePath != null) {
                    filePath = media.get(0).getUrl();
                    builder.append(String.format("<div><video %s src=\"%s\"/></div>", controls, filePath));
                }
            }
        }
        return htmlContent = builder.toString();
    }

    public String getFAQHtmlContent() {
        if (null == faqHtmlContent) {
            Pattern pattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)");
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("$1");
            faqHtmlContent = content.replaceAll("__", "");
        }
        return faqHtmlContent;
    }

    private HashMap<String, String> links = new HashMap<>();

    public String getLinkContent() {
        if (null == faqHtmlContent) {
            StringBuilder builder = new StringBuilder();
            faqHtmlContent = String.format("<body>%s</body>", content);
            Pattern pattern = Pattern.compile("\\[(.*?)\\]\\((.*?)\\)");
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("<a href=\\\"$1|$2\\\">$1</a>");
            content = content.replaceAll("\\*\\*\\\n\\\n", "</b><br><br>");
            content = content.replaceAll("\n\n", "<br><br>");
            content = content.replaceAll("\n", "<br>");
            content = content.replaceAll("- __", "<br><b>");
            content = content.replaceAll("__", "</b>");
            content = content.replaceAll("\\.\\*\\*", ".</b>");
            content = content.replaceAll("\\*\\*\\.", "</b>.");
            content = content.replaceAll("\\*\\*\\,", "</b>,");
            content = content.replaceAll("\\*\\* ", "</b> ");
            content = content.replaceAll("\\*\\* ", "</b> ");
            content = content.replaceAll("\\*\\*\\\"\\.", "</b>\".");
            content = content.replaceAll("\\*\\*", "<b>");
            content = content.replaceAll("_", "");
            faqHtmlContent = content.replace("\\u00B0", "&#176");
            builder.append(String.format("<p>%s</p>", faqHtmlContent));
        }
        return faqHtmlContent;
    }

    public Set<String> getLinkKeys() {
        return links.keySet();
    }

    public String getLink(String key) {
        return links.get(key);
    }
}