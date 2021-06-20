package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Category;
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
		logger.info("[HomeController INFO] goHome()");
//		List<PersonalDealItemList> personalDealItemList = store.getPersonalDealItemList();
		
		// 경매 아이템 4개 가져옴
		List<AuctionItemList> auctionItems = store.getFourAuctionItemList();
		model.put("auctionItems", auctionItems);
		
		// 크라우드펀딩 아이템 4개 가져옴
//		List<CrowdFundingItem> crowdFundingItems = store.getFourCrowdFundingItemList();
//		PagedListHolder<CrowdFundingItem> pagedList = new PagedListHolder<CrowdFundingItem>(crowdFundingItems);
//		pagedList.setPageSize(10);
//		model.put("crowdFundingItemList", pagedList);
		
		//중고물품 4개 가져옴
		//List<PersonalDealItem> personalDealItems = store.getFourPersonalDealItemList();
		//model.put("personalDealItems", personalDealItems);

		return "thyme/home";
	}
	
	@RequestMapping("/personalDealList.go")
	public String goPersonalDealList(HttpServletRequest request, Model model) {
		return "thyme/personalDealItemListView";
	}

	@RequestMapping("/auctionList.go")
	public String goAuctionList(HttpServletRequest request, Model model) {
		return "thyme/auctionItemListView";
	}
	
	@RequestMapping("/crowdFundingList.go")
	public String goCrowdFundingList(HttpServletRequest request, Model model) {
		return "thyme/crowdFundingListView";
	}
	
}
