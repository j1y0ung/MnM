package com.example.mnm.controller;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.mnm.service.MnmStoreFacade;

@Controller
public class RemoveAuctionItemController implements ApplicationContextAware {
	
	private WebApplicationContext context;
	private String uploadDir;
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setMnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@RequestMapping("/auction/remove/{auctionId}")
	public String handleRequest(@PathVariable String auctionId, @RequestParam String itemId, @RequestParam String img) {
		mnmStore.deleteAuctionItem(auctionId);
		deleteFile(img);
		mnmStore.deleteItem(itemId);
		return "redirect:/auction/recently";
	}
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
	// 이미지 파일 삭제
	private void deleteFile(String img) {
		File file = new File(this.uploadDir + img);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("파일 삭제 성공");
			} else {
				System.out.println("파일 삭제 실패");
			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

}
