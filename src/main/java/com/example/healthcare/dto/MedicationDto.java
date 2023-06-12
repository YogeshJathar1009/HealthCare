package com.example.healthcare.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class MedicationDto {
	    private String name;
	    private String dosage;
	    private String instructions;
	    private String schedule;
	    
	    
	    private UserDto user;

}
