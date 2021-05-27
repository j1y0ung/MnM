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
import com.example.mnm.domain.FundingForm;
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
	public List<CrowdFundingItem> getMyFundingItemListById(String userId) {
		return crowdFundingDao.getMyFundingItemListById(userId);
	}

	@Override
	public List<CrowdFundingItem> getMyFundingItemsCheckoutById(String userId) {
		return crowdFundingDao.getMyFundingItemsCheckoutById(userId);
	}
	
	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) {
		crowdFundingDao.addItem(crowdFundingItem.getItem());
		crowdFundingDao.addFundingItem(crowdFundingItem);
	}

	@Override
	public void removeFundingItemById(String itemId) {
		crowdFundingDao.removeFundingItemById(itemId);
		crowdFundingDao.removeItemById(itemId);
	}

	@Override
	public void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem) {
		crowdFundingDao.updateFundingItemById(crowdFundingId, crowdFundingItem);
		crowdFundingDao.updateItemById(Integer.toString(crowdFundingItem.getItem().getItemId()), crowdFundingItem.getItem());
	}

	@Override
	public void fund(FundingForm fundingForm) {
		crowdFundingDao.fund(fundingForm);
		crowdFundingDao.fund2(fundingForm);
		crowdFundingDao.fundUpdate(fundingForm);
	}
	
	

	

	

}