package com.example.mnm.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.domain.Account;
import com.example.mnm.domain.DealForm;
import com.example.mnm.domain.Orders;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/personalDeal/order")
@SessionAttributes("account")
public class PersonalDealOrderController {
	private PersonalDealItem personalDealItem;
	public String pdId;
	@Autowired
	private MnmStoreFacade mnmStore;

	@GetMapping("/{personalDealId}")
	protected String purchase(
			@PathVariable("personalDealId") String personalDealId,
			ModelMap model) {
		
		DealForm dealForm = new DealForm();
		PersonalDealItem temp = this.mnmStore.getPersonalDealItem(personalDealId);
		
		dealForm.setPersonalDealItem(temp);
		dealForm.getPersonalDealItem().setItem(temp.getItem());
		dealForm.getPersonalDealItem().setPersonalDealId(personalDealId);
		System.out.println(this.mnmStore.getPersonalDealItem(personalDealId));
		pdId = personalDealId; System.out.println("*personalDealId = " + pdId);
		model.put("dealForm", dealForm);
		
		return "thyme/PersonalDealOrderForm";
	}
	
	@PostMapping("")
	public String purchaseExecute(
			@ModelAttribute(value="dealForm") DealForm dealForm
			, HttpSession session
			, ModelMap model) throws Exception {
		
		dealForm.getOrders().setUserId(((Account) session.getAttribute("account")).getUserid());
		//System.out.println(dealForm.getPersonalDealItem().getItem().getItemId());
		//System.out.println(dealForm.getPersonalDealItem().getPersonalDealId());
		this.mnmStore.purchase(dealForm);
		this.mnmStore.updatePurchase("판매완료", pdId);

		return "thyme/PersonalDealOrderCompleteView";
	}

}
