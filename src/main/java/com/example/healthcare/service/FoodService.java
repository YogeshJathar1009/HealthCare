package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.FoodDto;

public interface FoodService {
	
FoodDto createFood(FoodDto foodDto);
    
    FoodDto updateFood(FoodDto foodDto);
    
    void deleteFood(Long foodId);
    
    List<FoodDto> getAllFoods();
    
    List<FoodDto> getFoodsByMeal(Long mealId);
    
    List<FoodDto> getFoodsByUser(Long userId);
    
    
    List<FoodDto> getFoodsWithLowCalories();
    
    List<FoodDto> getFoodsWithLowFat();
    
    List<FoodDto> getFoodsWithHighProtein();
    
    List<FoodDto> getFoodsWithHighCarbohydrates();

}
