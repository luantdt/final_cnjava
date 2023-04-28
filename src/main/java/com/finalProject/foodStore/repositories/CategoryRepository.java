package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.dto.CategoryDto;
import com.finalProject.foodStore.models.Category;
import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select p from category p ")
    List<Category> getAllCategories();

    @Query("select new com.finalProject.foodStore.dto.CategoryDto(c.id, c.name) from category c inner  join food p on p.category.id = c.id group by c.id")
    List<CategoryDto> getCategoryAndProduct();


}
