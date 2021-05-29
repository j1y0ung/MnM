package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/sellerPage/addItem")
public class AddPersonalDealItemController{
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@ModelAttribute("personalDealItem")
	public PersonalDealItem formBacking() {
		return new PersonalDealItem();
	}

	@GetMapping
	public String form() {
		return "thyme/RegistPersonalDealItemForm";
	}
	
	@PostMapping("")
	protected ModelAndView addPersonalDealItem(
			@ModelAttribute("personalDealItem") PersonalDealItem personalDealItem 
			) {
		System.out.println(personalDealItem.toString());
		this.mnmStore.addPersonalDealItem(personalDealItem);
		ModelAndView mav = new ModelAndView("RegistPersonalDealItemForm");
		return mav;
	}

}
