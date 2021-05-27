package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.service.StoreFacade;

@Controller
public class AddPersonalDealItemController {

	@Autowired
	private StoreFacade store;
	
	@ModelAttribute("personalDealForm")
	public PersonalDealForm createPersonalDealForm() {
		return new PersonalDealForm();
	
	//	판매 물품 등록 완료
	@RequestMapping("/sellerPage/addItem/complete")
	public ModelAndView handleRequest(HttpServletRequest request, 
			@ModelAttribute("personalDeal") PersonalDeal personalDeal,
			Model model) throws Exception {
		
		UserSession userSession = new UserSession(
				mnmStore.getAccount(accountForm.getAccount().getUsername()));
		
		store.addPersonalDealItemById(username, personalDeal);
		
		ModelAndView mav = new ModelAndView("myAccountView");
		mav.addObject("personalDeal", personalDeal.addItem());
		
		return mav;
	}

}
