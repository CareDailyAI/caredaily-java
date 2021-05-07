package com.peoplepowerco.virtuoso.bean;

import android.content.Context;

import java.text.DecimalFormat;

/**
 * @author : James Cho
 * @brief :
 * @date : 10/03/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPElectricityBilling {
    private Context m_Context;

    public PPElectricityBilling(Context context) {
        m_Context = context;
    }

    public String wattsToCostPerHourString(float watts, String currencyCode) {
        String localizedMoneyString = "";
        return localizedMoneyString;
    }

    public String wattsToCostPerMonthString(float watts, String currencyCode, String billingRate) {
        String localizedMoneyString = "";
        String currencySymbol = "";
        Float fRateVaule = 0f;
        if (currencyCode == null || currencyCode.isEmpty()) {
            currencySymbol = getCurrencySymbol("USD");
        } else {
            currencySymbol = getCurrencySymbol(currencyCode);
        }
        if (billingRate == null || billingRate.isEmpty()) {
            fRateVaule = 0.12f;
        } else {
            fRateVaule = Float.parseFloat(billingRate);
        }

        Float fKwattPerMonth = (float) (fRateVaule * 730.484 * (watts / 1000.0));
        DecimalFormat df = new DecimalFormat("###.##");
        localizedMoneyString = currencySymbol + df.format(fKwattPerMonth);

        return localizedMoneyString;
    }

    public String getCurrencySymbol(String currencyCode) {
        if (currencyCode.equals("USD") || currencyCode.equals("AUD") || currencyCode.equals("CAD") || currencyCode.equals("MXN")) {
            return "$";
        } else if (currencyCode.equals("EUR")) {
            return "€";
        } else if (currencyCode.equals("CHF")) {
            return "Fr";
        } else if (currencyCode.equals("INR")) {
            return "₹";
        } else if (currencyCode.equals("ILS")) {
            return "₪";
        } else if (currencyCode.equals("ZAR")) {
            return "R";
        } else if (currencyCode.equals("GBP")) {
            return "£";
        } else if (currencyCode.equals("AED")) {
            return "د.إ";
        } else if (currencyCode.equals("CNY") || currencyCode.equals("JPY")) {
            return "¥";
        } else {
            return "$";
        }
    }
}