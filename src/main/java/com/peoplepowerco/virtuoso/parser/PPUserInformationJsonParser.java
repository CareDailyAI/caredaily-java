package com.peoplepowerco.virtuoso.parser;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.VirtuosoCommonSettings;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationBadgeModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationCommunityModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationCountryModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationOrgModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationStateModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationLocationTimezoneModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationOrganizationModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationServiceModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserAuthClientModel;
import com.peoplepowerco.virtuoso.models.userinformations.PPUserInformationUserModel;
import io.realm.Realm;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho
 * @brief : User information parser
 * @date : 15. 11. 11.
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPUserInformationJsonParser implements PPBaseJsonParser {

    private static final String TAG = PPUserInformationJsonParser.class.getSimpleName();
    private PPUserInformationUserModel m_userInformationUserModel;
    private ArrayList<PPUserInformationServiceModel> m_userInformatioServiceArrayList;
    private ArrayList<PPUserInformationOrganizationModel> m_userInformationOrganiztionArrayList;
    private ArrayList<PPUserInformationBadgeModel> m_userInformationBadgeArrayList;


    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        try {
            m_userInformationUserModel = (PPUserInformationUserModel) obj[0];
            m_userInformatioServiceArrayList = (ArrayList<PPUserInformationServiceModel>) obj[1];
            m_userInformationBadgeArrayList = (ArrayList<PPUserInformationBadgeModel>) obj[2];
            m_userInformationOrganiztionArrayList = (ArrayList<PPUserInformationOrganizationModel>) obj[3];

            m_userInformatioServiceArrayList.clear();
            m_userInformationBadgeArrayList.clear();
            m_userInformationOrganiztionArrayList.clear();

            //User part
            JSONObject jsonObjUser = (jso.containsKey("user")) ? jso.getJSONObject("user") : null;
            parseUserInformation(jsonObjUser, realm);
            parseUserLocationCommunities(jso, realm);

            //Locations
            JSONArray jsonArrayLocation = (jso.containsKey("locations")) ? jso.getJSONArray("locations") : null;
            parseLocations(jsonArrayLocation, realm);

            //Services, badges, organizations
            parseOthers(jso);

            realm.commitTransaction();
            realm.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        realm.commitTransaction();
        realm.close();
        return false;
    }

    private void parseUserInformation(JSONObject jsonObjUser, Realm realm) {
        //User part
        m_userInformationUserModel.setId((jsonObjUser.containsKey("id")) ? jsonObjUser.getInteger("id") : 0);
        m_userInformationUserModel.setUserName((jsonObjUser.containsKey("userName")) ? jsonObjUser.getString("userName") : null);
        m_userInformationUserModel.setFirstName((jsonObjUser.containsKey("firstName")) ? jsonObjUser.getString("firstName") : null);
        m_userInformationUserModel.setLastName((jsonObjUser.containsKey("lastName")) ? jsonObjUser.getString("lastName") : null);
        m_userInformationUserModel.setCommunityName((jsonObjUser.containsKey("communityName")) ? jsonObjUser.getString("communityName") : null);
        m_userInformationUserModel.setAnonymous((jsonObjUser.containsKey("anonymous")) ? jsonObjUser.getBoolean("anonymous") : false);
        m_userInformationUserModel.setFileUploadPolicy((jsonObjUser.containsKey("fileUploadPolicy")) ? jsonObjUser.getInteger("fileUploadPolicy") : 0);
        m_userInformationUserModel.setPhone((jsonObjUser.containsKey("phone")) ? jsonObjUser.getString("phone") : null);
        m_userInformationUserModel.setPhoneType((jsonObjUser.containsKey("phoneType")) ? jsonObjUser.getIntValue("phoneType") : 0);
        m_userInformationUserModel.setSmsType((jsonObjUser.containsKey("smsStatus")) ? jsonObjUser.getIntValue("smsStatus") : 0);
        m_userInformationUserModel.setLanguage((jsonObjUser.containsKey("language")) ? jsonObjUser.getString("language") : null);
        //User email
        JSONObject jsonObjEmail = (jsonObjUser.containsKey("email")) ? jsonObjUser.getJSONObject("email") : null;
        if (null != jsonObjEmail) {
            m_userInformationUserModel.sUserEmail = ((jsonObjEmail.containsKey("email")) ? jsonObjEmail.getString("email") : null);
            m_userInformationUserModel.bEmailVerified = ((jsonObjEmail.containsKey("verified")) ? jsonObjEmail.getBoolean("verified") : false);
            m_userInformationUserModel.nEmailStatus = ((jsonObjEmail.containsKey("status")) ? jsonObjEmail.getInteger("status") : 0);
        } else {
            m_userInformationUserModel.sUserEmail = null;
        }

        //User permission
        if (jsonObjUser.containsKey("permission")) {
            JSONArray jsonArrayPermission = (jsonObjUser.containsKey("permission")) ? jsonObjUser.getJSONArray("permission") : null;
            if (null != jsonArrayPermission && !jsonArrayPermission.isEmpty()) {
                PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_IS_USER_ADMIN, true);
                int userPermissionCount = jsonArrayPermission.size();
                List<Integer> userPermissionList = new ArrayList<>();
                for (int i = 0; i < userPermissionCount; i++) {
                    userPermissionList.add(jsonArrayPermission.getIntValue(i));
                }
                m_userInformationUserModel.setArrayListPermission(userPermissionList);
            } else {
                m_userInformationUserModel.setArrayListPermission(null);
                PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_IS_USER_ADMIN, false);
            }
        } else {
            m_userInformationUserModel.setArrayListPermission(null);
            PPAppCenter.m_SharedPresence.setKeyBooleanValue(PPCommonInfo.REFERENCE_KEY_IS_USER_ADMIN, false);
        }

        //User Client Auth
        realm.delete(PPUserInformationUserAuthClientModel.class);
        if (jsonObjUser.containsKey("authClients")) {
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
    }

    private void parseLocations(JSONArray jsonArrayLocation, Realm realm) {
        if (null != jsonArrayLocation && !jsonArrayLocation.isEmpty()) {
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
                PPUserInformationLocationModel userLocationModel = realm.where(PPUserInformationLocationModel.class).equalTo("id", locationId).findFirst();
                if (null == userLocationModel) {
                    userLocationModel = realm.createObject(PPUserInformationLocationModel.class, locationId);
                }
                userLocationModel.userId = String.valueOf(m_userInformationUserModel.nId);
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
                        userLocationModel.userInformationLocationStateModel.setTimezone(jsonObjState.getString("timezoneId"));
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
    }

    private void parseUserLocationCommunities(JSONObject jso, Realm realm) {
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

    private void parseOthers(JSONObject jso) {
        //Services
        if (jso.containsKey("services")) {
            JSONArray jsonArrayServices = (jso.containsKey("services")) ? jso.getJSONArray("services") : null;
            if (jsonArrayServices.size() > 0) {
                int userServiceCount = jsonArrayServices.size();
                for (int i = 0; i < userServiceCount; i++) {
                    JSONObject jsonObjServices = jsonArrayServices.getJSONObject(i);
                    PPUserInformationServiceModel userServiceModel = new PPUserInformationServiceModel();
                    if (jsonObjServices != null) {
                        userServiceModel.setName((jsonObjServices.containsKey("name")) ? jsonObjServices.getString("name") : null);
                        userServiceModel.setAmount((jsonObjServices.containsKey("amount")) ? jsonObjServices.getInteger("amount") : 0);
                        userServiceModel.setStartDate((jsonObjServices.containsKey("startDate")) ? jsonObjServices.getString("startDate") : null);
                        userServiceModel.setStartDateMs((jsonObjServices.containsKey("startDateMs")) ? jsonObjServices.getLong("startDateMs") : 0L);
                        userServiceModel.setEndDate((jsonObjServices.containsKey("endDate")) ? jsonObjServices.getString("endDate") : null);
                        userServiceModel.setEndDateMs((jsonObjServices.containsKey("endDateMs")) ? jsonObjServices.getLong("endDateMs") : 0L);
                    }
                    m_userInformatioServiceArrayList.add(userServiceModel);
                }
            }
        }
        //Badges
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
                    m_userInformationBadgeArrayList.add(userBadgesModel);
                }
            }
        }
        //Organizations
        if (jso.containsKey("organizations")) {
            JSONArray jsonArrayOrganization = (jso.containsKey("organizations")) ? jso.getJSONArray("organizations") : null;
            if (jsonArrayOrganization.size() > 0) {
                int userOrganizationCount = jsonArrayOrganization.size();
                for (int i = 0; i < userOrganizationCount; i++) {
                    JSONObject jsonObjOrganization = jsonArrayOrganization.getJSONObject(i);
                    PPUserInformationOrganizationModel userOrganizationModel = new PPUserInformationOrganizationModel();
                    if (jsonObjOrganization != null) {
                        userOrganizationModel.setId((jsonObjOrganization.containsKey("id")) ? jsonObjOrganization.getInteger("id") : 0);
                        userOrganizationModel.setName((jsonObjOrganization.containsKey("name")) ? jsonObjOrganization.getString("name") : null);
                        userOrganizationModel.setDomainName((jsonObjOrganization.containsKey("domainName")) ? jsonObjOrganization.getString("domainName") : null);
                        userOrganizationModel.setStatus((jsonObjOrganization.containsKey("status")) ? jsonObjOrganization.getInteger("status") : 0);
                        userOrganizationModel.setGroupId((jsonObjOrganization.containsKey("groupId")) ? jsonObjOrganization.getInteger("groupId") : 0);
                        userOrganizationModel.setGroupName((jsonObjOrganization.containsKey("groupName")) ? jsonObjOrganization.getString("groupName") : null);
                        userOrganizationModel.setnGroupPoints((jsonObjOrganization.containsKey("groupPoints")) ? jsonObjOrganization.getInteger("groupPoints") : 0);
                        userOrganizationModel.setPoints((jsonObjOrganization.containsKey("points")) ? jsonObjOrganization.getInteger("points") : 0);
                        userOrganizationModel.setnPointsLevel((jsonObjOrganization.containsKey("pointsLevel")) ? jsonObjOrganization.getInteger("pointsLevel") : 0);
                        userOrganizationModel.setNotes((jsonObjOrganization.containsKey("notes")) ? jsonObjOrganization.getString("notes") : null);
                    }
                    m_userInformationOrganiztionArrayList.add(userOrganizationModel);
                }
            }
        }
    }
}
