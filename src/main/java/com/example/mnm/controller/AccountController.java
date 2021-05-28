package com.example.mnm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mnm.domain.Account;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 회원가입 폼으로 이동
	@RequestMapping(value="/joinForm.do")
	public String goJoinForm(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goJoinForm()");
		
		return "thyme/joinForm";
	}
	
	// 계정 추가 실행
	@RequestMapping("/join.do")
    private ModelAndView insertAccount(Account account, BindingResult result,
            RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.info("[AcountController INFO] insertAccount()");
		logger.info("[AcountController INFO] joinForm 입력값");
		logger.info("[AcountController INFO] userid:" + account.getUserid());
		logger.info("[AcountController INFO] email:" + account.getEmail());
		logger.info("[AcountController INFO] name:" + account.getName());
		logger.info("[AcountController INFO] addr:" + account.getAddr());
		logger.info("[AcountController INFO] phone:" + account.getPhone());
		logger.info("[AcountController INFO] favcategory:" + account.getFavcategory());
		logger.info("[AcountController INFO] pwd:" + account.getPwd());
		
        store.insertAccount(account);
        
        return new ModelAndView("thyme/home");
    }
	
	// 로그인 폼으로 이동
	@RequestMapping(value="/loginForm.do")
	public String goLoginForm(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {
		logger.info("[AcountController INFO] goLoginForm()");
		
		return "thyme/loginForm";
	}
	
	// 로그인 실행
	@RequestMapping(value="/login.do")
    public String login(HttpSession session, 
    					@RequestParam(value="userid") String userid, 
                        @RequestParam(value="pwd") String pwd) {
		logger.info("[AcountController INFO] login()");
		
		Account account = null;                            
        if((store.getPwd(userid)).equals(pwd)) {
        	account = store.getAccount(userid);
        	session.setAttribute("userid", userid);
            session.setAttribute("account", account);
            logger.info("[AcountController INFO] 로그인 성공");
            return "thyme/home";
        } else{
        	logger.info("[AcountController INFO] 로그인 실패");
        	// 실패 오류 띄워주는거 추가하기
        	return "thyme/home";
        }
    }

	// 로그아웃 실행
	@RequestMapping(value="/logout.do")
	public String logout(HttpSession session) throws Exception {
		logger.info("[AcountController INFO] logout()");
		
		// 세션 비활성화
		session.removeAttribute("userid");
		session.removeAttribute("account");
		session.invalidate();

		return "thyme/home";
	}
	
	// 세션 체크용
	@RequestMapping("/sessionCheck.do")
	private ModelAndView sessionCheck(@ModelAttribute Account account,
			HttpServletRequest request) throws Exception {
		logger.info("[AcountController INFO] sessionCheck()");
		
		HttpSession session = request.getSession();
		Account curSession = (Account) session.getAttribute("account");
		if (curSession != null) {
			logger.info("[AcountController INFO] get session user name:" + curSession.getName());
		}
		
		return new ModelAndView("home");
	}
	
}
