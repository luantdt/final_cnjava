package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.repositories.CategoryRepository;
import com.finalProject.foodStore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("")
    public String getCart(Model model){
        List<Category> categories = categoryRepository.getAllCategories();
        cartService.getModel(model);
        model.addAttribute("categories", categories);
        return "client/cart";
    }

    @GetMapping("/{id}")
    public String addCart(@PathVariable Integer id) {
        cartService.addCart(id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItemById(@PathVariable("id") Integer id){
        cartService.deleteById(id);
        return "/client/cart";
    }
}
