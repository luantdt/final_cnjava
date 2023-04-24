package com.finalProject.foodStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.FoodRepository;

@Service
public class FoodService {
	@Autowired
	private FoodRepository FRepo;
	
	public void save(Food f) {
		FRepo.save(f);
	}
	
	public List<Food> getAllFood(){
		return FRepo.findAll();
	}
	
	public Food getFoodById(int id) {
		return FRepo.findById(id).get();
	}
	
	public void deleteFoodById(int id) {
		FRepo.deleteById(id);
	}
}
