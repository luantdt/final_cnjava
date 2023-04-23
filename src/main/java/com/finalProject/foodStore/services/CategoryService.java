package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }

}
