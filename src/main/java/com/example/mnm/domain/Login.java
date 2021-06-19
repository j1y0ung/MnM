package com.example.mnm.domain;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Login implements Serializable {
	private String userId;
	private String pwd;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
