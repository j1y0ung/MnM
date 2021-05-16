package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewMyAccountController {
	

//	마이페이지
	@RequestMapping("/myAccount")
	public String ViewMyAccountHandler(Model model) {
		
		return "myAccountView";
	}
}
