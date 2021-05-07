/**
 * @FileName  : IPPVirtuosoTypes.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso;

/**
 * These are result and request type definitions for Virtuoso
 * to be shared publicly.
 */
public interface IPPVirtuosoTypes {
    public static final short ENSEMBLE_SUCCESS                          = 0;  //Success
    public static final short ENSEMBLE_INTERNAL_ERROR                   = 1;  //Internal error
    public static final short ENSEMBLE_WRONG_API_KEY                    = 2;  //Wrong API key
    public static final short ENSEMBLE_WRONG_LOCATION_ID                = 3;  //Wrong location ID or location is not related to the user
    public static final short ENSEMBLE_WRONG_DEVICE_ID                  = 4;  //Wrong device ID or device has not been found
    public static final short ENSEMBLE_PROXY_NOT_FOUND                  = 5;  //Device proxy (gateway) has not been found
    public static final short ENSEMBLE_OBJECT_NOT_FOUND                 = 6;  //Object not found
    public static final short ENSEMBLE_ACCESS_DENIED                    = 7;  //Access denied
    public static final short ENSEMBLE_WRONG_PARAM_VALUE                = 8;  //Wrong parameter value
    public static final short ENSEMBLE_MISSING_PARAM_VALUE              = 9;  //Missed mandatory parameter value
    public static final short ENSEMBLE_NO_AVAIL_RES_TO_COMPLETE         = 10; //No available device resources to complete operation
    public static final short ENSEMBLE_NOT_ENOUGH_FILE_SPACE            = 11; //Not enough free files space
    public static final short ENSEMBLE_INVALID_USER_INFO                = 12; //Invalid username or wrong password
    public static final short ENSEMBLE_WRONG_INDEX_VALUE                = 13; //Wrong index value
    public static final short ENSEMBLE_ERROR_PARSING_INPUT              = 14; //Error in parsing of input data
    public static final short ENSEMBLE_WRONG_CONSUMER_ID                = 15; //Wrong consumer ID
    public static final short ENSEMBLE_WRONG_CONSUMER_TYPE_ID           = 16; //Wrong consumer type ID
    public static final short ENSEMBLE_WRONG_ACTIVATION_KEY             = 17; //Wrong activation key
    public static final short ENSEMBLE_WRONG_RULE_SCHED_FORMAT          = 18; //Wrong rule schedule format
    public static final short ENSEMBLE_WRONG_RULE_ID                    = 19; //Wrong rule ID
    public static final short ENSEMBLE_DUPLICATE_USER_NAME              = 20; //Duplicate user name
    public static final short ENSEMBLE_DEVICE_OFFLINE                   = 21; //Device is offline or disconnected
    public static final short ENSEMBLE_DEVICE_DIFF_LOCATION             = 22; //Device is under different location
    public static final short ENSEMBLE_RULE_GENERATION_ERROR            = 23; //Rule generation error
    public static final short ENSEMBLE_WRONG_DEV_REG_CODE               = 24; //Wrong device registration code
    public static final short ENSEMBLE_DUPLICATE_PROPERTY               = 26; //Duplicate entity or property
    public static final short ENSEMBLE_DEVICE_COMM_TIMEOUT              = 27; //Timeout in device communication
    public static final short ENSEMBLE_DEVICE_NO_LOCATION               = 28; //Device is not linked to any location
    public static final short ENSEMBLE_API_NOT_FOUND                    = 29; //Requested API method not found
    public static final short ENSEMBLE_SERVICE_UNAVAILABLE              = 30; //Service is temporary unavailable
    public static final short ENSEMBLE_UNKNOWN_OAUTH_CLIENT             = 31; //Unknown OAuth client
    public static final short ENSEMBLE_EXTERNAL_ERROR                   = 32; //External application error response
    public static final short ENSEMBLE_UNABLE_TO_MODIFY_EXT_RESOURCES   = 34; //Cannot modify external resources
    public static final short ENSEMBLE_WRONG_PHONE_NUMBER               = 35; //Wrong phone number
    public static final short ENSEMBLE_OPERATION_CANCELLED              = 36; //Operation cancelled



	public static final short RES_FAILURE 		 	        = 0;
    public static final short RES_SUCCESS 		 			= 1;
	public static final short RES_WRONG_APIKEY 		 	    = 2;
    public static final short RES_WRONG_LOCATIONID 		 	= 3;
    public static final short RES_DEVICE_NOT_FOUND 		 	= 4;

    /* CLOUD MANAGER */
    // https:/<cloud>/espapi/watch
    public static final short REQ_GET_CHECK_AVAILABILITY                    = 101;

    // https://<cloud>/cloud/json/settings?deviceId=deviceId&version=version
    public static final short REQ_GET_CLOUD_SETTINGS                        = 102;

