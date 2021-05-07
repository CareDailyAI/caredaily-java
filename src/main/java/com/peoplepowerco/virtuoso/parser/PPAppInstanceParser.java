package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppAccessesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppDeviceTypesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppInstanceModel;

import java.util.ArrayList;


public class PPAppInstanceParser implements PPBaseJsonParser {

    public static final String TAG = "PPAppInstanceParser";
    public ArrayList<PPAppInstanceModel> m_instanceArrayList;

    @Override
    public boolean setData(JSONObject jsonObject, Object[] obj) {
        try {
            JSONArray dataArray = jsonObject.getJSONArray("apps");
            if (null == dataArray || dataArray.isEmpty()) {
                return false;
            }
            m_instanceArrayList = (ArrayList<PPAppInstanceModel>) obj[0];
            if (m_instanceArrayList != null) {
                m_instanceArrayList.clear();
            }
            for (int i = 0; i != dataArray.size(); ++i) {
                JSONObject dataObj = dataArray.getJSONObject(i);
                PPAppInstanceModel model = new PPAppInstanceModel();
                model.appInstanceId = dataObj.getInteger("appInstanceId");
                model.bundle = dataObj.getString("bundle");
                model.name = dataObj.getString("name");
                model.status = dataObj.getInteger("status");
                if (dataObj.containsKey("access")) {
                    JSONArray modelArray = dataObj.getJSONArray("access");
                    if (null != modelArray) {
                        model.models = new ArrayList<>();
                        for (int j = 0; j != modelArray.size(); ++j) {
                            JSONObject modelObj = modelArray.getJSONObject(j);
                            PPAppAccessesModel accessModel = new PPAppAccessesModel();
                            accessModel.category = modelObj.getInteger("category");
                            accessModel.deviceId = modelObj.containsKey("deviceId") ? modelObj.getString("deviceId") : "";
                            accessModel.deviceType = modelObj.containsKey("deviceType") ? modelObj.getInteger("deviceType") : -1;
                            accessModel.trigger = modelObj.getBoolean("trigger");
                            accessModel.read = modelObj.getBoolean("read");
                            accessModel.control = modelObj.getBoolean("control");
                            JSONObject reasonObj = modelObj.getJSONObject("reason");
                            if (null != reasonObj && reasonObj.containsKey("en")) {
                                accessModel.reason = reasonObj.getString("en");
                            }
                            accessModel.excluded = modelObj.getBoolean("excluded");
                            model.models.add(accessModel);
                        }
                    }
                }
                m_instanceArrayList.add(model);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
