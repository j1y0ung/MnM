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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/crowdFunding/add")
public class AddCrowdFundingItemController {

	@Autowired private MnmStoreFacade storeFacade;

	//	@ModelAttribute("addCrowdFundingItemForm")
	//	public CrowdFundingItemForm createCrowdFundingItemForm() {
	//		return new CrowdFundingItemForm();
	//	}

	@GetMapping("")
	protected ModelAndView form(ModelMap model, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		Account account = (Account) session.getAttribute("account");
		
		if(account == null) {
			mav.setViewName("crowdFundingListView");
			
		} else {
			
			mav.setViewName("crowdFundingForm");
			model.put("crowdFundingItem", new CrowdFundingItem(new Item()));

			// 카테고리
			List<Category> categoryList = storeFacade.getCategoryList();
			mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		}
		
		return mav;
	}

	@PostMapping("")
	protected ModelAndView addCrowdFundingItem(
			@ModelAttribute("crowdFundingItem") CrowdFundingItem crowdFundingItem
			, HttpSession session
			, MultipartHttpServletRequest request
			//			, SessionStatus status
			) {
		System.out.println(crowdFundingItem.toString());
		
		crowdFundingItem.getItem().getAccount().setUserid(((Account) session.getAttribute("account")).getUserid());
		// 카테고리
		crowdFundingItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));
		System.out.println(request.getParameter("category1"));
		crowdFundingItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));
		System.out.println(request.getParameter("category2"));
		
		this.storeFacade.addFundingItem(crowdFundingItem);
		ModelAndView mav = new ModelAndView("thyme/crowdFundingRegistration");
		
		return mav;
	}

}
