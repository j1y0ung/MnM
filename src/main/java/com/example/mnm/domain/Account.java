package com.example.mnm.domain;

public class Account {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String favCategory;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
