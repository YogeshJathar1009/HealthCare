package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.HealthArticleDto;

public interface HealthArticleService {

HealthArticleDto getHealthArticleById(Long articleId);
    
    List<HealthArticleDto> getAllHealthArticles();
    
    HealthArticleDto createHealthArticle(HealthArticleDto healthArticleDto);
    
    HealthArticleDto updateHealthArticle(Long articleId, HealthArticleDto healthArticleDto);
    
    void deleteHealthArticle(Long articleId);
}
