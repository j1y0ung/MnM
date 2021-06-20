package com.example.mnm.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.mnm.dao.PersonalDealDao;
import com.example.mnm.dao.mybatis.mapper.PersonalDealMapper;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;

@Repository
public class MybatisPersonalDealDao implements PersonalDealDao{
	
	@Autowired
	PersonalDealMapper personalDealMapper;
	
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
	
	public void removePersonalDealItemById(String itemId) throws DataAccessException{
		personalDealMapper.removePersonalDealItemById(itemId);
	}
	
	public void removeItemById(String itemId) throws DataAccessException{
		personalDealMapper.removeItemById(itemId);
	}
	
	public void updatePersonalDealItemById (String personalDealId, PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.updatePersonalDealItemById(personalDealId, personalDealItem);
	}
	
	public void updateItemById(String itemId, Item item) throws DataAccessException{
		personalDealMapper.updateItemById(itemId, item);
	}
	
	public void finishDealById(int userId, PersonalDealItem personalDealItem) throws DataAccessException{
		personalDealMapper.finishDealById(userId, personalDealItem);
	}

	@Override
	public List<PersonalDealItem> getFourPersonalDealItemList() throws DataAccessException {
		return personalDealMapper.getFourPersonalDealItemList();
	}

}
