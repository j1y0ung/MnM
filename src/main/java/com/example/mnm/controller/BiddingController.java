package com.example.mnm.controller;

import java.util.Date;

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
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	// 입찰
	@PostMapping("/auction/bidding/{auctionId}")
	public String bid(@PathVariable String auctionId, @ModelAttribute("account") Account account, 
			HttpServletRequest request, RedirectAttributes redirect) throws Exception {
		// 폼에 입력된 입찰가
		int bidPrice = Integer.parseInt(request.getParameter("bidPrice"));
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		
		// 입찰가 < 현재가 => 뷰로 돌아가 alert창 띄움
		if (bidPrice <= auctionItem.getCurrentPrice()) {
			redirect.addAttribute("lowBidPrice", true);
		} else { // 입찰가 > 현재가
			Bid bid = new Bid();
			bid.setAuctionId(auctionId);
			bid.setBidPrice(bidPrice);
			// 세션에 저장된 account의 userId를 가져와 Bid의 userId(입찰자)에 세팅
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
		// 세션에 저장된 account의 userId를 가져와 세팅
		mnmStore.updateImmediatePurchase(auctionId, immdPurchasePrice, account.getUserid());
		
		return "redirect:/auction/" + auctionId;
	}
	// 낙찰포기
	@RequestMapping("/auction/bidding/{auctionId}/giveup")
	public String giveUpWinning(@PathVariable String auctionId, @ModelAttribute("account") Account account) {
		// 세션에 저장된 account의 userId를 가져와 세팅
		mnmStore.updateGiveUpWinning(auctionId, account.getUserid());
		
		return "redirect:/auction/history";
	}
	// 후순위자 낙찰
	@RequestMapping("/auction/bidding/{auctionId}/second")
	public String secondWinning(@PathVariable String auctionId, RedirectAttributes redirect) throws Exception {
		
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		// 2번째로 높은 입찰가를 보유한 입찰 내역
		Bid secondBid = mnmStore.findSecondBid(auctionId, auctionItem.getWinnerId());
		if (secondBid != null) { // 후순위 입찰 내역이 있을 경우
			mnmStore.updateWinner(secondBid.getUserId(), secondBid.getBidPrice(), secondBid.getAuctionId(), new Date());
		} else { // 후순위 입찰 내역이 없을 경우
			redirect.addAttribute("noSecondBid", true);
		}
		
		return "redirect:/auction/history";
	}
	//예외적 재입찰 (재경매)
	@GetMapping("/auction/rebidding/{auctionId}")
	public String rebiddingForm(@PathVariable String auctionId, Model model) {
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
	public String rebiddingSubmit(@PathVariable String auctionId, @Valid @ModelAttribute("auctionItem") AuctionItem auctionItem, 
			BindingResult result, Model model) throws Exception {
		auctionItem.getItem().setImg(image);
		auctionItem.getItem().setItemId(itemId);
		auctionItem.getItem().setParentCatId(parentCatId);
		auctionItem.getItem().setChildCatId(childCatId);
		// AuctionItem 유효성 검사
		if (result.hasErrors()) {
            return "thyme/AuctionRebiddingForm";
        }
		
		mnmStore.updateRebidding(auctionId);
		auctionItem.setCurrentPrice(mnmStore.findWinnerBid(auctionId).getBidPrice());
		mnmStore.updateAuctionItem(auctionItem);
		mnmStore.updateItem(auctionItem.getItem());
		
		// 경매 스케쥴러
		mnmStore.startAuctionScheduler(auctionItem.getStartDate(), auctionItem.getAuctionId());
		mnmStore.endAuctionScheduler(auctionItem.getEndDate(), auctionItem.getAuctionId());
		
		return "redirect:/auction/" + auctionId;
	}
}
