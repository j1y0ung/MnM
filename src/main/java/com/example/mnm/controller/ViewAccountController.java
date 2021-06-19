package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Login;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("myaccount")
public class ViewAccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String viewName = "thyme/MyAccountInfoView";
	
	// 내 정보 페이지로 이동
	@RequestMapping(method=RequestMethod.GET)
	public String goMyaccountInfo() {
		logger.info("goMyaccountInfo()");
		return viewName;
	}
	
}
