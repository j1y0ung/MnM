package com.example.mnm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.CrowdFundingItem;
import com.example.mnm.domain.FundingForm;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/crowdFunding/fund")
public class FundController {
	@Autowired private MnmStoreFacade storeFacade;

//	@ModelAttribute("fundForm")
//	public FundForm createFundForm() {
//		return new FundForm();
//	}

	@GetMapping("/{crowdFundingId}")
	protected String fund(
			@PathVariable("crowdFundingId") String crowdFundingId,
			ModelMap model) {
		FundingForm fundingForm = new FundingForm();
		CrowdFundingItem temp = this.storeFacade.getFundingItemById(crowdFundingId);
		fundingForm.setCrowdFundingItem(temp);
		fundingForm.getCrowdFundingItem().setItem(temp.getItem());
		fundingForm.getCrowdFundingItem().setCrowdFundingId(Integer.parseInt(crowdFundingId));
		System.out.println(this.storeFacade.getFundingItemById(crowdFundingId));
		model.put("fundingForm", fundingForm);
		
		return "ViewOrderFunding";
	}
	
	@PostMapping("")
	public String fundExecute(
			@ModelAttribute(value="fundingForm") FundingForm fundingForm
			, ModelMap model) throws Exception {
		fundingForm.getOrders().setUserId("1");
		System.out.println(fundingForm.getCrowdFundingItem().getItem().getItemId());
		System.out.println(fundingForm.getCrowdFundingItem().getCrowdFundingId());
		this.storeFacade.fund(fundingForm);

		return "orderCompleteView";
	}
}
