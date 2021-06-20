package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
public class AuctionItem implements Serializable {
	private String auctionId;
	private int currentPrice; // 현재가
	@Positive
	private int startPrice; // 시작가
	@NotNull
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date startDate; // 경매 시작일
	@NotNull
	@Future
	@DateTimeFormat(pattern="yyyy-MM-dd\'T\'HH:mm")
	private Date endDate; // 경매 마감일
	@Positive
	private int bidUnit; // 입찰단위
	private int bidNum; // 입찰수
	private int immdPurchasePrice; // 즉시구매가격
	@Valid
	private Item item; // 아이템
	private String itemId; // 아이템 아이디
	private String status; // 경매 진행 상태
	private String winnerId; // 낙찰자
	private int winningBidPrice; // 낙찰가
	
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
	
	public int getWinningBidPrice() {
		return winningBidPrice;
	}
	public void setWinningBidPrice(int winningBidPrice) {
		this.winningBidPrice = winningBidPrice;
	}
	public String getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(String winnerId) {
		this.winnerId = winnerId;
	}
	@Override
	public String toString() {
		return "AuctionItem [auctionId=" + auctionId + ", currentPrice=" + currentPrice + ", startPrice=" + startPrice
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", bidUnit=" + bidUnit + ", bidNum=" + bidNum
				+ ", immdPurchasePrice=" + immdPurchasePrice + ", item=" + item + ", itemId=" + itemId + ", status="
				+ status + "]";
	}
}
