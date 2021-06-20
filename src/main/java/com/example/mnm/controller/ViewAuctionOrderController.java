package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Orders;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewAuctionOrderController {

	private MnmStoreFacade mnmStore;

	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@RequestMapping("/auction/viewOrder.do")
	public String handleRequest(@RequestParam("itemId") int itemId, @RequestParam("auctionId") String auctionId, Model model) throws Exception {
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		
		int orderId = mnmStore.getOrderId(itemId);
		Orders orders = mnmStore.getAuctionOrder(orderId);
		
		model.addAttribute("auctionItem", auctionItem);
		model.addAttribute("orders", orders);
		
		return "thyme/AuctionOrderView";
	}
}
