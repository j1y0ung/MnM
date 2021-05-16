package com.example.mnm.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.mnm.domain.Item;
import com.example.mnm.domain.Product;
import com.example.mnm.service.MnmStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes({"category", "productList"})
public class ViewProductController { 

	private MnmStoreFacade mnmStore;

	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@RequestMapping("/shop/viewProduct.do")
	public String handleRequest(
			@RequestParam("productId") String productId,
			ModelMap model) throws Exception {
		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.mnmStore.getItemListByProduct(productId));
		itemList.setPageSize(4);
		Product product = this.mnmStore.getProduct(productId);
		model.put("itemList", itemList);
		model.put("product", product);
		return "Product";
	}
	
	@RequestMapping("/shop/viewProduct2.do")
	public String handleRequest2(
			@ModelAttribute("product") Product product,
			@ModelAttribute("itemList") PagedListHolder<Item> itemList,
			@RequestParam("pageName") String page, 
			ModelMap model) throws Exception {
		if ("next".equals(page)) {
			itemList.nextPage();
		}
		else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		model.put("itemList", itemList);
		model.put("product", product);
		return "Product";
	}
}
