package com.example.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.healthcare.entity.NutritionInfo;

public interface NutritionInfoRepository extends JpaRepository<NutritionInfo,Long>{
	 
	    
	    
	    List<NutritionInfo> findByFood_Id(Long foodId);
	    
	    List<NutritionInfo> findByCaloriesLessThan(double calories);
	    
	    List<NutritionInfo> findByFatLessThan(double fat);
	    
	    List<NutritionInfo> findByProteinGreaterThan(double protein);
	    
	    List<NutritionInfo> findByCarbohydratesGreaterThan(double carbohydrates);
	    
}
