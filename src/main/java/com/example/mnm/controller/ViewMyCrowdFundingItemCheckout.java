package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/myFundingCheckout")
public class ViewMyCrowdFundingItemCheckout {

	@Autowired private MnmStoreFacade storeFacade;
	
	@GetMapping("")
	public String handleRequest(HttpServletRequest request
			, HttpSession session
			, ModelMap model
			) throws Exception {
		
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "thyme/LoginForm";
		} 
		
		List<FundingForm> myLists = storeFacade.getMyFundingItemsCheckoutById(account.getUserid());
		model.put("myLists", myLists);
		
		return "thyme/crowdFundingHistory";
	}
	
	@PostMapping("/cancel")
	public String cancelFunding(HttpServletRequest request
			, HttpSession session
			, @RequestParam("crowdFundingId") int crowdFundingId
			, @RequestParam("orderId") int orderId
			, @RequestParam("lineNum") int lineNum
			, @ModelAttribute FundingForm fundingForm
			) throws Exception {
		
		fundingForm.getCrowdFundingItem().setCrowdFundingId(crowdFundingId);
		fundingForm.getOrders().setOrderId(orderId);
		fundingForm.getOrders().getcLineItem().setLineNumber(lineNum);
		fundingForm.getOrders().setUserId(((Account) session.getAttribute("account")).getUserid());
//		System.out.println(fundingForm.toString());
//		System.out.println(fundingForm.getCrowdFundingItem().getCrowdFundingId());
		
		storeFacade.cancelMyFundingItemsCheckout(fundingForm);
		
		return "redirect:/crowdFunding/myFundingCheckout";
	}
}
