package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("/myaccount/update")
public class UpdateMyAccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 내 정보 수정
	@RequestMapping(method=RequestMethod.POST)
    public String updateAccount(Account account, BindingResult result,
            RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("updateAccount()");
		logger.info("userid:" + account.getUserid());
		logger.info("email:" + account.getEmail());
		logger.info("name:" + account.getName());
		logger.info("addr:" + account.getAddr());
		logger.info("phone:" + account.getPhone());
		logger.info("favcategory:" + account.getFavcategory());
		logger.info("pwd:" + account.getPwd());
		logger.info("kakao:" + account.getKakao());
		
        store.updateAccount(account);
        return "redirect:/";
    }

}
