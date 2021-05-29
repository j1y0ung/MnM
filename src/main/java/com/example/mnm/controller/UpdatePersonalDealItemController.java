package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.Product;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/sellerPage/updateItem/{itemid}")
public class UpdatePersonalDealItemController {

	private MnmStoreFacade storeFacade;
	@Autowired
	public void setmnmStore(MnmStoreFacade storeFacade) {
		this.storeFacade = storeFacade;
	}
	
	@GetMapping("/{personalDealId}")
	public String updateForm(
			HttpServletRequest request
			, @PathVariable("personalDealId") String personalDealId
			, @ModelAttribute("personalDeal") PersonalDealItem personalDeal
			, ModelMap model
			, HttpSession session
			) throws Exception {
		
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/signon";
		} else {
			model.put("session", account);
		}
		
		PersonalDealItem personalDealItem = this.storeFacade.getPersonalDealItemById(personalDealId);
		model.put("personalDealItem", personalDealItem);
		
		List<Category> catlist = this.storeFacade.getCategoryList();
		model.put("categories", catlist);
		
		List<Product> prolist = this.storeFacade.getProductList();
		model.put("products", prolist);
		
		return "UpdatePersonalDealItemForm";
	}

}