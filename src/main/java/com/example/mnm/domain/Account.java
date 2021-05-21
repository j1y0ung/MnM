package com.example.mnm.domain;

public class Account {
	private String id;
	private String password;
	private String email;
	private String name;
	private String address;
	private String phone;
	private String favouriteCategoryId;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	
}
