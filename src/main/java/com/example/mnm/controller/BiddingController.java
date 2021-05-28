package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Bid;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@SessionAttributes("userSession")
public class BiddingController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@PostMapping("/auction/bidding/{auctionId}")
	public ModelAndView handleRequest(@PathVariable String auctionId, @ModelAttribute("userSession") UserSession userSession, 
			@RequestParam int bidPrice) {
		Bid bid = new Bid();
		bid.setAuctionId(auctionId);
		bid.setBidPrice(bidPrice);
		bid.setUserId(userSession.getAccount().getUserId());
		mnmStore.insertBidding(bid);
		mnmStore.updateCurrentPrice(auctionId, bidPrice);
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		List<Bid> bids = mnmStore.getBids(auctionId);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thyme/AuctionItemView");
		mav.addObject("auctionItem", auctionItem);
		mav.addObject("bids", bids);
		return mav;
	}
	
	@RequestMapping("/auction/bidding/{auctionId}/immd")
	public ModelAndView handleRequest2(@PathVariable String auctionId, @ModelAttribute("userSession") UserSession userSession, @RequestParam int immdPurchasePrice) {
		mnmStore.updateImmediatePurchase(auctionId, immdPurchasePrice, userSession.getAccount().getUserId());
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thyme/AuctionItemView");
		mav.addObject("auctionItem", auctionItem);
		return mav;
	}

}
