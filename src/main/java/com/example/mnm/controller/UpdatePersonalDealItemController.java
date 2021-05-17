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
public class UpdatePersonalDealItemController {

	//	판매 물품 정보 수정
	@RequestMapping("/sellerPage/updateItem/{itemid}")
	public ModelAndView requestHandler(HttpServletRequest request, @RequestParam("itemId") String itemId,
			@ModelAttribute("personalDeal") PersonalDeal personalDeal, Model model) throws Exception{

		
		personalDealItem.updateItemById(itemId, personalDeal);

		return new ModelAndView("personalDealItemView", personalDeal);
	}

}