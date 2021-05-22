package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bid implements Serializable {
	private int bidPrice;
	private String userId;
	
	public Bid() {
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	
}
