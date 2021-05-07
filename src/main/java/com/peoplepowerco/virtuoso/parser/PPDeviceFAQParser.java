package com.peoplepowerco.virtuoso.parser;

import android.text.Html;
import android.text.TextUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.peoplepowerco.virtuoso.models.devices.PPDeviceFAQModel;

import java.util.List;

/**
 * Created by edwardliu on 2018/2/7.
 */

public class PPDeviceFAQParser implements PPBaseJsonParser {

    @Override
    public boolean setData(JSONObject jso, Object[] obj) {
        JSONObject json = null;
        List<PPDeviceFAQModel> deviceFAQModels = (List<PPDeviceFAQModel>) obj[0];
        deviceFAQModels.clear();
        try {
            JSONArray dataArray = jso.getJSONArray("data");
            if (null != dataArray && !dataArray.isEmpty()) {
                JSONObject faqObj = dataArray.getJSONObject(0);
                if (faqObj.containsKey("faq")) {
                    JSONArray faqArray = faqObj.getJSONArray("faq");
                    if (null != faqArray && !faqArray.isEmpty()) {
                        for (int i = 0; i < faqArray.size(); i++) {
                            json = faqArray.getJSONObject(i);
                            PPDeviceFAQModel model = new PPDeviceFAQModel();
                            model.setQuestion(json.getString("question"));
                            String answer = json.getString("answer");
                            if (!TextUtils.isEmpty(answer)) {
                                model.setAnswer(Html.fromHtml(answer).toString());
                            }
                            boolean isAndroid = json.getBoolean("android");
                            if (isAndroid) {
                                deviceFAQModels.add(model);
                            }
                        }
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError ex) {
            Runtime.getRuntime().gc();
        }
        return false;
    }
}
