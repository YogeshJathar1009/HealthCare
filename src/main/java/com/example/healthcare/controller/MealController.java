package com.example.healthcare.controller;

import com.example.healthcare.dto.MealDto;
import com.example.healthcare.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @PostMapping
    public ResponseEntity<MealDto> createMeal(@RequestBody MealDto mealDto) {
        MealDto createdMeal = mealService.createMeal(mealDto);
        return new ResponseEntity<>(createdMeal, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<MealDto> updateMeal(@RequestBody MealDto mealDto) {
        MealDto updatedMeal = mealService.updateMeal(mealDto);
        return ResponseEntity.ok(updatedMeal);
    }

    @DeleteMapping("/{mealId}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long mealId) {
        mealService.deleteMeal(mealId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MealDto>> getAllMeals() {
        List<MealDto> meals = mealService.getAllMeals();
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MealDto>> getMealsByUser(@PathVariable Long userId) {
        List<MealDto> meals = mealService.getMealsByUser(userId);
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/recommended/{userId}")
    public ResponseEntity<List<MealDto>> getRecommendedMealsForUser(@PathVariable Long userId) {
        List<MealDto> meals = mealService.getRecommendedMealsForUser(userId);
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/lowCalories")
    public ResponseEntity<List<MealDto>> getMealsWithLowCalories() {
        List<MealDto> meals = mealService.getMealsWithLowCalories();
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/lowFat")
    public ResponseEntity<List<MealDto>> getMealsWithLowFat() {
        List<MealDto> meals = mealService.getMealsWithLowFat();
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/highProtein")
    public ResponseEntity<List<MealDto>> getMealsWithHighProtein() {
        List<MealDto> meals = mealService.getMealsWithHighProtein();
        return ResponseEntity.ok(meals);
    }

    @GetMapping("/highCarbohydrates")
    public ResponseEntity<List<MealDto>> getMealsWithHighCarbohydrates() {
        List<MealDto> meals = mealService.getMealsWithHighCarbohydrates();
        return ResponseEntity.ok(meals);
    }
}