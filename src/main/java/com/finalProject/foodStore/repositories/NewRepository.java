package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewRepository extends JpaRepository<Food, Integer> {


}
