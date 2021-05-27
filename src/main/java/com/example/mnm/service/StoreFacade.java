package com.example.mnm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.domain.Product;

@Service("storeFacade")
public interface StoreFacade {
	
	List<Category> getCategoryList();
	Category getCategory(String categoryId);

	List<Product> getProductList();
	
	List<CrowdFundingItem> getCrowdFundingItemList();
	CrowdFundingItem getFundingItemById(String crowdFundingId);
	List<CrowdFundingItem> getMyFundingItemListById(String userId);
	List<CrowdFundingItem> getMyFundingItemsCheckoutById(String userId);
	void addFundingItem(CrowdFundingItem crowdFundingItem); 
	void removeFundingItemById(String itemId);
	void updateFundingItemById(String crowdFundingId, CrowdFundingItem crowdFundingItem); 
	void fund(FundingForm fundingForm);

	

	
	
}