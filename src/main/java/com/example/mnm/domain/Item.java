package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@SuppressWarnings("serial")
public class Item implements Serializable{
  /* Private Fields */
  private String itemId;
  @NotEmpty
  private String title;
  @NotEmpty
  private String description;
  private String img;
  private Date regiDate;
  private int views;
  private int shippingFee;
  private int parentCatId; // 카테고리 id
  private int childCatId; // 카테고리 id
  private double listPrice;
  private double unitCost;
  private int supplierId;
  private String status;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private Category category;
  @Positive
  private int quantity;
  private String type;
  private String userId;

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
public int getSupplierId() { return supplierId; }
  public void setSupplierId(int supplierId) { this.supplierId = supplierId; }


  public double getListPrice() { return listPrice; }
  public void setListPrice(double listPrice) { this.listPrice = listPrice; }

  public double getUnitCost() { return unitCost; }
  public void setUnitCost(double unitCost) { this.unitCost = unitCost; }

  public String getStatus() { return status; }
  public void setStatus(String status) { this.status = status; }
 
  public String getAttribute1() { return attribute1; }
  public void setAttribute1(String attribute1) { this.attribute1 = attribute1; }
  public String getAttribute2() { return attribute2; }
  public void setAttribute2(String attribute2) { this.attribute2 = attribute2; }
  public String getAttribute3() { return attribute3; }
  public void setAttribute3(String attribute3) { this.attribute3 = attribute3; }
  public String getAttribute4() { return attribute4; }
  public void setAttribute4(String attribute4) { this.attribute4 = attribute4; }
  public String getAttribute5() { return attribute5; }
  public void setAttribute5(String attribute5) { this.attribute5 = attribute5; }
  
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
				+ parentCatId + ", childCatId=" + childCatId + ", listPrice=" + listPrice + ", unitCost=" + unitCost
				+ ", supplierId=" + supplierId + ", status=" + status + ", attribute1=" + attribute1 + ", attribute2="
				+ attribute2 + ", attribute3=" + attribute3 + ", attribute4=" + attribute4 + ", attribute5="
				+ attribute5 + ", category=" + category + ", quantity=" + quantity + ", type=" + type + ", userId="
				+ userId + ", account=" + account + "]";
	}
	
	
  
}