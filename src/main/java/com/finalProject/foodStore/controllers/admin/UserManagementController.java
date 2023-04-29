package com.finalProject.foodStore.controllers.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/user")
public class UserManagementController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public String getUserManagementPage(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "admin/userManage";
	}
	
	@GetMapping("/{id}")
	public String getEditUserPage(Model model, @PathVariable int id, HttpServletResponse res) {
		Optional<User> user = userRepo.findById(id);
		if(!user.isPresent()) {
			return "redirect:/admin/user";
		}
		model.addAttribute("user", user.get());
		return "admin/editUser";
	}
}
