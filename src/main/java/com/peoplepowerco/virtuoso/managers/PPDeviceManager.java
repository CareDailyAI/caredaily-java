package com.peoplepowerco.virtuoso.managers;

import android.text.TextUtils;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.interfaces.IPPDeviceParameters;
import com.peoplepowerco.virtuoso.interfaces.IPPRobotDefines;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPAddDeviceAttributeModel;
import com.peoplepowerco.virtuoso.models.PPAddDeviceModel;
import com.peoplepowerco.virtuoso.models.PPBillingInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceActivateModel;
import com.peoplepowerco.virtuoso.models.PPDeviceCommand;
import com.peoplepowerco.virtuoso.models.PPDeviceGoalsModel;
import com.peoplepowerco.virtuoso.models.PPDeviceInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceInstallationModel;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceParameterModel;
import com.peoplepowerco.virtuoso.models.PPDevicePropertyModel;
import com.peoplepowerco.virtuoso.models.PPDeviceRegisterModel;
import com.peoplepowerco.virtuoso.models.PPDeviceRegistrationInfoModel;
import com.peoplepowerco.virtuoso.models.PPGatewayInformationModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppAccessesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppDeviceTypesModel;
import com.peoplepowerco.virtuoso.models.appinfo.PPAppInstanceModel;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceFAQModel;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceMeasurmentHistoryModel;
import com.peoplepowerco.virtuoso.models.devices.PPFirmwareJobModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayOptionModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPProductsParametersModel;
import com.peoplepowerco.virtuoso.util.PPCameraUtils;
import com.peoplepowerco.virtuoso.util.PPUtil;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Manager for user devices.
 */
public class PPDeviceManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes, IPPRobotDefines, IPPDeviceParameters {

    private static final String TAG = PPDeviceManager.class.getSimpleName();
    private static PPDeviceManager instance = null;

    //used models
    private PPDeviceInfoModel m_DeviceInfoModel = null;
    private PPDeviceActivateModel m_DeviceActivateModel = null;
    private PPDeviceRegisterModel m_PPDeviceRegisterModel = null;
    private PPDeviceRegistrationInfoModel m_DeviceRegisterInfo = null;
    private PPBillingInfoModel m_BillingInfoModel = null;
    private PPDeviceInstallationModel m_installationModel = null;

    private List<PPDevicePropertyModel> m_DevicePropertyModelList = null;
    private List<PPDeviceParameterModel> m_DeviceParamModelList = null;
    private List<PPDeviceMeasurmentHistoryModel> m_deviceMeasurmentHistoryList = null;
    private List<PPDeviceMeasurmentHistoryModel> m_deviceHistoryList = null;

    private ArrayList<PPAppInstanceModel> m_appInstanceArrayList;
    private ArrayList<PPAppAccessesModel> m_accessArrayList;
    private ArrayList<PPAppDeviceTypesModel> m_deviceTypesArrayList;

    private List<PPDeviceFAQModel> m_deviceFAQModelList = null;
    private HashMap<String, String> m_deviceUpdatedParams = null;

    //list of devices and parameters
    private static List<PPDeviceInfoModel> m_DeviceInfoArrayList = null;
    private static List<PPDeviceParameterModel> m_DeviceParamModelArrayList = null;
    private static List<PPAddDeviceModel> m_SupportDeviceList = null;
    private static List<PPAddDeviceModel> m_SupportAllDeviceList = null;
    //This is for maxSlaves, notifySlavesNum attribute check for adding device is available
    private static List<PPAddDeviceModel> m_SupportDeviceListAddDeviceAvailable = null;
    private static List<PPDeviceGoalsModel> m_deviceGoallist = null;

    //support for firmware updates
    private List<PPFirmwareJobModel> m_FirmwareJobList;

    private List<PPProductsParametersModel> m_productParameterModelList;

    // ANDROID-1766
    public static PPDeviceInfoModel localCamera = null;
    public static boolean isLocalCameraRemoved = false;

    //last presence gateway
    String sLastPresenceGateway = null;

    /**
     * Hidden class constructor.
     */
    private PPDeviceManager() {
        init();
    }

    /**
     * Get the one and only instance of this class. The first calling thread will create an initial instance. This method will only be synchronized on the first call, thus it will not affect speed of
     * our app.
     */
    public static PPDeviceManager getInstance() {
        synchronized (PPDeviceManager.class) {
            if (instance == null) {
                instance = new PPDeviceManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);
        m_DeviceInfoModel = new PPDeviceInfoModel();
        m_DeviceActivateModel = new PPDeviceActivateModel();
        m_PPDeviceRegisterModel = new PPDeviceRegisterModel();
        m_DeviceRegisterInfo = new PPDeviceRegistrationInfoModel();
        m_BillingInfoModel = new PPBillingInfoModel();
        m_installationModel = new PPDeviceInstallationModel();
        m_appInstanceArrayList = new ArrayList<>();
        m_accessArrayList = new ArrayList<>();
        m_deviceTypesArrayList = new ArrayList<>();
        m_DevicePropertyModelList = new ArrayList<PPDevicePropertyModel>();
        m_DeviceParamModelList = new ArrayList<PPDeviceParameterModel>();
        m_deviceFAQModelList = new ArrayList<>();
        m_DeviceInfoArrayList = new ArrayList<PPDeviceInfoModel>();
        m_DeviceParamModelArrayList = new ArrayList<PPDeviceParameterModel>();
        m_SupportDeviceList = new ArrayList<PPAddDeviceModel>();
        m_SupportAllDeviceList = new ArrayList<PPAddDeviceModel>();
        m_SupportDeviceListAddDeviceAvailable = new ArrayList<PPAddDeviceModel>();
        m_deviceGoallist = new ArrayList<PPDeviceGoalsModel>();
        m_FirmwareJobList = new ArrayList<>();
        m_deviceMeasurmentHistoryList = new ArrayList<PPDeviceMeasurmentHistoryModel>();
        m_deviceHistoryList = new ArrayList<PPDeviceMeasurmentHistoryModel>();
        m_deviceUpdatedParams = new HashMap<>();
        m_productParameterModelList = new ArrayList<>();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_FirmwareJobList.clear();
            instance.m_FirmwareJobList = null;
            instance.m_DeviceInfoArrayList.clear();
            instance.m_DeviceInfoArrayList = null;
            instance.m_DeviceParamModelArrayList.clear();
            instance.m_DeviceParamModelArrayList = null;
            instance.m_SupportDeviceList.clear();
            instance.m_SupportDeviceList = null;
            instance.m_SupportAllDeviceList.clear();
            instance.m_SupportAllDeviceList = null;
            instance.m_SupportDeviceListAddDeviceAvailable.clear();
            instance.m_SupportDeviceListAddDeviceAvailable = null;
            instance.m_deviceGoallist.clear();
            instance.m_deviceGoallist = null;
            instance.m_DeviceInfoModel = null;
            instance.m_DeviceActivateModel = null;
            instance.m_PPDeviceRegisterModel = null;
            instance.m_DeviceRegisterInfo = null;
            instance.m_BillingInfoModel = null;
            instance.m_DevicePropertyModelList = null;
            instance.m_DeviceParamModelList = null;
            instance.m_deviceFAQModelList = null;
            instance.m_installationModel = null;
            instance.m_deviceMeasurmentHistoryList = null;
            instance.m_deviceHistoryList = null;
            instance.m_deviceUpdatedParams.clear();
            instance.m_deviceUpdatedParams = null;
            instance.m_productParameterModelList.clear();
            instance.m_productParameterModelList = null;
            instance = null;
        }
    }

    public List<PPFirmwareJobModel> getFirmwareJobList() {
        return m_FirmwareJobList;
    }

    /**
     * Get stored list of devices. This does not make a server call.
     */
    public List<PPDeviceInfoModel> getDeviceInfoArrayList() {
        return m_DeviceInfoArrayList;
    }

    public List<PPAddDeviceModel> getSupportDeviceList() {
        return m_SupportDeviceList;
    }

    public List<PPAddDeviceModel> getSupportAllDeviceList() {
        return m_SupportAllDeviceList;
    }

    public List<PPAddDeviceModel> getSupportDeviceListAddDeviceAvailable() {
        return m_SupportDeviceListAddDeviceAvailable;
    }

    public PPAppDeviceTypesModel findDeviceTypeById(int deviceType) {
        if (null != m_deviceTypesArrayList) {
            for (PPAppDeviceTypesModel model : m_deviceTypesArrayList) {
                if (model.id == deviceType) {
                    return model;
                }
            }
        }
        return null;
    }

    public List<PPAppInstanceModel> getAppInstanceArrayList() {
        return m_appInstanceArrayList;
    }

    public List<PPAppAccessesModel> getAppAccessArrayList() {
        return m_accessArrayList;
    }

    public List<PPAppDeviceTypesModel> getAppDeviceTypeArrayList() {
        return m_deviceTypesArrayList;
    }

    public List<PPDeviceMeasurmentHistoryModel> getDeviceMeasurmentHistoryList() {
        return m_deviceMeasurmentHistoryList;
    }

    /**
     * Check If there is disconnected device
     */
    public boolean hasDeviceDisconnected() {
        boolean isAvailable = false;
        int index = 0;
        int iLastIndex = getDeviceInfoArrayList().size();
        for (PPDeviceInfoModel currentDeviceInfoModel : getDeviceInfoArrayList()) {
            if ((index < iLastIndex) && (!currentDeviceInfoModel.bSeparator)) {
                if (!currentDeviceInfoModel.connected && !currentDeviceInfoModel.bLocalCamera) {
                    isAvailable = true;
                    break;
                }
            }
            index++;
        }
        return isAvailable;
    }

    public int getDeviceInfoCount() {
        int deviceCount = 0;
        for (PPDeviceInfoModel device : m_DeviceInfoArrayList) {
            if (device != null) {
                if (!device.bSeparator && !device.bLocalCamera) {
                    //Don't include the TED Gateway in device total Only the TED MTU LOAD (device type 1000) should be counted.
                    if ((device.type < PPCommonInfo.INT_TED_MTU_LOAD) || device.type > PPCommonInfo.INT_TED_MTU) {
                        deviceCount++;
                    }
                }
            }
        }
        return deviceCount;
    }


    public int getSensorDevicesCount() {
        int deviceCount = 0;
        for (PPDeviceInfoModel device : m_DeviceInfoArrayList) {
            if (device != null) {
                int numDeviceType = device.type;
                if (numDeviceType != PPCommonInfo.INT_PRESENCE_CAMARA &&
                    numDeviceType != PPCommonInfo.INT_PRESENCE_IOS_CAMERA &&
                    numDeviceType != PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA &&
                    numDeviceType != PPCommonInfo.INT_FOSCAM_IP_CAMERA &&
                    numDeviceType != PPCommonInfo.INT_AMTK_IP_CAMERA &&
                    numDeviceType != PPCommonInfo.INT_PPC_IP_CAMERA &&
                    numDeviceType != PPCommonInfo.INT_ALFAPRO_IP_CAMERA) {
                    ++deviceCount;
                }
            }
        }
        return deviceCount;
    }

    /**
     * Get Device Information for a device by its ID
     */
    public PPDeviceInfoModel getDeviceInfoByID(String deviceID) {
        for (PPDeviceInfoModel device : m_DeviceInfoArrayList) {
            if (device.id.equalsIgnoreCase(deviceID)) {
                return device;
            }
        }
        return null;
    }

    /**
     * Get shared devices from current list and add to provided list.
     */
    public void getSharedDevices(List<PPDeviceInfoModel> shared) {
        for (PPDeviceInfoModel device : m_DeviceInfoArrayList) {
            if (device.shared) {
                shared.add(device);
            }
        }
    }

    public ArrayList<PPDeviceInfoModel> getConnectedSiren() {
        ArrayList<PPDeviceInfoModel> sirenList = new ArrayList<>();
        if (m_DeviceInfoArrayList != null) {
            for (PPDeviceInfoModel curItem : m_DeviceInfoArrayList) {
                if (curItem.type == PPCommonInfo.INT_SIREN || curItem.type == PPCommonInfo.INT_LH_SIREN || curItem.type == PPCommonInfo.INT_DEVELCO_SIREN) {
                    if (curItem.connected) {
                        sirenList.add(curItem);
                    }
                }
            }
        }
        return sirenList;
    }

