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
public class ViewPersonalDealController {
	
	@Autowired
	private StoreFacade store;
	
//	물품 상세 정보 보기
	@RequestMapping("/personalDeal/item/{itemid}")
	public ModelAndView handleRequest(HttpServletRequest request, 
			@RequestParam(value="itemId") String itemId,
			@ModelAttribute("personalDeal") PersonalDeal personalDeal ,
			Model model) throws Exception {
		
		return new ModelAndView("personalDealItemView", store.getPersonalDealItemById(itemId));
	}

}
