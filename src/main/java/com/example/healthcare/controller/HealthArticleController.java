package com.example.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.healthcare.dto.HealthArticleDto;
import com.example.healthcare.service.HealthArticleService;

@RestController
@RequestMapping("/health-articles")
public class HealthArticleController {

    @Autowired
    private HealthArticleService healthArticleService;

    @GetMapping("/{articleId}")
    public ResponseEntity<HealthArticleDto> getHealthArticleById(@PathVariable Long articleId) {
        HealthArticleDto healthArticleDto = healthArticleService.getHealthArticleById(articleId);
        return new ResponseEntity<>(healthArticleDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HealthArticleDto>> getAllHealthArticles() {
        List<HealthArticleDto> healthArticles = healthArticleService.getAllHealthArticles();
        return new ResponseEntity<>(healthArticles, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HealthArticleDto> createHealthArticle(@RequestBody HealthArticleDto healthArticleDto) {
        HealthArticleDto createdHealthArticle = healthArticleService.createHealthArticle(healthArticleDto);
        return new ResponseEntity<>(createdHealthArticle, HttpStatus.CREATED);
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<HealthArticleDto> updateHealthArticle(@PathVariable Long articleId,
                                                                @RequestBody HealthArticleDto healthArticleDto) {
        HealthArticleDto updatedHealthArticle = healthArticleService.updateHealthArticle(articleId, healthArticleDto);
        return new ResponseEntity<>(updatedHealthArticle, HttpStatus.OK);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<Void> deleteHealthArticle(@PathVariable Long articleId) {
        healthArticleService.deleteHealthArticle(articleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}