    public ArrayList<PPGatewayInformationModel> getDependencyGateways(List<Integer> dependencyDeviceTypes) {
        ArrayList<PPGatewayInformationModel> gatewayInfoList = null;
        if (null != dependencyDeviceTypes && !dependencyDeviceTypes.isEmpty()) {
            if (m_DeviceInfoArrayList != null) {
                gatewayInfoList = new ArrayList<>();
                for (PPDeviceInfoModel curItem : m_DeviceInfoArrayList) {
                    if (dependencyDeviceTypes.contains(curItem.type)) {
                        PPGatewayInformationModel gatewayInformationModel = new PPGatewayInformationModel();
                        gatewayInformationModel.setDeviceId(curItem.id);
                        gatewayInformationModel.setDeviceType(curItem.type);
                        gatewayInformationModel.setIsConnected(curItem.connected);
                        gatewayInformationModel.setDescription(curItem.desc);
                        gatewayInfoList.add(gatewayInformationModel);
                    }
                }
            }
        }
        return gatewayInfoList;
    }

    public ArrayList<PPGatewayInformationModel> getConnectedGateways(ArrayList<PPGatewayInformationModel> gatewayInfoList) {
        ArrayList<PPGatewayInformationModel> connectedGateways = new ArrayList<>();
        for (PPGatewayInformationModel curItem : gatewayInfoList) {
            if (curItem.getIsConnected()) {
                connectedGateways.add(curItem);
            }
        }
        return connectedGateways;
    }

    public PPDeviceInfoModel getConnectedGateway() {
        if (null != m_DeviceInfoArrayList) {
            for (PPDeviceInfoModel curItem : m_DeviceInfoArrayList) {
                if (curItem.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY) {
                    return curItem;
                }
            }
        }
        return null;
    }

    public PPDeviceInfoModel getConnectedAllSupportedGateway() {
        if (null != m_DeviceInfoArrayList) {
            for (PPDeviceInfoModel curItem : m_DeviceInfoArrayList) {
                if (curItem.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                    || curItem.type == PPCommonInfo.INT_GREEN_GATEWAY
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
                    return curItem;
                }
            }
        }
        return null;
    }

    public boolean hasConnectedGateway() {
        if (null != m_DeviceInfoArrayList) {
            for (PPDeviceInfoModel curItem : m_DeviceInfoArrayList) {
                if ((curItem.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                    || curItem.type == PPCommonInfo.INT_GREEN_GATEWAY
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
                    || curItem.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) && curItem.connected) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Gets the first newly registered device from the current device list.
     */
    public PPDeviceInfoModel getRegisteredDevice() {
        for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
            if (currModel.id.equals(m_PPDeviceRegisterModel.sDeviceId)) {
                return currModel;
            }
        }
        return null;
    }

    /**
     * Gets the last registered device id if it exists.
     *
     * @return String containing device id.
     */
    public String getRegisteredDeviceID() {
        if (m_PPDeviceRegisterModel != null && !TextUtils.isEmpty(m_PPDeviceRegisterModel.sDeviceId)) {
            return m_PPDeviceRegisterModel.sDeviceId;
        }
        return PPUtil.NULL_STRING;
    }

    public String getRegisteredDeviceType() {
        if (m_PPDeviceRegisterModel != null && !TextUtils.isEmpty(m_PPDeviceRegisterModel.sDeviceType)) {
            return m_PPDeviceRegisterModel.sDeviceType;
        }
        return PPUtil.NULL_STRING;
    }

    /**
     * Checks the current device list to see if a given device is currently online/connected. Note: This method does not make any server calls, so the caller should ensure that the list is recent by
     * making a call to a server GET method for devices and waiting until that request is complete before calling this method.
     *
     * @param deviceid Device ID of the device in question.
     * @return Returns true if the device exists and is currently online; false otherwise.
     */
    public boolean isDeviceConnected(String deviceid) {
        if (TextUtils.isEmpty(deviceid)) {
            return false;
        }
        for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
            if (deviceid.equals(currModel.id)) {
                return currModel.connected;
            }
        }
        return false;
    }

    public PPDeviceRegistrationInfoModel getDeviceRegisterInfo() {
        return m_DeviceRegisterInfo;
    }

    public PPDeviceActivateModel getDeviceActivateInfo() {
        return m_DeviceActivateModel;
    }

    /**
     * Checks current device list for a newly active sensor. This is a passive method and does not make any server calls. It is up to the user to do the proper GET for the latest device list as well
     * as ensuring the request is complete before calling this method.
     *
     * @return Returns true if a newly active sensor exists and false otherwise.
     */
    public boolean containsNewlyActiveSensor() {
        if (m_DeviceInfoArrayList != null) {
            for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
                if (currModel != null) {
                    if (currModel.newDevice) {
                        switch (currModel.type) {
                            case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
                            case PPCommonInfo.INT_MOTION_DETECTOR:
                            case PPCommonInfo.INT_MOTION_SENSOR:
                            case PPCommonInfo.INT_GE_LIGHT_BULB:
                            case PPCommonInfo.INT_LEAK_DETECTOR:
                            case PPCommonInfo.INT_TOUCH_SENSOR:
                            case PPCommonInfo.INT_TEMPERATURE:
                            case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                            case PPCommonInfo.INT_HUMIDITY_SENSOR:
                            case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                            case PPCommonInfo.INT_THERMOSTAT:
                            case PPCommonInfo.INT_SIREN:
                            case PPCommonInfo.INT_LH_SIREN:
                            case PPCommonInfo.INT_DEVELCO_SIREN:
                            case PPCommonInfo.INT_IN_WALL_SWITCH:
                            case PPCommonInfo.INT_DOOR_LOCK:
                            case PPCommonInfo.INT_EWIG_BUTTON:
                            case PPCommonInfo.INT_DEVELCO_BUTTON:
                                return true;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        return false;
    }

    public PPDeviceInfoModel getNewlyEcobeeThermostat() {
        if (m_DeviceInfoArrayList != null) {
            for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
                if (currModel != null
                    && currModel.newDevice
                    && currModel.type == PPCommonInfo.INT_ECOBEE_THERMOSTAT) {
                    return currModel;
                }
            }
        }
        return null;
    }

    public int containsNewActiveSensorType() {
        if (m_DeviceInfoArrayList != null) {
            for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
                if (currModel.newDevice) {
                    switch (currModel.type) {
                        case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
                        case PPCommonInfo.INT_MOTION_DETECTOR:
                        case PPCommonInfo.INT_MOTION_SENSOR:
                        case PPCommonInfo.INT_GE_LIGHT_BULB:
                        case PPCommonInfo.INT_LEAK_DETECTOR:
                        case PPCommonInfo.INT_TOUCH_SENSOR:
                        case PPCommonInfo.INT_TEMPERATURE:
                        case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                        case PPCommonInfo.INT_HUMIDITY_SENSOR:
                        case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                        case PPCommonInfo.INT_THERMOSTAT:
                        case PPCommonInfo.INT_SIREN:
                        case PPCommonInfo.INT_LH_SIREN:
                        case PPCommonInfo.INT_DEVELCO_SIREN:
                        case PPCommonInfo.INT_IN_WALL_SWITCH:
                        case PPCommonInfo.INT_DOOR_LOCK:
                        case PPCommonInfo.INT_EWIG_BUTTON:
                        case PPCommonInfo.INT_DEVELCO_BUTTON:
                            return currModel.type;
                        default:
                            break;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * Returns the first newly active sensor encountered in the device list. This is a passive method and does not make any server calls. It is up to the user to do the proper GET for the latest
     * device list as well as ensuring the request is complete before calling this method.
     *
     * @return Returns A newly active sensor if it exists and null otherwise.
     */
    public PPDeviceInfoModel getNewlyActiveSensor() {
        for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
            if (currModel.newDevice) {
                switch (currModel.type) {
                    case PPCommonInfo.INT_DOOR_WINDOW_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR:
                    case PPCommonInfo.INT_MOTION_DETECTOR:
                    case PPCommonInfo.INT_MOTION_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_MOTION_SENSOR:
                    case PPCommonInfo.INT_GE_LIGHT_BULB:
                    case PPCommonInfo.INT_LEAK_DETECTOR:
                    case PPCommonInfo.INT_TOUCH_SENSOR:
                    case PPCommonInfo.INT_TEMPERATURE:
                    case PPCommonInfo.INT_TEMPERATURE_SENSOR:
                    case PPCommonInfo.INT_HUMIDITY_SENSOR:
                    case PPCommonInfo.INT_CENTRALITE_SMART_PLUG:
                    case PPCommonInfo.INT_THERMOSTAT:
                    case PPCommonInfo.INT_SIREN:
                    case PPCommonInfo.INT_LH_SIREN:
                    case PPCommonInfo.INT_DEVELCO_SIREN:
                    case PPCommonInfo.INT_IN_WALL_SWITCH:
                    case PPCommonInfo.INT_DOOR_LOCK:
                    case PPCommonInfo.INT_EWIG_BUTTON:
                    case PPCommonInfo.INT_DEVELCO_BUTTON:
                    case PPCommonInfo.INT_DEVELCO_KEYPAD:
                    case PPCommonInfo.INT_DEVELCO_WATER_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_DEVICEIO:
                    case PPCommonInfo.INT_DEVELCO_SMART_CABLE:
                    case PPCommonInfo.INT_PRESSURE_PAD_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_MULITI_BUTTON:
                    case PPCommonInfo.INT_DEVELCO_AIR_QUALITY_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_HEAT_ALARM:
                    case PPCommonInfo.INT_DEVELCO_HUMIDITY_SENSOR:
                    case PPCommonInfo.INT_DEVELCO_VIBRATION_SENSOR:
                        return currModel;
                    default:
                        break;
                }
            }
        }

        return null;
    }

    /**
     * Checks current device list for an inactive gateway. This is a passive method and does not make any server calls. It is up to the user to do the proper GET for the latest device list as well as
     * ensuring the request is complete before calling this method. This currently checks for GreenPeak gateways by id and prefix.
     *
     * @return Returns true if an inactive gateway exists and false otherwise.
     */
    public boolean isGatewayRegistered(String gatewayId) {
        for (PPDeviceInfoModel item : m_DeviceInfoArrayList) {
            if ((item.type == PPCommonInfo.INT_GREEN_GATEWAY
                || item.type == PPCommonInfo.INT_X5_GATEWAY
                || item.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                || item.type == PPCommonInfo.INT_GREENX_PPC_HUB
                || item.type == PPCommonInfo.INT_TED_GATEWAY
                || item.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
                || item.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
                || item.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) && item.id.equals(gatewayId)) {
                return true;
            }
        }
        return false;
    }

    public List<PPDevicePropertyModel> getCurrentDeviceProperties() {
        return m_DevicePropertyModelList;
    }

    public List<PPDeviceParameterModel> getCurrentDeviceParameters() {
        return m_DeviceParamModelList;
    }

    public PPDeviceInfoModel getDeviceInfoByType(int deviceType) {
        for (PPDeviceInfoModel device : m_DeviceInfoArrayList) {
            if (device.type == deviceType) {
                return device;
            }
        }
        return null;
    }

    /**
     * Sets the next valid GreenPeak gateway name. These devices get the Prefix of "Presence Gateway" with a number based on the order of registration.
     */
    public void setNextGreenGatewayName() {
        StringBuilder sReturn = new StringBuilder();
        int iMaxIndex = 0;
        if (m_DeviceInfoArrayList != null) {
            for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
                if ((currModel.type == PPCommonInfo.INT_GREEN_GATEWAY) ||
                    (currModel.id.contains("LCGW"))) {

                    StringBuilder sb = new StringBuilder();
                    if (currModel.desc != null) {
                        for (char c : currModel.desc.toCharArray()) {
                            if (Character.isDigit(c)) {
                                sb.append(c);
                            }
                        }
                    } else {
                        if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
                            || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)) {
                            currModel.desc = "Smart Home Center";
                        } else {
                            currModel.desc = "Presence Gateway";
                        }
                    }

                    if (sb.length() > 0) {
                        int iGateway = Integer.parseInt(sb.toString());
                        if (iGateway >= iMaxIndex) {
                            iMaxIndex = iGateway + 1;
                        }
                    } else {
                        if (iMaxIndex == 0) {
                            iMaxIndex++;
                        }
                    }
                }
            }
        }

        //build name
        if (iMaxIndex > 0) {
            if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
                || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)) {
                sReturn.append("Smart Home Center");
            } else {
                sReturn.append("Presence Gateway ");
            }
            sReturn.append(Integer.toString(iMaxIndex));
        } else {
            if (PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_CARE)
                || PPAppCenter.APP_NAME.equals(PPCommonInfo.PPC_BRAND_FAMILY)) {
                sReturn.append("Smart Home Center");
            } else {
                sReturn.append("Presence Gateway");
            }
        }

        sLastPresenceGateway = sReturn.toString();
    }

    public PPDeviceInfoModel getNewIPCamera() {
        for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
            if (currModel.newDevice) {
                switch (currModel.type) {
                    //Can be added later...
                    case PPCommonInfo.INT_FOSCAM_IP_CAMERA:
                    case PPCommonInfo.INT_AMTK_IP_CAMERA:
                    case PPCommonInfo.INT_BAYCAM_IP_CAMERA:
                    case PPCommonInfo.INT_PPC_IP_CAMERA:
                    case PPCommonInfo.INT_ALFAPRO_IP_CAMERA:
                        return currModel;
                    default:
                        break;
                }
            }
        }
        return null;
    }

