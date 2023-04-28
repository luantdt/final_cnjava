package com.finalProject.foodStore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.services.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@GetMapping("/category")
	public ModelAndView categoryList() {
		List<Category> list = service.getAllCategory();
		ModelAndView m = new ModelAndView();
		m.setViewName("admin/categoryList");
		m.addObject("category",list);
		return new ModelAndView("admin/categoryList","category",list);
	}
	
	@PostMapping("/save")
	public String addCategory(@ModelAttribute Category c) {
		service.save(c);
		return "redirect:/admin/category";
	}
	
	@RequestMapping("/editCategory/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Category p = service.getCategoryById(id);
		model.addAttribute("category", p);
		return "admin/categoryDetail";
	}
	
	@RequestMapping("/deleteCategory/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		service.deleteCategoryById(id);
		return "redirect:/admin/category";
	}
}
