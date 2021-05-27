package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalDealItemFormController {

//	판매 물품 등록
	@RequestMapping("/sellerPage/addItem")
	public ModelAndView handleRequest(HttpServletRequest request, 
			@ModelAttribute("personalDeal") PersonalDeal personalDeal ,
			Model model) throws Exception {
		
		return new ModelAndView("personalDealItemForm");
	}
}
