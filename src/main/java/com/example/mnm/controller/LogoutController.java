package com.example.mnm.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.service.KakaoAPI;

@Controller
public class LogoutController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KakaoAPI kakao;
	
	// 로그아웃 실행
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		logger.info("logout()");
		
		// 세션 비활성화
		session.removeAttribute("account");
		session.invalidate();

		return "redirect:/";
	}

}
