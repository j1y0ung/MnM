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

//	public Account getAccount(String id) {
//		return accountDao.getAccount(id);
//	}
//
//	public Account getAccount(String id, String pwd) {
//		return accountDao.getAccount(id, pwd);
//	}

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

	public String getPwd(String id) {
		return accountDao.getPwd(id);
	}

}