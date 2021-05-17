package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mnm.domain.AuctionItem;

@Controller
public class ViewAuctionItemListController {
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/auction/recently")
	public String handleRequest(Model model) {
		List<AuctionItem> auctionItems = this.auctionService.getAuctionItemListBy("startDate");
		model.addAttribute("auctionItemList", auctionItems);
		return "AuctionItemListView";
	}
	@RequestMapping("/auction/mostViews")
	public String handleRequest2(Model model) {
		List<AuctionItem> auctionItems = this.auctionService.getAuctionItemListBy("views");
		model.addAttribute("auctionItemList", auctionItems);
		return "AuctionItemListView";
	}
	@RequestMapping("/auction/mostBids")
	public String handleRequest3(Model model) {
		List<AuctionItem> auctionItems = this.auctionService.getAuctionItemListBy("bidNum");
		model.addAttribute("auctionItemList", auctionItems);
		return "AuctionItemListView";
	}
	@RequestMapping("/auction/deadline")
	public String handleRequest4(Model model) {
		List<AuctionItem> auctionItems = this.auctionService.getAuctionItemListBy("endDate");
		model.addAttribute("auctionItemList", auctionItems);
		return "AuctionItemListView";
	}	
	@RequestMapping("/auction/search/{word}")
	public String handleRequest5(@PathVariable String word, Model model) {
		List<AuctionItem> auctionItems = this.auctionService.searchAuctionItemList(word);
		model.addAttribute("auctionItemList", auctionItems);
		return "AuctionItemListView";
	}
}
