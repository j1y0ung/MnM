package com.example.mnm.domain;

public class CrowdFundingItem{
	private String crowdFundingId;
	private String shortInfo; // 간략한 설명
	private String targetAmount; // 목표액
	private String startDate; // 펀딩 시작일
	private String closingDate; // 펀딩 마감일
	private String productComposition; // 구성 물품
	private String currentSponsoredAmount; // 현재 모금액
	private String numberOfSponsor; // 후원자 수
	private String detailInfo; // 본문 내용
	private Item item;
	private Account account; //등록자 
	
	public CrowdFundingItem() {
		super();
	}
	public CrowdFundingItem(Item item) {
		this.item = item;
	}
	
	public String getCrowdFundingId() {
		return crowdFundingId;
	}
	public void setCrowdFundingId(String crowdFundingId) {
		this.crowdFundingId = crowdFundingId;
	}
	public String getShortInfo() {
		return shortInfo;
	}
	public void setShortInfo(String shortInfo) {
		this.shortInfo = shortInfo;
	}
	public String getTargetAmount() {
		return targetAmount;
	}
	public void setTargetAmount(String targetAmount) {
		this.targetAmount = targetAmount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(String closingDate) {
		this.closingDate = closingDate;
	}
	public String getProductComposition() {
		return productComposition;
	}
	public void setProductComposition(String productComposition) {
		this.productComposition = productComposition;
	}
	public String getCurrentSponsoredAmount() {
		return currentSponsoredAmount;
	}
	public void setCurrentSponsoredAmount(String currentSponsoredAmount) {
		this.currentSponsoredAmount = currentSponsoredAmount;
	}
	public String getNumberOfSponsor() {
		return numberOfSponsor;
	}
	public void setNumberOfSponsor(String numberOfSponsor) {
		this.numberOfSponsor = numberOfSponsor;
	}
	public String getDetailInfo() {
		return detailInfo;
	}
	public void setDetailInfo(String detailInfo) {
		this.detailInfo = detailInfo;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	
	

}
