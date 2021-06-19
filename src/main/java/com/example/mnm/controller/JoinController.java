package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.service.MnmStoreFacade;
import com.example.mnm.validator.MemberRegisterValidator;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("join")
public class JoinController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String formViewName = "JoinForm";

	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	@ModelAttribute("account")
	protected Object joinformBackingObject() throws Exception {
		logger.info("joinformBackingObject()");
		return new Account();
	}
	
	// 회원가입 폼으로 이동
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView joinForm() {
		logger.info("joinForm()");
		ModelAndView mav = new ModelAndView();
		// 카테고리 목록 가져오기
		List<Category> categoryList = store.getCategoryList();
		mav.setViewName("JoinForm");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		logger.info("mav: " + JSONArray.fromObject(categoryList));
		return mav;
	}

	// 계정 추가 실행
	@RequestMapping(method=RequestMethod.POST)
    public String insertAccount(@ModelAttribute("account") Account account, BindingResult result, HttpServletRequest request, Model model) {
		
		logger.info("insertAccount()");
		new MemberRegisterValidator().validate(account, result);
		model.addAttribute("account", account);
		
		if(result.hasErrors()) {
			List<Category> categoryList = store.getCategoryList();
			model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
            return formViewName;
		}
		else {
			account.setEmail(account.getEmail() + account.getEmailDomain());
			account.setPhone(account.getPhone() + "-" +account.getPhone2() + "-" + account.getPhone3());
			account.setFavcategory(request.getParameter("category1"));
			account.setKakao("n");
			
			logger.info("userid:" + account.getUserid());
			logger.info("name:" + account.getName());
			logger.info("addr:" + account.getAddr());
			logger.info("pwd:" + account.getPwd());
			logger.info("kakao:" + account.getKakao());
			logger.info("email:" + account.getEmail());
			logger.info("phone:" + account.getPhone());
			logger.info("favcategory:" + account.getFavcategory());
		}
		
		store.insertAccount(account);
		return "redirect:/login";
    }
}
