package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.AuctionCart;
import com.example.mnm.domain.Item;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@SessionAttributes("sessionCart")
public class AddAuctionItemToCartController { 

	private MnmStoreFacade mnmStore;

	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@ModelAttribute("sessionCart")
	public AuctionCart createCart() {
		return new AuctionCart();
	}
	
	@RequestMapping("/auction/addItemToCart.do")
	public String handleRequest(
			@RequestParam("auctionId") String auctionId, @ModelAttribute("sessionCart") AuctionCart cart,
			Model model, RedirectAttributes redirect) throws Exception {
		// 카트에 이미 해당 물품이 들어있는 경우
		if (cart.containsItemId(auctionId)) {
			redirect.addAttribute("alreadyAdded", true);
			return "redirect:/auction/" + auctionId;
		}
		else {
			AuctionItem auctionItem = this.mnmStore.getAuctionItem(auctionId);
			Item item = this.mnmStore.getItem(auctionItem.getItemId());
			auctionItem.setItem(item);
			cart.addItem(auctionItem);
			model.addAttribute("cart", cart);
			return "thyme/AuctionCart";
		}
	}
}