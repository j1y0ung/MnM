package com.example.mnm.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.AccountDao;
import com.example.mnm.dao.mybatis.mapper.AccountMapper;
import com.example.mnm.domain.Account;

@Repository
public class MybatisAccountDao implements AccountDao {

	@Autowired
	private AccountMapper accountMapper;
	
//	public Account getAccount(String id) throws DataAccessException {
//		return accountMapper.getAccountById(id);
//	}
//
//	public Account getAccount(String username, String password) 
//			throws DataAccessException {
//		return accountMapper.getAccountByUsernameAndPassword(username, password);
//	}

	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}

//	public void updateAccount(Account account) throws DataAccessException {
//		accountMapper.updateAccount(account);
//		accountMapper.updateProfile(account);
//		if (account.getPassword() != null && account.getPassword().length() > 0) 
//		{
//			accountMapper.updateSignon(account);
//		}
//	}
// 
//	public List<String> getUsernameList() throws DataAccessException {
//		return accountMapper.getUsernameList();
//	}

	public String getPwd(String id) throws DataAccessException {
		return accountMapper.getPwd(id);
	}
}