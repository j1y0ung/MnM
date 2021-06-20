package com.example.mnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Bid;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewAuctionItemController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/auction/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model, @SessionAttribute(required = false) Account account,
			@RequestParam(required = false, defaultValue = "false") boolean alreadyAdded, 
			@RequestParam(required = false, defaultValue = "false") boolean lowBidPrice) {

		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		
		// 조회수 증가
		mnmStore.increaseItemViews(auctionItem.getItemId());
		// 입찰 내역 목록
		List<Bid> bids = mnmStore.getBids(auctionId);
		
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		
		// 세션에 저장한 account 가 존재할 경우
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		model.addAttribute("auctionItem", auctionItem);
		model.addAttribute("bids", bids);
		model.addAttribute("parentCatId", mnmStore.getCategoryName(Integer.toString(auctionItem.getItem().getParentCatId())));
		model.addAttribute("childCatId", mnmStore.getCategoryName(Integer.toString(auctionItem.getItem().getChildCatId())));
		
		// 장바구니 목록에 해당 물품이 이미 추가된 경우
		if (alreadyAdded) {
			model.addAttribute("alreadyAdded", alreadyAdded);
		}
		// 입찰시 현재가보다 입찰가가 낮을 경우
		if (lowBidPrice) {
			model.addAttribute("lowBidPrice", lowBidPrice);
		}
		
		return "thyme/AuctionItemView";
	}

}
