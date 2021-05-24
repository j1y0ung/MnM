package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.StoreFacade;

@Controller
@RequestMapping("/crowdFunding/myList")
public class ViewMyCrowdFundingItemListController {
	@Autowired private StoreFacade storeFacade;
	
	@GetMapping("")
	public ModelAndView handleRequest(HttpServletRequest request
			, @ModelAttribute("userId") String userId
			, HttpSession session
			) throws Exception {
		// 테스트 용 : 사용자 id가 1이라고 가정 
		List<CrowdFundingItem> list = storeFacade.getMyFundingItemListByUserId("1");
		// 세션에서 사용자 id 가져와서 사용 
//		List<CrowdFundingItem> list = storeFacade.getMyFundingItemListByUserId();
		return new ModelAndView("crowdFundingRegiHistory", "myCrowdFundingItemList", list);
	}
}
