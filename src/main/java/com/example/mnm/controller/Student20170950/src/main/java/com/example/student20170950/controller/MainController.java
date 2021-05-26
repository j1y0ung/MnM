package com.example.student20170950.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@GetMapping({"", "/"})
	public String requestHandle(Model model) {
		return "main";
	}
}
