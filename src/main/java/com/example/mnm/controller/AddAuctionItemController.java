package com.example.mnm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Account;
import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Category;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/auction/add")
@SessionAttributes("account")
public class AddAuctionItemController implements ApplicationContextAware {
	
	private WebApplicationContext context;
	private String uploadDir;
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@ModelAttribute("auctionItem")
	public AuctionItem formBacking() {
		return new AuctionItem();
	}

	@GetMapping
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		// 카테고리 목록 가져오기
		List<Category> categoryList = mnmStore.getCategoryList();
		mav.setViewName("RegistAuctionItemForm");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		return mav;
	}
	
	@PostMapping
	public String submit(@Valid @ModelAttribute("auctionItem") AuctionItem auctionItem, BindingResult result, MultipartHttpServletRequest request, 
			@ModelAttribute("account") Account account, Model model) throws Exception {
		// AuctionItem 유효성 검사
		if (result.hasErrors()) {
			List<Category> categoryList = mnmStore.getCategoryList();
			model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
            return "RegistAuctionItemForm";
        }
		// 이미지 파일 업로드
        MultipartFile file = request.getFile("file");
		auctionItem.getItem().setImg(file.getOriginalFilename());
		uploadFile(file);
		
		auctionItem.getItem().setType("auction");
		// 세션에 저장된 account의 id를 꺼내 item의 userId(판매자)에 세팅.
		auctionItem.getItem().setUserId(account.getUserid());
		// 카테고리 - 경매 등록 폼에서 선택된 값들을 item의 부모,자식 카테고리 아이디에 세팅
		auctionItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));
		auctionItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));
		
		// Item, AuctionItem 테이블에 저장
		mnmStore.insertItem(auctionItem.getItem());
		mnmStore.insertAuctionItem(auctionItem);
		
		// 경매 스케쥴러
		mnmStore.startAuctionScheduler(auctionItem.getStartDate(), auctionItem.getAuctionId());
		mnmStore.endAuctionScheduler(auctionItem.getEndDate(), auctionItem.getAuctionId());
		
		return "redirect:/auction/" + auctionItem.getAuctionId();
	}

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
	private void uploadFile(MultipartFile report) {
		File file = new File(this.uploadDir + report.getOriginalFilename());
		try {
			report.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
