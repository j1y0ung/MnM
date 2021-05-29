package com.example.mnm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewPersonalDealItemListController {
	
	@Autowired
	private MnmStoreFacade mnmStore;
	
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/personalDeal")
	public String handleRequest(ModelMap model) throws Exception {
		
		List<PersonalDealItem> personalDeallist = this.mnmStore.getPersonalDealItemList();
		PagedListHolder<PersonalDealItem> pagedList = new PagedListHolder<PersonalDealItem>(personalDeallist);
		pagedList.setPageSize(10);
		
		model.put("personalDealItemList", pagedList);
		
		List<Category> catlist = this.mnmStore.getCategoryList();
		model.put("categories", catlist);
		
		String[] sorts = {"인기순", "최신순", "최다후원순", "최다 금액순", "마감임박순"};
		model.put("sorts", sorts);
		return "thyme/PersonalDealItemListView";
	}
}
