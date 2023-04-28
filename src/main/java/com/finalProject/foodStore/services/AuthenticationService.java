package com.finalProject.foodStore.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalProject.foodStore.jwt.AuthenticationRequest;
import com.finalProject.foodStore.jwt.AuthenticationResponse;
import com.finalProject.foodStore.jwt.RegisterRequest;
import com.finalProject.foodStore.jwt.Role;
import com.finalProject.foodStore.jwt.TokenType;
import com.finalProject.foodStore.models.Token;
import com.finalProject.foodStore.models.User;
import com.finalProject.foodStore.repositories.TokenRepository;
import com.finalProject.foodStore.repositories.UserRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private final UserRepository repository;

	@Autowired
	private final TokenRepository tokenRepository;

	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	private final JwtService jwtService;
	
	@Autowired
	private final AuthenticationManager authenticationManager;

	public AuthenticationResponse register(RegisterRequest request, HttpServletResponse response) {
		var user = User.builder()
				.name(request.getName())
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.phone(request.getPhone())
				.address(request.getAddress())
				.status(true)
				.role(Role.USER).build();
		System.out.println(user);
		var savedUser = repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(user);
		saveUserToken(savedUser, jwtToken);
		saveTokenIntoCookie(response, jwtToken, refreshToken);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
		
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		var users = repository.findByEmail(request.getEmail()).orElseThrow();
		var jwtToken = jwtService.generateToken(users);
		var refreshToken = jwtService.generateRefreshToken(users);
		revokeAllUserTokens(users);
		saveUserToken(users, jwtToken);
   
        Cookie access_cookie = new Cookie("access_token", jwtToken);
        Cookie refresh_coookie = new Cookie("refresh_token", refreshToken);
        
        access_cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        access_cookie.setPath("/");
        
        refresh_coookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        refresh_coookie.setPath("/");
        
        response.addCookie(access_cookie);
        response.addCookie(refresh_coookie);
		return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
	}

	private void saveUserToken(User user, String jwtToken) {
		var token = Token.builder().user(user).token(jwtToken).tokenType(TokenType.BEARER).expired(false)
				.revoked(false).build();
		tokenRepository.save(token);
	}

	private void revokeAllUserTokens(User user) {
		var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
		if (validUserTokens.isEmpty())
			return;
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepository.saveAll(validUserTokens);
	}

	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		final String refreshToken;
		final String userEmail;
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		refreshToken = authHeader.substring(7);
		userEmail = jwtService.extractUsername(refreshToken);
		if (userEmail != null) {
			var user = this.repository.findByEmail(userEmail).orElseThrow();
			if (jwtService.isTokenValid(refreshToken, user)) {
				var accessToken = jwtService.generateToken(user);
				revokeAllUserTokens(user);
				saveUserToken(user, accessToken);
				var authResponse = AuthenticationResponse.builder().accessToken(accessToken).refreshToken(refreshToken)
						.build();
				new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
			}
		}
	}
	
	public void saveTokenIntoCookie(HttpServletResponse response, String accessToken, String refreshToken) {
		Cookie access_cookie = new Cookie("access_token", accessToken);
        Cookie refresh_coookie = new Cookie("refresh_token", refreshToken);
        
        access_cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        access_cookie.setPath("/");
        
        refresh_coookie.setMaxAge(7 * 24 * 60 * 60);
        refresh_coookie.setPath("/");
        
        response.addCookie(access_cookie);
        response.addCookie(refresh_coookie);
	}
}
