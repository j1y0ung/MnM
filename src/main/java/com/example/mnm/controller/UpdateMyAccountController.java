package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateMyAccountController {
	
	
//	프로필수정
	@RequestMapping("/myAccount/update/{updateproperty}")
	public String updateMyAccountHandler(Model model) {
		
		return "myAccountView";
	}
	
}
