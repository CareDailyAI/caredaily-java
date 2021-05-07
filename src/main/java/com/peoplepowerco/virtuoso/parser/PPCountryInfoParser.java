/**
 * @FileName : PPCountryInfoParser.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.models.PPCountryInfoModel;
import com.peoplepowerco.virtuoso.models.PPCountryInfoStatesModel;
import com.peoplepowerco.virtuoso.models.PPCountryInfoTimezonesModel;
import com.peoplepowerco.virtuoso.util.PPSharedPreferences;
import com.peoplepowerco.virtuoso.util.PPUtil;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 * @brief : Country Information json parser(Need to be extented)
 * @date : Jul 9, 2014
 */
public class PPCountryInfoParser implements PPBaseJsonParser {

    public PPCountryInfoParser() {
    }

    @SuppressWarnings("unused")
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        JSONArray jsonArrayCountry = null;
        JSONObject jsonObjCountry = null;
        PPCountryInfoModel CountryInfoModel = null;
        JSONArray jsonArrayTimezone = null;
        JSONObject jsonObjTimezone = null;

        JSONArray jsonArrayState = null;
        JSONObject jsonObjState = null;

        PPSharedPreferences m_Prefs = PPVirtuoso.getInstance().getPrefs();
        try {
            ArrayList<PPCountryInfoModel> countryInfoList = (ArrayList<PPCountryInfoModel>) obj[0];
            Map<String, PPCountryInfoModel> countryInfoMap = (Map<String, PPCountryInfoModel>) obj[1];
            Map<String, PPCountryInfoStatesModel> countryStatesMap = (Map<String, PPCountryInfoStatesModel>) obj[2];
            countryInfoList.clear();
            countryInfoMap.clear();
            countryStatesMap.clear();

            jsonArrayCountry = jso.getJSONArray("countries");
            if (jsonArrayCountry != null && jsonArrayCountry.size() > 0) {
                int arrayCount = jsonArrayCountry.size();
                for (int i = 0; i < arrayCount; i++) {
                    jsonObjCountry = jsonArrayCountry.getJSONObject(i);
                    CountryInfoModel = new PPCountryInfoModel();
                    CountryInfoModel.setId((jsonObjCountry.containsKey("id")) ? jsonObjCountry.getInteger("id") : 0);
                    CountryInfoModel.setCountryName((jsonObjCountry.containsKey("name")) ? jsonObjCountry.getString("name") : null);
                    CountryInfoModel.setCurrencyCode((jsonObjCountry.containsKey("currencyCode")) ? jsonObjCountry.getString("currencyCode") : null);
                    CountryInfoModel.setCurrencySymbol((jsonObjCountry.containsKey("currencySymbol")) ? jsonObjCountry.getString("currencySymbol") : null);
                    CountryInfoModel.setCountryCode((jsonObjCountry.containsKey("countryCode")) ? jsonObjCountry.getString("countryCode") : null);
                    CountryInfoModel.setZipFormat((jsonObjCountry.containsKey("zipFormat")) ? jsonObjCountry.getString("zipFormat") : null);
                    CountryInfoModel.setZipName((jsonObjCountry.containsKey("zipName")) ? jsonObjCountry.getString("zipName") : null);
                    CountryInfoModel.setPreferred((jsonObjCountry.containsKey("preferred")) ? jsonObjCountry.getBoolean("preferred") : false);
                    CountryInfoModel.setFormatCountryInfo(String.format("%s +%s", CountryInfoModel.getCountryCode(),
                            PPUtil.getCountryCode(CountryInfoModel.getCountryCode())));

//                    m_Prefs.setCurrencyCode(Integer.toString(i) + "code", CountryInfoModel.getCurrencyCode());
//                    m_Prefs.setCurrencySymbol(Integer.toString(i) + "symbol", CountryInfoModel.getCurrencySymbol());
//                    m_Prefs.setCountryNameByKey(Integer.toString(i) + "name", CountryInfoModel.getCountryName());
//                    m_Prefs.setCurrencySymbolByCountryName(CountryInfoModel.getCountryName() + "symbol", CountryInfoModel.getCurrencySymbol());
                    m_Prefs.setCurrencySymbolByCode(CountryInfoModel.getCurrencyCode() + "symbol", CountryInfoModel.getCurrencySymbol());
//                    m_Prefs.setCurrencyCodeByCountryName(CountryInfoModel.getCountryName() + "code", CountryInfoModel.getCurrencyCode());
//					PPVirtuosoLogTrace.i("PPCountryInfoParser", "Symbol by country ===" + m_Prefs.getCurrencySymbolByCountryName(CountryInfoModel.getCountryName() + "symbol"));
//					PPVirtuosoLogTrace.i("PPCountryInfoParser", "Symbol by code ===" + m_Prefs.getCurrencySymbolByCode(CountryInfoModel.getCurrencyCode() + "symbol"));
//					PPVirtuosoLogTrace.i("PPCountryInfoParser", "Code by country ===" + m_Prefs.getCurrencyCodeByCountryName(CountryInfoModel.getCountryName() + "code"));
                    //Timezone
                    if (jsonObjCountry.containsKey("timezones")) {
                        jsonArrayTimezone = jsonObjCountry.getJSONArray("timezones");
                        if (jsonArrayTimezone != null && jsonArrayTimezone.size() > 0) {
                            int timezoneArrayCount = jsonArrayTimezone.size();
                            ArrayList<PPCountryInfoTimezonesModel> timezoneArrayList = new ArrayList<PPCountryInfoTimezonesModel>();
                            for (int j = 0; j < timezoneArrayCount; j++) {
                                PPCountryInfoTimezonesModel timezoneModel = new PPCountryInfoTimezonesModel();
                                jsonObjTimezone = jsonArrayTimezone.getJSONObject(j);
                                timezoneModel.setId((jsonObjTimezone.containsKey("id")) ? jsonObjTimezone.getString("id") : null);
                                timezoneModel.setnOffset((jsonObjTimezone.containsKey("offset")) ? jsonObjTimezone.getInteger("offset") : 0);
                                timezoneModel.setDst((jsonObjTimezone.containsKey("dst")) ? jsonObjTimezone.getBoolean("dst") : false);
                                timezoneModel.setName((jsonObjTimezone.containsKey("name")) ? jsonObjTimezone.getString("name") : null);
                                timezoneArrayList.add(timezoneModel);
                            }
                            CountryInfoModel.setCountryInfoTimezonesModelArrayList(timezoneArrayList);
                        }
                    }
                    //State
                    if (jsonObjCountry.containsKey("states")) {
                        jsonArrayState = jsonObjCountry.getJSONArray("states");
                        if (jsonArrayState != null && jsonArrayState.size() > 0) {
                            int stateArrayCount = jsonArrayState.size();
                            ArrayList<PPCountryInfoStatesModel> stateArrayList = new ArrayList<PPCountryInfoStatesModel>();
                            for (int k = 0; k < stateArrayCount; k++) {
                                PPCountryInfoStatesModel stateModel = new PPCountryInfoStatesModel();
                                jsonObjState = jsonArrayState.getJSONObject(k);
                                stateModel.setId((jsonObjState.containsKey("id")) ? jsonObjState.getInteger("id") : 0);
                                stateModel.setName((jsonObjState.containsKey("name")) ? jsonObjState.getString("name") : null);
                                stateModel.setTimezoneId((jsonObjState.containsKey("timezoneId")) ? jsonObjState.getString("timezoneId") : null);
                                stateModel.setPreffered((jsonObjState.containsKey("preferred")) ? jsonObjState.getBoolean("preferred") : false);
                                stateArrayList.add(stateModel);

                                countryStatesMap.put(stateModel.getName(), stateModel);
                            }
                            CountryInfoModel.setCountryInfoStatesModelArrayList(stateArrayList);
                        }
                    }
                    countryInfoMap.put(CountryInfoModel.getCountryCode(), CountryInfoModel);
                    countryInfoList.add(CountryInfoModel);
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
