package com.peoplepowerco.virtuoso.managers;

import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;

/**
 *
 */
public class PPDeviceIOManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
  private static final String TAG = PPDeviceIOManager.class.getSimpleName();
  private static PPDeviceIOManager instance = null;

  /**
   * Hidden class constructor.
   */
  private PPDeviceIOManager() {
    init();
  }

  /**
   * Get the one and only instance of this class.
   * The first calling thread will create an initial instance.
   * This method will only be synchronized on the first call,
   * thus it will not affect speed of our app.
   * @return
   */
  public static PPDeviceIOManager getInstance() {
    synchronized(PPDeviceIOManager.class) {
      if (instance == null) {
        instance = new PPDeviceIOManager();
      }
    }
    return instance;
  }

  /**
   * Initialization of class workers.
   */
  private void init() {
    init(this);
  }

  /**
   * Release essential data holders and listeners.
   */
  public static void release() {
    if(instance != null) {
      instance.releaseBase();
      instance = null;
    }
  }

  @Override
  public void onResultSuccess(int reqid, int arg1, int arg2, Object result, String tag) {
    sendResultToListeners(reqid, arg1, arg2, result, tag);
  }

  @Override
  public void onResultFailure(int reqid, int arg1, int arg2, Object result, String tag) {
    sendResultToListeners(reqid, arg1, arg2, result, tag);
  }

//  /**
//   * update Device parameter to server
//   */
//  private void requestSetDeviceParameters() {
//      sendMessageToCameraUIHandler(PPCameraUtils.OPTION_DISABLED);
//      sendMessageToCameraUIHandler(PPCameraUtils.CAMERA_SWITCH_DISABLED);
//      try {
//          Object[] m_DeviceParameters = PPCameraUtils.prepareDeviceParameters(m_DeviceCommand);
//          JSONObject jsonObj = new JSONObject();
//          String sDeviceId = PPCommonInfo.GetDevicesUUID(m_Context) + "::" + PPApp.m_sharedPresence.getUserId();
//          try {
//              jsonObj.put("HostName", m_sHostDeviceIo);
//              jsonObj.put("Port", m_sPortDeviceIo);
//              jsonObj.put("EspToken", PPApp.m_sharedPresence.getEspToken());
//              jsonObj.put("DeviceId", sDeviceId);
//          } catch (JSONException e) {
//              e.printStackTrace();
//          }
//          m_parserMain.PostDataThreadPool(REQ_SET_DEVICE_DEFAULT_PARAMETER, jsonObj, m_DeviceParameters);
//      } catch (JSONException e1) {
//          e1.printStackTrace();
//      }
//  }
}
