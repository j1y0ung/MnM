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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.domain.Category;
import com.example.mnm.service.MnmStoreFacade;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/auction/update")
public class UpdateAuctionItemController implements ApplicationContextAware {
	private WebApplicationContext context;
	private String uploadDir;
	private String itemId;
	private String preImage;
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
	public String form(@RequestParam String auctionId, Model model) {
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		
		// 기존 이미지
		preImage = auctionItem.getItem().getImg();
		itemId = auctionItem.getItemId();
		
		// 카테고리 리스트
		List<Category> categoryList = mnmStore.getCategoryList();
		
		model.addAttribute("auctionItem", auctionItem);
		model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
		
		return "UpdateAuctionItemForm";
	}
	
	@PostMapping
	public String update(@RequestParam String auctionId, @Valid @ModelAttribute("auctionItem") AuctionItem auctionItem, 
			BindingResult result, MultipartHttpServletRequest request, Model model) throws Exception {
		
		auctionItem.getItem().setItemId(itemId);
		// 카테고리 아이디
		auctionItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));
		auctionItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));

		// AuctionItem 유효성 검사
		if (result.hasErrors()) {
			List<Category> categoryList = mnmStore.getCategoryList();
			model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
            return "UpdateAuctionItemForm";
        }
		MultipartFile file = request.getFile("file");
		if (file.isEmpty()) { // 새로 등록한 이미지 파일이 있을 경우
			System.out.println("기존 파일로 등록");
			auctionItem.getItem().setImg(preImage);
		} else { // 새로 등록한 이미지 파일이 없을 경우
			System.out.println("새로 등록한 파일 있음");
			auctionItem.getItem().setImg(file.getOriginalFilename());
			uploadFile(file);
		}
		// 현재가 = 시작가
		auctionItem.setCurrentPrice(auctionItem.getStartPrice());
		mnmStore.updateAuctionItem(auctionItem);
		mnmStore.updateItem(auctionItem.getItem());
		
		// 경매 스케쥴러
		mnmStore.startAuctionScheduler(auctionItem.getStartDate(), auctionItem.getAuctionId());
		mnmStore.endAuctionScheduler(auctionItem.getEndDate(), auctionItem.getAuctionId());
		
		return "redirect:/auction/" + auctionId;
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