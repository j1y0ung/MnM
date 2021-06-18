package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/add")
public class AddCrowdFundingItemController {
	
	@Autowired private MnmStoreFacade storeFacade;

//	@ModelAttribute("addCrowdFundingItemForm")
//	public CrowdFundingItemForm createCrowdFundingItemForm() {
//		return new CrowdFundingItemForm();
//	}
	
	@GetMapping("")
	protected String form(ModelMap model, HttpSession session) {
		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			return "redirect:/crowdFunding/list";
		} else {
			model.put("session", account);
		}
		
		List<Category> catlist = this.storeFacade.getCategoryList();
		model.put("categories", catlist);
		
		model.put("crowdFundingItem", new CrowdFundingItem(new Item()));
		
		return "thyme/crowdFundingForm";
	}

	@PostMapping("")
	protected ModelAndView addCrowdFundingItem(
			@ModelAttribute("crowdFundingItem") CrowdFundingItem crowdFundingItem 
//			, SessionStatus status
			) {
		System.out.println(crowdFundingItem.toString());
		this.storeFacade.addFundingItem(crowdFundingItem);
		ModelAndView mav = new ModelAndView("thyme/crowdFundingRegistration");
//		mav.addObject("crowdFundingItem", crowdFundingItemForm.addItem());
//		status.setComplete();
		return mav;
	}

}
