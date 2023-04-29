package com.finalProject.foodStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.finalProject.foodStore.models.News;

public interface NewsRepository extends JpaRepository<News, Integer>{

}
