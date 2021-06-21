package com.example.mnm.dao.mybatis;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.PersonalDealDao;
import com.example.mnm.dao.mybatis.mapper.PersonalDealMapper;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.PersonalDealItemList;
import com.example.mnm.domain.DealForm;
import com.example.mnm.domain.Item;

@Repository
public class MybatisPersonalDealDao implements PersonalDealDao{
	
	@Autowired
	private PersonalDealMapper personalDealMapper;
	
	public List<PersonalDealItem> getAllPersonalDealItems() throws DataAccessException{
		return personalDealMapper.getPersonalDealItemList();
	}	

	public List<PersonalDealItem> getPersonalDealItemList() throws DataAccessException{
		return personalDealMapper.getPersonalDealItemList();
	}

	@Override
	public PersonalDealItem getPersonalDealItemById(String personalDealId) {
		return personalDealMapper.getPersonalDealItemById(personalDealId);
	}
	public void addPersonalDealItem(PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.addPersonalDealItem(personalDealItem);
	}
	
	public void addItem(Item item) throws DataAccessException{
		personalDealMapper.addItem(item);
	}
	
	public void removeItemById(String itemId) throws DataAccessException{
		personalDealMapper.removeItemById(itemId);
	}

	@Override
	public void updatePersonalDealItem(PersonalDealItem personalDealItem) {
		personalDealMapper.updatePersonalDealItem(personalDealItem);
		
	}
	
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.finishDealById(userId, personalDealItem);
	}

	@Override
	public List<PersonalDealItemList> searchPersonalDealItemList(String word) {
		return personalDealMapper.searchPersonalDealItemList(word);
	}

	@Override
	public List<PersonalDealItemList> getNewestPersonalDealItemList() {
		return personalDealMapper.getNewestPersonalDealItemList();
	}

	@Override
	public List<PersonalDealItemList> getPopularPersonalDealItemList() {
		return personalDealMapper.getPopularPersonalDealItemList();
	}

	@Override
	public List<PersonalDealItemList> getLowestPricePersonalDealItemList() {
		return personalDealMapper.getLowestPricePersonalDealItemList();
	}

	@Override
	public List<PersonalDealItemList> getHightestPricePersonalDealItemList() {
		return personalDealMapper.getHightestPricePersonalDealItemList();
	}

	@Override
	public List<PersonalDealItemList> getFourPersonalDealItemList() {
		return personalDealMapper.getFourPersonalDealItemList();
	}

	@Override
	public PersonalDealItem getPersonalDealItem(String personalDealId) {
		return personalDealMapper.getPersonalDealItem(personalDealId);
	}

	@Override
	public void removePersonalDealItem(String personalDealId) {
		personalDealMapper.removePersonalDealItem(personalDealId);
	}

	@Override
	public List<PersonalDealItem> getPersonalDealItemListById(String userId) {
		return personalDealMapper.getPersonalDealItemListById(userId);
	}

	public List<PersonalDealItem> getRecommendedItemList(String fav) {
		return personalDealMapper.getRecommendedItemList(fav);
	}

	@Override
	public void purchase(DealForm dealForm) {
		personalDealMapper.purchase(dealForm);
		
	}

	/*@Override
	public void purchase2(DealForm dealForm) {
		personalDealMapper.purchase2(dealForm);
		
	}*/

	@Override
	public void updatePurchase(String status, String personalDealId) {
		personalDealMapper.updatePurchase(status, personalDealId);
		
	}

	@Override
	public List<PersonalDealItem> getPurchasedPersonalDealItemListById(String userid) {
		return personalDealMapper.getPurchasedPersonalDealItemListById(userid);
	}

}
