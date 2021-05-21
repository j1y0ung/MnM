package com.example.mnm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;

public interface StoreFacade {
	Account getAccount(String username);

	Account getAccount(String username, String password);

	void insertAccount(Account account);

	void updateAccount(Account account);

	List<String> getUsernameList();


	List<Category> getCategoryList();

	Category getCategory(String categoryId);

	List<CrowdFundingItem> getCrowdFundingItemList();
}
