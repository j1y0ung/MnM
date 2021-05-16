package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddPersonalDealItemController {
	
//	판매 물품 등록 완료
	@RequestMapping("/sellerPage/addItem/complete")
	public String addPersonalDealItemHandler(Model model) {
		
		return "myAccountView";
	}
	
}
