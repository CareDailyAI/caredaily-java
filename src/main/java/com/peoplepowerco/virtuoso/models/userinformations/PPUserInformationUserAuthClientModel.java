package com.peoplepowerco.virtuoso.models.userinformations;

import io.realm.RealmObject;

/**
 * @author : James Cho
 * @brief : User auth client model
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationUserAuthClientModel extends RealmObject {

    public String sAppId;
    public String sAppName;
    public String sExpiry;
    public boolean bAutoRefresh;
}
