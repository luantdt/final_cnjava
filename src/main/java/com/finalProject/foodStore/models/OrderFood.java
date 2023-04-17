package com.finalProject.foodStore.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table
@Entity(name = "orderfood")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderFood {
	private int id;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private User user;

	@CreationTimestamp
	private Date orderDate;
	
	private float shippingFee = 20;
	
	private String status;
	private String note;
	private float total;

	/*
	 * @Transient public int calTotal() { int sum = 0; List<ProductOrder> pros =
	 * getProductOrder(); for (ProductOrder productOrder : pros) { sum +=
	 * productOrder.getProducts().getPrice() * productOrder.getQuantity(); } return
	 * sum; }
	 */
}
