package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.services.CategoryService;
import com.finalProject.foodStore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String getHome(Model model){
        List<Category> categories = categoryService.getAllCategories();
        List<Food> products = productService.getAllProducts();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "client/index";
    }

    @GetMapping("/product")
    public String getProduct(Model model)
    {
        List<Food> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/shop";
    }


    @GetMapping("/find-product/{id}")
    public String findProductById(@PathVariable("id") Integer id, Model model){
        Food food = productService.getProductById(id);
        model.addAttribute("product", food);
        return "client/product-detail";
    }
}
