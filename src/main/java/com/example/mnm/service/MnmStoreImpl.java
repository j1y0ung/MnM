package com.example.mnm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.mnm.dao.AccountDao;
import com.example.mnm.domain.Account;

@Service
@Transactional
public class MnmStoreImpl implements MnmStoreFacade { 
	@Autowired	
	private AccountDao accountDao;

	// 로그인시 비밀번호 비교하는 용도
	public String getPwd(String id) {
		return accountDao.getPwd(id);
	}
	
	// 로그인 성공시 Account 얻어오는 용도
	public Account getAccount(String id) {
		return accountDao.getAccount(id);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

//	public void updateAccount(Account account) {
//		accountDao.updateAccount(account);
//	}
//
//	public List<String> getUsernameList() {
//		return accountDao.getUsernameList();
//	}

}