    public PPDeviceInfoModel getNewAddedDevice(int deviceType) {
        for (PPDeviceInfoModel currModel : m_DeviceInfoArrayList) {
            if (currModel.newDevice &&
                (deviceType == PPCommonInfo.PPInvalidValue || currModel.type == deviceType)) {
                return currModel;
            }
        }
        return null;
    }

    /*
     * Find device description from device Id.
     */
    public String findDeviceDescriptionById(String deviceId) {
        if (m_DeviceInfoArrayList == null) {
            return "";
        }
        for (PPDeviceInfoModel m_DeviceInfoModel : m_DeviceInfoArrayList) {
            if (m_DeviceInfoModel.id.equals(deviceId)) {
                if (m_DeviceInfoModel.desc.equals("")) {

                } else {
                    return m_DeviceInfoModel.desc;
                }
            }
        }
        return "";
    }

    public String findDeviceNameByDeviceType(int deviceType) {
        for (PPAddDeviceModel addDeviceModel : m_SupportDeviceList) {
            if (addDeviceModel.getDeviceTypeId() == deviceType) {
                return addDeviceModel.getName();
            }
        }
        return "";
    }

    public void recordPutParamTime(String sDeviceId, int status) {
        m_deviceUpdatedParams.put(sDeviceId, String.format("%d_%d", System.currentTimeMillis(), status));
    }

    public String getRecentParam(String sDeviceId) {
        if (m_deviceUpdatedParams.containsKey(sDeviceId)) {
            return m_deviceUpdatedParams.get(sDeviceId);
        }
        return null;
    }

    @Override
    public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
        switch (reqid) {
            case REQ_GET_DEVICE_LIST:
                setNextGreenGatewayName();
                break;
            default:
                break;
        }
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }

    @Override
    public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
        sendResultToListeners(reqid, arg1, arg2, result, tag);
    }


    /**
     * Sends a command or set of commands to a specific device.
     *
     * @param deviceid Device ID of the device to execute the command(s)
     * @param params Command parameters for the device to execute.
     */
    public void serverRequestPutDeviceParameters(String tag, String deviceid, List<JSONObject> params) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsObjParams = new JSONObject();
        try {
            jsonObj.put("deviceId", deviceid);
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsObjParams.put("params", params);
            jsonObj.put("paramsObj", jsObjParams);
            //API body format has been simplified.
            //now fill the params
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SEND_COMMAND, jsonObj);
    }

    /**
     * Set a device parameters
     */
    public void serverRequestPutDeviceParameters(String tag, List<JSONObject> params, String sDeviceId) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsObjParams = new JSONObject();

        try {
            jsObjParams.put("params", params);
            jsonObj.put("TAG", tag);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("paramsObj", jsObjParams);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SEND_COMMAND, jsonObj);
    }

    /**
     * Set a device parameter
     */
    public void serverRequestPutDeviceParameter(String tag, String sParamName, String sValue, String sDeviceId) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsObjParams = new JSONObject();

        try {
            //now fill the params
            List<JSONObject> params = new ArrayList<JSONObject>();
            JSONObject jsonObjCmd = new JSONObject();
            jsonObjCmd.put("name", sParamName);
            jsonObjCmd.put("value", sValue);
            params.add(jsonObjCmd);
            //API body format has been simplified.
            jsObjParams.put("params", params);

            jsonObj.put("TAG", tag);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("paramsObj", jsObjParams);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SEND_COMMAND, jsonObj);
    }

    public void serverRequestPutDeviceParameterNoLocation(String tag, String sParamName, String sValue, String sDeviceId) {
        JSONObject jsonObj = new JSONObject();
        JSONObject jsObjParams = new JSONObject();

        try {
            //now fill the params
            List<JSONObject> params = new ArrayList<JSONObject>();
            JSONObject jsonObjCmd = new JSONObject();
            jsonObjCmd.put("name", sParamName);
            jsonObjCmd.put("value", sValue);
            params.add(jsonObjCmd);
            //API body format has been simplified.
            jsObjParams.put("params", params);

            jsonObj.put("TAG", tag);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("paramsObj", jsObjParams);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SEND_COMMAND, jsonObj);
    }

    public void serverRequestPutDeviceParameterCommandType(String tag, String deviceid, String data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("deviceId", deviceid);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_SEND_COMMAND_TYPE, jsonObj);
    }

    /**
     * Get device attribute from server
     */
    public void serverRequestGetDeviceAttrs(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (m_SupportDeviceList != null) {
            m_SupportDeviceList.clear();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES, jsonObj);
    }

    /**
     * Get device attribute from server
     */
    public void serverRequestGetDeviceType(String tag, String attribute, String deviceType, boolean isDeviceDependency) {
        if (m_SupportDeviceList != null) {
            m_SupportDeviceList.clear();
        }
        if (m_SupportAllDeviceList != null) {
            m_SupportAllDeviceList.clear();
        }
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("attrName", attribute);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_PRODUCTS, jsonObj, new Object[]{m_SupportDeviceList, deviceType, isDeviceDependency, m_SupportAllDeviceList});
    }

    public void serverRequestGetDeviceType(String tag, JSONObject jsonObj, String deviceType, boolean isDeviceDependency) {
        if (m_SupportDeviceList != null) {
            m_SupportDeviceList.clear();
        }
        if (m_SupportAllDeviceList != null) {
            m_SupportAllDeviceList.clear();
        }
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_PRODUCTS, jsonObj, new Object[]{m_SupportDeviceList, deviceType, isDeviceDependency, m_SupportAllDeviceList});
    }

    public void serverRequestGetDeviceType(String tag, JSONObject jsonObj, String deviceType, boolean isDeviceDependency, boolean isSupportDeviceRequest) {
        if (m_SupportDeviceList != null) {
            m_SupportDeviceList.clear();
        }
        if (m_SupportAllDeviceList != null) {
            m_SupportAllDeviceList.clear();
        }
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_PRODUCTS, jsonObj, new Object[]{m_SupportDeviceList, deviceType, isDeviceDependency, m_SupportAllDeviceList, isSupportDeviceRequest});
    }

    /**
     * Get app information from server
     */
    public void serverRequestGetAppInformation(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_APP_INFORMATION, jsonObj, new Object[]{m_accessArrayList, m_deviceTypesArrayList});
    }

    /**
     * Get app instance from server
     */
    public void serverRequestGetAppInstance(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_APP_INSTANCE, jsonObj, new Object[]{m_appInstanceArrayList});
    }

    /**
     * Get device attribute from server
     */
    public void serverRequestGetDeviceTypeForAddDeviceAvailable(String tag, JSONObject jsonObj, String deviceType) {
        if (m_SupportDeviceListAddDeviceAvailable != null) {
            m_SupportDeviceListAddDeviceAvailable.clear();
        }
        if (m_SupportAllDeviceList != null) {
            m_SupportAllDeviceList.clear();
        }
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_SUPPORTED_PRODUCTS, jsonObj, new Object[]{m_SupportDeviceListAddDeviceAvailable, deviceType, false, m_SupportAllDeviceList});
    }

    /**
     * Device registration
     */
    public void serverRequestForGatewayRegistration(String tag, String strDeviceID, String strDeviceType) {
        JSONObject jsonObj = new JSONObject();
        String desc = null;

        //do we need a special name?
        if (strDeviceType != null) {
            if (PPCommonInfo.INT_GREEN_GATEWAY == Integer.parseInt(strDeviceType)) {
                desc = sLastPresenceGateway;
            }
        } else {
            if (strDeviceID.contains("LCGW")) {
                desc = sLastPresenceGateway;
            }
        }

        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
//            jsonObj.put("username", PPAppCenter.m_SharedPresence.getUserName());
            jsonObj.put("deviceId", strDeviceID);
            jsonObj.put("deviceType", strDeviceType);
            jsonObj.put("authToken", "false");
            jsonObj.put("desc", desc);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_REGISTER_GATEWAY, jsonObj, m_PPDeviceRegisterModel);
    }

    /**
     * Device registration
     */
    public void serverRequestForDeviceRegistration(String tag, String strDeviceID, String strDeviceType) {
        JSONObject jsonObj = new JSONObject();
        String desc = null;

        //do we need a special name?
        if (strDeviceType != null) {
            if (PPCommonInfo.INT_GREEN_GATEWAY == Integer.parseInt(strDeviceType)) {
                desc = sLastPresenceGateway;
            }
        } else {
            if (strDeviceID.contains("LCGW")) {
                desc = sLastPresenceGateway;
            }
        }

        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", strDeviceID);
            jsonObj.put("deviceType", strDeviceType);
            jsonObj.put("authToken", "false");
            jsonObj.put("desc", desc);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_REGISTER_DEVICE, jsonObj, m_DeviceRegisterInfo);
    }

    /**
     * Send IP Camera registration information to the server.
     *
     * @param devicetype Device type for this camera.
     * @param description Name for this device
     * @param properties A String containing the properties for this camera. (see docs)
     */
    public void serverRequestIPCameraDeviceRegistration(String tag,
        String devicetype,
        String description,
        String properties) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("deviceType", devicetype);
            jsonObj.put("desc", description);
            jsonObj.put("properties", properties);
            jsonObj.put("authToken", "false");
            jsonObj.put("TAG", tag);
            PPVirtuosoLogTrace.d(TAG, "Data Sending to server: " + jsonObj.toJSONString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_REGISTER_DEVICE, jsonObj, m_DeviceRegisterInfo);
    }

    /**
     * Request local camera device registration when it is deleted by other device
     */
    public void serverRequestLocalCameraDeviceRegistration(String tag, String strDeviceType, String strIsQRscan, String strDesc) {
        JSONObject jsonObj = new JSONObject();
        String sDeviceId = PPCommonInfo.GetDevicesUUID(m_Context) + "::" +
            PPVirtuoso.getInstance().getPrefs().getUserId();
        PPVirtuosoLogTrace.d("PPDeviceManager", "sDeviceId ============= " + sDeviceId);
        try {
            jsonObj.put("MAC", PPCommonInfo.getMacAddress(m_Context));
            jsonObj.put("QRSCAN", strIsQRscan);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("deviceType", strDeviceType);
            jsonObj.put("desc", strDesc);
            jsonObj.put("TAG", tag);
            jsonObj.put("authToken", "true");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_REGISTER_DEVICE, jsonObj, m_DeviceRegisterInfo);
    }

    /**
     * Delete a device by deviceID
     */
    public void serverRequestDeleteDevice(String tag, String strDevId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", strDevId.replace(" ", ""));
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_DEVICE, jsonObj);
    }

    /**
     * Get latest device properties from the server
     *
     * @param deviceId DeviceId for the device whos properties to retrieve
     */
    public void serverRequestGetDeviceProperties(String tag, String deviceId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_PROPERTY, jsonObj, new Object[]{m_DevicePropertyModelList});
    }

    /**
     * Get latest device parameters from the server
     *
     * @param deviceId DeviceId for the device whos parameters to retrieve
     */
    public void serverRequestGetDeviceParameter(String tag, String deviceId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("TAG", tag);
            m_CloudCommander.GetDataThreadPool(REQ_GET_CURRENT_MEASUREMENTS, jsonObj, new Object[]{m_DeviceParamModelList});
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverRequestGetDeviceIndexParameter(String tag, String deviceId, boolean bIndex) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("TAG", tag);
            m_CloudCommander.GetDataThreadPool(REQ_GET_CURRENT_MEASUREMENTS, jsonObj, new Object[]{m_DeviceParamModelList, bIndex});
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void serverRequestGetHistoryOfMeasurement(String tag, String startDate, String endDate, String deviceId, String paramName, String interval) {
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("startDate", startDate);
            jsonObj.put("endDate", endDate);
            jsonObj.put("paramName", paramName);
            if (!TextUtils.isEmpty(interval) && !interval.equals("-1")) {
                jsonObj.put("interval", interval);
            }
            jsonObj.put("aggregation", "0");
            jsonObj.put("TAG", tag);
            m_CloudCommander.GetDataThreadPool(REQ_GET_MEASUREMENT_HISTORY, jsonObj, new Object[]{m_deviceMeasurmentHistoryList});
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  Get device parameter
     *  @param secondary true if the secondary parser should be used and false otherwise.
     *                  This avoids interrupting existing requests such as the long poll
     *                  for HTTP commands.
     */
//    public void serverRequestGetDeviceParameters(boolean secondary) {
//        m_DeviceParamModelArrayList.clear();
//        JSONObject jsonObj = new JSONObject();
//        try{
//            jsonObj.put("UserKey", PPAppCenter.m_SharedPresence.getUserKey());
//            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
//        } catch (JSONException e){
//            e.printStackTrace();
//        }
//        if(secondary) {
//            m_parserSecondary.GetDataThreadPool(REQ_DEVICE_PARAMETERS, jsonObj, new Object[]{m_DeviceParamModelArrayList});
//        } else {
//            m_parserMain.GetData(REQ_DEVICE_PARAMETERS, jsonObj, new Object[]{m_DeviceParamModelArrayList});
//        }
//    }

//    /**
//     * Get device parameter time stamp
//     */
//    public void serverRequestGetDeviceParametersTimeStamp(String deviceId) {
//        JSONObject jsonObj = new JSONObject();
//        try {
//            jsonObj.put("locationId", PPVirtuoso.getInstance(null).getPrefs().getLocationId());
//            if (deviceId != null) {
//                jsonObj.put("deviceId", deviceId);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        m_parserSecondary.GetDataThreadPool(REQ_GET_CURRENT_MEASUREMENTS, jsonObj, new Object[]{m_DeviceParamModelArrayList});
//    }

    /**
     * Request device information (Request device list according to strType, This is to request server and reduce the loading time without response)
     */
    public void serverRequestGetDeviceInfo(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("checkPersistent", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_LIST, jsonObj, m_DeviceInfoArrayList);
    }

    public void serverRequestGetSimpleDeviceList(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("checkPersistent", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_SIMPLE_DEVICE_LIST, jsonObj);
    }

    public void serverRequestNewAddedDeviceList(String tag, List<PPDeviceInfoModel> newDevices) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("checkPersistent", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_LIST, jsonObj, new Object[]{m_DeviceInfoArrayList, newDevices});
    }

    /**
     * Request device information (Request device list according to strType, This is to request server and reduce the loading time without response)
     */
    public void serverRequestGetDeviceSeparateInfo(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("checkPersistent", "true");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_SEPARATE_INFO, jsonObj, new Object[]{m_DeviceInfoArrayList});
    }

    /**
     * Request Device activation
     */
    public void serverRequestGetDeviceActivate(String tag, String sDeviceType) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceType", sDeviceType);
            jsonObj.put("sendEmail", "false");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION, jsonObj, new Object[]{m_DeviceActivateModel});
    }

    /**
     * Update device information
     */
    public void serverRequestUpdateDeviceInfo(String tag, String sDeviceId, String locationId, JSONObject jsonObject) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("locationId", locationId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_DEVICE, jsonObj, jsonObject);
    }

