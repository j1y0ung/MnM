package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FundingForm implements Serializable{
	private Orders orders;
	private CrowdFundingItem crowdFundingItem;
	
	public FundingForm() {
		orders = new Orders();
		crowdFundingItem = new CrowdFundingItem(new Item());
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public CrowdFundingItem getCrowdFundingItem() {
		return crowdFundingItem;
	}
	public void setCrowdFundingItem(CrowdFundingItem crowdFundingItem) {
		this.crowdFundingItem = crowdFundingItem;
	}

}
