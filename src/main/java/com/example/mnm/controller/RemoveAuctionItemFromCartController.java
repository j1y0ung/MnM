package com.example.mnm.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.AuctionCart;

@Controller
@SessionAttributes("sessionCart")
public class RemoveAuctionItemFromCartController { 

	@RequestMapping("/auction/removeItemFromCart.do")
	public ModelAndView handleRequest(
			@RequestParam("auctionId") String workingItemId,
			@ModelAttribute("sessionCart") AuctionCart cart
		) throws Exception {
		cart.removeItemById(workingItemId);
		return new ModelAndView("thyme/AuctionCart", "cart", cart);
	}
}
