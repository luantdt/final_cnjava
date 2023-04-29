package com.finalProject.foodStore.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.finalProject.foodStore.models.News;
import com.finalProject.foodStore.services.NewsService;

@Controller
@RequestMapping("/admin")
public class NewsController {
	@Autowired
	private NewsService newsService;
	
	@GetMapping("/blog")
	public ModelAndView blogList() {
		List<News> list = newsService.getAllBlog();
		ModelAndView m = new ModelAndView();
		m.setViewName("admin/new");
		m.addObject("blog",list);
		return new ModelAndView("admin/new","blog",list);
	}
	
	@GetMapping("/add_blog")
	public String createBlog() {
		return "admin/addNews";
	}
	
	@PostMapping("/saveBlog")
	public String addBlog(News a) {
		newsService.save(a);
		return "redirect:/admin/blog";
	}
	
	@RequestMapping("/editBlog/{id}")
	public String editBlog(@PathVariable("id") int id, Model model) {
		News a = newsService.getBlogById(id);
		model.addAttribute("blog", a);
		return "admin/newsDetail";
	}
	
	@RequestMapping("/deleteBlog/{id}")
	public String deleteBlog(@PathVariable("id") int id) {
		newsService.deleteBlogById(id);
		return "redirect:/admin/blog";
	}
}
