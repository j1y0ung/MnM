package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
=======
>>>>>>> develop
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
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
=======
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
		bid.setUserId(userSession.getAccount().getUsername());
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
		mnmStore.updateImmediatePurchase(auctionId, immdPurchasePrice, userSession.getAccount().getUsername());
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("thyme/AuctionItemView");
		mav.addObject("auctionItem", auctionItem);
		return mav;
>>>>>>> develop
	}

}
