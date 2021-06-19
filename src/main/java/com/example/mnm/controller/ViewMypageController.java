package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("mypage")
public class ViewMypageController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String viewName = "thyme/MypageView";
	
	// 마이페이지로 이동
	@RequestMapping(method=RequestMethod.GET)
	public String goMypage() {
		logger.info("goMypage()");
		return viewName;
	}

}
