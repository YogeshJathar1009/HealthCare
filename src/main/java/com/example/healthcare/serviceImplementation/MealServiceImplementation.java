package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.healthcare.dto.MealDto;
import com.example.healthcare.entity.Meal;
import com.example.healthcare.repository.MealRepository;
import com.example.healthcare.repository.UserRepository;
import com.example.healthcare.service.MealService;
@Service
public class MealServiceImplementation implements MealService{

	 @Autowired
	    private MealRepository mealRepository;
	    
	    @Autowired
	    private UserRepository userRepository;
	    
	    @Autowired
	    private ModelMapper modelMapper;
	    
	    @Override
	    public MealDto createMeal(MealDto mealDto) {
	        Meal meal = modelMapper.map(mealDto, Meal.class);
	        meal.setUser(userRepository.findById(mealDto.getUserId()).orElse(null));
	        Meal savedMeal = mealRepository.save(meal);
	        return modelMapper.map(savedMeal, MealDto.class);
	    }
	    
	    @Override
	    public MealDto updateMeal(MealDto mealDto) {
	        Meal existingMeal = mealRepository.findById(mealDto.getMealId()).orElse(null);
	        if (existingMeal == null) {
	            // Handle not found error or throw exception
	        }
	        
	        // Update the existingMeal with new values from mealDto
	        
	        Meal updatedMeal = mealRepository.save(existingMeal);
	        return modelMapper.map(updatedMeal, MealDto.class);
	    }
	    
	    @Override
	    public void deleteMeal(Long mealId) {
	        mealRepository.deleteById(mealId);
	    }
	    
	    @Override
	    public List<MealDto> getAllMeals() {
	        List<Meal> meals = mealRepository.findAll();
	        return meals.stream()
	                .map(meal -> modelMapper.map(meal, MealDto.class))
	                .collect(Collectors.toList());
	    }
	    
	    @Override
	    public List<MealDto> getMealsByUser(Long userId) {
	        List<Meal> meals = mealRepository.findByUser_Id(userId);
	        return meals.stream()
	                .map(meal -> modelMapper.map(meal, MealDto.class))
	                .collect(Collectors.toList());
	    }
	    @Override
	    public List<MealDto> getRecommendedMealsForUser(Long userId) {
	        // Custom logic to retrieve recommended meals for the user
	        List<Meal> meals = mealRepository.findRecommendedMealsForUser(userId);
	        return mapMealsToDto(meals);
	    }

	    @Override
	    public List<MealDto> getMealsWithLowCalories() {
	        List<Meal> meals = mealRepository.findByFoods_NutritionInfo_CaloriesLessThan(500);
	        return mapMealsToDto(meals);
	    }

	    @Override
	    public List<MealDto> getMealsWithLowFat() {
	        List<Meal> meals = mealRepository.findByFoods_NutritionInfo_FatLessThan(10);
	        return mapMealsToDto(meals);
	    }

	    @Override
	    public List<MealDto> getMealsWithHighProtein() {
	        List<Meal> meals = mealRepository.findByFoods_NutritionInfo_ProteinGreaterThan(30);
	        return mapMealsToDto(meals);
	    }

	    @Override
	    public List<MealDto> getMealsWithHighCarbohydrates() {
	        List<Meal> meals = mealRepository.findByFoods_NutritionInfo_CarbohydratesGreaterThan(50);
	        return mapMealsToDto(meals);
	    }

	    private List<MealDto> mapMealsToDto(List<Meal> meals) {
	        return meals.stream()
	                .map(meal -> modelMapper.map(meal, MealDto.class))
	                .collect(Collectors.toList());
	    }
}
