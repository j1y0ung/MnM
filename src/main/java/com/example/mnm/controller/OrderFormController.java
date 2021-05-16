package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderFormController {
	
//	물건 주문
	@RequestMapping("/personalDeal/order/{itemid}")
	public String orderFormHandler(Model model) {
		
		return "personalDealItemOrderForm";
	}
	
}
