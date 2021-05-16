package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdatePersonalDealItemController {
	

//	판매 물품 정보 수정
	@RequestMapping("/sellerPage/updateItem/{itemid}")
	public String updatePersonalDealItemHandler(Model model) {
		
		return "personalDealItemView";
	}
	
}