package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewPersonalDealListController {
	
	@Autowired
	private StoreFacade store;
	
//	개인간 거래 목록 보기
	@RequestMapping("/personalDeal")
	public ModelAndView handleRequest(HttpServletRequest request, 
			@ModelAttribute("personalDeal") PersonalDeal personalDeal ,
			Model model) throws Exception {
		
		return new ModelAndView("personalDealItemListView", "personalDealItemList",store.getPersonalDealList());
	}
}
