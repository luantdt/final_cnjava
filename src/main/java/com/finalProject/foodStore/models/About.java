package com.finalProject.foodStore.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "about")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class About {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 255)
	@NotEmpty(message = "title is not empty")
	@NotNull(message = "title is not null")
	private String title;
	
	@Column(length = 255)
	@NotEmpty(message = "Sub title is not empty")
	@NotNull(message = "Sub title is not null")
	private String subTitle;
	
	private String description;
	
	private String address;
}
