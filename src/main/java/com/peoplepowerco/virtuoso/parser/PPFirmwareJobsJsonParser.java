package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.devices.PPFirmwareJobListModel;
import com.peoplepowerco.virtuoso.models.devices.PPFirmwareJobModel;

import java.util.List;

/**
 * Created by laghee on 5/26/17.
 */

public class PPFirmwareJobsJsonParser implements PPBaseJsonParser {
    List<PPFirmwareJobModel> jobList;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        jobList = (List<PPFirmwareJobModel>) obj[0];
        if (jobList != null) {
            jobList.clear();
        }

        try {

            PPFirmwareJobListModel response = JSON.parseObject(jso.toString(), PPFirmwareJobListModel.class);
            if (response == null) {
                return false;
            }

            List<PPFirmwareJobModel> jm = response.getJobs();
            if(jm != null) {
                jobList.addAll(jm);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
