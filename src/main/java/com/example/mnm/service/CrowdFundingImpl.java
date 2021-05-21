package com.example.mnm.service;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import com.example.mnm.domain.CrowdFundingItem;

@SuppressWarnings("serial")
@Service("crowdFundingImpl")
public class CrowdFundingImpl implements Serializable, CrowdFunding {
	final Map<String, CrowdFundingItem> crowdFundingItemMap = Collections.synchronizedMap(new HashMap<String, CrowdFundingItem>());
	final PagedListHolder<CrowdFundingItem> crowdFundingItemList = new PagedListHolder<CrowdFundingItem>();

	/* JavaBeans Properties */

	public CrowdFundingImpl() {
		this.crowdFundingItemList.setPageSize(4);
	}

	public Iterator<CrowdFundingItem> getAllCartItems() { return crowdFundingItemList.getSource().iterator(); }
	public PagedListHolder<CrowdFundingItem> getCartItemList() { return crowdFundingItemList; }
	public int getNumberOfItems() { return crowdFundingItemList.getSource().size(); }

	/* Public Methods */
	
	@Override
	public PagedListHolder<CrowdFundingItem> getAllFundingItems() {
		
		return null;
	}

	@Override
	public PagedListHolder<CrowdFundingItem> getfundingItemList() {
		
		return null;
	}

	@Override
	public void addFundingItem(CrowdFundingItem crowdFundingItem) {
		
	}

	@Override
	public void removeFundingItemById(int id) {
		
	}

	@Override
	public void updateFundingItemById(int id, CrowdFundingItem crowdFundingItem) {
		
	}

	@Override
	public void fund(int id) {
		
	}

	
}
