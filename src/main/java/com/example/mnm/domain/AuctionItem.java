package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable {
	private String auctionId;
	private int currentPrice;
	private int startPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date endDate;
	private int bidUnit;
	private int bidNum;
	private int immdPurchasePrice;
	private HashMap<String, Integer> bidInfo;
	private HashMap<String, Integer> finalBidInfo;
	private Item item;
	private String itemId;
	private String status;
	
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
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "AuctionItem [auctionId=" + auctionId + ", currentPrice=" + currentPrice + ", startPrice=" + startPrice
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", bidUnit=" + bidUnit + ", bidNum=" + bidNum
				+ ", immdPurchasePrice=" + immdPurchasePrice + ", item=" + item + ", itemId=" + itemId + ", status="
				+ status + "]";
	}
	
}