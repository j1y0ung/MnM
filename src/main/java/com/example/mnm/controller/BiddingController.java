package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Bid;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@SessionAttributes("account")
public class BiddingController {
	private MnmStoreFacade mnmStore;
	private String image;
	private String itemId;
	private int parentCatId;
	private int childCatId; 
	@Autowired
	public void setPetStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	// 입찰
	@PostMapping("/auction/bidding/{auctionId}")
	public String bid(@PathVariable String auctionId, @ModelAttribute("account") Account account, 
			HttpServletRequest request, RedirectAttributes redirect) throws Exception {

		int bidPrice = Integer.parseInt(request.getParameter("bidPrice"));
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		
		if (bidPrice <= auctionItem.getCurrentPrice()) {
			redirect.addAttribute("lowBidPrice", true);
		} else {
			Bid bid = new Bid();
			bid.setAuctionId(auctionId);
			bid.setBidPrice(bidPrice);
			bid.setUserId(account.getUserid());
			
			mnmStore.insertBidding(bid);
			mnmStore.updateCurrentPrice(auctionId, bidPrice);
		}

		return "redirect:/auction/" + auctionId;
	}
	// 즉시구매
	@RequestMapping("/auction/bidding/{auctionId}/immd")
	public String immdPurchase(@PathVariable String auctionId, @ModelAttribute("account") Account account, 
								@RequestParam int immdPurchasePrice) {
		
		mnmStore.updateImmediatePurchase(auctionId, immdPurchasePrice, account.getUserid());
		
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
	public String secondWinning(@PathVariable String auctionId, RedirectAttributes redirect) throws Exception {
		
		Bid firstBid = mnmStore.findWinnerBid(auctionId);
		Bid secondBid = mnmStore.findSecondBid(auctionId, firstBid.getUserId());
		if (secondBid != null) {
			mnmStore.updateWinner(secondBid.getUserId(), secondBid.getBidPrice(), secondBid.getAuctionId());
		} else {
			redirect.addAttribute("noSecondBid", true);
		}
		
		return "redirect:/auction/history";
	}
	//예외적 재입찰 (재경매)
	@GetMapping("/auction/rebidding/{auctionId}")
	public String rebiddingForm(@PathVariable String auctionId, Model model) {
		mnmStore.updateRebidding(auctionId);
		
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));

		image = auctionItem.getItem().getImg();
		itemId = auctionItem.getItem().getItemId();
		parentCatId = auctionItem.getItem().getParentCatId();
		childCatId = auctionItem.getItem().getChildCatId();
		
		model.addAttribute("auctionItem", auctionItem);
		
		return "thyme/AuctionRebiddingForm";
	}
	
	//예외적 재입찰 (재경매)
	@PostMapping("/auction/rebidding/{auctionId}")
	public String rebiddingSubmit(@PathVariable String auctionId, @Valid @ModelAttribute("auctionItem") AuctionItem auctionItem, BindingResult result, Model model) throws Exception {
		auctionItem.getItem().setImg(image);
		auctionItem.getItem().setItemId(itemId);
		auctionItem.getItem().setParentCatId(parentCatId);
		auctionItem.getItem().setChildCatId(childCatId);
		
		if (result.hasErrors()) {
            return "thyme/AuctionRebiddingForm";
        }
		
		mnmStore.updateRebidding(auctionId);
		
		mnmStore.updateAuctionItem(auctionItem);
		mnmStore.updateItem(auctionItem.getItem());
		
		// 경매 스케쥴러
		mnmStore.startAuctionScheduler(auctionItem.getStartDate(), auctionItem.getAuctionId());
		mnmStore.endAuctionScheduler(auctionItem.getEndDate(), auctionItem.getAuctionId());
		
		return "redirect:/auction/" + auctionId;
	}
}
