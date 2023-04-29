package com.finalProject.foodStore.services;

import com.finalProject.foodStore.models.News;
import com.finalProject.foodStore.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews(){
        return newsRepository.getAllNews();
    }
}
