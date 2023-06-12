package com.example.healthcare.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class HealthRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recordId;
	private LocalDate date; 
	private int blood_pressure;
	private int heart_rate;
	private  double weight;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
