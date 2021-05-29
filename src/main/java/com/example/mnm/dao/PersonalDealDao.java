package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.Item;

public interface PersonalDealDao {

	public List<PersonalDealItem> getAllPersonalDealItems() throws DataAccessException; //모든 거래 물품 반환
	public List<PersonalDealItem> getPersonalDealItemList() throws DataAccessException; //거래 물품 리스트 반환
	public PersonalDealItem getPersonalDealItemById(String personalDealId);
	
	public void addPersonalDealItem(PersonalDealItem personalDealItem) throws DataAccessException; //거래 물품 추가
	public void addItem(Item item) throws DataAccessException;
	public void removePersonalDealItemById(String itemId) throws DataAccessException; //거래 물품 삭제
	public void removeItemById(String itemId) throws DataAccessException;
	public void updatePersonalDealItemById(String personalDealId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 물품 정보 업데이트
	public void updateItemById(String itemId, Item item) throws DataAccessException;
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 상태 마감으로 변경

}

