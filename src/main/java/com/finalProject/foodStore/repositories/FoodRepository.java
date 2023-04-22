package com.finalProject.foodStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>{

    @Query("select p from food p")
    List<Food> getAllFoods();
}
