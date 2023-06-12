package com.example.healthcare.controller;
import com.example.healthcare.dto.NutritionInfoDto;
import com.example.healthcare.service.NutritionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutritionInfo")
public class NutritionInfoController {

    @Autowired
    private NutritionInfoService nutritionInfoService;

    @PostMapping
    public ResponseEntity<NutritionInfoDto> createNutritionInfo(@RequestBody NutritionInfoDto nutritionInfoDto) {
        NutritionInfoDto createdNutritionInfo = nutritionInfoService.createNutritionInfo(nutritionInfoDto);
        return new ResponseEntity<>(createdNutritionInfo, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<NutritionInfoDto> updateNutritionInfo(@RequestBody NutritionInfoDto nutritionInfoDto) {
        NutritionInfoDto updatedNutritionInfo = nutritionInfoService.updateNutritionInfo(nutritionInfoDto);
        return ResponseEntity.ok(updatedNutritionInfo);
    }

    @DeleteMapping("/{nutritionInfoId}")
    public ResponseEntity<Void> deleteNutritionInfo(@PathVariable Long nutritionInfoId) {
        nutritionInfoService.deleteNutritionInfo(nutritionInfoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<NutritionInfoDto>> getAllNutritionInfo() {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getAllNutritionInfo();
        return ResponseEntity.ok(nutritionInfos);
    }

    @GetMapping("/food/{foodId}")
    public ResponseEntity<List<NutritionInfoDto>> getNutritionInfoByFood(@PathVariable Long foodId) {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getNutritionInfoByFood(foodId);
        return ResponseEntity.ok(nutritionInfos);
    }

    @GetMapping("/lowCalories")
    public ResponseEntity<List<NutritionInfoDto>> getNutritionInfoWithLowCalories() {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getNutritionInfoWithLowCalories();
        return ResponseEntity.ok(nutritionInfos);
    }

    @GetMapping("/lowFat")
    public ResponseEntity<List<NutritionInfoDto>> getNutritionInfoWithLowFat() {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getNutritionInfoWithLowFat();
        return ResponseEntity.ok(nutritionInfos);
    }

    @GetMapping("/highProtein")
    public ResponseEntity<List<NutritionInfoDto>> getNutritionInfoWithHighProtein() {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getNutritionInfoWithHighProtein();
        return ResponseEntity.ok(nutritionInfos);
    }

    @GetMapping("/highCarbohydrates")
    public ResponseEntity<List<NutritionInfoDto>> getNutritionInfoWithHighCarbohydrates() {
        List<NutritionInfoDto> nutritionInfos = nutritionInfoService.getNutritionInfoWithHighCarbohydrates();
        return ResponseEntity.ok(nutritionInfos);
    }
}