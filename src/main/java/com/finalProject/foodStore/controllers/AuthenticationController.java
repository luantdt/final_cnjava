package com.finalProject.foodStore.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalProject.foodStore.jwt.AuthenticationRequest;
import com.finalProject.foodStore.jwt.AuthenticationResponse;
import com.finalProject.foodStore.jwt.RegisterRequest;
import com.finalProject.foodStore.jwt.UpdateRequest;
import com.finalProject.foodStore.models.ResponseObject;
import com.finalProject.foodStore.services.AuthenticationService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	@Autowired
	private final AuthenticationService service;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody @Valid RegisterRequest request,
			HttpServletResponse response) {
		return ResponseEntity.ok(service.register(request, response));
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseObject> authenticate(@RequestBody @Valid AuthenticationRequest request,
			HttpServletResponse response) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("OK", "Login has successful", service.authenticate(request, response)));
	}

	@PostMapping("/refresh-token")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		service.refreshToken(request, response);
	}

	@PostMapping("/update")
	public ResponseEntity<ResponseObject> updateUser(@RequestBody @Valid UpdateRequest req, HttpServletResponse res){
		int type = service.update(req);
		if (type == 0) {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Update account has successful", null));
		} else {
			if (type == 1) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("FALSE", "Cant not found", null));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseObject("FALSE", "Email has existed", null));
		}
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "admin/login";
	}

	@GetMapping("register")
	public String getRegisterPage() {
		return "admin/register";
	}
}