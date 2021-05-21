package com.example.mnm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.mnm.domain.CrowdFundingItem;

@Controller
@RequestMapping("test")
public class TestController {
	@GetMapping("")
	public ModelAndView handelRequest(HttpServletRequest request) throws Exception {
		return new ModelAndView("crowdFundingForm", "crowdFundingItem", new CrowdFundingItem());
	}
}
