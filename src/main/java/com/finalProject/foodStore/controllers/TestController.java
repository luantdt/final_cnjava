package com.finalProject.foodStore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/test")
public class TestController {
	@GetMapping("")
	public String getTestPage() {
		return "test";
	}
}