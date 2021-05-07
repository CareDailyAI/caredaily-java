package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPOperationTokenModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

/**
 * @author : James Cho
 * @brief : Parse valid operation token.
 * @date : 2017. 2. 17.
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPOperationTokenJsonParser implements PPBaseJsonParser  {
    private static final String TAG = PPOperationTokenJsonParser.class.getSimpleName();

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        try {
            PPOperationTokenModel operationTokenModel = (PPOperationTokenModel)obj[0];

            operationTokenModel.setToken((jso.containsKey("token")) ? jso.getString("token") : null);
            operationTokenModel.setTokenType((jso.containsKey("tokenType")) ? jso.getString("tokenType") : null);
            operationTokenModel.setValidFrom((jso.containsKey("validFrom")) ? jso.getString("validFrom") : null);
//            operationTokenModel.setExpire((jso.containsKey("expire")) ? jso.getString("expire") : null);

            PPVirtuosoLogTrace.d(TAG, "Token : " + operationTokenModel.getToken());
            PPVirtuosoLogTrace.d(TAG, "TokenType : " + operationTokenModel.getTokenType());
//            PPVirtuosoLogTrace.d(TAG, "TokenValidFrom : " + operationTokenModel.getValidFrom());
//            PPVirtuosoLogTrace.d(TAG, "TokenExpire : " + operationTokenModel.getexpire());

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
