package com.example.healthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class HealthArticleDto {
	 private String title;
	    private String content; 
	    private String author;
	    private String imageUrl;
	    private String videoUrl;
	
	    private UserDto user;
}
