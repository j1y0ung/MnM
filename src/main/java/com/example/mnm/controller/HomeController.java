package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/")
	public String goHome(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		logger.info("goHome()");
		
		// 각 카테고리별로 4개씩 가져오기
//		List<PersonalDealItem> personalDealItemList = store.getFourPersonalDealItemList();
//		model.put("personalDealItems", personalDealItemList);
//		System.out.println("@@@@@@@@@@@@ " + personalDealItemList);
		List<AuctionItemList> auctionItems = store.getFourAuctionItemList();
		model.put("auctionItems", auctionItems);
		
		List<CrowdFundingItem> crowdFundingItems = store.getFourCrowdFundingItemList();
		model.put("crowdFundingItemList", crowdFundingItems);

		return "thyme/home";
	}
	
//	@RequestMapping("/personalDealList.go")
//	public String goPersonalDealList(HttpServletRequest request, Model model) {
//		return "thyme/";
//	}
//
//	@RequestMapping("/auctionList.go")
//	public String goAuctionList(HttpServletRequest request, Model model) {
//		return "thyme/auctionItemListView";
//	}
//	
//	@RequestMapping("/crowdFundingList.go")
//	public String goCrowdFundingList(HttpServletRequest request, Model model) {
//		return "thyme/crowdFundingListView";
//	}
	
	// 세션 체크용
	@RequestMapping("/sessionCheck")
	private String sessionCheck(@ModelAttribute Account account, HttpServletRequest request) throws Exception {
		logger.info("sessionCheck()");
		
		HttpSession session = request.getSession();
		Account curSession = (Account) session.getAttribute("account");
		if (curSession != null) {
			logger.info("curSession.getName:" + curSession.getName());
		}
		
		return "redirect:/";
	}
	
}
