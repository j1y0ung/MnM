package com.example.mnm.controller;

import java.io.Serializable;
import org.springframework.beans.support.PagedListHolder;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Product;

@SuppressWarnings("serial")
public class UserSession implements Serializable {

	private Account account;

	private PagedListHolder<Product> myList;

	public UserSession(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setMyList(PagedListHolder<Product> myList) {
		this.myList = myList;
	}

	public PagedListHolder<Product> getMyList() {
		return myList;
	}
}