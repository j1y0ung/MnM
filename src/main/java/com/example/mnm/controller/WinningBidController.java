package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WinningBidController {
	@Autowired
	private AuctionService auctionService;
	
	@RequestMapping("/auction/chooseWinnerbidding{auctionId}")
	public String handleRequest(@PathVariable String auctionId) {
		auctionService.updateWinner(auctionId);
		return "redirect:/";
	}

}
