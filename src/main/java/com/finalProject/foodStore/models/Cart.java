package com.finalProject.foodStore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table
@Entity(name = "cart")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userId;

    private int foodId;

    @NotNull(message = "quantity field cannot be left null")
    @Min(value = 1, message = "quantity must more than one")
    private int quantity;
}
