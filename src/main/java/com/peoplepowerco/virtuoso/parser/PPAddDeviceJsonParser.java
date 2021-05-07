package com.peoplepowerco.virtuoso.parser;


import android.content.Context;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.R;
import com.peoplepowerco.virtuoso.models.PPAddDeviceAttributeModel;
import com.peoplepowerco.virtuoso.models.PPAddDeviceModel;
import com.peoplepowerco.virtuoso.util.PPUtil;
import java.util.ArrayList;

public class PPAddDeviceJsonParser implements PPBaseJsonParser {

    public ArrayList<PPAddDeviceModel> m_addDeviceModelArrayList;
    public ArrayList<PPAddDeviceModel> m_supportDeviceArrayList;
    public static final String TAG = "PPAddDeviceJsonParser";

    //Let's use this category for same category and we can add category type later for supported device.
    public static final String SUPPORTED_METER_CATEGORY = "1";
    public static final String SUPPORTED_CENTRALITE_CATEGORY = "2";
    public static final String SUPPORTED_SOLAR_CATEGORY = "3";
    public static final String SUPPORTED_THERMOSTAT_CATEGORY = "4";
    public static final String SUPPORTED_LOCK_CATEGORY = "5";
    public static final String SUPPORTED_MOBILE_CAMERA_CATEGORY = "6";
    public static final String SUPPORTED_VIDEO_CATEGORY = "7";
    public static final String SUPPORTED_MISCELLANEOUS_CATEGORY = "900";
    public static final String SUPPORTED_ADMIN_TOOLS_CATEGORY = "1000";
    public static final String SUPPORTED_ALARMS_CATEGORY = "2000";
    public static final String SUPPORTED_ANALYIZE_CATEGORY = "3000";
    public static final String SUPPORTED_SAFETY_CATEGORY = "4000";
    public static final String SUPPORTED_AUDIO_CATEGORY = "5000";
    public static final String SUPPORTED_CAMERAS_CATEGORY = "6000";
    public static final String SUPPORTED_CLIMATE_CATEGORY = "7000";
    public static final String SUPPORTED_DISPLAYS_CATEGORY = "8000";
    public static final String SUPPORTED_ENVIRONMENTAL_CATEGORY = "9000";
    public static final String SUPPORTED_HEALTH_CATEGORY = "10000";
    public static final String SUPPORTED_LIGHTING = "11000";
    public static final String SUPPORTED_LOCKS_CATEGORY = "12000";
    public static final String SUPPORTED_MEDIA_CATEGORY = "13000";

    public static final String SUPPORTED_METERS_CATEGORY = "14000";
    public static final String SUPPORTED_PRIMETER_MONITORING_CATEGORY = "15000";
    public static final String SUPPORTED_REMOTE_CONTROL_CATEGORY = "16000";
    public static final String SUPPORTED_ROBOTICS_CATEGORY = "17000";
    public static final String SUPPORTED_ROUTER_GATEWAY_CATEGORY = "18000";
    public static final String SUPPORTED_SECURITY_CATEGORY = "19000";
    public static final String SUPPORTED_SENSOR_CATEGORY = "20000";
    public static final String SUPPORTED_SHADE_CATEGORY = "21000";
    public static final String SUPPORTED_SOCIAL_CATEGORY = "22000";
    public static final String SUPPORTED_SWITCH_CATEGORY = "23000";
    public static final String SUPPORTED_TOYS_CATEGORY = "24000";
    public static final String SUPPORTED_TRANSPORTATION_CATEGORY = "25000";
    public static final String SUPPORTED_VIDEOS_CATEGORY = "26000";
    public static final String SUPPORTED_WATER_CATEGORY = "27000";
    public static final String SUPPORTED_APPLIANCES_CATEGORY = "28000";

    private Context m_Context = null;
    private boolean m_bDeviceDependency = false;
    private boolean m_bPresenceGateway = false;
    private boolean m_bSupportDeviceRequest = false;
    private String m_sDeviceType = null;

    public PPAddDeviceJsonParser(Context context) {
        this.m_Context = context;
    }

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        m_addDeviceModelArrayList = (ArrayList<PPAddDeviceModel>) obj[0];
        m_sDeviceType = (String) obj[1];
        m_bDeviceDependency = (boolean) obj[2];

        PPAddDeviceJsonListener listener = null;
        m_supportDeviceArrayList = (ArrayList<PPAddDeviceModel>) obj[3];
        listener = new PPAddDevicePresence();

