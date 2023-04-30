package com.finalProject.foodStore.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 255)
	@NotEmpty(message = "title is not empty")
	@NotNull(message = "title is not null")
	private String title;
	
	@NotEmpty(message = "description of blog is not empty")
	@NotNull(message = "description of blog is not null")
	private String description;
	
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date date;
 
}
