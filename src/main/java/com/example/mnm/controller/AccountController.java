package com.example.mnm.controller;

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
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 회원가입 폼으로 이동
	@RequestMapping("/joinForm")
	private ModelAndView goJoinForm(@ModelAttribute Account account,
			HttpServletRequest request) throws Exception {
		return new ModelAndView("joinForm");
	}
	
	// 계정 추가 실행
	@RequestMapping("/join")
    private ModelAndView insertAccount(@Valid Account account, BindingResult result,
            RedirectAttributes redirect, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("<joinForm 입력값>");
        System.out.println("id: " + account.getId());
        System.out.println("pwd: " + account.getPwd());
        System.out.println("name: " + account.getName());
        System.out.println("email: " + account.getEmail());
        System.out.println("phone: " + account.getPhone());
        System.out.println("address: " + account.getAddress());
        System.out.println("favCategory: " + account.getFavCategory());
        System.out.println("-------------------------------------");
        store.insertAccount(account);
        
        return new ModelAndView("home");
    }
	
	// 로그인 폼으로 이동
	@RequestMapping("/loginForm")
	private ModelAndView goLoginForm(@ModelAttribute Account account,
			HttpServletRequest request) throws Exception {
		return new ModelAndView("loginForm");
	}
	
	// 로그인 실행
	@RequestMapping(value="/login")
    public String login(HttpSession session,
                             @RequestParam(value="id") String id, 
                             @RequestParam(value="pwd") String pwd) {
		Account account = null;                            
        if((store.getPwd(id)).equals(pwd)) {
        	account = store.getAccount(id);
            session.setAttribute("loginCheck", true);
            session.setAttribute("id", id);
            session.setAttribute("account", account);
            System.out.println("로그인 성공");
            return "home";
        } else{
        	System.out.println("로그인 실패");
        	// 실패 오류 띄워주는거 추가하기
        	return "home";
        }
    }

	// 로그아웃 실행
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) throws Exception {
		// 세션 비활성화
		HttpSession session = request.getSession();
		session.invalidate();

		return "redirect:/home";
	}
	
	// 세션 체크용
//	@RequestMapping("/sessionCheck")
//	private ModelAndView sessionCheck(@ModelAttribute Account account,
//			HttpServletRequest request) throws Exception {
//		HttpSession session = request.getSession();
//		Account curSession = (Account) session.getAttribute("account");
//		System.out.println(curSession.getName());
//		return new ModelAndView("home");
//	}
	
}
