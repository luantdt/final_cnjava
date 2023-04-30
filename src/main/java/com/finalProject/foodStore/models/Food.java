package com.finalProject.foodStore.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table
@Entity(name = "food")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	@NotNull(message = "category is not null")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonIgnore
	private Category category;

	@NotEmpty(message = "name of food is not empty")
	@NotNull(message = "name of food is not null")
	private String name;

	@NotNull(message = "quantity field cannot be left null")
	@Min(value = 1, message = "quantity must more than one")
	private float quantity;

	@NotEmpty(message = "description of food is not empty")
	@NotNull(message = "description of food is not null")
	private String description;

	@NotEmpty(message = "image of food is not empty")
	@NotNull(message = "image of food is not null")
	private String image;
	
	private Boolean isSale = true;

	@Column(nullable = true)
	private float discountPrice;
	
	@NotNull(message = "quantity field cannot be left null")
	@Min(value = 1, message = "quantity must more than one")
	private float price;
	
	@Column(nullable = true)
	private Date beginSale;
	
	private boolean status = true;
	
	@Column(nullable = true)
	private Date endSale;
	
	
}
