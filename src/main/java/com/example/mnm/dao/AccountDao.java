package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.Account;

public interface AccountDao {
	
	// 계정 추가
	void insertAccount(Account account) throws DataAccessException;
	
	// 계정 삭제
	void deleteAccount(String userid) throws DataAccessException;
	
	// 계정 업데이트
	void updateAccount(Account account) throws DataAccessException;
	
	// 계정 목록 가져오기
	List<Account> getAccountList() throws DataAccessException;

	// id에 일치하는 비밀번호 가져오기
	String getPwd(String id) throws DataAccessException;

	// 계정 정보 가져오기
	Account getAccount(String id) throws DataAccessException;
	
	// 계정 유무 확인
	String hasAccount(String id) throws DataAccessException;
	
}
