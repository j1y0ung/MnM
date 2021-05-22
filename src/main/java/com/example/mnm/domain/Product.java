package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
	private Category category;
	private String productId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}