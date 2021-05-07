package com.peoplepowerco.virtuoso.models.devices;

import java.util.List;

/**
 * Created by laghee on 5/26/17.
 */

public class PPFirmwareJobListModel {
    private List<PPFirmwareJobModel> jobs;

    public List<PPFirmwareJobModel> getJobs() {
        return jobs;
    }

    public void setJobs(List<PPFirmwareJobModel> jobs) {
        this.jobs = jobs;
    }
}
