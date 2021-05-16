package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateCrowdFundingItemController {
	@RequestMapping("/crowdFunding/updateItem.do")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@RequestParam("itemId") String itemId,
			@ModelAttribute("crowdFunding") CrowdFunding crowdFunding) throws Exception {
		CrowdFundingItem crowdFundingItem = this.store.getItem(itemId);
		String itemId = crowdFundingItem.getItem().getItemId();
		crowdFunding.updateItemById(itemId, item);
		
		return new ModelAndView("CrowdFunding", "crowdFunding", crowdFunding);
	}
}
