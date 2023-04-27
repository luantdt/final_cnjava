package com.finalProject.foodStore.jwt;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
	@NotNull(message = "email is not empty")
	@NotEmpty(message = "email is not empty")
	private String email;
	
	@NotNull(message = "password is not empty")
	@NotEmpty(message = "password is not empty")
	String password;
}
