package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPLocationServicePlanModel;
import io.realm.Realm;
import io.realm.Realm.Transaction;

/**
 * Created by edwardliu on 2017/12/11.
 */

public class PPLocationServicePlanParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        try {
            final JSONArray jaArrayProperty = (jso.containsKey("subscriptions")) ? jso.getJSONArray("subscriptions") : null;
            if (null != jaArrayProperty && !jaArrayProperty.isEmpty()) {
                Realm.getDefaultInstance().executeTransaction(new Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Long[] planIds = new Long[jaArrayProperty.size()];
                        for (int i = 0; i < jaArrayProperty.size(); i++) {
                            JSONObject jsonObj = jaArrayProperty.getJSONObject(i);
                            long userPlanId = jsonObj.getLongValue("userPlanId");
                            PPLocationServicePlanModel planModel = realm.where(PPLocationServicePlanModel.class)
                                .equalTo("userPlanId", userPlanId).findFirst();
                            if (null == planModel) {
                                planModel = realm.createObject(PPLocationServicePlanModel.class, userPlanId);
                            }
                            planIds[i] = userPlanId;
                            planModel.locationId = jsonObj.getLongValue("locationId");
                            planModel.type = jsonObj.getIntValue("type");
                            planModel.paymentType = jsonObj.getIntValue("paymentType");
                            planModel.status = jsonObj.getIntValue("status");
                            planModel.startDateMs = jsonObj.getLongValue("startDateMs");
                            planModel.endDateMs = jsonObj.getLongValue("endDateMs");
                            planModel.free = jsonObj.getBooleanValue("free");
                            planModel.isPaid = jsonObj.containsKey("gatewayId") || jsonObj.containsKey("subscriptionId");
                            JSONArray serviceArray = (jsonObj.containsKey("services")) ? jsonObj.getJSONArray("services") : null;
                            if (null != serviceArray && !serviceArray.isEmpty()) {
                                StringBuilder builder = new StringBuilder();
                                for (int j = 0; j != serviceArray.size(); ++j) {
                                    JSONObject serviceObj = serviceArray.getJSONObject(j);
                                    builder.append(serviceObj.getString("name").toLowerCase());
                                }
                                planModel.services = builder.toString();
                            } else {
                                planModel.services = "";
                            }
                        }
                        realm.where(PPLocationServicePlanModel.class)
                            .beginGroup()
                            .not().in("userPlanId", planIds)
                            .endGroup()
                            .findAll().deleteAllFromRealm();
                    }
                });
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
