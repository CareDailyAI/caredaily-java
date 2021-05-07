package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPTermsOfServiceModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

import java.util.ArrayList;

/**
 * @FileName : ${file_name}
 * @Project : ${project_name}
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */
public class PPTermsOfServiceJsonParser implements PPBaseJsonParser {
    public  ArrayList<PPTermsOfServiceModel> m_TermsOfModleArrayList;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        // TODO Auto-generated method stub
        JSONArray jaArrayTos = null;
        //JSONObject 		json 	= null;
        String sTos = null;
        try{
            m_TermsOfModleArrayList = (ArrayList<PPTermsOfServiceModel>) obj[0];
            jaArrayTos = (jso.containsKey("termsOfServices")) ? jso.getJSONArray("termsOfServices") : null;

            if(jaArrayTos != null && jaArrayTos.size() > 0){
                int nArrayName = jaArrayTos.size();
                for(int i=0; i<nArrayName; i++){
                    sTos = jaArrayTos.getString(i);
                    PPTermsOfServiceModel termsOfServiceModel = new PPTermsOfServiceModel();
                    termsOfServiceModel.sTos = sTos;
                    PPVirtuosoLogTrace.d("PPTermsOfServiceJsonParser", "Terms of service = " +  termsOfServiceModel.sTos);
                    m_TermsOfModleArrayList.add(termsOfServiceModel);
                }
            }
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
