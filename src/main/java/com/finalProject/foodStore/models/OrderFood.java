package com.finalProject.foodStore.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Table
@Entity(name = "orderfood")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderFood {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@CreationTimestamp
	private LocalDateTime orderDate;
	
	private float shippingFee = 20;
	
	private String status;
	
	@Column(nullable = true)
	private String note;
	private float total;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@JsonManagedReference
	private User user;


	@PrePersist
	protected void onCreate() {
		orderDate = LocalDateTime.now();
		status = "shipping";
		shippingFee = 20;
	}

	/*
	 * @Transient public int calTotal() { int sum = 0; List<ProductOrder> pros =
	 * getProductOrder(); for (ProductOrder productOrder : pros) { sum +=
	 * productOrder.getProducts().getPrice() * productOrder.getQuantity(); } return
	 * sum; }
	 */

}