    // https://<cloud>/cloud/json/settingsServer?type=type&deviceId=deviceId&ssl=ssl&version=version
    public static final short REQ_GET_SERVER_URL                            = 103;

    //https://app.presencepro.com/cloud/json/settingsServer/type?deviceId=&connected=&version=&brand=&appName=
    public static final short REQ_GET_SERVER                                = 104;

    /* USER MANAGER */
    // https://<cloud>/cloud/json/login?username=username&expiry=expiry
    public static final short REQ_GET_LOGIN_USERNAME                        = 110;

    // https://<cloud>/cloud/json/loginByKey?keyType=keyType&expiry=expiry&clientId=clientId
    public static final short REQ_GET_LOGIN_KEY                             = 111;

    // https://<cloud>/cloud/json/logout
    public static final short REQ_GET_LOGOUT                                = 112;

    // https://app.presencepro.com/cloud/json/user
    public static final short REQ_POST_NEW_USER_AND_LOCATION                = 120;

    // https://app.presencepro.com/cloud/json/user?userId=userId&organizationId=organizationId
    public static final short REQ_GET_USER_INFO                             = 121;

    // https://app.presencepro.com/cloud/json/user?userId=userId
    public static final short REQ_PUT_UPDATE_USER_INFO                      = 122;

    // https://app.presencepro.com/cloud/json/user?userId=userId
    public static final short REQ_DELETE_USER                               = 123;

    // https://app.presencepro.com/cloud/json/devices/<proxyId>/user
    public static final short REQ_GET_USER_BY_DEVICE                        = 124;

    // https://app.presencepro.com/cloud/json/location?userId=userId
    public static final short REQ_POST_ADD_USER_LOCATION                    = 125;

    // https://app.presencepro.com/cloud/json/location/<locationId>
    public static final short REQ_PUT_UPDATE_LOCATION                       = 126;

    // https://app.presencepro.com/cloud/json/location/<locationId>/event/<eventName>
    public static final short REQ_POST_CHANGE_SCENE_AT_LOCATION             = 127;

    // https://app.presencepro.com/cloud/json/location/<locationId>/events
    public static final short REQ_GET_LOCATION_SCENE_HISTORY                = 128;

    // https://app.presencepro.com/cloud/json/emailVerificationMessage?forward=forward&type=type
    public static final short REQ_GET_SEND_VERIFICATION_MESSAGE             = 129;

    // https://app.presencepro.com/cloud/json/emailVerificationMessage?type=type&code=code
    public static final short REQ_PUT_PROVIDE_VERIFICATION_CODE             = 130;

    // https://app.presencepro.com/cloud/json/newPassword?username=username&forward=forward
    public static final short REQ_GET_RECOVER_PASSWORD                      = 131;

    // https://app.presencepro.com/cloud/json/newPassword?forward=forward
    public static final short REQ_PUT_NEW_PASSWORD                          = 132;

    // https://app.presencepro.com/cloud/json/badges?type=type
    public static final short REQ_PUT_RESET_BADGES                          = 133;

    // https://app.presencepro.com/cloud/json/termsOfServices/<signatureId>
    public static final short REQ_PUT_SIGN_TOS                              = 134;

    // https://app.presencepro.com/cloud/json/termsOfServices
    public static final short REQ_GET_SIGNATURES                            = 135;

    // https://app.presencepro.com/cloud/json/callCenter
    public static final short REQ_GET_CALL_CENTER                           = 136;

    // https://app.presencepro.com/cloud/json/callCenter
    public static final short REQ_PUT_UPDATE_CALL_CENTER                    = 137;

    // https://app.presencepro.com/cloud/json/callCenterAlerts
    public static final short REQ_GET_CALL_CENTER_ALERTS                    = 138;

    // https://app.presencepro.com/cloud/json/countries?organizationId=organizationId&countryCode=countryCode
    public static final short REQ_GET_COUNTRIES_STATES_TIME_ZONES           = 139;

    //TODO: MERGE THIS WITH "REQ_GET_USER_INFO"
    public static final short REQ_GET_ALL_USER_INFORMATION                  = 121;

    public static final short REQ_DELETE_CALL_CENTER                        = 140;

    public static final short REQ_TWITTER_USER_INFO                         = 141;

    public static final short REQ_GET_ALL_USER_INFORMATION_NO_SWITCH        = 142;

    /* DEVICE MANAGER */
    // https://app.presencepro.com/cloud/json/devices?locationId=locationId&deviceId=deviceId&deviceType=deviceType&authToken=authToken&startDate=startDate&desc=desc
    public static final short REQ_GET_SIMPLE_DEVICE_LIST                    = 143;

    public static final short REQ_GET_USER_LOCATION_EVENT                   = 144;

    public static final short REQ_GET_USER_INFO_REFRESH                     = 145;

