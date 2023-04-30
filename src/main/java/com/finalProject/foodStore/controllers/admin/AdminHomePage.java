package com.finalProject.foodStore.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminHomePage {
	
	@Autowired
	private AuthenticationService authService;

	@GetMapping("")
	public String getAdminHomePage(Model model, HttpServletRequest req) {
		model.addAttribute("fullName", authService.AuthInfor(req).getName());
		return "admin/index";
	}
}
