package com.example.healthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.healthcare.entity.HealthArticle;

public interface HealthArticleRepository extends JpaRepository<HealthArticle,Long>{

}
