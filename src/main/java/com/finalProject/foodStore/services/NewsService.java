package com.finalProject.foodStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.foodStore.models.News;
import com.finalProject.foodStore.repositories.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository NRepo;
	
	public void save(News a) {
		NRepo.save(a);
	}
	
	public List<News> getAllBlog(){
		return NRepo.findAll();
	}
	
	public News getBlogById(int id) {
		return NRepo.findById(id).get();
	}
	
	public void deleteBlogById(int id) {
		NRepo.deleteById(id);
	}
}
