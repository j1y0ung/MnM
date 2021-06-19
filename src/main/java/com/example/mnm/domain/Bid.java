package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Bid implements Serializable {
	private int bidPrice;
	private String userId;
	private String auctionId;
	private String giveUp;
	
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
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public String getGiveUp() {
		return giveUp;
	}
	public void setGiveUp(String giveUp) {
		this.giveUp = giveUp;
	}
}