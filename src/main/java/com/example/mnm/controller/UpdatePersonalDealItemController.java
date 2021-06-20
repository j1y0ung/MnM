package com.example.mnm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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

import com.example.mnm.domain.Account;
import com.example.mnm.domain.Category;
import com.example.mnm.domain.PersonalDealItem;
import com.example.mnm.service.MnmStoreFacade;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/personalDeal/update")
public class UpdatePersonalDealItemController implements ApplicationContextAware{
	
	private WebApplicationContext context;
	private String uploadDir;
	private String itemId;
	private String preImage;
	
	private MnmStoreFacade mnmStore;
	@Autowired
	public void setmnmStore(MnmStoreFacade mnmStore) {
		this.mnmStore = mnmStore;
	}
	
	@ModelAttribute("personalDealItem")
	public PersonalDealItem formBacking() {
		return new PersonalDealItem();
	}

	@GetMapping("/{personalDealId}")
	public ModelAndView updateForm(
			HttpServletRequest request
			, @PathVariable("personalDealId") String personalDealId
			, ModelMap model
			, HttpSession session
			) throws Exception {

		ModelAndView mav = new ModelAndView();

		Account account = (Account) session.getAttribute("account");
		if(account == null) {
			mav.setViewName("thyme/personalDeal/myList");
		} else {
			mav.setViewName("UpdatePersonalDealItemForm");

			PersonalDealItem personalDealItem = this.mnmStore.getPersonalDealItem(personalDealId);
			model.put("personalDealItem", personalDealItem);

			// 카테고리
			List<Category> categoryList = mnmStore.getCategoryList();
			mav.addObject("categoryList", JSONArray.fromObject(categoryList));
		}
		return mav;
	}
	/*@GetMapping
	public String form(@RequestParam String personalDealId, Model model) {
		PersonalDealItem personalDealItem = mnmStore.getPersonalDealItem(personalDealId);
		personalDealItem.setItem(mnmStore.getItem(personalDealItem.getItemId()));
		
		preImage = personalDealItem.getItem().getImg();
		itemId = personalDealItem.getItemId();
		
		List<Category> categoryList = mnmStore.getCategoryList();
		
		model.addAttribute("personalDealItem", personalDealItem);
		model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
		
		return "UpdatePersonalDealItemForm";
	}*/

	@PostMapping
	public String update(@RequestParam String personalDealId, @Valid @ModelAttribute("personalDealItem") PersonalDealItem personalDealItem, BindingResult result, MultipartHttpServletRequest request, Model model) throws Exception {
		personalDealItem.getItem().setItemId(itemId);
		personalDealItem.getItem().setParentCatId(Integer.parseInt(request.getParameter("category1")));
		personalDealItem.getItem().setChildCatId(Integer.parseInt(request.getParameter("category2")));

		if (result.hasErrors()) {
			List<Category> categoryList = mnmStore.getCategoryList();
			model.addAttribute("categoryList", JSONArray.fromObject(categoryList));
            return "UpdatePersonalDealItemForm";
        }

		mnmStore.updatePersonalDealItem(personalDealItem);
		mnmStore.updateItem(personalDealItem.getItem());
		
		return "redirect:/personalDeal/" + personalDealId;
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
