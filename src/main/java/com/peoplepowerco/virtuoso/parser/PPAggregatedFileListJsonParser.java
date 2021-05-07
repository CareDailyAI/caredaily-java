package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.PPAggregatedFileSummaryModel;
import com.peoplepowerco.virtuoso.models.PPAggregatedListFileModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho
 * @brief :
 * @date : 24/04/2018
 * @Copyright : Copyright (c) 2015 People Power Company. All rights reserved.
 */
public class PPAggregatedFileListJsonParser implements PPBaseJsonParser {

    private static final String TAG = PPAggregatedFileListJsonParser.class.getSimpleName();
    private PPAggregatedListFileModel aggregatedFileModel;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {

        JSONArray jsonSummaryArray = null;
        JSONObject jsoSummaryObj = null;

        try {
            aggregatedFileModel = (PPAggregatedListFileModel) obj[0];
            aggregatedFileModel.setTotalFileSpace((jso.containsKey("totalFilesSpace")) ? jso.getLong("totalFilesSpace") : 0L);
            aggregatedFileModel.setUsedFileSpace((jso.containsKey("usedFilesSpace")) ? jso.getLong("usedFilesSpace") : 0L);
            aggregatedFileModel.setFileCount((jso.containsKey("filesCount")) ? jso.getInteger("filesCount") : 0);
            aggregatedFileModel.setStartDate((jso.containsKey("startDate")) ? jso.getString("startDate") : null);
            aggregatedFileModel.setStartDateMs((jso.containsKey("startDateMs")) ? jso.getLong("startDateMs") : 0L);
            aggregatedFileModel.setEndDate((jso.containsKey("endDate")) ? jso.getString("endDate") : null);
            aggregatedFileModel.setEndDateMs((jso.containsKey("endDateMs")) ? jso.getLong("endDateMs") : 0L);

            jsonSummaryArray = jso.getJSONArray("summaries");

            if (jsonSummaryArray != null) {
                int count = jsonSummaryArray.size();
                List<PPAggregatedFileSummaryModel> aggregatedFileSummaryModelList = new ArrayList<PPAggregatedFileSummaryModel>();
                for (int i = 0; i < count; i++) {
                    if (jsonSummaryArray != null && jsonSummaryArray.size() > 0) {
                        jsoSummaryObj = jsonSummaryArray.getJSONObject(i);
                        PPAggregatedFileSummaryModel summaryModel = new PPAggregatedFileSummaryModel();
                        summaryModel.setDate((jsoSummaryObj.containsKey("date")) ? jsoSummaryObj.getString("date") : null);
                        summaryModel.setDateMs((jsoSummaryObj.containsKey("dateMs")) ? jsoSummaryObj.getLong("dateMs") : 0L);
                        summaryModel.setTotal((jsoSummaryObj.containsKey("total")) ? jsoSummaryObj.getInteger("total") : 0);
                        summaryModel.setDeleted((jsoSummaryObj.containsKey("deleted")) ? jsoSummaryObj.getInteger("deleted") : 0);
                        summaryModel.setSize((jsoSummaryObj.containsKey("size")) ? jsoSummaryObj.getInteger("size") : 0);
                        summaryModel.setDuration((jsoSummaryObj.containsKey("duration")) ? jsoSummaryObj.getInteger("duration") : 0);
                        summaryModel.setViewed((jsoSummaryObj.containsKey("viewed")) ? jsoSummaryObj.getInteger("viewed") : 0);
                        summaryModel.setFavourite((jsoSummaryObj.containsKey("favourite")) ? jsoSummaryObj.getInteger("favourite") : 0);
                        aggregatedFileSummaryModelList.add(summaryModel);
                    }
                }
                aggregatedFileModel.setSummaryModelList(aggregatedFileSummaryModelList);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
