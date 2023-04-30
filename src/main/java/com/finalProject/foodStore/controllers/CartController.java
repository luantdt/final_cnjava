package com.finalProject.foodStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.repositories.CategoryRepository;
import com.finalProject.foodStore.services.CartService;
import com.finalProject.foodStore.services.OrderService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/cart")
@Controller

public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderService orderService;
    
    @GetMapping("")
    public String getCart(Model model, HttpServletRequest httpServletRequest){
        List<Category> categories = categoryRepository.getAllCategories();
        cartService.getModel(model, httpServletRequest);
        model.addAttribute("categories", categories);
        return "client/cart";
    }

    @GetMapping("/{id}")
    public String addCart(@PathVariable Integer id, HttpServletRequest httpServletRequest) {
        cartService.addCart(id, httpServletRequest);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItemById(@PathVariable("id") Integer id){
        cartService.deleteById(id);
        return "/client/cart";
    }

    @GetMapping("/pay")
    public String pay(HttpServletRequest httpServletRequest ) {
        orderService.payAllItem(httpServletRequest);
        return "redirect:/cart";
    }
}
