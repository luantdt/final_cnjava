package com.finalProject.foodStore.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Food, Integer>{

    List<Food> findByCategoryId(int CategoryId);

    @Query("select p from food p where p.status = 1")
    Page<Food> pageProduct(Pageable pageable);

    @Query("select p from food p where p.description like %?1% or p.name like %?1%")
    Page<Food> searchProducts(String keyword, Pageable pageable);
    @Query("select p from food p where p.status = 1")
    List<Food> getAllProducts();

    @Query(value = "select * from food p where p.status = 1", nativeQuery = true)
    List<Food> getLimitProducts();

    @Query(value = "select * from food p where p.categoryId = ?1 and p.status = 1 limit 3", nativeQuery = true)
    List<Food> getRelatedProducts(Integer categoryId);

    @Query(value = "select * from food p where p.categoryId = ?1", nativeQuery = true)
    List<Food> getProductsInCategory(Integer categoryId);
}