    public static final short REQ_GET_USER_LOCATION_REFRESH                 = 146;

    public static final short REQ_POST_REGISTER_DEVICE                      = 150;

    // https://app.presencepro.com/cloud/json/devices?locationId=locationId&userId=userId&checkPersistent=checkPersistent
    public static final short REQ_GET_DEVICE_LIST                           = 151;

    // https://app.presencepro.com/cloud/json/devices?deviceId=deviceId&clear=clear
    public static final short REQ_DELETE_DEVICES                             = 152;

    // https://app.presencepro.com/cloud/json/devices/deviceId?checkConnected=checkConnected&locationId=locationId&userId=userId
    public static final short REQ_GET_SINGLE_DEVICE                         = 153;

    // https://app.presencepro.com/cloud/json/devices/<deviceId>
    public static final short REQ_PUT_UPDATE_DEVICE                         = 154;

    // https://app.presencepro.com/cloud/json/devices/deviceId?clear=clear
    public static final short REQ_DELETE_DEVICE                             = 155;

    // https://app.presencepro.com/cloud/json/locations/<locationId>/devices/<deviceId>
    public static final short REQ_PUT_UPDATE_DEVICE_AT_LOCATION             = 156;

    // https://app.presencepro.com/cloud/json/locations/locationId/devices/deviceId?clear=clear
    public static final short REQ_DELETE_DEVICE_AT_LOCATION                 = 157;

    // https://app.presencepro.com/cloud/json/deviceActivation/deviceType?sendEmail=sendEmail
    public static final short REQ_GET_DEVICE_ACTIVATION_INFO                = 158;

    // https://app.presencepro.com/cloud/json/locations/locationId/deviceActivation/deviceType?sendEmail=sendEmail
    public static final short REQ_GET_DEVICE_ACTIVATION_INFO_AT_LOCATION    = 159;

    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&value=value&index=index
    public static final short REQ_PUT_SINGLE_DEVICE_PROPERTY                = 160;

    // https://app.presencepro.com/cloud/json/devices/deviceId/properties
    public static final short REQ_PUT_MULTIPLE_DEVICE_PROPERTIES            = 161;

    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
    public static final short REQ_GET_DEVICE_PROPERTY                       = 162;

    // https://app.presencepro.com/cloud/json/devices/deviceId/properties?name=name&index=index
    public static final short REQ_DELETE_DEVICE_PROPERTY                    = 163;

    //TODO: MERGE WITH "REQ_GET_DEVICE_LIST"
    public static final short REQ_GET_DEVICE_SEPARATE_INFO                  = 165;
    public static final short REQ_POST_REGISTER_GATEWAY                     = 166;

    public static final short REQ_PUT_FIRMWARE_UPDATE_STATUS                = 168;
    public static final short REQ_GET_FIRMWARE_JOBS                         = 169;

    /* DEVICE MEASUREMENTS */
    // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId&userId=userId&paramName=paramName
    public static final short REQ_GET_CURRENT_MEASUREMENTS                  = 170;

    // https://app.presencepro.com/cloud/json/devices/deviceId/parameters?locationId=locationId
    public static final short REQ_PUT_SEND_COMMAND                          = 171;

    // https://app.presencepro.com/cloud/json/parameters?locationId=locationId&userId=userId&deviceId=deviceId&paramName=paramName
    public static final short REQ_GET_MEASUREMENTS_WITH_SEARCH              = 172;

    // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByDate/startDate?endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&interval=interval&aggregation=aggregation&reduceNoise=reduceNoise
    public static final short REQ_GET_MEASUREMENT_HISTORY                   = 173;

    // https://app.presencepro.com/cloud/json/devices/deviceId/parametersByCount/rowCount?startDate=startDate&endDate=endDate&locationId=locationId&userId=userId&paramName=paramName&index=index&reduceNoise=reduceNoise
    public static final short REQ_GET_LAST_N_MEASUREMENTS                   = 174;

    // https://app.presencepro.com/cloud/json/units
    public static final short REQ_GET_UNITS_OF_MEASURE                      = 175;


    /* USER COMMUNICATIONS */
    // https://app.presencepro.com/cloud/json/notificationSubscriptions
    public static final short REQ_GET_NOTIFICATION_SUBSCRIPTIONS            = 176;

    // https://app.presencepro.com/cloud/json/notificationSubscriptions/type?email=email&emailPeriod=emailPeriod&push=push&pushPeriod=pushPeriod&sms=sms&smsPeriod=smsPeriod
    public static final short REQ_PUT_NOTIFICATION_SUBSCRIPTIONS            = 177;

    // https://app.presencepro.com/cloud/json/notificationToken/appName/notificationToken_or_registrationId?badge=badge
    public static final short REQ_PUT_APP_NOTIFICATION_REGISTRATION         = 178;

