package com.finalProject.foodStore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.services.FoodService;

@Controller
@RequestMapping("/admin")
public class FoodController {
	@Autowired
	private FoodService service;
	
	@GetMapping("/food")
	public ModelAndView foodList() {
		List<Food> list = service.getAllFood();
		ModelAndView m = new ModelAndView();
		m.setViewName("admin/foodList");
		m.addObject("food",list);
		return new ModelAndView("admin/foodList","food",list);
	}
}
