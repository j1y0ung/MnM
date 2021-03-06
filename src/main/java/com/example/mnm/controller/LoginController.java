package com.example.mnm.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Login;
import com.example.mnm.service.MnmStoreFacade;
import com.example.mnm.validator.LoginValidator;

@Controller
@RequestMapping("login")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String formViewName = "LoginForm";
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 로그인 폼으로 이동
	@RequestMapping(method=RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm()");
		return formViewName;
	}
	
	@ModelAttribute
	protected Object loginformBackingObject() throws Exception {
		logger.info("loginformBackingObject()");
		return new Login();
	}
	
	// 로그인 실행
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(HttpSession session, @ModelAttribute("login") Login login, BindingResult result, 
			@RequestParam(value="forwardAction", required=false) String forwardAction, Model model) {
		logger.info("submit()");
		String inputUserId = login.getUserId();
		String inputPwd = login.getPwd();
		LoginValidator val = new LoginValidator();
		val.validate(login, result);
		
		if(store.getAccount(inputUserId) == null) {
			val.checkAccount(login, result);
		}
		else if(!store.getAccount(inputUserId).getPwd().equals(inputPwd)) {
			val.checkPwd(login, result);
		}
		
		if(result.hasErrors()) {
			return new ModelAndView("LoginForm");
		}
		
		if (session.getAttribute("userid") != null ){
			session.removeAttribute("account");
		}
		else {
        	Account account = store.getAccount(inputUserId);
        	
        	if((store.getPwd(inputUserId)).equals(inputPwd)) {
            	logger.info("로그인 성공");
            	account = store.getAccount(inputUserId);
                session.setAttribute("account", account);
                if (forwardAction != null) {
    				return new ModelAndView("redirect:" + forwardAction);
    			}
    			else {
    				return new ModelAndView("redirect:/");
    			}
            } else{
            	logger.info("로그인 실패");
            	return new ModelAndView("LoginForm");
            }
        }
		return new ModelAndView("redirect:/");
	}
	
}