//    /**
//     * //Gateway delete (TED)
//     * @param strDevId
//     */
//    public void serverRequestDeleteGateway(String strDevId)
//    {
//        JSONObject jsonObj = new JSONObject();
//        try{
//            jsonObj.put("deviceId", strDevId.replace(" ", ""));
//        } catch (JSONException e){
//            e.printStackTrace();
//        }
//        m_parserMain.DeleteDataThreadPool(REQ_GATEWAY_DELETE, jsonObj);
//    }

    /**
     * Request get billing information for switch devices
     */
    public void serverRequestGetBillingInfo(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            //filter 0 - get all data, 1 - billing day, 2 - budget, 4 - all rate info, 8 - only current rate
            jsonObj.put("filter", "4");
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_BILLING_INFORMATION, jsonObj, m_BillingInfoModel);
    }

    /**
     * Request get billing information for switch devices
     */
    public void serverRequestGetBillingInfo(String tag, String filter) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            //filter 0 - get all data, 1 - billing day, 2 - budget, 4 - all rate info, 8 - only current rate
            jsonObj.put("filter", filter);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_BILLING_INFORMATION, jsonObj, m_BillingInfoModel);
    }

    public PPBillingInfoModel getBillingInfoModel() {
        return m_BillingInfoModel;
    }

    /**
     * Update billing information
     */
    public void serverRequestPutBillingInfo(String tag, JSONObject jsonObjBillInfo) {
        JSONObject jsonObj = new JSONObject();
        //JSONObject jsonObjBillInfo = new JSONObject();
        //String billingRateId = Integer.toString(m_PPBillingInfoModel.getBillingRateId());
        try {
            jsonObj.put("locationId", PPVirtuoso.getInstance().getPrefs().getLocationId());
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_BILLING_INFORMATION, jsonObj, jsonObjBillInfo);
    }

    public void ioServerSetDeviceDefaultParameter(String tag, String strHost, String strPort) {
        JSONObject jsonObj = new JSONObject();
        String sDeviceId = PPCommonInfo.GetDevicesUUID(m_Context) + "::" +
            PPVirtuoso.getInstance().getPrefs().getUserId();
        PPVirtuosoLogTrace.d(TAG, "sDeviceId ============= " + sDeviceId);
        List<JSONObject> m_deviceDefaultParametersList = null;
        try {
            m_deviceDefaultParametersList = PPCameraUtils.prepareJSONForDeviceCamera(m_Context);
            jsonObj.put("HostName", strHost);
            jsonObj.put("Port", strPort);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("EspToken", PPVirtuoso.getInstance().getPrefs().getEspToken());
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_SET_DEVICE_DEFAULT_PARAMETER, jsonObj, m_deviceDefaultParametersList.toArray());
    }

    public void ioServerSetDeviceDefaultForEachParameter(String tag, String strHost, String strPort, String parameter, String value, String commandId) {
        JSONObject jsonObj = new JSONObject();
        String sDeviceId = PPCommonInfo.GetDevicesUUID(m_Context) + "::" +
            PPVirtuoso.getInstance().getPrefs().getUserId();
        PPVirtuosoLogTrace.d(TAG, "sDeviceId ============= " + sDeviceId);
        List<JSONObject> deviceDefaultParameter = null;
        try {
            deviceDefaultParameter = PPCameraUtils.JSONForEachParameterDeviceCamera(m_Context, parameter, value);
            jsonObj.put("HostName", strHost);
            jsonObj.put("Port", strPort);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("EspToken", PPVirtuoso.getInstance().getPrefs().getEspToken());
            jsonObj.put("TAG", tag);
            if (commandId != null) {
                jsonObj.put("commandId", commandId);
                jsonObj.put("result", "1");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_SET_DEVICE_DEFAULT_PARAMETER, jsonObj, deviceDefaultParameter.toArray());
    }

    public void serverRequestGoalsList(String tag, String deviceType) {
        JSONObject jsonObj = new JSONObject();
        if (m_deviceGoallist != null) {
            m_deviceGoallist.clear();
        }
        try {
            jsonObj.put("deviceTypeId", deviceType);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_GOALS_BY_TYPE, jsonObj, new Object[]{m_deviceGoallist});
    }

    public void serverRequestGoalsListByAppName(String tag, String deviceType, String appName) {
        JSONObject jsonObj = new JSONObject();
        if (m_deviceGoallist != null) {
            m_deviceGoallist.clear();
        }
        try {
            jsonObj.put("deviceTypeId", deviceType);
            jsonObj.put("appName", appName);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_GOALS_BY_TYPE, jsonObj, new Object[]{m_deviceGoallist});
    }

    public List<PPDeviceGoalsModel> getDeviceGoalList() {
        return m_deviceGoallist;
    }

    public void serverRequestInstallationDetail(String tag, String goalId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("goalId", goalId);
            jsonObj.put("appName", PPAppCenter.APP_NAME);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS, jsonObj, m_installationModel);
    }

    public PPDeviceInstallationModel getInstallationModel() {
        return m_installationModel;
    }

    public void serverRequestDeviceFAQ(String tag, String locale, String device) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locale", locale);
            jsonObj.put("device", device);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_DEVICE_FAQ, jsonObj, m_deviceFAQModelList);
    }

    public List<PPDeviceFAQModel> getDeviceFAQModelList() {
        return m_deviceFAQModelList;
    }


    public void serverRequestProductParameters(String tag, String paramName) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("paramName", paramName);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_PRODUCT_PARAMETERS, jsonObj, new Object[]{m_productParameterModelList});
    }

