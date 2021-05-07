/**
 * @FileName : PPContactModel.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.models;


import com.peoplepowerco.virtuoso.util.PPUtil;

import java.io.Serializable;

public class PPContactModel implements Serializable {
    private static final long serialVersionUID = 7382351359868556981L;

    public String sName = PPUtil.NULL_STRING;
    public String sNameFirstLetter = PPUtil.NULL_STRING;
    public String sFirstName = PPUtil.NULL_STRING;
    public String sLastName = PPUtil.NULL_STRING;
    public String sEmail = PPUtil.NULL_STRING;
    public String sPhone = PPUtil.NULL_STRING;
    public String sContactId = PPUtil.NULL_STRING;
    public boolean bChecked = false;
    public boolean bIsSeperator = false;
    public boolean bIsLast = false;
    public int seperatorType = 1; // 1 means phone contact; 0 means manually added contact;
}
