package com.example.mnm.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.PersonalDealItemList;
import com.example.mnm.domain.DealForm;
import com.example.mnm.domain.Item;

public interface PersonalDealDao {

	public List<PersonalDealItem> getAllPersonalDealItems() throws DataAccessException; //모든 거래 물품 반환
	public List<PersonalDealItem> getPersonalDealItemList() throws DataAccessException; //거래 물품 리스트 반환
	public List<PersonalDealItemList> searchPersonalDealItemList(String word);
	public List<PersonalDealItemList> getNewestPersonalDealItemList();
	public List<PersonalDealItemList> getPopularPersonalDealItemList();
	public List<PersonalDealItemList> getLowestPricePersonalDealItemList();
	public List<PersonalDealItemList> getHightestPricePersonalDealItemList();
	public List<PersonalDealItemList> getFourPersonalDealItemList();
	public List<PersonalDealItem> getPersonalDealItemListById(String userId);
	public List<PersonalDealItem> getRecommendedItemList(String fav);
	
	public PersonalDealItem getPersonalDealItemById(String personalDealId);
	public PersonalDealItem getPersonalDealItem(String personalDealId);
	public void addPersonalDealItem(PersonalDealItem personalDealItem) throws DataAccessException; //거래 물품 추가
	public void addItem(Item item) throws DataAccessException;
	public void removeItemById(String itemId) throws DataAccessException;
	public void removePersonalDealItem(String personalDealId);
	public void updatePersonalDealItem(PersonalDealItem personalDealItem);
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException; //거래 상태 마감으로 변경
	public void purchase(DealForm dealForm);
	//public void purchase2(DealForm dealForm);	
	public void updatePurchase(String status, String personalDealId);
	public List<PersonalDealItem> getPurchasedPersonalDealItemListById(String userid);


}

