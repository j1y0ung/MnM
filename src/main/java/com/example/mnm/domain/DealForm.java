package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DealForm implements Serializable{
	private Orders orders;
	private PersonalDealItem personalOrder;
	
	public DealForm() {
		orders = new Orders();
		personalOrder = new PersonalDealItem(new Item());
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public PersonalDealItem getPersonalDealItem() {
		return personalOrder;
	}
	public void setPersonalDealItem(PersonalDealItem personalDealItem) {
		this.personalOrder = personalDealItem;
	}
	
	@Override
	public String toString() {
		return "DealForm [orders=" + orders + ", crowdFunding=" + personalOrder + "]";
	}
	

	
}
