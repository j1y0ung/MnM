package com.example.mnm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class ViewMypageController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private String viewName = "MypageView";
	
	private MnmStoreFacade store;
	@Autowired
	public void setMnmStore(MnmStoreFacade store) {
		this.store = store;
	}
	
	// 마이페이지로 이동
	@RequestMapping("mypage")
	public String goMypage(HttpSession session, Model model) {
		logger.info("goMypage()");
		Account account = (Account) session.getAttribute("account");
		
		// 관심 카테고리에 해당하는 아이템 가져오기
		String fav = account.getFavcategory();
		List<PersonalDealItem> recommendItems = store.getRecommendedItemList(fav);
		model.addAttribute("recommendItems", recommendItems);
		return viewName;
	}
}