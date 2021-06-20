package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("myaccount")
public class MyAccountInfoController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String formViewName = "MyAccountInfoView";

	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	@ModelAttribute("account")
	protected Object myaccountformBackingObject() throws Exception {
		logger.info("myaccountformBackingObject()");
		return new Account();
	}
	
	// 내 정보 페이지로 이동
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView goMyaccountInfo(Model model, HttpSession session) {
		logger.info("goMyaccountInfo()");
		Account account = (Account) session.getAttribute("account");
		String userid = account.getUserid();
		Account curAccount = store.getAccount(userid);
		System.out.println("");
		model.addAttribute("account", curAccount);
		
		// 카테고리 목록 가져오기
		ModelAndView mav = new ModelAndView();
		List<Category> categoryList = store.getCategoryList();
		mav.setViewName(formViewName);
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		logger.info("mav: " + JSONArray.fromObject(categoryList));
		return mav;
	}
	
	// 내 정보 수정
	@RequestMapping(method=RequestMethod.POST)
    public String updateAccount(@ModelAttribute("account") Account account, HttpSession session, BindingResult result, HttpServletRequest request, Model model) throws Exception {
		logger.info("updateAccount()");
		Account ac = (Account) session.getAttribute("account");
		account.setUserid(ac.getUserid());
		String fav = request.getParameter("category1");
		account.setFavcategory(fav);
		logger.info("userid:" + account.getUserid());
		logger.info("pwd:" + account.getPwd());
		logger.info("email:" + account.getEmail());
		logger.info("phone:" + account.getPhone());
		logger.info("addr:" + account.getAddr());
		logger.info("favcategory:" + account.getFavcategory());
		
        store.updateAccount(account);
        return "redirect:/";
    }
	
}