//    // https://app.presencepro.com/cloud/json/devices?locationId=locationId&deviceId=deviceId&deviceType=deviceType&authToken=authToken&startDate=startDate&desc=desc
//    public static final short REQ_POST_REGISTER_DEVICE                      = 150;
//
//    // https://app.presencepro.com/cloud/json/devices?locationId=locationId&userId=userId&checkPersistent=checkPersistent
//    public static final short REQ_GET_DEVICE_LIST                           = 151;
//
//    // https://app.presencepro.com/cloud/json/devices?deviceId=deviceId&clear=clear
//    public static final short REQ_DELETE_DEVICE                             = 152;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId?checkConnected=checkConnected&locationId=locationId&userId=userId
//    public static final short REQ_GET_SINGLE_DEVICE                         = 153;
//
//    // https://app.presencepro.com/cloud/json/devices/<deviceId>
//    public static final short REQ_PUT_UPDATE_DEVICE                         = 154;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId?clear=clear
//    public static final short REQ_DELETE_DEVICE                             = 155;
//
//    // https://app.presencepro.com/cloud/json/locations/<locationId>/devices/<deviceId>
//    public static final short REQ_PUT_UPDATE_DEVICE_AT_LOCATION             = 156;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/devices/deviceId?clear=clear
//    public static final short REQ_DELETE_DEVICE_AT_LOCATION                 = 157;
//
//    // https://app.presencepro.com/cloud/json/deviceActivation/deviceType?sendEmail=sendEmail
//    public static final short REQ_GET_DEVICE_ACTIVATION_INFO                = 158;
//
//    // https://app.presencepro.com/cloud/json/locations/locationId/deviceActivation/deviceType?sendEmail=sendEmail
//    public static final short REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION    = 159;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&value=value&index=index
//    public static final short REQ_PUT_SINGLE_DEVICE_PROPERTY                = 160;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/properties
//    public static final short REQ_PUT_MULTIPLE_DEVICE_PROPERTIES            = 161;

    /**
     * Set device property for twitter
     */
    public void serverRequestPutDeviceProperties(String tag, PPDeviceCommand m_DeviceCommand) {
        try {
            Object[] m_DeviceProperties = PPCameraUtils.prepareDeviceProperties(m_DeviceCommand);
            JSONObject jsonObj = new JSONObject();
            String sDeviceId = PPCommonInfo.GetDevicesUUID(m_Context) + "::" + PPAppCenter.m_SharedPresence.getUserId();
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("deviceId", sDeviceId);
            m_CloudCommander.PostDataThreadPool(REQ_PUT_MULTIPLE_DEVICE_PROPERTIES, jsonObj, m_DeviceProperties);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * Request to get a list of available firmware jobs This is to request server and reduce the loading time without response)
     */
    public void serverRequestGetFirmwareJobs(String tag) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_FIRMWARE_JOBS, jsonObj, new Object[]{m_FirmwareJobList});
    }

    /**
     * Set firmware update status
     */
    public void serverRequestSetFirmwareUpdateStatus(String tag, String sDeviceId, int status, long startDate) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("deviceId", sDeviceId);
            jsonObj.put("status", status);
            if (status == PPCommonInfo.INT_FIRMWARE_UPDATE_APPROVED && startDate != 0) {
                jsonObj.put("startDate", startDate);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_FIRMWARE_UPDATE_STATUS, jsonObj);
    }

    public void serverRequestPostDataRequest(String tag, String locationId, String data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("TAG", tag);
            jsonObj.put("locationId", locationId);
            jsonObj.put("data", data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.PostDataThreadPool(REQ_POST_DATA_REQUEST, jsonObj);
    }

//    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
//    public static final short REQ_GET_DEVICE_PROPERTY                       = 162;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
//    public static final short REQ_DELETE_DEVICE_PROPERTY                    = 163;

//    /* DEVICE MEASUREMENTS */
//    // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId&userId=userId&paramName=paramName
//    public static final short REQ_GET_CURRENT_MEASUREMENTS                  = 170;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId
//    public static final short REQ_PUT_SEND_COMMAND                          = 171;
//
//    // https://app.presencepro.com/cloud/json/parameters?locationId=locationId&userId=userId&deviceId=deviceId&paramName=paramName
//    public static final short REQ_GET_MEASUREMENTS_WITH_SEARCH              = 172;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByDate/startDate?endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&interval=interval&aggregation=aggregation&reduceNoise=reduceNoise
//    public static final short REQ_GET_MEASUREMENT_HISTORY                   = 173;
//
//    // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByCount/rowCount?startDate=startDate&endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&reduceNoise=reduceNoise
//    public static final short REQ_GET_LAST_N_MEASUREMENTS                   = 174;
//
//    // https://app.presencepro.com/cloud/json/units
//    public static final short REQ_GET_UNITS_OF_MEASURE                      = 175;

    public String findDeviceIconByListIcon(String iconName) {
        String unicodeString = null;
        if (null == iconName) {
            return null;
        }
        if (iconName.equals(PPCommonInfo.PP_ICON_2WAY_VIDEO)) {
            unicodeString = "\uEA01";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_50MB_STORAGE)) {
            unicodeString = "\uEA02";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_5GB_STORAGE)) {
            unicodeString = "\uEA03";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ACCOUNT_INFO)) {
            unicodeString = "\uEA04";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ADMIN_SUPER)) {
            unicodeString = "\uEA05";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ADMIN_SYSTEM)) {
            unicodeString = "\uEA06";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ADMIN)) {
            unicodeString = "\uEA07";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ALARM)) {
            unicodeString = "\uEA08";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ANONYMOUS)) {
            unicodeString = "\uEA09";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_AUTOMATE)) {
            unicodeString = "\uEA0A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BACK)) {
            unicodeString = "\uEA0B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BLOCKED)) {
            unicodeString = "\uEA0C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BUDGET)) {
            unicodeString = "\uEA0D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BULB)) {
            unicodeString = "\uEA0E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BULLET_ACTIVE)) {
            unicodeString = "\uEA0F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_BULLET)) {
            unicodeString = "\uEA10";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_ANDROID)) {
            unicodeString = "\uEA11";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_GALILEO)) {
            unicodeString = "\uEA12";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_IOS)) {
            unicodeString = "\uEA13";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_KUBI)) {
            unicodeString = "\uEA14";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_P360)) {
            unicodeString = "\uEA7C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_NAME)) {
            unicodeString = "\uEA15";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA)) {
            unicodeString = "\uEA16";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CHALLENGES_ALERT)) {
            unicodeString = "\uEA17";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CHALLENGES)) {
            unicodeString = "\uEA18";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CHECKBOX_ACTIVE)) {
            unicodeString = "\uEA19";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CHECKBOX)) {
            unicodeString = "\uEA1A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CONTACTS)) {
            unicodeString = "\uEA1B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_DELETE)) {
            unicodeString = "\uEA1C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_DEVICE_HISTORY)) {
            unicodeString = "\uEA1D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_DRYER)) {
            unicodeString = "\uEA1E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CALL_CENTER)) {
            unicodeString = "\uEA1F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_EMERGENCY)) {
            unicodeString = "\uEA20";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ENTRY)) {
            unicodeString = "\uEA21";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FACEBOOK)) {
            unicodeString = "\uEA22";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FAQ)) {
            unicodeString = "\uEA23";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FEEDBACK_BUG)) {
            unicodeString = "\uEA24";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FEEDBACK_CROWD)) {
            unicodeString = "\uEA25";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FEEDBACK_FEATURE)) {
            unicodeString = "\uEA26";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FEEDBACK_PRO)) {
            unicodeString = "\uEA27";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FEEDBACK)) {
            unicodeString = "\uEA28";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FLASHLIGHT_OFF)) {
            unicodeString = "\uEA29";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FLASHLIGHT)) {
            unicodeString = "\uEA2A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FLIP_CAMERA)) {
            unicodeString = "\uEA2B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FRIENDS)) {
            unicodeString = "\uEA2C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_GATEWAY)) {
            unicodeString = "\uEA2D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_GEOFENCING)) {
            unicodeString = "\uEA2E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_GET_PRO)) {
            unicodeString = "\uEA2F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_GLOBE)) {
            unicodeString = "\uEA30";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_GROUPS)) {
            unicodeString = "\uEA31";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_HELP)) {
            unicodeString = "\uEA32";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_HUMIDITY)) {
            unicodeString = "\uEA33";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_INFO)) {
            unicodeString = "\uEA34";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_INVALID)) {
            unicodeString = "\uEA35";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEVEL_1)) {
            unicodeString = "\uEA36";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEVEL_2)) {
            unicodeString = "\uEA37";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEVEL_3)) {
            unicodeString = "\uEA38";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEVEL_4)) {
            unicodeString = "\uEA39";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEVEL_5)) {
            unicodeString = "\uEA3A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LOCK)) {
            unicodeString = "\uEA3B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MESSAGES_ALERT)) {
            unicodeString = "\uEA3C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MESSAGES)) {
            unicodeString = "\uEA3D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_METER)) {
            unicodeString = "\uEA3E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MIC)) {
            unicodeString = "\uEA3F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MODE)) {
            unicodeString = "\uEA40";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_HOME)) {
            unicodeString = "\uEA76";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_AWAY)) {
            unicodeString = "\uEA75";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VACATION)) {
            unicodeString = "\uEA7B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SLEEP)) {
            unicodeString = "\uEA79";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TEST)) {
            unicodeString = "\uEA7A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MOTION_RECORDING)) {
            unicodeString = "\uEA41";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MOTION)) {
            unicodeString = "\uEA42";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_NOTIFICATION_SETTINGS)) {
            unicodeString = "\uEA43";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PASSWORD)) {
            unicodeString = "\uEA44";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PHONE_ALERT)) {
            unicodeString = "\uEA46";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PHONE)) {
            unicodeString = "\uEA47";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PICTURE)) {
            unicodeString = "\uEA48";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PILL)) {
            unicodeString = "\uEA49";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PLUG)) {
            unicodeString = "\uEA4A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_POINTS)) {
            unicodeString = "\uEA4B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PRESENCE_PRO)) {
            unicodeString = "\uEA4C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PRESENCE)) {
            unicodeString = "\uEA4D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_QR_CODE)) {
            unicodeString = "\uEA4E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_RECORDING_TIME)) {
            unicodeString = "\uEA4F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_RECORDING)) {
            unicodeString = "\uEA50";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_RECOVER)) {
            unicodeString = "\uEA51";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_REMOTE)) {
            unicodeString = "\uEA52";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_REPLAY)) {
            unicodeString = "\uEA53";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_RIGHT_ARROW)) {
            unicodeString = "\uEA54";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_RULES)) {
            unicodeString = "\uEA55";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SEARCH)) {
            unicodeString = "\uEA56";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SENSITIVITY)) {
            unicodeString = "\uEA57";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SETTINGS)) {
            unicodeString = "\uEA58";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SHARE_ALERTS)) {
            unicodeString = "\uEA59";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SIGN_OUT)) {
            unicodeString = "\uEA5A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_STAR)) {
            unicodeString = "\uEA5B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_STICKER)) {
            unicodeString = "\uEA5C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_STORE)) {
            unicodeString = "\uEA5D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TEMPERATURE)) {
            unicodeString = "\uEA5E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TERMS)) {
            unicodeString = "\uEA5F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_THERMOSTAT)) {
            unicodeString = "\uEA60";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TIME_FORMAT)) {
            unicodeString = "\uEA61";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TIME)) {
            unicodeString = "\uEA62";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TIMER)) {
            unicodeString = "\uEA63";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TIMEZONE)) {
            unicodeString = "\uEA64";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TOUCH)) {
            unicodeString = "\uEA65";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TWITTER)) {
            unicodeString = "\uEA66";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_USER_BACK)) {
            unicodeString = "\uEA67";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_USER)) {
            unicodeString = "\uEA68";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VALID)) {
            unicodeString = "\uEA69";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VIDEO_ALLOW)) {
            unicodeString = "\uEA6A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VIDEO_QUALITY)) {
            unicodeString = "\uEA6B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VIDEO_SETTINGS)) {
            unicodeString = "\uEA6C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VIDEO)) {
            unicodeString = "\uEA6D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_VOLUME)) {
            unicodeString = "\uEA6E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_WATER)) {
            unicodeString = "\uEA6F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_YOUTUBE)) {
            unicodeString = "\uEA70";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_POLICE)) {
            unicodeString = "\uEA71";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_USER_ADD)) {
            unicodeString = "\uEA72";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CALENDAR)) {
            unicodeString = "\uEA73";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CAMERA_IP)) {
            unicodeString = "\uEA45";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SWITCH)) {
            unicodeString = "\uEA74";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_KEYPAD)) {
            unicodeString = "\uEA77";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SIREN)) {
            unicodeString = "\uEA78";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ARROW_DOWN)) {
            unicodeString = "\uEA7D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ARROW_LEFT)) {
            unicodeString = "\uEA7E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ARROW_RIGHT)) {
            unicodeString = "\uEA7F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_ARROW_UP)) {
            unicodeString = "\uEA80";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_FINGERPRINT_CIRCLE)) {
            unicodeString = "\uEA81";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_KEY_CIRCLE)) {
            unicodeString = "\uEA82";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_KEYPAD_CIRCLE)) {
            unicodeString = "\uEA83";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_MUTE_CIRCLE)) {
            unicodeString = "\uEA84";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_UNMUTE_CIRCLE)) {
            unicodeString = "\uEA85";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_AIR)) {
            unicodeString = "\uEA86";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_WEATHER)) {
            unicodeString = "\uEA87";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CIRCLE_FILLED)) {
            unicodeString = "\uEA88";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CIRCLE_NO_FILL)) {
            unicodeString = "\uEA89";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_STAY)) {
            unicodeString = "\uEA8A";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_LEAF)) {
            unicodeString = "\uEA8B";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_NOISE)) {
            unicodeString = "\uEA8C";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_PRESSURE)) {
            unicodeString = "\uEA8D";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_AC)) {
            unicodeString = "\uEA8E";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_CONDITION)) {
            unicodeString = "\uEA8F";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TOUCHPAD)) {
            unicodeString = "\uEA90";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TEMP_HUMIDITY)) {
            unicodeString = "\uEA91";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_AWAY_NEW)) {
            unicodeString = "\uEA92";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_HOME_NEW)) {
            unicodeString = "\uEA93";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_STAY_NEW)) {
            unicodeString = "\uEA94";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_TEST_NEW)) {
            unicodeString = "\uEA95";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SECURITY_SETTINGS)) {
            unicodeString = "\uEA96";
        } else if (iconName.equals(PPCommonInfo.PP_ICON_SECURITY)) {
            unicodeString = "\uEA97";
        }
        return unicodeString;
    }

    public String findDeviceFontIcon(String deviceId) {

        if (m_DeviceInfoArrayList == null) {
            return PPCommonInfo.ICON_DEFAULT;
        }
        for (PPDeviceInfoModel m_DeviceInfoModel : m_DeviceInfoArrayList) {
            if (m_DeviceInfoModel.id != null) {
                if (m_DeviceInfoModel.id.equals(deviceId)) {
                    if (m_DeviceInfoModel.type == PPCommonInfo.INT_PRESENCE_IOS_CAMERA) {
                        if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360 && m_DeviceInfoModel.connected) {
                            return PPCommonInfo.ICON_DEVICE_CAMERA_P360;
                        } else {
                            return PPCommonInfo.ICON_DEVICE_CAMERA_IOS;
                        }
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA) {
                        if (deviceId.equals(PPAppCenter.m_SharedPresence.getUuidForUserId(PPAppCenter.m_SharedPresence.getUserId())) == true) {
                            if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360) {
                                return PPCommonInfo.ICON_DEVICE_CAMERA_P360;
                            } else {
                                return PPCommonInfo.ICON_DEVICE_CAMERA;
                            }
                        } else {
                            if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360 && m_DeviceInfoModel.connected) {
                                return PPCommonInfo.ICON_DEVICE_CAMERA_P360;
                            } else {
                                return PPCommonInfo.ICON_DEVICE_CAMERA_ANDROID;
                            }
                        }
                    } else if (m_DeviceInfoModel.type <= PPCommonInfo.INT_TED_MTU_LOAD && m_DeviceInfoModel.type >= PPCommonInfo.INT_TED_MTU) {
                        return PPCommonInfo.ICON_DEVICE_METER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR || m_DeviceInfoModel.type == PPCommonInfo.INT_ENERGY_METER) {
                        return PPCommonInfo.ICON_DEVICE_METER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GREEN_GATEWAY || m_DeviceInfoModel.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_X5_GATEWAY) {
                        return PPCommonInfo.ICON_DEVICE_GATEWAY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_DOOR_WINDOW_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_ENTRY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_MOTION_DETECTOR) {
                        return PPCommonInfo.ICON_DEVICE_MOTION;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_TOUCH_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_TOUCH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_MOTION_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_MOTION;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_LEAK_DETECTOR) {
                        return PPCommonInfo.ICON_DEVICE_WATER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_TEMPERATURE;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_HUMIDITY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_HUMIDITY_TEMP;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GE_LIGHT_BULB) {
                        return PPCommonInfo.ICON_DEVICE_BULB;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_WIFI_SMART_PLUG) {
                        return PPCommonInfo.ICON_DEVICE_PLUG;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_CENTRALITE_SMART_PLUG || m_DeviceInfoModel.type == PPCommonInfo.INT_VISUAL_ENERGY_UFO_POWER_STRIP) {
                        return PPCommonInfo.ICON_DEVICE_PLUG;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS) {
                        return PPCommonInfo.ICON_DEVICE_DRYER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_THERMOSTAT
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_ECOBEE_THERMOSTAT
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_EMERSON_THERMOSTAT) {
                        return PPCommonInfo.ICON_DEVICE_THERMOSTAT;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_FOSCAM_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_AMTK_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WELCOME_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_BAYCAM_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_PPC_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_ALFAPRO_IP_CAMERA) {
                        return PPCommonInfo.ICON_DEVICE_CAMERA_IP;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GALILEO_BLUETOOTH_40) {
                        return PPCommonInfo.ICON_DEVICE_CAMERA_GALILEO;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GREEN_BUTTON || (m_DeviceInfoModel.type >= PPCommonInfo.INT_TED_MTU_LOAD
                        && m_DeviceInfoModel.type <= PPCommonInfo.INT_TED_MTU)) {
                        return PPCommonInfo.ICON_DEVICE_METER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_QMOTE) {
                        return PPCommonInfo.ICON_DEVICE_HEALTH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_IBEACON) {
                        return PPCommonInfo.ICON_GEOFENCING;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_IN_WALL_SWITCH) {
                        return PPCommonInfo.ICON_DEVICE_SWITCH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_SIREN || m_DeviceInfoModel.type == PPCommonInfo.INT_LH_SIREN
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_SIREN) {
                        return PPCommonInfo.ICON_DEVICE_SIREN;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH) {
                        return PPCommonInfo.ICON_DEVICE_HEALTHY_COACH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
                        return PPCommonInfo.ICON_DEVICE_WEATHER_STATION;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_SENSIBO_THERMOSTAT) {
                        return PPCommonInfo.ICON_SENSIBO_SKY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
                        return PPCommonInfo.ICON_DEVICE_HUMIDITY_TEMP;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_ANDROID_TOUCHPAD) {
                        return PPCommonInfo.ICON_DEVICE_TOUCH_PAD;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_DOOR_LOCK) {
                        return PPCommonInfo.ICON_DEVICE_LOCK;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_EWIG_BUTTON || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_BUTTON) {
                        return PPCommonInfo.ICON_PUSH_BUTTON;
                    } else {
                        return PPCommonInfo.ICON_DEFAULT;
                    }
                }
            }
        }
        return PPCommonInfo.ICON_DEFAULT;
    }

    public String findDeviceFontIconByDeviceId(String deviceId) {

        if (m_DeviceInfoArrayList == null) {
            return PPAppCenter.m_IconFontLabel.ICON_PRESENCE;
        }
        for (PPDeviceInfoModel m_DeviceInfoModel : m_DeviceInfoArrayList) {
            if (m_DeviceInfoModel.id != null) {
                if (m_DeviceInfoModel.id.equals(deviceId)) {
                    if (m_DeviceInfoModel.type == PPCommonInfo.INT_PRESENCE_IOS_CAMERA) {
                        if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360 && m_DeviceInfoModel.connected) {
                            return PPAppCenter.m_IconFontLabel.ICON_360;
                        } else {
                            return PPAppCenter.m_IconFontLabel.ICON_CAMERA_IOS;
                        }
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA) {
                        if (deviceId.equals(PPAppCenter.m_SharedPresence.getUuidForUserId(PPAppCenter.m_SharedPresence.getUserId())) == true) {
                            if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360) {
                                return PPAppCenter.m_IconFontLabel.ICON_360;
                            } else {
                                return PPAppCenter.m_IconFontLabel.ICON_FA_CAMERA;
                            }
                        } else {
                            if (m_DeviceInfoModel.iRobotType == PPRobotType.ROBOT_P360 && m_DeviceInfoModel.connected) {
                                return PPAppCenter.m_IconFontLabel.ICON_360;
                            } else {
                                return PPAppCenter.m_IconFontLabel.ICON_CAMERA_ANDROID;
                            }
                        }
                    } else if (m_DeviceInfoModel.type <= PPCommonInfo.INT_TED_MTU_LOAD && m_DeviceInfoModel.type >= PPCommonInfo.INT_TED_MTU) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_TACHOMETER_ALT;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_TACHOMETER_ALT;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GREEN_GATEWAY || m_DeviceInfoModel.type == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_X5_GATEWAY
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_WIFI;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_DOOR_WINDOW_SENSOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_ENTRY_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_ENTRY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_MOTION_DETECTOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_MOTION;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_TOUCH_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_TOUCH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_MOTION_SENSOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_MOTION_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_MOTION;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_LEAK_DETECTOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_WATER_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_WATER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_TEMPERATURE;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_HUMIDITY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_TEMP_HUMIDITY;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GE_LIGHT_BULB) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_LIGHTBULB;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_WIFI_SMART_PLUG) {
                        return PPAppCenter.m_IconFontLabel.ICON_PLUG;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_CENTRALITE_SMART_PLUG || m_DeviceInfoModel.type == PPCommonInfo.INT_VISUAL_ENERGY_UFO_POWER_STRIP
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_LOAD_CONTROLLER) {
                        return PPAppCenter.m_IconFontLabel.ICON_PLUG;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS) {
                        return PPAppCenter.m_IconFontLabel.ICON_DRYER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_THERMOSTAT || m_DeviceInfoModel.type == PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_ECOBEE_THERMOSTAT
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_EMERSON_THERMOSTAT) {
                        return PPAppCenter.m_IconFontLabel.ICON_THERMOSTAT;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_FOSCAM_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_AMTK_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WELCOME_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_BAYCAM_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_PPC_IP_CAMERA
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_ALFAPRO_IP_CAMERA) {
                        return PPAppCenter.m_IconFontLabel.ICON_CAMERA_IP;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GALILEO_BLUETOOTH_40) {
                        return PPAppCenter.m_IconFontLabel.ICON_CAMERA_GALILEO;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_GREEN_BUTTON || (m_DeviceInfoModel.type >= PPCommonInfo.INT_TED_MTU_LOAD
                        && m_DeviceInfoModel.type <= PPCommonInfo.INT_TED_MTU)
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_ENERGY_METER) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_TACHOMETER_ALT;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_QMOTE) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_CROSSHAIRS;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_IBEACON) {
                        return PPAppCenter.m_IconFontLabel.ICON_GEOFENCING;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_IN_WALL_SWITCH) {
                        return PPAppCenter.m_IconFontLabel.ICON_SWITCH;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_SIREN || m_DeviceInfoModel.type == PPCommonInfo.INT_LH_SIREN
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_SIREN) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_BULLHORN;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH) {
                        return PPAppCenter.m_IconFontLabel.ICON_AIR;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_WEATHER;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_SENSIBO_THERMOSTAT) {
                        return PPAppCenter.m_IconFontLabel.ICON_AC;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_ANDROID_TOUCHPAD) {
                        return PPAppCenter.m_IconFontLabel.ICON_TOUCHPAD;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_DOOR_LOCK) {
                        return PPAppCenter.m_IconFontLabel.ICON_SMART_LOCK;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_EWIG_BUTTON || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_BUTTON
                        || m_DeviceInfoModel.type == PPCommonInfo.INT_DEVELCO_MULITI_BUTTON) {
                        return PPAppCenter.m_IconFontLabel.ICON_PUSH_BUTTON;
                    } else if (m_DeviceInfoModel.type == PPCommonInfo.INT_PRESSURE_PAD_SENSOR) {
                        return PPAppCenter.m_IconFontLabel.ICON_FA_BED;
                    } else {
                        return PPAppCenter.m_IconFontLabel.ICON_PRESENCE;
                    }
                }
            }
        }
        return PPAppCenter.m_IconFontLabel.ICON_PRESENCE;
    }

    public String findDeviceIconByType(int deviceType) {

        if (deviceType == PPCommonInfo.INT_PRESENCE_IOS_CAMERA) {
            return PPCommonInfo.ICON_DEVICE_CAMERA_IOS;
        } else if (deviceType == PPCommonInfo.INT_PRESENCE_ANDROID_CAMERA) {
            return PPCommonInfo.ICON_DEVICE_CAMERA_ANDROID;
        } else if (deviceType >= PPCommonInfo.INT_TED_MTU_LOAD && deviceType <= PPCommonInfo.INT_TED_MTU) {
            return PPCommonInfo.ICON_DEVICE_METER;
        } else if (deviceType == PPCommonInfo.INT_BLUE_LINE_POWERCOST_MONITOR) {
            return PPCommonInfo.ICON_DEVICE_METER;
        } else if (deviceType == PPCommonInfo.INT_GREEN_GATEWAY
            || deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY
            || deviceType == PPCommonInfo.INT_X5_GATEWAY
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
            return PPCommonInfo.ICON_DEVICE_GATEWAY;
        } else if (deviceType == PPCommonInfo.INT_DOOR_WINDOW_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_ENTRY;
        } else if (deviceType == PPCommonInfo.INT_MOTION_DETECTOR) {
            return PPCommonInfo.ICON_DEVICE_MOTION;
        } else if (deviceType == PPCommonInfo.INT_TOUCH_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_TOUCH;
        } else if (deviceType == PPCommonInfo.INT_MOTION_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_MOTION;
        } else if (deviceType == PPCommonInfo.INT_LEAK_DETECTOR) {
            return PPCommonInfo.ICON_DEVICE_WATER;
        } else if (deviceType == PPCommonInfo.INT_TEMPERATURE_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_TEMPERATURE;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_SENSOR
            || deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
            || deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_HUMIDITY_TEMP;
        } else if (deviceType == PPCommonInfo.INT_GE_LIGHT_BULB) {
            return PPCommonInfo.ICON_DEVICE_BULB;
        } else if (deviceType == PPCommonInfo.INT_WIFI_SMART_PLUG) {
            return PPCommonInfo.ICON_DEVICE_PLUG;
        } else if (deviceType == PPCommonInfo.INT_CENTRALITE_SMART_PLUG || deviceType == PPCommonInfo.INT_VISUAL_ENERGY_UFO_POWER_STRIP) {
            return PPCommonInfo.ICON_DEVICE_PLUG;
        } else if (deviceType == PPCommonInfo.INT_LINT_ALERT_PRO_PLUS) {
            return PPCommonInfo.ICON_DEVICE_DRYER;
        } else if (deviceType == PPCommonInfo.INT_THERMOSTAT
            || deviceType == PPCommonInfo.INT_HONEYWELL_LYRIC_THERMOSTAT
            || deviceType == PPCommonInfo.INT_ECOBEE_THERMOSTAT
            || deviceType == PPCommonInfo.INT_EMERSON_THERMOSTAT) {
            return PPCommonInfo.ICON_DEVICE_THERMOSTAT;
        } else if (deviceType == PPCommonInfo.INT_FOSCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_AMTK_IP_CAMERA
            || deviceType == PPCommonInfo.INT_NETATMO_WELCOME_CAMERA
            || deviceType == PPCommonInfo.INT_BAYCAM_IP_CAMERA
            || deviceType == PPCommonInfo.INT_PPC_IP_CAMERA
            || deviceType == PPCommonInfo.INT_ALFAPRO_IP_CAMERA) {
            return PPCommonInfo.ICON_DEVICE_CAMERA_IP;
        } else if (deviceType == PPCommonInfo.INT_GALILEO_BLUETOOTH_40) {
            return PPCommonInfo.ICON_DEVICE_CAMERA_GALILEO;
        } else if (deviceType == PPCommonInfo.INT_GREEN_BUTTON) {
            return PPCommonInfo.ICON_DEVICE_METER;
        } else if (deviceType == PPCommonInfo.INT_QMOTE) {
            return PPCommonInfo.ICON_DEVICE_HEALTH;
        } else if (deviceType == PPCommonInfo.INT_IBEACON) {
            return PPCommonInfo.ICON_GEOFENCING;
        } else if (deviceType == PPCommonInfo.INT_IN_WALL_SWITCH) {
            return PPCommonInfo.ICON_DEVICE_SWITCH;
        } else if (deviceType == PPCommonInfo.INT_SIREN || deviceType == PPCommonInfo.INT_LH_SIREN || deviceType == PPCommonInfo.INT_DEVELCO_SIREN) {
            return PPCommonInfo.ICON_DEVICE_SIREN;
        } else if (deviceType == PPCommonInfo.INT_PRESENCE_360) {
            return PPCommonInfo.ICON_DEVICE_CAMERA_P360;
        } else if (deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221) {
            return PPCommonInfo.ICON_DEVICE_GATEWAY;
        } else if (deviceType == PPCommonInfo.INT_PEOPLE_POWER_GATEWAY) {
            return PPCommonInfo.ICON_DEVICE_GATEWAY;
        } else if (deviceType == PPCommonInfo.INT_NETATMO_HEALTHY_HOME_COACH) {
            return PPCommonInfo.ICON_DEVICE_HEALTHY_COACH;
        } else if (deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_INDOOR
            || deviceType == PPCommonInfo.INT_NETATMO_WEATHER_STATION_OUTDOOR) {
            return PPCommonInfo.ICON_DEVICE_WEATHER_STATION;
        } else if (deviceType == PPCommonInfo.INT_SENSIBO_THERMOSTAT) {
            return PPCommonInfo.ICON_SENSIBO_SKY;
        } else if (deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_SENSOR
            || deviceType == PPCommonInfo.INT_HUMIDITY_TEMP_LIGHT_SENSOR) {
            return PPCommonInfo.ICON_DEVICE_HUMIDITY_TEMP;
        } else if (deviceType == PPCommonInfo.INT_ANDROID_TOUCHPAD) {
            return PPCommonInfo.ICON_DEVICE_TOUCH_PAD;
        } else if (deviceType == PPCommonInfo.INT_DOOR_LOCK) {
            return PPCommonInfo.ICON_DEVICE_LOCK;
        } else if (deviceType == PPCommonInfo.INT_EWIG_BUTTON || deviceType == PPCommonInfo.INT_DEVELCO_BUTTON) {
            return PPCommonInfo.ICON_PUSH_BUTTON;
        } else {
            return PPCommonInfo.ICON_DEFAULT;
        }
    }


    public String getBillingInformation() {
        PPBillingInfoModel billingInfo = this.getBillingInfoModel();
        String symbol = PPCommonInfo.getCurrentSymbol();
        String rateValue = billingInfo.getBillingRateValue();
        String result = null;
        if (!PPUtil.isEmpty(rateValue)) {
            int index = 0;
            String sBillRate = null;
            if (symbol != null) {
                if (rateValue.contains(".")) {
                    index = rateValue.indexOf(".");
                    sBillRate = rateValue.substring(index);
                    PPVirtuosoLogTrace.d(TAG, "IndexOf =  " + index);
                    PPVirtuosoLogTrace.d(TAG, "sBillRate =  " + sBillRate);
                    if (sBillRate.length() < 3) {
                        result = symbol + " " + rateValue + "0";
                    } else {
                        result = symbol + " " + rateValue.substring(0, index + 3);
                    }
                } else {
                    result = symbol + " " + rateValue + ".00";
                }
            }
        }
        return result;
    }

    public String getBillingRateValue() {
        PPBillingInfoModel billingInfo = this.getBillingInfoModel();
        String rateValue = billingInfo.getBillingRateValue();
        String result = null;
        if (!PPUtil.isEmpty(rateValue)) {
            int index = 0;
            String sBillRate = null;
            if (rateValue.contains(".")) {
                index = rateValue.indexOf(".");
                sBillRate = rateValue.substring(index);
                PPVirtuosoLogTrace.d(TAG, "IndexOf =  " + index);
                PPVirtuosoLogTrace.d(TAG, "sBillRate =  " + sBillRate);
                if (sBillRate.length() < 3) {
                    result = rateValue + "0";
                } else {
                    result = rateValue.substring(0, index + 3);
                }
            } else {
                result = rateValue + ".00";
            }
        }
        return result;
    }


    public boolean getAccessCameraSettings(List<PPDeviceParameterInfoModel> deviceParamModeList) {
        if (deviceParamModeList != null) {
            if (!deviceParamModeList.isEmpty()) {
                for (PPDeviceParameterInfoModel currDPIModel : deviceParamModeList) {
                    PPVirtuosoLogTrace.d(TAG, "currDPIModel.getName() = " + currDPIModel.getName());
                    if (currDPIModel.getName().equals(PPCameraUtils.CameraParameter.ACCESS_CAMERA_SETTINGS)) {
                        String sValue = currDPIModel.getValue();
                        if (sValue != null) {
                            if (sValue.equals("1")) {
                                return true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int mMaxSlaveValue = 0;

    public int getGatewayDeviceCount(final String deviceId) {
        int count = 0;
        for (PPDeviceInfoModel model : m_DeviceInfoArrayList) {
            if (null != model.proxyId && model.proxyId.equals(deviceId)) {
                ++count;
            }
        }
        return count;
    }

    public boolean addDeviceAvailable(final String deviceId, List<PPAddDeviceModel> addDeviceModelList) {
        if (mMaxSlaveValue == 0) {
            String maxSlaveValue = null;
            for (int i = 0; i != addDeviceModelList.size(); ++i) {
                PPAddDeviceModel curDeviceModel = addDeviceModelList.get(i);
                if (curDeviceModel.getDeviceTypeId() == PPCommonInfo.INT_GREEN_GATEWAY) {
                    maxSlaveValue = curDeviceModel.attributeValue("maxSlaves");
                }
            }
            if (null != maxSlaveValue) {
                mMaxSlaveValue = Integer.valueOf(maxSlaveValue);
            }
        }
        if (mMaxSlaveValue <= 0) {
            return true;
        }
        int count = getGatewayDeviceCount(deviceId);
        if (count >= mMaxSlaveValue) {
            return false;
        }
        return true;
    }

    public List<PPDeviceParameterInfoModel> getCameraParameter(List<PPDeviceInfoModel> deviceInfo, String deviceId) {
        String localDeviceID = PPAppCenter.m_SharedPresence.getUuidForUserId(PPAppCenter.m_SharedPresence.getUserId());
        for (final PPDeviceInfoModel device : deviceInfo) {
            if ((device != null) && (device.connected) && (device.typeCategory == PPCommonInfo.PPDeviceTypeCategoryMobileCamera) && (!localDeviceID.equals(deviceId))) {
                return device.getDeviceParameters();
            }
        }
        return null;
    }

    public boolean isParameter(String parameter) {
        for (PPDeviceParameterModel currentParamModel : m_DeviceParamModelList) {
            for (PPDeviceParameterInfoModel currDPIModel : currentParamModel.getDeviceParametersInfoModel()) {
                if (currDPIModel.getName() != null && currDPIModel.getName().equals(parameter)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isParameterByIndex(String parameter, int index) {
        List<PPDeviceParameterModel> parameters = getCurrentDeviceParameters();
        for (PPDeviceParameterModel currentParamModel : parameters) {
            for (PPDeviceParameterInfoModel currDPIModel : currentParamModel.getDeviceParametersInfoModel()) {
                if (currDPIModel.getName() != null && currDPIModel.getName().equals(parameter)) {
                    if (currDPIModel.getIndex() != null && currDPIModel.getIndex().equals(Integer.toString(index))) {
                        if (currDPIModel.getValue() != null) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getParameterValueByIndex(String parameter, int index) {
        List<PPDeviceParameterModel> parameters = getCurrentDeviceParameters();
        String value = null;
        for (PPDeviceParameterModel currentParamModel : parameters) {
            for (PPDeviceParameterInfoModel currDPIModel : currentParamModel.getDeviceParametersInfoModel()) {
                if (currDPIModel.getName() != null && currDPIModel.getName().equals(parameter)) {
                    if (currDPIModel.getIndex() != null && currDPIModel.getIndex().equals(Integer.toString(index))) {
                        value = currDPIModel.getValue();
                        PPVirtuosoLogTrace.d(TAG, "getParameterValueByIndex PARAMETER = " + parameter + " INDEX = " + index + " RETURN value = " + value);
                        return value;
                    }
                }
            }
        }
        PPVirtuosoLogTrace.e(TAG, "getParameterValueByIndex PARAMETER = " + parameter + " INDEX = " + index + " RETURN value = " + value);
        return value;
    }

    public String getParameterValue(String parameter) {
        List<PPDeviceParameterModel> parameters = getCurrentDeviceParameters();
        String value = null;
        for (PPDeviceParameterModel currentParamModel : parameters) {
            for (PPDeviceParameterInfoModel currDPIModel : currentParamModel.getDeviceParametersInfoModel()) {
                if (currDPIModel.getName() != null && currDPIModel.getName().equals(parameter)) {
                    value = currDPIModel.getValue();
                    PPVirtuosoLogTrace.d(TAG, "getParameterValue PARAMETER = " + parameter + " RETURN value = " + value);
                    return value;
                }
            }
        }
        PPVirtuosoLogTrace.d(TAG, "getParameterValue PARAMETER = " + parameter + " RETURN value = " + value);
        return value;
    }

    public String getParameterValue(String[] paramFilters) {
        String value = null;
        for (PPDeviceParameterModel currentParamModel : m_DeviceParamModelList) {
            for (PPDeviceParameterInfoModel currDPIModel : currentParamModel.getDeviceParametersInfoModel()) {
                if (currDPIModel.getName() != null) {
                    for (String param : paramFilters) {
                        if (param.equals(currDPIModel.getName())) {
                            value = currDPIModel.getValue();
                            PPVirtuosoLogTrace.d(TAG, "getParameterValue PARAMETER = " + currDPIModel.getName() + " RETURN value = " + value);
                            return value;
                        }
                    }
                }
            }
        }
        return value;
    }


    public String getSupportDeviceDefaultDescription(int deviceType) {
        List<PPAddDeviceModel> supportModelList = getSupportAllDeviceList();
        for (PPAddDeviceModel deviceModel : supportModelList) {
            if (deviceType == deviceModel.getDeviceTypeId()) {
                for (PPAddDeviceAttributeModel attributeModel : deviceModel.getAttrbuteList()) {
                    if (attributeModel.getAttrName() != null && attributeModel.getAttrName().equals("defaultDescription")) {
                        return attributeModel.getAttrValue();
                    }
                }
            }
        }

        return "";
    }

    public String getSupportDeviceTypeName(int deviceType) {
        List<PPAddDeviceModel> supportModelList = getSupportAllDeviceList();
        for (PPAddDeviceModel deviceModel : supportModelList) {
            if (deviceType == deviceModel.getDeviceTypeId()) {
                return deviceModel.getName();
            }
        }
        return "";
    }


    public boolean getSupportDeviceTypeAttribute(int deviceType, String attributeName) {
        List<PPAddDeviceModel> supportModelList = getSupportDeviceList();
        for (PPAddDeviceModel deviceModel : supportModelList) {
            if (deviceType == deviceModel.getDeviceTypeId()) {
                for (PPAddDeviceAttributeModel deviceAttribute : deviceModel.getAttrbuteList()) {
                    if (deviceAttribute.getAttrName().equals(attributeName)) {
                        if (deviceAttribute.getAttrValue().equals("1") || deviceAttribute.getAttrValue().equals("true")) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getDeviceNameByDeviceId(String deviceId) {
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (null != deviceInfo && !TextUtils.isEmpty(deviceInfo.id) && deviceId.equals(deviceInfo.id)) {
                return deviceInfo.desc;
            }
        }
        return "";
    }

    public int getGoalIdByDeviceId(String deviceId) {
        int goalId = PPCommonInfo.PPInvalidValue;
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceId.equals(deviceInfo.id)) {
                goalId = deviceInfo.goalId;
                return goalId;
            }
        }
        return goalId;
    }

    public int getExistingDeviceCountByType(int deviceType) {
        int iDeviceCount = 0;
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceInfo.type == deviceType) {
                iDeviceCount++;
            }
        }
        return iDeviceCount;
    }

    public int getSelectedGoalCountByType(int deviceType, int goalId) {
        int iGoalCount = 0;
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceInfo.type == deviceType && deviceInfo.goalId == goalId) {
                iGoalCount++;
            }
        }
        return iGoalCount;
    }

    public boolean isExsitingDevice(String deviceId) {
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceId.equals(deviceInfo.id)) {
                return true;
            }
        }
        return false;
    }

    public int getDeviceTypeByDeviceId(String deviceId) {
        int deviceType = 0;
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceId.equals(deviceInfo.id)) {
                deviceType = deviceInfo.type;
                return deviceType;
            }
        }
        return deviceType;
    }

    public String getGatewayId() {
        String sGatewayId = "";
        for (PPDeviceInfoModel model : m_DeviceInfoArrayList) {
            if (PPCommonInfo.INT_GREEN_GATEWAY == model.type) {
                sGatewayId = model.id;
            }
        }
        return sGatewayId;
    }

    public String getAttributeValue(String attrName, int type) {
        String attrValue = null;
        for (PPAddDeviceModel model : m_SupportDeviceListAddDeviceAvailable) {
            if (model.getDeviceTypeId() == type) {
                for (PPAddDeviceAttributeModel attributeModel : model.getAttrbuteList()) {
                    if (!PPUtil.isEmpty(attributeModel.getAttrName())) {
                        if (attributeModel.getAttrName().equals(attrName)) {
                            attrValue = attributeModel.getAttrValue();
                            PPVirtuosoLogTrace.d(TAG, "Attr Name = " + attrName);
                            PPVirtuosoLogTrace.d(TAG, "Attr Value = " + attrValue);
                            return attrValue;
                        }
                    }
                }
            }
        }
        return attrValue;
    }

    public String iconNameByDeviceType(int type) {
        String iconName = null;
        for (PPDeviceInfoModel deviceModel : m_DeviceInfoArrayList) {
            if (deviceModel.type == type) {
                iconName = deviceModel.icon;
                return iconName;
            }
        }
        return iconName;
    }

    public int getLocationIdByDeviceId(String deviceId) {
        int location = 0;
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceId.equals(deviceInfo.id)) {
                location = deviceInfo.locationId;
                return location;
            }
        }
        return location;
    }

    public PPDeviceInfoModel getDeviceInfoByDeviceId(String deviceId) {
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (!TextUtils.isEmpty(deviceInfo.id) && deviceId.equals(deviceInfo.id)) {
                return deviceInfo;
            }
        }
        return null;
    }

    public boolean supportedHistoricalMeasurement() {
        for (PPDeviceParameterModel param : m_DeviceParamModelList) {
            for (PPDeviceParameterInfoModel paramInfo : param.getDeviceParametersInfoModel()) {
                if (isHistoricalParameter(paramInfo.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isHistoricalParameter(String param) {
        if (!PPUtil.isEmpty(param)) {
            if (param.equals(COOLING_SETPOINT)
                || param.equals(HEATING_SETPOINT)
                || param.equals(DEG_C)
                || param.equals(RELATIVE_HUMIDITY)
                || param.equals(POWER)
                || param.equals(ENERGY)
                || param.equals(DOOR_STATUS)
                || param.equals(VIBRATION_STATUS)
                || param.equals(WATER_LEAK)
//                || param.equals(BATTERY_VOLTAGE)
//                || param.equals(ALARM_WARN)
                || param.equals(LOCK_STATUS)
                || param.equals(SIG_PRESSURE)
                || param.equals(SIG_WCI_PRESSURE)
                || param.equals(MOTION_STATUS)
                || param.equals(BUTTON_STATUS)
                || param.equals(ALARM_STATUS)
//                || param.equals(CURRENT_LEVEL)
//                || param.equals(STATE)
//                || param.equals(PRESSURE_PAD_STATUS)
//                || param.equals(ARM_MODE)
            ) {
                return true;
            }
        }
        return false;
    }

    public List<PPDeviceMeasurmentHistoryModel> getDateSectionDeviceHistory() {
        boolean bToday = false;
        boolean bYesterday = false;
        boolean bOtherday = false;
        String sPreviousDate = null;
        if (m_deviceHistoryList != null) {
            m_deviceHistoryList.clear();
        }
        Collections.reverse(m_deviceMeasurmentHistoryList);
        for (PPDeviceMeasurmentHistoryModel history : m_deviceMeasurmentHistoryList) {
            Date date = new Date(history.getlTimeMs());
            PPDeviceMeasurmentHistoryModel sectionModel = new PPDeviceMeasurmentHistoryModel();
            if (isTodayDate(date)) {
                if (!bToday) {
                    sectionModel.setsDateSection("Today");
                    sectionModel.setbSecton(true);
                    m_deviceHistoryList.add(sectionModel);
                    bToday = true;
                }
                m_deviceHistoryList.add(history);
            } else if (isYesterdayDate(date)) {
                if (!bYesterday) {
                    sectionModel.setsDateSection("Yesterday");
                    sectionModel.setbSecton(true);
                    m_deviceHistoryList.add(sectionModel);
                    bYesterday = true;
                }
                m_deviceHistoryList.add(history);
            } else {
                String dateText = new SimpleDateFormat("MMMM dd", Locale.getDefault()).format(date);
                if (!bOtherday || !PPUtil.isEmpty(sPreviousDate) && !sPreviousDate.equals(dateText)) {
                    sectionModel.setsDateSection(dateText);
                    sectionModel.setbSecton(true);
                    m_deviceHistoryList.add(sectionModel);
                    bOtherday = true;
                }
                sPreviousDate = dateText;
                m_deviceHistoryList.add(history);
            }
        }
        return m_deviceHistoryList;
    }

    private boolean isTodayDate(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        Date currentDate = currentCalendar.getTime();
        SimpleDateFormat currentSDF = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat dateSDF = new SimpleDateFormat("dd.MM.yyyy");
        if (null != date) {
            if (currentSDF.format(currentDate).equals(dateSDF.format(date))) {
                return true;
            }
        }
        return false;
    }

    private boolean isYesterdayDate(Date date) {
        Calendar currentCalendar = Calendar.getInstance();
        currentCalendar.add(Calendar.DAY_OF_MONTH, -1);
        Date currentDate = currentCalendar.getTime();
        SimpleDateFormat currentSDF = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat dateSDF = new SimpleDateFormat("dd.MM.yyyy");
        if (null != date) {
            if (currentSDF.format(currentDate).equals(dateSDF.format(date))) {
                return true;
            }
        }
        return false;
    }

    public String getProductParameterDescription(String paramName) {
        for (PPProductsParametersModel paramDisplayModel : m_productParameterModelList) {
            if (!PPUtil.isEmpty(paramName) && paramName.equals(paramDisplayModel.getName())) {
                PPParameterDisplayModel displayModel = paramDisplayModel.getDisplayModel();
                if (null != displayModel && null != displayModel.getMlNameModel()) {
                    return displayModel.getMlNameModel().getMlName();
                } else {
                    return paramName;
                }
            }
        }
        return null;
    }

    public String getProductParameterIconName(String paramName) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (null != displayModel) {
            return displayModel.getIcon();
        }
        return null;
    }

    public String getProductParameterFontIcon(String paramName) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (null != displayModel) {
            return getParameterDisplayModel(paramName).getIconFont();
        }
        return null;
    }

    public PPParameterDisplayModel getParameterDisplayModel(String paramName) {
        for (PPProductsParametersModel paramDisplayModel : m_productParameterModelList) {
            if (!PPUtil.isEmpty(paramName) && paramDisplayModel != null && paramDisplayModel.getName() != null) {
                if (paramName.equalsIgnoreCase(paramDisplayModel.getName())) {
                    return paramDisplayModel.getDisplayModel();
                }
            }
        }
        return null;
    }

    public List<PPProductsParametersModel> getProductParameterList() {
        return m_productParameterModelList;
    }

    public String getProductName(String paramName) {
        PPParameterDisplayModel paramDisplayModel = getParameterDisplayModel(paramName);
        if (paramDisplayModel.getMlNameModel() != null && paramDisplayModel.getMlNameModel().getMlName() != null) {
            return paramDisplayModel.getMlNameModel().getMlName();
        }
        return null;
    }

    public boolean isKeypad() {
        for (PPDeviceInfoModel deviceInfo : m_DeviceInfoArrayList) {
            if (deviceInfo.type == PPCommonInfo.INT_DEVELCO_KEYPAD) {
                return true;
            }
        }
        return false;
    }

    public String getDeviceParamValue(String paramName, String deviceId) {
        List<PPDeviceParameterModel> parameters = getCurrentDeviceParameters();
        for (PPDeviceParameterModel currentParamModel : parameters) {
            if (!TextUtils.isEmpty(currentParamModel.strDeviceId) && currentParamModel.strDeviceId.equals(deviceId)) {
                for (int i = 0; i < currentParamModel.getDeviceParametersInfoModel().size(); i++) {
                    PPDeviceParameterInfoModel parameterInfo = currentParamModel.getDeviceParametersInfoModel().get(i);
                    if (parameterInfo.getName().equals(paramName)) {
                        if (parameterInfo.getValue() != null && !parameterInfo.getValue().isEmpty()) {
                            return parameterInfo.getValue();
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getOptionNameByParamValue(String value, String paramName) {
        PPParameterDisplayModel paramDisplayModel = getParameterDisplayModel(paramName);
        if (null != paramDisplayModel) {
            List<PPParameterDisplayOptionModel> options = paramDisplayModel.getOptioList();
            if (null != options) {
                for (PPParameterDisplayOptionModel option : options) {
                    if (option.getValue() != null && option.getValue().equals(value)) {
                        return option.getMlNameModel().getMlName();
                    }
                }
            }
        }
        return value;
    }

    public String getDisplayNameByParam(String paramName) {
        PPParameterDisplayModel paramDisplayModel = getParameterDisplayModel(paramName);
        if (paramDisplayModel != null && paramDisplayModel.getMlNameModel() != null) {
            return paramDisplayModel.getMlNameModel().getMlName();
        }
        return null;
    }


    public String getRangedOptionName(String value, String paramName) {
        String optionName = null;
        int iValue = 0;
        if (value.contains(".")) {
            value = value.substring(0, value.lastIndexOf("."));
            iValue = Integer.parseInt(value);
        } else if (value.contains("%")) {
            iValue = Integer.parseInt(value.replaceAll("%", ""));
        } else {
            iValue = Integer.parseInt(value);
        }
        int iRangeValue = 0;
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (null != displayModel) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())
                        && !TextUtils.isEmpty(option.getValue())) {
                        iRangeValue = Integer.parseInt(option.getValue());
                        if (iValue > iRangeValue) {
                            optionName = option.getMlNameModel().getMlName();
                            continue;
                        } else {
                            optionName = option.getMlNameModel().getMlName();
                            break;
                        }
                    }
                }
            }
        }
        return optionName;
    }

    public boolean isRangedOptionName(String paramName) {
        PPParameterDisplayModel paramDisplayModel = getParameterDisplayModel(paramName);
        if (null != paramDisplayModel) {
            if (paramDisplayModel.isRanged()) {
                return true;
            }
        }
        return false;
    }

    public String getRangedOptionIconName(String value, String paramName) {
        String optionName = null;
        int iValue = 0;
        if (value.contains(".")) {
            value = value.substring(0, value.lastIndexOf("."));
            iValue = Integer.parseInt(value);
        } else {
            iValue = Integer.parseInt(value);
        }
        int iRangeValue = 0;
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (null != displayModel) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())
                        && !TextUtils.isEmpty(option.getValue())) {
                        iRangeValue = Integer.parseInt(option.getValue());
                        if (iValue > iRangeValue) {
                            optionName = option.getIcon();
                            continue;
                        } else {
                            optionName = option.getIcon();
                            break;
                        }
                    }
                }
            }
        }
        return optionName;
    }

    public String getDisplayParameterValue(String paramName, String value) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (displayModel != null && displayModel.getOptioList() != null) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())
                        && !TextUtils.isEmpty(option.getValue())) {
                        if (option.getValue().equals(value) && option.getMlNameModel() != null) {
                            return option.getMlNameModel().getMlName();
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getDisplayParameterValueByIndex(String paramName, String value, int index) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (displayModel != null && displayModel.getOptioList() != null) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())) {
                        if (option.getMlNameModel() != null && option.getId() == index) {
                            return option.getMlNameModel().getMlName();
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getIconByParamValue(String paramName, String value) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (displayModel != null && displayModel.getOptioList() != null) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())
                        && !TextUtils.isEmpty(option.getValue())) {
                        if (option.getValue().equals(value) && option.getMlNameModel() != null) {
                            return option.getIcon();
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getIconFontByParamValue(String paramName, String value) {
        PPParameterDisplayModel displayModel = getParameterDisplayModel(paramName);
        if (displayModel != null && displayModel.getOptioList() != null) {
            for (PPParameterDisplayOptionModel option : displayModel.getOptioList()) {
                if (option != null && option.getMlNameModel() != null) {
                    if (!TextUtils.isEmpty(option.getMlNameModel().getMlName())
                        && !TextUtils.isEmpty(option.getValue())) {
                        if (option.getValue().equals(value) && option.getMlNameModel() != null) {
                            return option.getIconfont();
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean isSoundTestableDevices(int deviceType) {
        if (deviceType == PPCommonInfo.INT_SIREN
            || deviceType == PPCommonInfo.INT_DEVELCO_SIREN
            || deviceType == PPCommonInfo.INT_LH_SIREN) {
            return true;
        }
        return false;
    }

    public boolean isDevelcoGW(int deviceType) {
        if (deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW221
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW101
            || deviceType == PPCommonInfo.INT_DEVELCO_GATEWAY_MGW211) {
            return true;
        }
        return false;
    }
}

