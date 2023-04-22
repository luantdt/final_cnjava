package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.services.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
@RequestMapping("")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/product")
    public String getProduct(Model model)
    {
        List<Food> foods = foodService.getAllFoods();
        model.addAttribute("foods", foods);
        return "client/shop";
    }
}
