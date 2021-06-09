package com.example.mnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Bid;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewAuctionItemController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/auction/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model,
			@RequestParam(required = false, defaultValue = "false") boolean alreadyAdded) {

		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		
		mnmStore.increaseItemViews(auctionItem.getItemId());
		
		List<Bid> bids = mnmStore.getBids(auctionId);
		
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		
		model.addAttribute("auctionItem", auctionItem);
		model.addAttribute("bids", bids);
		model.addAttribute("parentCatId", mnmStore.getCategoryName(Integer.toString(auctionItem.getItem().getParentCatId())));
		model.addAttribute("childCatId", mnmStore.getCategoryName(Integer.toString(auctionItem.getItem().getChildCatId())));
		
		if (alreadyAdded) {
			model.addAttribute("alreadyAdded", alreadyAdded);
		}
		
		return "thyme/AuctionItemView";
	}

}
