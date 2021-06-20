package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FundingForm implements Serializable{
	private Orders orders;
	private CrowdFundingItem crowdFunding;
	
	public FundingForm() {
		orders = new Orders();
		crowdFunding = new CrowdFundingItem(new Item());
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public CrowdFundingItem getCrowdFundingItem() {
		return crowdFunding;
	}
	public void setCrowdFundingItem(CrowdFundingItem crowdFundingItem) {
		this.crowdFunding = crowdFundingItem;
	}
	
	@Override
	public String toString() {
		return "FundingForm [orders=" + orders + ", crowdFunding=" + crowdFunding + "]";
	}

	
}
