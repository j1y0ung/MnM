package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewPersonalDealController {
	

//	물품 상세 정보 보기
	@RequestMapping("/personalDeal/item/{itemid}")
	public String viewPersonalDealHandler(Model model){ 
		
		return "personalDealItemView";
	}

}
