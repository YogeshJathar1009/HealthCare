package com.example.healthcare.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class FoodDto {
     private long foodId;
     private long mealId;
	 private String name;
	    private String description;
	    private NutritionInfoDto nutritionInfo; 
	    private MealDto meal;
		
		
}
