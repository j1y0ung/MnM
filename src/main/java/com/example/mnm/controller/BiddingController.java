package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mnm.domain.Bid;

@Controller
public class BiddingController {
	@Autowired
	private AuctionService auctionService;
	
	@ModelAttribute("bid")
	public Bid formBacking() {
		return new Bid();
	}

	@GetMapping("/auction/bidding/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model) {
		model.addAttribute("auctionItem", auctionService.getAuctionItem(auctionId));
		return "auctionBiddingForm";
	}
	
	@PostMapping("/auction/bidding/{auctionId}")
	public String handleRequest2(@PathVariable String auctionId, @ModelAttribute("bid") Bid bid) {
		auctionService.updateBiddingPrice(auctionId, bid);
		return "redirect:/";
	}
	
	@RequestMapping("/auction/bidding/{auctionId}/immd")
	public String handleRequest3(@PathVariable String auctionId, @ModelAttribute("bid") Bid bid) {
		auctionService.immediatePurchase(auctionId, bid);
		return "redirect:/";
	}
	
	@RequestMapping("/auction/biddingProgress/{auctionId}")
	public String handleRequest4(@PathVariable String auctionId, Model model) {
		List<Bid> bids = auctionService.getBiddingProgress(auctionId);
		model.addAttribute("bids", bids);
		return "auctionBiddingView";
	}

}
