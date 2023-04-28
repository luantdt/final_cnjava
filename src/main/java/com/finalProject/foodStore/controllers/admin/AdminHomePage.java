package com.finalProject.foodStore.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomePage {
	@GetMapping("")
	public String getAdminHomePage() {
		return "admin/index";
	}
}
