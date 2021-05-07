package com.peoplepowerco.virtuoso.models.appinfo;

import java.util.List;

/**
 * Created by edwardliu on 2017/6/27.
 */

public class PPAppInstanceModel {
    public int appInstanceId;
    public String bundle;
    public String name;
    public int status;
    public List<PPAppAccessesModel> models;
    public List<PPAppDeviceTypesModel> deviceTypeModels;
}
