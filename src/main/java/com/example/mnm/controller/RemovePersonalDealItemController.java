package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/sellerPage/removeItem")
public class RemovePersonalDealItemController {
	
	private MnmStoreFacade mnmStore;
	
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@GetMapping("/{itemId}")
	public String updateExecute(
			HttpServletRequest request
			, @PathVariable("itemId") String itemId
			, ModelMap model
			) throws Exception {
		
		System.out.println(itemId);
		
		this.mnmStore.removePersonalDealItemById(itemId);
		
		return "redirect:/sellerPage";
	}
}