    // https://app.presencepro.com/cloud/json/notificationToken/notificationToken_or_registrationId
    public static final short REQ_DELETE_APP_NOTIFICATION_REGISTRATION      = 179;

    // https://app.presencepro.com/cloud/json/notifications?userId=userId&organizationId=organizationId
    public static final short REQ_POST_SEND_NOTIFICATION                    = 180;

    // https://app.presencepro.com/cloud/json/feedback
    public static final short REQ_POST_CROWD_FEEDBACK                       = 181;

    // https://app.presencepro.com/cloud/json/feedback/appName/type?startPos=startPos&length=length&productId=productId&productCategory=productCategory
    public static final short REQ_GET_CROWD_FEEDBACK_SEARCHING              = 182;

    // https://app.presencepro.com/cloud/json/feedback/feedbackId
    public static final short REQ_GET_CROWD_FEEDBACK                        = 183;

    // https://app.presencepro.com/cloud/json/feedback/feedbackId
    public static final short REQ_PUT_UPDATE_FEEDBACK                       = 184;

    // https://app.presencepro.com/cloud/json/feedback/feedbackId/rank
    public static final short REQ_PUT_VOTE_FOR_FEEDBACK                     = 185;

    // https://app.presencepro.com/cloud/json/support
    public static final short REQ_POST_REQUEST_SUPPORT                      = 186;

    // https://app.presencepro.com/cloud/json/messages
    public static final short REQ_POST_SEND_MESSAGE                         = 187;

    // https://app.presencepro.com/cloud/json/messages?status=status&messageId=messageId&userId=userId&type=type
    public static final short REQ_GET_RECEIVE_MESSAGES                      = 188;

    // https://app.presencepro.com/cloud/json/messages/messageId?read=read
    public static final short REQ_PUT_UPDATE_MESSAGE_ATTRIBUTES             = 189;

    // https://app.presencepro.com/cloud/json/messages/messageId
    public static final short REQ_DELETE_MESSAGE                            = 190;

    // https://app.presencepro.com/cloud/json/messages/messageId
    public static final short REQ_POST_REPLY_TO_MESSAGE                     = 191;

    // https://app.presencepro.com/cloud/json/questions?questionId=questionId&organizationId=organizationId&appId=appId&editable=editable
    public static final short REQ_GET_QUESTIONS                             = 192;

    // https://app.presencepro.com/cloud/json/questions
    public static final short REQ_PUT_ANSWER_QUESTION                       = 193;

    // https://app.presencepro.com/cloud/json/questions?questionId=questionId
    public static final short REQ_POST_UPDATE_RESPONSE                      = 194;

    public static final short REQ_PUT_UPDATE_OTHER_USER_INFO                = 195;

    public static final short REQ_GET_SIMPLE_QUESTIONS                      = 196;


    /* SYSTEM AND USER PROPERTIES */
    public static final short REQ_GET_SYSTEM_PROPERTY                       = 199;
    // https://app.presencepro.com/cloud/json/systemProperty/propertyName
    public static final short REQ_GET_SYSTEM_OR_USER_PROPERTY               = 200;

    // https://app.presencepro.com/cloud/json/userProperties?propertyName=propertyName&userId=userId
    public static final short REQ_GET_USER_PROPERTIES                       = 201;

    // https://app.presencepro.com/cloud/json/userProperties?userId=userId
    public static final short REQ_POST_UPDATE_USER_PROPERTIES               = 202;

    // https://app.presencepro.com/cloud/json/userProperty/propertyName?propertyValue=propertyValue
    public static final short REQ_PUT_UPDATE_USER_PROPERTY                  = 203;

    public static final short REQ_GET_QUESTION_BY_KEY                       = 204;

    /* FILE MANAGER */
    //https://app.presencepro.com/cloud/json/files?proxyId=proxyId&deviceId=deviceId&ext=ext&expectedSize=expectedSize&duration=duration&rotate=rotate&fileId=fileId&thumbnail=thumbnail&incomplete=incomplete&type=type
    public static final short REQ_POST_UPLOAD_NEW_FILE                      = 210;

    // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
    public static final short REQ_GET_FILES                                 = 211;

    // https://app.presencepro.com/cloud/json/files
    public static final short REQ_DELETE_ALL_FILES                          = 212;

    // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&thumbnail=thumbnail&incomplete=incomplete&index=index
    public static final short REQ_POST_FILE_FRAGMENT_OR_THUMBNAIL           = 213;

    // https://app.presencepro.com/cloud/json/files/fileId?thumbnail=thumbnail&API_KEY=API_KEY
    public static final short REQ_GET_FILE                                  = 214;

    // https://app.presencepro.com/cloud/json/files/fileId?proxyId=proxyId&incomplete=incomplete&recover=recover&userId=userId
    public static final short REQ_PUT_UPDATE_FILE_ATTRIBUTES                = 215;

