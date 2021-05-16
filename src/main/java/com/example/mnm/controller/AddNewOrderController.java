package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AddNewOrderController {
	
//	결제 완료
	@RequestMapping("/personalDeal/order/submitted")
	public String addNewOrderHandler(Model model) {
		
		return "orderCompleteView";
	}
	
	
}
