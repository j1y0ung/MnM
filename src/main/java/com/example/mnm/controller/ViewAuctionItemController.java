package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mnm.domain.AuctionItem;

@Controller
public class ViewAuctionItemController {
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/auction/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model) {
		AuctionItem auctionItem = auctionService.getAuctionItem(auctionId);
		model.addAttribute("auctionItem", auctionItem);
		return "AuctionItemView";
	}

}
