package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class FundController {
//	@Autowired
//	private StoreFacade store;
//
//	@ModelAttribute("fundForm")
//	public FundForm createFundForm() {
//		return new FundForm();
//	}

	@RequestMapping("/crowdFunding/fund")
	protected ModelAndView fund(
//			@ModelAttribute("fundForm") FundForm fundForm, 
			SessionStatus status) {
//		store.fund(fundForm.getFund());
		ModelAndView mav = new ModelAndView("cartView");
//		mav.addObject("fund", fundForm.getFund());
		status.setComplete();
		return mav;
	}

}
