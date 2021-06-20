package com.example.mnm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.Category;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/personalDeal/update")
public class UpdatePersonalDealItemController implements ApplicationContextAware{
	
	private WebApplicationContext context;
	private String uploadDir;
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@ModelAttribute("personalDealItem")
	public PersonalDealItem formBacking() {
		return new PersonalDealItem();
	}

	@GetMapping
	public ModelAndView form() {
		ModelAndView mav = new ModelAndView();
		List<Category> categoryList = mnmStore.getCategoryList();
		mav.setViewName("RegistPersonalDealItemForm");
		mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		return mav;
	}
	
	@PostMapping
	public String submit(@ModelAttribute("personalDealItem") PersonalDealItem personalDealItem, MultipartHttpServletRequest request, 
			@ModelAttribute("userSession") UserSession userSession) throws Exception {
		
		MultipartFile file = request.getFile("file");
		personalDealItem.getItem().setImg(file.getOriginalFilename());
		uploadFile(file);
		
		personalDealItem.getItem().setType("personalDeal");
		personalDealItem.getItem().setUserId(userSession.getAccount().getUserid());
		// 카테고리
		personalDealItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));
		personalDealItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));
		
		mnmStore.insertItem(personalDealItem.getItem());
		mnmStore.addPersonalDealItem(personalDealItem);
			
		return "redirect:/personalDeal/" + personalDealItem.getPersonalDealId();
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
