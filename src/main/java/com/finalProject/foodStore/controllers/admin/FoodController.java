package com.finalProject.foodStore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.CategoryRepository;
import com.finalProject.foodStore.services.CategoryService;
import com.finalProject.foodStore.services.FoodService;
import com.finalProject.foodStore.services.IStorageService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class FoodController {
	@Autowired
	private FoodService service;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private IStorageService storageService;
	
	@GetMapping("/food")
	public String foodList(Model model) {
		List<Food> list = service.getAllFood();
		List<Category> categories = categoryService.getAllCategory();
		model.addAttribute("list",list);
		model.addAttribute("categories",categories);
		return "admin/foodList";
	} 
	
	@PostMapping("/saveFood")
	public String addFood(@ModelAttribute Food f) {
		service.save(f);
		return "admin/addFood";
	}
	
	@RequestMapping("/editFood/{id}")
	public String editFood(@PathVariable("id") int id, Model model) {
		Food f = service.getFoodById(id);
		model.addAttribute("food", f);
		return "admin/foodDetail";
	}
	
	@RequestMapping("/deleteFood/{id}")
	public String deleteFood(@PathVariable("id") int id) {
		service.deleteFoodById(id);
		return "redirect:/admin/food";
	}
	
//	@PostMapping("/addFood")
//	public String uploadFile(@RequestParam("file") MultipartFile file, @ModelAttribute @Valid Food newFood,
//			RedirectAttributes redirectAttributes, BindingResult bindingResult) {
//
//		if (newFood.isValidExceptImg()) {
//			try {
//				String generatedFileName = storageService.storeFile(file);
//				newFood.setImage(generatedFileName);
//				service.save(newFood);
//				redirectAttributes.addFlashAttribute("successMessage", "Add new product has successful");
//				return "redirect:/admin";
//			} catch (Exception exception) {
//				redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
//				return "redirect:/admin";
//			}
//		} else {
//			redirectAttributes.addFlashAttribute("errorMessage",
//					"Could not add new product. Make sure you have entered all the fields. Please select the product again to update information");
//			return "redirect:/admin";
//		}
//
//	}
}
