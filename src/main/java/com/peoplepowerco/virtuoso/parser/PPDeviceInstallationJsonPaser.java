package com.peoplepowerco.virtuoso.parser;


import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPDeviceInstallationModel;
import com.peoplepowerco.virtuoso.util.PPVirtuosoLogTrace;

public class PPDeviceInstallationJsonPaser implements PPBaseJsonParser {
    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        //JSONObject 		json 	= null;
        String          sinsallation = null;
        try
        {
            PPDeviceInstallationModel installationModel = (PPDeviceInstallationModel)obj[0];

            sinsallation = jso.getString("installation");
            installationModel.setInstallationDetail(sinsallation);
            PPVirtuosoLogTrace.d("PPDeviceInstallationJsonPaser", "InstallationDetail ==" + installationModel.getInstallationDetail());

            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}
