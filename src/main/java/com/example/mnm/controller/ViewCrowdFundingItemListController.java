package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewCrowdFundingItemListController {
	@Autowired private MnmStoreFacade storeFacade;

	@RequestMapping("/crowdFunding/list")
	public ModelAndView handleRequest() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemList();
		mav.addObject("crowdFundingItemList", crowdlist);
		System.out.println(crowdlist.toString());

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;

	}

	@RequestMapping("/crowdFunding/recently")
	public ModelAndView fundingListRecently() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListRecently();
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;
	}

	@RequestMapping("/crowdFunding/mostViews")
	public ModelAndView fundingListmostViews() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListMostViews();
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;
	}

	@RequestMapping("/crowdFunding/mostSponsors")
	public ModelAndView fundingListmostSponsors() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListMostSponsors();
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;
	}

	@RequestMapping("/crowdFunding/mostAmount")
	public ModelAndView fundingListmostAmount() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListMostAmount();
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;
	}

	@RequestMapping("/crowdFunding/deadline")
	public ModelAndView fundingListdeadline() throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListDeadLine();
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		
		mav.addObject("categoryCommand", new Category());
		
		return mav;
	}
	
	@RequestMapping("/crowdFunding/category")
	public ModelAndView fundingListCategory(@ModelAttribute Category category) throws Exception {

		ModelAndView mav = new ModelAndView();

		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemListCategory(category);
		mav.addObject("crowdFundingItemList", crowdlist);

		// 카테고리
		List<Category> categoryList = storeFacade.getCategoryList();
		mav.setViewName("crowdFundingListView");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		return mav;
	}
}

