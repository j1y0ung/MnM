package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String goHome(HttpServletRequest request, Model model) {
		logger.info("[HomeController INFO] goHome()");
		return "thyme/Home";
	}
	
//	@RequestMapping("/personalDealList.go")
//	public String goPersonalDealList(HttpServletRequest request, Model model) {
//		return "thyme/";
//	}
//	
//	@RequestMapping("/auctionList.go")
//	public String goAuctionList(HttpServletRequest request, Model model) {
//		return "thyme/";
//	}
//	@RequestMapping("/crowdFundingList.go")
//	public String goCrowdFundingList(HttpServletRequest request, Model model) {
//		return "thyme/";
//	}
	
}
