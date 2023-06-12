package com.example.healthcare.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.healthcare.entity.Meal;
import com.example.healthcare.dto.FoodDto;
import com.example.healthcare.entity.Food;
import com.example.healthcare.repository.FoodRepository;
import com.example.healthcare.repository.MealRepository;
import com.example.healthcare.repository.UserRepository;
import com.example.healthcare.service.FoodService;
@Service
public class FoodServiceImpl implements FoodService {
	 @Autowired
	    private FoodRepository foodRepository;
	    
	    @Autowired
	    private MealRepository mealRepository;
	    
	        
	    @Autowired
	    private ModelMapper modelMapper;
	    
	    @Override
	    public FoodDto createFood(FoodDto foodDto) {
	        Food food = modelMapper.map(foodDto, Food.class);
	        Meal meal = mealRepository.findById(foodDto.getMealId()).orElse(null);
	        if (meal == null) {
	            throw new IllegalArgumentException("Invalid meal ID");
	        }
	        food.setMeal(meal);
	        Food savedFood = foodRepository.save(food);
	        return modelMapper.map(savedFood, FoodDto.class);
	    }

	    @Override
	    public FoodDto updateFood(FoodDto foodDto) {
	        Food existingFood = foodRepository.findById(foodDto.getFoodId()).orElse(null);
	        
	        if (existingFood == null) {
	            // Handle not found error or throw exception
	        }
	        
	        // Update the existingFood with new values from foodDto
	        
	        Food updatedFood = foodRepository.save(existingFood);
	        return modelMapper.map(updatedFood, FoodDto.class);
	    }
	    
	    @Override
	    public void deleteFood(Long foodId) {
	        foodRepository.deleteById(foodId);
	    }
	    
	    @Override
	    public List<FoodDto> getAllFoods() {
	        List<Food> foods = foodRepository.findAll();
	        return foods.stream()
	                .map(food -> modelMapper.map(food, FoodDto.class))
	                .collect(Collectors.toList());
	    }
	    
	    @Override
	    public List<FoodDto> getFoodsByMeal(Long mealId) {
	        List<Food> foods = foodRepository.findByMeal_Id(mealId);
	        return foods.stream()
	                .map(food -> modelMapper.map(food, FoodDto.class))
	                .collect(Collectors.toList());
	    }
	    
	    @Override
	    public List<FoodDto> getFoodsByUser(Long userId) {
	        List<Food> foods = foodRepository.findByMeal_User_Id(userId);
	        return foods.stream()
	                .map(food -> modelMapper.map(food, FoodDto.class))
	                .collect(Collectors.toList());
	    }
	    @Override
	    public List<FoodDto> getFoodsWithLowCalories() {
	        List<Food> foods = foodRepository.findByNutritionInfo_CaloriesLessThan(500);
	        return mapFoodsToDto(foods);
	    }

	    @Override
	    public List<FoodDto> getFoodsWithLowFat() {
	        List<Food> foods = foodRepository.findByNutritionInfo_FatLessThan(10);
	        return mapFoodsToDto(foods);
	    }

	    @Override
	    public List<FoodDto> getFoodsWithHighProtein() {
	        List<Food> foods = foodRepository.findByNutritionInfo_ProteinGreaterThan(30);
	        return mapFoodsToDto(foods);
	    }

	    @Override
	    public List<FoodDto> getFoodsWithHighCarbohydrates() {
	        List<Food> foods = foodRepository.findByNutritionInfo_CarbohydratesGreaterThan(50);
	        return mapFoodsToDto(foods);
	    }

	    private List<FoodDto> mapFoodsToDto(List<Food> foods) {
	        return foods.stream()
	                .map(food -> modelMapper.map(food, FoodDto.class))
	                .collect(Collectors.toList());
	    }
	

}
