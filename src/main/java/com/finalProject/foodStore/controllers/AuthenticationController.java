package com.finalProject.foodStore.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.foodStore.jwt.AuthenticationRequest;
import com.finalProject.foodStore.jwt.AuthenticationResponse;
import com.finalProject.foodStore.jwt.RegisterRequest;
import com.finalProject.foodStore.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private final AuthenticationService service;

	/*
	 * @PostMapping("/register") public ResponseEntity<AuthenticationResponse>
	 * register(@RequestBody RegisterRequest request) { return
	 * ResponseEntity.ok(service.register(request)); }
	 */

	@PostMapping(path = "/login")
	public String authenticate(@RequestBody AuthenticationRequest request) {
		System.out.println(request);
		service.authenticate(request);
		return "admin/index";
	}
	
	@GetMapping("/login")
	public String getLoginPage() {
		return "admin/login";
	}

	/*
	 * @PostMapping("/refresh-token") public void refreshToken(HttpServletRequest
	 * request, HttpServletResponse response) throws IOException {
	 * service.refreshToken(request, response); }
	 */

}
