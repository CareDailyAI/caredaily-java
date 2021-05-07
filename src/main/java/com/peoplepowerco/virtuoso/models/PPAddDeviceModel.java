package com.peoplepowerco.virtuoso.models;


import java.util.ArrayList;
import java.util.List;

public class PPAddDeviceModel {
    private int sDeviceTypeId;
    private String sName = null;
    private String sSeparatorName = null;
    private boolean isEditable = false;
    public List<PPAddDeviceAttributeModel> listAddDeviceAttributeModel = null;

    private boolean bSeparator = false;

    public void setAsSeparator(boolean separator) {
        bSeparator = separator;
    }
    public boolean isSeparator() {
        return bSeparator;
    }
    public void setSeparatorName(String separatorName){
        sSeparatorName = separatorName;
    }
    public String getSeparatorName(){
        return sSeparatorName;
    }
    public int getDeviceTypeId(){ return sDeviceTypeId;}
    public String getName(){ return sName;}
    public boolean getIsEditable(){
        return isEditable;
    }
    public List <PPAddDeviceAttributeModel>getAttrbuteList() {
        return listAddDeviceAttributeModel;
    }
    public void setDeviceTypeId(int deviceId) {this.sDeviceTypeId = deviceId;}
    public void setName(String name) { this.sName = name;}
    public void setEditable(Boolean bEditable) { this.isEditable = bEditable;}

    public String attributeValue(String key) {
        String value = null;
        if (null != listAddDeviceAttributeModel && !listAddDeviceAttributeModel.isEmpty()) {
            for (PPAddDeviceAttributeModel mode : listAddDeviceAttributeModel) {
                if (mode.getAttrName().equals(key)) {
                    value = mode.getAttrValue();
                    break;
                }
            }
        }
        return value;
    }

    public void setValue(String key, String value) {
        if (null == listAddDeviceAttributeModel) {
            listAddDeviceAttributeModel = new ArrayList<>();
        }
        PPAddDeviceAttributeModel model = new PPAddDeviceAttributeModel();
        model.setAttrName(key);
        model.setsAttrValue(value);
        listAddDeviceAttributeModel.add(model);
    }

}

