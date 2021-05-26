package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GiveUpWinningBidController {
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/auction/bidding/{auctionId}/giveUp")
	public String handleRequest(@PathVariable String auctionId) {
		auctionService.giveUpWinning(auctionId);
		return "redirect:/";
	}

}
