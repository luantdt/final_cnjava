package com.finalProject.foodStore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.models.OrderFood;
import com.finalProject.foodStore.models.OrderUnit;
import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.OrderFoodRepository;
import com.finalProject.foodStore.repositories.OrderUnitRepository;
import com.finalProject.foodStore.repositories.UserRepository;
import com.finalProject.foodStore.services.AuthenticationService;

import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(path = "/test")
@PreAuthorize("hasRole('USER')")
public class TestController {
	@Autowired
	private AuthenticationService authService;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private OrderFoodRepository orderFoodRepository;
	@Autowired
	private OrderUnitRepository orderUnitRepository;
	
	@GetMapping("")
	public ResponseEntity<ResponseObject> getTestPage(HttpServletRequest req, HttpServletResponse res) {

		User user = authService.AuthInfor(req);

		List<OrderFood> orderFood = orderFoodRepository.findAllByUser(user);
		List<OrderUnit> unit = orderUnitRepository.findAllByOID(orderFood.get(0).getId());
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", unit));
	}

	@GetMapping("/rest/{id}")
	public ResponseEntity<ResponseObject> getUser(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", user.get()));
	}
}
