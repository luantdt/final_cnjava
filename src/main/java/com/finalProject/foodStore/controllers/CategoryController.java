package com.finalProject.foodStore.controllers;


import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.CategoryRepository;
import com.finalProject.foodStore.repositories.ProductRepository;
import com.finalProject.foodStore.services.CartService;
import com.finalProject.foodStore.services.CategoryService;
import com.finalProject.foodStore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("")
public class CategoryController {

}