    // https://app.presencepro.com/cloud/json/files/fileId
    public static final short REQ_DELETE_FILE                               = 216;

    // https://app.presencepro.com/cloud/json/filesSummary/aggregation?timeZone=timeZone&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate
    public static final short REQ_GET_AGGREGATED_FILE_LIST                  = 217;

    // https://app.presencepro.com/cloud/json/filesInfo/fileId
    public static final short REQ_GET_FILE_INFORMATION                      = 218;

    // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
    public static final short REQ_PUT_APPLY_FILE_TAG                        = 219;

    // https://app.presencepro.com/cloud/json/files/fileId/tags/tag
    public static final short REQ_DELETE_FILE_TAG                           = 220;

    // https://app.presencepro.com/cloud/json/files/fileId/report/reportType
    public static final short REQ_PUT_REPORT_ABUSE                          = 221;

    // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
    public static final short REQ_POST_APP_UPLOAD_FILE_CONTENT              = 222;

    // https://app.presencepro.com/cloud/json/appfiles?fileId=fileId&type=type&userId=userId&locationId=locationId&deviceId=deviceId&name=name
    public static final short REQ_GET_APP_FILES                             = 223;

    // https://app.presencepro.com/cloud/json/appfiles/fileId?API_KEY=API_KEY&userId=userId&locationId=locationId
    public static final short REQ_GET_APP_DOWNLOAD_FILE                     = 224;

    // https://app.presencepro.com/cloud/json/appfiles/fileId?userId=userId&locationId=locationId
    public static final short REQ_DELETE_APP_FILE                           = 225;

    //TODO: Remove these extra types
    // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
    public static final short REQ_GET_OLD_FILES                             = 226;
    //TODO: Remove these extra types
    // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
    public static final short REQ_GET_RECOVERABLE_FILES                     = 227;
    //TODO: Remove these extra types
    // https://app.presencepro.com/cloud/json/files?deviceId=deviceId&type=type&owners=owners&ownerId=ownerId&startDate=startDate&endDate=endDate&searchTag=searchTag
    public static final short REQ_GET_FILES_EXIST                           = 228;

    // https://app.presencepro.com/cloud/json/filesByCount/count?startDate=&endDate=&type=&deviceId=&deviceDescription=
    public static final short REQ_GET_LAST_N_FILES = 229;



    /* RULES ENGINE */
    // https://app.presencepro.com/cloud/json/ruleConditions?version=version
    public static final short REQ_GET_RULE_PHRASES                          = 230;

    // https://app.presencepro.com/cloud/json/rules
    public static final short REQ_POST_CREATE_RULE                          = 231;

    // https://app.presencepro.com/cloud/json/rules/ruleId
    public static final short REQ_PUT_UPDATE_RULE                           = 232;

    // https://app.presencepro.com/cloud/json/rules/ruleId/attrs
    public static final short REQ_PUT_UPDATE_RULE_ATTRIBUTE                 = 233;

    // https://app.presencepro.com/cloud/json/rules?deviceId=deviceId&details=details
    public static final short REQ_GET_RULES                                 = 234;

    // https://app.presencepro.com/cloud/json/rules/ruleId?details=details
    public static final short REQ_GET_RULE                                  = 235;

    // https://app.presencepro.com/cloud/json/rules/ruleId
    public static final short REQ_DELETE_RULE                               = 236;

    // https://app.presencepro.com/cloud/json/rulesCreateDefault?deviceId=deviceId&userId=userId
    public static final short REQ_POST_CREATE_RULE_FOR_DEVICE               = 237;


    /* PAID SERVICES */
    // https://app.presencepro.com/cloud/json/servicePlans?appName=appName&userId=userId&hiddenPrices=hiddenPrices
    public static final short REQ_GET_SOFTWARE_SUBSCRIPTIONS                = 238;

    // https://app.presencepro.com/cloud/json/receipt/apple?appName=appName
    public static final short REQ_POST_SUBMIT_APPLE_PURCHASE_RECEIPT        = 239;

    // https://app.presencepro.com/auth/paypalpurchase/planPriceId?API_KEY=API_KEY&sandbox=sandbox
    public static final short REQ_GET_REDIRECT_USER_TO_PAYPAL_SITE          = 240;

    // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId?userName=userName&endDate=endDate
    public static final short REQ_POST_ASSIGN_SERVICES_TO_USER              = 241;

    // https://app.presencepro.com/cloud/json/userServicePlans/servicePlanId
    public static final short REQ_DELETE_CANCEL_SUBSCRIPTION                = 242;

    // https://app.presencepro.com/cloud/json/userServicePlansBatch/servicePlanId?endDate=endDate
    public static final short REQ_POST_ASSIGN_SERVICES_TO_USERS             = 243;

