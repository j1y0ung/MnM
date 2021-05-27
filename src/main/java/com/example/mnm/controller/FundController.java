package com.example.mnm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.service.StoreFacade;

@Controller
public class FundController {
	@Autowired private StoreFacade storeFacade;
//
//	@ModelAttribute("fundForm")
//	public FundForm createFundForm() {
//		return new FundForm();
//	}

	@RequestMapping("/crowdFunding/fund")
	protected ModelAndView fund(
//			@ModelAttribute("fundForm") FundForm fundForm,
			@ModelAttribute("crowdFundingId") int crowdFundongId,
			SessionStatus status) {
		
		storeFacade.fund(crowdFundongId);
		ModelAndView mav = new ModelAndView("ViewOrder");
//		mav.addObject("fund", fundForm.getFund());
		
		return mav;
	}

}
