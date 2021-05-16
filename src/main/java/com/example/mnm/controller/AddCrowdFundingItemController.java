package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddCrowdFundingItemController {
	@Autowired
	private StoreFacade store;

	@ModelAttribute("addCrowdFundingItemForm")
	public CrowdFundingItemForm createCrowdFundingItemForm() {
		return new CrowdFundingItemForm();
	}

	@RequestMapping("/crowdFunding/addItem.do")
	protected ModelAndView addCrowdFundingItem(
			@ModelAttribute("addCrowdFundingItemForm") CrowdFundingItemForm addCrowdFundingItemForm, 
			SessionStatus status) {
		store.addCrowdFundingItem(crowdFundingItemForm.addItem());
		ModelAndView mav = new ModelAndView("ViewItem");
		mav.addObject("crowdFundingItem", crowdFundingItemForm.addItem());
		status.setComplete();
		return mav;
	}

}
