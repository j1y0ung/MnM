package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.CrowdFundingItem;

@Controller
@RequestMapping("/crowdFunding/add")
public class AddCrowdFundingItemController {
//	@Autowired
//	private StoreFacade store;

//	@ModelAttribute("addCrowdFundingItemForm")
//	public CrowdFundingItemForm createCrowdFundingItemForm() {
//		return new CrowdFundingItemForm();
//	}
	
	@GetMapping("")
	protected ModelAndView form() {
		
		return new ModelAndView("crowdFundingForm", "crowdFundingItem", new CrowdFundingItem());
	}

	@PostMapping("")
	protected ModelAndView addCrowdFundingItem(
			@ModelAttribute("addCrowdFundingItem") CrowdFundingItem crowdFundingItem 
//			, SessionStatus status
			) {
//		store.addCrowdFundingItem(crowdFundingItemForm.addItem());
		ModelAndView mav = new ModelAndView("crowdFundingRegistration");
//		mav.addObject("crowdFundingItem", crowdFundingItemForm.addItem());
//		status.setComplete();
		return mav;
	}

}
