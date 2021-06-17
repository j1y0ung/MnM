//package com.example.mnm.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.example.mnm.domain.Item;
//import com.example.mnm.service.MnmStoreFacade;
//
///**
// * @author Juergen Hoeller
// * @since 30.11.2003
// * @modified-by Changsup Park
// */
//@Controller
//public class ViewItemController { 
//
//	private MnmStoreFacade mnmStore;
//
//	@Autowired
//	public void setMnmStore(MnmStoreFacade mnmStore) {
//		this.mnmStore = mnmStore;
//	}
//
//	@RequestMapping("/shop/viewItem.do")
//	public String handleRequest(
//			@RequestParam("itemId") String itemId,
//			ModelMap model) throws Exception {
//		Item item = this.mnmStore.getItem(itemId);
//		model.put("item", item);
//		model.put("product", item.getProduct());
//		return "Item";
//	}
//
//}
