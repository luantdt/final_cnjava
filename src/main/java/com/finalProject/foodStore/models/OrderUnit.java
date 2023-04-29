package com.finalProject.foodStore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orderunit")
@Table(name = "orderunit")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int foodId;
    private int orderId;
    private int quatity;
    private int unitPrice;

}
