package com.finalProject.foodStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	@GetMapping("/")
	public String getHomePage(Model model)
	{
		model.addAttribute("title", "Home Page");
		return "client/index";
	}


}
