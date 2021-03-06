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
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/myList")
public class ViewMyCrowdFundingItemListController {
	@Autowired private MnmStoreFacade storeFacade;
	
	@GetMapping("")
	public String handleRequest(HttpServletRequest request
			, HttpSession session
			, ModelMap model
			) throws Exception {
		
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/signon";
		}
		
		// 테스트 용 : 사용자 id가 1이라고 가정
//		System.out.println(account.getUserid());
//		List<CrowdFundingItem> list = storeFacade.getMyFundingItemListById("1");
		
		// 세션에서 사용자 id 가져와서 사용 
		List<CrowdFundingItem> list = storeFacade.getMyFundingItemListById(account.getUserid());
		model.put("myCrowdFundingItemList", list);
		
		return "thyme/crowdFundingRegiHistory";
	}
}
