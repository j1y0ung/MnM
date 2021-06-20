package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/item")
public class ViewCrowdFundingItemController {
	@Autowired private MnmStoreFacade storeFacade;

	@GetMapping("/{crowdFundingId}")
	public String handleRequest(
			@PathVariable("crowdFundingId") String crowdFundingId
			, ModelMap model) throws Exception {

		System.out.println("컨트롤러 입");
		CrowdFundingItem item = this.storeFacade.getFundingItemById(crowdFundingId);
		model.put("crowdFundingItem", item);

		return "thyme/crowdFundingView";
	}

	
}
