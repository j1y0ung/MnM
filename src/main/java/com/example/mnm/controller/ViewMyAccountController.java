package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.service.StoreFacade;

@Controller
public class ViewMyAccountController {
	
	@Autowired private StoreFacade storeFacade;
	
//	@ModelAttribute("accountForm")
//	public AccountForm formBackingObject(HttpServletRequest request) 
//			throws Exception {
//		UserSession userSession = 
//			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
//		if (userSession != null) {	// edit an existing account
//			return new AccountForm(
//				mnmStore.getAccount(userSession.getAccount().getUsername()));
//		}
//		else {	// create a new account
//			return new AccountForm();
//		}
//	}
	
//	마이페이지
	@RequestMapping("/myAccount")
	public ModelAndView handleRequest(HttpServletRequest request, 
//			@ModelAttribute("personalDeal") PersonalDeal personalDeal ,
			Model model) throws Exception {
		
//		UserSession userSession = new UserSession(
//				store.getAccount(accountForm.getAccount().getUsername()));
		
		return new ModelAndView("myAccountView"
//				, "userInfo", userSession
				);
	}
}
