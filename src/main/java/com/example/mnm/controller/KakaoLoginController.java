package com.example.mnm.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mnm.domain.Account;
import com.example.mnm.service.KakaoAPI;
import com.example.mnm.service.MnmStoreFacade;

@Controller
@RequestMapping("kakaoLogin")
public class KakaoLoginController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KakaoAPI kakao;
	
	@Autowired
	private MnmStoreFacade store;
	public void setStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 카카오 로그인
	@RequestMapping(method=RequestMethod.GET)
	public String kakaoLogin(@RequestParam("code") String code, HttpSession session) {
		logger.info("kakaoLogin()");
	    String access_Token = kakao.getAccessToken(code);
	    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
	    logger.info("userInfo: " + userInfo);
	    
	    String userid = (String) userInfo.get("id");
	    String name = (String) userInfo.get("name");
	    String email = (String) userInfo.get("email");
	    
	    // 회원 리스트에 없는 아이디면 join
	    String hasAccount = store.hasAccount(userid);
	    if(hasAccount == null) {
	    	Account account = new Account();
	    	logger.info("카카오 회원 등록");
	    	account.setUserid(userid);
	    	account.setName(name);
	    	account.setEmail(email);
	    	account.setKakao("y");
	    	store.insertAccount(account);
	    }
	    
	    // 세션 등록
	    Account account = store.getAccount(userid);
	    session.setAttribute("account", account);
	    return "redirect:/";
	}
}
