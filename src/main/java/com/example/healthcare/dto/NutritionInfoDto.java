package com.example.healthcare.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class NutritionInfoDto {
	private long nutritionInfoId;
	private long foodId;
	private double calories;
    private double protein;
    private double carbohydrates;
    private double fat;
    
}
