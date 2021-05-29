package com.example.mnm.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/personalDeal/item/{itemid}")
public class ViewPersonalDealItemController {
	
	@Autowired
	private MnmStoreFacade mnmStore;
	
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@GetMapping("")
	public String handleRequest(
			@RequestParam(value="personalDealId", defaultValue="1") String personalDealId
			, ModelMap model) throws Exception {

		PersonalDealItem item = this.mnmStore.getPersonalDealItemById(personalDealId);
		model.put("personalDealItem", item);

		return "thyme/PersonalDealItemView";
	}

}
