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

import com.finalProject.foodStore.models.About;
import com.finalProject.foodStore.services.AboutService;


@Controller
@RequestMapping("/admin")
public class AboutController {
	@Autowired
	private AboutService aboutService;
	
	@GetMapping("/about")
	public ModelAndView aboutList() {
		List<About> list = aboutService.getAllInfo();
		ModelAndView m = new ModelAndView();
		m.setViewName("admin/about");
		m.addObject("about",list);
		return new ModelAndView("admin/about","about",list);
	}
	
	@GetMapping("/add_info")
	public String createProduct() {
		return "admin/addAbout";
	}
	
	@PostMapping("/saveInfo")
	public String addAbout(About a) {
		aboutService.save(a);
		return "redirect:/admin/about";
	}
	
	@RequestMapping("/editInfo/{id}")
	public String editAbout(@PathVariable("id") int id, Model model) {
		About a = aboutService.getInfoById(id);
		model.addAttribute("about", a);
		return "admin/aboutDetail";
	}
	
	@RequestMapping("/deleteInfo/{id}")
	public String deleteAbout(@PathVariable("id") int id) {
		aboutService.deleteInfoById(id);
		return "redirect:/admin/about";
	}
}
