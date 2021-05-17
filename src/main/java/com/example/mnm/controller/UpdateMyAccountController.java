package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UpdateMyAccountController {
	
	
//	프로필수정
	@RequestMapping("/myAccount/update/{updateproperty}")
	public String updateMyAccountHandler(@RequestParam("updateproperty") String updateproperty,
			@ModelAttribute("account") Account account, Model model) {
		account.updateMyAccount();
		return "myAccountView";
	}
	
}
