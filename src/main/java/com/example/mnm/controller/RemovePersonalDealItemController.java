package com.example.mnm.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.example.mnm.service.MnmStoreFacade;

@Controller
public class RemovePersonalDealItemController implements ApplicationContextAware{
	
	private WebApplicationContext context;
	private String uploadDir;
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}

	@RequestMapping("/personalDeal/remove/{personalDealId}")
	//public String handleRequest(@PathVariable String personalDealId, @RequestParam String itemId, @RequestParam String img) {
	public String handleRequest(@PathVariable String personalDealId) {
		mnmStore.removePersonalDealItem(personalDealId);
		//deleteFile(img);
		//mnmStore.deleteItem(itemId);
		return "redirect:/personalDeal/newest";
	}
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
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
