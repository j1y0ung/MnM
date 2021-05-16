package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalDealItemFormController {

//	판매 물품 등록
	@RequestMapping("/sellerPage/addItem")
	public String personalDealItemFormHandler(Model model) {
		
		return "personalDealItemForm";
	}
}
