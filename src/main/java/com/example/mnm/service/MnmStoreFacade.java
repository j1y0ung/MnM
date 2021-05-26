package com.example.mnm.service;

import java.util.List;


import com.example.mnm.domain.Account;
public interface MnmStoreFacade {

//	Account getAccount(String id);
//
//	Account getAccount(String id, String pwd);

	void insertAccount(Account account);

//	void updateAccount(Account account);
//
//	List<String> getUsernameList();
	
	String getPwd(String id);

}