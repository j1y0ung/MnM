package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddNewOrderController {
	
	@Autowired
	private StoreFacade store;
	
	//	결제 완료
	@RequestMapping("/personalDeal/order/submitted")
	public ModelAndView handleRequest(HttpServletRequest request, 
			@ModelAttribute("addPersonalDealItemForm") PersonalDealItemForm addPersonalDealItemForm ,
			Model model) throws Exception {
		
		store.addPersonalDealItemForm()
		
		
		return new ModelAndView("orderCompleteView");
	}
	
	
}
