package com.example.healthcare.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor

public class ReminderDto {

	
    private MedicationDto medication;
    
    
    private UserDto user;
    
    private LocalDateTime reminderTime;
    
    private boolean notificationSent;
}
