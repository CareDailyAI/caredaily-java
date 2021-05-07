package com.peoplepowerco.virtuoso.models;

import java.io.Serializable;

public class PPTaskModel implements Serializable {
    public String id;
    public String title;
    public String due_date;
    public int priority;
    public String assigned_to;
    public String created_by;
    public String comment;
    public String icon;
    public String color;
    public String uiStyle;
    public long updated;
    public boolean editable;
    public String url;
}