    // https://app.presencepro.com/cloud/json/market?appName=appName
    public static final short REQ_GET_STORE_PRODUCTS                        = 244;


    /* DYNAMIC USER INTERFACES */
    // https://app.presencepro.com/cloud/json/uiscreens/appName?version=version
    public static final short REQ_GET_UI_SCREENS                            = 245;

    // https://app.presencepro.com/cloud/json/userTotals?devices=devices&files=files&rules=rules&friends=friends&userId=userId
    public static final short REQ_GET_USER_TOTALS                           = 246;
    public static final short REQ_GET_USER_TOTALS_OLD = 247;

    /* ENERGY MANAGEMENT */
    // https://app.presencepro.com/cloud/json/locations/locationId/energyUsage/aggregation/startDate?endDate=endDate&external=external
    public static final short REQ_GET_LOCATION_ENERGY_USAGE                 = 250;

    // https://app.presencepro.com/cloud/json/locations/locationId/billData
    public static final short REQ_POST_UPLOAD_LOCATION_UTILITY_BILLS        = 251;

    // https://app.presencepro.com/cloud/json/locations/locationId/bills/billId
    public static final short REQ_DELETE_UTILITY_BILL                       = 252;

    // https://app.presencepro.com/cloud/json/devices/deviceId/currentEnergyUsage?index=index&locationId=locationId&userId=userId
    public static final short REQ_GET_DEVICE_ENERGY_USAGE                   = 253;

    // https://app.presencepro.com/cloud/json/devices/deviceId/energyUsage/aggregation/startDate?endDate=endDate&reduceNoise=reduceNoise&locationId=locationId&userId=userId
    public static final short REQ_GET_AGGREGATED_DEVICE_ENERGY_USAGE        = 254;

    // https://app.presencepro.com/cloud/json/locations/locationId/billing/filter
    public static final short REQ_GET_BILLING_INFORMATION                   = 255;

    // https://app.presencepro.com/cloud/json/locations/locationId/billing
    public static final short REQ_PUT_UPDATE_BILLING_INFORMATION            = 256;


    /* CREATING PRODUCTS */
    // https://app.presencepro.com/cloud/json/deviceTypes?deviceType=deviceType&attrName=attrName&attrValue=attrValue&own=own&simple=simple&organizationId=organizationId
    public static final short REQ_GET_SUPPORTED_PRODUCTS                    = 260;

    // https://app.presencepro.com/cloud/json/deviceTypeAttrs
    public static final short REQ_GET_SUPPORTED_PRODUCT_ATTRIBUTES          = 261;

    // https://app.presencepro.com/cloud/json/deviceType
    public static final short REQ_POST_CREATE_PRODUCT                       = 262;

    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId
    public static final short REQ_POST_UPDATE_PRODUCT                       = 263;

    // https://app.presencepro.com/cloud/json/deviceParameters?paramName=paramName
    public static final short REQ_GET_PRODUCT_PARAMETERS                    = 264;

    // https://app.presencepro.com/cloud/json/deviceParameters
    public static final short REQ_POST_CREATE_OR_UPDATE_PRODUCT_PARAMETERS  = 265;

    // https://app.presencepro.com/cloud/json/deviceParameters/parameterName
    public static final short REQ_DELETE_PRODUCT_PARAMETER                  = 266;

    // https://app.presencepro.com/cloud/json/ruleTemplates
    public static final short REQ_GET_PRODUCT_RULE_PHRASE                   = 267;

    // https://app.presencepro.com/cloud/json/ruleTemplates
    public static final short REQ_POST_CREATE_PRODUCT_RULE_PHRASE           = 268;

    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
    public static final short REQ_GET_PRODUCT_RULE_PHRASE_BY_ID             = 269;

    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
    public static final short REQ_PUT_UPDATE_PRODUCT_RULE_PHRASE            = 270;

    // https://app.presencepro.com/cloud/json/ruleTemplates/templateId
    public static final short REQ_DELETE_PRODUCT_RULE_PHRASE                = 271;

    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules?details=details
    public static final short REQ_GET_PRODUCT_DEFAULT_RULES                 = 272;

    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId?hidden=hidden
    public static final short REQ_POST_PRODUCT_DEFAULT_RULE                 = 273;

    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/rules/ruleId
    public static final short REQ_DELETE_PRODUCT_DEFAULT_RULE               = 274;

    // https://app.presencepro.com/cloud/json/deviceType/deviceTypeId/goals
    public static final short REQ_GET_DEVICE_GOALS_BY_TYPE                  = 275;

    // https://app.presencepro.com/cloud/json/goals/goalId/installation
    public static final short REQ_GET_DEVICE_INSTALLATION_INSTRUCTIONS      = 276;

