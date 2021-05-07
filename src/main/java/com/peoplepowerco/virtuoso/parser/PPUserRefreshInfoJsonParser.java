package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.VirtuosoCommonSettings;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationBadgeModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserModel;
import io.realm.Realm;
import io.realm.Realm.Transaction;
import java.util.ArrayList;
import java.util.List;

public class PPUserRefreshInfoJsonParser implements PPBaseJsonParser {

    private static final String TAG = PPUserInformationJsonParser.class.getSimpleName();
    private PPUserInformationUserModel m_userInfoUserModel;
    private List<PPUserInformationBadgeModel> m_UserInformationBadgeArrayList;
    private boolean mNeedRefreshAllLocations;


    @Override
    public boolean setData(final JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        try {
            m_userInfoUserModel = (PPUserInformationUserModel) obj[0];
            m_UserInformationBadgeArrayList = (List<PPUserInformationBadgeModel>) obj[1];
            m_UserInformationBadgeArrayList.clear();
            mNeedRefreshAllLocations = (boolean) obj[2];
            //User part
            parseUserInformation(jso);
            Realm.getDefaultInstance().executeTransaction(new Transaction() {
                @Override
                public void execute(Realm realm) {
                    parseRealmDatas(jso, realm);
                }
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void parseUserInformation(JSONObject jso) {
        //User part
        JSONObject jsonObjUser = jso.getJSONObject("user");
        m_userInfoUserModel.setId((jsonObjUser.containsKey("id")) ? jsonObjUser.getInteger("id") : 0);
        m_userInfoUserModel.setUserName((jsonObjUser.containsKey("userName")) ? jsonObjUser.getString("userName") : null);
        m_userInfoUserModel.setFirstName((jsonObjUser.containsKey("firstName")) ? jsonObjUser.getString("firstName") : null);
        m_userInfoUserModel.setLastName((jsonObjUser.containsKey("lastName")) ? jsonObjUser.getString("lastName") : null);
        m_userInfoUserModel.setCommunityName((jsonObjUser.containsKey("communityName")) ? jsonObjUser.getString("communityName") : null);
        if (jsonObjUser.containsKey("anonymous")) {
            m_userInfoUserModel.setAnonymous((jsonObjUser.containsKey("anonymous")) ? jsonObjUser.getBoolean("anonymous") : false);
        }
        m_userInfoUserModel.setFileUploadPolicy((jsonObjUser.containsKey("fileUploadPolicy")) ? jsonObjUser.getInteger("fileUploadPolicy") : 0);
        m_userInfoUserModel.setPhone((jsonObjUser.containsKey("phone")) ? jsonObjUser.getString("phone") : null);
        m_userInfoUserModel.setPhoneType((jsonObjUser.containsKey("phoneType")) ? jsonObjUser.getIntValue("phoneType") : 0);
        m_userInfoUserModel.setSmsType((jsonObjUser.containsKey("smsStatus")) ? jsonObjUser.getIntValue("smsStatus") : 0);
        m_userInfoUserModel.setLanguage((jsonObjUser.containsKey("language")) ? jsonObjUser.getString("language") : null);
        //User email
        JSONObject jsonObjEmail = (jsonObjUser.containsKey("email")) ? jsonObjUser.getJSONObject("email") : null;
        if (null != jsonObjEmail) {
            m_userInfoUserModel.sUserEmail = ((jsonObjEmail.containsKey("email")) ? jsonObjEmail.getString("email") : null);
            m_userInfoUserModel.bEmailVerified = ((jsonObjEmail.containsKey("verified")) ? jsonObjEmail.getBoolean("verified") : false);
            m_userInfoUserModel.nEmailStatus = ((jsonObjEmail.containsKey("status")) ? jsonObjEmail.getInteger("status") : 0);
        }
        //Others like badges
        if (jso.containsKey("badges")) {
            JSONArray jsonArrayBadges = (jso.containsKey("badges")) ? jso.getJSONArray("badges") : null;
            if (jsonArrayBadges.size() > 0) {
                int userBadgeCount = jsonArrayBadges.size();
                for (int i = 0; i < userBadgeCount; i++) {
                    JSONObject jsonObjBadges = jsonArrayBadges.getJSONObject(i);
                    PPUserInformationBadgeModel userBadgesModel = new PPUserInformationBadgeModel();
                    if (jsonObjBadges != null) {
                        userBadgesModel.setType((jsonObjBadges.containsKey("type")) ? jsonObjBadges.getInteger("type") : 0);
                        userBadgesModel.setCount((jsonObjBadges.containsKey("count")) ? jsonObjBadges.getInteger("count") : 0);
                    }
                    m_UserInformationBadgeArrayList.add(userBadgesModel);
                }
            }
        }
    }

    private void parseRealmDatas(JSONObject jso, Realm realm) {
        JSONObject jsonObjUser = jso.getJSONObject("user");
        JSONArray jsonArrayLocation = jso.getJSONArray("locations");
        if (null != jsonArrayLocation) {
            List<Long> locations = new ArrayList<>();
            for (int i = 0; i < jsonArrayLocation.size(); i++) {
                JSONObject jsonObjLocation = jsonArrayLocation.getJSONObject(i);
                if (jsonObjLocation == null) {
                    continue;
                }

                //Use the tag as caregiver brand;
                JSONObject orgObj = jsonObjLocation.getJSONObject("organization");
                if (VirtuosoCommonSettings.setDNDInAvantguard) {
                    if (null != orgObj) {
                        String domainName = orgObj.getString("domainName");
                        if (TextUtils.isEmpty(domainName) || !domainName.equals(PPAppCenter.APP_NAME)) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }

                long locationId = jsonObjLocation.getLongValue("id");
                locations.add(locationId);
                String currentLocationId = PPAppCenter.m_SharedPresence.getLocationId();
                if (!mNeedRefreshAllLocations && null != currentLocationId && !currentLocationId.equals(String.valueOf(locationId))) {
                    continue;
                }
                PPUserInformationLocationModel userLocationModel = realm.where(PPUserInformationLocationModel.class).equalTo("id", locationId).findFirst();
                if (null == userLocationModel) {
                    userLocationModel = realm.createObject(PPUserInformationLocationModel.class, locationId);
                }
                userLocationModel.userId = PPAppCenter.m_SharedPresence.getUserId();
                userLocationModel.setName(jsonObjLocation.getString("name"));
                userLocationModel.setOrganizationId(ParserHelper.getStringValue(jsonObjLocation, "organizationId"));
                userLocationModel.setLocationAccess(ParserHelper.getIntValue(jsonObjLocation, "locationAccess"));
                userLocationModel.setUserCategory(ParserHelper.getIntValue(jsonObjLocation, "userCategory"));
                userLocationModel.setSmsPhone(ParserHelper.getStringValue(jsonObjLocation, "smsPhone"));
                userLocationModel.setFileUploadPolicy(ParserHelper.getIntValue(jsonObjLocation, "fileUploadPolicy"));
                userLocationModel.setType(ParserHelper.getIntValue(jsonObjLocation, "type"));
                userLocationModel.setZip(ParserHelper.getStringValue(jsonObjLocation, "zip"));
                userLocationModel.setLatitude(ParserHelper.getStringValue(jsonObjLocation, "latitude"));
                userLocationModel.setLongitude(ParserHelper.getStringValue(jsonObjLocation, "longitude"));
                userLocationModel.setTemporary(ParserHelper.getBooleanValue(jsonObjLocation, "temporary") ? 1 : 0);
                if (null != userLocationModel.sLatitude) {
                    userLocationModel.dLatitude = Double.parseDouble(userLocationModel.sLatitude);
                }
                if (null != userLocationModel.slongitude) {
                    userLocationModel.dLongitude = Double.parseDouble(userLocationModel.slongitude);
                }
                userLocationModel.setEvent(ParserHelper.getStringValue(jsonObjLocation, "event"));
                userLocationModel.setSalesTaxRate(ParserHelper.getStringValue(jsonObjLocation, "salesTaxRate"));
                userLocationModel.seStroiesNumber(ParserHelper.getIntValue(jsonObjLocation, "storiesNumber"));
                userLocationModel.setRoomsNumber(ParserHelper.getIntValue(jsonObjLocation, "roomsNumber"));
                userLocationModel.setBathRoomNumber(ParserHelper.getIntValue(jsonObjLocation, "bathroomsNumber"));
                userLocationModel.setOccupantsNumber(ParserHelper.getIntValue(jsonObjLocation, "occupantsNumber"));
                userLocationModel.setUsagePeriod(ParserHelper.getIntValue(jsonObjLocation, "usagePeriod"));
                userLocationModel.setHeatingType(ParserHelper.getIntValue(jsonObjLocation, "heatingType"));
                userLocationModel.setCoolingType(ParserHelper.getIntValue(jsonObjLocation, "coolingType"));
                userLocationModel.setWaterHeaterType(ParserHelper.getIntValue(jsonObjLocation, "waterHeaterType"));
                userLocationModel.setThermostatType(ParserHelper.getIntValue(jsonObjLocation, "thermostatType"));
                userLocationModel.setStartDate(ParserHelper.getStringValue(jsonObjLocation, "startDate"));
                userLocationModel.setAccessEndDate(ParserHelper.getStringValue(jsonObjLocation, "accessEndDate"));
                userLocationModel.setAccessEndDateMs(ParserHelper.getLongValue(jsonObjLocation, "accessEndDateMs"));
                userLocationModel.setCodeType(ParserHelper.getIntValue(jsonObjLocation, "codeType"));

                userLocationModel.setAddress1((jsonObjLocation.containsKey("addrStreet1")) ? jsonObjLocation.getString("addrStreet1") : null);
                userLocationModel.setAddress2((jsonObjLocation.containsKey("addrStreet2")) ? jsonObjLocation.getString("addrStreet2") : null);
                userLocationModel.setCity((jsonObjLocation.containsKey("addrCity")) ? jsonObjLocation.getString("addrCity") : null);
                //Location timezone
                JSONObject jsonObjTimeZone = jsonObjLocation.getJSONObject("timezone");
                if (jsonObjTimeZone != null) {
                    userLocationModel.userInformationLocationTimezoneModel = realm.where(PPUserInformationLocationTimezoneModel.class)
                        .equalTo("locationId", userLocationModel.id).findFirst();
                    if (null == userLocationModel.userInformationLocationTimezoneModel) {
                        userLocationModel.userInformationLocationTimezoneModel = realm.createObject(PPUserInformationLocationTimezoneModel.class, userLocationModel.id);
                    }
                    userLocationModel.userInformationLocationTimezoneModel.setId(jsonObjTimeZone.getString("id"));
                    userLocationModel.userInformationLocationTimezoneModel.setOffset(jsonObjTimeZone.getIntValue("offset"));
                    userLocationModel.userInformationLocationTimezoneModel.setDst(jsonObjTimeZone.getBooleanValue("dst"));
                    userLocationModel.userInformationLocationTimezoneModel.setName(jsonObjTimeZone.getString("name"));
                }
                //Location state
                if (jsonObjLocation.containsKey("state")) {
                    JSONObject jsonObjState = jsonObjLocation.getJSONObject("state");
                    if (jsonObjState != null) {
                        userLocationModel.userInformationLocationStateModel = realm.where(PPUserInformationLocationStateModel.class)
                            .equalTo("locationId", userLocationModel.id).findFirst();
                        if (null == userLocationModel.userInformationLocationStateModel) {
                            userLocationModel.userInformationLocationStateModel = realm.createObject(PPUserInformationLocationStateModel.class, userLocationModel.id);
                        }
                        userLocationModel.userInformationLocationStateModel.setId(jsonObjState.getString("id"));
                        userLocationModel.userInformationLocationStateModel.setName(jsonObjState.getString("name"));
                        userLocationModel.userInformationLocationStateModel.setTimezone(jsonObjTimeZone.getString("timezoneId"));
                        userLocationModel.userInformationLocationStateModel.setAbbr(jsonObjState.getString("dst"));
                    }
                }

                //Location country
                JSONObject jsonObjCountry = jsonObjLocation.getJSONObject("country");
                if (jsonObjCountry != null) {
                    userLocationModel.userInformationLocationCountryModel = realm.where(PPUserInformationLocationCountryModel.class)
                        .equalTo("locationId", userLocationModel.id).findFirst();
                    if (null == userLocationModel.userInformationLocationCountryModel) {
                        userLocationModel.userInformationLocationCountryModel = realm.createObject(PPUserInformationLocationCountryModel.class, userLocationModel.id);
                    }
                    userLocationModel.userInformationLocationCountryModel.setId(jsonObjCountry.getString("id"));
                    userLocationModel.userInformationLocationCountryModel.setName(jsonObjCountry.getString("name"));
                    userLocationModel.userInformationLocationCountryModel.setCountryCode(jsonObjCountry.getString("countryCode"));
                    userLocationModel.userInformationLocationCountryModel.setCurrencyCode(jsonObjCountry.getString("currencyCode"));
                    userLocationModel.userInformationLocationCountryModel.setCurrencySymbol(jsonObjCountry.getString("currencyCode"));
                    userLocationModel.userInformationLocationCountryModel.setZipFormat(jsonObjCountry.getString("zipFormat"));
                    userLocationModel.userInformationLocationCountryModel.setsStateName(jsonObjCountry.getString("stateName"));
                    userLocationModel.userInformationLocationCountryModel.setZipName(jsonObjCountry.getString("zipName"));
                }

                //Location organization
                JSONObject jsonObjOrg = jsonObjLocation.getJSONObject("organization");
                if (jsonObjOrg != null) {
                    userLocationModel.userInformationLocationOrgModel = realm.where(PPUserInformationLocationOrgModel.class)
                        .equalTo("locationId", userLocationModel.id).findFirst();
                    if (null == userLocationModel.userInformationLocationOrgModel) {
                        userLocationModel.userInformationLocationOrgModel = realm.createObject(PPUserInformationLocationOrgModel.class, userLocationModel.id);
                    }
                    userLocationModel.userInformationLocationOrgModel.id = jsonObjOrg.getString("id");
                    userLocationModel.userInformationLocationOrgModel.sName = jsonObjOrg.getString("name");
                    userLocationModel.userInformationLocationOrgModel.sContactName1 = jsonObjOrg.getString("contactName1");
                    userLocationModel.userInformationLocationOrgModel.sContactEmail1 = jsonObjOrg.getString("contactEmail1");
                    userLocationModel.userInformationLocationOrgModel.sContactPhone1 = jsonObjOrg.getString("contactPhone1");
                }

                //Location services
                userLocationModel.userInformationLocationServiceArrayList.deleteAllFromRealm();
                JSONArray jsonArrayServices = (jsonObjLocation.containsKey("services")) ? jsonObjLocation.getJSONArray("services") : null;
                if (null != jsonArrayServices && !jsonArrayServices.isEmpty()) {
                    for (int j = 0; j < jsonArrayServices.size(); j++) {
                        JSONObject jsonObjServices = jsonArrayServices.getJSONObject(j);
                        if (jsonObjServices == null) {
                            continue;
                        }

                        PPUserInformationServiceModel userServiceModel = realm.createObject(PPUserInformationServiceModel.class);
                        userServiceModel.locationId = userLocationModel.id;
                        userServiceModel.setName(jsonObjServices.getString("name"));
                        userServiceModel.setAmount(jsonObjServices.getIntValue("amount"));
                        userServiceModel.setStartDate(jsonObjServices.getString("startDate"));
                        userServiceModel.setStartDateMs(jsonObjServices.getLongValue("startDateMs"));
                        userServiceModel.setEndDate(jsonObjServices.getString("endDate"));
                        userServiceModel.setEndDateMs(jsonObjServices.getLongValue("endDateMs"));
                        userLocationModel.userInformationLocationServiceArrayList.add(userServiceModel);
                    }
                }
            }
            if (!locations.isEmpty()) {
                Long[] locationIds = new Long[locations.size()];
                for (int i = 0; i != locations.size(); ++i) {
                    locationIds[i] = locations.get(i);
                }
                realm.where(PPUserInformationLocationModel.class)
                    .beginGroup()
                    .not()
                    .in("id", locationIds)
                    .endGroup()
                    .findAll()
                    .deleteAllFromRealm();
            }
        }

        realm.delete(PPUserInformationUserAuthClientModel.class);
        if (jsonObjUser.containsKey("authClients")) { //User Client Auth
            JSONArray jsonArrayAuthClients = (jsonObjUser.containsKey("authClients")) ? jsonObjUser.getJSONArray("authClients") : null;
            for (int i = 0; i < jsonArrayAuthClients.size(); i++) {
                JSONObject jsonObjAuthClient = jsonArrayAuthClients.getJSONObject(i);
                if (jsonObjAuthClient != null && jsonObjAuthClient.containsKey("appId")) {
                    PPUserInformationUserAuthClientModel userAuthClientModel = realm.createObject(PPUserInformationUserAuthClientModel.class);
                    userAuthClientModel.sAppId = jsonObjAuthClient.getString("appId");
                    userAuthClientModel.sAppName = (jsonObjAuthClient.containsKey("appName")) ? jsonObjAuthClient.getString("appName") : null;
                    userAuthClientModel.sExpiry = (jsonObjAuthClient.containsKey("expiry")) ? jsonObjAuthClient.getString("expiry") : null;
                    userAuthClientModel.bAutoRefresh = (jsonObjAuthClient.containsKey("autoRefresh")) ? jsonObjAuthClient.getBoolean("autoRefresh") : false;
                }
            }
        }
        realm.delete(PPUserInformationCommunityModel.class);
        if (jso.containsKey("locationCommunities")) {
            JSONArray jsonArrayServices = (jso.containsKey("locationCommunities")) ? jso.getJSONArray("locationCommunities") : null;
            if (null != jsonArrayServices && jsonArrayServices.size() > 0) {
                for (int i = 0; i < jsonArrayServices.size(); i++) {
                    JSONObject jsonObjServices = jsonArrayServices.getJSONObject(i);
                    PPUserInformationCommunityModel locationCommunityModel = realm.createObject(PPUserInformationCommunityModel.class);
                    if (jsonObjServices != null) {
                        locationCommunityModel.locationId = jsonObjServices.getString("locationId");
                        locationCommunityModel.communityId = jsonObjServices.getString("communityId");
                        locationCommunityModel.communityName = jsonObjServices.getString("communityName");
                    }
                }
            }
        }
        realm.delete(PPUserCommunityModel.class);
        if (jso.containsKey("userCommunities")) {
            JSONArray jsonArrayServices = (jso.containsKey("userCommunities")) ? jso.getJSONArray("userCommunities") : null;
            if (null != jsonArrayServices && jsonArrayServices.size() > 0) {
                for (int i = 0; i < jsonArrayServices.size(); i++) {
                    JSONObject jsonObjServices = jsonArrayServices.getJSONObject(i);
                    PPUserCommunityModel userCommunityModel = realm.createObject(PPUserCommunityModel.class);
                    if (jsonObjServices != null) {
                        userCommunityModel.communityId = jsonObjServices.getLongValue("communityId");
                        userCommunityModel.communityName = jsonObjServices.getString("communityName");
                    }
                }
            }
        }
    }
}
//Location owner
//Check boolean type for owner for the exceptional case. Looks it needed to be checked more later.
//                Object tmpObj = jsonObjLocation.get("owner");
//                if (tmpObj instanceof Boolean) {
//                    PPVirtuosoLogTrace.d(TAG, "owner type is boolean");
//                } else {
//                    JSONObject ownerObj = jsonObjLocation.getJSONObject("owner");
//                    if (null != ownerObj) {
//                        PPUserInformationLocationOwnerModel ownerModel = new PPUserInformationLocationOwnerModel();
//                        ownerModel.id = ParserHelper.getIntValue(ownerObj, "id");
//                        ownerModel.firstName = ParserHelper.getStringValue(ownerObj, "firstName");
//                        ownerModel.lastName = ParserHelper.getStringValue(ownerObj, "lastName");
//                        ownerModel.phone = ParserHelper.getStringValue(ownerObj, "phone");
//                        ownerModel.phoneType = ParserHelper.getIntValue(ownerObj, "phoneType");
//                        if (ownerObj.containsKey("mail")) {
//                            Object mailObj = ownerObj.get("mail");
//                            if (mailObj instanceof String) {
//                                ownerModel.email = ownerObj.getString("mail");
//                            } else if (mailObj instanceof JSONObject) {
//                                JSONObject mailJson = (JSONObject) mailObj;
//                                ownerModel.email = mailJson.getString("mail");
//                                if (mailJson.containsKey("verified")) {
//                                    ownerModel.emailVerified = mailJson.getBooleanValue("verified");
//                                }
//                                if (mailJson.containsKey("status")) {
//                                    ownerModel.emailStatus = mailJson.getIntValue("status");
//                                }
//                            }
//                        }
//                        userLocationModel.setUserInformationLocationOwnerModel(ownerModel);
//                    }
//                }
//Location country
//                JSONObject jsonObjCountry = jsonObjLocation.getJSONObject("country");
//                if (jsonObjCountry != null) {
//                    PPUserInformationLocationCountryModel userLocationCountry = new PPUserInformationLocationCountryModel();
//                    userLocationCountry.setId((jsonObjCountry.containsKey("id")) ? jsonObjCountry.getInteger("id") : 0);
//                    userLocationCountry.setName((jsonObjCountry.containsKey("name")) ? jsonObjCountry.getString("name") : null);
//                    userLocationCountry.setCountryCode((jsonObjCountry.containsKey("countryCode")) ? jsonObjCountry.getString("countryCode") : null);
//                    userLocationCountry.setCurrencyCode((jsonObjCountry.containsKey("currencyCode")) ? jsonObjCountry.getString("currencyCode") : null);
//                    userLocationCountry.setCurrencySymbol((jsonObjCountry.containsKey("currencySymbol")) ? jsonObjCountry.getString("currencySymbol") : null);
//                    userLocationCountry.setZipFormat((jsonObjCountry.containsKey("zipFormat")) ? jsonObjCountry.getString("zipFormat") : null);
//                    userLocationCountry.setsStateName((jsonObjCountry.containsKey("stateName")) ? jsonObjCountry.getString("stateName") : null);
//                    userLocationCountry.setZipName((jsonObjCountry.containsKey("zipName")) ? jsonObjCountry.getString("zipName") : null);
//                    userLocationModel.setUserInformationLocationCountryModel(userLocationCountry);
//                }
//                //Location size
//                if (jsonObjLocation.containsKey("size")) {
//                    JSONObject jsonObjSize = jsonObjLocation.getJSONObject("size");
//                    if (jsonObjSize != null) {
//                        PPUserInformationLocationSizeModel userLocationSize = new PPUserInformationLocationSizeModel();
//                        userLocationSize.setUnit((jsonObjSize.containsKey("unit")) ? jsonObjSize.getString("unit") : null);
//                        userLocationSize.setValue((jsonObjCountry.containsKey("value")) ? jsonObjCountry.getInteger("value") : 0);
//                        userLocationModel.setUserInformationLocationSizeModel(userLocationSize);
//                    }
//                }
//                //Location occupants ranges
//                if (jsonObjLocation.containsKey("occupantsRanges")) {
//                    JSONArray jsonArrayOccupantsRanges = jsonObjLocation.getJSONArray("occupantsRanges");
//                    if (jsonArrayOccupantsRanges.size() > 0) {
//                        ArrayList<PPUserInformationLocationOccupantsRangeModel> userLocationOccupantRangesAarryList = new ArrayList<PPUserInformationLocationOccupantsRangeModel>();
//                        for (int j = 0; j < jsonArrayOccupantsRanges.size(); j++) {
//                            JSONObject jsonObjOccupantsRanges = jsonArrayOccupantsRanges.getJSONObject(j).getJSONObject("occupantsRanges");
//                            PPUserInformationLocationOccupantsRangeModel userLocationOccupantsRanges = new PPUserInformationLocationOccupantsRangeModel();
//                            if (jsonObjOccupantsRanges != null) {
//                                userLocationOccupantsRanges.setStart((jsonObjOccupantsRanges.containsKey("start")) ? jsonObjOccupantsRanges.getInteger("start") : 0);
//                                userLocationOccupantsRanges.setEnd((jsonObjOccupantsRanges.containsKey("end")) ? jsonObjOccupantsRanges.getInteger("end") : 0);
//                                userLocationOccupantsRanges.setNumber((jsonObjOccupantsRanges.containsKey("number")) ? jsonObjOccupantsRanges.getInteger("number") : 0);
//                            }
//                            userLocationOccupantRangesAarryList.add(userLocationOccupantsRanges);
//                        }
//                        userLocationModel.setUserInformationLocationOccupantsRangeArrayList(userLocationOccupantRangesAarryList);
//                    }
//                }
//
//                //Location auths
//                if (jsonObjLocation.containsKey("auths")) {
//                    JSONArray jsonArrayAuth = (jsonObjLocation.containsKey("auths")) ? jsonObjLocation.getJSONArray("auths") : null;
//                    if (jsonArrayAuth.size() > 0) {
//                        ArrayList<PPUserInformationUserAuthModel> userAuthAarryList = new ArrayList<>();
//                        for (int j = 0; j < jsonArrayAuth.size(); j++) {
//                            JSONObject jsonObjAuth = jsonArrayAuth.getJSONObject(j);
//                            if (jsonObjAuth == null) {
//                                continue;
//                            }
//                            PPUserInformationUserAuthModel userAuthModel = new PPUserInformationUserAuthModel();
//                            userAuthModel.setAppId((jsonObjAuth.containsKey("appId")) ? jsonObjAuth.getInteger("appId") : 0);
//                            userAuthModel.setAppName((jsonObjAuth.containsKey("appName")) ? jsonObjAuth.getString("appName") : null);
//                            userAuthModel.setUserName((jsonObjAuth.containsKey("userName")) ? jsonObjAuth.getString("userName") : null);
//                            userAuthModel.setActive((jsonObjAuth.containsKey("active")) ? jsonObjAuth.getBoolean("active") : false);
//                            userAuthModel.setExpiry((jsonObjAuth.containsKey("expiry")) ? jsonObjAuth.getString("expiry") : null);
//                            userAuthModel.setAutoRefresh((jsonObjAuth.containsKey("autoRefresh")) ? jsonObjAuth.getBoolean("autoRefresh") : false);
//                            userAuthAarryList.add(userAuthModel);
//                        }
//                        userLocationModel.setUserInformationLocationAuthArrayList(userAuthAarryList);
//                    }
//                }
