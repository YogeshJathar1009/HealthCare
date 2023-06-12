package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.HealthArticleDto;
import com.example.healthcare.entity.HealthArticle;
import com.example.healthcare.exception.ResourceNotFoundException;
import com.example.healthcare.repository.HealthArticleRepository;
import com.example.healthcare.service.HealthArticleService;
@Service
public class HealthArticleServiceImpl implements HealthArticleService {

	@Autowired
    private HealthArticleRepository healthArticleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HealthArticleDto getHealthArticleById(Long articleId) {
        HealthArticle healthArticle = healthArticleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Article", "id", articleId));
        return modelMapper.map(healthArticle, HealthArticleDto.class);
    }

    @Override
    public List<HealthArticleDto> getAllHealthArticles() {
        List<HealthArticle> healthArticles = healthArticleRepository.findAll();
        return healthArticles.stream()
                .map(article -> modelMapper.map(article, HealthArticleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public HealthArticleDto createHealthArticle(HealthArticleDto healthArticleDto) {
        HealthArticle healthArticle = modelMapper.map(healthArticleDto, HealthArticle.class);
        HealthArticle savedHealthArticle = healthArticleRepository.save(healthArticle);
        return modelMapper.map(savedHealthArticle, HealthArticleDto.class);
    }

    @Override
    public HealthArticleDto updateHealthArticle(Long articleId, HealthArticleDto healthArticleDto) {
        HealthArticle existingHealthArticle = healthArticleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Article", "id", articleId));

        // Update the existing HealthArticle with the values from the HealthArticleDto
        existingHealthArticle.setTitle(healthArticleDto.getTitle());
        existingHealthArticle.setContent(healthArticleDto.getContent());
        existingHealthArticle.setAuthor(healthArticleDto.getAuthor());
        existingHealthArticle.setImageUrl(healthArticleDto.getImageUrl());
        existingHealthArticle.setVideoUrl(healthArticleDto.getVideoUrl());

        HealthArticle updatedHealthArticle = healthArticleRepository.save(existingHealthArticle);
        return modelMapper.map(updatedHealthArticle, HealthArticleDto.class);
    }

    @Override
    public void deleteHealthArticle(Long articleId) {
        HealthArticle healthArticle = healthArticleRepository.findById(articleId)
                .orElseThrow(() -> new ResourceNotFoundException("Health Article", "id", articleId));
        healthArticleRepository.delete(healthArticle);
    }
}

