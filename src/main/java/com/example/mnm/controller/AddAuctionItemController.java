package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.mnm.domain.AuctionItem;

@Controller
@RequestMapping("/auction/add")
public class AddAuctionItemController {
	@Autowired
	private AuctionService auctionService;
	
	@ModelAttribute("auctionItem")
	public AuctionItem formBacking() {
		return new AuctionItem();
	}

	@GetMapping
	public String form() {
		return "auctionItemForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute("auctionItem") AuctionItem auctionItem, BindingResult result) {
		new AuctionItemValidator().validate(auctionItem, result);
		if (result.hasErrors()) {
			return "auctionItemForm";
		}
		auctionService.insertAuctionItem(auctionItem);
		return "auctionItemView";
	}

}
