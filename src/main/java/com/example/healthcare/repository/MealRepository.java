package com.example.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.healthcare.entity.Meal;

public interface MealRepository extends JpaRepository<Meal,Long> {

    
    @Query("SELECT m FROM Meal m WHERE m.user.id = :userId") // Custom query to retrieve recommended meals
    List<Meal> findRecommendedMealsForUser(@Param("userId") Long userId);
    
    List<Meal> findByFoods_NutritionInfo_CarbohydratesGreaterThanAndUser_Id(double carbohydrates, Long userId);
 List<Meal> findByUser_Id(Long userId);
    
    List<Meal> findByFoods_NutritionInfo_CaloriesLessThan(double calories);
    
    List<Meal> findByFoods_NutritionInfo_FatLessThan(double fat);
    
    List<Meal> findByFoods_NutritionInfo_ProteinGreaterThan(double protein);
    
    List<Meal> findByFoods_NutritionInfo_CarbohydratesGreaterThan(double carbohydrates);
    
    
}
