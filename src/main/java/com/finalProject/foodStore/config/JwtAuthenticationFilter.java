package com.finalProject.foodStore.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

import com.finalProject.foodStore.repositories.TokenRepository;
import com.finalProject.foodStore.services.JwtService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private final JwtService jwtService;

	@Autowired
	private final UserDetailsService userDetailsService;

	@Autowired
	private final TokenRepository tokenRepository;

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {
		if (request.getServletPath().contains("/auth")) {
			filterChain.doFilter(request, response);
			return;
		}

		Cookie cookie = WebUtils.getCookie(request, "access_token");

		if (cookie == null) {
			if (request.getServletPath().contains("/test") || request.getServletPath().contains("/order")
					|| request.getServletPath().contains("/cart/pay") || request.getServletPath().contains("/cart")
					|| request.getServletPath().contains("/admin")) {
				response.sendRedirect(request.getContextPath() + "/auth/login");
				return;
			} else {
				filterChain.doFilter(request, response);
				return;
			}
		}

		final String userEmail;
		final String jwt = cookie.getValue();
		userEmail = jwtService.extractUsername(jwt);
		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
			boolean isAdmin = false;
			for (GrantedAuthority authority : userDetails.getAuthorities()) {
				if (authority.getAuthority() == "ADMIN") {
					isAdmin = true;
				}
			}

			if (request.getServletPath().contains("/admin") && isAdmin == false) {
				response.sendRedirect(request.getContextPath() + "/");
				return;
			}

			var isTokenValid = tokenRepository.findByToken(jwt).map(t -> !t.isExpired() && !t.isRevoked())
					.orElse(false);
			if (jwtService.isTokenValid(jwt, userDetails) && isTokenValid) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
}