    // https://app.presencepro.com/cloud/json/hardwareOrders?userId=userId
    public static final short REQ_GET_HARDWARE_ORDERS                       = 277;

    // https://app.presencepro.com/cloud/json/hardwareOrders/orderId/status/status?userId=userId&changeDate=changeDate
    public static final short REQ_PUT_SET_HARDWARE_ORDERS                   = 278;


    /* OAuth 2.0 Client */
    // https://app.presencepro.com/cloud/json/authorize
    public static final short REQ_GET_SUPPORTED_THIRD_PARTY_APPS            = 280;

    // https://app.presencepro.com/auth/authorize/appId?API_KEY=API_KEY
    public static final short REQ_GET_ACCESS_THIRD_PARTY_APP                = 281;

    // https://app.presencepro.com/cloud/json/authorize/applicationId?userId=userId
    public static final short REQ_DELETE_REMOVE_THIRD_PARTY_APP_SUPPORT     = 282;


    /* OAuth 2.0 Host */
    // https://app.presencepro.com/oauth/authorize?client_id=client_id&state=state&response_type=response_type
    public static final short REQ_GET_AUTHORIZE_THIRD_PARTY_APP             = 283;

    // https://app.presencepro.com/auth/approve/approved?client_id=client_id&state=state&response_type=response_type&API_KEY=API_KEY
    public static final short REQ_GET_APPROVE_OR_DENY_APP_AUTHORIZATION     = 284;

    // https://app.presencepro.com/oauth/token?code=code&refresh_token=refresh_token&client_id=client_id
    public static final short REQ_POST_GET_ACCESS_TOKEN                     = 285;

    // https://app.presencepro.com/cloud/authClient?client_id=client_id&userId=userId
    public static final short REQ_DELETE_REVOKE_OAUTH_CLIENTS               = 286;


    /* FRIENDS */
    // https://app.presencepro.com/cloud/json/friends
    public static final short REQ_POST_ADD_FRIENDS                          = 290;

    // https://app.presencepro.com/cloud/json/friends?friendshipId=friendshipId&deviceId=deviceId&checkConnected=checkConnected
    public static final short REQ_GET_FRIENDS                               = 291;

    // https://app.presencepro.com/cloud/json/friends/friendshipId
    public static final short REQ_PUT_UPDATE_FRIENDSHIP                     = 292;

    // https://app.presencepro.com/cloud/json/friends/friendshipId
    public static final short REQ_DELETE_FRIENDSHIP                         = 293;

    // https://app.presencepro.com/cloud/json/friends/friendshipId/devices/deviceId
    public static final short REQ_DELETE_SHARED_DEVICE                      = 294;

    //TODO: Hide this
    public static final short REQ_GET_USER_BY_EMAIL                         = 295;
    public static final short REQ_BLOCK_FRIEND                              = 296;
    public static final short REQ_GET_OPERATION_TOKEN                       = 297;
    public static final short REQ_POST_USER_BY_PHONEORMAIL                  = 298;
    public static final short REQ_GET_USER_BY_PHONEORMAIL                   = 299;

    /* REPORTS */
    // https://app.presencepro.com/espapi/report/json/totalDeviceAlerts?alertType=alertType
    public static final short REQ_GET_TOTAL_DEVICE_ALERTS                   = 300;

    /* DEVICE IO */
    public static final short REQ_SET_DEVICE_DEFAULT_PARAMETER              = 500;
    public static final short REQ_SET_DEVICE_DEFAULT_PARAMETERS             = 501;
    public static final short REQ_SET_DEVICE_COMMAND_RESPONSE = 502;
    public static final short REQ_PUT_SEND_COMMAND_TYPE = 503;

    public static final short REQ_GET_STREAMING_SESSION_CAMERA              = 600;
    public static final short REQ_GET_STREAMING_SESSION_VIEWER              = 601;
    public static final short REQ_SET_DEVICE_MOTION_ACTIVITY                = 602;

    public static final short REQ_SET_MOTION_ALERT_USER                     = 700;

    //TODO: REMOVE THESE WHEN finished debugging...
    public static final short REQ_POST_DEVICE_FILE_THUMBNAIL                = 800;
    public static final short REQ_POST_DEVICE_FILE_VIDEO                    = 801;

    public static final short REQ_GET_APP_INFORMATION                       = 900;
    public static final short REQ_GET_APP_INSTANCE                          = 901;
    public static final short REQ_CONFIGURE_APP_INSTANCE                    = 902;
    public static final short REQ_PURCHASE_APP_INSTANCE                     = 903;
    public static final short REQ_POST_DATA_STREAM_WITH_MASK                = 904;

    public static final short REQ_GET_SMS_SUBSCRIBERS                       = 905;
    public static final short REQ_POST_SMS_SUBSCRIBER                       = 906;
    public static final short REQ_DELETE_SMS_SUBSCRIBER                     = 907;

