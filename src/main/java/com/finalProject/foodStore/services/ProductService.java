package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.Food;
import com.finalProject.foodStore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Food> pageProducts(int pageNo){
        Pageable pageable = PageRequest.of(pageNo, 6);
        Page<Food> productPages = productRepository.pageProduct(pageable);
        return productPages;
    }
    public Page<Food> searchProducts(int pageNo, String keyword){
        Pageable pageable = PageRequest.of(pageNo, 6);
        Page<Food> products = productRepository.searchProducts(keyword, pageable);
        return  products;
    }
    
    public List<Food> getAllProducts(){
        return productRepository.getAllProducts();
    }

    public List<Food> getLimitProducts(){ return productRepository.getLimitProducts();}

    public Optional<Food> getProductById(Integer id){
        return productRepository.findById(id);
    }

    public List<Food> getRelatedProducts(Integer categoryId){
        return  productRepository.getRelatedProducts(categoryId);
    }

    public List<Food> getProductsInCategory(Integer categoryId){
        return productRepository.getProductsInCategory(categoryId);
    }
    
    public List<Food> findAll() {
    	return productRepository.findAll();
    }
    
}
