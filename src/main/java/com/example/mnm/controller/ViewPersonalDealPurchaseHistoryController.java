package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/personalDeal/myPurchaseList")
public class ViewPersonalDealPurchaseHistoryController {
	@Autowired 
	private MnmStoreFacade storeFacade;
	
	@GetMapping("")
	public String handleRequest(HttpServletRequest request
			, HttpSession session
			, ModelMap model
			) throws Exception {
		
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/signon";
		}
		
		List<PersonalDealItem> purchasedList = storeFacade.getPurchasedPersonalDealItemListById(account.getUserid());
		model.put("purchasedPersonalDealItemList", purchasedList);
		
		return "thyme/PersonalDealPurchaseHistory";
	}
}
