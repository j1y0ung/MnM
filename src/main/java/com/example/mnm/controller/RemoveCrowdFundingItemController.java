package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RemoveCrowdFundingItemController {
	@RequestMapping("/crowdFunding/removeItem.do")
	public ModelAndView handleRequest(
			@RequestParam("itemId") String itemId,
			@ModelAttribute("crowdFunding") CrowdFunding crowdFunding
		) throws Exception {
		crowdFunding.removeItemById(itemId);
		return new ModelAndView("CrowdFunding", "crowdFunding", crowdFunding);
	}

}
