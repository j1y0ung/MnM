package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.service.MnmStoreFacade;
import com.example.mnm.domain.AuctionItemList;
@Controller
public class ViewAuctionItemListController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/auction/recently")
	public String handleRequest(Model model) {
		List<AuctionItemList> auctionItems = mnmStore.getRecentAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		return "thyme/AuctionItemListView";
	}
	@RequestMapping("/auction/mostViews")
	public String handleRequest2(Model model) {
		List<AuctionItemList> auctionItems = mnmStore.getPopularAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		return "thyme/AuctionItemListView";
	}
	@RequestMapping("/auction/mostBids")
	public String handleRequest3(Model model) {
		List<AuctionItemList> auctionItems = mnmStore.getMostBiddingAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		return "thyme/AuctionItemListView";
	}
	@RequestMapping("/auction/deadline")
	public String handleRequest4(Model model) {
		List<AuctionItemList> auctionItems = mnmStore.getClosingAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		return "thyme/AuctionItemListView";
	}	
	@RequestMapping("/auction/search")
	public String handleRequest5(@RequestParam String word, Model model) {
		List<AuctionItemList> auctionItems = mnmStore.searchAuctionItemList(word);
		model.addAttribute("auctionItems", auctionItems);
		return "thyme/AuctionItemListView";
	}
}