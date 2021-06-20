package com.example.mnm.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.service.MnmStoreFacade;
import com.example.mnm.domain.PersonalDealItem;

@Controller
public class ViewPersonalDealItemListController {
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	//검색
	@RequestMapping("/personalDeal/search")
	public String search(@RequestParam String word, Model model) {
		List<PersonalDealItem> personalDealItems = mnmStore.searchPersonalDealItemList(word);
		model.addAttribute("personalDealItems", personalDealItems);
		return "thyme/PersonalDealItemListView";
	}
	
	//최신순
	@RequestMapping("/personalDeal/newest")
	public String sortByNewest(Model model) {
		List<PersonalDealItem> personalDealItems = mnmStore.getNewestPersonalDealItemList();
		model.addAttribute("personalDealItems", personalDealItems);
		return "thyme/PersonalDealItemListView";
	}
	
	//조회순
	@RequestMapping("/personalDeal/mostViews")
	public String sortByViews(Model model) {
		List<PersonalDealItem> personalDealItems = mnmStore.getPopularPersonalDealItemList();
		model.addAttribute("personalDealItems", personalDealItems);
		return "thyme/PersonalDealItemListView";
	}	
	
	//최저가순
	@RequestMapping("/personalDeal/lowestPrice")
	public String sortByLowestPrice(Model model) {
		List<PersonalDealItem> personalDealItems = mnmStore.getLowestPricePersonalDealItemList();
		model.addAttribute("personalDealItems", personalDealItems);
		return "thyme/PersonalDealItemListView";
	}	
	
	//최고가순
	@RequestMapping("/personalDeal/hightestPrice")
	public String sortByHightestPrice(Model model) {
		List<PersonalDealItem> personalDealItems = mnmStore.getHightestPricePersonalDealItemList();
		model.addAttribute("personalDealItems", personalDealItems);
		return "thyme/PersonalDealItemListView";
	}	
	

}
