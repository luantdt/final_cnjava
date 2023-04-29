package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String showOrder(Model model){
        orderService.getAllAndModel(model);

        return "/client/order";
    }

}
