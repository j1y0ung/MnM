package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private String userId;
	private String password;
	private String email;
	private String name;
	private String address;
	private String phone;
	private String favouriteCategoryId;
	private String accountNum;
	
	private String id;
	private String pwd;
	private String favCategory;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFavouriteCategoryId() {
		return favouriteCategoryId;
	}
	public void setFavouriteCategoryId(String favouriteCategoryId) {
		this.favouriteCategoryId = favouriteCategoryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFavCategory() {
		return favCategory;
	}
	public void setFavCategory(String favCategory) {
		this.favCategory = favCategory;
	}
	
}
