package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.NutritionInfoDto;

public interface NutritionInfoService {
NutritionInfoDto createNutritionInfo(NutritionInfoDto nutritionInfoDto);
    
    NutritionInfoDto updateNutritionInfo(NutritionInfoDto nutritionInfoDto);
    
    void deleteNutritionInfo(Long nutritionInfoId);
    
    List<NutritionInfoDto> getAllNutritionInfo();
    
    List<NutritionInfoDto> getNutritionInfoByFood(Long foodId);
    
    
    List<NutritionInfoDto> getNutritionInfoWithLowCalories();
    
    List<NutritionInfoDto> getNutritionInfoWithLowFat();
    
    List<NutritionInfoDto> getNutritionInfoWithHighProtein();
    
    List<NutritionInfoDto> getNutritionInfoWithHighCarbohydrates();
}
