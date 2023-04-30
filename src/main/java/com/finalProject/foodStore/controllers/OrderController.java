package com.finalProject.foodStore.controllers;

import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.services.AuthenticationService;
import com.finalProject.foodStore.services.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public String showOrder(Model model, HttpServletRequest  httpServletRequest){
        orderService.getAllAndModel(model, httpServletRequest);

        return "client/order";
    }

    @Autowired
    private AuthenticationService authService;
    @GetMapping("/test")
    public ResponseEntity<ResponseObject> getTestPage(HttpServletRequest req) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", authService.AuthInfor(req)));
    }

}
