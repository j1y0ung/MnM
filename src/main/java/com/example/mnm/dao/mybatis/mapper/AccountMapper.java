package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Account;

@Mapper
public interface AccountMapper {
	
	Account getAccount(String id);
//
//	Account getAccountByUsernameAndPassword(String username, String password);
//
//	List<String> getUsernameList();
	  
	void insertAccount(Account account);
	  
//	void insertProfile(Account account);
//	  
//	void updateAccount(Account account);
//
//	void updateProfile(Account account);
//
//	void updateSignon(Account account);
	
	String getPwd(String id);

}
