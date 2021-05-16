package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewPersonalDealListController {
	
//	개인간 거래 목록 보기
	@RequestMapping("/personalDeal")
	public String viewPersonalDealListHandler(Model model){ 
		
		return "personalDealItemListView";
	}
}
