package com.example.mnm.controller; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Bid;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewPersonalDealItemController {
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@RequestMapping("/personalDeal/{personalDealId}")
	public String handleRequest(@PathVariable String personalDealId, Model model,
			@RequestParam(required = false, defaultValue = "false") boolean alreadyAdded)  {

		PersonalDealItem personalDealItem = mnmStore.getPersonalDealItem(personalDealId);
		
		mnmStore.increaseItemViews(personalDealItem.getItemId());
		
		personalDealItem.setItem(mnmStore.getItem(personalDealItem.getItemId()));
		
		model.addAttribute("personalDealItem", personalDealItem);
		model.addAttribute("parentCatId", mnmStore.getCategoryName(Integer.toString(personalDealItem.getItem().getParentCatId())));
		model.addAttribute("childCatId", mnmStore.getCategoryName(Integer.toString(personalDealItem.getItem().getChildCatId())));

		return "thyme/PersonalDealItemView";
	}

}
