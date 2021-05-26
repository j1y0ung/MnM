package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mnm.domain.AuctionItem;

@Controller
public class UpdateAuctionItemController {
	@Autowired
	private AuctionService auctionService;
	
	@GetMapping("/auction/update/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model) {
		model.addAttribute("auctionItem", auctionService.getAuctionItem(auctionId));
		return "auctionItemUpdateForm";	
	}
	
	@PostMapping("/auction/update/{auctionId}")
	public String handleRequest2(AuctionItem auctionItem) {
		auctionService.updateAuctionItem(auctionItem);
		return "redirect:/";
	}
}