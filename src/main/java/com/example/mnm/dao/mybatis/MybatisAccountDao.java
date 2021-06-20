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
	
	public void insertAccount(Account account) throws DataAccessException {
		accountMapper.insertAccount(account);
	}
	
	public void deleteAccount(String userid) throws DataAccessException {
		accountMapper.deleteAccount(userid);
	}
	
	public void updateAccount(Account account) throws DataAccessException {
		accountMapper.updateAccount(account);
	}
	
	public List<Account> getAccountList() throws DataAccessException {
		return accountMapper.getAccountList();
	}
	
	public String getPwd(String id) throws DataAccessException {
		return accountMapper.getPwd(id);
	}
	
	public Account getAccount(String id) throws DataAccessException {
		return accountMapper.getAccount(id);
	}
	
	public String hasAccount(String id) throws DataAccessException {
		return accountMapper.hasAccount(id);
	}
	
}