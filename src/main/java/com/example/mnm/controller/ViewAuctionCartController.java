package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

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
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		handleRequest(page, cart, userSession);
		return new ModelAndView("thyme/AuctionCart", "cart", cart);
	}

	@RequestMapping("/auction/checkout.do")
	public ModelAndView checkout(
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@ModelAttribute("sessionCart") AuctionCart cart) 
			throws Exception {
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		handleRequest(page, cart, userSession);
		return new ModelAndView("thyme/AuctionCheckout", "cart", cart);
	}
	
	private void handleRequest(String page, AuctionCart cart, UserSession userSession)
			throws Exception {
		if ("nextCart".equals(page)) {
			cart.getCartItemList().nextPage();
		}
		else if ("previousCart".equals(page)) {
			cart.getCartItemList().previousPage();
		}
	}
}