	public static final short REQ_GET_DEVICE_FAQ                            = 908;
    public static final short REQ_GET_NOTIFICATIONS                         = 909;
	public static final short REQ_GET_DEVICE_MODELS                         = 910;
    public static final short REQ_GET_STORIES                               = 911;
    public static final short REQ_GET_LOCATION_SPACES                       = 912;
    public static final short REQ_LINK_DEVICE_SPACE                         = 913;
    public static final short REQ_UNLINK_DEVICE_SPACE                       = 914;
    public static final short REQ_DELETE_LOCATION_SPACE                     = 915;
    public static final short REQ_UPDATE_LOCATION_SPACE                     = 916;
    public static final short REQ_GET_LOCATION_USERS                        = 917;
    public static final short REQ_POST_LOCATION_USERS                       = 918;
    public static final short REQ_DELETE_LOCATION_USER                      = 919;
    public static final short REQ_GET_SEND_PASSCODE                         = 920;
    // https://app.presencepro.com/cloud/json/location/<locationId>
    public static final short REQ_DELETE_LOCATION                           = 921;
    public static final short REQ_GET_LOCATION_STATE                        = 922;
    public static final short REQ_PUT_LOCATION_STATE                        = 923;

    // Device Measurements
    public static final short REQ_POST_DATA_REQUEST                         = 924;
    // Presence Gateway uuids;
    public static final short REQ_GET_PRESENCE_IDS                          = 925;
    public static final short REQ_POST_AUTH_ACCESS                          = 926;

    public static final short REQ_GET_OTHER_USER_INFORMATION                = 927;
    public static final short REQ_POST_DATA_STREAM_WITH_MASK_FALSE          = 928;
    public static final short REQ_GET_LOCATION_USERS_WITH_FILTERS           = 929;

    public static final short REQ_GET_LOCATION_OTHER_STATE                  = 930;
    public static final short REQ_GET_LOCATION_DASHBOARD                    = 931;
    public static final short REQ_GET_LOCATION_TASK_USERS                   = 932;

    public static final short REQ_GET_COMMUNITY_POSTS                       = 933;
    public static final short REQ_CREATE_COMMUNITY_POST                     = 934;
    public static final short REQ_UPDATE_COMMUNITY_POST                     = 935;
    public static final short REQ_DELETE_COMMUNITY_POST                     = 936;

    public static final short REQ_GET_LOCATION_TIME_STATE                   = 937;

    public static final short REQ_CREATE_COMMUNITY_COMMENT                  = 938;
    public static final short REQ_CREATE_COMMUNITY_REACTION                 = 939;
    public static final short REQ_DELETE_COMMUNITY_COMMENT                  = 940;
    public static final short REQ_GET_BOT_SUMMARY                           = 941;

    public static final short REQ_POST_UPLOAD_POST_FILE                     = 942;
    public static final short REQ_PUT_UPLOAD_FILE_DONE                      = 943;
    public static final short REQ_GET_POST_FILE_URL                         = 944;
    public static final short REQ_DELETE_POST_FILE                          = 945;

    public static final short REQ_PUT_USER_CODE                             = 946;
    public static final short REQ_DELETE_USER_CODE                          = 947;
    public static final short REQ_GET_USER_CODE                             = 948;
    public static final short REQ_PUT_USER_CODE_DEVICE_ID                   = 949;

    public static final short REQ_GET_SURVEY_QUESTIONS                      = 960;
    public static final short REQ_PUT_ANSWER_SURVEY_QUESTIONS               = 961;

    public static final short REQ_GET_ORGANIZATION_PROPERTIES               = 962;
    public static final short REQ_GET_ORGANIZATION_OBJECT_CONTENT           = 963;
    public static final short REQ_GET_LOCATION_SERVICE_PLANS                = 964;
    public static final short REQ_GET_DEVICE_MODEL_BY_DEVICETYPE            = 965;
    public static final short REQ_PUT_ADD_LOCATION = 966;
    public static final short REQ_PUT_MOVE_LOCATION = 967;

    public static final short REQ_GET_NARRATIVE_QUESTIONS                   = 10001;
    public static final short REQ_GET_NARRATIVES                            = 10002;
    public static final short REQ_GET_CIRCLES                               = 10003;
    public static final short REQ_GET_CIRCLE_MEMBERS                        = 10004;
    public static final short REQ_GET_POSTS                                 = 10005;
    public static final short REQ_POST_CIRCLE                               = 10006;
    public static final short REQ_SET_CIRCLE_STATUS                         = 10007;
    public static final short REQ_POST_CIRCLE_FILE                          = 10009;
    public static final short REQ_POST_CREATE_POST                          = 10010;
    public static final short REQ_POST_CREATE_COMMENT                       = 10011;
}
