package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("myaccount")
public class ViewAccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String viewName = "MyAccountInfoView";

	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	@ModelAttribute("account")
	protected Object accountformBackingObject() throws Exception {
		logger.info("joinformBackingObject()");
		return new Account();
	}
	
	// 내 정보 페이지로 이동
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView goMyaccountInfo(Model model, HttpSession session) {
		logger.info("goMyaccountInfo()");
		Account account = (Account) session.getAttribute("account");
		model.addAttribute("account", account);
		
		// 카테고리 목록 가져오기
		ModelAndView mav = new ModelAndView();
		List<Category> categoryList = store.getCategoryList();
		mav.setViewName(viewName);
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		logger.info("mav: " + JSONArray.fromObject(categoryList));
		return mav;
	}
	
}
