package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.mnm.domain.AuctionCart;

@Controller
@SessionAttributes("sessionCart")
public class ViewAuctionCartController { 
	
	@ModelAttribute("sessionCart")
	public AuctionCart createCart(HttpSession session) {
		AuctionCart cart = (AuctionCart)session.getAttribute("sessionCart");
		if (cart == null) cart = new AuctionCart();
		return cart;
	}
	
	@RequestMapping("/auction/viewCart.do")
	public ModelAndView viewCart(
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@ModelAttribute("sessionCart") AuctionCart cart) 
			throws Exception {
		handleRequest(page, cart);
		return new ModelAndView("thyme/AuctionCart", "cart", cart);
	}
	
	private void handleRequest(String page, AuctionCart cart)
			throws Exception {
		if ("nextCart".equals(page)) {
			cart.getCartItemList().nextPage();
		}
		else if ("previousCart".equals(page)) {
			cart.getCartItemList().previousPage();
		}
	}
}
