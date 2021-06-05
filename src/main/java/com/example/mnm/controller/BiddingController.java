package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	// 입찰
	@PostMapping("/auction/bidding/{auctionId}")
	public String bid(@PathVariable String auctionId, @ModelAttribute("userSession") UserSession userSession, 
			@RequestParam int bidPrice) {
		Bid bid = new Bid();
		bid.setAuctionId(auctionId);
		bid.setBidPrice(bidPrice);
		bid.setUserId(userSession.getAccount().getUserid());
		
		mnmStore.insertBidding(bid);
		mnmStore.updateCurrentPrice(auctionId, bidPrice);

		return "redirect:/auction/" + auctionId;
	}
	// 즉시구매
	@RequestMapping("/auction/bidding/{auctionId}/immd")
	public String immdPurchase(@PathVariable String auctionId, @ModelAttribute("userSession") UserSession userSession, @RequestParam int immdPurchasePrice) {
		
		mnmStore.updateImmediatePurchase(auctionId, immdPurchasePrice, userSession.getAccount().getUserid());
		
		return "redirect:/auction/" + auctionId;
	}
	// 낙찰포기
	@RequestMapping("/auction/bidding/{auctionId}/giveup")
	public String giveUpWinning(@PathVariable String auctionId) {
		
		mnmStore.updateGiveUpWinning(auctionId);
		
		return "redirect:/auction/history";
	}
	// 후순위자 낙찰 
	@RequestMapping("/auction/bidding/{auctionId}/second")
	public String secondWinning(@PathVariable String auctionId, @ModelAttribute("userSession") UserSession userSession) {
		
		Bid firstBid = mnmStore.findWinnerBid(auctionId);
		Bid secondBid = mnmStore.findSecondBid(auctionId, firstBid.getUserId());
		
		mnmStore.updateWinner(secondBid.getUserId(), secondBid.getBidPrice(), secondBid.getAuctionId());
		
		return "redirect:/auction/history";
	}

}
