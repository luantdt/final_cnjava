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
public class UpdateRequest {
	
	@NotNull(message = "id is not empty")
	private int id;
	
	
	@NotNull(message = "name is not empty")
	@NotEmpty(message = "name is not empty")
	private String name;

	@NotNull(message = "email is not empty")
	@NotEmpty(message = "email is not empty")
	private String email;

	@NotNull(message = "phone is not empty")
	@NotEmpty(message = "phone is not empty")
	private String phone;

	@NotNull(message = "address is not empty")
	@NotEmpty(message = "address is not empty")
	private String address;

	@NotNull(message = "role is not empty")
	@NotEmpty(message = "role is not empty")
	private String role;
	
	@NotNull(message = "status is not empty")
	private boolean status;
}
