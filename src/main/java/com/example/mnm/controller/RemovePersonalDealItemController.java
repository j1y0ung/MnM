package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemovePersonalDealItemController {
	
//	등록한 물품 삭제
	@RequestMapping("/sellerPage/removeItem/{itemid}")
	public String removePersonalDealItemHandler(Model model) {
		
		return "myPersonalDealItemListView";
	}
	
}
