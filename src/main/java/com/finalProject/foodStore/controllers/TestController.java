package com.finalProject.foodStore.controllers;

import java.util.ArrayList;
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

import com.finalProject.foodStore.models.Cart;
import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.models.OrderFood;
import com.finalProject.foodStore.models.OrderUnit;
import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.CartRepository;
import com.finalProject.foodStore.repositories.OrderFoodRepository;
import com.finalProject.foodStore.repositories.OrderUnitRepository;
import com.finalProject.foodStore.repositories.ProductRepository;
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
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderFoodRepository orderFoodRepository;

	@Autowired
	private OrderUnitRepository orderUnitRepository;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("")
	public ResponseEntity<ResponseObject> getTestPage(HttpServletRequest req, HttpServletResponse res) {

		User user = authenticationService.AuthInfor(req);

		List<OrderFood> orderFood = orderFoodRepository.findAllByUser(user);

		List<OrderUnit> orderUnit = new ArrayList<OrderUnit>();
		List<String> productName = new ArrayList<String>();
		for (OrderFood orderFood1 : orderFood) {
			List<OrderUnit> unit = orderUnitRepository.findAllByOID(orderFood1.getId());
			orderUnit.addAll(unit);
			for (OrderUnit u : unit) {
				String name = productRepository.findById(u.getFoodId()).get().getName();
				productName.add(name);
			}
		}

		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Login has successful", orderUnit));
	}

}
