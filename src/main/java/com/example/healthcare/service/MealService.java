package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.MealDto;

public interface MealService {

MealDto createMeal(MealDto mealDto);
    
    MealDto updateMeal(MealDto mealDto);
    
    void deleteMeal(Long mealId);
    
    List<MealDto> getAllMeals();
    
    List<MealDto> getMealsByUser(Long userId);
    
    // Additional methods for older people's functionality
    List<MealDto> getRecommendedMealsForUser(Long userId);
    
    List<MealDto> getMealsWithLowCalories();
    
    List<MealDto> getMealsWithLowFat();
    
    List<MealDto> getMealsWithHighProtein();
    
    List<MealDto> getMealsWithHighCarbohydrates();
}
