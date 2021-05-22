package com.example.mnm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnm.dao.CategoryDao;
import com.example.mnm.dao.CrowdFundingDao;
import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;

@Service
@Transactional
public class StoreFacadeImpl implements StoreFacade{
	@Autowired CrowdFundingDao crowdFundingDao;
	@Autowired CategoryDao category;
	
	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<String> getUsernameList() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		return category.getCategoryList();
	}
	
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemList() {
		return crowdFundingDao.getAllFundingItems();
	}

	@Override
	public CrowdFundingItem getFundingItemById(String crowdFundingId) {
		return crowdFundingDao.getFundingItemById(crowdFundingId);
	}

}
