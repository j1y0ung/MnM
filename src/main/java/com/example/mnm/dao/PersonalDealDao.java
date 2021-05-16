package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.PersonalDealItem;

public interface PersonalDealDao {

	public List<PersonalDealItem> getAllPersonalDealItems() throws DataAccessException; //모든 거래 물품 반환
	
	public List<PersonalDealItem> getPersonalDealItemList() throws DataAccessException; //거래 물품 리스트 반환
	
	public void addPersonalDealItem(int userId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 물품 추가
	
	public void removePersonalDealItemById(int personalDealId) throws DataAccessException; //거래 물품 삭제

	public void updatePersonalDealItemById(int userId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 물품 정보 업데이트
	
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 상태 마감으로 변경

}

