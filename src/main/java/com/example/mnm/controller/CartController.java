package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.service.MnmStoreFacade;

@Controller
public class CartController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	@RequestMapping("/cart")
	public String goCart(HttpServletRequest request, HttpSession session, ModelMap model) throws Exception {
		logger.info("goCart()");
		return "thyme/Cart";
	}

}
