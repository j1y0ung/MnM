package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private String itemId;
	private String title;
	private String description;
	private String img;
	private int quantity;
	private Date regiDate;
	private int views;
	private int shippingFee;
	private Account account;
	private String type;
	private Category category;
	private int parentCatId; // 카테고리 id
	private int childCatId; // 카테고리 id
	private String userId;

	public Item() {
		super();
	}
	public String getTitle() {
		return title;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
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
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", title=" + title + ", description=" + description + ", img=" + img
				+ ", quantity=" + quantity + ", regiDate=" + regiDate + ", views=" + views + ", shippingFee="
				+ shippingFee + ", account=" + account + ", type=" + type + ", category=" + category + ", parentCatId="
				+ parentCatId + ", childCatId=" + childCatId + ", userId=" + userId + "]";
	}
}