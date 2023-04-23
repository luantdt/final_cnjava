package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Food> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public Food getProductById(Integer id){
        return productRepository.getById(id);
    }
}
