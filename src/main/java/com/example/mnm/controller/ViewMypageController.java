package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewMypageController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String viewName = "MypageView";
	
	// 마이페이지로 이동
	@RequestMapping("mypage")
	public String goMypage() {
		logger.info("goMypage()");
		return viewName;
	}
}