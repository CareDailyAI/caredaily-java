/**
 * @FileName  : PPUIScreenItemModel.java
 * @Project   : Presence Pro
 * @Copyright : Copyright (c) 2016 People Power Company. All rights reserved.
 */

package com.peoplepowerco.virtuoso.models;

/**
 * @brief : UIScreen item Model
 * @date  : Aug 14, 2014
 * @author : James Cho
 * Copyright (c) 2014 People Power. All rights reserved.
 */
public class PPUIScreenItemModel {
	public String sId = null;
	public String sName =null;
	public int nOrder = 0;
	public String sProduct =null;
	public String sDetails =null;
	public String sIcon = null;
	public int nIndex = 0;
	

	public String getItemId()
	{
		return sId;
	}

	public void setItemId(String sItemId)
	{
		this.sId = sItemId;
	}
	
	public String getItemName()
	{
		return sName;
	}

	public void setItemName(String sItemName)
	{
		this.sName = sItemName;
	}
	
	public String getItemProduct()
	{
		return sProduct;
	}

	public void setItemProduct(String sItemProduct)
	{
		this.sProduct = sItemProduct;
	}
	
	public String getItemDetails()
	{
		return sDetails;
	}

	public void setItemDetails(String sItemDetails)
	{
		this.sDetails = sItemDetails;
	}
	
	public String getItemIcons()
	{
		return sIcon;
	}

	public void setItemIcons(String sItemIcons)
	{
		this.sIcon = sItemIcons;
	}
	
	public int getItemOrder()
	{
		return nOrder;
	}

	public void setItemOrder(int nItemOrder)
	{
		this.nOrder = nItemOrder;
	}
	
	public int getItemIndex()
	{
		return nIndex;
	}

	public void setItemIndex(int nItemIndex)
	{
		this.nIndex = nItemIndex;
	}

}
