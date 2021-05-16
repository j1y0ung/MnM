package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewCrowdFundingItemListController {
	private StoreFacade store;

	@Autowired
	public void setStore(StoreFacade store) {
		this.store = store;
	}

	@RequestMapping("/crowdFunding/viewList.do")
	public ModelAndView handleRequest(
		@ModelAttribute("crowdFunding") CrowdFunding crowdFunding
		) throws Exception {
		return new ModelAndView("CrowdFundingItemList", "crowdFundingItemList", 
				store.getCrowdFundingItemList());
	}

}
