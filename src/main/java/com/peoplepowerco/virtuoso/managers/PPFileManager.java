package com.peoplepowerco.virtuoso.managers;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.IPPVirtuosoTypes;
import com.peoplepowerco.virtuoso.PPAppCenter;
import com.peoplepowerco.virtuoso.PPCommonInfo;
import com.peoplepowerco.virtuoso.PPVirtuoso;
import com.peoplepowerco.virtuoso.interfaces.IPPServerResultListener;
import com.peoplepowerco.virtuoso.models.PPAggregatedListFileModel;
import com.peoplepowerco.virtuoso.models.PPDeviceFileInfoModel;
import com.peoplepowerco.virtuoso.models.PPDeviceUploadFileModel;
import com.peoplepowerco.virtuoso.util.PPCameraUtils;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * Created by laghee on 5/22/16.
 */
public class PPFileManager extends PPAbstractManager implements IPPServerResultListener, IPPVirtuosoTypes {
    private static final String TAG = PPFileManager.class.getSimpleName();
    private static PPFileManager instance = null;

    //file owners
    public static final int PP_FILE_OWNERS_USER = 0;
    public static final int PP_FILE_OWNERS_FRIEND = 1;
    public static final int PP_FILE_OWNERS_ALL = 2;
    public static final int PP_FILE_OWNERS_DELETED = 4;

    //file types
    private static final int PP_FILE_TYPE_ANY = 0;
    private static final int PP_FILE_TYPE_VIDEO = 1;
    private static final int PP_FILE_TYPE_IMAGE = 2;
    private static final int PP_FILE_TYPE_AUDIO = 3;
    private static final int PP_FILE_TYPE_BITMAP_MASK = 4;
    private static final int PP_FILE_TYPE_TEXTLOG = 4;

    //local members
    private PPDeviceFileInfoModel m_DeviceFileInfoModel = null;
    private PPDeviceFileInfoModel m_AdditionalFileInfoModel = null;
    private PPDeviceFileInfoModel m_RecoverableFiles = null;
    private PPDeviceFileInfoModel m_FriendDeviceFileInfoModel = null;
    private PPDeviceFileInfoModel m_OldestDeviceFileInfoModel = null;
    private PPDeviceUploadFileModel m_DeviceUploadFile = null;
    private PPAggregatedListFileModel m_AggregatedListFile = null;

    private PPDeviceFileInfoModel m_DeviceFileInfoModelNFiles = null;
//    private PPDeviceFileInfoModel m_AdditionalFileInfoModelNFiles = null;

    private boolean m_bAddingFiles = false;

    /**
     * Hidden class constructor.
     */
    private PPFileManager() {
        init();
    }

    /**
     * Get the one and only instance of this class.
     * The first calling thread will create an initial instance.
     * This method will only be synchronized on the first call,
     * thus it will not affect speed of our app.
     *
     * @return
     */
    public static PPFileManager getInstance() {
        synchronized (PPFileManager.class) {
            if (instance == null) {
                instance = new PPFileManager();
            }
        }
        return instance;
    }

    /**
     * Initialization of class workers.
     */
    private void init() {
        init(this);

        m_DeviceUploadFile = new PPDeviceUploadFileModel();
        m_DeviceFileInfoModel = new PPDeviceFileInfoModel();
        m_AdditionalFileInfoModel = new PPDeviceFileInfoModel();
        m_RecoverableFiles = new PPDeviceFileInfoModel();
        m_DeviceFileInfoModelNFiles = new PPDeviceFileInfoModel();
//        m_AdditionalFileInfoModelNFiles = new PPDeviceFileInfoModel();
        m_FriendDeviceFileInfoModel = new PPDeviceFileInfoModel();
        m_OldestDeviceFileInfoModel = new PPDeviceFileInfoModel();
        m_AggregatedListFile = new PPAggregatedListFileModel();
    }