        return listener.onSetDataWithJson(jso, obj);
    }

    /**
     * Check device is available in category for dependency device list
     */
    private boolean isDeviceInAvailable(JSONArray jaArrayProperty, String category) {
        JSONObject json = null;
        JSONObject jsonAttr = null;
        JSONArray jaAttributes = null;

        try {

            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                int nArrayName = jaArrayProperty.size();
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
                    int deviceTypeId = (json.containsKey("id")) ? json.getInteger("id") : 0;
                    if (deviceTypeId == PPCommonInfo.INT_CENTRALITE_SMART_PLUG) {
                        AddDeviceModel.setName(m_Context.getString(R.string.presence_smart_plug));
                    } else {
                        AddDeviceModel.setName((json.containsKey("name")) ? json.getString("name") : null);
                    }
                    AddDeviceModel.setEditable(json.getBoolean("editable"));
                    jaAttributes = (json.containsKey("attributes")) ? json.getJSONArray("attributes") : null;
                    if (jaAttributes != null) {
                        int attCount = jaAttributes.size();
                        AddDeviceModel.listAddDeviceAttributeModel = new ArrayList<PPAddDeviceAttributeModel>(jaAttributes.size());
                        for (int attIdx = 0; attIdx < attCount; attIdx++) {
                            jsonAttr = jaAttributes.getJSONObject(attIdx);
                            PPAddDeviceAttributeModel AddDeviceAttributeModel = new PPAddDeviceAttributeModel();
                            AddDeviceAttributeModel.setAttrName((jsonAttr.containsKey("name")) ? jsonAttr.getString("name") : null);
                            AddDeviceAttributeModel.setsAttrValue((jsonAttr.containsKey("value")) ? jsonAttr.getString("value") : null);
                            AddDeviceModel.listAddDeviceAttributeModel.add(AddDeviceAttributeModel);
                        }
                        for (int attIdx = 0; attIdx < attCount; attIdx++) {
                            if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrName().equals("category")) {
                                if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrValue().equals(category)) {
                                    for (int attrIdx = 0; attrIdx < attCount; attrIdx++) {
                                        if (AddDeviceModel.listAddDeviceAttributeModel.get(attrIdx).getAttrName().equals("available")) {
                                            if (!AddDeviceModel.listAddDeviceAttributeModel.get(attrIdx).getAttrValue().equals("0")) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    /*
     * Need to check and change to use context to get xml string.
     */
    private void setListSeparator(String category) {
        PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
        AddDeviceModel.setAsSeparator(true);
        String sSeparatorName = null;
        Context ctx = PPVirtuoso.getInstance().getContext();
        if (category.equals(SUPPORTED_METER_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_meter);
        } else if (category.equals(SUPPORTED_CENTRALITE_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_monster);
        } else if (category.equals(SUPPORTED_SOLAR_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_solar);
        } else if (category.equals(SUPPORTED_THERMOSTAT_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_thermostats);
        } else if (category.equals(SUPPORTED_LOCK_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_locks);
        } else if (category.equals(SUPPORTED_VIDEO_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_videos);
        } else if (category.equals(SUPPORTED_MISCELLANEOUS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_miscellaneous);
        } else if (category.equals(SUPPORTED_ADMIN_TOOLS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_admin_tools);
        } else if (category.equals(SUPPORTED_ALARMS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_alarms);
        } else if (category.equals(SUPPORTED_ANALYIZE_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_analytics);
        } else if (category.equals(SUPPORTED_SAFETY_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_safety);
        } else if (category.equals(SUPPORTED_AUDIO_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_audio);
        } else if (category.equals(SUPPORTED_CAMERAS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_cameras);
        } else if (category.equals(SUPPORTED_CLIMATE_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_climate_control);
        } else if (category.equals(SUPPORTED_DISPLAYS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_displays);
        } else if (category.equals(SUPPORTED_ENVIRONMENTAL_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_environmental);
        } else if (category.equals(SUPPORTED_HEALTH_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_health);
        } else if (category.equals(SUPPORTED_LIGHTING)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_lighting);
        } else if (category.equals(SUPPORTED_LOCKS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_locks);
        } else if (category.equals(SUPPORTED_MEDIA_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_media);
        } else if (category.equals(SUPPORTED_METERS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_meters);
        } else if (category.equals(SUPPORTED_PRIMETER_MONITORING_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_perimeter_monitoring);
        } else if (category.equals(SUPPORTED_REMOTE_CONTROL_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_remote_control);
        } else if (category.equals(SUPPORTED_ROBOTICS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_robotics);
        } else if (category.equals(SUPPORTED_ROUTER_GATEWAY_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_other_gateway);
        } else if (category.equals(SUPPORTED_SENSOR_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_sensors);
        } else if (category.equals(SUPPORTED_METERS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_meters);
        } else if (category.equals(SUPPORTED_HEALTH_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_health);
        } else if (category.equals(SUPPORTED_MOBILE_CAMERA_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.remote_camera);
        } else if (category.equals(SUPPORTED_SECURITY_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_security);
        } else if (category.equals(SUPPORTED_SOCIAL_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_social);
        } else if (category.equals(SUPPORTED_SWITCH_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_switches);
        } else if (category.equals(SUPPORTED_TOYS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_toys);
        } else if (category.equals(SUPPORTED_TRANSPORTATION_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_transportation);
        } else if (category.equals(SUPPORTED_VIDEOS_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_videos);
        } else if (category.equals(SUPPORTED_WATER_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_water);
        } else if (category.equals(SUPPORTED_APPLIANCES_CATEGORY)) {
            sSeparatorName = ctx.getResources().getString(R.string.separator_appliances);
        } else {
            sSeparatorName = ctx.getResources().getString(R.string.unnamed_device);
        }
        AddDeviceModel.setSeparatorName(sSeparatorName);
        m_addDeviceModelArrayList.add(AddDeviceModel);
    }

    private String getLocalizedDeviceName(int deviceType) {
        Context ctx = PPVirtuoso.getInstance().getContext();
        String result = null;
        switch (deviceType) {
            case PPCommonInfo.INT_GREEN_GATEWAY:
                result = ctx.getString(R.string.device_name_presence_gateway);
                break;
            case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
                result = ctx.getString(R.string.device_name_entry_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221:
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101:
            case PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211:
                result = ctx.getString(R.string.device_name_develco_gateway);
                break;
            case PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR:
                result = ctx.getString(R.string.device_name_develco_entry_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_KEYPAD:
                result = ctx.getString(R.string.device_name_develco_kepad);
                break;
            case PPCommonInfo.INT_DEVELCO_SIREN:
                result = ctx.getString(R.string.device_name_develco_siren);
                break;
            case PPCommonInfo.INT_DEVELCO_WATER_SENSOR:
                result = ctx.getString(R.string.device_name_develco_water_sensor);
                break;
            case PPCommonInfo.INT_DEVELCO_BUTTON:
                result = ctx.getString(R.string.device_name_develco_button);
                break;
            case PPCommonInfo.INT_DEVELCO_MOTION_SENSOR:
                result = ctx.getString(R.string.device_name_develco_motion_sensor);
                break;
            case PPCommonInfo.INT_LEAK_DETECTOR:
                result = ctx.getString(R.string.device_name_water_sensor);
                break;
            case PPCommonInfo.INT_TOUCH_SENSOR:
                result = ctx.getString(R.string.device_name_touch_sensor);
                break;
            case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                result = ctx.getString(R.string.device_name_temperature_sensor);
                break;
            case PPCommonInfo.INT_HUMIDITY_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_sensor);
                break;
            case PPCommonInfo.INT_MOTION_SENSOR:
                result = ctx.getString(R.string.device_name_motion_sensor);
                break;
            case PPCommonInfo.INT_GE_LIGHT_BULB:
                result = ctx.getString(R.string.device_name_smart_led);
                break;
            case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                result = ctx.getString(R.string.device_name_smart_plug);
                break;
            case PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_temp_sensor);
                break;
            case PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR:
                result = ctx.getString(R.string.device_name_humidity_temp_light_sensor);
                break;
        }

        return result;
    }

    /**
     * Check device in category
     */
    private boolean isDeviceInCategory(JSONArray jaArrayProperty, String category) {
        JSONObject json = null;
        JSONObject jsonAttr = null;
        JSONArray jaAttributes = null;

        try {

            if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                int nArrayName = jaArrayProperty.size();
                for (int i = 0; i < nArrayName; i++) {
                    json = jaArrayProperty.getJSONObject(i);
                    PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
                    int deviceTypeId = (json.containsKey("id")) ? json.getInteger("id") : 0;
                    AddDeviceModel.setDeviceTypeId(deviceTypeId);
                    if (deviceTypeId == PPCommonInfo.INT_CENTRALITE_SMART_PLUG) {
                        AddDeviceModel.setName(m_Context.getString(R.string.presence_smart_plug));
                    } else {
                        AddDeviceModel.setName((json.containsKey("name")) ? json.getString("name") : null);
                    }
                    AddDeviceModel.setEditable(json.getBoolean("editable"));
                    jaAttributes = (json.containsKey("attributes")) ? json.getJSONArray("attributes") : null;
                    if (jaAttributes != null) {
                        int attCount = jaAttributes.size();
                        AddDeviceModel.listAddDeviceAttributeModel = new ArrayList<PPAddDeviceAttributeModel>(jaAttributes.size());
                        for (int attIdx = 0; attIdx < attCount; attIdx++) {
                            jsonAttr = jaAttributes.getJSONObject(attIdx);
                            PPAddDeviceAttributeModel AddDeviceAttributeModel = new PPAddDeviceAttributeModel();
                            AddDeviceAttributeModel.setAttrName((jsonAttr.containsKey("name")) ? jsonAttr.getString("name") : null);
                            AddDeviceAttributeModel.setsAttrValue((jsonAttr.containsKey("value")) ? jsonAttr.getString("value") : null);
                            AddDeviceModel.listAddDeviceAttributeModel.add(AddDeviceAttributeModel);
                        }
                        for (int attIdx = 0; attIdx < attCount; attIdx++) {
                            if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrName().equals("category")) {
                                if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrValue().equals(category)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    private interface PPAddDeviceJsonListener {

        public boolean onSetDataWithJson(JSONObject jso, Object[] obj);
    }

    private class PPAddDevicePresence implements PPAddDeviceJsonListener {

        @Override
        public boolean onSetDataWithJson(JSONObject jso, Object[] obj) {
            try {
                JSONArray jaArrayProperty = null;
                //All device type
                if (!m_bDeviceDependency) {
                    jaArrayProperty = (jso.containsKey("deviceTypes")) ? jso.getJSONArray("deviceTypes") : null;
                    //Check category add device list to decide separator
                    //This is for Presence Gateway.
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ROUTER_GATEWAY_CATEGORY)) {
                        m_bPresenceGateway = true;
//                    setListSeparator(SUPPORTED_GATEWAY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ROUTER_GATEWAY_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SENSOR_CATEGORY)) {
                        setListSeparator(SUPPORTED_SENSOR_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SENSOR_CATEGORY);
                    }
                    //This is for supported Gateway.
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ROUTER_GATEWAY_CATEGORY)) {
                        setListSeparator(SUPPORTED_ROUTER_GATEWAY_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ROUTER_GATEWAY_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_METER_CATEGORY)) {
                        setListSeparator(SUPPORTED_METER_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_METER_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_CENTRALITE_CATEGORY)) {
                        setListSeparator(SUPPORTED_CENTRALITE_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_CENTRALITE_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SOLAR_CATEGORY)) {
                        setListSeparator(SUPPORTED_SOLAR_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SOLAR_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_THERMOSTAT_CATEGORY)) {
                        setListSeparator(SUPPORTED_THERMOSTAT_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_THERMOSTAT_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_LOCK_CATEGORY)) {
                        setListSeparator(SUPPORTED_LOCK_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_LOCK_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_MOBILE_CAMERA_CATEGORY)) {
                        setListSeparator(SUPPORTED_MOBILE_CAMERA_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_MOBILE_CAMERA_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_VIDEO_CATEGORY)) {
                        setListSeparator(SUPPORTED_VIDEO_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_VIDEO_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_MISCELLANEOUS_CATEGORY)) {
                        setListSeparator(SUPPORTED_MISCELLANEOUS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_MISCELLANEOUS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ADMIN_TOOLS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ADMIN_TOOLS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ADMIN_TOOLS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ALARMS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ALARMS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ALARMS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ANALYIZE_CATEGORY)) {
                        setListSeparator(SUPPORTED_ANALYIZE_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ANALYIZE_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SAFETY_CATEGORY)) {
                        setListSeparator(SUPPORTED_SAFETY_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SAFETY_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_AUDIO_CATEGORY)) {
                        setListSeparator(SUPPORTED_AUDIO_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_AUDIO_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_CLIMATE_CATEGORY)) {
                        setListSeparator(SUPPORTED_CLIMATE_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_CLIMATE_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_CAMERAS_CATEGORY)) {
                        setListSeparator(SUPPORTED_CAMERAS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_CAMERAS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_DISPLAYS_CATEGORY)) {
                        setListSeparator(SUPPORTED_DISPLAYS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_DISPLAYS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ENVIRONMENTAL_CATEGORY)) {
                        setListSeparator(SUPPORTED_ENVIRONMENTAL_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ENVIRONMENTAL_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_HEALTH_CATEGORY)) {
                        setListSeparator(SUPPORTED_HEALTH_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_HEALTH_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_LIGHTING)) {
                        setListSeparator(SUPPORTED_LIGHTING);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_LIGHTING);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_LOCKS_CATEGORY)) {
                        setListSeparator(SUPPORTED_LOCKS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_LOCKS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_MEDIA_CATEGORY)) {
                        setListSeparator(SUPPORTED_MEDIA_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_MEDIA_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_METERS_CATEGORY)) {
                        setListSeparator(SUPPORTED_METERS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_METERS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_PRIMETER_MONITORING_CATEGORY)) {
                        setListSeparator(SUPPORTED_PRIMETER_MONITORING_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_PRIMETER_MONITORING_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_REMOTE_CONTROL_CATEGORY)) {
                        setListSeparator(SUPPORTED_REMOTE_CONTROL_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_REMOTE_CONTROL_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SECURITY_CATEGORY)) {
                        setListSeparator(SUPPORTED_SECURITY_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SECURITY_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SHADE_CATEGORY)) {
                        setListSeparator(SUPPORTED_SHADE_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SHADE_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SOCIAL_CATEGORY)) {
                        setListSeparator(SUPPORTED_SOCIAL_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SOCIAL_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_SWITCH_CATEGORY)) {
                        setListSeparator(SUPPORTED_SWITCH_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_SWITCH_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_TOYS_CATEGORY)) {
                        setListSeparator(SUPPORTED_TOYS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_TOYS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_TRANSPORTATION_CATEGORY)) {
                        setListSeparator(SUPPORTED_TRANSPORTATION_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_TRANSPORTATION_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_VIDEOS_CATEGORY)) {
                        setListSeparator(SUPPORTED_VIDEOS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_VIDEOS_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_WATER_CATEGORY)) {
                        setListSeparator(SUPPORTED_WATER_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_WATER_CATEGORY);
                    }
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_APPLIANCES_CATEGORY)) {
                        setListSeparator(SUPPORTED_APPLIANCES_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_APPLIANCES_CATEGORY);
                    }
                    // As the GALILEO_BLUETOOTH is not supported in android, so hide it
                    if (isDeviceInCategory(jaArrayProperty, SUPPORTED_ROBOTICS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ROBOTICS_CATEGORY);
                        addDeviceListOnCategory(jaArrayProperty, SUPPORTED_ROBOTICS_CATEGORY);
                    }
                } else {
                    //Dependency device type
                    jaArrayProperty = (jso.containsKey("deviceTypes")) ? jso.getJSONArray("deviceTypes") : null;
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SENSOR_CATEGORY)) {
                        setListSeparator(SUPPORTED_SENSOR_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SENSOR_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_METER_CATEGORY)) {
                        setListSeparator(SUPPORTED_METER_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_METER_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SOLAR_CATEGORY)) {
                        setListSeparator(SUPPORTED_SOLAR_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SOLAR_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_CENTRALITE_CATEGORY)) {
                        setListSeparator(SUPPORTED_CENTRALITE_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_CENTRALITE_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_THERMOSTAT_CATEGORY)) {
                        setListSeparator(SUPPORTED_THERMOSTAT_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_THERMOSTAT_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_LOCK_CATEGORY)) {
                        setListSeparator(SUPPORTED_LOCK_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_LOCK_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_MOBILE_CAMERA_CATEGORY)) {
                        setListSeparator(SUPPORTED_MOBILE_CAMERA_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_MOBILE_CAMERA_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_VIDEO_CATEGORY)) {
                        setListSeparator(SUPPORTED_VIDEO_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_VIDEO_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_MISCELLANEOUS_CATEGORY)) {
                        setListSeparator(SUPPORTED_MISCELLANEOUS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_MISCELLANEOUS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ADMIN_TOOLS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ADMIN_TOOLS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ADMIN_TOOLS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ALARMS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ALARMS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ALARMS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ANALYIZE_CATEGORY)) {
                        setListSeparator(SUPPORTED_ANALYIZE_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ANALYIZE_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SAFETY_CATEGORY)) {
                        setListSeparator(SUPPORTED_SAFETY_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SAFETY_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_AUDIO_CATEGORY)) {
                        setListSeparator(SUPPORTED_AUDIO_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_AUDIO_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_CAMERAS_CATEGORY)) {
                        setListSeparator(SUPPORTED_CAMERAS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_CAMERAS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_CLIMATE_CATEGORY)) {
                        setListSeparator(SUPPORTED_CLIMATE_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_CLIMATE_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_DISPLAYS_CATEGORY)) {
                        setListSeparator(SUPPORTED_DISPLAYS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_DISPLAYS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ENVIRONMENTAL_CATEGORY)) {
                        setListSeparator(SUPPORTED_ENVIRONMENTAL_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ENVIRONMENTAL_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_HEALTH_CATEGORY)) {
                        setListSeparator(SUPPORTED_HEALTH_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_HEALTH_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_LIGHTING)) {
                        setListSeparator(SUPPORTED_LIGHTING);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_LIGHTING);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_LOCKS_CATEGORY)) {
                        setListSeparator(SUPPORTED_LOCKS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_LOCKS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_MEDIA_CATEGORY)) {
                        setListSeparator(SUPPORTED_MEDIA_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_MEDIA_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_METERS_CATEGORY)) {
                        setListSeparator(SUPPORTED_METERS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_METERS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_PRIMETER_MONITORING_CATEGORY)) {
                        setListSeparator(SUPPORTED_PRIMETER_MONITORING_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_PRIMETER_MONITORING_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_REMOTE_CONTROL_CATEGORY)) {
                        setListSeparator(SUPPORTED_REMOTE_CONTROL_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_REMOTE_CONTROL_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ROUTER_GATEWAY_CATEGORY)) {
                        setListSeparator(SUPPORTED_ROUTER_GATEWAY_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ROUTER_GATEWAY_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SECURITY_CATEGORY)) {
                        setListSeparator(SUPPORTED_SECURITY_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SECURITY_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SHADE_CATEGORY)) {
                        setListSeparator(SUPPORTED_SHADE_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SHADE_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SOCIAL_CATEGORY)) {
                        setListSeparator(SUPPORTED_SOCIAL_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SOCIAL_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_SWITCH_CATEGORY)) {
                        setListSeparator(SUPPORTED_SWITCH_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_SWITCH_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_TOYS_CATEGORY)) {
                        setListSeparator(SUPPORTED_TOYS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_TOYS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_TRANSPORTATION_CATEGORY)) {
                        setListSeparator(SUPPORTED_TRANSPORTATION_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_TRANSPORTATION_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_VIDEOS_CATEGORY)) {
                        setListSeparator(SUPPORTED_VIDEOS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_VIDEOS_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_WATER_CATEGORY)) {
                        setListSeparator(SUPPORTED_WATER_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_WATER_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_APPLIANCES_CATEGORY)) {
                        setListSeparator(SUPPORTED_APPLIANCES_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_APPLIANCES_CATEGORY);
                    }
                    if (isDeviceInAvailable(jaArrayProperty, SUPPORTED_ROBOTICS_CATEGORY)) {
                        setListSeparator(SUPPORTED_ROBOTICS_CATEGORY);
                        addDeviceListOnDependency(jaArrayProperty, m_sDeviceType, SUPPORTED_ROBOTICS_CATEGORY);
                    }
                    getAllSupportDeviceList(jaArrayProperty);
                }
                getAllSupportDeviceList(jaArrayProperty);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        private void getAllSupportDeviceList(JSONArray jaArrayProperty) {
            JSONObject json = null;
            JSONObject jsonAttr = null;
            JSONArray jaAttributes = null;
            try {
                if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                    int nArrayName = jaArrayProperty.size();
                    for (int i = 0; i < nArrayName; i++) {
                        json = jaArrayProperty.getJSONObject(i);
                        PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
                        int deviceTypeId = (json.containsKey("id")) ? json.getInteger("id") : 0;
                        AddDeviceModel.setDeviceTypeId(deviceTypeId);
                        String name = getLocalizedDeviceName(deviceTypeId);
                        AddDeviceModel.setName((json.containsKey("name")) ? json.getString("name") : null);
                        AddDeviceModel.setEditable(json.getBoolean("editable"));
                        jaAttributes = (json.containsKey("attributes")) ? json.getJSONArray("attributes") : null;
                        if (jaAttributes != null) {
                            int attCount = jaAttributes.size();
                            AddDeviceModel.listAddDeviceAttributeModel = new ArrayList<PPAddDeviceAttributeModel>(jaAttributes.size());
                            for (int attIdx = 0; attIdx < attCount; attIdx++) {
                                jsonAttr = jaAttributes.getJSONObject(attIdx);
                                PPAddDeviceAttributeModel AddDeviceAttributeModel = new PPAddDeviceAttributeModel();
                                String attrName = (jsonAttr.containsKey("name")) ? jsonAttr.getString("name") : null;
                                AddDeviceAttributeModel.setAttrName(attrName);
                                if (attrName.equals("defaultDescription") && !PPUtil.isEmpty(name)) {
                                    AddDeviceAttributeModel.setsAttrValue(name);
                                } else {
                                    AddDeviceAttributeModel.setsAttrValue((jsonAttr.containsKey("value")) ? jsonAttr.getString("value") : null);
                                }
                                AddDeviceModel.listAddDeviceAttributeModel.add(AddDeviceAttributeModel);
                            }
                        }
                        m_supportDeviceArrayList.add(AddDeviceModel);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /**
         * Add device on same category
         */
        private void addDeviceListOnCategory(JSONArray jaArrayProperty, String category) {
            JSONObject json = null;
            JSONObject jsonAttr = null;
            JSONArray jaAttributes = null;
            try {
                boolean bTempDevice = false;
                if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                    int nArrayName = jaArrayProperty.size();
                    for (int i = 0; i < nArrayName; i++) {
                        json = jaArrayProperty.getJSONObject(i);
                        PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
                        AddDeviceModel.setDeviceTypeId((json.containsKey("id")) ? json.getInteger("id") : 0);
                        String name = getLocalizedDeviceName(AddDeviceModel.getDeviceTypeId());
                        if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_GALILEO_BLUETOOTH_40) {
                            continue;
                        } else if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_CENTRALITE_SMART_PLUG) {
                            AddDeviceModel.setName(m_Context.getString(R.string.presence_smart_plug));
                        } else {
                            AddDeviceModel.setName((json.containsKey("name")) ? json.getString("name") : null);
                        }
                        AddDeviceModel.setEditable(json.getBoolean("editable"));
                        jaAttributes = (json.containsKey("attributes")) ? json.getJSONArray("attributes") : null;
                        if (jaAttributes != null) {
                            int attCount = jaAttributes.size();
                            AddDeviceModel.listAddDeviceAttributeModel = new ArrayList<PPAddDeviceAttributeModel>(jaAttributes.size());
                            for (int attIdx = 0; attIdx < attCount; attIdx++) {
                                jsonAttr = jaAttributes.getJSONObject(attIdx);
                                PPAddDeviceAttributeModel AddDeviceAttributeModel = new PPAddDeviceAttributeModel();
                                String attrName = (jsonAttr.containsKey("name")) ? jsonAttr.getString("name") : null;
                                AddDeviceAttributeModel.setAttrName(attrName);
                                if (attrName.equals("defaultDescription") && !PPUtil.isEmpty(name)) {
                                    AddDeviceAttributeModel.setsAttrValue(name);
                                } else {
                                    AddDeviceAttributeModel.setsAttrValue((jsonAttr.containsKey("value")) ? jsonAttr.getString("value") : null);
                                }
                                AddDeviceModel.listAddDeviceAttributeModel.add(AddDeviceAttributeModel);
                            }
                            for (int attIdx = 0; attIdx < attCount; attIdx++) {
                                if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrName().equals("category")) {
                                    if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrValue().equals(category)) {
                                        if (category.equals(SUPPORTED_ROUTER_GATEWAY_CATEGORY)) {
                                            //if we need to support other gateways later, release condition when we support it.
                                            if (!m_bPresenceGateway) {
                                                if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_TED_GATEWAY) {
                                                    AddDeviceModel.setAsSeparator(false);
                                                    m_addDeviceModelArrayList.add(AddDeviceModel);
                                                } else if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
                                                    AddDeviceModel.setAsSeparator(false);
                                                    m_addDeviceModelArrayList.add(AddDeviceModel);
                                                } else if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY) {
                                                    AddDeviceModel.setAsSeparator(false);
//                                                m_addDeviceModelArrayList.add(AddDeviceModel);
                                                }
                                            } else {
                                                if (AddDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_GREEN_GATEWAY) {
                                                    AddDeviceModel.setAsSeparator(false);
                                                    m_addDeviceModelArrayList.add(AddDeviceModel);
                                                    m_bPresenceGateway = false;
                                                }
                                            }
                                        } else if (category.equals(SUPPORTED_METERS_CATEGORY)) {
                                            if (AddDeviceModel.getDeviceTypeId() != PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR) {
                                                AddDeviceModel.setAsSeparator(false);
                                                m_addDeviceModelArrayList.add(AddDeviceModel);
                                            }
                                        } else {
                                            if (AddDeviceModel.getDeviceTypeId() != PPCommonInfo.INT_GALILEO_BLUETOOTH_40
                                                && AddDeviceModel.getDeviceTypeId() != PPCommonInfo.INT_GALILEO_30_PIN
                                                && AddDeviceModel.getDeviceTypeId() != PPCommonInfo.INT_KUBI_BLUETOOTH_40) {
                                                AddDeviceModel.setAsSeparator(false);
                                                m_addDeviceModelArrayList.add(AddDeviceModel);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (OutOfMemoryError ex) {
                Runtime.getRuntime().gc();
            }

        }

        /**
         * Add device on same category with device dependency check
         */
        private void addDeviceListOnDependency(JSONArray jaArrayProperty, String deviceType, String category) {
            JSONObject json = null;
            JSONObject jsonAttr = null;
            JSONArray jaAttributes = null;
            try {
                if (jaArrayProperty != null && jaArrayProperty.size() > 0) {
                    int nArrayName = jaArrayProperty.size();
                    for (int i = 0; i < nArrayName; i++) {
                        json = jaArrayProperty.getJSONObject(i);
                        PPAddDeviceModel AddDeviceModel = new PPAddDeviceModel();
                        int deviceTypeId = (json.containsKey("id")) ? json.getInteger("id") : 0;
                        AddDeviceModel.setDeviceTypeId(deviceTypeId);
                        String name = getLocalizedDeviceName(deviceTypeId);
                        if (deviceTypeId == PPCommonInfo.INT_CENTRALITE_SMART_PLUG) {
                            AddDeviceModel.setName(m_Context.getString(R.string.presence_smart_plug));
                        } else {
                            AddDeviceModel.setName((json.containsKey("name")) ? json.getString("name") : null);
                        }
                        AddDeviceModel.setEditable(json.getBoolean("editable"));
                        jaAttributes = (json.containsKey("attributes")) ? json.getJSONArray("attributes") : null;
                        if (jaAttributes != null) {
                            int attCount = jaAttributes.size();
                            AddDeviceModel.listAddDeviceAttributeModel = new ArrayList<PPAddDeviceAttributeModel>(jaAttributes.size());
                            for (int attIdx = 0; attIdx < attCount; attIdx++) {
                                jsonAttr = jaAttributes.getJSONObject(attIdx);
                                PPAddDeviceAttributeModel AddDeviceAttributeModel = new PPAddDeviceAttributeModel();
                                String attrName = (jsonAttr.containsKey("name")) ? jsonAttr.getString("name") : null;
                                AddDeviceAttributeModel.setAttrName(attrName);
                                if (attrName.equals("defaultDescription") && !PPUtil.isEmpty(name)) {
                                    AddDeviceAttributeModel.setsAttrValue(name);
                                } else {
                                    AddDeviceAttributeModel.setsAttrValue((jsonAttr.containsKey("value")) ? jsonAttr.getString("value") : null);
                                }
                                AddDeviceModel.listAddDeviceAttributeModel.add(AddDeviceAttributeModel);
                            }
                            //Check category first and get dependency device type add attribute model also should be checked device is available.
                            for (int attIdx = 0; attIdx < attCount; attIdx++) {
                                if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrName().equals("category")) {
                                    if (AddDeviceModel.listAddDeviceAttributeModel.get(attIdx).getAttrValue().equals(category)) {
                                        for (int attrIdx = 0; attrIdx < attCount; attrIdx++) {
                                            if (AddDeviceModel.listAddDeviceAttributeModel.get(attrIdx).getAttrName().equals("dependencyDeviceTypes")) {
                                                if (AddDeviceModel.listAddDeviceAttributeModel.get(attrIdx).getAttrValue().contains(deviceType)) {
                                                    for (int attriIdx = 0; attriIdx < attCount; attriIdx++) {
                                                        if (AddDeviceModel.listAddDeviceAttributeModel.get(attriIdx).getAttrName().equals("available")) {
                                                            if (!AddDeviceModel.listAddDeviceAttributeModel.get(attriIdx).getAttrValue().equals("0")) {
                                                                AddDeviceModel.setAsSeparator(false);
                                                                m_addDeviceModelArrayList.add(AddDeviceModel);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
