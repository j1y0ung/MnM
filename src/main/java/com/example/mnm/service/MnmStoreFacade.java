package com.example.mnm.service;

import java.util.List;


import com.example.mnm.domain.Account;
public interface MnmStoreFacade {

	// 로그인시 비밀번호 비교하는 용도
	String getPwd(String id);
		
	// 로그인 성공시 Account 얻어오는 용도
	Account getAccount(String id);

	void insertAccount(Account account);

//	void updateAccount(Account account);
//
//	List<String> getUsernameList();

}