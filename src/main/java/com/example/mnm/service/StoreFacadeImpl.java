package com.example.mnm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mnm.dao.CategoryDao;
import com.example.mnm.dao.CrowdFundingDao;
import com.example.mnm.dao.ProductDao;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Product;

@Service
@Transactional
public class StoreFacadeImpl implements StoreFacade{
	@Autowired CrowdFundingDao crowdFundingDao;
	@Autowired CategoryDao categoryDao;
	@Autowired ProductDao productDao;
	

	@Override
	public Category getCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}
	
	@Override
	public List<Product> getProductList() {
		return productDao.getProductList();
	}
	
	@Override
	public List<CrowdFundingItem> getCrowdFundingItemList() {
		return crowdFundingDao.getAllFundingItems();
	}

	@Override
	public CrowdFundingItem getFundingItemById(String crowdFundingId) {
		return crowdFundingDao.getFundingItemById(crowdFundingId);
	}

	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) {
		crowdFundingDao.addItem(crowdFundingItem.getItem());
		crowdFundingDao.addFundingItem(crowdFundingItem);
	}

	@Override
	public void removeFundingItemById(int crowdFundingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFundingItemById(int crowdFundingId, CrowdFundingItem crowdFundingItem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fund(int crowdFundingId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CrowdFundingItem> getMyFundingItemListByUserId(String userId) {
		return crowdFundingDao.getMyFundingItemListByUserId(userId);
	}

	

	

}
