package com.example.mnm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonalDealFormController {
	
//	판매자 페이지
	@RequestMapping("/sellerPage")
	public String viewSellerPageHandler(Model model){ 
		
		return "sellerPageView";
	}
	
//	판매 물품 등록
	@RequestMapping("/sellerPage/addItem")
	public String personalDealItemFormHandler(Model model) {
		
		return "personalDealItemForm";
	}
	
//	판매 물품 등록 완료
	@RequestMapping("/sellerPage/addItem/complete")
	public String addPersonalDealItemHandler(Model model) {
		
		return "myAccountView";
	}
	
//	판매 물품 정보 수정
	@RequestMapping("/sellerPage/updateItem/{itemid}")
	public String updatePersonalDealItemHandler(Model model) {
		
		return "personalDealItemView";
	}
	
//	등록한 물품 삭제
	@RequestMapping("/sellerPage/removeItem/{itemid}")
	public String removePersonalDealItemHandler(Model model) {
		
		return "myPersonalDealItemListView";
	}
	
//	마이페이지
	@RequestMapping("/myAccount")
	public String ViewMyAccountHandler(Model model) {
		
		return "myAccountView";
	}
	
//	프로필수정
	@RequestMapping("/myAccount/update/{updateproperty}")
	public String updateMyAccountHandler(Model model) {
		
		return "myAccountView";
	}
	
//	개인간 거래 목록 보기
	@RequestMapping("/personalDeal")
	public String viewPersonalDealListHandler(Model model){ 
		
		return "personalDealItemListView";
	}
	
//	물품 상세 정보 보기
	@RequestMapping("/personalDeal/item/{itemid}")
	public String viewPersonalDealHandler(Model model){ 
		
		return "personalDealItemView";
	}
	
//	물건 주문
	@RequestMapping("/personalDeal/order/{itemid}")
	public String orderFormHandler(Model model) {
		
		return "personalDealItemOrderForm";
	}
	
//	결제 완료
	@RequestMapping("/personalDeal/order/submitted")
	public String addNewOrderHandler(Model model) {
		
		return "orderCompleteView";
	}
	
	
}
