package com.example.mnm.controller;


import java.io.File;
import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.mnm.domain.AuctionItem;
import com.example.mnm.service.MnmStoreFacade;

@Controller
public class UpdateAuctionItemController implements ApplicationContextAware {
	private WebApplicationContext context;
	private String uploadDir;
	private String itemId;
	private String preImage;
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@GetMapping("/auction/update/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, Model model) {
		AuctionItem auctionItem = mnmStore.getAuctionItem(auctionId);
		auctionItem.setItem(mnmStore.getItem(auctionItem.getItemId()));
		preImage = auctionItem.getItem().getImg();
		itemId = auctionItem.getItemId();
		model.addAttribute("auctionItem", auctionItem);
		return "thyme/UpdateAuctionItemForm";
	}
	
	@PostMapping("/auction/update/{auctionId}")
	public String handleRequest2(@PathVariable String auctionId, AuctionItem auctionItem, MultipartHttpServletRequest request, Model model) throws Exception {
		auctionItem.getItem().setItemId(itemId);
		MultipartFile file = request.getFile("file");
		if (file.isEmpty()) {
			System.out.println("기존 파일로 등록");
			auctionItem.getItem().setImg(preImage);
		} else {
			System.out.println("새로 등록한 파일 있음");
			auctionItem.getItem().setImg(file.getOriginalFilename());
			uploadFile(file);
		}
		mnmStore.updateAuctionItem(auctionItem);
		mnmStore.updateItem(auctionItem.getItem());
		System.out.println(auctionItem.getItem().getViews());
		model.addAttribute("auctionItem", auctionItem);
		return "thyme/AuctionItemView";
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