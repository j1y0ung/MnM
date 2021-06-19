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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/crowdFunding/update")
public class UpdateCrowdFundingItemController {
	@Autowired private MnmStoreFacade storeFacade;

	@GetMapping("/{crowdFundingId}")
	public ModelAndView updateForm(
			HttpServletRequest request
			, @PathVariable("crowdFundingId") String crowdFundingId
			, ModelMap model
			, HttpSession session
			) throws Exception {

		ModelAndView mav = new ModelAndView();

		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			mav.setViewName("thyme/crowdFunding/myList");
		} else {
			mav.setViewName("crowdFundingUpdateForm");

			CrowdFundingItem crowdFundingItem = this.storeFacade.getFundingItemById(crowdFundingId);
			model.put("crowdFundingItem", crowdFundingItem);

			// 카테고리
			List<Category> categoryList = storeFacade.getCategoryList();
			mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		}
		return mav;
	}

	@PostMapping("")
	public String updateExecute(
			@ModelAttribute("crowdFundingItem") CrowdFundingItem crowdFundingItem
			, HttpSession session
			, MultipartHttpServletRequest request
			) throws Exception {

		System.out.println(crowdFundingItem.toString());
		System.out.println(crowdFundingItem.getItem().toString());
		System.out.println(crowdFundingItem.getItem().getAccount().toString());

		crowdFundingItem.getItem().getAccount().setUserid(((Account) session.getAttribute("account")).getUserid());
		
		// 카테고리
		System.out.println(request.getParameter("category1"));
		crowdFundingItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));

		crowdFundingItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));
		System.out.println(request.getParameter("category2"));

		this.storeFacade.updateFundingItemById(Integer.toString(crowdFundingItem.getCrowdFundingId()), crowdFundingItem);

		return "redirect:/crowdFunding/myList";
	}

}
