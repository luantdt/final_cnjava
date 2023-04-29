package com.finalProject.foodStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finalProject.foodStore.models.About;
import com.finalProject.foodStore.repositories.AboutRepository;

@Service
public class AboutService {
	@Autowired
	private AboutRepository ARepo;
	
	public void save(About a) {
		ARepo.save(a);
	}
	
	public List<About> getAllInfo(){
		return ARepo.findAll();
	}
	
	public About getInfoById(int id) {
		return ARepo.findById(id).get();
	}
	
	public void deleteInfoById(int id) {
		ARepo.deleteById(id);
	}
}
