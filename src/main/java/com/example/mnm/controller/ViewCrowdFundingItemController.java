package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewCrowdFundingItemController {
	private StoreFacade store;

	@Autowired
	public void setStore(storeFacade store) {
		this.store = store;
	}

	@RequestMapping("/crowdFunding/viewItem.do")
	public ModelAndView handleRequest(
		@ModelAttribute("crowdFunding") CrowdFunding crowdFunding
		) throws Exception {
		String itemid = crowdFunding.getItemId();
		return new ModelAndView("CrowdFundingItem", "crowdFundingItem", 
				store.getItemById(itemid));
	}

}
