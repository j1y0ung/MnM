package com.example.mnm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItemList;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@SessionAttributes("account")
public class ViewAuctionHistoryController {
	private MnmStoreFacade petStore;
	@Autowired
	public void setMnmStore(MnmStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping("/auction/history")
	public String handleRequest(@ModelAttribute("account") Account account, Model model, 
								@RequestParam(required = false, defaultValue = "false") boolean noSecondBid) {
		// 판매한 물품 목록, 세션에 저장한 account의 userId 이용
		List<AuctionItemList> sellingAuctionItemList = petStore.getSellingAuctionItemList(account.getUserid());

		// 입찰한 물품 목록, 세션에 저장한 account의 userId 이용
		List<AuctionItemList> biddingAuctionItemList = petStore.getBiddingAuctionItemList(account.getUserid());

		// 낙찰받은 물품 목록, 세션에 저장한 account의 userId 이용
		List<AuctionItemList> auctionedItemList = petStore.getAuctionedItemList(account.getUserid());

		model.addAttribute("sellingAuctionItemList", sellingAuctionItemList);
		model.addAttribute("biddingAuctionItemList", biddingAuctionItemList);
		model.addAttribute("auctionedItemList", auctionedItemList);
		
		// 후순위 입찰 내역이 없을 경우
		if (noSecondBid) {
			model.addAttribute("noSecondBid", noSecondBid);
		}
		
		return "thyme/AuctionHistory";
	}

}
