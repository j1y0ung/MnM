package com.example.mnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.domain.Bid;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@SessionAttributes("userSession")
public class ViewAuctionHistoryController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/auction/history")
	public String handleRequest(@ModelAttribute("userSession") UserSession userSession, Model model) {
		// 판매한 물품 목록
		List<AuctionItemList> sellingAuctionItemList = mnmStore.getSellingAuctionItemList(userSession.getAccount().getUserid());
		for (int i = 0; i < sellingAuctionItemList.size(); i++) {
			System.out.println(sellingAuctionItemList.get(i).getAuctionId());
		}
		// 입찰한 물품 목록
		List<AuctionItemList> biddingAuctionItemList = mnmStore.getBiddingAuctionItemList(userSession.getAccount().getUserid());
		for (int i = 0; i < biddingAuctionItemList.size(); i++) {
			System.out.println(biddingAuctionItemList.get(i).getAuctionId());
		}
		// 낙찰받은 물품 목록
		List<AuctionItemList> auctionedItemList = mnmStore.getAuctionedItemList(userSession.getAccount().getUserid());
		for (int i = 0; i < auctionedItemList.size(); i++) {
			System.out.println(auctionedItemList.get(i).getAuctionId());
		}
		model.addAttribute("sellingAuctionItemList", sellingAuctionItemList);
		model.addAttribute("biddingAuctionItemList", biddingAuctionItemList);
		model.addAttribute("auctionedItemList", auctionedItemList);
		
		return "thyme/AuctionHistory";
	}

}
