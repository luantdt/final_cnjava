package com.finalProject.foodStore.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository CRepo;
	
	public void save(Category c) {
		CRepo.save(c);
	}
	
	public List<Category> getAllCategory(){
		return CRepo.findAll();
	}
	
	public Category getCategoryById(int id) {
		return CRepo.findById(id).get();
	}
	
	public void deleteCategoryById(int id) {
		CRepo.deleteById(id);
	}
}
