package com.example.mnm.domain;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Item implements Serializable {
	private Product product; 
	private int itemId;
	private String title;
	private String description;
	private String img;
	private int quantity;
	private Date regiDate;
	private int views;
	private int shippingFee;
	private Account account;
	private String type;

	private String productId;
	private String userId;


	public Item() {
		super();
	}
	public Item(Product product) {
		this.product = product;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId = productId; }

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Item [product=" + product + ", itemId=" + itemId + ", title=" + title + ", description=" + description
				+ ", img=" + img + ", quantity=" + quantity + ", regiDate=" + regiDate + ", views=" + views
				+ ", shippingFee=" + shippingFee + ", account=" + account + ", type=" + type + "]";
	}
}