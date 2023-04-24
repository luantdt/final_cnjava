package com.finalProject.foodStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Food, Integer>{

    @Query("select p from food p where p.status = 1")
    List<Food> getAllProducts();

    @Query(value = "select * from food p where p.status = 1 limit 4", nativeQuery = true)
    List<Food> getLimitProducts();

    @Query(value = "select * from food p where p.categoryId = ?1 limit 3", nativeQuery = true)
    List<Food> getRelatedProducts(Integer categoryId);
}
