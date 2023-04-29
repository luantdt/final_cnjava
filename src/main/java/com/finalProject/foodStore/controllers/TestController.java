package com.finalProject.foodStore.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.UserRepository;
import com.finalProject.foodStore.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/test")
public class TestController {
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("")
	public ResponseEntity<ResponseObject> getTestPage(HttpServletRequest req) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", authService.AuthInfor(req)));
	}
	
	@GetMapping("/rest/{id}")
	public ResponseEntity<ResponseObject> getUser(@PathVariable int id){
		System.out.println(id);
		Optional<User> user = userRepo.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", user.get()));
	}
}
