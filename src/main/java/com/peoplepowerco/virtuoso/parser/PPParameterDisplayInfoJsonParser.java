package com.peoplepowerco.virtuoso.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayMLNameModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPParameterDisplayOptionModel;
import com.peoplepowerco.virtuoso.models.productsParameters.PPProductsParametersModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : James Cho
 * @date : 2019-11-19
 */
public class PPParameterDisplayInfoJsonParser implements PPBaseJsonParser {

    private static final String TAG = PPParameterDisplayInfoJsonParser.class.getSimpleName();
    private List<PPProductsParametersModel> mDeviceParameterDisplayInfoModels;

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {

        try {
            mDeviceParameterDisplayInfoModels = (List<PPProductsParametersModel>) obj[0];
            if (mDeviceParameterDisplayInfoModels != null && mDeviceParameterDisplayInfoModels.size() > 0) {
                mDeviceParameterDisplayInfoModels.clear();
            }
            JSONArray array = jso.getJSONArray("deviceParams");
            if (null != array && !array.isEmpty()) {
                int deviceParamCounts = array.size();

                for (int i = 0; i < deviceParamCounts; i++) {
                    JSONObject json = array.getJSONObject(i);
                    PPProductsParametersModel paramDisplayInfoModel = new PPProductsParametersModel();
                    paramDisplayInfoModel.setEditable(json.containsKey("editable") ? json.getBoolean("editable") : false);
                    paramDisplayInfoModel.setHistorical(json.containsKey("historical") ? json.getInteger("historical") : -1);
                    paramDisplayInfoModel.setSystemMultiplier(json.containsKey("systemMultiplier") ? json.getString("systemMultiplier") : null);
                    paramDisplayInfoModel.setSystemUnit(json.containsKey("systemUnit") ? json.getString("systemUnit") : null);
                    paramDisplayInfoModel.setScale(json.containsKey("scale") ? json.getInteger("scale") : -1);
                    paramDisplayInfoModel.setProfiled(json.containsKey("profiled") ? json.getBoolean("profiled") : false);
                    paramDisplayInfoModel.setAdjustment(json.containsKey("adjustment") ? json.getBoolean("adjustment") : false);
                    paramDisplayInfoModel.setConfigured(json.containsKey("configured") ? json.getBoolean("configured") : false);
                    paramDisplayInfoModel.setNumeric(json.containsKey("numeric") ? json.getBoolean("numeric") : false);
                    paramDisplayInfoModel.setDescription(json.containsKey("description") ? json.getString("description") : null);
                    paramDisplayInfoModel.setName(json.containsKey("name") ? json.getString("name") : null);
                    JSONObject displayJson = json.getJSONObject("displayInfo");
                    if (displayJson != null) {
                        PPParameterDisplayModel displayModel = new PPParameterDisplayModel();
                        displayModel.setDefaultOption(displayJson.containsKey("defaultOption") ? displayJson.getInteger("defaultOption") : -1);
                        displayModel.setValueType(displayJson.containsKey("valueType") ? displayJson.getInteger("valueType") : -1);
                        displayModel.setIconFont(displayJson.containsKey("iconFont") ? displayJson.getString("iconFont") : null);

                        JSONObject mlJson = displayJson.getJSONObject("mlName");
                        PPParameterDisplayMLNameModel mlModel = new PPParameterDisplayMLNameModel();
                        mlModel.setMlName(mlJson.containsKey("en") ? mlJson.getString("en") : null);
                        displayModel.setMlNameModel(mlModel);
                        displayModel.setIcon(displayJson.containsKey("icon") ? displayJson.getString("icon") : null);
                        displayModel.setHidden(displayJson.containsKey("hidden") ? displayJson.getBoolean("hidden") : false);
                        displayModel.setRanged(displayJson.containsKey("ranged") ? displayJson.getBoolean("ranged") : false);
                        JSONArray optionArray = displayJson.getJSONArray("options");
                        if (null != optionArray && !optionArray.isEmpty()) {
                            int optionArrayCounts = optionArray.size();
                            List<PPParameterDisplayOptionModel> optionModelList = new ArrayList<PPParameterDisplayOptionModel>();
                            for (int j = 0; j < optionArrayCounts; j++) {
                                JSONObject optionJson = optionArray.getJSONObject(j);
                                PPParameterDisplayOptionModel optionModel = new PPParameterDisplayOptionModel();
                                optionModel.setId(optionJson.containsKey("id") ? optionJson.getInteger("id") : -1);
                                optionModel.setValue(optionJson.containsKey("value") ? optionJson.getString("value") : null);
                                optionModel.setIcon(optionJson.containsKey("icon") ? optionJson.getString("icon") : null);
                                optionModel.setIconfont(optionJson.containsKey("iconFont") ? optionJson.getString("iconFont") : null);

                                JSONObject optionMlJson = optionJson.getJSONObject("mlName");
                                PPParameterDisplayMLNameModel optionMlModel = new PPParameterDisplayMLNameModel();
                                optionMlModel.setMlName(optionMlJson.containsKey("en") ? optionMlJson.getString("en") : null);
                                optionModel.setMlNameModel(optionMlModel);
                                optionModelList.add(optionModel);
                            }
                            displayModel.setOptionList(optionModelList);
                        }
                        paramDisplayInfoModel.setDisplayModel(displayModel);
                    }
                    mDeviceParameterDisplayInfoModels.add(paramDisplayInfoModel);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
