package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.example.mnm.service.MnmStoreFacade;
import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItemList;
@Controller
public class ViewAuctionItemListController {
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	// 신규 경매순
	@RequestMapping("/auction/recently")
	public String sortByLatest(Model model, @SessionAttribute(required = false) Account account) {
		List<AuctionItemList> auctionItems = mnmStore.getRecentAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		return "thyme/AuctionItemListView";
	}
	// 조회순
	@RequestMapping("/auction/mostViews")
	public String sortByViews(Model model, @SessionAttribute(required = false) Account account) {
		List<AuctionItemList> auctionItems = mnmStore.getPopularAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		return "thyme/AuctionItemListView";
	}
	// 입찰순
	@RequestMapping("/auction/mostBids")
	public String sortByBids(Model model, @SessionAttribute(required = false) Account account) {
		List<AuctionItemList> auctionItems = mnmStore.getMostBiddingAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		return "thyme/AuctionItemListView";
	}
	// 마감 임박순
	@RequestMapping("/auction/deadline")
	public String sortByDeadline(Model model, @SessionAttribute(required = false) Account account) {
		List<AuctionItemList> auctionItems = mnmStore.getClosingAuctionItemList();
		model.addAttribute("auctionItems", auctionItems);
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		return "thyme/AuctionItemListView";
	}	
	// 검색
	@RequestMapping("/auction/search")
	public String search(@RequestParam String word, Model model, @SessionAttribute(required = false) Account account) {
		List<AuctionItemList> auctionItems = mnmStore.searchAuctionItemList(word);
		model.addAttribute("auctionItems", auctionItems);
		if (account != null) {
			model.addAttribute("username", account.getUserid());
		}
		return "thyme/AuctionItemListView";
	}
}