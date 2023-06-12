package com.example.healthcare.service;

import java.util.List;

import com.example.healthcare.dto.ReminderDto;

public interface ReminderService {
ReminderDto createReminder(ReminderDto reminderDto);
    
    ReminderDto updateReminder(ReminderDto reminderDto);
    
    void deleteReminder(Long reminderId);
    
    List<ReminderDto> getRemindersForUser(Long userId);
    
    List<ReminderDto> getRemindersForMedication(Long medicationId);
}
