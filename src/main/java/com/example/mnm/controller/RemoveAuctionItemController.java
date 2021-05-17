package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RemoveAuctionItemController {
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/auction/remove/{auctionId}")
	public String handleRequest(@PathVariable String auctionId) {
		auctionService.deleteAuctionItem(auctionId);
		return "redirect:/";
	}

}
