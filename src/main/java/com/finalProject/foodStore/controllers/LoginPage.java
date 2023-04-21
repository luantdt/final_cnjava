package com.finalProject.foodStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginPage {
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}
}