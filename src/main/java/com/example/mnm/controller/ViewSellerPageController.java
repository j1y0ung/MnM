package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewSellerPageController {
	
//	판매자 페이지
	@RequestMapping("/sellerPage")
	public String viewSellerPageHandler(Model model){ 
		
		return "sellerPageView";
	}
}
