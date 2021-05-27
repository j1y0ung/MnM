package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/item")
public class ViewCrowdFundingItemController {
	@Autowired private MnmStoreFacade storeFacade;

	@GetMapping("")
	public String handleRequest(
			@RequestParam(value="crowdFundingId", defaultValue="1") String crowdFundingId
			, ModelMap model) throws Exception {

		CrowdFundingItem item = this.storeFacade.getFundingItemById(crowdFundingId);
		model.put("crowdFundingItem", item);

		return "crowdFundingView";
	}

	
}
