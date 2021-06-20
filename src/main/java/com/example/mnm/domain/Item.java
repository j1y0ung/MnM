package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@SuppressWarnings("serial")
public class Item implements Serializable{
  /* Private Fields */
  private String itemId; // 아이템 아이디
  @NotEmpty
  private String title; // 제목
  @NotEmpty
  private String description; // 설명
  private String img; // 이미지
  private Date regiDate; // 등록일
  private int views; // 조회수
  private int shippingFee; // 배송비
  private int parentCatId; // 부모 카테고리 id
  private int childCatId; // 자식 카테고리 id
  private Category category; // 카테고리
  @Positive
  private int quantity; // 수량
  private String type; // 타입 (ex) 경매, 크라우드펀딩, 중고거래)
  private String userId; // 판매자
  private Account account;

  /* JavaBeans Properties */
  

  public String getTitle() {
	return title;
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public Date getRegiDate() {
	return regiDate;
}
public void setRegiDate(Date regiDate) {
	this.regiDate = regiDate;
}
public int getViews() {
	return views;
}
public void setViews(int views) {
	this.views = views;
}
public int getShippingFee() {
	return shippingFee;
}
public void setShippingFee(int shippingFee) {
	this.shippingFee = shippingFee;
}
public int getQuantity() { return quantity; }
  public void setQuantity(int quantity) { this.quantity = quantity; }

  public Category getCategory() {
	return category;
  }
  public void setCategory(Category category) {
	  this.category = category;
  }
public int getParentCatId() {
	return parentCatId;
}
public void setParentCatId(int parentCatId) {
	this.parentCatId = parentCatId;
}
public int getChildCatId() {
	return childCatId;
}
public void setChildCatId(int childCatId) {
	this.childCatId = childCatId;
}
  
  public String getType() { return type; }
  public void setType(String type) { this.type = type; }
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	 public Account getAccount() { return account; }
	 
	public void setAccount(Account account) {
		
		this.account = account;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", title=" + title + ", description=" + description + ", img=" + img
				+ ", regiDate=" + regiDate + ", views=" + views + ", shippingFee=" + shippingFee + ", parentCatId="
				+ parentCatId + ", childCatId=" + childCatId + ", category=" + category + ", quantity=" + quantity
				+ ", type=" + type + ", userId=" + userId + ", account=" + account + "]";
	}

}