    /**
     * Release essential data holders and listeners.
     */
    public static void release() {
        if (instance != null) {
            instance.releaseBase();
            instance.m_DeviceFileInfoModel = null;
            instance.m_AdditionalFileInfoModel = null;
            instance.m_FriendDeviceFileInfoModel = null;
            instance.m_OldestDeviceFileInfoModel = null;
            instance.m_DeviceUploadFile = null;
            instance.m_RecoverableFiles = null;
            instance.m_AggregatedListFile = null;
            instance.m_bAddingFiles = false;
            instance.m_DeviceFileInfoModelNFiles = null;
//            instance.m_AdditionalFileInfoModelNFiles = null;
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

    public int getTotalFriendFileCount() {
        return m_FriendDeviceFileInfoModel.iCollectionTotalSize;
    }

    public PPDeviceFileInfoModel getFriendDeviceFileInfoModel() {
        return m_FriendDeviceFileInfoModel;
    }

    public int getTotalFileCount() {
        return m_DeviceFileInfoModel.iCollectionTotalSize;
    }

    public PPDeviceFileInfoModel getDeviceFileInfoModel() {
        return m_DeviceFileInfoModel;
    }

    public PPDeviceFileInfoModel getRecoverableFileInfoModel() {
        return m_RecoverableFiles;
    }

    public PPDeviceFileInfoModel getOldestDeviceFileInfoModel() {
        return m_OldestDeviceFileInfoModel;
    }

    public PPDeviceUploadFileModel getDeviceUploadFile() {
        return m_DeviceUploadFile;
    }

    public PPAggregatedListFileModel getAggregatedListFile() {
        return m_AggregatedListFile;
    }

    public PPDeviceFileInfoModel getAddedNFilesToDeviceFileInfoModel() {

        return m_AdditionalFileInfoModel;
    }

    public int getAddedNFilesListSize() {
        if (m_DeviceFileInfoModelNFiles != null && m_DeviceFileInfoModelNFiles.fileList.size() > 0) {
            return m_DeviceFileInfoModelNFiles.fileList.size();
        } else {
            return 0;
        }
    }

    public boolean isAddingFiles() {
        return m_bAddingFiles;
    }

    /**
     * Get video file(s) param from server for videos shared from a friend.
     */
    public void serverRequestFriendDeviceFileInfo(String tag,
                                                  int rowCount,
                                                  int firstRow,
                                                  int userId,
                                                  String sortCollection,
                                                  String sortBy,
                                                  String sortOrder) {
        if (m_FriendDeviceFileInfoModel.fileList != null) {
            m_FriendDeviceFileInfoModel.fileList.clear();
        }
        PPVirtuosoLogTrace.d(TAG, ">>requestDeviceFileInfo()");
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("sortCollection", sortCollection);
            jsonObj.put("sortBy", sortBy);
            jsonObj.put("rowCount", rowCount);
            jsonObj.put("sortOrder", sortOrder);
            jsonObj.put("firstRow", firstRow);
            jsonObj.put("ownerId", userId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_FILES, jsonObj, new Object[]{m_FriendDeviceFileInfoModel});
        PPVirtuosoLogTrace.d(TAG, "<<requestDeviceFileInfo()");
    }

    /**
     * Get video file(s) param from server.
     * This is HIDDEN API
     */
    public void serverRequestRecoverableFileInfo(String tag, String sortCollection, String sortBy, String sortOrder) {
        if (m_RecoverableFiles.fileList != null) {
            m_RecoverableFiles.fileList.clear();
        }
        PPVirtuosoLogTrace.d(TAG, ">>requestRecoverableFileInfo()");
        JSONObject jsonObj = new JSONObject();
        try {
            //sorting parameter need to get sorted deleted list.
            jsonObj.put("sortCollection", sortCollection);
            jsonObj.put("sortBy", sortBy);
            jsonObj.put("sortOrder", sortOrder);
            jsonObj.put("owners", PP_FILE_OWNERS_DELETED);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_FILES, jsonObj, new Object[]{m_RecoverableFiles});
        PPVirtuosoLogTrace.d(TAG, "<<requestRecoverableFileInfo()");
    }

    /**
     * Get video file(s) param from server.
     */
    public void serverRequestDeviceFileInfo(String tag,
                                            int rowCount,
                                            int firstRow,
                                            String sortCollection,
                                            String sortBy,
                                            String sortOrder) {
        if ((firstRow > 0) && (m_DeviceFileInfoModel != null) && (firstRow >= m_DeviceFileInfoModel.iCollectionTotalSize)) {
            return;
        }

        if (m_DeviceFileInfoModel.fileList != null && firstRow == 0) {
            m_DeviceFileInfoModel.fileList.clear();
        }

        PPVirtuosoLogTrace.d(TAG, ">>requestDeviceFileInfo()");
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("sortCollection", sortCollection);
            jsonObj.put("sortBy", sortBy);
            jsonObj.put("rowCount", rowCount);
            jsonObj.put("sortOrder", sortOrder);
            jsonObj.put("firstRow", firstRow);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.GetDataThreadPool(REQ_GET_FILES, jsonObj, new Object[]{m_DeviceFileInfoModel});
        PPVirtuosoLogTrace.d(TAG, "<<requestDeviceFileInfo()");
    }

    /**
     * Get video file(s) param from server.
     */
    public void serverRequestGetOldDeviceFiles(String tag, String sortCollection, String sortBy) {
        if (m_OldestDeviceFileInfoModel.fileList != null) {
            m_OldestDeviceFileInfoModel.fileList.clear();
        }
        PPVirtuosoLogTrace.d(TAG, ">>requestGetOldDeviceFiles()");
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("sortCollection", sortCollection);
            jsonObj.put("sortBy", sortBy);
            jsonObj.put("rowCount", 1);
            jsonObj.put("sortOrder", "asc");
            jsonObj.put("firstRow", 0);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_OLD_FILES, jsonObj, new Object[]{m_OldestDeviceFileInfoModel});
        PPVirtuosoLogTrace.d(TAG, "<<requestGetOldDeviceFiles()");
    }

    /**
     * https://developer.peoplepowerco.com/docs/?q=cloud/deviceFilesUpdate
     * Update video file(s) param from server.
     *
     * @param isStatus
     * @param m_sFileId
     */
    public void serverRequestDeviceFileUpdate(String tag,
                                              boolean isStatus,
                                              String m_sFileId,
                                              int userAction) {
        PPVirtuosoLogTrace.d(TAG, ">>requestDeviceFileUpdate(boolean isStatus,String fileId)" + isStatus, m_sFileId);
        JSONObject jsonObj = new JSONObject();
        JSONObject joFile = null;
        try {
            jsonObj.put("fileId", m_sFileId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("TAG", tag);
            switch (userAction) {
                case PPCommonInfo.USER_FAV_ACTION:
                    joFile = new JSONObject();
                    joFile.put("favourite", isStatus);
                    break;
                case PPCommonInfo.USER_VIDEO_VIEW_ACTION:
                    joFile = new JSONObject();
                    joFile.put("viewed", isStatus);
                    break;
                case PPCommonInfo.USER_RECOVER_VIDEO_PIC:
                    jsonObj.put("recover", String.valueOf(true));
                    break;
                default:
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PutDataThreadPool(REQ_PUT_UPDATE_FILE_ATTRIBUTES, jsonObj, new Object[]{joFile});
        PPVirtuosoLogTrace.d(TAG, "<<requestDeviceFileUpdate(boolean isStatus,String fileId)");
    }

    /**
     * https://developer.peoplepowerco.com/docs/?q=cloud/deviceFilesDelete
     * Delete video file(s) from server.
     */
    public void serverRequestDeviceFileDelete(String tag, String m_sFileId) {
        PPVirtuosoLogTrace.d(TAG, ">>requestDeviceFileDelete(String m_sFileId)", m_sFileId);
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("fileId", m_sFileId);
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(IPPVirtuosoTypes.REQ_DELETE_FILE, jsonObj);
        PPVirtuosoLogTrace.d(TAG, "<<requestDeviceFileDelete(String m_sFileId)");
    }

    /**
     * Uploading photo to server
     */
    synchronized public void serverRequestForUploadingPhoto(String tag, String deviceID, byte[] m_data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("EspToken", PPVirtuoso.getInstance().getPrefs().getEspToken());
            jsonObj.put("proxyId", deviceID);
            jsonObj.put("deviceId", deviceID);
            jsonObj.put("ext", "jpg");
            jsonObj.put("incomplete", false);
            jsonObj.put("thumbnail", false);
            jsonObj.put("expectedSize", m_data.length);
            jsonObj.put("type", PP_FILE_TYPE_IMAGE);
            //
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_UPLOAD_NEW_FILE, jsonObj, new Object[]{m_DeviceUploadFile, m_data});
    }

    /**
     * Uploading thumbnail to server
     */
    synchronized public void serverRequestForUploadingThumbnail(String tag, String deviceID, byte[] m_data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("EspToken", PPVirtuoso.getInstance().getPrefs().getEspToken());
            jsonObj.put("proxyId", deviceID);
            jsonObj.put("deviceId", deviceID);
            jsonObj.put("duration", "" + PPCameraUtils.CameraDefaultValue.MAXIMUM_FREE_USER_MOTION_RECORD_SECONDS);
            jsonObj.put("ext", "mp4");
            jsonObj.put("incomplete", true);
            jsonObj.put("thumbnail", true);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_UPLOAD_NEW_FILE, jsonObj, new Object[]{m_DeviceUploadFile, m_data});
    }

    /**
     * Uploading Video to server
     */
    synchronized public void serverRequestForUploadingVideo(String tag,
                                                            String deviceID,
                                                            int motionSeconds,
                                                            boolean incomplete,
                                                            boolean thumbnail,
                                                            int newFileREfId,
                                                            int fileRefId,
                                                            byte[] m_data) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("EspToken", PPVirtuoso.getInstance().getPrefs().getEspToken());
            jsonObj.put("proxyId", deviceID);
            jsonObj.put("deviceId", deviceID);
            jsonObj.put("duration", "" + motionSeconds);
            jsonObj.put("ext", "mp4");
            jsonObj.put("incomplete", incomplete);
            jsonObj.put("thumbnail", thumbnail);
            jsonObj.put("newFileId", newFileREfId);
            jsonObj.put("fileId", fileRefId);
            jsonObj.put("TAG", tag);
            PPVirtuosoLogTrace.d(TAG, "Seconds for File upload :: " + motionSeconds);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        m_CloudCommander.PostDataThreadPool(REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL, jsonObj, new Object[]{m_DeviceUploadFile, m_data});
    }

    public void serverRequestAggregatedFileList(String tag, String aggregation, String detail, String owner, String startDate, String endDate) {
        JSONObject jsonObj = new JSONObject();
        PPVirtuosoLogTrace.d(TAG, "Time Zone = " + PPAppCenter.m_SharedPresence.getTimeZone());
        try {
            jsonObj.put("locationId", PPAppCenter.m_SharedPresence.getLocationId());
            jsonObj.put("aggregation", aggregation);
            jsonObj.put("details", detail);
            jsonObj.put("timeZone", PPAppCenter.m_SharedPresence.getTimeZone());
            jsonObj.put("owners", owner);
            jsonObj.put("startDate", startDate);
            jsonObj.put("endDate", endDate);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_AGGREGATED_FILE_LIST, jsonObj, new Object[]{m_AggregatedListFile});
    }

    public void serverRequestGetFiles(String tag, String fileId, int type, String userId,
                                      String locationId, String deviceId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("fileId", fileId);
            jsonObj.put("type", type);
            jsonObj.put("userId", userId);
            jsonObj.put("locationId", locationId);
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.GetDataThreadPool(REQ_GET_APP_FILES, jsonObj, new Object[]{m_DeviceFileInfoModel});
    }

    public void serverRequestDeleteFile(String tag, String fileId, String locationId) {
        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("fileId", fileId);
            jsonObj.put("locationId", locationId);
            jsonObj.put("TAG", tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m_CloudCommander.DeleteDataThreadPool(REQ_DELETE_APP_FILE, jsonObj);
    }

    public void serverRequestForLastNFiles(String tag, String count, String startDate, String endDate, String type, String deviceId, String deviceDescription, boolean firstN) {


//        m_AdditionalFileInfoModelNFiles = m_AdditionalFileInfoModel;

        if (m_DeviceFileInfoModel.fileList != null && firstN) {
            m_DeviceFileInfoModel.fileList.clear();
        }

        if (m_AdditionalFileInfoModel.fileList != null && !firstN) {
            m_AdditionalFileInfoModel.fileList.clear();
        }

        JSONObject jsonObj = new JSONObject();
        try {
            jsonObj.put("count", count);
            jsonObj.put("startDate", startDate);
            jsonObj.put("endDate", endDate);
            jsonObj.put("type", type);
            jsonObj.put("deviceId", deviceId);
            jsonObj.put("deviceDescription", deviceDescription);
            jsonObj.put("TAG", tag);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!firstN) {
            m_CloudCommander.GetDataThreadPool(REQ_GET_LAST_N_FILES, jsonObj, new Object[]{m_AdditionalFileInfoModel});
            m_bAddingFiles = true;
        } else {
            m_CloudCommander.GetDataThreadPool(REQ_GET_LAST_N_FILES, jsonObj, new Object[]{m_DeviceFileInfoModel});
            m_bAddingFiles = false;
        }
    }

//    /* FILE MANAGER */
//    //https://app.presencepro.com/cloud/json/files?proxyId=proxyId&deviceId=deviceId&ext=ext&expectedSize=expectedSize&duration=duration&rotate=rotate&fileId=fileId&thumbnail=thumbnail&incomplete=incomplete&type=type
//    public static final short REQ_POST_UPLOAD_NEW_FILE                      = 210;
//
//    // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
//    public static final short REQ_GET_FILES                                 = 211;
//
//    // https://app.presencepro.com/cloud/json/files
//    public static final short REQ_DELETE_ALL_FILES                          = 212;
//
//    // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&thumbnail=thumbnail&incomplete=incomplete&index=index
//    public static final short REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL           = 213;
//
//    // https://app.presencepro.com/cloud/json/files/fileId?thumbnail=thumbnail&API_KEY=API_KEY
//    public static final short REQ_GET_FILE                                  = 214;
//
//    // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&incomplete=incomplete&recover=recover&userId=userId
//    public static final short REQ_PUT_UPDATE_FILE_ATTRIBUTES                = 215;
//
//    // https://app.presencepro.com/cloud/json/files/fileId
//    public static final short REQ_DELETE_FILE                               = 216;
//
//    // https://app.presencepro.com/cloud/json/filesSummary/aggregation?timeZone=timeZone&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate
//    public static final short REQ_GET_AGGREGATED_FILE_LIST                  = 217;
//
//    // https://app.presencepro.com/cloud/json/filesInfo/fileId
//    public static final short REQ_GET_FILE_INFORMATION                      = 218;
//
//    // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
//    public static final short REQ_PUT_APPLY_FILE_TAG                        = 219;
//
//    // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
//    public static final short REQ_DELETE_FILE_TAG                           = 220;
//
//    // https://app.presencepro.com/cloud/json/files/fileId/report/reportType
//    public static final short REQ_PUT_REPORT_ABUSE                          = 221;
//
//    // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
//    public static final short REQ_POST_APP_UPLOAD_FILE_CONTENT              = 222;
//
//    // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
//    public static final short REQ_GET_APP_FILES                             = 223;
//
//    // https://app.presencepro.com/cloud/json/appfiles/fileId?API_KEY=API_KEY&userId=userId&locationId=locationId
//    public static final short REQ_GET_APP_DOWNLOAD_FILE                     = 224;
//
//    // https://app.presencepro.com/cloud/json/appfiles/fileId?userId=userId&locationId=locationId
//    public static final short REQ_DELETE_APP_FILE                           = 225;
}
