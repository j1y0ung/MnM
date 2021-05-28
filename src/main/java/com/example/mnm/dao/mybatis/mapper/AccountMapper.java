package com.example.mnm.dao.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Account;

@Mapper
public interface AccountMapper {
	
	void insertAccount(Account account);
	
	void deleteAccount(String userid);
	
	void updateAccount(Account account);
	
	List<Account> getAccountList();
	
	String getPwd(String id);
	
	Account getAccount(String id);

}
