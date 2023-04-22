package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;


    public List<Food> getAllFoods(){
        return foodRepository.getAllFoods();
    }
}
