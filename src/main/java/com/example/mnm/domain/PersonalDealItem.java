package com.example.mnm.domain;

import java.sql.Date;

public class PersonalDealItem {
	private String personalDealId;
	private Item item;
	private String title; //개인 간 거래  글 제목
	private String shippingFee; //배송비 추가 여부
	private String description; //판매자 추가 설명
	private String location; //거래 지역 정보
	private String productStatus; //상품상태
	private Date date; //판매 글 작성일
	private String dealStatus; //개인 간 거래 진행 상태
	private int views; //조회수
	private int price; //판매희망가
	
	public String getPersonalDealId() {
		return personalDealId;
	}
	public void setPersonalDealId(String personalDealId) {
		this.personalDealId = personalDealId;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(String shippingFee) {
		this.shippingFee = shippingFee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	@Override
	public String toString() {
		return "PersonalDealItem [item=" + item + ", title=" + title + ", shippingFee=" + shippingFee + ", description="
				+ description + ", location=" + location + ", date=" + date + ", dealStatus=" + dealStatus + ", views="
				+ views + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}	
	
}

