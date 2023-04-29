package com.finalProject.foodStore.repositories;

import com.finalProject.foodStore.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query(value="select * from news", nativeQuery = true)
    List<News> getAllNews();
}
