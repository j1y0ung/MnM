package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CrowdFundingItem implements Serializable{
	private int crowdFundingId;
	private String shortInfo; // 간략한 설명
	private int targetAmount; // 목표액
	private Date startDate; // 펀딩 시작일
	private Date closingDate; // 펀딩 마감일
	private String productComposition; // 구성 물품
	private int currentSponsoredAmount; // 현재 모금액
	private int numberOfSponsor; // 후원자 수
	private String status;
	private Item item;
	
	public CrowdFundingItem() {
		super();
	}
	public CrowdFundingItem(Item item) {
		this.item = item;
	}
	public int getCrowdFundingId() {
		return crowdFundingId;
	}
	public void setCrowdFundingId(int crowdFundingId) {
		this.crowdFundingId = crowdFundingId;
	}
	public String getShortInfo() {
		return shortInfo;
	}
	public void setShortInfo(String shortInfo) {
		this.shortInfo = shortInfo;
	}
	public int getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(int targetAmount) {
		this.targetAmount = targetAmount;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}
	public String getProductComposition() {
		return productComposition;
	}
	public void setProductComposition(String productComposition) {
		this.productComposition = productComposition;
	}
	public int getCurrentSponsoredAmount() {
		return currentSponsoredAmount;
	}
	public void setCurrentSponsoredAmount(int currentSponsoredAmount) {
		this.currentSponsoredAmount = currentSponsoredAmount;
	}
	public int getNumberOfSponsor() {
		return numberOfSponsor;
	}
	public void setNumberOfSponsor(int numberOfSponsor) {
		this.numberOfSponsor = numberOfSponsor;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	
}
