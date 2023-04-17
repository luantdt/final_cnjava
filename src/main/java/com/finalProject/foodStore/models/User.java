package com.finalProject.foodStore.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table
@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true, length = 255)
	@NotEmpty(message = "email of account is not empty")
	@NotNull(message = "email of account is not null")
	private String email;
	
	@Column(length = 10)
	@Max(value = 10, message = "phone is no more than 10 characters")
	@Min(value = 9, message = "phone is no less than 9 characters")
	@NotEmpty(message = "phone of account is not empty")
	@NotNull(message = "phone of account is not null")
	private String phone;
	
	@NotEmpty(message = "name of account is not empty")
	@NotNull(message = "name of account is not null")
	private String name;
	
	@NotEmpty(message = "address of account is not empty")
	@NotNull(message = "address of account is not null")
	private String address;
	
	@NotEmpty(message = "password of account is not empty")
	@NotNull(message = "password of account is not null")
	private String password;
	
	private Boolean status = true;
	private String role;
	
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	@EqualsAndHashCode.Exclude
    @ToString.Exclude
	private List<OrderFood> orderFood;
}
