package com.example.healthcare.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class MealDto {
	private long mealId;
	private String name;
    private LocalDateTime dateTime;
    private long userId;
    
    private List<FoodDto> foods;
    
   
    private UserDto user;
}
