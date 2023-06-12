package com.example.healthcare.controller;

import com.example.healthcare.dto.FoodDto;
import com.example.healthcare.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping
    public ResponseEntity<FoodDto> createFood(@RequestBody FoodDto foodDto) {
        FoodDto createdFood = foodService.createFood(foodDto);
        return new ResponseEntity<>(createdFood, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FoodDto> updateFood(@RequestBody FoodDto foodDto) {
        FoodDto updatedFood = foodService.updateFood(foodDto);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAllFoods() {
        List<FoodDto> foods = foodService.getAllFoods();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/meal/{mealId}")
    public ResponseEntity<List<FoodDto>> getFoodsByMeal(@PathVariable Long mealId) {
        List<FoodDto> foods = foodService.getFoodsByMeal(mealId);
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FoodDto>> getFoodsByUser(@PathVariable Long userId) {
        List<FoodDto> foods = foodService.getFoodsByUser(userId);
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/lowCalories")
    public ResponseEntity<List<FoodDto>> getFoodsWithLowCalories() {
        List<FoodDto> foods = foodService.getFoodsWithLowCalories();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/lowFat")
    public ResponseEntity<List<FoodDto>> getFoodsWithLowFat() {
        List<FoodDto> foods = foodService.getFoodsWithLowFat();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/highProtein")
    public ResponseEntity<List<FoodDto>> getFoodsWithHighProtein() {
        List<FoodDto> foods = foodService.getFoodsWithHighProtein();
        return ResponseEntity.ok(foods);
    }

    @GetMapping("/highCarbohydrates")
    public ResponseEntity<List<FoodDto>> getFoodsWithHighCarbohydrates() {
        List<FoodDto> foods = foodService.getFoodsWithHighCarbohydrates();
        return ResponseEntity.ok(foods);
    }
}