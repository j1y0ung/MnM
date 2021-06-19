package com.example.mnm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Orders;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/auction/order")
@SessionAttributes("account")
public class AuctionOrderController {
	private AuctionItem auctionItem;
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@ModelAttribute("orders")
	public Orders formBacking() {
		return new Orders();
	}
	
	@GetMapping
	public String form(@RequestParam String auctionId, Model model) {
		auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		
		model.addAttribute("auctionItem", auctionItem);
		return "thyme/AuctionOrderForm";
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("orders") Orders orders, BindingResult result, 
			@RequestParam String auctionId, @RequestParam int winningBidPrice,
			@ModelAttribute("account") Account account, Model model) throws Exception {

		if (result.hasErrors()) {
			model.addAttribute("auctionItem", auctionItem);
			return "thyme/AuctionOrderForm";
		}
		orders.setUserId(account.getUserid());
		orders.setTotalPrice(winningBidPrice);
		orders.addAuctionLineItem(auctionItem);
		
		mnmStore.insertOrders(orders);
		
		orders.getLineItems().get(0).setOrderId(orders.getOrderId());
		
		mnmStore.insertLineItem(orders.getLineItems());
		mnmStore.updateStatus("결제완료", auctionId);

		return "thyme/orderCompleteView";
	}
}
