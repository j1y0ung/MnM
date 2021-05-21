package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.Item;
import com.example.mnm.service.StoreFacade;

@Controller
public class ViewCrowdFundingItemController {
//	@Autowired(required=false)
//	private StoreFacade store;

	@RequestMapping("/crowdFunding/item/{itemid}")
	public ModelAndView handleRequest(
		@ModelAttribute("crowdFunding") CrowdFundingItem crowdFundingItem, Model model) throws Exception {
		
		
		return new ModelAndView("crowdFundingView", "crowdFundingItem", new CrowdFundingItem(new Item()));
	}

}
