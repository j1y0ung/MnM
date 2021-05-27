package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RemovePersonalDealItemController {
	
//	등록한 물품 삭제
	@RequestMapping("/sellerPage/removeItem/{itemid}")
	public String removePersonalDealItem(@RequestParam("itemId") String itemId,
			@ModelAttribute("personalDeal") PersonalDeal personalDeal, Model model) {
		
		personalDeal.removeItemById(itemId);
		
		return "myPersonalDealItemListView";
	}
	
}
