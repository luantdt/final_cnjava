package com.finalProject.foodStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.Food;

public interface FoodRepository extends JpaRepository<Food, Integer>{
}
