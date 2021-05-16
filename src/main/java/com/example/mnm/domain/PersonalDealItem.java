package com.example.mnm.domain;

import java.sql.Date;

public class PersonalDealItem {
	private Item item;
	private String title; //개인 간 거래  글 제목
	private String shippingFee; //배송비 추가 여부
	private String description; //판매자 추가 설명
	private String location; //거래 지역 정보
	private Date date; //판매 글 작성일
	private String dealStatus; //개인 간 거래 진행 상태
	private int views; //조회수
	
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

	
	
}

