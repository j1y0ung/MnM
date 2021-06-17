package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/update")
public class UpdateCrowdFundingItemController {
	@Autowired private MnmStoreFacade storeFacade;
	
	@GetMapping("/{crowdFundingId}")
	public String updateForm(
			HttpServletRequest request
			, @PathVariable("crowdFundingId") String crowdFundingId
			, @ModelAttribute("crowdFunding") CrowdFundingItem crowdFunding
			, ModelMap model
			, HttpSession session
			) throws Exception {
		
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/signon";
		} else {
			model.put("session", account);
		}
//		model.put("session", new Account());
		
		CrowdFundingItem crowdFundingItem = this.storeFacade.getFundingItemById(crowdFundingId);
//		System.out.println(crowdFundingItem.toString());
		model.put("crowdFundingItem", crowdFundingItem);
		
		List<Category> catlist = this.storeFacade.getCategoryList();
		model.put("categories", catlist);
		
//		List<Product> prolist = this.storeFacade.getProductList();
//		model.put("products", prolist);
		
		return "thyme/CrowdFundingUpdateForm";
	}
	
	@PostMapping("")
	public String updateExecute(
			HttpServletRequest request
			, @ModelAttribute("crowdFundingItem") CrowdFundingItem crowdFundingItem
			, ModelMap model
			) throws Exception {
		
//		System.out.println(crowdFundingItem.toString());
//		System.out.println(crowdFundingItem.getItem().toString());
		this.storeFacade.updateFundingItemById(Integer.toString(crowdFundingItem.getCrowdFundingId()), crowdFundingItem);
		
		
		return "redirect:/crowdFunding/myList";
	}
}
