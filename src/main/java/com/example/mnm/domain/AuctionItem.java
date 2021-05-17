package com.example.mnm.domain;

import java.util.Date;
import java.util.HashMap;

public class AuctionItem {
	private String auctionId;
	private int currentPrice;
	private int startPrice;
	private Date startDate;
	private Date endDate;
	private int bidUnit;
	private int bidNum;
	private int immdPurchasePrice;
	private HashMap<String, Integer> bidInfo;
	private HashMap<String, Integer> finalBidInfo;
	private int views;
	
	public AuctionItem() {
	}
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public int getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(int startPrice) {
		this.startPrice = startPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getBidUnit() {
		return bidUnit;
	}
	public void setBidUnit(int bidUnit) {
		this.bidUnit = bidUnit;
	}
	public int getBidNum() {
		return bidNum;
	}
	public void setBidNum(int bidNum) {
		this.bidNum = bidNum;
	}
	public int getImmdPurchasePrice() {
		return immdPurchasePrice;
	}
	public void setImmdPurchasePrice(int immdPurchasePrice) {
		this.immdPurchasePrice = immdPurchasePrice;
	}
	public HashMap<String, Integer> getBidInfo() {
		return bidInfo;
	}
	public void setBidInfo(HashMap<String, Integer> bidInfo) {
		this.bidInfo = bidInfo;
	}
	public HashMap<String, Integer> getFinalBidInfo() {
		return finalBidInfo;
	}
	public void setFinalBidInfo(HashMap<String, Integer> finalBidInfo) {
		this.finalBidInfo = finalBidInfo;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
	
}
