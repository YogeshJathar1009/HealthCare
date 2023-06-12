package com.example.healthcare.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
	@Table(name = "foods")
	public class Food {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long foodId;
	    
	    private String name;
	    private String description;
	    // Additional properties such as serving size, food group, etc.
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "nutritionInfoId")
	    private NutritionInfo nutritionInfo;
	    
	    @ManyToOne
	    @JoinColumn(name = "meal_id")
	    private Meal meal;
}
