package com.example.healthcare.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class HealthRecordDto {

	private Long recordId;
	private LocalDate date; 
	private int blood_pressure;
	private int heart_rate;
	private  double weight;
	
	private UserDto user;
}
