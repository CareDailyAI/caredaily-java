/**
 * @FileName : PPUtil.java
 * @Project : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
package com.peoplepowerco.virtuoso.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.peoplepowerco.virtuoso.PPAppCenter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPUtil {

    public static final String NULL_STRING = "";
    public static final String PASSWORD_PATTERN = "^.{8,}$";
    private static final String[] COUNTRIES = {
        "AD",
        "AE",
        "AF",
        "AL",
        "AM",
        "AN",
        "AO",
        "AQ",
        "AR",
        "AT",
        "AU",
        "AW",
        "AZ",
        "BA",
        "BD",
        "BE",
        "BF",
        "BG",
        "BH",
        "BI",
        "BJ",
        "BL",
        "BN",
        "BO",
        "BR",
        "BT",
        "BW",
        "BY",
        "BZ",
        "US",
        "CC",
        "CD",
        "CF",
        "CG",
        "CH",
        "CI",
        "CK",
        "CL",
        "CM",
        "CN",
        "CO",
        "CR",
        "CU",
        "CV",
        "CX",
        "CY",
        "CZ",
        "DE",
        "DJ",
        "DK",
        "DZ",
        "EC",
        "EE",
        "EG",
        "ER",
        "ES",
        "ET",
        "FI",
        "FJ",
        "FK",
        "FM",
        "FO",
        "FR",
        "GA",
        "GB",
        "GE",
        "GH",
        "GI",
        "GL",
        "GM",
        "GN",
        "GQ",
        "GR",
        "GT",
        "GW",
        "GY",
        "HK",
        "HN",
        "HR",
        "HT",
        "HU",
        "ID",
        "IE",
        "IL",
        "IM",
        "IN",
        "IQ",
        "IR",
        "IT",
        "JO",
        "JP",
        "KE",
        "KG",
        "KH",
        "KI",
        "KM",
        "KP",
        "KR",
        "KW",
        "KZ",
        "LA",
        "LB",
        "LI",
        "LK",
        "LR",
        "LS",
        "LT",
        "LU",
        "LV",
        "LY",
        "MA",
        "MC",
        "MD",
        "ME",
        "MG",
        "MH",
        "MK",
        "ML",
        "MM",
        "MN",
        "MO",
        "MR",
        "MT",
        "MU",
        "MV",
        "MW",
        "MX",
        "MY",
        "MZ",
        "NA",
        "NC",
        "NE",
        "NG",
        "NI",
        "NL",
        "NO",
        "NP",
        "NR",
        "NU",
        "NZ",
        "OM",
        "PA",
        "PE",
        "PF",
        "PG",
        "PH",
        "PK",
        "PL",
        "PM",
        "PN",
        "PR",
        "PT",
        "PW",
        "PY",
        "QA",
        "RO",
        "RS",
        "RU",
        "RW",
        "SA",
        "SB",
        "SC",
        "SD",
        "SE",
        "SG",
        "SH",
        "SI",
        "SK",
        "SL",
        "SM",
        "SN",
        "SO",
        "SR",
        "ST",
        "SV",
        "SY",
        "SZ",
        "TD",
        "TG",
        "TH",
        "TJ",
        "TK",
        "TL",
        "TM",
        "TN",
        "TO",
        "TR",
        "TV",
        "TW",
        "TZ",
        "UA",
        "UG",
        "CA",
        "UY",
        "UZ",
        "VA",
        "VE",
        "VN",
        "VU",
        "WF",
        "WS",
        "YE",
        "YT",
        "ZA",
        "ZM",
        "ZW"
    };

    private static final String[] COUNTRY_CODES = {
        "376",
        "971",
        "93",
        "355",
        "374",
        "599",
        "244",
        "672",
        "54",
        "43",
        "61",
        "297",
        "994",
        "387",
        "880",
        "32",
        "226",
        "359",
        "973",
        "257",
        "229",
        "590",
        "673",
        "591",
        "55",
        "975",
        "267",
        "375",
        "501",
        "1",
        "61",
        "243",
        "236",
        "242",
        "41",
        "225",
        "682",
        "56",
        "237",
        "86",
        "57",
        "506",
        "53",
        "238",
        "61",
        "357",
        "420",
        "49",
        "253",
        "45",
        "213",
        "593",
        "372",
        "20",
        "291",
        "34",
        "251",
        "358",
        "679",
        "500",
        "691",
        "298",
        "33",
        "241",
        "44",
        "995",
        "233",
        "350",
        "299",
        "220",
        "224",
        "240",
        "30",
        "502",
        "245",
        "592",
        "852",
        "504",
        "385",
        "509",
        "36",
        "62",
        "353",
        "972",
        "44",
        "91",
        "964",
        "98",
        "39",
        "962",
        "81",
        "254",
        "996",
        "855",
        "686",
        "269",
        "850",
        "82",
        "965",
        "7",
        "856",
        "961",
        "423",
        "94",
        "231",
        "266",
        "370",
        "352",
        "371",
        "218",
        "212",
        "377",
        "373",
        "382",
        "261",
        "692",
        "389",
        "223",
        "95",
        "976",
        "853",
        "222",
        "356",
        "230",
        "960",
        "265",
        "52",
        "60",
        "258",
        "264",
        "687",
        "227",
        "234",
        "505",
        "31",
        "47",
        "977",
        "674",
        "683",
        "64",
        "968",
        "507",
        "51",
        "689",
        "675",
        "63",
        "92",
        "48",
        "508",
        "870",
        "1",
        "351",
        "680",
        "595",
        "974",
        "40",
        "381",
        "7",
        "250",
        "966",
        "677",
        "248",
        "249",
        "46",
        "65",
        "290",
        "386",
        "421",
        "232",
        "378",
        "221",
        "252",
        "597",
        "239",
        "503",
        "963",
        "268",
        "235",
        "228",
        "66",
        "992",
        "690",
        "670",
        "993",
        "216",
        "676",
        "90",
        "688",
        "886",
        "255",
        "380",
        "256",
        "1",
        "598",
        "998",
        "39",
        "58",
        "84",
        "678",
        "681",
        "685",
        "967",
        "262",
        "27",
        "260",
        "263"
    };

    private static int getIndex(String country) {
        String search = country.toUpperCase(Locale.getDefault());
        for (int i = 0; i < COUNTRIES.length; ++i) {
            if (COUNTRIES[i].equals(search)) {
                return i;
            }
        }

        return -1;
    }

    private static int getIndexOfCode(String countryCode) {
        String search = countryCode.toUpperCase(Locale.getDefault());
        for (int i = 0; i < COUNTRY_CODES.length; ++i) {
            if (COUNTRY_CODES[i].equals(search)) {
                return i;
            }
        }

        return -1;
    }

    public static String getCountryCode(String country) {
        int index = getIndex(country);
        if (-1 == index) {
            index = getIndexOfCode(country);
        }
        return index == -1 ? null : COUNTRY_CODES[index];
    }

    public static String getCountry(String countryCode) {
        int index = getIndexOfCode(countryCode);
        return index == -1 ? null : COUNTRIES[index];
    }

    public static String getCountryCodeWithPlus(String country) {
        int index = getIndex(country);
        return index == -1 ? null : String.format("+%s", COUNTRY_CODES[index]);
    }

    public static String getFormatPhoneNumber(String phone, String countryCode) {
        String formattedPhone = phone;
        String prefix = getCountryCode(countryCode);
        if (null != prefix) {
            if (phone.length() > 10 && phone.substring(0, prefix.length()).equals(prefix)) {
                formattedPhone = phone.substring(prefix.length());
            }
        }
        return formattedPhone;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isStartWithAEIOU(String str) {
        String compareLetter = str.toLowerCase();
        if (compareLetter.startsWith("a") || compareLetter.startsWith("e") || compareLetter.startsWith("i")
            || compareLetter.startsWith("o") || compareLetter.startsWith("u")) {
            return true;
        }
        return false;
    }

    public static int dip2px(Context context, float dpValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, metrics);
    }

    public static int sp2px(Context context, float spValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, metrics);
    }

    public static boolean isBeforeOrEqualToday(String dateStr) {
        if (TextUtils.isEmpty(dateStr)) {
            return false;
        }
        Date date = null;
        SimpleDateFormat dateOutputFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = dateOutputFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (null != date) {
            Date today = new Date();
            return date.before(today) || date.equals(today);
        }
        return false;
    }

    public static Date getFormatDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsedDate;
    }

    public static long getFormatDatetime(String date) {
        Date parsedDate = getFormatDate(date);
        if (null == parsedDate) {
            return 0;
        }
        return parsedDate.getTime();
    }

    public static String getValidateQRcode(String sQRCode) {
        String sCheckSum = null;
        String sMacPid = null;
        String[] sSplitScandId = null;

        sSplitScandId = sQRCode.split("-");

        //do we have 3 parts?
        if (sSplitScandId.length < 3) {
            return null;
        }

        String m_sProductId = sSplitScandId[1];
        sCheckSum = sSplitScandId[2];
        sMacPid = sQRCode.substring(0, sQRCode.lastIndexOf("-") + 1);

        if (m_sProductId != null) {
            try {
                int nProductId = Integer.parseInt(m_sProductId);
            } catch (Exception e) {
            }
        }

        char[] chCode = new char[sMacPid.length()];
        String[] sCode = new String[sMacPid.length()];
        String[] xCode = new String[sMacPid.length()];
        int nSum = 0;
        String sCalCheckSum = null;

        for (int i = 0; i < sMacPid.length(); i++) {
            chCode[i] = sMacPid.charAt(i);
            xCode[i] = String.format("0x%02x", (int) chCode[i]);
            sCode[i] = Character.toString(chCode[i]);
            nSum += chCode[i];
        }
        sCalCheckSum = String.format("%02x", nSum);

        if (sCalCheckSum.equals(sCheckSum)) {
            return m_sProductId;
        } else {
            return null;
        }
    }

    public static String wattsToCostPerHourString(float watts, String currencyCode) {
        String localizedMoneyString = "";
        return localizedMoneyString;
    }

    public static String wattsToCostPerMonthString(float watts, String currencyCode, String billingRate) {
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

    public static String getCurrencySymbol(String currencyCode) {
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

    public static boolean validatePostalCode(String postalCode) {
        String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
        Pattern pc = Pattern.compile(regex);
        Matcher matcher = pc.matcher(postalCode);
        return true || matcher.find();
    }

    public static void updateCodes(String numeric, String duress) {
        String nc = PPAppCenter.m_SharedPresence.getNumericCode();
        String dc = PPAppCenter.m_SharedPresence.getDuressCode();

        if (numeric != null && !numeric.isEmpty() && !numeric.equals(nc)) {
            PPAppCenter.m_SharedPresence.setNumericCode(numeric);
        }
        if (duress != null && !duress.isEmpty() && !duress.equals(dc)) {
            PPAppCenter.m_SharedPresence.setDuressCode(duress);
        }
    }

    public static String getFormattedDegree(String degreeValue, String unit) {
        try {
            if (unit.equals("DegF")) {
                float deviceStatus = Float.parseFloat(degreeValue);
                deviceStatus = (float) (deviceStatus * 9.0 / 5.0 + 32.0);
                String degree = String.format("%.1f", deviceStatus);
                return degree + "°F";
            } else {
                return degreeValue + "°C";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static long getZeroTime(long timeMs) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(timeMs));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime().getTime();
    }
}
