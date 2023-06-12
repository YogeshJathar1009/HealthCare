package com.example.healthcare.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.healthcare.entity.Food;
public interface FoodRepository extends JpaRepository<Food,Long> {

List<Food> findByMeal_Id(Long mealId);
    
List<Food> findByMeal_User_UserId(Long userId);
    List<Food> findByMeal_User_Id(Long userId);
    List<Food> findByNutritionInfo_CaloriesLessThan(double calories);
    List<Food> findByNutritionInfo_FatLessThan(double fat);
    List<Food> findByNutritionInfo_ProteinGreaterThan(double protein);
    List<Food> findByNutritionInfo_CarbohydratesGreaterThan(double carbohydrates);
}
