package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class AuctionItemList implements Serializable {
	private String auctionId;
	private String title;
	private String img;
	private int currentPrice;
	private int bidNum;
	private int views;
	private String userid;
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date startDate;
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date endDate;
	private String itemId;
	private String status;
	
	public AuctionItemList() {
	}
	
	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(int currentPrice) {
		this.currentPrice = currentPrice;
	}

	public int getBidNum() {
		return bidNum;
	}

	public void setBidNum(int bidNum) {
		this.bidNum = bidNum;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AuctionItemList [auctionId=" + auctionId + ", title=" + title + ", img=" + img + ", currentPrice="
				+ currentPrice + ", bidNum=" + bidNum + ", views=" + views + ", userid=" + userid + ", startDate="
				+ startDate + ", endDate=" + endDate + ", itemId=" + itemId + ", status=" + status + "]";
	}
	
}
