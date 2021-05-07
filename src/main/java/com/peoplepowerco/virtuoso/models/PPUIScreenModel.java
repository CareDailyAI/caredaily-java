/**
 * @FileName  : PPUIScreenModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

import java.util.List;

/**
 * @brief : UI screen Model
 * @date  : Aug 14, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPUIScreenModel {
	
	public String sScreenId = null;
	public int nScreenOrder = 0;

	public String sSectionId = null;
	public String sSectionName = null;
	public int nSectionOrder = 0;

	public String sOrganizationId = null;
	public String sOrganizationName = null;
	public String sOrganizationDomain = null;
	public boolean bSeperator = false;
	public List <PPUIScreenItemModel> alUiScreenItemModel = null;

	public  List <PPUIScreenItemModel> getUIScreenItemModel() {
		return alUiScreenItemModel;
	}

	public void setUIScreenItemModel(List<PPUIScreenItemModel> arrayListUIScreenItemModel) {
		this.alUiScreenItemModel = arrayListUIScreenItemModel;
	}
	
	public boolean getSeperatorStatus(){
		return bSeperator;
	}
	
	public void setSeperatorStatus(boolean Status)
	{
		this.bSeperator = Status;
	}
}
