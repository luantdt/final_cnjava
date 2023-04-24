package com.finalProject.foodStore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
