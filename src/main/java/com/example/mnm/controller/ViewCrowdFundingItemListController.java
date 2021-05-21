package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.CrowdFunding;
import com.example.mnm.service.StoreFacade;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewCrowdFundingItemListController {
//	private StoreFacade store;
//
//	@Autowired
//	public void setStore(StoreFacade store) {
//		this.store = store;
//	}

	@RequestMapping("/crowdFunding/list")
	public ModelAndView handleRequest(
		@ModelAttribute("crowdFunding") CrowdFunding crowdFunding) throws Exception {
		
		return new ModelAndView("crowdFundingListView"
//				, "crowdFundingItemList", store.getCrowdFundingItemList()
				);
	}
}
