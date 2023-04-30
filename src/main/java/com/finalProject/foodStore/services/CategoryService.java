package com.finalProject.foodStore.services;

import com.finalProject.foodStore.dto.CategoryDto;
import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }


    public List<CategoryDto> getCategoryAndProduct(){
        return categoryRepository.getCategoryAndProduct();
    }

    public Optional<Category> findById(Integer id){
        return categoryRepository.findById(id);
    }

    public Category findByCateName(String name) {
    	return categoryRepository.findByName(name);
    }
}
