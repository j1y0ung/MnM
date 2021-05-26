package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Account;

public interface AccountDao {
//	Account getAccount(String username) throws DataAccessException;
//
//	Account getAccount(String username, String password) throws DataAccessException;

	void insertAccount(Account account) throws DataAccessException;

//	void updateAccount(Account account) throws DataAccessException;
//
//	List<String> getUsernameList() throws DataAccessException;
	
	String getPwd(String id) throws DataAccessException;

}
