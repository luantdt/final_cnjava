package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Food, Integer> {

    @Query("select p from category p ")
    List<Category> getAllCategories();
}
