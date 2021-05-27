package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
	private String catId;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCatId() {
		return catId;
	}
	public void setCatId(String catId) {
		this.catId = catId;
	}
	
}
