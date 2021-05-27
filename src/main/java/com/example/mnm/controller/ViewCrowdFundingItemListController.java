package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewCrowdFundingItemListController {
	@Autowired private MnmStoreFacade storeFacade;

	@RequestMapping("/crowdFunding/list")
	public String handleRequest(
//			HttpServletRequest request,
//			@RequestParam(value="page", required=false) String page,
			ModelMap model) throws Exception {
		
		// 크라우드펀딩 목록 
		List<CrowdFundingItem> crowdlist = this.storeFacade.getCrowdFundingItemList();
		PagedListHolder<CrowdFundingItem> pagedList = new PagedListHolder<CrowdFundingItem>(crowdlist);
		pagedList.setPageSize(10);
//		if(page == null) { pagedList.setPage(1); }
//		request.getSession().setAttribute("crowdFundingItemList", pagedList);
//
//		if ("next".equals(page)) {
//			pagedList.nextPage();
//		}
//		else if ("previous".equals(page)) {
//			pagedList.previousPage();
//		}
		
		model.put("crowdFundingItemList", pagedList);
		
		// 카테고리
		List<Category> catlist = this.storeFacade.getCategoryList();
		model.put("categories", catlist);
		
		// 정렬 순 
		String[] sorts = {"인기순", "최신순", "최다후원순", "최다 금액순", "마감임박순"};
		model.put("sorts", sorts);
		return "thyme/crowdFundingListView";
	}
}
