package com.finalProject.foodStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
