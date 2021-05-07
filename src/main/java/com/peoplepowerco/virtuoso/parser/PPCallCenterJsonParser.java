package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.managers.PPLocationUserManager;
import com.peoplepowerco.virtuoso.models.PPCallCenterContactsModel;
import com.peoplepowerco.virtuoso.models.PPCallCenterModel;
import com.peoplepowerco.virtuoso.models.locationUser.PPLocationUserModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.util.ArrayList;

public class PPCallCenterJsonParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {

        JSONArray missingFiedlsJsonArray = null;
        JSONArray contactJsonArray = null;
        JSONObject callCenterJsonObj = null;
        PPCallCenterModel callCenterModel = null;
        try {
            callCenterModel = (PPCallCenterModel) obj[0];
            //callCenterModel = new PPCallCenterModel();
            callCenterJsonObj = jso.getJSONObject("callCenter");
            callCenterModel.setUserId((callCenterJsonObj.containsKey("userId")) ? callCenterJsonObj.getString("userId") : null);
            callCenterModel.setCodeWord((callCenterJsonObj.containsKey("codeword")) ? callCenterJsonObj.getString("codeword") : null);
            callCenterModel.setPermitId((callCenterJsonObj.containsKey("permit")) ? callCenterJsonObj.getString("permit") : null);
            callCenterModel.setStatus((callCenterJsonObj.containsKey("status")) ? callCenterJsonObj.getInteger("status") : 0);
            callCenterModel.setAlertStatus((callCenterJsonObj.containsKey("alertStatus")) ? callCenterJsonObj.getInteger("alertStatus") : 0);
            callCenterModel.setAlertDate((callCenterJsonObj.containsKey("alertDate")) ? callCenterJsonObj.getString("alertDate") : null);
            callCenterModel.setAlertDateMs((callCenterJsonObj.containsKey("alertDateMs")) ? callCenterJsonObj.getString("alertDateMs") : null);
            callCenterModel.setAlertStatusDate((callCenterJsonObj.containsKey("alertStatusDate")) ? callCenterJsonObj.getString("alertStatusDate") : null);
            callCenterModel.setAlertStatusDateMs((callCenterJsonObj.containsKey("alertStatusDateMs")) ? callCenterJsonObj.getString("alertStatusDateMs") : null);

            if (callCenterJsonObj.containsKey("missingFields")) {
                missingFiedlsJsonArray = (callCenterJsonObj.containsKey("missingFields")) ? callCenterJsonObj.getJSONArray("missingFields") : null;
                if (missingFiedlsJsonArray != null && missingFiedlsJsonArray.size() > 0) {
                    int missingFieldCount = missingFiedlsJsonArray.size();
                    ArrayList<String> m_missingFieldList = new ArrayList<String>();
                    for (int j = 0; j < missingFieldCount; j++) {
                        if (missingFiedlsJsonArray != null) {
                            m_missingFieldList.add(missingFiedlsJsonArray.toString());
                            PPVirtuosoLogTrace.d("PPCallCenterJsonParser", "missingFieldList = " + m_missingFieldList.get(j));
                        }
                    }
                    callCenterModel.setCallCenterMissingFieldsArrayList(m_missingFieldList);
                }
            }
            if (callCenterJsonObj.containsKey("contacts")) {
                ArrayList<PPCallCenterContactsModel> m_callCenterContactList = new ArrayList<PPCallCenterContactsModel>();
                contactJsonArray = (callCenterJsonObj.containsKey("contacts")) ? callCenterJsonObj.getJSONArray("contacts") : null;
                if (contactJsonArray != null && contactJsonArray.size() > 0) {
                    int contactCount = contactJsonArray.size();
                    for (int j = 0; j < contactCount; j++) {
                        PPCallCenterContactsModel m_callCenterContactModel = new PPCallCenterContactsModel();
                        JSONObject subscriptionJsonObject = contactJsonArray.getJSONObject(j);
                        m_callCenterContactModel.setUserId((subscriptionJsonObject.containsKey("userId")) ? subscriptionJsonObject.getIntValue("userId") : PPCommonInfo.PPInvalidValue);
                        m_callCenterContactModel.setFirstName((subscriptionJsonObject.containsKey("firstName")) ? subscriptionJsonObject.getString("firstName") : null);
                        m_callCenterContactModel.setLastName((subscriptionJsonObject.containsKey("lastName")) ? subscriptionJsonObject.getString("lastName") : null);
                        m_callCenterContactModel.setPhone((subscriptionJsonObject.containsKey("phone")) ? subscriptionJsonObject.getString("phone") : null);

                        for (PPLocationUserModel locationUserModel : PPLocationUserManager.getInstance().getUserModels()) {
                            if (locationUserModel.getId() == m_callCenterContactModel.getUserId()) {
                                m_callCenterContactModel.setAvatarId(locationUserModel.getAvatarFileId());
                                break;
                            }
                        }

                        m_callCenterContactList.add(m_callCenterContactModel);
                    }
                }
                callCenterModel.setCallCenterContactsModelArrayList(m_callCenterContactList);
            } else {
                callCenterModel.setCallCenterContactsModelArrayList(null);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
